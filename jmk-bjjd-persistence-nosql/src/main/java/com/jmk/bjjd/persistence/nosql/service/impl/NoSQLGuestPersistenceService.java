package com.jmk.bjjd.persistence.nosql.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jmk.bjjd.models.GuestModel;
import com.jmk.bjjd.persistence.mapper.EntityModelMapper;
import com.jmk.bjjd.persistence.nosql.entities.GuestEntity;
import com.jmk.bjjd.persistence.nosql.repository.GuestRepository;
import com.jmk.bjjd.persistence.nosql.sequence.SequencePersistenceService;
import com.jmk.bjjd.persistence.service.GuestPersistenceService;

@Transactional
@Repository("noSQLGuestPersistenceService")
public class NoSQLGuestPersistenceService implements GuestPersistenceService {

	@Resource(name="noSQLGuestRepository")
	private GuestRepository repository;
	
	@Autowired
	private EntityModelMapper mapper;
	
	@Autowired
	private SequencePersistenceService sequencePersistenceService;
	
	@Override
	public GuestModel saveRecord(GuestModel guestModel) {
		GuestEntity guestEntity=mapper.map(guestModel,GuestEntity.class);
		sequencePersistenceService.setNextSequenceIdForSingleEntity(guestEntity);
		guestEntity=repository.insert(guestEntity);
		guestModel=mapper.map(guestEntity, GuestModel.class);
		return guestModel;
	}
	
	@Override
	public List<GuestModel> saveRecords(List<GuestModel> guestModels) {
		List<GuestEntity> guestEntities=mapper.map(guestModels, GuestEntity.class);
		sequencePersistenceService.setNextSequenceIdForMultipleEntity(guestEntities);
		guestEntities=repository.insert(guestEntities);
		guestModels=mapper.map(guestEntities, GuestModel.class);
		return guestModels;
	}


	@Override
	public GuestModel updateRecord(GuestModel guestModel) {
		GuestEntity guestEntity=mapper.map(guestModel,GuestEntity.class);
		guestEntity=repository.save(guestEntity);
		guestModel=mapper.map(guestEntity, GuestModel.class);
		return guestModel;
	}

	@Override
	public List<GuestModel> fetchAllRecordsByTenantId(Long tenantId) {
		List<GuestEntity> guestEntities=repository.findAll();
		List<GuestModel> guestModels=mapper.map(guestEntities, GuestModel.class);
		return guestModels;
	}

	@Override
	public void deleteRecordById(String id) {
		repository.delete(id);
	}

	@Override
	public GuestModel findRecordByKey(String id) {
		GuestEntity guestEntity= repository.findOne(id);
		GuestModel guestModel=mapper.map(guestEntity, GuestModel.class);
		return guestModel;
	}

	
	@Override
	public void deleteRecords(List<GuestModel> guestModels) {
		List<GuestEntity> guestEntities=mapper.map(guestModels, GuestEntity.class);
		repository.delete(guestEntities);
	}

}
