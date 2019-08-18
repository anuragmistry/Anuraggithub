package com.onmobile.stepDefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.onmobile.utils.Util;
import com.onmobile.xpaths.PortalXpath;

import cucumber.api.java.en.Given;

public class ModifyModHeader implements PortalXpath{
	 By temp;
	 Util util=new Util();
	 static WebDriver driver=Launcher.getdriver();
	 static Logger Log = LogManager.getLogger("test");
	 
	@Given("^Add \"([^\"]*)\" with \"([^\"]*)\" in Mod Header$")
	public void add_Requested_ModHeader(String requestHaederName,String val) throws Throwable {

		driver.findElement(By.xpath("//button[@tooltip='Add New']")).click();

		WebElement actionElem = driver.findElement(By.name("action"));
		Select select = new Select(actionElem);
		select.selectByVisibleText("Add");

		WebElement nameElem = driver.findElement(By.name("name"));
		nameElem.sendKeys("x-control-id");
		WebElement valueElem = driver.findElement(By.name("value"));

		valueElem.sendKeys(val);

		WebElement descElem = driver.findElement(By.name("description"));
		descElem.sendKeys("Add "+requestHaederName+" property in Mod header");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='btn_save_3']")).click();
		Thread.sleep(1000);	
		driver.findElement(By.xpath("//button[@id='btn_enable_3']")).click();
		Log.info("Add the ["+requestHaederName+"] and value ["+val+"] in Mod Header");
	}
}
