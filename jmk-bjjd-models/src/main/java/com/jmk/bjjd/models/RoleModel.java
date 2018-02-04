package com.jmk.bjjd.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

public class RoleModel extends BaseModel {
	
	private String name;
	
	private String description;
	
	private List<MemberModel> members;

	public RoleModel() {
		super();
	}

	public RoleModel(String id, String name, String description) {
		super();
		setId(id);
		this.name = name;
		this.description = description;
	}

	public RoleModel(String id) {
		super();
		setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<MemberModel> getMembers() {
		return members;
	}

	public void setMembers(List<MemberModel> members) {
		this.members = members;
	}
	
}
