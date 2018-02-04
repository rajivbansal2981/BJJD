package com.jmk.bjjd.persistence.sql.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="PHOTOUPLOAD")
@Entity
public class PhotoUploadEntity extends BaseEntity{
	
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="LOCATION")
	private String location;
	
	@OneToOne
	@JoinColumn(name="MEMBERID",referencedColumnName="ID")
	private MemberEntity member;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public MemberEntity getMember() {
		return member;
	}

	public void setMember(MemberEntity member) {
		this.member = member;
	}
	
}
