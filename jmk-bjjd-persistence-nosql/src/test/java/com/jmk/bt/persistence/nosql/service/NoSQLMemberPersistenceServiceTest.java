package com.jmk.bt.persistence.nosql.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jmk.bjjd.models.MemberModel;
import com.jmk.bjjd.persistence.nosql.config.SpringNoSQLPersistenceConfig;
import com.jmk.bjjd.persistence.service.MemberPersistenceService;
import com.jmk.bjjd.util.testdata.NoSQLTestDataUtil;

@ContextConfiguration(classes={SpringNoSQLPersistenceConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
public class NoSQLMemberPersistenceServiceTest {

	@Resource(name="noSQLMemberPersistenceService")
	private MemberPersistenceService service;
	
	private MemberModel member;
	
	private static String memberId="-9999999";
	
	/**
	 * To include all test scenario into one test to maintain the order of test methods
	 * we can use alternative approach as well by putting the annotation i.e. @FixMethodOrder(MethodSorters.NAME_ASCENDING)
	 */
	@Test
	public void testMemberPersistenceService(){
		saveMember();
		updateMember();
		fetchMemberRecords();
		deleteMember();
	}
	
	private void saveMember(){
		member=NoSQLTestDataUtil.createMember(memberId);
		member=service.saveRecord(member);
		System.out.println(member);
		Assert.assertNotNull(member);
	}
	
	private void updateMember(){
		member=updateMemberRecord();
		member=service.updateRecord(member);
		Assert.assertNotNull(member);
	}

	private void fetchMemberRecords(){
		List<MemberModel> members=service.fetchAllRecordsByTenantId(12L);
		Assert.assertNotNull(members);
	}
	
	private void deleteMember(){
		service.deleteRecordById(memberId);
		Assert.assertNull(service.findRecordByKey(memberId));
	}
	
	
	private MemberModel updateMemberRecord(){
		member.setAge(12);;
		return member;
	}
	
}
