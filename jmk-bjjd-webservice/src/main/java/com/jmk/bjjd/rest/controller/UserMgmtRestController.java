package com.jmk.bjjd.rest.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jmk.bjjd.models.UserModel;
import com.jmk.bjjd.service.UserMgmtService;
import com.jmk.bjjd.util.constants.UserURIConstants;


@RestController("userMgmtRestController")
public class UserMgmtRestController {
	
	private Logger logger=LoggerFactory.getLogger(UserMgmtRestController.class);

	@Resource(name="userMgmtService")
	private UserMgmtService service;
	
	@RequestMapping(value=UserURIConstants.GET_USERDETAILS_BY_USERNAME_AND_TYPE,method=RequestMethod.GET)
	public UserModel getUserDetailsByUserId(@PathVariable("userName") String userName,@PathVariable("userType") String userType){
		logger.info("userNameuserNameuserNameuserNameuserNameuserNameuserNameuserName: "+userName);
		UserModel userModel=service.findUserDetailsByUserName(userName,userType);
		return userModel;
	}
	
		
}
