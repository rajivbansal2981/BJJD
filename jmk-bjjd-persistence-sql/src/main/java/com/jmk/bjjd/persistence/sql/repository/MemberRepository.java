package com.jmk.bjjd.persistence.sql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmk.bjjd.persistence.sql.entities.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity,String>{
	public List<MemberEntity> findAllByTenantId(Long tenantId);
	
	public MemberEntity findByUserName(String userName);
}
