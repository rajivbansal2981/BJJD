package com.jmk.bjjd.web.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jmk.bjjd.models.SevaCategoryModel;
import com.jmk.bjjd.util.constants.SevaCategoryURIConstants;
import com.jmk.bjjd.web.facade.SevaCategoryMgmtServiceFacade;

@Component("sevaCategoryMgmtServiceFacade")
public class DefaultSevaCategoryMgmtServiceFacade implements SevaCategoryMgmtServiceFacade{

	@Value("${webservice.url}")
	private String webServiceURL;
	
	
	@Override
	public SevaCategoryModel saveRecord(SevaCategoryModel model) {
		return null;
	}

	@Override
	public SevaCategoryModel updateRecord(SevaCategoryModel model) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SevaCategoryModel> fetchAllRecords(Long tenantId) {
		RestTemplate template=new RestTemplate();
		List<HttpMessageConverter<?>> msgConverters=template.getMessageConverters();
		msgConverters.add(new MappingJackson2HttpMessageConverter());
		List<SevaCategoryModel> sevaCategories=template.getForObject(webServiceURL+SevaCategoryURIConstants.FETCH_ALL_SEVACATEGORIES_BY_TENANTID, List.class,tenantId);
		return sevaCategories;
	}

	@Override
	public void deleteRecordById(String id) {
	}

	@Override
	public SevaCategoryModel findRecordByKey(String id) {
		return null;
	}

	@Override
	public List<SevaCategoryModel> saveRecords(List<SevaCategoryModel> records) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRecords(List<SevaCategoryModel> records) {
		// TODO Auto-generated method stub
		
	}

}
