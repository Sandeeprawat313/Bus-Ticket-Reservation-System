package com.project.dao;

import com.project.exception.UserException;
import com.project.model.User;

public interface UserDao {
	public String customerRegistration(User user) throws UserException;

	public User userLogin(String email, String password)throws UserException;
}
