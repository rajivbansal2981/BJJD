package com.jmk.bjjd.persistence.nosql.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jmk.bjjd.models.SevaModel;
import com.jmk.bjjd.persistence.mapper.EntityModelMapper;
import com.jmk.bjjd.persistence.nosql.entities.SevaEntity;
import com.jmk.bjjd.persistence.nosql.repository.SevaRepository;
import com.jmk.bjjd.persistence.nosql.sequence.SequencePersistenceService;
import com.jmk.bjjd.persistence.service.SevaPersistenceService;

@Transactional
@Repository("noSQLSevaPersistenceService")
public class NoSQLSevaPersistenceService implements SevaPersistenceService {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Resource(name="noSQLSevaRepository")
	private SevaRepository repository;
	
	@Autowired
	private EntityModelMapper mapper;
	
	@Autowired
	private SequencePersistenceService sequencePersistenceService;

	@Override
	public SevaModel saveRecord(SevaModel sevaModel) {
		SevaEntity sevaEntity=mapper.map(sevaModel,SevaEntity.class);
		sequencePersistenceService.setNextSequenceIdForSingleEntity(sevaEntity);
		sevaEntity=repository.insert(sevaEntity);
		sevaModel=mapper.map(sevaEntity, SevaModel.class);
		return sevaModel;
	}

	@Override
	public SevaModel updateRecord(SevaModel sevaModel) {
		SevaEntity sevaEntity=mapper.map(sevaModel,SevaEntity.class);
		sequencePersistenceService.setNextSequenceIdForSingleEntity(sevaEntity);
		sevaEntity=repository.save(sevaEntity);
		sevaModel=mapper.map(sevaEntity, SevaModel.class);
		return sevaModel;
	}

	@Override
	public List<SevaModel> fetchAllRecordsByTenantId(Long tenantId) {
		List<SevaEntity> sevaEntities=repository.findAll();
		List<SevaModel> sevaModels=mapper.map(sevaEntities, SevaModel.class);
		return sevaModels;
	}

	@Override
	public void deleteRecordById(String id) {
		repository.delete(id);
	}

	@Override
	public SevaModel findRecordByKey(String id) {
		SevaEntity sevaEntity=repository.findOne(id);
		SevaModel sevaModel=mapper.map(sevaEntity, SevaModel.class);
		return sevaModel;
	}

	@Override
	public List<SevaModel> saveRecords(List<SevaModel> sevaModels) {
		List<SevaEntity> sevaEntities=mapper.map(sevaModels, SevaEntity.class);
		sequencePersistenceService.setNextSequenceIdForMultipleEntity(sevaEntities);
		sevaEntities=repository.save(sevaEntities);
		sevaModels=mapper.map(sevaEntities, SevaModel.class);
		return sevaModels;
	}

	@Override
	public void deleteRecords(List<SevaModel> sevaModels) {
		List<SevaEntity> sevaEntities=mapper.map(sevaModels, SevaEntity.class);	
		repository.delete(sevaEntities);
	}
	
}
