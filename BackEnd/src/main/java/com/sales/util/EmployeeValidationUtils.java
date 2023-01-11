package com.sales.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sales.entity.Employee;
import com.sales.exception.EmployeeCustomException;

// class for writing validation codes for UserRegistration
public class EmployeeValidationUtils {
	
	// method to validate user input details
	public static void validateEmployeeDetails(Employee employee) throws EmployeeCustomException {
		validateName(employee.getFirstName(), employee.getLastName());
		validateAge(employee.getAge());
		validateGender(employee.getGender());
		validatePhoneNumber(employee.getPhoneNumber());
	}

	// method to validate Name
	private static void validateName(String firstName, String lastName) throws EmployeeCustomException {
		// pattern matching using regex - Name must be in alphabets
		Pattern pattern = Pattern.compile("[A-Za-z]");
		Matcher matcherFirstName = pattern.matcher(firstName);
		Matcher matcherLastName = pattern.matcher(lastName);
		
		boolean matchFirstNameFound = matcherFirstName.find();
		boolean matchLastNameFound = matcherLastName.find();
		
		if(!matchFirstNameFound || !matchLastNameFound) {
			throw new EmployeeCustomException("Name must be in alphabet characters!!!");
		}
	}
	
	// method to validate Age
	private static void validateAge(Integer age) throws EmployeeCustomException {
		// user must be above 18 years
		if(age < 18) {
			throw new EmployeeCustomException("Age must be over 18!!!");
		}
	}
	
	// method to validate gender
	private static void validateGender(String gender) throws EmployeeCustomException {
		// user must be either Male or Female
		if(!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")) {
			throw new EmployeeCustomException("Gender must be either MALE or FEMALE!!!");
		}
	}
	
	// method to validate phone number
	private static void validatePhoneNumber(Long phoneNumber) throws EmployeeCustomException {
		// phone number must be a 10-digit no. 
		if(phoneNumber < 7000000000l && phoneNumber > 9999999999l) {
			throw new EmployeeCustomException("Put a valid phone number");
		}
	}
	
}
