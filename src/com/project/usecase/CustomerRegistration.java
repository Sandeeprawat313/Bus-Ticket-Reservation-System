package com.project.usecase;

import java.util.Scanner;

import com.project.dao.UserDao;
import com.project.dao.UserDaoImpl;
import com.project.model.User;

public class CustomerRegistration {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your name");
		String uname = sc.next();

		System.out.println("Enter the email");
		String email = sc.next();

		System.out.println("Enter the Password");
		String password = sc.next();
		System.out.println();

		UserDao udao = new UserDaoImpl();
		User u1 = new User();
		u1.setUname(uname);
		u1.setEmail(email);
		u1.setPassword(password);

		String str = udao.customerRegistration(u1);
		System.out.println(str);
		System.out.println("Please login using existing customer link");
		System.out.println();

	}

}
