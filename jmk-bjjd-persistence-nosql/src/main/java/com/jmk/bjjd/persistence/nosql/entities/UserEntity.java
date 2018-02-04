package com.jmk.bjjd.persistence.nosql.entities;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.jmk.bjjd.models.RoleModel;

@Document(collection="user")
public abstract class UserEntity extends PersonEntity {

	@Field("userName")
	private String userName;
	
	@Field("password")
	private String password;
	
	@Field("userType")
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

	public abstract List<RoleEntity> getRoles();
	public abstract void setRoles(List<RoleEntity> roles);
	public abstract Boolean getActive();
	public abstract void setActive(Boolean active);
}
