/**
 * 
 */
package com.skydriver.mapper;

import java.util.List;

import com.skydriver.entity.Filetype;

/**
 * @author jrong
 *	文件类型管理
 */
public interface FiletypeMapper {
	List<Filetype> findAll();

	void add(Filetype filetype);

	void delete(Integer filetypeId);

	void update(Filetype filetype);

	Filetype findByFiletypeName(String filetypeName);
}
