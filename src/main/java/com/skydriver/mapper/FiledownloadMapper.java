/**
 * 
 */
package com.skydriver.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.skydriver.entity.Filedownload;
import com.skydriver.entity.Fileupload;
import com.skydriver.entity.Users;

/**
 * @author jrong
 *	文件下载记录管理
 */
public interface FiledownloadMapper {
	void add(Filedownload filedownload);

	List<Filedownload> findByUser(@Param("userId")Integer userId);

	List<Filedownload> findByFileName(@Param("filedownloadFilename")String filedownloadFilename, @Param("userId")Integer userId);

//	List<Filedownload> findByDownloadTime(Date filedownloadDate, Integer userId);

	void delete(Integer filedownloadId);

	void deleteByfileId(@Param("fileId")Integer fileId);
	
	void deleteAll(@Param("userId")Integer userId);
}
