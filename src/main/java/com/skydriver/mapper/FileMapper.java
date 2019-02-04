/**
 * 
 */
package com.skydriver.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.skydriver.entity.File;

/**
 * @author jrong
 *	文件管理
 */
public interface FileMapper {
	List<File> findByParent(String parent);

	List<File> findByUsersAndParent(@Param("userId")Integer userId,@Param("parent")String parent);

	List<File> findByUsersAndFileName(@Param("userId")Integer userId,@Param("fileName")String fileName);

	File findByFileID(@Param("fileId")Integer fileId);
	
	List<File> findByUsers(@Param("userId")Integer userId);
	
	void add(File file);

	void updateFileName(@Param("fileId")Integer fileId,@Param("fileName") String flleName);

	void delete(Integer fileId);

	List<File> findByFiletypeId(@Param("userId")Integer userId,@Param("filetypeId")Integer filetypeId);
}
