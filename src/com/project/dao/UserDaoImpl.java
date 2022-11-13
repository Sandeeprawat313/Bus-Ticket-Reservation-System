package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.exception.UserException;
import com.project.model.User;
import com.project.utility.DButil;

public class UserDaoImpl implements UserDao {

	@Override
	public String customerRegistration(User user) throws UserException {
		String msg = "Registration failed..";

		try (Connection conn = DButil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("Insert into user(uname,email,password) values(?,?,?)");

			ps.setString(1, user.getUname());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());

			int x = ps.executeUpdate();
			if (x > 0)
				msg = "Registration successfull";

		} catch (SQLException e) {
			msg = e.getMessage();
		}

		return msg;

	}

	@Override
	public User userLogin(String email, String password) throws UserException {
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
			throw new UserException(e.getMessage());
		}

		if (user == null) {
			throw new UserException("Wrong credentials please try again with the correct username and password");
		}

		return user;
	}

}
