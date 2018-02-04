package com.jmk.bjjd.persistence.nosql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jmk.bjjd.persistence.nosql.entities.UserEntity;

@Repository("noSQLUserRespository")
public interface UserRespository extends MongoRepository<UserEntity,String>{
}
