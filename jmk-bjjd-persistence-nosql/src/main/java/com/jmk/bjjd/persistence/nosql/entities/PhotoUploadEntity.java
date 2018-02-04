package com.jmk.bjjd.persistence.nosql.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class PhotoUploadEntity extends BaseEntity{
	
	
	@Field("name")
	private String name;
	
	@Field("location")
	private String location;

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

	
}
