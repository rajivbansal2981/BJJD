package com.jmk.bjjd.enums;

public enum DayNumberInMonth {
	FIRST("First"),SECOND("Second"),THIRD("Third"),LAST("Last"),ALL("All");

	private String displayName;
	
	
	private DayNumberInMonth(String displayName){
		this.displayName=displayName;
	}



	public String getDisplayName() {
		return displayName;
	}

}
