package org.unibl.etf.ip.dtos;

import java.util.Date;

import org.unibl.etf.ip.enums.LoggingLevel;

public class Log {
	private int id;
	private LoggingLevel level;
	private String message;
	private Date timestamp;

	public Log(int id, LoggingLevel level, String message, Date timestamp) {
		super();
		this.id = id;
		this.level = level;
		this.message = message;
		this.timestamp = timestamp;
	}

	public Log() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LoggingLevel getLevel() {
		return level;
	}

	public void setLevel(LoggingLevel level) {
		this.level = level;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
