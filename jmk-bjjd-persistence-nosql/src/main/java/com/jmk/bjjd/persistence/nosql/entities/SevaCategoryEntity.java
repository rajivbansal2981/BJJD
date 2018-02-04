package com.jmk.bjjd.persistence.nosql.entities;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.jmk.bjjd.models.SevaModel;

@Document(collection="sevacategory")
public class SevaCategoryEntity extends BaseEntity{

	@Field("name")
	private String name;
	
	@Field("description")
	private String description;
	
	@DBRef
	private List<SevaModel> sevas;

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

	public List<SevaModel> getSevas() {
		return sevas;
	}

	public void setSevas(List<SevaModel> sevas) {
		this.sevas = sevas;
	}
	

}
