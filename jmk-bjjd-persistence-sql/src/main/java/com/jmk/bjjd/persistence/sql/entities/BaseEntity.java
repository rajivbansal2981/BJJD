package com.jmk.bjjd.persistence.sql.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public class BaseEntity {

	@Id
	@GenericGenerator(name="SEQ_ID",strategy="com.jmk.bjjd.persistence.sql.sequence.PKSequenceGenerator")
	@GeneratedValue(generator="SEQ_ID")
	@Column(name = "ID")
	private String id;
	
	@Column(name = "WHENCREATED")
	private Date whenCreated;
	
	@Column(name = "CREATEDBY")
	private String createdBy;

	@Column(name = "WHENUPDATED")
	private Date whenUpdated;
	
	@Column(name = "UPDATEDBY")
	private String updatedBy;
	
	@Column(name = "TENANTID")
	private Long tenantId;

	@Version
	@Column(name = "VERSION", nullable = false, columnDefinition = "default 1")
	private Long version = 1L;


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
	
	

}
