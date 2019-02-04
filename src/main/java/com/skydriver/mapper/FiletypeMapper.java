/**
 * 
 */
package com.skydriver.mapper;

import java.util.List;

import com.skydriver.entity.Filetype;

/**
 * @author jrong
 *	�ļ����͹���
 */
public interface FiletypeMapper {
	List<Filetype> findAll();

	void add(Filetype filetype);

	void delete(Integer filetypeId);

	void update(Filetype filetype);

	Filetype findByFiletypeName(String filetypeName);
}
