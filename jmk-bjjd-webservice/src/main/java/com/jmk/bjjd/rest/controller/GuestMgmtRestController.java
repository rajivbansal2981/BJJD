package com.jmk.bjjd.rest.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jmk.bjjd.models.GuestModel;
import com.jmk.bjjd.service.GuestMgmtService;
import com.jmk.bjjd.util.constants.GuestURIConstants;

@RestController("guestMgmtRestController")
public class GuestMgmtRestController {

	@Resource(name="guestMgmtService")
	private GuestMgmtService service;
	
	@RequestMapping(value=GuestURIConstants.GET_GUESTDETAILS_BY_ID,method=RequestMethod.GET)
	public GuestModel getGuestDetailsById(@PathVariable String id){
		GuestModel guestModel=service.findRecordByKey(id);
		return guestModel;
	}
	
}
