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
public class RoleAuthority implements Serializable {
	private Integer id;
	private Roles roldId;
	private List<Authority> authorityId;

	/**
	 * @param id
	 * @param roldId
	 * @param authorityId
	 */
	public RoleAuthority(Integer id, Roles roldId, List<Authority> authorityId) {
		super();
		this.id = id;
		this.roldId = roldId;
		this.authorityId = authorityId;
	}

	/**
	 * 
	 */
	public RoleAuthority() {
		super();
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
	 * @return the roldId
	 */
	public Roles getRoldId() {
		return roldId;
	}

	/**
	 * @param roldId the roldId to set
	 */
	public void setRoldId(Roles roldId) {
		this.roldId = roldId;
	}

	/**
	 * @return the authorityId
	 */
	public List<Authority> getAuthorityId() {
		return authorityId;
	}

	/**
	 * @param authorityId the authorityId to set
	 */
	public void setAuthorityId(List<Authority> authorityId) {
		this.authorityId = authorityId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RoleAuthority [id=" + id + ", roldId=" + roldId + ", authorityId=" + authorityId + "]";
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
		result = prime * result + ((authorityId == null) ? 0 : authorityId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((roldId == null) ? 0 : roldId.hashCode());
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
		RoleAuthority other = (RoleAuthority) obj;
		if (authorityId == null) {
			if (other.authorityId != null)
				return false;
		} else if (!authorityId.equals(other.authorityId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (roldId == null) {
			if (other.roldId != null)
				return false;
		} else if (!roldId.equals(other.roldId))
			return false;
		return true;
	}

}
