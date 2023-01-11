package com.sales.service;

import static com.sales.util.EmployeeValidationUtils.validateEmployeeDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sales.dao.EmployeeDAO;
import com.sales.dto.EmployeeDetailsDTO;
import com.sales.entity.Employee;
import com.sales.exception.EmployeeCustomException;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	// method to get all users
	@Override
	public List<Employee> getAllEmployees() {
		return employeeDAO.findAll();
	}

	// method to find emp by user id
	@Override
	public Employee findEmployeeById(Integer id) {
		return employeeDAO.findById(id).orElse(null);
	}

	// method to add user details
	@Override
	public Employee addEmployeeDetails(Employee employee, Integer l_id) {
		try {
			validateEmployeeDetails(employee);

		} catch (EmployeeCustomException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return employeeDAO.save(employee);
	}

	// method to update user details
	@Override
	public Employee updateEmployeeDetailsById(EmployeeDetailsDTO empDetailsDTO, Integer id) {

		Employee emp = employeeDAO.findById(id).orElse(null);

		// if emp is not found
		if (emp != null) {

			// check if the user details are proper
			if (empDetailsDTO.getFirstName() != null && !empDetailsDTO.getFirstName().isBlank()) {
				emp.setFirstName(empDetailsDTO.getFirstName());
			}
			if (empDetailsDTO.getLastName() != null && !empDetailsDTO.getLastName().isBlank()) {
				emp.setLastName(empDetailsDTO.getLastName());
			}
			if (empDetailsDTO.getAddress() != null && !empDetailsDTO.getAddress().isBlank()) {
				emp.setAddress(empDetailsDTO.getAddress());
			}
			if (empDetailsDTO.getPhoneNumber() > 7000000000l && empDetailsDTO.getPhoneNumber() < 9999999999l) {
				emp.setPhoneNumber(empDetailsDTO.getPhoneNumber());
			}
			employeeDAO.save(emp);
		}
		return emp;
	}

	// method to delete employee
	@Override
	public Employee deleteEmployeeById(Integer id) {
		Employee emp = employeeDAO.findById(id).orElse(null);

		if (emp != null) {
			employeeDAO.delete(emp);
		}
		return emp;
	}

}
