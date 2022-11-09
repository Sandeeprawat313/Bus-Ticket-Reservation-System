package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.project.utility.DButil;

public class TicketBookingImpl implements TicketBookingDao {

	@Override
	public String BookTicket(int userid, int busid) {
		String msg = "Tcket booked";

		try (Connection conn = DButil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("Insert into book_Bus_Tickets(userid,busid) values(?,?)");

			ps.setInt(1, userid);
			ps.setInt(2, busid);

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
