package com.jmk.bjjd.persistence.sql.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.jmk.bjjd.persistence.sql.converter.BooleanToYNStringConverter;

@Entity
@Table(name="MEMBER")
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQuery(name="findTeamLeadersByTenantId",query="SELECT m from MemberEntity m JOIN m.roles r "
		+ "WHERE m.tenantId= :tenantId and r.name=:rolename")
public class MemberEntity extends UserEntity{

	public MemberEntity(){
		
	}
	
	public MemberEntity(String id){
		setId(id);
	}
	
	@Column(name="FATHERNAME")
	private String fatherName;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name="REPORTINGLEAD",referencedColumnName="ID")
	private MemberEntity reportingLead;
	
	@Column(name="JOININGDATE")
	@DateTimeFormat(iso=ISO.DATE)
	private Date joiningDate;
	
	@Column(name="DATEOFBIRTH")
	@DateTimeFormat(iso=ISO.DATE)
	private Date dateOfBirth;
	
	@Column(name="DRESSISSUED")
	private Boolean dressIssued;
	
	@Column(name="AGE")
	private Integer age;
	
	@Column(name = "ACTIVE")
	@Convert(converter = BooleanToYNStringConverter.class)
	private Boolean active = true;
	
	@ManyToMany
	@JoinTable(name="MEMBERROLE",joinColumns={@JoinColumn(name="MEMBERID",referencedColumnName="ID",nullable=false)},
	inverseJoinColumns={@JoinColumn(name="ROLEID",referencedColumnName="ID",nullable=false)})
	private List<RoleEntity> roles;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="member")
	private List<SevaEntity> sevas;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="member")
	private AddressEntity mailingAddress;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="member")
	private AddressEntity permanentAddress;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name="REFERREDBY",referencedColumnName="ID")
 	private MemberEntity referredBy;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="member")
	private PhotoUploadEntity photoUpload;

	/**
	 * @return the fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}

	/**
	 * @param fatherName the fatherName to set
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	/**
	 * @return the reportingLead
	 */
	public MemberEntity getReportingLead() {
		return reportingLead;
	}

	/**
	 * @param reportingLead the reportingLead to set
	 */
	public void setReportingLead(MemberEntity reportingLead) {
		this.reportingLead = reportingLead;
	}

	/**
	 * @return the joiningDate
	 */
	public Date getJoiningDate() {
		return joiningDate;
	}

	/**
	 * @param joiningDate the joiningDate to set
	 */
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the dressIssued
	 */
	public Boolean getDressIssued() {
		return dressIssued;
	}

	/**
	 * @param dressIssued the dressIssued to set
	 */
	public void setDressIssued(Boolean dressIssued) {
		this.dressIssued = dressIssued;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	
	
	
	/**
	 * @return the roles
	 */
	public List<RoleEntity> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	/**
	 * @return the sevas
	 */
	public List<SevaEntity> getSevas() {
		return sevas;
	}

	/**
	 * @param sevas the sevas to set
	 */
	public void setSevas(List<SevaEntity> sevas) {
		this.sevas = sevas;
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

	/**
	 * @return the referredBy
	 */
	public MemberEntity getReferredBy() {
		return referredBy;
	}

	/**
	 * @param referredBy the referredBy to set
	 */
	public void setReferredBy(MemberEntity referredBy) {
		this.referredBy = referredBy;
	}

	public PhotoUploadEntity getPhotoUpload() {
		return photoUpload;
	}

	public void setPhotoUpload(PhotoUploadEntity photoUpload) {
		this.photoUpload = photoUpload;
	}

}
