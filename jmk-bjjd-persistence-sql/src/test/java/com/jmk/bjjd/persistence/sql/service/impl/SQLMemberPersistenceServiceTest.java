package com.jmk.bjjd.persistence.sql.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jmk.bjjd.models.MemberModel;
import com.jmk.bjjd.persistence.service.MemberPersistenceService;
import com.jmk.bjjd.persistence.sql.config.SpringSQLPersistenceConfig;
import com.jmk.bjjd.util.testdata.SQLTestDataUtil;

@ContextConfiguration(classes = { SpringSQLPersistenceConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class SQLMemberPersistenceServiceTest {

	@Resource(name = "sqlMemberPersistenceService")
	private MemberPersistenceService service;

	private MemberModel member;

	private static String memberId = "-99949919";

	@Test
	@Ignore
	public void testMemberPersistenceService() {
		saveMember();
	//	getTeamLeadersByTenantId();
	//	updateMember();
	//	fetchMemberRecords();
		deleteMember();
	}
	
	@Test
	@Ignore
	public void findMemberRecord() {
		MemberModel member = service.findRecordByKey("213213");
		Assert.assertNotNull(member);
	}

	private void saveMember() {
		member = SQLTestDataUtil.createMember(memberId);
		member = service.saveRecord(member);
		System.out.println(member);
		Assert.assertNotNull(member);
	}
	
	private void getTeamLeadersByTenantId() {
		List<MemberModel> teamLeaders=service.findTeamLeadersByTenantId(9L);
		Assert.assertNotNull(teamLeaders);
	}

	private void updateMember() {
		member = updateMemberRecord();
		member = service.updateRecord(member);
		Assert.assertNotNull(member);
	}

	private void fetchMemberRecords() {
		List<MemberModel> members = service.fetchAllRecordsByTenantId(12L);
		Assert.assertNotNull(members);
	}
	
	private void deleteMember() {
		service.deleteRecordById(memberId);
		Assert.assertNull(service.findRecordByKey(memberId));
	}

	private MemberModel updateMemberRecord() {
		member.setAge(12);
		member.setVersion(2L);
		return member;
	}

}
