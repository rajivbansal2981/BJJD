package com.jmk.bjjd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jmk.bjjd.models.GuestModel;
import com.jmk.bjjd.persistence.service.GuestPersistenceService;
import com.jmk.bjjd.service.GuestMgmtService;

@Service("guestMgmtService")
public class DefaultGuestMgmtService implements GuestMgmtService{
	
	@Resource(name="${persistenceservicetype}GuestPersistenceService")
	private GuestPersistenceService service;

	@Override
	public GuestModel saveRecord(GuestModel model) {
		return service.saveRecord(model);
	}

	@Override
	public GuestModel updateRecord(GuestModel model) {
		return service.updateRecord(model);
	}

	@Override
	public List<GuestModel> fetchAllRecordsByTenantId(Long tenantId) {
		return service.fetchAllRecordsByTenantId(tenantId);
	}

	@Override
	public void deleteRecordById(String id) {
		service.deleteRecordById(id);
	}

	@Override
	public GuestModel findRecordByKey(String id) {
		return service.findRecordByKey(id);
	}

	@Override
	public List<GuestModel> saveRecords(List<GuestModel> records) {
		return service.saveRecords(records);
	}

	@Override
	public void deleteRecords(List<GuestModel> records) {
		// TODO Auto-generated method stub
		
	}
	
}
