/**
 * 
 */
package com.skydriver.entity;

import java.io.Serializable;

import com.mysql.jdbc.Blob;

/**
 * @author jrong
 *
 */
public class File implements Serializable {
	private Integer fileId;
	private String fileName;
	private String parent;
	private Blob fileData;
	private String filePath;
	private Integer fileSize;
	private Filetype filetypeId;
	private Users userId;

	/**
	 * @return the fileId
	 */
	public Integer getFileId() {
		return fileId;
	}

	/**
	 * @param fileId the fileId to set
	 */
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the parent
	 */
	public String getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(String parent) {
		this.parent = parent;
	}

	/**
	 * @return the fileData
	 */
	public Blob getFileData() {
		return fileData;
	}

	/**
	 * @param fileData the fileData to set
	 */
	public void setFileData(Blob fileData) {
		this.fileData = fileData;
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * @return the fileSize
	 */
	public Integer getFileSize() {
		return fileSize;
	}

	/**
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "File [fileId=" + fileId + ", fileName=" + fileName + ", parent=" + parent + ", fileData=" + fileData
				+ ", filePath=" + filePath + ", fileSize=" + fileSize + ", filetypeId=" + filetypeId + ", userId="
				+ userId + "]";
	}

	/**
	 * @param fileId
	 * @param fileName
	 * @param parent
	 * @param fileData
	 * @param filePath
	 * @param fileSize
	 */
	public File(Integer fileId, String fileName, String parent, Blob fileData, String filePath, Integer fileSize) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.parent = parent;
		this.fileData = fileData;
		this.filePath = filePath;
		this.fileSize = fileSize;
	}

	/**
	 * @param fileId
	 * @param fileName
	 * @param parent
	 * @param fileData
	 * @param filePath
	 * @param fileSize
	 * @param filetypeId
	 * @param userId
	 */
	public File(Integer fileId, String fileName, String parent, Blob fileData, String filePath, Integer fileSize,
			Filetype filetypeId) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.parent = parent;
		this.fileData = fileData;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.filetypeId = filetypeId;
	}

	/**
	 * 
	 */
	public File() {
		super();
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
		result = prime * result + ((fileData == null) ? 0 : fileData.hashCode());
		result = prime * result + ((fileId == null) ? 0 : fileId.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
		result = prime * result + ((fileSize == null) ? 0 : fileSize.hashCode());
		result = prime * result + ((filetypeId == null) ? 0 : filetypeId.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
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
		File other = (File) obj;
		if (fileData == null) {
			if (other.fileData != null)
				return false;
		} else if (!fileData.equals(other.fileData))
			return false;
		if (fileId == null) {
			if (other.fileId != null)
				return false;
		} else if (!fileId.equals(other.fileId))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (filePath == null) {
			if (other.filePath != null)
				return false;
		} else if (!filePath.equals(other.filePath))
			return false;
		if (fileSize == null) {
			if (other.fileSize != null)
				return false;
		} else if (!fileSize.equals(other.fileSize))
			return false;
		if (filetypeId == null) {
			if (other.filetypeId != null)
				return false;
		} else if (!filetypeId.equals(other.filetypeId))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
