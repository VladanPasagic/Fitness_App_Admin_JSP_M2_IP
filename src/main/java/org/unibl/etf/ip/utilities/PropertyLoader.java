package org.unibl.etf.ip.utilities;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

public class PropertyLoader {

	private static final String PROPERTIES_PATH = "WEB-INF/resources/config.prop";

	private static Properties prop = new Properties();

	public static void load(ServletContext context) {
		try {
			InputStream input = context.getResourceAsStream(PROPERTIES_PATH);
			prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return prop.get(key).toString();
	}
}
