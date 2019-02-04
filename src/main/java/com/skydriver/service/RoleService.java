/**
 * 
 */
package com.skydriver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skydriver.entity.Roles;
import com.skydriver.entity.Users;
import com.skydriver.mapper.RolesMapper;
import com.skydriver.mapper.UserRoleMapper;

/**
 * @author jrong
 *
 */
@Service
public class RoleService {
	
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	@Autowired
	private RolesMapper rolesMapper;
	
	
	
	public boolean register(Users users) {
		List<Roles> role = rolesMapper.findByRoleName("ADMIN_USER");
		userRoleMapper.add(users, role.get(0));
		return true;
	}
	
	
	
	
	
	
	
	
}
