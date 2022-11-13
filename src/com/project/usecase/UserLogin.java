package com.project.usecase;

import java.util.Scanner;

import com.project.dao.BusDao;
import com.project.dao.BusDaoImpl;
import com.project.dao.UserDao;
import com.project.dao.UserDaoImpl;
import com.project.exception.UserException;
import com.project.model.User;

public class UserLogin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your email");
		String email = sc.next();

		System.out.println("Enter your password");
		String password = sc.next();

		UserDao uDao = new UserDaoImpl();

		try {
			User user = uDao.userLogin(email, password);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
