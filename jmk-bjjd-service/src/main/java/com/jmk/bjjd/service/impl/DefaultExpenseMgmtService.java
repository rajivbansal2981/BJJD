package com.jmk.bjjd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jmk.bjjd.models.ExpenseModel;
import com.jmk.bjjd.persistence.service.ExpensePersistenceService;
import com.jmk.bjjd.service.ExpenseMgmtService;

@Service("expenseMgmtService")
public class DefaultExpenseMgmtService implements ExpenseMgmtService{
	
	@Resource(name="${persistenceservicetype}ExpensePersistenceService")
	private ExpensePersistenceService service;

	@Override
	public ExpenseModel saveRecord(ExpenseModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExpenseModel updateRecord(ExpenseModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExpenseModel> fetchAllRecordsByTenantId(Long tenantId) {
		return service.fetchAllRecordsByTenantId(tenantId);
	}

	@Override
	public void deleteRecordById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ExpenseModel findRecordByKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExpenseModel> saveRecords(List<ExpenseModel> records) {
		records=service.saveRecords(records);
		return records;
	}

	@Override
	public void deleteRecords(List<ExpenseModel> records) {
		// TODO Auto-generated method stub
		
	}

}
