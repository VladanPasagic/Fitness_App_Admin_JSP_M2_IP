package org.unibl.etf.ip.beans;

import java.io.Serializable;
import java.util.List;

import org.unibl.etf.ip.dao.UserDAO;
import org.unibl.etf.ip.dtos.User;

public class UsersBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6338903508447198786L;
	
	public List<User> getUsers()
	{
		return UserDAO.getUsers();
	}

}
