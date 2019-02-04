/**
 * 
 */
package com.skydriver.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.skydriver.entity.Users;
import com.skydriver.mapper.RolesMapper;
import com.skydriver.service.UsersInfoService;

/**
 * @author jrong
 *
 */
@Controller
public class UsersInfoController {
	@Autowired
	private UsersInfoService usersInfoService;


	
	
	/**
	 * 登录
	 * 
	 * @param user
	 * @return
	 */
//	@ResponseBody
	@RequestMapping(value = "/logins", method = RequestMethod.POST)
	public String login(Users users, HttpSession session) {
		System.out.println("用户信息" + users);
		Optional<Users> optional = usersInfoService.login(users.getUid(), users.getPassword());
		if (optional.isPresent()) {
			users = optional.get();
			session.setAttribute("user", users);
			return "home";
		}
		return "error";
	}

	@ResponseBody
	@RequestMapping(value = "getUsers", method = RequestMethod.GET)
	public Users getUser(HttpSession session, HttpServletResponse response) {
		if (session.getAttribute("user") == null)
			return null;
		response.setCharacterEncoding("UTF-8");
		return (Users) session.getAttribute("user");
	}

	/**
	 * 注册
	 * 
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Users users) {
		if (true == usersInfoService.register(users)) {
			
			return "true";
		}
		return "false";
	}

	/**
	 * 用户名是否存在
	 * 
	 * @param uid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/isexist", method = RequestMethod.GET)
	public String isexist(String uid) {
		return String.valueOf(usersInfoService.isexist(uid));
	}

	/**
	 * 修改密码
	 * 
	 * @param users
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public String updatePassword(String oldPassword, String newPassword, HttpSession session) {
		if (session.getAttribute("user") == null)
			return null;
		Users users = (Users) session.getAttribute("user");
		if (!users.getPassword().equals(oldPassword)) {
			return "error";
		}
		users.setPassword(newPassword);
		String flag = String.valueOf(usersInfoService.updatePassword(users));
		session.setAttribute("user", null);
		return flag;
	}

	/**
	 * 修改用户名
	 * 
	 * @param users
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateUsername", method = RequestMethod.POST)
	public String updateUsername(HttpSession session,String username) {
		if (session.getAttribute("user") == null)
			return null;
		Users users = (Users) session.getAttribute("user");
		users.setUsername(username);
		String flag = String.valueOf(usersInfoService.updateUsername(users));
		session.setAttribute("user", users);
		return flag;
	}
	
	
	
	
	
	@RequestMapping(value = "/admin")
	public String success(HttpSession session) {
		if (session.getAttribute("user") == null)
			return null;
		Users users = (Users) session.getAttribute("user");
		System.out.println(users);
		return "success";
	}

	@ModelAttribute
	public Users users() {
		return new Users();
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	@RequestMapping("/error")
	public String error() {
		return "error";
	}
}
