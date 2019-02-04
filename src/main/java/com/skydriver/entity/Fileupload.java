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
public class Fileupload implements Serializable{
	private Integer fileuploadId;
	private File file;
	private Date uploadDate;
	private Users userId;
	private Filetype filetypeId;
	/**
	 * @return the fileuploadId
	 */
	public Integer getFileuploadId() {
		return fileuploadId;
	}
	/**
	 * @param fileuploadId the fileuploadId to set
	 */
	public void setFileuploadId(Integer fileuploadId) {
		this.fileuploadId = fileuploadId;
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
	 * @return the uploadDate
	 */
	public Date getUploadDate() {
		return uploadDate;
	}
	/**
	 * @param uploadDate the uploadDate to set
	 */
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
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
	 * @param fileuploadId
	 * @param file
	 * @param uploadDate
	 * @param userId
	 * @param filetypeId
	 */
	public Fileupload(Integer fileuploadId, File file, Date uploadDate, Users userId, Filetype filetypeId) {
		super();
		this.fileuploadId = fileuploadId;
		this.file = file;
		this.uploadDate = uploadDate;
		this.userId = userId;
		this.filetypeId = filetypeId;
	}
	/**
	 * 
	 */
	public Fileupload() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Fileupload [fileuploadId=" + fileuploadId + ", file=" + file + ", uploadDate=" + uploadDate
				+ ", userId=" + userId + ", filetypeId=" + filetypeId + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		result = prime * result + ((filetypeId == null) ? 0 : filetypeId.hashCode());
		result = prime * result + ((fileuploadId == null) ? 0 : fileuploadId.hashCode());
		result = prime * result + ((uploadDate == null) ? 0 : uploadDate.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Fileupload other = (Fileupload) obj;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		if (filetypeId == null) {
			if (other.filetypeId != null)
				return false;
		} else if (!filetypeId.equals(other.filetypeId))
			return false;
		if (fileuploadId == null) {
			if (other.fileuploadId != null)
				return false;
		} else if (!fileuploadId.equals(other.fileuploadId))
			return false;
		if (uploadDate == null) {
			if (other.uploadDate != null)
				return false;
		} else if (!uploadDate.equals(other.uploadDate))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
	
}
