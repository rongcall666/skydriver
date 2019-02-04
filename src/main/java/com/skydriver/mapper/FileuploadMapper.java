/**
 * 
 */
package com.skydriver.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;

import com.skydriver.entity.Fileupload;
import com.skydriver.entity.Users;

/**
 * @author jrong 文件上传记录管理
 */
public interface FileuploadMapper {
	void add(Fileupload fileupload);

	List<Fileupload> findByUser(@Param("userId")Integer userId);

	List<Fileupload> findByFileName(@Param(value = "uploadFilename") String uploadFilename,
			@Param(value = "userid") Integer userid);

	List<Fileupload> findByUploadTime(@Param(value = "uploadTime") Date uploadTime,
			@Param(value = "userid") Integer userId);

	void delete(Integer fileuploadId);
	
	void deleteByfileId(@Param("fileId")Integer fileId);
	
	void deleteAll(@Param("userId")Integer userId);
	
	Fileupload findByFileuploadId(Integer fileuploadId);
	
}
