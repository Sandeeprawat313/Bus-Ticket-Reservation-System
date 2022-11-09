package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.project.model.Bus;
import com.project.utility.DButil;

public class BusDaoImpl implements BusDao {

	@Override
	public String addBusDetails(Bus bus) {
		String msg = "Insertion failed";

		try (Connection conn = DButil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"insert into bus (destinationFrom, destinationTo, departure, arrival, seatsAvailable) values(?,?,?,?,?)");
			
			ps.setString(1, bus.getDestinationFrom());
			ps.setString(2, bus.getDestinationTo());
			ps.setString(3, bus.getDeparture());
			ps.setString(4, bus.getArrival());
			ps.setInt(5, bus.getSeatsAvailable());
			
			
			int x = ps.executeUpdate();
			if (x > 0)
				msg = "insertion successfull";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return msg;
	}

}
