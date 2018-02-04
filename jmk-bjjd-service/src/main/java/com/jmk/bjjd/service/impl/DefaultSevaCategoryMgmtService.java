package com.jmk.bjjd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jmk.bjjd.models.SevaCategoryModel;
import com.jmk.bjjd.persistence.service.SevaCategoryPersistenceService;
import com.jmk.bjjd.service.SevaCategoryMgmtService;

@Service("sevaCategoryMgmtService")
public class DefaultSevaCategoryMgmtService implements SevaCategoryMgmtService{
	
	@Resource(name="${persistenceservicetype}SevaCategoryPersistenceService")
	private SevaCategoryPersistenceService service;

	@Override
	public SevaCategoryModel saveRecord(SevaCategoryModel model) {
		return service.saveRecord(model);
	}

	@Override
	public SevaCategoryModel updateRecord(SevaCategoryModel model) {
		return service.updateRecord(model);
	}

	@Override
	public List<SevaCategoryModel> fetchAllRecordsByTenantId(Long tenantId) {
		return service.fetchAllRecordsByTenantId(tenantId);
	}

	@Override
	public void deleteRecordById(String id) {
		service.deleteRecordById(id);
	}

	@Override
	public SevaCategoryModel findRecordByKey(String id) {
		return service.findRecordByKey(id);
	}

	@Override
	public List<SevaCategoryModel> saveRecords(List<SevaCategoryModel> records) {
		return service.saveRecords(records);
	}

	@Override
	public void deleteRecords(List<SevaCategoryModel> records) {
		service.deleteRecords(records);
	}

	
}
