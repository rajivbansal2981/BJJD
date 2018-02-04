package com.jmk.bjjd.web.facade;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jmk.bjjd.models.ExpenseModel;

public interface ExpenseMgmtServiceFacade extends BaseMgmtServiceFacade<ExpenseModel>{
	List<ExpenseModel> uploadExpense(CommonsMultipartFile multipartFile);
	
	void generateExpenseVouchers(List<String> voucherNos,Long tenantId);
}
