package com.project.usecase;

import java.util.List;

import com.project.dao.BusDao;
import com.project.dao.BusDaoImpl;
import com.project.exception.BusException;
import com.project.model.Bus;

public class ShowAllTravelSchedule {

	public static void main(String[] args) {
		BusDao b1 = new BusDaoImpl();

		try {
			List<Bus> list = b1.showALLTravelSchedule();
			for (Bus i : list) {
				System.out.println(i);
			}

		} catch (BusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
