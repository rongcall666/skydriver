/**
 * 
 */
package com.skydriver.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skydriver.entity.Filedownload;
import com.skydriver.entity.Fileupload;
import com.skydriver.entity.Users;
import com.skydriver.service.FileRecordService;

@Controller
public class FileRecordController {

	@Autowired
	private FileRecordService fileRecordService;
	
	@ResponseBody
	@RequestMapping(value="/getFileupload",method=RequestMethod.POST)
	public List<Fileupload> getFileupload(HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		return fileRecordService.getFileupload(user.getId());
	}
	@ResponseBody
	@RequestMapping(value="/getFiledownload",method=RequestMethod.POST)
	public List<Filedownload> getFiledownload(HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		return fileRecordService.getFiledownload(user.getId());
	}
	@ResponseBody
	@RequestMapping(value="/deleteFileupload",method=RequestMethod.GET)
	public String deleteFileupload(Integer fileuploadId,HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		if(user == null) 
			return "login";
		fileRecordService.deleteFileupload(fileuploadId);
		return "success";
	}
	@ResponseBody
	@RequestMapping(value="/deleteFileuploadAll",method=RequestMethod.POST)
	public String deleteFileuploadAll(HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		if(user == null) 
			return "login";
		fileRecordService.deleteFileuploadAll(user.getId());
		return "success";
	}
	@ResponseBody
	@RequestMapping(value="/deleteFiledownload",method=RequestMethod.GET)
	public String deleteFiledownload(Integer filedownloadId,HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		if(user == null) 
			return "login";
		fileRecordService.deleteFiledownload(filedownloadId);
		return "success";

	}
	@ResponseBody
	@RequestMapping(value="/deleteFiledownloadAll",method=RequestMethod.POST)
	public String deleteFiledownloadAll(HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		if(user == null) 
			return "login";
		fileRecordService.deleteFiledownloadAll(user.getId());
		return "success";
	}
}
