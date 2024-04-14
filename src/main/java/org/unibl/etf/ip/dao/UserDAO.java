package org.unibl.etf.ip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.ip.dtos.User;
import org.unibl.etf.ip.utilities.ConnectionFactory;
import org.unibl.etf.ip.utilities.DAOUtilities;

public class UserDAO {

	private static final String SQL_SELECT_BY_USERNAME_AND_PASSWORD = "select * from user where username=? and password=? and dtype=\"AdminEntity\"";
	private static final String SQL_READ_USERS = "select * from user";

	public static User getByUsernameAndPassword(String username, String password) {
		User user = null;
		Object[] values = { username, password };
		Connection con = ConnectionFactory.getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = DAOUtilities.prepareStatement(con, SQL_SELECT_BY_USERNAME_AND_PASSWORD, false, values);
				rs = ps.executeQuery();
				if (rs.next()) {
					user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
							rs.getString("last_name"), rs.getString("first_name"));
				}
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	public static List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		Connection con = ConnectionFactory.getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(SQL_READ_USERS);
				rs = ps.executeQuery();
				while (rs.next()) {
					users.add(new User(rs.getInt("id"), rs.getString("username"), rs.getString("last_name"),
							rs.getString("first_name"), rs.getString("dtype"), rs.getString("city"),
							rs.getString("mail")));
				}
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}
}
