package org.unibl.etf.ip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.unibl.etf.ip.dtos.User;
import org.unibl.etf.ip.utilities.ConnectionFactory;
import org.unibl.etf.ip.utilities.DAOUtilities;

public class UserDAO {

	private static final String SQL_SELECT_BY_USERNAME_AND_PASSWORD = "select * from user where username=? and password=?";

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
}
