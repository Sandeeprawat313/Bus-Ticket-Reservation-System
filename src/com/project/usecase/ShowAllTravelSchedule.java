package com.project.usecase;

import java.util.List;

import com.project.dao.BusDao;
import com.project.dao.BusDaoImpl;
import com.project.model.Bus;

public class ShowAllTravelSchedule {

	public static void main(String[] args) {
		BusDao b1 = new BusDaoImpl();
		List<Bus> list = b1.showALLTravelSchedule();

		for (Bus i : list) {
			System.out.println(i);
		}

	}

}
