package com.jmk.bjjd.rest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.jmk.bjjd.models.MemberModel;
import com.jmk.bjjd.models.UserModel;
import com.jmk.bjjd.rest.config.SpringWebServiceConfig;
import com.jmk.bjjd.service.MemberMgmtService;
import com.jmk.bjjd.service.UserMgmtService;
import com.jmk.bjjd.util.constants.UserURIConstants;
import com.jmk.bjjd.util.testdata.SQLTestDataUtil;

@ContextConfiguration(classes={SpringWebServiceConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class UserMgmtRestServiceTest {
	
	private final String WEBSERVICE_URL="http://localhost:9090/jmk-bjjd-webservice";
	
	/**
	 * Just for setup/destroy
	 */
	@Autowired
	private UserMgmtService service;
	
	@Autowired
	private MemberMgmtService memberMgmtService;
	
	private static final String id="-999999";
	
	private static RestTemplate template=new RestTemplate();
	
//	@Before
	public void setup(){
		memberMgmtService.saveRecord(SQLTestDataUtil.createMember(id));
	}

	@Test
	@Ignore
	public void getUserDetailsByUserId(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("userName", "rajivbansal2981");
		map.put("userType", "MEMBER");
		UserModel userModel=template.getForObject(WEBSERVICE_URL+UserURIConstants.GET_USERDETAILS_BY_USERNAME_AND_TYPE,MemberModel.class,map);
		Assert.assertNotNull(userModel);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	@Ignore
	public void fetchAllUserRecords(){
		ResponseEntity<List> result=template.exchange(WEBSERVICE_URL+UserURIConstants.FETCH_ALL_USERS_BY_TENANTID, HttpMethod.GET, null,List.class);
		List<UserModel> list=(List<UserModel>)result.getBody();
		Assert.assertNotNull(list);
	}
	
	//@After
	public void destroy(){
		memberMgmtService.deleteRecordById(id);
	}
}
