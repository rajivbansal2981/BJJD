package com.jmk.bjjd.persistence.sql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmk.bjjd.persistence.sql.entities.SevaEntity;

public interface SevaRepository extends JpaRepository<SevaEntity,String>{
	public List<SevaEntity> findAllByTenantId(Long tenantId);
}
