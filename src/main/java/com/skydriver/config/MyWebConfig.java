/**
 * 
 */
package com.skydriver.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.skydriver.security.service.MyInvocation;
import com.skydriver.security.service.MyUserDetail;

/**
 * @author jrong
 *
 */
@Configuration
@EnableWebSecurity
public class MyWebConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyInvocation invocation;

	@Bean
	public MyUserDetail myUserDetail() {
		return new MyUserDetail();
	}

	@Autowired
	private MySuccessHandle mySuccessHandle;
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.config.
	 * annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/js/**").permitAll().antMatchers("/css/**").permitAll()
				.antMatchers("/image/**").permitAll().antMatchers("/register*").permitAll()
				.antMatchers("/login*").permitAll()
				.antMatchers("/WEB-INF/templates/").permitAll()
				.antMatchers("/insert").permitAll()
				.antMatchers("/isexist")
				.permitAll().anyRequest().authenticated().and().formLogin()
			
				.loginPage("/login.jsp")
				.loginProcessingUrl("/logins")
				.successHandler(mySuccessHandle)
				.failureUrl("/error")
				.permitAll().and().logout().permitAll();

		http.addFilterBefore(invocation, FilterSecurityInterceptor.class).csrf().disable();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.config.
	 * annotation.authentication.builders.AuthenticationManagerBuilder)
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetail()).passwordEncoder(bCryptPasswordEncoder());
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
