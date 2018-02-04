package com.jmk.bjjd.persistence.nosql.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.jmk.bjjd.enums.PersonType;
import com.jmk.bjjd.persistence.nosql.entities.CollectionEntity;

public interface CollectionRespository extends MongoRepository<CollectionEntity,String>{
	@Query("{'guest.$id':?0}")
	public List<CollectionEntity> findAllCollectionByGuestId(String guestId);
	
	@Query("{'persontype':?0}")
	public List<CollectionEntity> findAllCollectionByPersonType(PersonType type);
}
