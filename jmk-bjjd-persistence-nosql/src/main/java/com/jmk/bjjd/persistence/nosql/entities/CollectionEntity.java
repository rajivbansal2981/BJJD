package com.jmk.bjjd.persistence.nosql.entities;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.jmk.bjjd.enums.PersonType;


@Document(collection="collection")
public class CollectionEntity extends BaseEntity {

	@Field("personType")
	private PersonType personType;
	
	@DBRef
	private MemberEntity member;
	
	@DBRef
	private GuestEntity guest;
	
	private String month;
	
	private Integer year;
	
	private Integer monthlyAmount;
	
	private Integer projectAmount;
	
	private Integer totalAmount;
	
	@Field("submittedon")
	@DateTimeFormat(iso=ISO.DATE_TIME)
	private Date submittedOn;

	public PersonType getPersonType() {
		return personType;
	}

	public void setPersonType(PersonType personType) {
		this.personType = personType;
	}

	public MemberEntity getMember() {
		return member;
	}

	public void setMember(MemberEntity member) {
		this.member = member;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonthlyAmount() {
		return monthlyAmount;
	}

	public void setMonthlyAmount(Integer monthlyAmount) {
		this.monthlyAmount = monthlyAmount;
	}

	public Integer getProjectAmount() {
		return projectAmount;
	}

	public void setProjectAmount(Integer projectAmount) {
		this.projectAmount = projectAmount;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getSubmittedOn() {
		return submittedOn;
	}

	public void setSubmittedOn(Date submittedOn) {
		this.submittedOn = submittedOn;
	}

	public GuestEntity getGuest() {
		return guest;
	}

	public void setGuest(GuestEntity guest) {
		this.guest = guest;
	}
	
	
}
