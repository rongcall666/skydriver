/**
 * 
 */
package com.skydriver.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.skydriver.entity.Roles;
import com.skydriver.entity.Users;
import com.skydriver.mapper.UsersMapper;

/**
 * @author jrong
 *
 */
@Service
public class MyUserDetail implements UserDetailsService {

	@Autowired
	private UsersMapper usersMapper;

	

	@Autowired
	private BCryptPasswordEncoder encoder;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (0 == usersMapper.isexist(username)) {
			throw new UsernameNotFoundException("用户名不存在");
		} else {
			Users user = usersMapper.findByUserId(username);
			List<Roles> roles = usersMapper.findRoleByUserId(user.getId());
			List<GrantedAuthority> authorities = new ArrayList();
			for (Roles role : roles) {
				authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
			}
			return new User(user.getUid(),encoder.encode(user.getPassword()) , authorities);
		}
	}

}
