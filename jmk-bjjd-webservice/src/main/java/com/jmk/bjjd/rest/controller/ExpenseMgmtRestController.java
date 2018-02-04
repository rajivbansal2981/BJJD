package com.jmk.bjjd.rest.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jmk.bjjd.models.ExpenseModel;
import com.jmk.bjjd.service.ExpenseMgmtService;
import com.jmk.bjjd.util.constants.ExpenseURIConstants;

@RestController("expenseMgmtRestController")
public class ExpenseMgmtRestController {

	@Resource(name="expenseMgmtService")
	private ExpenseMgmtService service;
	
	@RequestMapping(value=ExpenseURIConstants.GET_EXPENSEDETAILS_BY_ID,method=RequestMethod.GET)
	public ExpenseModel getExpenseDetailsById(@PathVariable("id") String id){
		ExpenseModel model=service.findRecordByKey(id);
		return model;
	}
	
	@RequestMapping(value=ExpenseURIConstants.FETCH_ALL_EXPENSES_BY_TENANTID,method=RequestMethod.GET)
	public List<ExpenseModel> fetchAllExpenseDetailsByTenantId(@PathVariable("tenantId") Long tenantId){
		List<ExpenseModel> expenseModels=service.fetchAllRecordsByTenantId(tenantId);
		return expenseModels;
	}
	
	@RequestMapping(value=ExpenseURIConstants.SAVE_EXPENSE,method=RequestMethod.POST)
	public ExpenseModel saveExpense(@RequestBody ExpenseModel ExpenseModel){
		ExpenseModel=service.saveRecord(ExpenseModel);
		return ExpenseModel;
	}
	
	@RequestMapping(value=ExpenseURIConstants.SAVE_EXPENSES,method=RequestMethod.POST)
	public List<ExpenseModel> saveExpenses(@RequestBody List<ExpenseModel> expenseModels){
		expenseModels=service.saveRecords(expenseModels);
		return expenseModels;
	}
	
	@RequestMapping(value=ExpenseURIConstants.UPDATE_EXPENSE,method=RequestMethod.POST)
	public ExpenseModel updateExpense(@RequestBody ExpenseModel ExpenseModel){
		ExpenseModel=service.updateRecord(ExpenseModel);
		return ExpenseModel;
	}
	
	@RequestMapping(value=ExpenseURIConstants.UPDATE_EXPENSES,method=RequestMethod.POST)
	public void updateExpenses(@RequestBody List<ExpenseModel> ExpenseModels){
		service.saveRecords(ExpenseModels);
	}
	
	@RequestMapping(value=ExpenseURIConstants.DELETE_EXPENSE_BY_ID,method=RequestMethod.POST)
	public void deleteExpense(@RequestBody ExpenseModel ExpenseModel){
		service.deleteRecordById(ExpenseModel.getId());
	}
	
	@RequestMapping(value=ExpenseURIConstants.DELETE_EXPENSES,method=RequestMethod.POST)
	public void deleteExpenses(@RequestBody List<ExpenseModel> ExpenseModels){
		service.deleteRecords(ExpenseModels);
	}
	
}
