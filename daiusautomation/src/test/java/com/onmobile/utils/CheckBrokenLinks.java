package com.onmobile.utils;

import java.util.List;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.*;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.onmobile.stepDefinitions.Launcher;



public class CheckBrokenLinks extends Launcher{
	static WebDriver webDriver=Launcher.getdriver();
	static Logger Log = LogManager.getLogger("test");

	public static List<WebElement> findAllLinks()

	{

		List<WebElement> elementList = new ArrayList();

		elementList = webDriver.findElements(By.tagName("a"));

		elementList.addAll(webDriver.findElements(By.tagName("img")));

		List<WebElement> finalList = new ArrayList();

		for (WebElement element : elementList) {

			if (element.getAttribute("href") != null)

			{
				finalList.add(element);

			}

		}

		return finalList;
	}

	public static String isLinkBroken(URL url) throws Exception{
		// url = new URL("http://yahoo.com");
		String response = "";
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		try {
			connection.connect();
			response = connection.getResponseMessage();
			connection.disconnect();
			
			Log.info("URL: "+url+"  Response: "+response);
			
			return response;

		}

		catch (Exception exp) {
			return exp.getMessage();
		}
	}

	//public static void main(String[] args) throws Exception {
	public static void findBrokenLinks() throws Throwable
	{
		
		//use already existing driver only
		//WebDriver driver;
		int brokenLinksCount=0;
		ArrayList<String> brokenLinks = new ArrayList<String>();
		String resmsg=null;
	
		webDriver.get(webDriver.getCurrentUrl());
		List<WebElement> allLinks = findAllLinks();

		System.out.println("Total number of Links found " + allLinks.size());
		Log.info("Total number of Links found " + allLinks.size());

		for (WebElement element : allLinks) {
			try {
				
				resmsg = isLinkBroken(new URL(element.getAttribute("href")));
				// System.out.println(element.getLocation());
				//System.out.println("URL: " + element.getAttribute("href") + " Return Status Message: "+resmsg);
				
				if(!resmsg.equalsIgnoreCase("OK")){
					System.out.println("Broken URL: " + element.getAttribute("href") + " Return Status Message: "+resmsg);
					Log.info("Broken URL: " + element.getAttribute("href") + " Return Status Message: "+resmsg);
					
					brokenLinks.add(element.getAttribute("href"));
					brokenLinksCount++;
				}
				
			} catch (Exception exp) {
				System.out.println("At " + element.getAttribute("innerHTML") + " Exception occured -&gt; " + exp.getMessage());
			}
		}
		
		
		if(brokenLinksCount>0){
			System.out.println("Total Broken Links : "+brokenLinksCount);
			Log.info("Total Broken Links : "+brokenLinksCount);
			
			Log.info("Page \""+webDriver.getCurrentUrl()+"\"has broken links.\nBroken Links Count: "+brokenLinksCount+"\nURLs:\n"+brokenLinks.toString());			
			Assert.fail("Page \""+webDriver.getCurrentUrl()+"\"has broken links.\nBroken Links Count: "+brokenLinksCount+"\nURLs:\n"+brokenLinks.toString());
		}
		
	}
}