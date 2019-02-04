/**
 * 
 */
package com.skydriver.entity;

/**
 * @author jrong
 *
 */
public class FiletypeDetail {
	private Integer detailId;
	private String suffix;
	private Filetype filetype;
	
	
	/**
	 * @param detailId
	 * @param suffix
	 */
	public FiletypeDetail(Integer detailId, String suffix,Filetype filetype) {
		super();
		this.detailId = detailId;
		this.suffix = suffix;
		this.filetype = filetype;
	}
	/**
	 * 
	 */
	public FiletypeDetail() {
		super();
	}
	/**
	 * @return the detailId
	 */
	public Integer getDetailId() {
		return detailId;
	}
	/**
	 * @param detailId the detailId to set
	 */
	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
	}
	/**
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
	}
	/**
	 * @param suffix the suffix to set
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FiletypeDetail [detailId=" + detailId + ", suffix=" + suffix + "]";
	}
	/**
	 * @return the filetype
	 */
	public Filetype getFiletype() {
		return filetype;
	}
	/**
	 * @param filetype the filetype to set
	 */
	public void setFiletype(Filetype filetype) {
		this.filetype = filetype;
	}
	
	
}
