package com.jmk.bjjd.facade;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jmk.bjjd.dto.LoggedInUser;
import com.jmk.bjjd.service.MemberMgmtService;
import com.jmk.bjjd.service.config.SpringServiceConfig;
import com.jmk.bjjd.web.config.SpringWebMvcConfig;
import com.jmk.bjjd.web.facade.UserMgmtServiceFacade;



@ContextConfiguration(classes={SpringWebMvcConfig.class,SpringServiceConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Ignore
public class UserMgmtServiceFacadeTest {

	private static final String id="-10001";
	
	@Autowired
	private UserMgmtServiceFacade serviceFacade;
	
	@Autowired
	private MemberMgmtService memberMgmtService;
	
	@Before
	public void setUp(){
	//	memberMgmtService.saveRecord(NoSQLTestDataUtil.createMember(id));
	}
	
	@Test
	public void getUserDetailsByUserName(){
		LoggedInUser loggedInUser=(LoggedInUser)serviceFacade.loadUserByUsername("rajivbansal2981:MEMBER");
		Assert.assertNotNull(loggedInUser);
	}
	
	@After
	public void destroy(){
	//	memberMgmtService.deleteRecordById(id);
	}
	
}
