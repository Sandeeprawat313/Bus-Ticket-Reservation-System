package com.project.usecase;

import java.util.List;
import java.util.Scanner;

import com.project.dao.BusDao;
import com.project.dao.BusDaoImpl;
import com.project.dao.TicketsDao;
import com.project.dao.TicketsDaoImpl;
import com.project.exception.BusException;
import com.project.exception.TicketException;
import com.project.model.Bus;
import com.project.model.Tickets;

public class BookTickets {

	public static void print(Tickets t1) {
		System.out.println();
		System.out.println("===================");
		System.out.println("Reference id: " + t1.getReferenceID());
		System.out.println("Email id: " + t1.getEmail());
		System.out.println("Bus number: " + t1.getBid());
		System.out.println("Starting point: " + t1.getDestinationFrom());
		System.out.println("Destination: " + t1.getDestinationTo());
		System.out.println("Departure date & time: " + t1.getDeparture());
		System.out.println("Arrival date & time: " + t1.getArrival());
		System.out.println("===================");
		System.out.println("Passanger details....");
		System.out.println("Passanger name: " + t1.getPassangerName());
		System.out.println("Passanger age: " + t1.getPassangerAge());
		System.out.println("===================");

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter the Bus id");
		int bid = sc.nextInt();
		BusDao b11 = new BusDaoImpl();
		Bus bus;
		try {
			bus = b11.ShowDetailsAsPerbid(bid);
			System.out.println(bus);

			// on the basis of bid received the details of that bus
			System.out.println("Please enter the number of tickets you want to book");
			int seat = sc.nextInt();
			if (seat <= 0) {
				System.out.println("Tickets must be more than 0");
			} else if (bus.getSeatsAvailable() - seat < 0) {
				System.out.println("Invalid only " + bus.getSeatsAvailable() + " tickets are availbale to book");
			} else {
				System.out.println("Please share the passanget details");
//				System.out.println("No of tickets you want to book");
//				int tickets = sc.nextInt();
				String refID = bus.getSeatsAvailable() + "" + bus.getBid() + "" + java.time.LocalDate.now();
				for (int i = 0; i < seat; i++) {
					System.out.println("Enter the name of Passanger");
					String pname = sc.next();
					System.out.println("Enter the age of the passanger");
					int age = sc.nextInt();

					// save booking details
					TicketsDao tdao = new TicketsDaoImpl();
					Tickets t1 = new Tickets();
					t1.setReferenceID(refID);
					t1.setBid(bus.getBid());
					t1.setPassangerName(pname);
					t1.setPassangerAge(age);
					t1.setDestinationFrom(bus.getDestinationFrom());
					t1.setDestinationTo(bus.getDestinationTo());
					t1.setDeparture(bus.getDeparture());
					t1.setArrival(bus.getArrival());
					t1.setEmail("s@123");// hardcode change it
					try {
						tdao.bookingData(t1);
					} catch (TicketException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}

				System.out.println("you have booked your tickets");
				// after successfull booking
				BusDao update = new BusDaoImpl();
				update.updateSeats(seat, bid);

				// print ticket details

				TicketsDao t1 = new TicketsDaoImpl();

				try {
					List<Tickets> list = t1.PrintTickets(refID, "s@123");
					for (Tickets i : list) {
						System.out.println(i);
					}
				} catch (TicketException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} catch (BusException e1) {
			
			e1.printStackTrace();
		}

	}

}
