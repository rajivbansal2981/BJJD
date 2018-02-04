package com.jmk.bjjd.persistence.sql.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jmk.bjjd.models.ExpenseModel;
import com.jmk.bjjd.persistence.config.SpringPersistenceConfig;
import com.jmk.bjjd.persistence.service.ExpensePersistenceService;

@ContextConfiguration(classes={SpringPersistenceConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
public class SQLExpensePersistenceServiceTest {
	
	@Resource(name="sqlExpensePersistenceService")
	private ExpensePersistenceService service;
	
	
	
	@Test
	public void saveRecords() {
			List<ExpenseModel> expenses=new ArrayList<ExpenseModel>();
			ExpenseModel expense=new ExpenseModel();
			expense.setId("123");
			expense.setAmount(56.00);
			expense.setDescription("Tables for Container in Bhandara(Funding by Kishan Fauji)"+
			"1. Paid to Ramnaresh Carpenter for wood and labour: Rs.10000"
			+"2. Paid for Paint:                                                                            Rs.  750"
			+"3. Fevicol,Buffer etc.                                                                   Rs. 460"
			+"4. Sunmica                                                                                        Rs. 1360");
			expense.setDate(new Date());
			expense.setDateString("01-Apr-2017");
			expense.setPaidTo("sfdsdf");
			expenses.add(expense);
			service.saveRecords(expenses);
	}
}
