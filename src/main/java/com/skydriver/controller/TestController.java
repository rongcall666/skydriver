/**
 * 
 */
package com.skydriver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skydriver.mapper.TestMapper;

/**
 * @author jrong
 *
 */
@Controller
public class TestController {
	
	@Autowired
	private TestMapper testMapper;
	
	@ResponseBody
	@RequestMapping("/insert")
	public String insertA() {
		for(int i = 0;i < 10000;i++) {
			testMapper.insertA(i, "a" + i);
			testMapper.insertB(i, "b" + i);
		}
		return "success";
	}
}
