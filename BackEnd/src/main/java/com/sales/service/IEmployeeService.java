package com.sales.service;

import java.util.List;

import com.sales.dto.EmployeeDetailsDTO;
import com.sales.entity.Employee;

public interface IEmployeeService {
	
	List<Employee> getAllEmployees();
	
	Employee findEmployeeById(Integer id);
	
	Employee addEmployeeDetails(Employee employee, Integer l_id);

	Employee updateEmployeeDetailsById(EmployeeDetailsDTO empDTO, Integer id);
	
	Employee deleteEmployeeById(Integer id);
	
}
