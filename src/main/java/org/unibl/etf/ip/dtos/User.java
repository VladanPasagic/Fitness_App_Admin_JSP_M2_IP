package org.unibl.etf.ip.dtos;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6199124666473328338L;

	private int id;
	private String username;
	private String password;
	private String lastName;
	private String firstName;
	private String dtype;
	private String city;
	private String mail;

	public User() {
		super();
	}

	public User(int id, String username, String password, String lastName, String firstName) {
		super();
		this.username = username;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.id = id;
	}

	public User(int id, String username, String lastName, String firstName, String dtype, String city, String mail) {
		super();
		this.username = username;
		this.lastName = lastName;
		this.firstName = firstName;
		this.id = id;
		this.dtype = dtype;
		this.city = city;
		this.mail = mail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public int hashCode() {
		return Objects.hash(username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(username, other.username);
	}

}
