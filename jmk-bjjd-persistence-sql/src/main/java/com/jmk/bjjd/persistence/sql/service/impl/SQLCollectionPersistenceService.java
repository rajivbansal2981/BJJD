package com.jmk.bjjd.persistence.sql.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jmk.bjjd.enums.PersonType;
import com.jmk.bjjd.models.CollectionModel;
import com.jmk.bjjd.persistence.service.CollectionPersistenceService;

@Repository("sqlCollectionPersistenceService")
public class SQLCollectionPersistenceService implements CollectionPersistenceService {

	@Override
	public CollectionModel saveRecord(CollectionModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionModel updateRecord(CollectionModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CollectionModel> fetchAllRecordsByTenantId(Long tenantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRecordById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CollectionModel findRecordByKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CollectionModel> saveRecords(List<CollectionModel> records) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRecords(List<CollectionModel> records) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CollectionModel> findAllCollectionByMemberId(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CollectionModel> findAllCollectionByGuestId(String guestId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CollectionModel> findAllCollectionByPersonTypeAndTenantId(PersonType type,
			Long tenantId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
