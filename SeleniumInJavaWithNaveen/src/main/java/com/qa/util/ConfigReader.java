package com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private Properties prop;
	private static final String CONFIG_PATH = "./src/test/resources/config/config.properties";

	public Properties init_prop() {
		prop = new Properties();
		try (FileInputStream ip = new FileInputStream(CONFIG_PATH)) {
			prop.load(ip);
		} catch (IOException e) {
			System.err.println("Error reading config file: " + e.getMessage());
		}
		return prop;
	}

	public String getBrowser() {
		if (prop == null) {
			init_prop();
		}
		String browser = prop.getProperty("browser");
		return (browser != null && !browser.trim().isEmpty())
				? browser.trim().toLowerCase()
				: "chrome"; // default browser
	}
}