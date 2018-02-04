package com.jmk.bjjd.models;

import java.util.List;

public class SevaCategoryModel extends BaseModel {
	private String name;
	
	private String description;
	
	private List<SevaModel> sevas;

	public SevaCategoryModel() {
		super();
	}

	public SevaCategoryModel(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public SevaCategoryModel(String id,String name, String description) {
		super();
		setId(id);
		this.name = name;
		this.description = description;
	}
	
	

	public SevaCategoryModel(String id) {
		super(id);
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

	public List<SevaModel> getSevas() {
		return sevas;
	}

	public void setSevas(List<SevaModel> sevas) {
		this.sevas = sevas;
	}
	
}
