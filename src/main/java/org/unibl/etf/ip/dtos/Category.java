package org.unibl.etf.ip.dtos;

import java.util.List;
import java.util.Objects;

public class Category {
	private int id;
	private String name;
	private List<SpecificAttribute> specificAttributes;

	public Category() {
		super();
	}

	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return id == other.id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SpecificAttribute> getSpecificAttributes() {
		return specificAttributes;
	}

	public void setSpecificAttributes(List<SpecificAttribute> specificAttributes) {
		this.specificAttributes = specificAttributes;
	}

}
