package com.project.usecase;

import java.sql.Date;
import java.util.Scanner;

import com.project.dao.BusDao;
import com.project.dao.BusDaoImpl;
import com.project.exception.BusException;
import com.project.model.Bus;

public class ListNewBus {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the start location");
		String destinationFrom = sc.next();

		System.out.println("Enter the destination to");
		String destinationTo = sc.next();

		System.out.println("Enter the departure date yyyy-mm-dd");
		String dD = sc.next();
		System.out.println("Enter the departure time HH:MM:SS ");
		String dT = sc.next();

		System.out.println("Enter the arrival date yyyy-mm-dd");
		String aD = sc.next();
		System.out.println("Enter the arrival time in hh:mm:ss");
		String aT = sc.next();

		System.out.println("Seats available");
		int sA = sc.nextInt();

		BusDao dao = new BusDaoImpl();
		Bus b1 = new Bus();
		b1.setDestinationFrom(destinationFrom);
		b1.setDestinationTo(destinationTo);
		b1.setDeparture(dD + " " + dT);
		b1.setArrival(aD + " " + aT);
		b1.setSeatsAvailable(sA);

		// System.out.println(b1);

		try {
			String msg = dao.addBusDetails(b1);
			System.out.println(msg);
		} catch (BusException e) {
			System.out.println(e.getMessage());
		}

	}

}
