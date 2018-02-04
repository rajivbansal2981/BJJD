package com.jmk.bjjd.persistence.sql.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jmk.bjjd.models.ExpenseModel;
import com.jmk.bjjd.persistence.mapper.EntityModelMapper;
import com.jmk.bjjd.persistence.service.ExpensePersistenceService;
import com.jmk.bjjd.persistence.sql.entities.ExpenseEntity;
import com.jmk.bjjd.persistence.sql.repository.ExpenseRepository;

@Transactional
@Repository("sqlExpensePersistenceService")
public class SQLExpensePersistenceService implements ExpensePersistenceService{
	
	@Resource(name="entityModelMapper")
	private EntityModelMapper mapper;
	
	@Autowired
	private ExpenseRepository repository;

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
		List<ExpenseEntity> expenseEntities=repository.findAll();
		List<ExpenseModel> expenseModels=mapper.map(expenseEntities,ExpenseModel.class);
		return expenseModels;
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
		List<ExpenseEntity> expenseEntities=mapper.map(records,ExpenseEntity.class);
		expenseEntities=repository.save(expenseEntities);
		records=mapper.map(expenseEntities,ExpenseModel.class);
		return records;
	}

	@Override
	public void deleteRecords(List<ExpenseModel> records) {
		// TODO Auto-generated method stub
		
	}

}
