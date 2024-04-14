package org.unibl.etf.ip.beans;

import java.io.Serializable;
import java.util.List;

import org.unibl.etf.ip.dao.CategoryDAO;
import org.unibl.etf.ip.dtos.Category;

public class CategoriesBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 650726096462982062L;

	public List<Category> getCategories() {
		return CategoryDAO.readCategories();
	}
}
