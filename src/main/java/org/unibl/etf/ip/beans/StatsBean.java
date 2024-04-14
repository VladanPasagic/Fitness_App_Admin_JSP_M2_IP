package org.unibl.etf.ip.beans;

import java.io.Serializable;
import java.util.List;

import org.unibl.etf.ip.dao.StatDAO;
import org.unibl.etf.ip.dtos.Log;

public class StatsBean implements Serializable{

	private static final long serialVersionUID = -1089444821485782669L;
	
	public List<Log> getLogs()
	{
		return StatDAO.readLogs();
	}

}
