package com.sales.service;

import static com.sales.util.LoginValidationUtil.validateLoginDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sales.dao.LoginDAO;
import com.sales.dto.LoginDTO;
import com.sales.entity.Login;
import com.sales.exception.LoginClassCustomException;

@Service
@Transactional
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private LoginDAO loginDAO;

	// method to find user by email and password
	@Override
	public Login findByUserNameAndPassword(LoginDTO loginDTO) {
		// verify user exists with given email and password
		Login userLogin = loginDAO.findOneByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());

		return userLogin;

	}

	// method to add more credentials
	@Override
	public Login addLoginUser(Login login) {
		try {
			// validate the login credentials
			validateLoginDetails(login);
			checkForDuplicateUsername(login.getUsername());
			// save if succeeded
			return loginDAO.save(login);
		} catch (LoginClassCustomException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// method to check duplicate username
	private void checkForDuplicateUsername(String username) throws LoginClassCustomException {
		Login findDuplicateLogin = loginDAO.findByUsername(username);

		// if found
		if (findDuplicateLogin != null) {
			throw new LoginClassCustomException("Username already exists!!! Use another username!!!");
		}
	}

	// method to get all login users
	@Override
	public List<Login> getAllLoginUsers() {
		return loginDAO.findAll();
	}

}
