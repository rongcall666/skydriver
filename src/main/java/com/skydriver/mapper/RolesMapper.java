/**
 * 
 */
package com.skydriver.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.skydriver.entity.Roles;

/**
 * @author jrong
 *	½ÇÉ«¹ÜÀí
 */
@Repository
public interface RolesMapper {
	List<Roles> findAll();

	void delete(Integer roleId);

	void add(Roles role);

	List<Roles> findByRoleName(@Param("roleName")String roleName);

	void update(Roles Roles);
}
