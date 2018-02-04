package com.jmk.bt.persistence.nosql.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jmk.bjjd.enums.PersonType;
import com.jmk.bjjd.models.CollectionModel;
import com.jmk.bjjd.persistence.nosql.config.SpringNoSQLPersistenceConfig;
import com.jmk.bjjd.persistence.service.CollectionPersistenceService;
import com.jmk.bjjd.util.testdata.NoSQLTestDataUtil;

@ContextConfiguration(classes={SpringNoSQLPersistenceConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
public class NoSQLCollectionPersistenceServiceTest {

	@Resource(name="noSQLCollectionPersistenceService")
	private CollectionPersistenceService service;
	
	private  List<CollectionModel> collections;
	
	@Before
	public void setUp(){
		collections=NoSQLTestDataUtil.createCollection();
		service.saveRecords(collections);
	}
	
	@Test
	public void fetchCollectionRecords(){
		collections=service.fetchAllRecordsByTenantId(12L);
		Assert.assertNotNull(collections);
	}
	
	@Test
	public void findAllCollectionByMemberId(){
		List<CollectionModel> collections=service.findAllCollectionByMemberId("-99999");
		Assert.assertNotNull(collections);
	}
	
	@Test
	public void findAllCollectionByGuestId(){
		List<CollectionModel> collections=service.findAllCollectionByGuestId("-11111");
		Assert.assertNotNull(collections);
	}
	
	@Test
	public void findAllCollectionByPersonType(){
		List<CollectionModel> collections=service.findAllCollectionByPersonTypeAndTenantId(PersonType.MEMBER,12L);
		Assert.assertNotNull(collections);
	}
	
	@After
	public  void destroy(){
		service.deleteRecords(collections);
	}
	
}
