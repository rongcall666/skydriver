/**
 * 
 */
package com.skydriver.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.skydriver.entity.FiletypeDetail;

/**
 * @author jrong
 *
 */
public interface FiletypeDetailMapper {
	void addFiletypeDateil(FiletypeDetail filetypeDetail);
	
	void updateSuffix(FiletypeDetail filetypeDetail);
	
	void deleteSuffix(@Param("detailId")Integer detailId);
	
	List<FiletypeDetail> findAll();
	
	List<FiletypeDetail> findByFiletype(@Param("filetypeId")Integer filetypeId);
	
}
