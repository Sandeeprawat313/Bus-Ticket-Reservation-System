package com.project.usecase;

import java.util.List;
import java.util.Scanner;

import com.project.dao.BusDao;
import com.project.dao.BusDaoImpl;
import com.project.model.Bus;

public class ShowDetailsAsperRoute {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Starting Point");
		String startPoint = sc.next();
		System.out.println("Enter Your Destination");
		String DestinationTO = sc.next();

		BusDao b1 = new BusDaoImpl();
		List<Bus> list = b1.showTravelDetailsRoute(startPoint, DestinationTO);
		System.out.println(list);
		System.out.println();

		System.out.println("If you want to book a ticket please select Y / N");

		String initiate_booking = sc.next().toUpperCase();
		if (initiate_booking.equals("Y")) {
			BookTickets b11 = new BookTickets();
			b11.main(null);
		}

	}

}
