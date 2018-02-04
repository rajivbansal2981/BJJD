package com.jmk.bjjd.models;

import java.util.List;


public class UserModel extends PersonModel {

	private String userName;
	
	private String password;
	
	private String userType;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	public List<RoleModel> getRoles(){
		return null;
	}
	public void setRoles(List<RoleModel> roles){}
	public Boolean getActive(){
		return null;
	}
	public void setActive(Boolean active){}
}
