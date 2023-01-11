package com.sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sales.dto.LoginDTO;
import com.sales.entity.Login;
import com.sales.service.ILoginService;

@CrossOrigin
@RestController
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
	private ILoginService loginService;
	
	// for login
	@PostMapping
	public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
		Login user = loginService.findByUserNameAndPassword(loginDTO);
		
		if(user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!!!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}
	}
	
	// for signUp
	@PostMapping("/signUp")
	public ResponseEntity<?> addLoginUser(@RequestBody Login login) {
		 Login newUser = loginService.addLoginUser(login);
		 if(newUser == null) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User details not saved!!!");
		 } else {
			 return ResponseEntity.status(HttpStatus.OK).body(newUser);
		 }
	}
	
	// API to get Login list
	@GetMapping
	public ResponseEntity<?> getAllLoginUsers() {
		List<Login> userList = loginService.getAllLoginUsers();
		
		if(userList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Database is empty!!! Add Users first");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(userList);
		}
	}
}
