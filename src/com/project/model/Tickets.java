package com.project.model;

public class Tickets {
	private String referenceID;
	private int bid;
	private String passangerName;
	private int passangerAge;
	private String destinationFrom;
	private String destinationTo;
	private String departure;
	private String arrival;
	private String email;

	public String getReferenceID() {
		return referenceID;
	}

	public void setReferenceID(String referenceID) {
		this.referenceID = referenceID;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getPassangerName() {
		return passangerName;
	}

	public void setPassangerName(String passangerName) {
		this.passangerName = passangerName;
	}

	public int getPassangerAge() {
		return passangerAge;
	}

	public void setPassangerAge(int passangerAge) {
		this.passangerAge = passangerAge;
	}

	public String getDestinationFrom() {
		return destinationFrom;
	}

	public void setDestinationFrom(String destinationFrom) {
		this.destinationFrom = destinationFrom;
	}

	public String getDestinationTo() {
		return destinationTo;
	}

	public void setDestinationTo(String destinationTo) {
		this.destinationTo = destinationTo;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Tickets [referenceID=" + referenceID + ", bid=" + bid + ", passangerName=" + passangerName
				+ ", passangerAge=" + passangerAge + ", destinationFrom=" + destinationFrom + ", destinationTo="
				+ destinationTo + ", departure=" + departure + ", arrival=" + arrival + ", email=" + email + "]";
	}

	public Tickets(String referenceID, int bid, String passangerName, int passangerAge, String destinationFrom,
			String destinationTo, String departure, String arrival, String email) {
		super();
		this.referenceID = referenceID;
		this.bid = bid;
		this.passangerName = passangerName;
		this.passangerAge = passangerAge;
		this.destinationFrom = destinationFrom;
		this.destinationTo = destinationTo;
		this.departure = departure;
		this.arrival = arrival;
		this.email = email;
	}

	public Tickets() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
