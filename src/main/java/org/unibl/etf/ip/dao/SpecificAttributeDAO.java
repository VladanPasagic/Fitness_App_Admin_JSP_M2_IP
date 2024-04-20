package org.unibl.etf.ip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.ip.dtos.SpecificAttribute;
import org.unibl.etf.ip.utilities.ConnectionFactory;
import org.unibl.etf.ip.utilities.DAOUtilities;

public class SpecificAttributeDAO {

	private static final String SQL_CREATE_ATTRIBUTE = "insert into specific_attribute (attribute, value) values (?,?)";
	private static final String SQL_ADD_ATTRIBUTE_TO_CATEGORY = "insert into category_specific_attributes values (?,?)";
	private static final String SQL_READ_SPECIFIC_ATTRIBUTES = "SELECT * FROM category_specific_attributes csa join specific_attribute sa on csa.specific_attributes_id=sa.id where category_entity_id=?";

	public static void saveAttributes(int categoryId, List<SpecificAttribute> list) {
		Connection con = ConnectionFactory.getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		if (con != null) {
			for (SpecificAttribute specificAttribute : list) {
				Object[] values = { specificAttribute.getAttribute(), specificAttribute.getValue() };
				try {
					ps = DAOUtilities.prepareStatement(con, SQL_CREATE_ATTRIBUTE, true, values);
					ps.execute();
					rs = ps.getGeneratedKeys();
					rs.first();
					Object[] statementValues = { categoryId, rs.getInt(1) };
					ps = DAOUtilities.prepareStatement(con, SQL_ADD_ATTRIBUTE_TO_CATEGORY, false, statementValues);
					ps.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static List<SpecificAttribute> getSpecificAttributes(int id) {
		List<SpecificAttribute> specificAttributes = new ArrayList<SpecificAttribute>();
		Connection con = ConnectionFactory.getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		Object[] values = { id };
		if (con != null) {
			try {
				ps = DAOUtilities.prepareStatement(con, SQL_READ_SPECIFIC_ATTRIBUTES, false, values);
				rs = ps.executeQuery();
				while (rs.next()) {
					specificAttributes.add(
							new SpecificAttribute(rs.getInt("id"), rs.getString("attribute"), rs.getString("value")));
				}
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return specificAttributes;
	}
}
