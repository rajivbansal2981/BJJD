package com.jmk.bjjd.persistence.sql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmk.bjjd.persistence.sql.entities.GuestEntity;

public interface GuestRepository extends JpaRepository<GuestEntity,String>{
	public List<GuestEntity> findAllByTenantId(Long tenantId);
}
