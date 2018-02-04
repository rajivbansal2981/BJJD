package com.jmk.bjjd.persistence.sql.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@MappedSuperclass
public class PersonEntity extends BaseEntity{

	 @Column(name = "FIRSTNAME")
	 private String firstName;

	 @Column(name = "LASTNAME")
	 private String lastName;
	
	 @Column(name = "EMAILID")
	 private String emailId;

	 @Column(name = "MOBILENO1")
	 private String mobileNo1;

	 @Column(name = "MOBILENO2")
	 private String mobileNo2;
	 
	 @Column(name = "SEX")
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
