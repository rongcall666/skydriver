/**
 * 
 */
package com.skydriver.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jrong
 *
 */
public class Filedownload implements Serializable {
	private Integer filedownloadId;
	private File file;
	private Date filedownloadDate;
	private Users userId;
	private Filetype filetypeId;

	/**
	 * @return the filedownloadId
	 */
	public Integer getFiledownloadId() {
		return filedownloadId;
	}

	/**
	 * @param filedownloadId the filedownloadId to set
	 */
	public void setFiledownloadId(Integer filedownloadId) {
		this.filedownloadId = filedownloadId;
	}

	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * @return the filedownloadDate
	 */
	public Date getFiledownloadDate() {
		return filedownloadDate;
	}

	/**
	 * @param filedownloadDate the filedownloadDate to set
	 */
	public void setFiledownloadDate(Date filedownloadDate) {
		this.filedownloadDate = filedownloadDate;
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
	 * @return the filetypeId
	 */
	public Filetype getFiletypeId() {
		return filetypeId;
	}

	/**
	 * @param filetypeId the filetypeId to set
	 */
	public void setFiletypeId(Filetype filetypeId) {
		this.filetypeId = filetypeId;
	}

	/**
	 * 
	 */
	public Filedownload() {
		super();
	}

	/**
	 * @param filedownloadId
	 * @param file
	 * @param filedownloadDate
	 * @param userId
	 * @param filetypeId
	 */
	public Filedownload(Integer filedownloadId, File file, Date filedownloadDate, Users userId, Filetype filetypeId) {
		super();
		this.filedownloadId = filedownloadId;
		this.file = file;
		this.filedownloadDate = filedownloadDate;
		this.userId = userId;
		this.filetypeId = filetypeId;
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
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		result = prime * result + ((filedownloadDate == null) ? 0 : filedownloadDate.hashCode());
		result = prime * result + ((filedownloadId == null) ? 0 : filedownloadId.hashCode());
		result = prime * result + ((filetypeId == null) ? 0 : filetypeId.hashCode());
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
		Filedownload other = (Filedownload) obj;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		if (filedownloadDate == null) {
			if (other.filedownloadDate != null)
				return false;
		} else if (!filedownloadDate.equals(other.filedownloadDate))
			return false;
		if (filedownloadId == null) {
			if (other.filedownloadId != null)
				return false;
		} else if (!filedownloadId.equals(other.filedownloadId))
			return false;
		if (filetypeId == null) {
			if (other.filetypeId != null)
				return false;
		} else if (!filetypeId.equals(other.filetypeId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Filedownload [filedownloadId=" + filedownloadId + ", file=" + file + ", filedownloadDate="
				+ filedownloadDate + ", userId=" + userId + ", filetypeId=" + filetypeId + "]";
	}

}
