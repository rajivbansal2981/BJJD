package com.jmk.bjjd.web.facade;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.jmk.bjjd.models.UserModel;

public interface UserMgmtServiceFacade extends UserDetailsService{
	public UserModel findUserDetailsByUserName(String userid,String userType);
	
	public void changePassword(String userId,String password);
}
