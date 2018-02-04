package com.jmk.bjjd.web.facade.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.itextpdf.text.DocumentException;
import com.jmk.bjjd.models.ExpenseModel;
import com.jmk.bjjd.util.constants.ExpenseURIConstants;
import com.jmk.bjjd.web.facade.ExpenseMgmtServiceFacade;
import com.jmk.bjjd.web.utils.PdfCreator;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

@Component("expenseMgmtServiceFacade")
public class DefaultExpenseMgmtServiceFacade implements ExpenseMgmtServiceFacade{
	
	private static final DateFormat dateFormat=new SimpleDateFormat("dd-MMM-yyyy");
	
	@Value("${webservice.url}")
	private String webServiceURL;
	
	@Resource(name="expensePdfCreator")
	private PdfCreator<ExpenseModel> expensePdfCreator;

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
	public List<ExpenseModel> fetchAllRecords(Long tenantId) {
		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<ExpenseModel[]> respsoneEntity=restTemplate.getForEntity(webServiceURL+ExpenseURIConstants.FETCH_ALL_EXPENSES_BY_TENANTID,ExpenseModel[].class,tenantId);
		List<ExpenseModel> expenses=Arrays.asList(respsoneEntity.getBody());
		return expenses;
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
		RestTemplate restTemplate=new RestTemplate();
		List<MediaType> mediaTypes=new ArrayList<MediaType>();
		mediaTypes.add(MediaType.APPLICATION_JSON);
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(mediaTypes);
		HttpEntity<List<ExpenseModel>> requestEntity=new HttpEntity<List<ExpenseModel>>(records,headers);
		ResponseEntity<ExpenseModel[]> respsoneEntity=restTemplate.exchange(webServiceURL+ExpenseURIConstants.SAVE_EXPENSES,HttpMethod.POST, requestEntity, ExpenseModel[].class);
		List<ExpenseModel> expenses=Arrays.asList(respsoneEntity.getBody());
		return expenses;
	}

	@Override
	public void deleteRecords(List<ExpenseModel> records) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ExpenseModel> uploadExpense(CommonsMultipartFile multipartFile) {
		List<ExpenseModel> expenses=null;
		HeaderColumnNameTranslateMappingStrategy<ExpenseModel> headerColumnMappingStrategy=new HeaderColumnNameTranslateMappingStrategy<ExpenseModel>();
		
		Map<String,String> columnMapping=new HashMap<String,String>();
		columnMapping.put("V.No","id");
		columnMapping.put("Date","dateString");
		columnMapping.put("Description","description");
		columnMapping.put("PaidTo","paidTo");
		columnMapping.put("Remark","remark");
		columnMapping.put("Amount","amount");
		
		headerColumnMappingStrategy.setColumnMapping(columnMapping);
		headerColumnMappingStrategy.setType(ExpenseModel.class);
		CsvToBean<ExpenseModel> csvToBean=new CsvToBean<ExpenseModel>();
		try(CSVReader csvReader=new CSVReader(new InputStreamReader(multipartFile.getInputStream(),"UTF-8"));){
			expenses=csvToBean.parse(headerColumnMappingStrategy, csvReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		expenses=(expenses!=null)?saveRecords(expenses):null;
		return expenses;
	}
	
	@Override
	public void generateExpenseVouchers(List<String> voucherNos,Long tenantId) {
		List<ExpenseModel> expenses=fetchAllRecords(9L);
		expenses.forEach(expense -> expense.setDateString(formatDate(expense.getDate())));
		try {
			expensePdfCreator.createPdf("sdf",expenses);
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected String formatDate(Date date){
		String formattedDate=dateFormat.format(date);
		return formattedDate;
	}
	
}
