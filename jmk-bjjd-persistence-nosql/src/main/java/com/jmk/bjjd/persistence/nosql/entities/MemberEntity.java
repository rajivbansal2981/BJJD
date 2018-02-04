package com.jmk.bjjd.persistence.nosql.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document(collection="member")
public class MemberEntity extends UserEntity{
	
	public MemberEntity(){
		
	}
	
	public MemberEntity(String id){
		setId(id);
	}
	
	@Field("fatherName")
	private String fatherName;
	
	@Field("reportingLead")
	private MemberEntity reportingLead;
	
	@Field("joiningDate")
	@DateTimeFormat(iso=ISO.DATE)
	private Date joiningDate;
	
	@Field("dateOfBirth")
	@DateTimeFormat(iso=ISO.DATE)
	private Date dateOfBirth;
	
	@Field("dressIssued")
	private Boolean dressIssued;
	
	private Integer age;
	
	@Field("active")
	private Boolean active;
	
	@DBRef
	private List<RoleEntity> roles;
	
	@DBRef
	private List<SevaEntity> sevas;
	
	private String photoName;
	
	@DBRef
	private AddressEntity mailingAddress;
	
	@DBRef
	private AddressEntity permanentAddress;
	
	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public MemberEntity getReportingLead() {
		return reportingLead;
	}

	public void setReportingLead(MemberEntity reportingLead) {
		this.reportingLead = reportingLead;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Boolean getDressIssued() {
		return dressIssued;
	}

	public void setDressIssued(Boolean dressIssued) {
		this.dressIssued = dressIssued;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public List<SevaEntity> getSevas() {
		return sevas;
	}

	public void setSevas(List<SevaEntity> sevas) {
		this.sevas = sevas;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	/**
	 * @return the mailingAddress
	 */
	public AddressEntity getMailingAddress() {
		return mailingAddress;
	}

	/**
	 * @return the permanentAddress
	 */
	public AddressEntity getPermanentAddress() {
		return permanentAddress;
	}

	/**
	 * @param mailingAddress the mailingAddress to set
	 */
	public void setMailingAddress(AddressEntity mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

	/**
	 * @param permanentAddress the permanentAddress to set
	 */
	public void setPermanentAddress(AddressEntity permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

}
