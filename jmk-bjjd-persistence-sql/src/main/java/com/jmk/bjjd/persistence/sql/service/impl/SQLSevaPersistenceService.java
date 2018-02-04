package com.jmk.bjjd.persistence.sql.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jmk.bjjd.models.SevaModel;
import com.jmk.bjjd.persistence.mapper.EntityModelMapper;
import com.jmk.bjjd.persistence.service.SevaPersistenceService;
import com.jmk.bjjd.persistence.sql.entities.SevaEntity;
import com.jmk.bjjd.persistence.sql.repository.SevaRepository;

@Transactional
@Repository("sqlSevaPersistenceService")
public class SQLSevaPersistenceService implements SevaPersistenceService {

	@Resource(name="entityModelMapper")
	private EntityModelMapper mapper;
	
	@Autowired
	private SevaRepository repository;
	
	@Override
	public SevaModel saveRecord(SevaModel model) {
		SevaEntity sevaEntity=mapper.map(model,SevaEntity.class);
		sevaEntity=repository.save(sevaEntity);
		model=mapper.map(sevaEntity,SevaModel.class);
		return model;
	}

	@Override
	public SevaModel updateRecord(SevaModel model) {
		SevaEntity sevaEntity=mapper.map(model,SevaEntity.class);
		sevaEntity=repository.save(sevaEntity);
		model=mapper.map(sevaEntity,SevaModel.class);
		return model;
	}

	@Override
	public List<SevaModel> fetchAllRecordsByTenantId(Long tenantId) {
		List<SevaEntity> sevaEntities=repository.findAllByTenantId(tenantId);
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
		SevaModel sevaModel=mapper.map(sevaEntity,SevaModel.class);
		return sevaModel;
	}

	@Override
	public List<SevaModel> saveRecords(List<SevaModel> records) {
		List<SevaEntity> sevaEntities=mapper.map(records,SevaEntity.class);
		sevaEntities=repository.save(sevaEntities);
		records=mapper.map(sevaEntities, SevaModel.class);
		return records;
	}

	@Override
	public void deleteRecords(List<SevaModel> records) {
		List<SevaEntity> sevaEntities=mapper.map(records,SevaEntity.class);
		repository.delete(sevaEntities);		
	}
	
}
