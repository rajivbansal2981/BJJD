package com.jmk.bt.persistence.nosql.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jmk.bjjd.persistence.nosql.config.SequenceId;
import com.jmk.bjjd.persistence.nosql.config.SpringNoSQLPersistenceConfig;
import com.jmk.bjjd.persistence.nosql.sequence.Sequence;
import com.jmk.bjjd.persistence.nosql.sequence.SequencePersistenceService;

@ContextConfiguration(classes={SpringNoSQLPersistenceConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
public class NoSQLSequencePersistenceServiceTest {

	@Autowired
	private SequencePersistenceService service;
	
	private List<Sequence> sequences;
	
	@Before
	public void setup(){
		sequences=new ArrayList<Sequence>();
		sequences.add(new Sequence(SequenceId.MEMBER.value(),0,"BJJDJKYV",4));
		sequences.add(new Sequence(SequenceId.GUEST.value(),0,"GST",4));
		sequences.add(new Sequence(SequenceId.USER.value(),0,"USER",4));
		sequences.add(new Sequence(SequenceId.COLLECTION.value(),0,"COL",8));
		sequences.add(new Sequence(SequenceId.SEVA.value(),0,"SV",7));
		sequences.add(new Sequence(SequenceId.SEVA_CATEGORY.value(),0,"SVC",2));
	}
	
	@Test
	public void initilizeSequence(){
		service.initializeSequences(sequences);
	}
	
	
}
