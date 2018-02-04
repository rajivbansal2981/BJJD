package com.jmk.bjjd.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jmk.bjjd.models.UserModel;
import com.jmk.bjjd.persistence.service.UserPersistenceService;
import com.jmk.bjjd.service.UserMgmtService;

@Service("userMgmtService")
public class DefaultUserMgmtService implements UserMgmtService {

	@Resource(name="${persistenceservicetype}MemberPersistenceService")
	private UserPersistenceService memberPersistenceService;
	
	@Override
	public UserModel findUserDetailsByUserName(String userName,String userType) {
		UserModel userModel=null;
		if("MEMBER".equals(userType)){
			userModel=memberPersistenceService.findUserDetailsByUserName(userName);
		}
		return userModel;
	}

	@Override
	public void changePassword(String userId, String password) {
		memberPersistenceService.changePassword(userId, password);
	}
	
}
