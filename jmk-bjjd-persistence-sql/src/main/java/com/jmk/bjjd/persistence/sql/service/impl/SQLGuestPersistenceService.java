package com.jmk.bjjd.persistence.sql.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jmk.bjjd.models.GuestModel;
import com.jmk.bjjd.persistence.mapper.EntityModelMapper;
import com.jmk.bjjd.persistence.service.GuestPersistenceService;
import com.jmk.bjjd.persistence.sql.entities.GuestEntity;
import com.jmk.bjjd.persistence.sql.repository.GuestRepository;

@Transactional
@Repository("sqlGuestPersistenceService")
public class SQLGuestPersistenceService implements GuestPersistenceService {

	@Resource(name="entityModelMapper")
	private EntityModelMapper mapper;
	
	@Autowired
	private GuestRepository repository;
	
	@Override
	public GuestModel saveRecord(GuestModel model) {
		GuestEntity guestEntity=mapper.map(model,GuestEntity.class);
		guestEntity=repository.save(guestEntity);
		model=mapper.map(guestEntity,GuestModel.class);
		return model;
	}

	@Override
	public GuestModel updateRecord(GuestModel model) {
		GuestEntity guestEntity=mapper.map(model,GuestEntity.class);
		guestEntity=repository.save(guestEntity);
		model=mapper.map(guestEntity,GuestModel.class);
		return model;
	}

	@Override
	public List<GuestModel> fetchAllRecordsByTenantId(Long tenantId) {
		List<GuestEntity> guestEntities=repository.findAllByTenantId(tenantId);
		List<GuestModel> guestModels=mapper.map(guestEntities, GuestModel.class);
		return guestModels;
	}

	@Override
	public void deleteRecordById(String id) {
		repository.delete(id);
		
	}

	@Override
	public GuestModel findRecordByKey(String id) {
		GuestEntity guestEntity=repository.findOne(id);
		GuestModel model=mapper.map(guestEntity,GuestModel.class);
		return model;
	}

	@Override
	public List<GuestModel> saveRecords(List<GuestModel> records) {
		List<GuestEntity> guestEntities=mapper.map(records, GuestEntity.class);
		guestEntities=repository.save(guestEntities);
		records=mapper.map(guestEntities, GuestModel.class);
		return records;
	}

	@Override
	public void deleteRecords(List<GuestModel> records) {
		List<GuestEntity> guestEntities=mapper.map(records, GuestEntity.class);
		repository.delete(guestEntities);
	}
	
}
