package com.jmk.bjjd.rest.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jmk.bjjd.models.SevaCategoryModel;
import com.jmk.bjjd.service.SevaCategoryMgmtService;
import com.jmk.bjjd.util.constants.SevaCategoryURIConstants;

@RestController("sevaCategoryMgmtRestController")
public class SevaCategoryMgmtRestController {

	@Resource(name="sevaCategoryMgmtService")
	private SevaCategoryMgmtService service;
	
	@RequestMapping(value=SevaCategoryURIConstants.FETCH_ALL_SEVACATEGORIES_BY_TENANTID,method=RequestMethod.GET)
	public List<SevaCategoryModel> fetchAllSevaCategoriesByTenantId(@PathVariable("tenantId") Long tenantId){
		return service.fetchAllRecordsByTenantId(tenantId);
	}
	
	
	
}
