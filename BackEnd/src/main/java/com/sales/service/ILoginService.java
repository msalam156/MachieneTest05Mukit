package com.sales.service;

import java.util.List;

import com.sales.dto.LoginDTO;
import com.sales.entity.Login;

public interface ILoginService {

	Login findByUserNameAndPassword(LoginDTO loginDTO);
	
	Login addLoginUser(Login login);
	
	List<Login> getAllLoginUsers();
	
}
