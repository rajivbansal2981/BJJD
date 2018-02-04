package com.jmk.bjjd.persistence.nosql.config;

public enum SequenceId {
	MEMBER("member"),GUEST("guest"),USER("user"),COLLECTION("collection"),SEVA("seva"),SEVA_CATEGORY("sevacategory");
	
	private String value;
	
	private SequenceId(String value){
		this.value=value;
	}
	
	public String value(){
		return value;
	}
	
	
}
