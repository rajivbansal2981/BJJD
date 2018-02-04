package com.jmk.bjjd.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.jmk.bjjd.models.UserModel;
import com.jmk.bjjd.service.config.SpringServiceConfig;

@ContextConfiguration(classes=SpringServiceConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
public class UserMgmtServiceTest {

	@Autowired
	private UserMgmtService service;
	
	@Autowired
	private MemberMgmtService memberMgmtService;
	
	private static final String id="-999999";
	
	@Before
	public void setup(){
	//	MemberModel user=SQLTestDataUtil.createMember("BJJDJKYV0060");
	//	memberMgmtService.saveRecord(user);
	}
	
	@Test
	public void findUserDetailsByUserId(){
		UserModel userModel=service.findUserDetailsByUserName("rajivbansal2981","MEMBER");
		Assert.notNull(userModel);
	}
	
	@After
	public void destroy(){
		//memberMgmtService.deleteRecordById(id);
	}
}
