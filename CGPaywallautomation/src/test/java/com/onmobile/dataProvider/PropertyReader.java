package com.onmobile.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.PropertiesConfigurationLayout;

public class PropertyReader {

	public static Properties properties;
	public static String propertyFilePath = "src\\test\\resources\\config\\config.properties";
	public static String baseurl="localhost";
	
	static PropertiesConfiguration propertiesConfiguration;

	public PropertyReader() {
		// loadAllProperties();
	}

	public static void loadAllProperties() {
		if (properties != null) { // config.properties is only read once. This if statement ensures that config
			return;
		}
		properties = new Properties();
		try {
			System.out.println("Loading config.properties data.");
			properties.load(new FileInputStream(propertyFilePath));
			baseurl=properties.getProperty("Page_Load_Url");
		} catch (Exception e) {
			throw new RuntimeException("Could not read Properties File");
		}
	}

	public static String readItem(String propertyName) {
		return properties.getProperty(propertyName);
	}

	public static void setItem(String propertyName, String propertyvalue) {
		properties.setProperty(propertyName, propertyvalue);
	}

	public static void WritePropertiesFile(String propertyName, String propertyValue)
			throws IOException, ConfigurationException {
		File file = new File(propertyFilePath);
		PropertiesConfiguration config = new PropertiesConfiguration();
		PropertiesConfigurationLayout layout = new PropertiesConfigurationLayout(config);
		layout.load(new InputStreamReader(new FileInputStream(file)));
		config.setProperty(propertyName, propertyValue);
		layout.save(new FileWriter(propertyFilePath, false));
	}
}