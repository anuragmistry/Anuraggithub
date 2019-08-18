package com.onmobile.stepDefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.onmobile.utils.Util;
import com.onmobile.xpaths.PortalXpath;

import cucumber.api.java.en.Then;

public class ErrorPageImpl implements PortalXpath{
	static Logger Log = LogManager.getLogger("test");
	Util util=new Util();
	By temp;
    WebDriver webdriver = Launcher.getdriver();
    
    @Then("^validate Error Page$")
    public void Validate_ErrorPage() throws Exception {
       String errorTxt=Launcher.getvaluefromExcelDataMap("ErrorPage_ErrorText");
 	   util.waitForLoad(webdriver);
 	   webdriver.findElement(ErrorPage).isDisplayed();
	   Log.info("Error section is present");
	   webdriver.findElement(Errortitle).isDisplayed();
	   Log.info("Error Title is present");
 	   String ErrorTitle=webdriver.findElement(Errortitle).getText();
	   Log.info("Error Page title name-->"+ErrorTitle);
	   webdriver.findElement(ErrorText).isDisplayed();
	   Log.info("Error Text is present");
 	   String errortext=webdriver.findElement(ErrorText).getText();
	   Log.info("Error text is-->"+errortext);
	   webdriver.findElement(Errorclosebtn).isDisplayed();
	   Log.info("Error close Button is present");
 	   String Errorbtn=webdriver.findElement(Errorclosebtn).getText();
	   Log.info("Error close button name-->"+Errorbtn);
	   webdriver.findElement(Errorclosebtn).click();
	   Log.info("Click on close Button");
    }
    
}
