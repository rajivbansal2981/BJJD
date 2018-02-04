package com.jmk.bjjd.models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ExpenseModel extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date date;
	
	@JsonIgnore
	private String dateString;

	private String description;
	
	private String paidTo;
	
	private String remark;
	
	private Double amount;
	
	private static final DateFormat df=new SimpleDateFormat("dd-MMM-yyyy");

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPaidTo() {
		return paidTo;
	}

	public void setPaidTo(String paidTo) {
		this.paidTo = paidTo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
		try {
			setDate(df.parse(dateString));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}
