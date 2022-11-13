package com.project.usecase;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.project.dao.BusDao;
import com.project.dao.BusDaoImpl;
import com.project.exception.BusException;
import com.project.model.Bus;

public class ShowDetailsAsperRoute {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Starting Point");
		String startPoint = sc.next();
		System.out.println("Enter Your Destination");
		String DestinationTO = sc.next();

		BusDao b1 = new BusDaoImpl();

		try {
			List<Bus> list = b1.showTravelDetailsRoute(startPoint, DestinationTO);
			System.out.println("Bus id" + "    " + "Starting point" + "    " + "Destination" + "    "
					+ "Departure data & time" + "    " + "Arrival date & time" + "    " + "Seats Available");
			for (Bus i : list) {
				int bid = i.getBid();
				String startingPoint = i.getDestinationFrom();
				String desPoint = i.getDestinationTo();
				String departure = i.getDeparture();
				String arrival = i.getArrival();
				int seatsAvailable = i.getSeatsAvailable();

				System.out.printf("%2d", bid);
				System.out.printf("%16s", startingPoint.toUpperCase());
				System.out.printf("%18s        ", desPoint.toUpperCase());

				System.out.printf("%15s    ", departure);
				System.out.printf("%15s", arrival);
				System.out.printf("%10d", seatsAvailable);
				System.out.println();

			}

			System.out.println();
		} catch (BusException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
