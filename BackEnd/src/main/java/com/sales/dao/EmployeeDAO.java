package com.sales.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sales.entity.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer>{

}
