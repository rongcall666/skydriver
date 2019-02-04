/**
 * 
 */
package com.skydriver.security.service;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

/**
 * @author jrong
 *
 */
@Service
public class MyAccessManager implements AccessDecisionManager {

	/* (non-Javadoc)
	 * @see org.springframework.security.access.AccessDecisionManager#decide(org.springframework.security.core.Authentication, java.lang.Object, java.util.Collection)
	 */
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if(null == configAttributes || configAttributes.size() <= 0) {
			return;
		}
		ConfigAttribute cfg;
		String needRole;
		for(Iterator<ConfigAttribute> iter=configAttributes.iterator();iter.hasNext();) {
			cfg = iter.next();
			needRole = cfg.getAttribute();
			
			for(GrantedAuthority ga:authentication.getAuthorities()) {
				if(needRole.trim().equals(ga.getAuthority())) {
					return;
				}
			}
		}
		throw new AccessDeniedException("no right");
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.access.AccessDecisionManager#supports(org.springframework.security.access.ConfigAttribute)
	 */
	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.access.AccessDecisionManager#supports(java.lang.Class)
	 */
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

}	
