package org.unibl.etf.ip.beans;

import java.io.Serializable;

import org.unibl.etf.ip.dtos.Category;

public class CategoryBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2994216378286208734L;

	private Category category;

	public CategoryBean(Category category) {
		super();
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
