package org.unibl.etf.ip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.ip.dtos.Log;
import org.unibl.etf.ip.enums.LoggingLevel;
import org.unibl.etf.ip.utilities.ConnectionFactory;

public class StatDAO {

	private static final String SQL_READ_LOGS = "select * from log";

	public static List<Log> readLogs() {
		List<Log> logs = new ArrayList<Log>();
		Connection con = ConnectionFactory.getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(SQL_READ_LOGS);
				rs = ps.executeQuery();
				while (rs.next()) {
					logs.add(new Log(rs.getInt("id"), LoggingLevel.fromInt(rs.getInt("level")), rs.getString("message"),
							rs.getDate("timestamp")));
				}
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return logs;
	}
}
