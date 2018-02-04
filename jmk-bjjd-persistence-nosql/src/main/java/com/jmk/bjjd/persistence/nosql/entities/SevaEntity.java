package com.jmk.bjjd.persistence.nosql.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.jmk.bjjd.enums.Day;
import com.jmk.bjjd.enums.DayNumberInMonth;

@Document(collection="seva")
public class SevaEntity extends BaseEntity {
	
	@Field
	private Day day;
	
	@Field("dayNumberInMonth")
	private DayNumberInMonth dayNumberInMonth;
	
	private String description;
	
	@Field("applicable")
	private Boolean applicable=Boolean.FALSE;
	
	@DBRef
	private MemberEntity member;
	
	@DBRef
	private SevaCategoryEntity sevaCategory;
	
	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
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

	public MemberEntity getMember() {
		return member;
	}

	public void setMember(MemberEntity member) {
		this.member = member;
	}

	public SevaCategoryEntity getSevaCategory() {
		return sevaCategory;
	}

	public void setSevaCategory(SevaCategoryEntity sevaCategory) {
		this.sevaCategory = sevaCategory;
	}

	public Boolean isApplicable(){
		return getApplicable();
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

	
}
