package com.jmk.bjjd.enums;

public enum Day {
	SUN("Sunday"),MON("Monday"),TUE("Tuesday"),WED("Wednesday"),THU("Thursday"),FRI("Friday"),SAT("Saturday");

	private String displayName;
	
	private Day(String displayName){
		this.displayName=displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	
	
}
