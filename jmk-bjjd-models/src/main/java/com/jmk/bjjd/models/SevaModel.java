package com.jmk.bjjd.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jmk.bjjd.enums.Day;
import com.jmk.bjjd.enums.DayNumberInMonth;
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class SevaModel extends BaseModel {
	
	private Day day;
	
	private DayNumberInMonth dayNumberInMonth;
	
	private Boolean applicable=Boolean.FALSE;
	
	private String description;
	
	private MemberModel member;
	
	private SevaCategoryModel sevaCategory;

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	/**
	 * @return the applicable
	 */
	public Boolean getApplicable() {
		return applicable;
	}

	/**
	 * @param applicable the applicable to set
	 */
	public void setApplicable(Boolean applicable) {
		this.applicable = applicable;
	}

	public DayNumberInMonth getDayNumberInMonth() {
		return dayNumberInMonth;
	}

	public void setDayNumberInMonth(DayNumberInMonth dayNumberInMonth) {
		this.dayNumberInMonth = dayNumberInMonth;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MemberModel getMember() {
		return member;
	}

	public void setMember(MemberModel member) {
		this.member = member;
	}
	
	public Boolean isApplicable(){
		return getApplicable();
	}

	public SevaCategoryModel getSevaCategory() {
		return sevaCategory;
	}

	public void setSevaCategory(SevaCategoryModel sevaCategory) {
		this.sevaCategory = sevaCategory;
	}
	
}
