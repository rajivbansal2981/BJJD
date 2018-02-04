package com.jmk.bjjd.persistence.sql.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SEVACATEGORY")
public class SevaCategoryEntity extends BaseEntity{

	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="sevaCategory")
	private List<SevaEntity> sevas;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the sevas
	 */
	public List<SevaEntity> getSevas() {
		return sevas;
	}

	/**
	 * @param sevas the sevas to set
	 */
	public void setSevas(List<SevaEntity> sevas) {
		this.sevas = sevas;
	}
	
	
	
}
