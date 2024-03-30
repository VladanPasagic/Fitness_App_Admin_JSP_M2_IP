package org.unibl.etf.ip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.ip.dtos.Category;
import org.unibl.etf.ip.utilities.ConnectionFactory;
import org.unibl.etf.ip.utilities.DAOUtilities;

public class CategoryDAO {

	private static final String SQL_CREATE_CATEGORY = "insert into category where name=?";
	private static final String SQL_UPDATE_CATEGORY = "update category set name=? where id=?";
	private static final String SQL_DELETE_CATEGORY = "delete from category where id=?";
	private static final String SQL_READ_CATEGORIES = "select * from category";

	private static Category createCategory(String name) {
		Category category = null;
		Object[] values = { name };
		Connection con = ConnectionFactory.getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = DAOUtilities.prepareStatement(con, SQL_CREATE_CATEGORY, false, values);
				rs = ps.executeQuery();
				ResultSet generatedKeys = ps.getGeneratedKeys();
				category = new Category(generatedKeys.getInt(1), name);
				generatedKeys.close();
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return category;
	}

	private static Category updateCategory(int id, String name) {
		Category category = new Category(id, name);
		Object[] values = { name, id };
		Connection con = ConnectionFactory.getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = DAOUtilities.prepareStatement(con, SQL_UPDATE_CATEGORY, false, values);
				rs = ps.executeQuery();
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return category;
	}

	private static boolean deleteCategory(int id) {
		Object[] values = { id };
		Connection con = ConnectionFactory.getConnection();
		boolean result = false;
		ResultSet rs = null;
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = DAOUtilities.prepareStatement(con, SQL_DELETE_CATEGORY, false, values);
				rs = ps.executeQuery();
				if (rs.getInt(1) == 1) {
					result = true;
				}
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	private static List<Category> readCategories() {
		List<Category> categories = new ArrayList<Category>();
		Connection con = ConnectionFactory.getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(SQL_READ_CATEGORIES);
				rs = ps.executeQuery();
				while (rs.next()) {
					categories.add(new Category(rs.getInt("id"), rs.getString("name")));
				}
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return categories;
	}
}
