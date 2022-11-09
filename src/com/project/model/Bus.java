package com.project.model;

public class Bus {
	private int bid;
	private String DestinationFrom;
	private String DestinationTo;
	private String departure;
	private String arrival;
	private int seatsAvailable;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getDestinationFrom() {
		return DestinationFrom;
	}

	public void setDestinationFrom(String destinationFrom) {
		DestinationFrom = destinationFrom;
	}

	public String getDestinationTo() {
		return DestinationTo;
	}

	public void setDestinationTo(String destinationTo) {
		DestinationTo = destinationTo;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bus(int bid, String destinationFrom, String destinationTo, String departure, String arrival,
			int seatsAvailable) {
		super();
		this.bid = bid;
		DestinationFrom = destinationFrom;
		DestinationTo = destinationTo;
		this.departure = departure;
		this.arrival = arrival;
		this.seatsAvailable = seatsAvailable;
	}

	@Override
	public String toString() {
		return "Bus [bid=" + bid + ", DestinationFrom=" + DestinationFrom + ", DestinationTo=" + DestinationTo
				+ ", departure=" + departure + ", arrival=" + arrival + ", seatsAvailable=" + seatsAvailable + "]";
	}

}
