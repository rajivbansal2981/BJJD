package com.jmk.bjjd.persistence.sql.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.qos.logback.core.util.TimeUtil;

import com.jmk.bjjd.models.SevaCategoryModel;
import com.jmk.bjjd.persistence.service.SevaCategoryPersistenceService;
import com.jmk.bjjd.persistence.sql.config.SpringSQLPersistenceConfig;
import com.jmk.bjjd.util.TimeUtility;

@ContextConfiguration(classes={SpringSQLPersistenceConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SQLSevaCategoryPersistenceServiceTest  {
	
	@Resource(name="sqlSevaCategoryPersistenceService")
	private SevaCategoryPersistenceService service;
	
	private List<SevaCategoryModel> sevaCategoryModels;
	
	@Before
	public void setUp(){
		sevaCategoryModels=new ArrayList<SevaCategoryModel>();
		sevaCategoryModels.add(new SevaCategoryModel("SVC01","Ankrit Day Seva","Internal Day Seva in Darbar"));
		sevaCategoryModels.add(new SevaCategoryModel("SVC02","Ankrit Night Seva","Internal Day Seva in Darbar"));
		sevaCategoryModels.add(new SevaCategoryModel("SVC03","Bahari Day Seva","External Night Seva in Darbar"));
		sevaCategoryModels.add(new SevaCategoryModel("SVC04","Bahari Night Seva","External Night Seva in Darbar"));
		sevaCategoryModels.add(new SevaCategoryModel("SVC05","Dhan Seva","Dhan Seva"));
		for(SevaCategoryModel sevaCategoryModel:sevaCategoryModels){
			sevaCategoryModel.setWhenCreated(TimeUtility.getSystemDate());
			sevaCategoryModel.setCreatedBy("BJJDJKYV0060");
			sevaCategoryModel.setWhenUpdated(TimeUtility.getSystemDate());
			sevaCategoryModel.setUpdatedBy("BJJDJKYV0060");
			sevaCategoryModel.setTenantId(9L);
		}
	}
	
	@Test
	@Ignore
	public void saveRecord() {
		sevaCategoryModels=service.saveRecords(sevaCategoryModels);
		Assert.assertNotNull(sevaCategoryModels);
	}

}
