package com.project.dao;

import java.util.List;

import com.project.model.Tickets;

public interface TicketsDao {
	public List<Tickets> bookingData(Tickets tickets);
}