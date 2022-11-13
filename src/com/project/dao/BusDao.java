package com.project.dao;

import java.util.List;

import com.project.exception.BusException;
import com.project.model.Bus;

public interface BusDao {
	public String addBusDetails(Bus bus)throws BusException;

	public List<Bus> showALLTravelSchedule() throws BusException;

	public List<Bus> showTravelDetailsRoute(String startingPoint, String destination) throws BusException;

	public Bus ShowDetailsAsPerbid(int bid) throws BusException;

	public void updateSeats(int seat, int bid);
}
