/**
 * 
 */
package com.skydriver.entity;

import java.io.Serializable;

/**
 * @author jrong
 *
 */
public class Authority implements Serializable {
	private Integer authorityId;
	private String authorityDetail;
	private String authorityUrl;

	/**
	 * 
	 */
	public Authority() {
		super();
	}

	/**
	 * @param authorityId
	 * @param authorityDetail
	 * @param authorityUrl
	 */
	public Authority(Integer authorityId, String authorityDetail, String authorityUrl) {
		super();
		this.authorityId = authorityId;
		this.authorityDetail = authorityDetail;
		this.authorityUrl = authorityUrl;
	}

	/**
	 * @return the authorityId
	 */
	public Integer getAuthorityId() {
		return authorityId;
	}

	/**
	 * @param authorityId the authorityId to set
	 */
	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	/**
	 * @return the authorityDetail
	 */
	public String getAuthorityDetail() {
		return authorityDetail;
	}

	/**
	 * @param authorityDetail the authorityDetail to set
	 */
	public void setAuthorityDetail(String authorityDetail) {
		this.authorityDetail = authorityDetail;
	}

	/**
	 * @return the authorityUrl
	 */
	public String getAuthorityUrl() {
		return authorityUrl;
	}

	/**
	 * @param authorityUrl the authorityUrl to set
	 */
	public void setAuthorityUrl(String authorityUrl) {
		this.authorityUrl = authorityUrl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Authority [authorityId=" + authorityId + ", authorityDetail=" + authorityDetail + ", authorityUrl="
				+ authorityUrl + "]";
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
		result = prime * result + ((authorityDetail == null) ? 0 : authorityDetail.hashCode());
		result = prime * result + ((authorityId == null) ? 0 : authorityId.hashCode());
		result = prime * result + ((authorityUrl == null) ? 0 : authorityUrl.hashCode());
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
		Authority other = (Authority) obj;
		if (authorityDetail == null) {
			if (other.authorityDetail != null)
				return false;
		} else if (!authorityDetail.equals(other.authorityDetail))
			return false;
		if (authorityId == null) {
			if (other.authorityId != null)
				return false;
		} else if (!authorityId.equals(other.authorityId))
			return false;
		if (authorityUrl == null) {
			if (other.authorityUrl != null)
				return false;
		} else if (!authorityUrl.equals(other.authorityUrl))
			return false;
		return true;
	}

}
