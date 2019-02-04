/**
 * 
 */
package com.skydriver.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PatchMapping;

import com.skydriver.entity.Authority;
import com.skydriver.entity.Roles;
import com.skydriver.entity.Users;

/**
 * @author jrong
 *	用户管理
 */
@Repository
public interface UsersMapper {
	Users findByUserIdAndPassword(@Param(value="uid")String uid,@Param(value="password") String password);

	List<Roles> findRoleByUserId(Integer id);

	void updatePassword(@Param(value="uid")String uid, @Param(value="password")String password);

	void updateUsername(@Param(value="uid")String uid, @Param(value="username")String username);

	void updateUsecapacity(@Param(value="id")Integer id,@Param(value="usecapacity")Integer usecapacity);
	
	void delete(Integer id);

	void add(Users users);

	Users findByUserId(String uid);

	Integer isexist(String uid);

	List<Users> findAll();
	
}
