package com.onmobile.stepDefinitions;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.onmobile.dataProvider.PropertyReader;

//import com.onmobile.dataProvider.PropertyReader;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
public class Hooks {
	static Logger Log = LogManager.getLogger("test");
	WebDriver webdriver = Launcher.getdriver();
	
	@Before
    public void beforeScenario(Scenario scenario){
		PropertyReader.loadAllProperties();
		System.err.println("-----------------Start of Scenario-----------------");
		Log.info("Currently execute Scenario Name is-->" +scenario.getName());
    }	
	
	
	@After
	public void afterScenario(Scenario scenario) {
		System.err.println("-----------------End of Scenario-----------------");
		if (scenario.isFailed()) {
	//    	String screenshotName = scenario.getName().replaceAll(" ", "_");
	    	Log.info("Failed Scenario Name is-->" +scenario.getName());
	        try {
	            byte[] screenshot = ((TakesScreenshot)webdriver).getScreenshotAs(OutputType.BYTES);
	            scenario.embed(screenshot, "image/png" );
	            scenario.write("URL at failure: " + webdriver.getCurrentUrl());
	        } catch (WebDriverException wde) {
	        	scenario.write("Embed Failed " + wde.getMessage());
	        } catch (ClassCastException cce) {
	            cce.printStackTrace();
	        }
	   
	      /*  webdriver.quit();
			Log.info("closed the browser");*/
	    }/*else {
	    	
	    	webdriver.quit();
			Log.info("closed the browser");
	    }*/
	}
	/*@After(order=1)
    public void afterScenario_close(){
		webdriver.close();
		Log.info("closed the browser");
        System.err.println("Log out the user and close the browser");
    }*/	
}
