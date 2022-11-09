package com.project.usecase;

import java.util.Scanner;

import com.project.dao.TicketBookingDao;
import com.project.dao.TicketBookingImpl;

public class BookBusTicket {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the user id");
		int userid = sc.nextInt();

		System.out.println("Enter the bus id");
		int busid = sc.nextInt();
		
		TicketBookingDao tbDao =  new TicketBookingImpl();
		String msg = tbDao.BookTicket(userid, busid);
	
		

		
		

	}

}
