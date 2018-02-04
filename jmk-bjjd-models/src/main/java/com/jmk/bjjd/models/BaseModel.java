package com.jmk.bjjd.models;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class BaseModel implements Serializable{
	
	private String id;
	
	private Date whenCreated;
	
	private String createdBy;
	
	private Date whenUpdated;
	
	private String updatedBy;
	
	private Long version=1L;
	
	private Long tenantId;
	
	public BaseModel(String id) {
		this.id = id;
	}
	
	public BaseModel() {
	}
	

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the whenCreated
	 */
	public Date getWhenCreated() {
		return whenCreated;
	}


	/**
	 * @param whenCreated the whenCreated to set
	 */
	public void setWhenCreated(Date whenCreated) {
		this.whenCreated = whenCreated;
	}


	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}


	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	/**
	 * @return the whenUpdated
	 */
	public Date getWhenUpdated() {
		return whenUpdated;
	}


	/**
	 * @param whenUpdated the whenUpdated to set
	 */
	public void setWhenUpdated(Date whenUpdated) {
		this.whenUpdated = whenUpdated;
	}


	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}


	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	/**
	 * @return the version
	 */
	public Long getVersion() {
		return version;
	}


	/**
	 * @param version the version to set
	 */
	public void setVersion(Long version) {
		this.version = version;
	}


	/**
	 * @return the tenantId
	 */
	public Long getTenantId() {
		return tenantId;
	}


	/**
	 * @param tenantId the tenantId to set
	 */
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}


/*	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
*/
}

