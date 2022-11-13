package com.project.dao;

import java.util.List;

import com.project.exception.TicketException;
import com.project.model.Tickets;

public interface TicketsDao {
	public List<Tickets> bookingData(Tickets tickets)throws TicketException;

	public List<Tickets> PrintTickets(String referenceID, String email) throws TicketException;

	public List<String> ShowRefID(String email);
}
