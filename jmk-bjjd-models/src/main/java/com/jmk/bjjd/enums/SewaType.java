package com.jmk.bjjd.enums;

public enum SewaType {
	FINANCIAL("Financial"),BAHAARI_SEWA("Bahaari Sewa"),ANTRIK_SEWA("Antrik Sewa"),RATRI_SEWA("Ratri Seva");

	private String name;


	private SewaType(String sevaName) {
		this.name = sevaName;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	
	
}
