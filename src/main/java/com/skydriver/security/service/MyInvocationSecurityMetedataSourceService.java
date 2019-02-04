/**
 * 
 */
package com.skydriver.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aopalliance.intercept.Invocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import com.skydriver.entity.Authority;
import com.skydriver.entity.Roles;
import com.skydriver.mapper.AuthorityMapper;

/**
 * @author jrong
 *
 */
@Service
public class MyInvocationSecurityMetedataSourceService implements SecurityMetadataSource {

	@Autowired
	private AuthorityMapper authorityMapper;

	private Map<String, Collection<ConfigAttribute>> map = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.SecurityMetadataSource#getAttributes(java
	 * .lang.Object)
	 */
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		if (map == null)
			loadResource();
		HttpServletRequest request =  ((FilterInvocation)object).getHttpRequest();
		AntPathRequestMatcher matcher;
		String url;
		for(Iterator<String> iter = map.keySet().iterator();iter.hasNext();) {
			url = iter.next();
			matcher = new AntPathRequestMatcher(url);
			if(matcher.matches(request)) {
				return map.get(url);
			}
		}
		return null;
	}

	/**
	 * 
	 */
	private void loadResource() {
		map = new HashMap<String, Collection<ConfigAttribute>>();
		List<Authority> authorities = authorityMapper.findAll();
		Collection<ConfigAttribute> configAttributes;
		ConfigAttribute cfg;
		for (Authority authority : authorities) {
			if (map.get(authority.getAuthorityUrl()) != null) {
				configAttributes = map.get(authority.getAuthorityUrl());
			} else {
				configAttributes = new HashSet<ConfigAttribute>();
			}
			List<Roles> roles = authorityMapper.findByAuthorityUrl(authority.getAuthorityUrl());
			List<String> list = new ArrayList();
			for(Roles role :roles) {
				list.add(role.getRoleName());
			}
			for(String str:list) {
				cfg = new SecurityConfig(str);
				configAttributes.add(cfg);
			}
			map.put(authority.getAuthorityUrl(), configAttributes);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.access.SecurityMetadataSource#
	 * getAllConfigAttributes()
	 */
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.SecurityMetadataSource#supports(java.lang
	 * .Class)
	 */
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

}
