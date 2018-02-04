package com.jmk.bjjd.rest.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jmk.bjjd.enums.PersonType;
import com.jmk.bjjd.models.CollectionModel;
import com.jmk.bjjd.service.CollectionMgmtService;
import com.jmk.bjjd.util.constants.CollectionURIConstants;

@RestController("collectionMgmtRestController")
public class CollectionMgmtRestController {

	@Resource(name="collectionMgmtService")
	private CollectionMgmtService service;
	
	@RequestMapping(value=CollectionURIConstants.GET_COLLECTIONDETAILS_BY_ID,method=RequestMethod.GET)
	public CollectionModel getCollectionDetailsById(@PathVariable String id){
		CollectionModel collection=service.findRecordByKey(id);
		return collection;
	}
	
	@RequestMapping(value=CollectionURIConstants.SAVE_COLLECTION,method=RequestMethod.GET)
	public CollectionModel saveCollection(@RequestBody CollectionModel collection){
		collection=service.saveRecord(collection);
		return collection;
	}
	
	@RequestMapping(value=CollectionURIConstants.SAVE_COLLECTIONS,method=RequestMethod.GET)
	public void saveCollections(@RequestBody List<CollectionModel> collection){
		service.saveRecords(collection);
	}
	
	@RequestMapping(value=CollectionURIConstants.UPDATE_COLLECTION,method=RequestMethod.GET)
	public CollectionModel updateCollection(@RequestBody CollectionModel collection){
		collection=service.updateRecord(collection);
		return collection;
	}
	
	@RequestMapping(value=CollectionURIConstants.UPDATE_COLLECTIONS,method=RequestMethod.GET)
	public void updateCollections(@RequestBody List<CollectionModel> collections){
		service.saveRecords(collections);
	}

	@RequestMapping(value=CollectionURIConstants.DELETE_COLLECTION_BY_ID,method=RequestMethod.GET)
	public void deleteCollectionById(@RequestBody String id){
		service.deleteRecordById(id);
	}
	
	@RequestMapping(value=CollectionURIConstants.DELETE_COLLECTIONS,method=RequestMethod.GET)
	public void deleteCollections(@RequestBody List<CollectionModel> collections){
		service.deleteRecords(collections);
	}

	@RequestMapping(value=CollectionURIConstants.FETCH_ALL_COLLECTIONS_BY_TENANTID,method=RequestMethod.GET)
	public List<CollectionModel> fetchAllRecordsByTenantId(@PathVariable("tenantId") Long tenantId){
		List<CollectionModel> collections=service.fetchAllRecordsByTenantId(tenantId);
		return collections;
	}
	
	@RequestMapping(value=CollectionURIConstants.FETCH_COLLECTIONS_BY_MEMBERID,method=RequestMethod.GET)
	public List<CollectionModel> fetchCollectionsByMemberId(@PathVariable String memberId){
		List<CollectionModel> collections=service.findAllCollectionByMemberId(memberId);
		return collections;
	}
	
	@RequestMapping(value=CollectionURIConstants.FETCH_COLLECTIONS_BY_GUESTID,method=RequestMethod.GET)
	public List<CollectionModel> fetchCollectionsByGuestId(@PathVariable String guestId){
		List<CollectionModel> collections=service.findAllCollectionByGuestId(guestId);
		return collections;
	}
	
	@RequestMapping(value=CollectionURIConstants.FETCH_COLLECTIONS_BY_PERSONTYPE_AND_TENANTID,method=RequestMethod.GET)
	public List<CollectionModel> fetchCollectionByPersonTypeAndTenantId(@PathVariable PersonType personType,@PathVariable("tenantId") Long tenantId){
		List<CollectionModel> collections=service.findAllCollectionByPersonTypeAndTenantId(personType,tenantId);
		return collections;
	}
}
