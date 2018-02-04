package com.jmk.bjjd.persistence.nosql.entities;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="role")
public class RoleEntity extends BaseEntity{
	
	@Field("name")
	private String name;
	
	@Field("description")
	private String description;
	
	@DBRef
	private List<MemberEntity> members;

	public RoleEntity() {
		super();
	}

	public RoleEntity(String id, String name, String description) {
		super();
		setId(id);
		this.name = name;
		this.description = description;
	}

	public RoleEntity(String id) {
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

	public List<MemberEntity> getMembers() {
		return members;
	}

	public void setMembers(List<MemberEntity> members) {
		this.members = members;
	}
	
	
}
