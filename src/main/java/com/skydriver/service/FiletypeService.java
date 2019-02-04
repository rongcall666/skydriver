/**
 * 
 */
package com.skydriver.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skydriver.entity.Filetype;
import com.skydriver.entity.FiletypeDetail;
import com.skydriver.mapper.FiletypeDetailMapper;
import com.skydriver.mapper.FiletypeMapper;

/**
 * @author jrong
 *
 */
@Service
public class FiletypeService {
	Map<String, Filetype> map = null;
//	/*
//	static {
//		map.put(".jpg", 1);
//		map.put(".word", 2);
//		map.put(".ppt", 2);map.put(".txt", 2);
//		map.put(".mp3", 3);
//	}
//	public Filetype findFiletype(String suffix) {
//		if(map.get(suffix) != null) {
//			return new Filetype(map.get(suffix), "");
//		}else {
//			return null;
//		}
//	}*/
	@Autowired
	private FiletypeMapper filetypeMapper;
	@Autowired
	private FiletypeDetailMapper filetypeDetailMapper;

	public Filetype findFiletypeByFileName(String fileName) {
		return filetypeMapper.findByFiletypeName(fileName);
	}

	public Filetype findFiletype(String suffix) {
		if (map == null) {
			loadResource();
		}
		System.out.println(map.size());
		if (map.get(suffix) != null) {
			return map.get(suffix);
		} else {
			return null;
		}
	}

	private void loadResource() {
		map = new HashMap<>();
		List<FiletypeDetail> list = filetypeDetailMapper.findAll();
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			map.put(list.get(i).getSuffix(), list.get(i).getFiletype());
		}
	}

}
