package com.jmk.bjjd.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.jmk.bjjd.models.UserModel;

public class LoggedInUser extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 328609439951586072L;
	
	private UserModel userModel;

	public LoggedInUser(UserModel userModel,String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
	}

	public LoggedInUser(UserModel userModel,String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.userModel=userModel;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	
}
