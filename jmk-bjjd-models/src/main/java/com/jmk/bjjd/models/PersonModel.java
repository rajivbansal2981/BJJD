package com.jmk.bjjd.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class PersonModel extends BaseModel{

	@NotEmpty(message="Please enter the first name")
	private String firstName;
	
	private String lastName;
	
	@NotEmpty(message="Please enter the mobile number")
	private String mobileNo1;
	
	private String mobileNo2;
	
	@Email
	private String emailId;
	
	private String reference;
	
	private Character sex;
	
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


	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
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


}
