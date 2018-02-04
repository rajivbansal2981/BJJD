package com.jmk.bjjd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jmk.bjjd.models.SevaModel;
import com.jmk.bjjd.persistence.service.SevaPersistenceService;
import com.jmk.bjjd.service.SevaMgmtService;

@Service("sevaMgmtService")
public class DefaultSevaMgmtService implements SevaMgmtService{
	
	@Resource(name="${persistenceservicetype}SevaPersistenceService")
	private SevaPersistenceService service;

	@Override
	public SevaModel saveRecord(SevaModel model) {
		model=service.saveRecord(model);
		return model;
	}

	@Override
	public SevaModel updateRecord(SevaModel model) {
		model=service.updateRecord(model);
		return model;
	}

	@Override
	public List<SevaModel> fetchAllRecordsByTenantId(Long tenantId) {
		return service.fetchAllRecordsByTenantId(tenantId);
	}

	@Override
	public void deleteRecordById(String id) {
		service.deleteRecordById(id);
	}

	@Override
	public SevaModel findRecordByKey(String id) {
		return service.findRecordByKey(id);
	}

	@Override
	public List<SevaModel> saveRecords(List<SevaModel> records) {
		return service.saveRecords(records);
	}

	@Override
	public void deleteRecords(List<SevaModel> records) {
		service.deleteRecords(records);
	}

}
