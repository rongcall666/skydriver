/**
 * 
 */
package com.skydriver.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.skydriver.entity.Filetype;
import com.skydriver.entity.Fileupload;
import com.skydriver.entity.Users;
import com.skydriver.service.FileRecordService;
import com.skydriver.service.FileService;
import com.skydriver.service.FiletypeService;
import com.skydriver.service.UsersInfoService;

@Controller
public class FileController {

	@Autowired
	private FiletypeService filetypeService;
	@Autowired
	private FileService fileService;
	@Autowired
	private UsersInfoService usersInfoService;
	@Autowired
	private FileRecordService fileRecordService;

	@ResponseBody
	@RequestMapping(value = "getFile", method = RequestMethod.GET)
	public List<com.skydriver.entity.File> getFile(HttpSession session, HttpServletResponse response) {
		if (session.getAttribute("user") == null)
			return null;
		Users user = (Users) session.getAttribute("user");
		List<com.skydriver.entity.File> file = fileService.getFile(user, 0);
		response.setCharacterEncoding("UTF-8");
		return file;
	}

	@ResponseBody
	@RequestMapping(value = "uploadfile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("file") CommonsMultipartFile file, boolean flag, HttpSession session)
			throws IOException {
		if (session.getAttribute("user") == null)
			return "login";

		Users user = (Users) session.getAttribute("user");
		FileOutputStream os = null;
		InputStream in = null;
		if (file == null) {
			return "error1";
		} else {
			File file3 = new File("F:\\skydriver" + "\\" + user.getUid());
			if (!file3.exists()) {
				file3.mkdir();
			}
			String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
			if (filetypeService.findFiletype(suffix) == null)
				return "error2";
			else {
				int fileSize = (int) file.getSize();
				if (user.getCapacity() - user.getUsecapacity() < fileSize) {
					return "updateVip";
				} else {
					com.skydriver.entity.File file2 = new com.skydriver.entity.File();
					String path = file3.getPath() + "\\" + file.getOriginalFilename();
					file2.setFileName(file.getOriginalFilename());
					
					Optional optional = Optional.ofNullable(fileService.findByUsersAndFileName(file2.getFileName(), user.getId()));
					if (((List)optional.get()).size() == 1) {
						return "chongshi";
					}

					file2.setFileSize(fileSize);
					file2.setFilePath(path);
					file2.setParent("\\");
					file2.setFiletypeId(filetypeService.findFiletype(suffix));
					file2.setUserId(user);
					try {
						if (!fileService.fileUpload(file2, user)) {
							return "error";
						}
						
						
						
						
						
						
						os = new FileOutputStream(path);
						in = file.getInputStream();
						int b = 0;
						while ((b = in.read()) != -1) {
							os.write(b);
						}
						os.flush();
					} catch (Exception e) {
						return "success";
					} finally {
						if (in != null) {
							try {
								in.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if (os != null) {
							try {
								os.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}

			return "success";
		}
	}

	@ResponseBody
	@RequestMapping(value = "getFileByType", method = RequestMethod.GET)
	public List<com.skydriver.entity.File> getWord(HttpSession session, String filetypeId) {
		if (session.getAttribute("user") == null)
			return null;
		Users user = (Users) session.getAttribute("user");
		Filetype filetype = new Filetype();
		filetype.setFiletypeId(Integer.valueOf(filetypeId));
		List<com.skydriver.entity.File> files = fileService.getFileType(user, filetype);
		return files;
	}

	@RequestMapping(value = "filedownload", method = RequestMethod.GET)
	public void fileDownload(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			String fileId) throws IOException {
		if (session.getAttribute("user") == null)
			return;
		Users user = (Users) session.getAttribute("user");
		String path = "F:\\skydriver\\" + user.getUid();
		File file3 = new File(path);
		if (!file3.exists()) {
			file3.mkdir();
			return;
		} else {
			if (fileService.fildFileName(Integer.valueOf(fileId)) == null) {
				return;
			}
			com.skydriver.entity.File file = fileService.fildFileName(Integer.valueOf(fileId));
			
			
			response.setContentType("text/html;charset=utf-8");
			java.io.BufferedInputStream bis = null;
			java.io.BufferedOutputStream bos = null;

			try {
				if (!fileService.fileDownload(file)) {
					return;
				}
				response.setContentType("application/x-msdownload;");
				response.setHeader("Content-disposition",
						"attachment; filename=" + new String(file.getFileName().getBytes("utf-8"), "ISO8859-1"));
				response.setHeader("Content-Length", String.valueOf(file.getFileSize()));
				
				bis = new BufferedInputStream(new FileInputStream(path + "\\" + file.getFileName()));
				bos = new BufferedOutputStream(response.getOutputStream());
				byte[] buff = new byte[2048];
				int bytesRead;
				while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
					bos.write(buff, 0, bytesRead);
				}
				bis.close();
				bos.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (bis != null)
					try {
						bis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				if (bos != null)
					try {
						bos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}
	}

	@ResponseBody
	@RequestMapping(value = "deleteFile", method = RequestMethod.GET)
	public String deleteFile(String fileId, HttpSession session) {
		Users user = (Users) session.getAttribute("user");

		if (user == null) {
			return "login";
		}
		Integer fileid = Integer.valueOf(fileId);
		com.skydriver.entity.File file = fileService.getFile(fileid);
		if (file.getUserId().getId() != user.getId()) {
			return "error";
		} else {
			fileRecordService.deletedownloadFileId(fileid);
			fileRecordService.deleteuploadFileId(fileid);
			boolean flag = fileService.deleteFile(fileid);
			if (flag) {
				user.setUsecapacity(user.getUsecapacity() - file.getFileSize());
				usersInfoService.updateUsecapacity(user);
				return "success";
			} else {
				return "error";
			}
		}
	}

}
