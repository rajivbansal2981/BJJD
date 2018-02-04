package com.jmk.bjjd.models;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


public class MemberModel extends UserModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MemberModel(){
	}
	
	public MemberModel(String id){
		setId(id);
	}
	
	@NotEmpty(message="Please enter the father name")
	private String fatherName;
	
	private MemberModel reportingLead;
	
	@NotNull(message="Please enter the joining date")
	//@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date joiningDate;
	
	@NotNull(message="Please enter the date of birth")
	//@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date dateOfBirth;
	
	private Boolean dressIssued=Boolean.FALSE;
	
	private Integer age;
	
	private Boolean active=Boolean.TRUE;
	
	private List<RoleModel> roles;
	
	private List<SevaModel> sevas;
	
	@Valid
	private AddressModel mailingAddress;
	
	@Valid
	private AddressModel permanentAddress;
	
	private PhotoUploadModel photoUpload;
	
	private MemberModel referredBy;
	
	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}


	public MemberModel getReportingLead() {
		return reportingLead;
	}

	public void setReportingLead(MemberModel reportingLead) {
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

	public List<RoleModel> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleModel> roles) {
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

	public List<SevaModel> getSevas() {
		return sevas;
	}

	public void setSevas(List<SevaModel> sevas) {
		this.sevas = sevas;
	}

	/**
	 * @return the mailingAddress
	 */
	public AddressModel getMailingAddress() {
		return mailingAddress;
	}

	/**
	 * @return the permanentAddress
	 */
	public AddressModel getPermanentAddress() {
		return permanentAddress;
	}

	/**
	 * @param mailingAddress the mailingAddress to set
	 */
	public void setMailingAddress(AddressModel mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

	/**
	 * @param permanentAddress the permanentAddress to set
	 */
	public void setPermanentAddress(AddressModel permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	/**
	 * @return the referredBy
	 */
	public MemberModel getReferredBy() {
		return referredBy;
	}

	/**
	 * @param referredBy the referredBy to set
	 */
	public void setReferredBy(MemberModel referredBy) {
		this.referredBy = referredBy;
	}

	public PhotoUploadModel getPhotoUpload() {
		return photoUpload;
	}

	public void setPhotoUpload(PhotoUploadModel photoUpload) {
		this.photoUpload = photoUpload;
	}

}
