package com.project.usecase;

import java.util.Scanner;

import com.project.dao.UserDao;
import com.project.dao.UserDaoImpl;
import com.project.model.User;

public class AdminLogin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your email");
		String email = sc.next();

		System.out.println("Enter your password");
		String password = sc.next();

		UserDao uDao = new UserDaoImpl();
		User user = uDao.userLogin(email, password);

		System.out.println("Welcome " + user.getUname());
		System.out.println();


	}

}
