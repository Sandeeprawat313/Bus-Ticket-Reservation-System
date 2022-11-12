package com.project.usecase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.project.model.Tickets;

public class Demo {

	public static void main(String[] args) {
		List<Tickets> list2 = new ArrayList<>();

		Tickets t1 = new Tickets("1212", 1, "Sandeep", 25, "Delhi", "Jaipur", "2022-12-12 10:00:00",
				"2022-12-12 18:00:00", "r@123");
		Tickets t2 = new Tickets("1212", 1, "Rawat", 35, "Delhi", "Jaipur", "2022-12-12 10:00:00",
				"2022-12-12 18:00:00", "r@123");
		list2.add(t1);
		list2.add(t2);

		String refID = null;
		String startPoint1 = null;
		String destinatio = null;
		String departure = null;
		String arrival = null;
		Map<String, Integer> map = new HashMap<>();

		for (Tickets i : list2) {
			refID = i.getReferenceID();
			startPoint1 = i.getDestinationFrom();
			destinatio = i.getDestinationTo();
			departure = i.getDeparture();
			arrival = i.getArrival();
			map.put(i.getPassangerName(), i.getPassangerAge());
		}

		System.out.println("==================================================");
		System.out.println("                  Bus Ticket");
		System.out.println("==================================================");
		System.out.printf("Reference id                  :" + "%-20s\n", refID);
		System.out.printf("Starting point                :" + "%-20s\n", startPoint1);
		System.out.printf("Destination point             :" + "%-20s\n", destinatio);
		System.out.printf("Departure date & time         :" + "%-20s\n", departure);
		System.out.printf("Arrival date & time           :" + "%-20s\n", arrival);
		System.out.println("==================================================");
		System.out.println("Passenger details");

		System.out.println("S.No.   Name of passanger      " + "Age");
		int i = 1;

		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.printf("%2d         ", i);
			System.out.printf("%8s            ", entry.getKey());
			System.out.printf("%-10d", entry.getValue());
			// System.out.println(i + ". " + entry.getKey()+ entry.getValue());
			i++;
			System.out.println();
		}
		System.out.println("==================================================");

	}

}
