package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.exception.TicketException;
import com.project.model.Bus;
import com.project.model.Tickets;
import com.project.utility.DButil;

public class TicketsDaoImpl implements TicketsDao {

	@Override
	public List<Tickets> bookingData(Tickets tickets) throws TicketException {
		List<Tickets> list = new ArrayList<>();// thik karo isko ye string return karega
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
				// System.out.println("Updation successfull.............");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}
//		if (list.isEmpty()) {
//			throw new TicketException("Ticket booking failed please try again");
//		}

		return list;
	}

	@Override
	public List<Tickets> PrintTickets(String referenceID, String email) throws TicketException {
		List<Tickets> list = new ArrayList<>();
		try (Connection conn = DButil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from tickets where referenceID = ? AND email = ?");

			ps.setString(1, referenceID);
			ps.setString(2, email);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Tickets t1 = new Tickets();
				t1.setReferenceID(rs.getString("referenceID"));
				t1.setBid(rs.getInt("bid"));
				t1.setPassangerName(rs.getString("passangerName"));
				t1.setPassangerAge(rs.getInt("passangerAge"));

				t1.setDestinationFrom(rs.getString("destinationFrom"));
				t1.setDestinationTo(rs.getString("destinationTo"));
				t1.setDeparture(rs.getString("departure"));
				t1.setArrival(rs.getString("arrival"));
				t1.setEmail(rs.getString("email"));

				// add to list
				list.add(t1);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();

		}

		if (list.isEmpty()) {
			throw new TicketException("Reference id is not valid");
		}

		return list;
	}

	@Override
	public List<String> ShowRefID(String email) {
		List<String> listRefId = new ArrayList<>();

		try (Connection conn = DButil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select referenceID from tickets where email = ?");
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String id = rs.getString("referenceID");
				if (!listRefId.contains(id)) {
					listRefId.add(id);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listRefId;
	}

}
