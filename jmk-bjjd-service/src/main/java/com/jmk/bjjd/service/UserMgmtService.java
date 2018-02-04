package com.jmk.bjjd.service;

import com.jmk.bjjd.models.UserModel;



public interface UserMgmtService{
	public UserModel findUserDetailsByUserName(String username,String userType);
	
	public void changePassword(String userId,String password);
}
