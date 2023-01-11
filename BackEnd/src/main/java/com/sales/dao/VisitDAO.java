package com.sales.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sales.entity.Visit;

@Repository
public interface VisitDAO extends JpaRepository<Visit, Integer> {

}
