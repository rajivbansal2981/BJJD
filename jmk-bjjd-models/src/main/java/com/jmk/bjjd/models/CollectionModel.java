package com.jmk.bjjd.models;

import java.util.Date;

import com.jmk.bjjd.enums.PersonType;


public class CollectionModel extends BaseModel {

	private String id;
	
	private PersonType personType;
	
	private MemberModel member;
	
	private GuestModel guest;
	
	private String month;
	
	private Integer year;
	
	private Integer monthlyAmount;
	
	private Integer projectAmount;
	
	private Integer totalAmount;
	
	private Date submittedOn;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PersonType getPersonType() {
		return personType;
	}

	public void setPersonType(PersonType personType) {
		this.personType = personType;
	}

	public MemberModel getMember() {
		return member;
	}

	public void setMember(MemberModel member) {
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

	public GuestModel getGuest() {
		return guest;
	}

	public void setGuest(GuestModel guest) {
		this.guest = guest;
	}
	
	
}
