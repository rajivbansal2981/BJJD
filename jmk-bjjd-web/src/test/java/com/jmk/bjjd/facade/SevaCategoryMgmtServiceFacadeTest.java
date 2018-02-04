package com.jmk.bjjd.facade;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jmk.bjjd.models.SevaCategoryModel;
import com.jmk.bjjd.web.config.SpringWebMvcConfig;
import com.jmk.bjjd.web.facade.SevaCategoryMgmtServiceFacade;



@ContextConfiguration(classes={SpringWebMvcConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Ignore
public class SevaCategoryMgmtServiceFacadeTest {

	@Autowired
	private SevaCategoryMgmtServiceFacade serviceFacade;
	
	
	@Test
	public void getUserDetailsByUserName(){
		List<SevaCategoryModel> sevaCategoryModels=serviceFacade.fetchAllRecords(9L);
		Assert.assertNotNull(sevaCategoryModels);
	}
	
	
}
