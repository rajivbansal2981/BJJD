package com.jmk.bjjd.persistence.sql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmk.bjjd.persistence.sql.entities.RoleEntity;


public interface RoleRepository extends JpaRepository<RoleEntity,String>{
	public List<RoleEntity> findAllByTenantId(Long tenantId);
}
