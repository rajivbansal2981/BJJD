package com.jmk.bjjd.persistence.service;

import com.jmk.bjjd.models.UserModel;



public interface UserPersistenceService{
	public UserModel findUserDetailsByUserName(String userid);
	
	public void changePassword(String userId,String password);
}
