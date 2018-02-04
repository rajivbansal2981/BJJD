package com.jmk.bjjd.persistence.sql.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jmk.bjjd.models.SevaCategoryModel;
import com.jmk.bjjd.persistence.mapper.EntityModelMapper;
import com.jmk.bjjd.persistence.service.SevaCategoryPersistenceService;
import com.jmk.bjjd.persistence.sql.entities.SevaCategoryEntity;
import com.jmk.bjjd.persistence.sql.repository.SevaCategoryRepository;

@Transactional
@Repository("sqlSevaCategoryPersistenceService")
public class SQLSevaCategoryPersistenceService implements SevaCategoryPersistenceService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Resource(name="entityModelMapper")
	private EntityModelMapper mapper;
	
	@Autowired
	private SevaCategoryRepository repository;
	
	@Override
	public SevaCategoryModel saveRecord(SevaCategoryModel model) {
		SevaCategoryEntity sevaCategoryEntity=mapper.map(model,SevaCategoryEntity.class);
	//	sevaCategoryEntity=entityManager.merge(sevaCategoryEntity);
		sevaCategoryEntity=repository.save(sevaCategoryEntity);
		model=mapper.map(sevaCategoryEntity,SevaCategoryModel.class);
		return model;
	}

	@Override
	public SevaCategoryModel updateRecord(SevaCategoryModel model) {
		SevaCategoryEntity sevaCategoryEntity=mapper.map(model,SevaCategoryEntity.class);
		sevaCategoryEntity=entityManager.merge(sevaCategoryEntity);
		model=mapper.map(sevaCategoryEntity,SevaCategoryModel.class);
		return model;
	}

	@Override
	public List<SevaCategoryModel> fetchAllRecordsByTenantId(Long tenantId) {
		List<SevaCategoryEntity> sevaCategoryEntities=repository.findAllByTenantId(tenantId);
		List<SevaCategoryModel> sevaCategoryModels=mapper.map(sevaCategoryEntities, SevaCategoryModel.class);
		return sevaCategoryModels;
	}

	@Override
	public void deleteRecordById(String id) {
		repository.delete(id);
	}

	@Override
	public SevaCategoryModel findRecordByKey(String id) {
		SevaCategoryEntity sevaCategoryEntity=repository.findOne(id);
		SevaCategoryModel sevaCategoryModel=mapper.map(sevaCategoryEntity,SevaCategoryModel.class);
		return sevaCategoryModel;
	}

	@Override
	public List<SevaCategoryModel> saveRecords(List<SevaCategoryModel> records) {
		List<SevaCategoryEntity> sevaCategoryEntities=mapper.map(records,SevaCategoryEntity.class);
		sevaCategoryEntities=repository.save(sevaCategoryEntities);
		List<SevaCategoryModel> sevaCategoryModels=mapper.map(sevaCategoryEntities, SevaCategoryModel.class);
		return sevaCategoryModels;
	}

	@Override
	public void deleteRecords(List<SevaCategoryModel> records) {
		List<SevaCategoryEntity> sevaCategoryEntities=mapper.map(records,SevaCategoryEntity.class);
		repository.delete(sevaCategoryEntities);
	}

	
	
}
