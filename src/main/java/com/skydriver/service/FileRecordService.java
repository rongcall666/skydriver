/**
 * 
 */
package com.skydriver.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skydriver.entity.File;
import com.skydriver.entity.Filedownload;
import com.skydriver.entity.Fileupload;
import com.skydriver.entity.Users;
import com.skydriver.mapper.FiledownloadMapper;
import com.skydriver.mapper.FileuploadMapper;

/**
 * @author jrong
 *
 */
@Service
public class FileRecordService {

	@Autowired
	private FileuploadMapper fileuploadMapper;
	@Autowired
	private FiledownloadMapper filedownloadMapper;

	
	public void addFileupload(File file,Users users) {
		Fileupload fileupload = new Fileupload();
		fileupload.setFile(file);
		fileupload.setUserId(users);
		fileupload.setUploadDate(new Date());
		fileuploadMapper.add(fileupload);
	}
	
	public void addFiledownload(File file,Users users) {
		Filedownload filedownload = new Filedownload();
		filedownload.setFile(file);
		filedownload.setUserId(users);
		filedownload.setFiledownloadDate(new Date());
		filedownloadMapper.add(filedownload);
	}
	
	
	public List<Fileupload> getFileupload(Integer id) {
		return fileuploadMapper.findByUser(id);
	}

	public List<Filedownload> getFiledownload(Integer id) {
		return filedownloadMapper.findByUser(id);
	}

	public void deleteuploadFileId(Integer fileId) {
		fileuploadMapper.deleteByfileId(fileId);
	}
	
	public void deletedownloadFileId(Integer fileId) {
		filedownloadMapper.deleteByfileId(fileId);
	}
	
	public void deleteFileupload(Integer fileuploadId) {
		fileuploadMapper.delete(fileuploadId);
	}
	public void deleteFileuploadAll(Integer id) {
		fileuploadMapper.deleteAll(id);
	}
	public void deleteFiledownload(Integer filedownloadId) {
		filedownloadMapper.delete(filedownloadId);
	}
	public void deleteFiledownloadAll(Integer id) {
		filedownloadMapper.delete(id);
	}
}
