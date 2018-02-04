package com.jmk.bjjd.web.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jmk.bjjd.models.ExpenseModel;
import com.jmk.bjjd.web.facade.ExpenseMgmtServiceFacade;
import com.jmk.bjjd.web.utils.UserUtility;

@Controller("expenseController")
public class ExpenseController {
	
	private static final DateFormat dateFormat=new SimpleDateFormat("dd-MMM-yyyy");
	
	private Logger logger=LoggerFactory.getLogger(MemberController.class);
	
	@Resource(name="expenseMgmtServiceFacade")
	private ExpenseMgmtServiceFacade serviceFacade;

	@RequestMapping("expense/uploadExpensePage")
	public String uploadExpensePage(){
		return "uploadExpensePage";
	}
	
	@RequestMapping("expense/uploadExpenses")
	public String uploadExpense(@RequestParam("fileUpload") CommonsMultipartFile multipartFile,HttpServletRequest request,Model model) throws IllegalStateException, IOException{
		File file=new File(request.getServletContext().getRealPath("/")).getParentFile();
		multipartFile.transferTo(new File(file.getParentFile().getAbsolutePath()+"/bjjd/expense_details/"+multipartFile.getOriginalFilename()));
		List<ExpenseModel> expenses=serviceFacade.uploadExpense(multipartFile);
		expenses.forEach(expense -> expense.setDescription(formatDescription(expense.getDescription())));
		expenses.forEach(expense -> expense.setDateString(formatDate(expense.getDate())));
		ObjectMapper mapper=new ObjectMapper();
		String expenseListAsString=mapper.writeValueAsString(expenses);
		logger.info("expenseListAsString"+expenseListAsString);
		model.addAttribute("expenseList",expenseListAsString);
		return "listExpensePage";
	}
	
	@RequestMapping("expense/generateExpenseVouchers")
	public String generateExpenseVouchers(Model model,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException{
		String idsToBePrint[]=request.getParameter("idsToBePrint").split(",");
		logger.info("Selected Rows: "+idsToBePrint);
		serviceFacade.generateExpenseVouchers(Arrays.asList(idsToBePrint), UserUtility.getLoggedInUser().getUserModel().getTenantId());
		return "uploadExpensePage";
	}
	
	@RequestMapping("expense/listExpensePage")
	public String list(Model model,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException{
		String idsToBePrint=request.getParameter("idsToBePrint");
		logger.info("Selected Rows: "+idsToBePrint);
		List<ExpenseModel> expenses=serviceFacade.fetchAllRecords(9L);
		expenses.forEach(expense -> expense.setDescription(formatDescription(expense.getDescription())));
		expenses.forEach(expense -> expense.setDateString(formatDate(expense.getDate())));
		ObjectMapper mapper=new ObjectMapper();
		String expenseListAsString=mapper.writeValueAsString(expenses);
		logger.info("expenseListAsString"+expenseListAsString);
		model.addAttribute("expenseList",expenseListAsString);
		return "listExpensePage";
	}
	
	protected String formatDate(Date date){
		String formattedDate=dateFormat.format(date);
		return formattedDate;
	}
	
	protected String formatDescription(String description){
		if(description.contains("\n\r") || description.contains("\n") || description.contains(System.lineSeparator())){
			 return description.replaceAll("\n\r", "#")
	                    .replaceAll("\n", "#")
	                    .replaceAll(System.lineSeparator(), "#");
		}
		
		return description;
	}

	
}
