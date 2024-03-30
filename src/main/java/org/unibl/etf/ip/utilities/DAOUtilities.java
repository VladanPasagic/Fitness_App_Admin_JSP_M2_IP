package org.unibl.etf.ip.utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOUtilities {
	public static PreparedStatement prepareStatement(Connection con, String sql, boolean returnGeneratedKeys,
			Object... values) throws SQLException {
		PreparedStatement statement = con.prepareStatement(sql,
				returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
		setValues(statement, values);
		return statement;
	}

	public static void setValues(PreparedStatement statement, Object... values) throws SQLException {
		for (int i = 0; i < values.length; i++) {
			statement.setObject(i + 1, values[i]);
		}
	}
}
