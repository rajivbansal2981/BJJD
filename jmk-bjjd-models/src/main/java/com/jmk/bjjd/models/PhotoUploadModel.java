package com.jmk.bjjd.models;



public class PhotoUploadModel extends BaseModel{
	private String name;
	
	private String location;
	
	private MemberModel member;

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

	public MemberModel getMember() {
		return member;
	}

	public void setMember(MemberModel member) {
		this.member = member;
	}
	
	
}
