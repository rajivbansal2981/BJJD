package com.jmk.bjjd.persistence.sql.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jmk.bjjd.models.MemberModel;
import com.jmk.bjjd.models.RoleModel;
import com.jmk.bjjd.models.UserModel;
import com.jmk.bjjd.persistence.mapper.EntityModelMapper;
import com.jmk.bjjd.persistence.service.MemberPersistenceService;
import com.jmk.bjjd.persistence.sql.entities.MemberEntity;
import com.jmk.bjjd.persistence.sql.entities.RoleEntity;
import com.jmk.bjjd.persistence.sql.repository.MemberRepository;
import com.jmk.bjjd.persistence.sql.repository.RoleRepository;

@Transactional
@Repository("sqlMemberPersistenceService")
public class SQLMemberPersistenceService implements MemberPersistenceService{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Resource(name="entityModelMapper")
	private EntityModelMapper mapper;
	
	@Autowired
	private MemberRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public MemberModel saveRecord(MemberModel model) {
		MemberEntity memberEntity=mapper.map(model,MemberEntity.class);
		memberEntity=repository.save(memberEntity);
		model=mapper.map(memberEntity,MemberModel.class);
		return model;
	}

	@Override
	public MemberModel updateRecord(MemberModel model) {
		MemberEntity memberEntity=mapper.map(model,MemberEntity.class);
		memberEntity=repository.save(memberEntity);
		model=mapper.map(memberEntity,MemberModel.class);
		return model;
	}

	@Override
	public List<MemberModel> fetchAllRecordsByTenantId(Long tenantId) {
		List<MemberEntity> memberEntities=repository.findAllByTenantId(tenantId);
		List<MemberModel> memberModels=mapper.map(memberEntities, MemberModel.class);
		return memberModels;
	}

	@Override
	public void deleteRecordById(String id) {
		repository.delete(id);
	}

	@Override
	public MemberModel findRecordByKey(String id) {
		MemberEntity memberEntity=repository.findOne(id);
		MemberModel model=mapper.map(memberEntity,MemberModel.class);
		return model;
	}

	@Override
	public List<MemberModel> saveRecords(List<MemberModel> records) {
		List<MemberEntity> memberEntities=mapper.map(records,MemberEntity.class);
		memberEntities=repository.save(memberEntities);
		records=mapper.map(memberEntities, MemberModel.class);
		return records;
	}

	@Override
	public void deleteRecords(List<MemberModel> records) {
		List<MemberEntity> memberEntities=mapper.map(records,MemberEntity.class);
		repository.delete(memberEntities);
	}

	@Override
	public List<RoleModel> findRolesByTenantId(Long tenantId) {
		List<RoleEntity> roleEntities=roleRepository.findAllByTenantId(tenantId);
		List<RoleModel> roleModels=mapper.map(roleEntities, RoleModel.class);
		return roleModels;
	}

	@Override
	public List<MemberModel> findTeamLeadersByTenantId(Long tenantId) {
		TypedQuery<MemberEntity> query=entityManager.createNamedQuery("findTeamLeadersByTenantId",MemberEntity.class);
		query.setParameter("tenantId",tenantId);
		query.setParameter("rolename","TL");
		List<MemberEntity> memberEntities=query.getResultList();
		List<MemberModel> memberModels=mapper.map(memberEntities, MemberModel.class);
		return memberModels;
	}

	@Override
	public UserModel findUserDetailsByUserName(String userName) {
		MemberEntity memberEntity=repository.findByUserName(userName);
		MemberModel memberModel=mapper.map(memberEntity,MemberModel.class);
		return memberModel;
	}

	@Override
	public void changePassword(String userId, String password) {
		// TODO Auto-generated method stub
		
	}
	
}
