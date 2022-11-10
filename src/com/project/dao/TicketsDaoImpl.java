package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.model.Bus;
import com.project.model.Tickets;
import com.project.utility.DButil;

public class TicketsDaoImpl implements TicketsDao {

	@Override
	public List<Tickets> bookingData(Tickets tickets) {
		List<Tickets> list = new ArrayList<>();
		try (Connection conn = DButil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into tickets values(?,?,?,?,?,?,?,?,?)");

			ps.setString(1, tickets.getReferenceID());
			ps.setInt(2, tickets.getBid());
			ps.setString(3, tickets.getPassangerName());
			ps.setInt(4, tickets.getPassangerAge());
			ps.setString(5, tickets.getDestinationFrom());
			ps.setString(6, tickets.getDestinationTo());
			ps.setString(7, tickets.getDeparture());
			ps.setString(8, tickets.getArrival());
			ps.setString(9, tickets.getEmail());

			int x = ps.executeUpdate();
			if (x > 0) {
				System.out.println("Updation successfull.............");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
