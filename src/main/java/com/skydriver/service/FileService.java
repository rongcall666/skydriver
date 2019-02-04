/**
 * 
 */
package com.skydriver.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skydriver.entity.File;
import com.skydriver.entity.Filedownload;
import com.skydriver.entity.Filetype;
import com.skydriver.entity.Fileupload;
import com.skydriver.entity.Users;
import com.skydriver.mapper.FileMapper;
import com.skydriver.mapper.FiledownloadMapper;
import com.skydriver.mapper.FileuploadMapper;

/**
 * @author jrong
 *
 */
@Service
public class FileService {
	@Autowired
	private FileMapper fileMapper;
	@Autowired
	private FileuploadMapper fileuploadMapper;
	@Autowired
	private FiledownloadMapper filedownloadMapper;
	@Autowired
	private UsersInfoService usersInfoService;
	@Transactional
	public boolean fileUpload(com.skydriver.entity.File file,Users user) {
		Fileupload fileupload = new Fileupload();
	
		fileupload.setFiletypeId(file.getFiletypeId());
		fileupload.setUserId(file.getUserId());
		fileupload.setUploadDate(new Date());
		user.setUsecapacity(user.getUsecapacity() + file.getFileSize());
		try {
			usersInfoService.updateUsecapacity(user);
			fileMapper.add(file);
			
			List<File> file2 = fileMapper.findByUsersAndFileName(user.getId(), file.getFileName());
			
			fileupload.setFile(file2.get(0));
			
			
			
			
			fileuploadMapper.add(fileupload);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean fileDownload(com.skydriver.entity.File file) {
		Filedownload filedownload = new Filedownload();
		filedownload.setFile(file);
		filedownload.setFiledownloadDate( new Date());
		filedownload.setFiletypeId(file.getFiletypeId());
		filedownload.setUserId(file.getUserId());
		try {
			filedownloadMapper.add(filedownload);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public List<File> getFile(Users user,Integer page){
		List<File> list = fileMapper.findByUsers(user.getId());
		return list;
	}
	public File getFile(Integer fileId){
		File list = fileMapper.findByFileID(fileId);
		return list;
	}
	public List<File> getFileType(Users user,Filetype filetypeId){
		List<File> list = fileMapper.findByFiletypeId(user.getId(), filetypeId.getFiletypeId());
		return list;
	}
	
	public List<File> findByUsersAndFileName(String fileName,Integer userId) {
		return fileMapper.findByUsersAndFileName(userId, fileName);
	}
	public com.skydriver.entity.File fildFileName(Integer fileId) {
		return fileMapper.findByFileID(fileId);
	}
	public boolean deleteFile(Integer fileId) {
		try {
			
			
			
			fileMapper.delete(fileId);
			
			
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
