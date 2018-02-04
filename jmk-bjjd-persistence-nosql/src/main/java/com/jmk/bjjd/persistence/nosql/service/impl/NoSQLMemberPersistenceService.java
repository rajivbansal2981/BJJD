package com.jmk.bjjd.persistence.nosql.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jmk.bjjd.models.MemberModel;
import com.jmk.bjjd.models.RoleModel;
import com.jmk.bjjd.models.UserModel;
import com.jmk.bjjd.persistence.mapper.EntityModelMapper;
import com.jmk.bjjd.persistence.nosql.entities.MemberEntity;
import com.jmk.bjjd.persistence.nosql.entities.RoleEntity;
import com.jmk.bjjd.persistence.nosql.repository.MemberRepository;
import com.jmk.bjjd.persistence.nosql.sequence.SequencePersistenceService;
import com.jmk.bjjd.persistence.service.MemberPersistenceService;
import com.jmk.bjjd.persistence.service.SevaPersistenceService;

@Transactional
@Repository("noSQLMemberPersistenceService")
public class NoSQLMemberPersistenceService implements MemberPersistenceService{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private EntityModelMapper mapper;
	
	@Resource(name="noSQLSevaPersistenceService")
	private SevaPersistenceService sevaPersistenceService;
	
	@Autowired
	private SequencePersistenceService sequencePersistenceService;
	
	@Resource(name="noSQLMemberRepository")
	private MemberRepository repository;
	
	public MemberModel saveRecord(MemberModel memberModel){
		memberModel.setSevas(sevaPersistenceService.saveRecords(memberModel.getSevas()));
		MemberEntity memberEntity=mapper.map(memberModel,MemberEntity.class);
		sequencePersistenceService.setNextSequenceIdForSingleEntity(memberEntity);
		mongoTemplate.insert(memberEntity);
		memberModel=findRecordByKey(memberEntity.getId());
		return memberModel;
	}
	
	public MemberModel findRecordByKey(String id){
		MemberEntity memberEntity=mongoTemplate.findById(id,MemberEntity.class);
		MemberModel memberModel=mapper.map(memberEntity, MemberModel.class);
		return memberModel;
	}
	
	public List<MemberModel> fetchAllRecordsByTenantId(Long tenantId){
		List<MemberEntity> memberEntities=mongoTemplate.findAll(MemberEntity.class);
		List<MemberModel> memberModels=mapper.map(memberEntities,MemberModel.class);
		return memberModels;
	}
	
	public MemberModel updateRecord(MemberModel memberModel){
		memberModel.setSevas(sevaPersistenceService.saveRecords(memberModel.getSevas()));
		MemberEntity memberEntity=mapper.map(memberModel,MemberEntity.class);
		mongoTemplate.save(memberEntity);
		memberModel=findRecordByKey(memberEntity.getId());
		return memberModel;
	}
	
	public void deleteRecordById(String id){
		Query query=new Query();
		query.addCriteria(Criteria.where("id").is(id));
		MemberModel memberModel=findRecordByKey(id);
		sevaPersistenceService.deleteRecords(memberModel.getSevas());
		mongoTemplate.remove(query, MemberEntity.class);
	}

	@Override
	public List<MemberModel> saveRecords(List<MemberModel> memberModels) {
		List<MemberModel> members=new ArrayList<MemberModel>();
		for(MemberModel memberModel:memberModels){
			if(memberModel.getId()!=null){
				members.add(saveRecord(memberModel));
			}else{
				members.add(updateRecord(memberModel));
			}
		}
		return members;
	}

	@Override
	public void deleteRecords(List<MemberModel> memberModels) {
		for(MemberModel memberModel:memberModels){
			deleteRecordById(memberModel.getId());
		}
		
	}

	@Override
	public List<RoleModel> findRolesByTenantId(Long tenantId) {
		List<RoleEntity> roleEntities=mongoTemplate.findAll(RoleEntity.class);
		List<RoleModel> roleModels=mapper.map(roleEntities,RoleModel.class);
		return roleModels;
	}

	@Override
	public List<MemberModel> findTeamLeadersByTenantId(Long tenantId) {
		RoleEntity roleEntity=getRoleByName("TL");
		Query query=new Query();
		query.addCriteria(Criteria.where("roles").is(new ObjectId(roleEntity.getId())));
		List<MemberEntity> memberEntities=mongoTemplate.find(query, MemberEntity.class);
		List<MemberModel> memberModels=mapper.map(memberEntities,MemberModel.class);
		return memberModels;
	}
	
	private RoleEntity getRoleByName(String name){
		Query query=new Query();
		query.addCriteria(Criteria.where("name").is(name));
		return mongoTemplate.findOne(query, RoleEntity.class);
	}

	@Override
	public UserModel findUserDetailsByUserName(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changePassword(String userId, String password) {
		// TODO Auto-generated method stub
		
	}
	
}
