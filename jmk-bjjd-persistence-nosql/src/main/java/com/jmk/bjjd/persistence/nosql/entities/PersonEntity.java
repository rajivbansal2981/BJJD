package com.jmk.bjjd.persistence.nosql.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class PersonEntity extends BaseEntity{

	private String firstName;
	
	private String lastName;
	
	@Field("mobile1")
	private String mobileNo1;
	
	@Field("mobile2")
	private String mobileNo2;
	
	@Field("emailId")
	private String emailId;
	
	@Field("sex")
	private Character sex;
	
	@DBRef
	@Field("referredBy")
	private MemberEntity referredBy;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the mobileNo1
	 */
	public String getMobileNo1() {
		return mobileNo1;
	}

	/**
	 * @param mobileNo1 the mobileNo1 to set
	 */
	public void setMobileNo1(String mobileNo1) {
		this.mobileNo1 = mobileNo1;
	}

	/**
	 * @return the mobileNo2
	 */
	public String getMobileNo2() {
		return mobileNo2;
	}

	/**
	 * @param mobileNo2 the mobileNo2 to set
	 */
	public void setMobileNo2(String mobileNo2) {
		this.mobileNo2 = mobileNo2;
	}

	/**
	 * @return the sex
	 */
	public Character getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(Character sex) {
		this.sex = sex;
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


}
