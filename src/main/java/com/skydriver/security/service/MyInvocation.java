/**
 * 
 */
package com.skydriver.security.service;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.aopalliance.intercept.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Service;

/**
 * @author jrong
 *
 */
@Service
public class MyInvocation extends AbstractSecurityInterceptor
	implements Filter{

	@Autowired
	private MyInvocationSecurityMetedataSourceService myInvocationSecurityMetedataSourceService;
	
	
	/* (non-Javadoc)
	 * @see org.springframework.security.access.intercept.AbstractSecurityInterceptor#setAccessDecisionManager(org.springframework.security.access.AccessDecisionManager)
	 */
	@Autowired
	public void setAccessDecisionManager(MyAccessManager accessDecisionManager) {
		super.setAccessDecisionManager(accessDecisionManager);
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		FilterInvocation filterInvocation = new FilterInvocation(request, response, chain);
		invoke(filterInvocation);
	}

	/**
	 * @param filterInvocation
	 */
	private void invoke(FilterInvocation filterInvocation) {
		InterceptorStatusToken token = super.beforeInvocation(filterInvocation);
		
		try {
			filterInvocation.getChain().doFilter(filterInvocation.getRequest(), filterInvocation.getHttpResponse());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			super.afterInvocation(token, null);
		}
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.access.intercept.AbstractSecurityInterceptor#getSecureObjectClass()
	 */
	public Class<?> getSecureObjectClass() {
		// TODO Auto-generated method stub
		return FilterInvocation.class;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.access.intercept.AbstractSecurityInterceptor#obtainSecurityMetadataSource()
	 */
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.myInvocationSecurityMetedataSourceService;
	}

	


}
