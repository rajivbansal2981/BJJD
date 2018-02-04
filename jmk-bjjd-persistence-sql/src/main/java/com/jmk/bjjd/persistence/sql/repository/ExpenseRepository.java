package com.jmk.bjjd.persistence.sql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmk.bjjd.persistence.sql.entities.ExpenseEntity;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, String>{

}
