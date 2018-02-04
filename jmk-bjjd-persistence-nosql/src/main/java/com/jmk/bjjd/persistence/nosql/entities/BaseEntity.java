package com.jmk.bjjd.persistence.nosql.entities;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class BaseEntity {
	
	@Id
	private String id;
	
	@CreatedDate
	@Field("whenCreated")
	private Date whenCreated;
	
	@CreatedBy
	@Field("createdBy")
	private String createdBy;
	
	@LastModifiedDate
	@Field("whenUpdated")
	private Date whenUpdated;
	
	@LastModifiedBy
	@Field("updatedBy")
	private String updatedBy;
	
	@Version
	private Long version;
	
	@Field("tenantId")
	private Long tenantId;

	

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

	
}

