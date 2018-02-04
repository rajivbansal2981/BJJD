package com.jmk.bjjd.persistence.nosql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.jmk.bjjd.enums.PersonType;
import com.jmk.bjjd.models.CollectionModel;
import com.jmk.bjjd.persistence.mapper.EntityModelMapper;
import com.jmk.bjjd.persistence.nosql.entities.CollectionEntity;
import com.jmk.bjjd.persistence.nosql.repository.CollectionRespository;
import com.jmk.bjjd.persistence.nosql.sequence.SequencePersistenceService;
import com.jmk.bjjd.persistence.service.CollectionPersistenceService;

@Repository("noSQLCollectionPersistenceService")
public class NoSQLCollectionPersistenceService implements CollectionPersistenceService {

	@Autowired
	private CollectionRespository repository;
	
	@Autowired
	private EntityModelMapper mapper;
	
	@Autowired
	private MongoTemplate template;
	
	@Autowired
	private SequencePersistenceService sequencePersistenceService;
	
	
	public CollectionModel saveRecord(CollectionModel collectionModel) {
		CollectionEntity collectionEntity=mapper.map(collectionModel,CollectionEntity.class);
		sequencePersistenceService.setNextSequenceIdForSingleEntity(collectionEntity);
		collectionEntity= repository.insert(collectionEntity);
		collectionModel=mapper.map(collectionEntity,CollectionModel.class);
		return collectionModel;
	}
	
	@Override
	public List<CollectionModel> saveRecords(List<CollectionModel> collectionModels) {
		List<CollectionEntity> collectionEntities=mapper.map(collectionModels, CollectionEntity.class);
		sequencePersistenceService.setNextSequenceIdForMultipleEntity(collectionEntities);
		collectionEntities= repository.insert(collectionEntities);
		collectionModels=mapper.map(collectionEntities,CollectionModel.class);
		return collectionModels;
	}

	@Override
	public CollectionModel updateRecord(CollectionModel collectionModel) {
		CollectionEntity collectionEntity=mapper.map(collectionModel,CollectionEntity.class);
		collectionEntity=repository.save(collectionEntity);
		collectionModel=mapper.map(collectionEntity,CollectionModel.class);
		return collectionModel;
	}

	@Override
	public List<CollectionModel> fetchAllRecordsByTenantId(Long tenantId) {
		List<CollectionEntity> collectionEntities= repository.findAll();
		List<CollectionModel> collectionModels=mapper.map(collectionEntities,CollectionModel.class);
		return collectionModels;
	}

	@Override
	public void deleteRecordById(String id) {
		repository.delete(id);
	}
	
	@Override
	public void deleteRecords(List<CollectionModel> collectionModels) {
		List<CollectionEntity> collectionEntities=mapper.map(collectionModels, CollectionEntity.class);
		repository.delete(collectionEntities);
	}

	@Override
	public CollectionModel findRecordByKey(String id) {
		CollectionEntity collectionEntity=repository.findOne(id);
		CollectionModel collectionModel=mapper.map(collectionEntity,CollectionModel.class);
		return collectionModel;
	}

	@Override
	public List<CollectionModel> findAllCollectionByMemberId(String memberId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("member.$id").is(memberId));
		List<CollectionEntity> collectionEntities=template.find(query, CollectionEntity.class);
		List<CollectionModel> collectionModels=mapper.map(collectionEntities,CollectionModel.class);
		return collectionModels;
	}

	@Override
	public List<CollectionModel> findAllCollectionByGuestId(String guestId) {
		List<CollectionEntity> collectionEntities=repository.findAllCollectionByGuestId(guestId);
		List<CollectionModel> collectionModels=mapper.map(collectionEntities,CollectionModel.class);
		return collectionModels;
	}

	@Override
	public List<CollectionModel> findAllCollectionByPersonTypeAndTenantId(PersonType type,Long tenantId) {
		List<CollectionEntity> collectionEntities=repository.findAllCollectionByPersonType(type);
		List<CollectionModel> collectionModels=mapper.map(collectionEntities,CollectionModel.class);
		return collectionModels;
	}

}
