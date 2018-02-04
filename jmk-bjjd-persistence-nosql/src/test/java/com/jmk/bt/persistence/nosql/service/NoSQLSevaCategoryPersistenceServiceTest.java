package com.jmk.bt.persistence.nosql.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jmk.bjjd.models.SevaCategoryModel;
import com.jmk.bjjd.persistence.nosql.config.SpringNoSQLPersistenceConfig;
import com.jmk.bjjd.persistence.service.SevaCategoryPersistenceService;

@ContextConfiguration(classes={SpringNoSQLPersistenceConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
public class NoSQLSevaCategoryPersistenceServiceTest {

	@Resource(name="noSQLSevaCategoryPersistenceService")
	private SevaCategoryPersistenceService service;
	
	private List<SevaCategoryModel> sevaCategoryModels;
	
	@Before
	public void setUp(){
		sevaCategoryModels=new ArrayList<SevaCategoryModel>();
		sevaCategoryModels.add(new SevaCategoryModel("Ankrit Day Seva","Internal Day Seva in Darbar"));
		sevaCategoryModels.add(new SevaCategoryModel("Ankrit Night Seva","Internal Day Seva in Darbar"));
		sevaCategoryModels.add(new SevaCategoryModel("Bahari Day Seva","External Night Seva in Darbar"));
		sevaCategoryModels.add(new SevaCategoryModel("Bahari Night Seva","External Night Seva in Darbar"));
	}
	
	/**
	 * To include all test scenario into one test to maintain the order of test methods
	 * we can use alternative approach as well by putting the annotation i.e. @FixMethodOrder(MethodSorters.NAME_ASCENDING)
	 */
	@Test
	public void saveInitialSevaCategory(){
		service.saveRecords(sevaCategoryModels);
	}
	
	
}
