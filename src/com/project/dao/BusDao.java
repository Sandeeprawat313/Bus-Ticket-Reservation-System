package com.project.dao;

import java.util.List;

import com.project.model.Bus;

public interface BusDao {
	public String addBusDetails(Bus bus);
	public List<Bus> showALLTravelSchedule(); 
	public List<Bus> showTravelDetailsRoute(String startingPoint, String destination);
	public Bus ShowDetailsAsPerbid(int bid);
	public void updateSeats(int seat, int bid);
}
