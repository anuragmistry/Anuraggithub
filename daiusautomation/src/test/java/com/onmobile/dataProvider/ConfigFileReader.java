package com.onmobile.dataProvider;

import java.io.FileInputStream;
import java.util.Properties;


public class ConfigFileReader {
	
	public static Properties properties;
	public static String propertyFilePath = "src\\test\\resources\\config\\config.properties";
	
	public void configFileReader(String configFileName)  
	{
		
		propertyFilePath = "src\\test\\resources\\config\\"+configFileName+".properties";
		
		if (properties != null) {//config.properties is only read once. This if statement ensures that config file is read ONLY ONCE.
				return;
			}
			properties = new Properties();
			try{
				System.out.println("Loading config.properties data.");
				properties.load(new FileInputStream(propertyFilePath));
			}catch(Exception e){
				throw new RuntimeException("Could not read Properties File");
			}
			
			if((properties.getProperty("HTTP_PROXY_REQUIRED","false").equalsIgnoreCase("true"))){
				
				System.setProperty("http.proxyHost", properties.getProperty("HTTP_PROXY_IP"));
				System.setProperty("http.proxyPort", properties.getProperty("HTTP_PROXY_PORT"));
				System.setProperty("http.proxyUser", properties.getProperty("HTTP_PROXY_USERNAME"));
				System.setProperty("http.proxyPassword", properties.getProperty("HTTP_PROXY_PASSWORD"));
				
				System.out.println("PROXY IS SET : IP-"+System.getProperty("http.proxyHost")+" PORT-"+System.getProperty("http.proxyPort")+" Username-"+System.getProperty("http.proxyUser")+" Password-"+System.getProperty("http.proxyPassword"));						
			}
			
		}
		
		public String getProperty(String propertyName){
			return properties.getProperty(propertyName);
		}
		
		public void setProperty(String propertyName , String propertyvalue){
			properties.setProperty(propertyName, propertyvalue);
		}
		
		public static void printProperty(String propertyName){
			System.out.println(properties.getProperty(propertyName));
		}
	}