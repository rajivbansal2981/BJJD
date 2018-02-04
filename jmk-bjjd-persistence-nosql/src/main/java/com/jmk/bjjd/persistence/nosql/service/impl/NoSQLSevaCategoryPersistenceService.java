package com.jmk.bjjd.persistence.nosql.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jmk.bjjd.models.SevaCategoryModel;
import com.jmk.bjjd.persistence.mapper.EntityModelMapper;
import com.jmk.bjjd.persistence.nosql.entities.SevaCategoryEntity;
import com.jmk.bjjd.persistence.nosql.repository.SevaCategoryRepository;
import com.jmk.bjjd.persistence.nosql.sequence.SequencePersistenceService;
import com.jmk.bjjd.persistence.service.SevaCategoryPersistenceService;

@Transactional
@Repository("noSQLSevaCategoryPersistenceService")
public class NoSQLSevaCategoryPersistenceService implements SevaCategoryPersistenceService {
	
	@Resource(name="noSQLSevaCategoryRepository")
	private SevaCategoryRepository repository;
	
	@Autowired
	private SequencePersistenceService sequencePersistenceService;
	
	@Autowired
	private EntityModelMapper mapper;

	@Override
	public SevaCategoryModel saveRecord(SevaCategoryModel model) {
		SevaCategoryEntity sevaCategoryEntity=mapper.map(model,SevaCategoryEntity.class);
		sequencePersistenceService.setNextSequenceIdForSingleEntity(sevaCategoryEntity);
		sevaCategoryEntity=repository.insert(sevaCategoryEntity);
		model=mapper.map(sevaCategoryEntity, SevaCategoryModel.class);
		return model;
	}

	@Override
	public SevaCategoryModel updateRecord(SevaCategoryModel model) {
		SevaCategoryEntity sevaCategoryEntity=mapper.map(model,SevaCategoryEntity.class);
		sevaCategoryEntity=repository.save(sevaCategoryEntity);
		model=mapper.map(sevaCategoryEntity, SevaCategoryModel.class);
		return model;
	}

	@Override
	public List<SevaCategoryModel> fetchAllRecordsByTenantId(Long tenantId) {
		List<SevaCategoryEntity> sevaCategoryEntities=repository.findAll();
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
		SevaCategoryModel sevaCategoryModel=mapper.map(sevaCategoryEntity, SevaCategoryModel.class);
		return sevaCategoryModel;
	}

	@Override
	public List<SevaCategoryModel> saveRecords(List<SevaCategoryModel> sevaCategoryModels) {
		List<SevaCategoryModel> sevaCategories=new ArrayList<SevaCategoryModel>();
		for(SevaCategoryModel sevaCategory:sevaCategoryModels){
			if(sevaCategory.getId()!=null){
				sevaCategories.add(saveRecord(sevaCategory));
			}else{
				sevaCategories.add(updateRecord(sevaCategory));
			}
		}
		
		List<SevaCategoryEntity> sevaCategoryEntities=mapper.map(sevaCategoryModels,SevaCategoryEntity.class);
		sequencePersistenceService.setNextSequenceIdForMultipleEntity(sevaCategoryEntities);
		sevaCategoryEntities=repository.insert(sevaCategoryEntities);
		sevaCategoryModels=mapper.map(sevaCategoryEntities, SevaCategoryModel.class);
		return null;
	}

	@Override
	public void deleteRecords(List<SevaCategoryModel> sevaCategoryModels) {
		List<SevaCategoryEntity> sevaCategoryEntities=mapper.map(sevaCategoryModels,SevaCategoryEntity.class);
		repository.delete(sevaCategoryEntities);
	}


}
