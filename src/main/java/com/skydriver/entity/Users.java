/**
 * 
 */
package com.skydriver.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author jrong
 *
 */
public class Users implements Serializable {
	// 主键
	private Integer id;
	// 账号
	private String uid;
	// 密码
	private String password;
	// 用户名
	private String username;
	// 容量
	private Integer capacity;
	// 已使用容量
	private Integer usecapacity;
	// 注册日期
	private Date register;
	private List<Roles> userRoles;

	/**
	 * 
	 */
	public Users() {
		super();
	}

	/**
	 * @param id
	 * @param uid
	 * @param password
	 * @param username
	 * @param capacity
	 * @param usecapacity
	 * @param register
	 */
	public Users(Integer id, String uid, String password, String username, Integer capacity, Integer usecapacity,
			Date register) {
		super();
		this.id = id;
		this.uid = uid;
		this.password = password;
		this.username = username;
		this.capacity = capacity;
		this.usecapacity = usecapacity;
		this.register = register;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the capacity
	 */
	public Integer getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return the usecapacity
	 */
	public Integer getUsecapacity() {
		return usecapacity;
	}

	/**
	 * @param usecapacity the usecapacity to set
	 */
	public void setUsecapacity(Integer usecapacity) {
		this.usecapacity = usecapacity;
	}

	/**
	 * @return the register
	 */
	public Date getRegister() {
		return register;
	}

	/**
	 * @param register the register to set
	 */
	public void setRegister(Date register) {
		this.register = register;
	}

	

	

	/**
	 * @return the userRoles
	 */
	public List<Roles> getUserRoles() {
		return userRoles;
	}

	/**
	 * @param userRoles the userRoles to set
	 */
	public void setUserRoles(List<Roles> userRoles) {
		this.userRoles = userRoles;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Users [id=" + id + ", uid=" + uid + ", password=" + password + ", username=" + username + ", capacity="
				+ capacity + ", usecapacity=" + usecapacity + ", register=" + register + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capacity == null) ? 0 : capacity.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((register == null) ? 0 : register.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		result = prime * result + ((usecapacity == null) ? 0 : usecapacity.hashCode());
		result = prime * result + ((userRoles == null) ? 0 : userRoles.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (capacity == null) {
			if (other.capacity != null)
				return false;
		} else if (!capacity.equals(other.capacity))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (register == null) {
			if (other.register != null)
				return false;
		} else if (!register.equals(other.register))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		if (usecapacity == null) {
			if (other.usecapacity != null)
				return false;
		} else if (!usecapacity.equals(other.usecapacity))
			return false;
		if (userRoles == null) {
			if (other.userRoles != null)
				return false;
		} else if (!userRoles.equals(other.userRoles))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	

}
