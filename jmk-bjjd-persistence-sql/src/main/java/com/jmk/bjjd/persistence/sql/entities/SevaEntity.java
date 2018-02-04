package com.jmk.bjjd.persistence.sql.entities;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jmk.bjjd.enums.Day;
import com.jmk.bjjd.enums.DayNumberInMonth;
import com.jmk.bjjd.persistence.sql.converter.BooleanToYNStringConverter;

@Entity
@Table(name="SEVA")
public class SevaEntity extends BaseEntity{
	
	@Enumerated(EnumType.STRING)
	@Column(name="SEVADAY")
	private Day day;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="DAYNUMBERINMONTH")
	private DayNumberInMonth dayNumberInMonth;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="APPLICABLE")
	@Convert(converter=BooleanToYNStringConverter.class)
	private Boolean applicable=Boolean.FALSE;
	
	@ManyToOne
	@JoinColumn(name="MEMBERID",referencedColumnName="ID")
	private MemberEntity member;
	
	@ManyToOne
	@JoinColumn(name="SEVACATEGORYID",referencedColumnName="ID")
	private SevaCategoryEntity sevaCategory;

	/**
	 * @return the day
	 */
	public Day getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(Day day) {
		this.day = day;
	}

	/**
	 * @return the dayNumberInMonth
	 */
	public DayNumberInMonth getDayNumberInMonth() {
		return dayNumberInMonth;
	}

	/**
	 * @param dayNumberInMonth the dayNumberInMonth to set
	 */
	public void setDayNumberInMonth(DayNumberInMonth dayNumberInMonth) {
		this.dayNumberInMonth = dayNumberInMonth;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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

	/**
	 * @return the member
	 */
	public MemberEntity getMember() {
		return member;
	}

	/**
	 * @param member the member to set
	 */
	public void setMember(MemberEntity member) {
		this.member = member;
	}

	/**
	 * @return the sevaCategory
	 */
	public SevaCategoryEntity getSevaCategory() {
		return sevaCategory;
	}

	/**
	 * @param sevaCategory the sevaCategory to set
	 */
	public void setSevaCategory(SevaCategoryEntity sevaCategory) {
		this.sevaCategory = sevaCategory;
	}
	
}
