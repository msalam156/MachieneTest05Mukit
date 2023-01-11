package com.sales.service;

import java.util.List;

import com.sales.entity.Visit;

public interface IVisitService {
	
	Visit addVisitDetails(Visit visit);
	
	List<Visit> getAllVisits();
	
	Visit deleteVisitById(Integer id);

}
