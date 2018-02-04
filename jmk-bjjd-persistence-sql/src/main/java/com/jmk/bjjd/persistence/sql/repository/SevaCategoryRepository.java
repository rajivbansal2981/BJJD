package com.jmk.bjjd.persistence.sql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmk.bjjd.persistence.sql.entities.SevaCategoryEntity;

public interface SevaCategoryRepository extends JpaRepository<SevaCategoryEntity,String>{
	public List<SevaCategoryEntity> findAllByTenantId(Long tenantId);
}
