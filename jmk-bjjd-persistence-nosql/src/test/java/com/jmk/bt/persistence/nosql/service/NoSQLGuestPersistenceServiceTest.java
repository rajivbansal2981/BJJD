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

import com.jmk.bjjd.models.GuestModel;
import com.jmk.bjjd.persistence.nosql.config.SpringNoSQLPersistenceConfig;
import com.jmk.bjjd.persistence.service.GuestPersistenceService;
import com.jmk.bjjd.util.testdata.NoSQLTestDataUtil;

@ContextConfiguration(classes={SpringNoSQLPersistenceConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
public class NoSQLGuestPersistenceServiceTest {

	@Resource(name="noSQLGuestPersistenceService")
	private GuestPersistenceService service;
	
	private List<GuestModel> guests;
	
	@Before
	public void setup(){
		guests=NoSQLTestDataUtil.createGuests();
		service.saveRecords(guests);
	}
	
	@Test
	public void fetchGuestRecords(){
		List<GuestModel> guests=service.fetchAllRecordsByTenantId(12L);
		Assert.assertNotNull(guests);
	}
	
	@After
	public void destroy(){
		service.deleteRecords(guests);
	}
	
}
