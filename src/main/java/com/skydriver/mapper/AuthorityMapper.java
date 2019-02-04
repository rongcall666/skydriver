/**
 * 
 */
package com.skydriver.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.skydriver.entity.Authority;
import com.skydriver.entity.Roles;

/**
 * @author jrong
 *	权限管理
 */
@Repository
public interface AuthorityMapper {
	List<Authority> findAll();

	List<Roles> findAllRole();
	
	void delete(Integer authorityId);

	void add(Authority authority);

	List<Roles> findByAuthorityUrl(String authorityUrl);

	void update(Authority authority);
}
