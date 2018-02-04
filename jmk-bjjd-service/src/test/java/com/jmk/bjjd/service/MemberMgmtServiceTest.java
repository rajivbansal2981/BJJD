package com.jmk.bjjd.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.commons.lang.SerializationUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jmk.bjjd.models.MemberModel;
import com.jmk.bjjd.models.SevaModel;
import com.jmk.bjjd.service.config.SpringServiceConfig;

@ContextConfiguration(classes=SpringServiceConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
public class MemberMgmtServiceTest {
	
	@Autowired
	private MemberMgmtService memberMgmtService;
	
	@Test
	@Ignore
	public void saveMemberRecord() throws FileNotFoundException {
		MemberModel memberModel=(MemberModel)SerializationUtils.deserialize(new FileInputStream("F:\\Member1.ser"));
		memberModel.setId(null);
		memberModel.getMailingAddress().setMember(memberModel);
		for(SevaModel sevaModel:memberModel.getSevas()){
			sevaModel.setMember(memberModel);
		}
		memberModel=memberMgmtService.saveRecord(memberModel);
	}
}
