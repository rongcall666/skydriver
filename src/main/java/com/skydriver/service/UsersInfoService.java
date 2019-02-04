/**
 * 
 */
package com.skydriver.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skydriver.entity.Roles;
import com.skydriver.entity.Users;
import com.skydriver.mapper.RolesMapper;
import com.skydriver.mapper.UserRoleMapper;
import com.skydriver.mapper.UsersMapper;

/**
 * @author jrong 
 * 	用户信息
 */
@Service
public class UsersInfoService {

	@Autowired
	private UsersMapper usersMapper;
	@Autowired
	private RoleService roleService;
	/**
	 * 登录
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	public Optional<Users> login(String userId, String password) {
		Optional<Users> optional = Optional.ofNullable(usersMapper.findByUserIdAndPassword(userId, password));
		return optional;
	}
	
	public void updateUsecapacity(Users user) {
		usersMapper.updateUsecapacity(user.getId(), user.getUsecapacity());
	}
	
	/**
	 * 注册
	 * 
	 * @param users
	 * @return
	 */
	@Transactional
	public boolean register(Users users) {
		Date date = new Date();
		users.setRegister(date);
		Roles role = new Roles();
		role.setRoleId(1);
		try {
			usersMapper.add(users);

			Users users2 = usersMapper.findByUserId(users.getUid());
			roleService.register(users2);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	/**
	 * 用户名是否存在
	 * @param uid
	 * @return
	 */
	public Integer isexist(String uid) {
		return usersMapper.isexist(uid);
	}
	/**
	 * 修改用户名
	 * 
	 * @param users
	 * @return
	 */
	@Transactional
	public boolean updateUsername(Users users) {
		try {
			usersMapper.updateUsername(users.getUid(), users.getUsername());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 修改密码
	 * @param users
	 * @return
	 */
	@Transactional
	public boolean updatePassword(Users users) {
		try {
			usersMapper.updatePassword(users.getUid(), users.getPassword());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
