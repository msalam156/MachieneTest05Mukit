package com.sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sales.dto.EmployeeDetailsDTO;
import com.sales.entity.Employee;
import com.sales.service.IEmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class EmplyeeController {

	@Autowired
	private IEmployeeService empService;

	// get all employees
	@GetMapping
	public ResponseEntity<?> getAllUsers() {
		List<Employee> empList = empService.getAllEmployees();

		if (empList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee list is empty!!!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(empList);
		}
	}

	// get employee by ID
	@GetMapping("{id}")
	public ResponseEntity<?> getUserById(@PathVariable Integer id) {
		Employee emp = empService.findEmployeeById(id);
		
		if (emp == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found!!!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(emp);
		}
	}

	// post details using login id of the employee
	@PostMapping("{id}")
	public ResponseEntity<?> addEmployeeDetails(@RequestBody Employee employee,
			@PathVariable Integer id) {
		Employee emp = empService.addEmployeeDetails(employee, id);
		
		if(emp == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee details not saved!!!");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(emp);
		}
	}

	// delete employee using emp id
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer id) {
		Employee emp = empService.deleteEmployeeById(id);
		
		if(emp == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Employee with ID: " + id + " doesn't exist!!!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("Employee " + emp.getFirstName() + " deleted successfully");
		}
		 
	}

	// update details of a user(Purchase Manager)
	@PutMapping("{id}")
	public ResponseEntity<?> updateEmployeeDetails(@RequestBody EmployeeDetailsDTO empDetailsDTO,
			@PathVariable Integer id) {
		Employee emp = empService.updateEmployeeDetailsById(empDetailsDTO, id);

		if(emp == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Employee with ID: " + id + " doesn't exist!!!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("Employee details updated successfully");
		}
	}

}
