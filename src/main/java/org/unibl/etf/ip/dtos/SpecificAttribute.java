package org.unibl.etf.ip.dtos;

public class SpecificAttribute {
	private int id;
	private String attribute;
	private String value;

	public SpecificAttribute() {
		super();
	}

	public SpecificAttribute(int id, String attribute, String value) {
		super();
		this.id = id;
		this.attribute = attribute;
		this.value = value;
	}
	
	public SpecificAttribute(String attribute, String value)
	{
		this.attribute = attribute;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
