package org.unibl.etf.ip.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static String jdbcUrl;
	private static String username;
	private static String password;

	static {
		jdbcUrl = PropertyLoader.getProperty("database.url");
		username = PropertyLoader.getProperty("database.username");
		password = PropertyLoader.getProperty("database.password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(jdbcUrl, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
