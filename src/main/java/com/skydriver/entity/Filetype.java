/**
 * 
 */
package com.skydriver.entity;

import java.io.Serializable;

/**
 * @author jrong
 *
 */
public class Filetype implements Serializable{
	private Integer filetypeId;
	private String filetypeName;
	/**
	 * @param filetypeId
	 * @param filetypeName
	 */
	public Filetype(Integer filetypeId, String filetypeName) {
		super();
		this.filetypeId = filetypeId;
		this.filetypeName = filetypeName;
	}
	/**
	 * 
	 */
	public Filetype() {
		super();
	}
	/**
	 * @return the filetypeId
	 */
	public Integer getFiletypeId() {
		return filetypeId;
	}
	/**
	 * @param filetypeId the filetypeId to set
	 */
	public void setFiletypeId(Integer filetypeId) {
		this.filetypeId = filetypeId;
	}
	/**
	 * @return the filetypeName
	 */
	public String getFiletypeName() {
		return filetypeName;
	}
	/**
	 * @param filetypeName the filetypeName to set
	 */
	public void setFiletypeName(String filetypeName) {
		this.filetypeName = filetypeName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Filetype [filetypeId=" + filetypeId + ", filetypeName=" + filetypeName + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filetypeId == null) ? 0 : filetypeId.hashCode());
		result = prime * result + ((filetypeName == null) ? 0 : filetypeName.hashCode());
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
		Filetype other = (Filetype) obj;
		if (filetypeId == null) {
			if (other.filetypeId != null)
				return false;
		} else if (!filetypeId.equals(other.filetypeId))
			return false;
		if (filetypeName == null) {
			if (other.filetypeName != null)
				return false;
		} else if (!filetypeName.equals(other.filetypeName))
			return false;
		return true;
	}
	
	
}
