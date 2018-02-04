package com.jmk.bjjd.persistence.service;

import java.util.List;

import com.jmk.bjjd.enums.PersonType;
import com.jmk.bjjd.models.CollectionModel;

public interface CollectionPersistenceService extends BasePersistenceService<CollectionModel>{

	public List<CollectionModel> findAllCollectionByMemberId(String memberId);
	
	public List<CollectionModel> findAllCollectionByGuestId(String guestId);
	
	public List<CollectionModel> findAllCollectionByPersonTypeAndTenantId(PersonType type,Long tenantId);
	
}
