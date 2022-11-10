package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<Bus> showALLTravelSchedule() {
		List<Bus> list = new ArrayList<>();

		try (Connection conn = DButil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("Select * from bus");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Bus bus = new Bus();
				bus.setBid(rs.getInt("bid"));
				bus.setDestinationFrom(rs.getString("destinationFrom"));
				bus.setDestinationTo(rs.getString("destinationTo"));
				bus.setDeparture(rs.getString("departure"));
				bus.setArrival(rs.getString("arrival"));
				bus.setSeatsAvailable(rs.getInt("seatsAvailable"));
				list.add(bus);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Bus> showTravelDetailsRoute(String startingPoint, String destination) {
		List<Bus> list = new ArrayList<>();

		try (Connection conn = DButil.provideConnection()) {
			PreparedStatement ps = conn
					.prepareStatement("Select * from bus where destinationFrom = ? AND destinationTo = ?");

			ps.setString(1, startingPoint);
			ps.setString(2, destination);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Bus bus = new Bus();
				bus.setBid(rs.getInt("bid"));
				bus.setDestinationFrom(rs.getString("destinationFrom"));
				bus.setDestinationTo(rs.getString("destinationTo"));
				bus.setDeparture(rs.getString("departure"));
				bus.setArrival(rs.getString("arrival"));
				bus.setSeatsAvailable(rs.getInt("seatsAvailable"));
				list.add(bus);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Bus ShowDetailsAsPerbid(int a) {
		Bus bus = null;
		try (Connection conn = DButil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("Select * from bus where bid = ?");
			ps.setInt(1, a);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				bus = new Bus();
				bus.setBid(rs.getInt("bid"));
				bus.setDestinationFrom(rs.getString("destinationFrom"));
				bus.setDestinationTo(rs.getString("destinationTo"));
				bus.setDeparture(rs.getString("departure"));
				bus.setArrival(rs.getString("arrival"));
				bus.setSeatsAvailable(rs.getInt("seatsAvailable"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bus;
	}

	@Override
	public void updateSeats(int seat, int bid) {
		Connection conn = DButil.provideConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("update bus set seatsAvailable = seatsAvailable - ? where bid = ?");
			ps.setInt(1, seat);
			ps.setInt(2, bid);
			
			int x = ps.executeUpdate();
			if(x > 0 ) {
				System.out.println("Updation sucessfull");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
