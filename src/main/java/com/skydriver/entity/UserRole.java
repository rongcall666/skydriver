/**
 * 
 */
package com.skydriver.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author jrong
 *
 */
public class UserRole implements Serializable {

	private Integer urId;
	private Users userId;
	private Roles roleId;

	/**
	 * 
	 */
	public UserRole() {
		super();
	}
	
	/**
	 * @param urId
	 * @param userId
	 * @param roleId
	 */
	public UserRole(Integer urId, Users userId, Roles roleId) {
		super();
		this.urId = urId;
		this.userId = userId;
		this.roleId = roleId;
	}

	/**
	 * @return the urId
	 */
	public Integer getUrId() {
		return urId;
	}

	/**
	 * @param urId the urId to set
	 */
	public void setUrId(Integer urId) {
		this.urId = urId;
	}

	/**
	 * @return the userId
	 */
	public Users getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Users userId) {
		this.userId = userId;
	}

	/**
	 * @return the roleId
	 */
	public Roles getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Roles roleId) {
		this.roleId = roleId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserRole [urId=" + urId + ", userId=" + userId + ", roleId=" + roleId + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((urId == null) ? 0 : urId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		UserRole other = (UserRole) obj;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (urId == null) {
			if (other.urId != null)
				return false;
		} else if (!urId.equals(other.urId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
