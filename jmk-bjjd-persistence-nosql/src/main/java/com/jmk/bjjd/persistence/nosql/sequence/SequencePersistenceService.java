package com.jmk.bjjd.persistence.nosql.sequence;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.jmk.bjjd.persistence.nosql.config.SequenceId;
import com.jmk.bjjd.persistence.nosql.entities.BaseEntity;
import com.jmk.bjjd.persistence.nosql.entities.CollectionEntity;
import com.jmk.bjjd.persistence.nosql.entities.GuestEntity;
import com.jmk.bjjd.persistence.nosql.entities.MemberEntity;
import com.jmk.bjjd.persistence.nosql.entities.SevaCategoryEntity;
import com.jmk.bjjd.persistence.nosql.entities.SevaEntity;
import com.jmk.bjjd.persistence.nosql.entities.UserEntity;

@Repository
public class SequencePersistenceService {

	@Autowired
	private MongoTemplate template;
	
	public void setNextSequenceIdForSingleEntity(BaseEntity baseEntity) {
		String id = baseEntity.getId();
		if (id == null) {

			id = getIdByEntity(baseEntity);
			// get sequence id
			Query query = new Query(Criteria.where("_id").is(id));

			// increase sequence id by 1
			Update update = new Update();
			update.inc("seqvalue", 1);

			// return new increased id
			FindAndModifyOptions findAndModifyOptions = new FindAndModifyOptions();
			findAndModifyOptions.returnNew(true);
			// this is the magic happened.
			Sequence sequence = template.findAndModify(query, update,
					findAndModifyOptions, Sequence.class);

			// if no id, throws SequenceException
			// optional, just a way to tell user when the sequence id is failed
			// to generate.
			if (sequence == null) {
				throw new SequenceException(
						"Sequence Number does not exist for the given key");
			}
			baseEntity.setId(prepareSequenceId(sequence));
		}
	}
	
	public void setNextSequenceIdForMultipleEntity(List<? extends BaseEntity> baseEntities){
		for(BaseEntity baseEntity:baseEntities){
			setNextSequenceIdForSingleEntity(baseEntity);
		}
	}
	
	private String prepareSequenceId(Sequence sequence){
		String sequenceValue=StringUtils.leftPad(String.valueOf(sequence.getSequenceValue()),sequence.getSequenceLength(),'0');
		String sequenceId=sequence.getSequencePrefix().concat(sequenceValue);
		return sequenceId;
	}
	
	
	/**
	 * Get the key based on that we will retrieve key
	 * @param baseEntity
	 * @return
	 */
	private String getIdByEntity(BaseEntity baseEntity){
		if(baseEntity.getClass()==UserEntity.class){
			return SequenceId.USER.value();
		}
		
		if(baseEntity.getClass()==MemberEntity.class){
			return SequenceId.MEMBER.value();
		}
		
		if(baseEntity.getClass()==GuestEntity.class){
			return SequenceId.GUEST.value();
		}
		
		if(baseEntity.getClass()==CollectionEntity.class){
			return SequenceId.COLLECTION.value();
		}
		
		if(baseEntity.getClass()==SevaCategoryEntity.class){
			return SequenceId.SEVA_CATEGORY.value();
		}
		
		if(baseEntity.getClass()==SevaEntity.class){
			return SequenceId.SEVA.value();
		}
		
		return null;
	}
	
	public void initializeSequences(List<Sequence> sequences){
		template.insertAll(sequences);
	}
	
}
