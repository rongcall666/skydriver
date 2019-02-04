/**
 * 
 */
package com.skydriver.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Service;

import com.skydriver.entity.Users;
import com.skydriver.mapper.UsersMapper;

/**
 * @author jrong
 *
 */
@Service
public class MySuccessHandle implements AuthenticationSuccessHandler {

	@Autowired
	private UsersMapper usersMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.web.authentication.
	 * SavedRequestAwareAuthenticationSuccessHandler#onAuthenticationSuccess(javax.
	 * servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * org.springframework.security.core.Authentication)
	 */
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		Users user = usersMapper.findByUserId(userDetails.getUsername());
		request.getSession().setAttribute("user", user);
        request.getRequestDispatcher("/home.jsp").forward(request, response);
	}
}
