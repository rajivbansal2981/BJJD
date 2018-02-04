package com.jmk.bjjd.persistence.nosql.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jmk.bjjd.models.ExpenseModel;
import com.jmk.bjjd.persistence.service.ExpensePersistenceService;

@Repository("noSQLExpensePersistenceService")
public class NoSQLExpensePersistenceService implements ExpensePersistenceService{

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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRecords(List<ExpenseModel> records) {
		// TODO Auto-generated method stub
		
	}

}
