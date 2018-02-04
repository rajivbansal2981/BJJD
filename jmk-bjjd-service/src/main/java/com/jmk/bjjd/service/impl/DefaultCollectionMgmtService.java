package com.jmk.bjjd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jmk.bjjd.enums.PersonType;
import com.jmk.bjjd.models.CollectionModel;
import com.jmk.bjjd.persistence.service.CollectionPersistenceService;
import com.jmk.bjjd.service.CollectionMgmtService;

@Service("collectionMgmtService")
public class DefaultCollectionMgmtService implements CollectionMgmtService {

	@Resource(name="${persistenceservicetype}CollectionPersistenceService")
	private CollectionPersistenceService service;
	
	@Override
	public CollectionModel saveRecord(CollectionModel model) {
		return service.saveRecord(model);
	}

	@Override
	public CollectionModel updateRecord(CollectionModel model) {
		return service.updateRecord(model);
	}

	@Override
	public List<CollectionModel> fetchAllRecordsByTenantId(Long tenantId) {
		return service.fetchAllRecordsByTenantId(tenantId);
	}

	@Override
	public void deleteRecordById(String id) {
		 service.deleteRecordById(id);
	}

	@Override
	public CollectionModel findRecordByKey(String id) {
		return service.findRecordByKey(id);
	}

	@Override
	public List<CollectionModel> saveRecords(List<CollectionModel> records) {
		return service.saveRecords(records);
	}

	@Override
	public void deleteRecords(List<CollectionModel> records) {
		service.deleteRecords(records);
	}

	@Override
	public List<CollectionModel> findAllCollectionByMemberId(String memberId) {
		return service.findAllCollectionByMemberId(memberId);
	}

	@Override
	public List<CollectionModel> findAllCollectionByGuestId(String guestId) {
		return service.findAllCollectionByGuestId(guestId);
	}

	@Override
	public List<CollectionModel> findAllCollectionByPersonTypeAndTenantId(PersonType type,Long tenantId) {
		return service.findAllCollectionByPersonTypeAndTenantId(type,tenantId);
	}


}
