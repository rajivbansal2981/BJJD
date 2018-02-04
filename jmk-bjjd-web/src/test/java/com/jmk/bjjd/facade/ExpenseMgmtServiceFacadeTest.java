package com.jmk.bjjd.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jmk.bjjd.models.ExpenseModel;
import com.jmk.bjjd.web.config.SpringWebMvcConfig;
import com.jmk.bjjd.web.facade.ExpenseMgmtServiceFacade;



@ContextConfiguration(classes={SpringWebMvcConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ExpenseMgmtServiceFacadeTest {

	@Autowired
	private ExpenseMgmtServiceFacade serviceFacade;
	
	
	@Test
	@Ignore
	public void saveExpenseRecords(){
		List<ExpenseModel> expenses=new ArrayList<ExpenseModel>();
		ExpenseModel expense=new ExpenseModel();
		expense.setId("2312233");
		expense.setAmount(56.00);
		expense.setDescription("Tables for Container in Bhandara(Funding by Kishan Fauji)"+
		"1. Paid to Ramnaresh Carpenter for wood and labour: Rs.10000"
		+"2. Paid for Paint:                                                                            Rs.  750"
		+"3. Fevicol,Buffer etc.                                                                   Rs. 460"
		+"4. Sunmica                                                                                        Rs. 1360");
		expense.setDate(new Date());
		expense.setPaidTo("sfdsdf");
		expenses.add(expense);
		expenses=serviceFacade.saveRecords(expenses);
		Assert.assertNotNull(expenses);
	}
	
	@Test
	@Ignore
	public void fetchExpenseRecords(){
		List<ExpenseModel> expenses=serviceFacade.fetchAllRecords(9L);
		Assert.assertNotNull(expenses);
	}
	
	@Test
	public void generateExpenseVoucher(){
		serviceFacade.generateExpenseVouchers(null,9L);
	}
	
}
