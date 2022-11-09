package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.project.model.User;
import com.project.utility.DButil;

public class UserDaoImpl implements UserDao {

	@Override
	public String CustomerRegistration(User user) {
		String msg = "Registration Successful..";

		try (Connection conn = DButil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("Insert into user(uname,email,password) values(?,?,?)");

			ps.setString(1, user.getUname());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());

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
