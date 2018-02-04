package com.jmk.bjjd.persistence.sql.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="EXPENSE")
public class ExpenseEntity extends BaseEntity{
	
	@Column(name="EXPENSEDATE")
	private Date date;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="PAIDTO")
	private String paidTo;
	
	@Column(name="REMARK")
	private String remark;
	
	@Column(name="AMOUNT")
	private Double amount;

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
	
	
}
