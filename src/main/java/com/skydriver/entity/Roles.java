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
public class Roles implements Serializable{
	private Integer roleId;
	private String roleName;
	private List<RoleAuthority> roleAuthoritys;	
	/**
	 * 
	 */
	public Roles() {
		super();
	}
	/**
	 * @param roleId
	 * @param roleName
	 */
	public Roles(Integer roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return the roleAuthoritys
	 */
	public List<RoleAuthority> getRoleAuthoritys() {
		return roleAuthoritys;
	}
	/**
	 * @param roleAuthoritys the roleAuthoritys to set
	 */
	public void setRoleAuthoritys(List<RoleAuthority> roleAuthoritys) {
		this.roleAuthoritys = roleAuthoritys;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Roles [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
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
		Roles other = (Roles) obj;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		return true;
	}
	
}
