package com.project.dao;

import com.project.model.User;

public interface UserDao {
	public String customerRegistration(User user);

	public User userLogin(String email, String password);
}
