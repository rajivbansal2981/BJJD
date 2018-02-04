package com.jmk.bjjd.persistence.sql.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="ROLE")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class RoleEntity extends BaseEntity{
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@ManyToMany(mappedBy="roles",cascade=CascadeType.MERGE)
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
