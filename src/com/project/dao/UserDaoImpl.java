package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.model.User;
import com.project.utility.DButil;

public class UserDaoImpl implements UserDao {

	@Override
	public String customerRegistration(User user) {
		String msg = "Registration failed..";

		try (Connection conn = DButil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("Insert into user(uname,email,password) values(?,?,?)");

			ps.setString(1, user.getUname());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());

			int x = ps.executeUpdate();
			if (x > 0)
				msg = "Registration successfull\n" + "-------------------------\n" + "\n" + "Welcome "
						+ user.getUname().toUpperCase() + "\n";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return msg;

	}

	@Override
	public User userLogin(String email, String password) {
		User user = null;

		try (Connection conn = DButil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("Select * from user where email = ? AND password = ?");

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setCid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setEmail(rs.getString("email"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

}
