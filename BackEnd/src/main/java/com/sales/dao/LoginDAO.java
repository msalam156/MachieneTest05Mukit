package com.sales.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sales.entity.Login;

@Repository
public interface LoginDAO extends JpaRepository<Login, Integer> {
	
	Login findOneByUsernameAndPassword(String username, String password);
	
	Login findByUsername(String username);
	
}
