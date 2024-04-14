package org.unibl.etf.ip.enums;

public enum LoggingLevel {
	TRACE(0), DEBUG(1), INFO(2), WARN(3), ERROR(4), FATAL(5);

	private int level;

	LoggingLevel(int i) {
		level = i;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public static LoggingLevel fromInt(int level) {
		for (LoggingLevel enumValue : LoggingLevel.values()) {
			if (enumValue.level == level) {
				return enumValue;
			}
		}
		throw new IllegalArgumentException("Invalid integer value for enum");
	}

}
