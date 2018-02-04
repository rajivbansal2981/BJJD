package com.jmk.bjjd.facade;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jmk.bjjd.models.MemberModel;
import com.jmk.bjjd.models.RoleModel;
import com.jmk.bjjd.web.config.SpringWebMvcConfig;
import com.jmk.bjjd.web.facade.MemberMgmtServiceFacade;

@ContextConfiguration(classes={SpringWebMvcConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Ignore
public class MemberMgmtServiceFacadeTest {

	@Resource(name="memberMgmtServiceFacade")
	private MemberMgmtServiceFacade facade;
	
	@Test
	public void findRolesByTenantId(){
		List<RoleModel> roles=facade.findRolesByTenantId(9L);
		Assert.assertNotNull(roles);
	}
	
	@Test
	public void findTeamLeadersByTenantId(){
		List<MemberModel> members=facade.findTeamLeadersByTenantId(9L);
		Assert.assertNotNull(members);
	}
	
}
