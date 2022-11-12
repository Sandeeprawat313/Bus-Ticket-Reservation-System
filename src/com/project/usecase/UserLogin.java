package com.project.usecase;

import java.util.Scanner;

import com.project.dao.BusDao;
import com.project.dao.BusDaoImpl;
import com.project.dao.UserDao;
import com.project.dao.UserDaoImpl;
import com.project.model.User;

public class UserLogin {

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

		System.out.println("1. Check the bus data");
		System.out.println("2. check the bus data on the basis of starting point and destination");
		System.out.println("3. Check booked tickets");
		System.out.println("4. LogOut");
		
		
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			ShowAllTravelSchedule satc = new ShowAllTravelSchedule();
			satc.main(null);
			UserLogin u1 = new UserLogin();
			u1.main(null);
			break;
		case 2:
			ShowDetailsAsperRoute s1 = new ShowDetailsAsperRoute();
			s1.main(null);
			break;
		case 3:	
			
			default:
		}

		// close the scanner
		sc.close();

	}

}
