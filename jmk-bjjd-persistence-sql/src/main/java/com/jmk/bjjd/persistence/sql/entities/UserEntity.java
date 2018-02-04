package com.jmk.bjjd.persistence.sql.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.jmk.bjjd.models.RoleModel;

@MappedSuperclass
public class UserEntity extends PersonEntity {

	@Column(name="USERNAME",unique=true)
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;
	
	//@Column(name="USERTYPE")
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

	public List<RoleEntity> getRoles(){return null;};
	public void setRoles(List<RoleEntity> roles){};
	public Boolean getActive(){return null;}
	public void setActive(Boolean active){}
	
}
