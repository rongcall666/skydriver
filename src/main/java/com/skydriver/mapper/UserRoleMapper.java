/**
 * 
 */
package com.skydriver.mapper;

import org.apache.ibatis.annotations.Param;
import com.skydriver.entity.Roles;
import com.skydriver.entity.Users;

/**
 * @author jrong
 *
 */
public interface UserRoleMapper {

	void add(@Param("user")Users user,@Param("role")Roles roles);
	
}
