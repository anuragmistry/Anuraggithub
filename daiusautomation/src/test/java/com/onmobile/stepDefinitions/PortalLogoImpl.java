package com.onmobile.stepDefinitions;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.onmobile.utils.Util;
import com.onmobile.xpaths.PortalXpath;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;


public class PortalLogoImpl implements PortalXpath {
	
	static Logger Log = LogManager.getLogger("test");
	WebDriver driver =Launcher.getdriver();
	Util util=new Util();
	PageConfirmation pageconfirmation=new PageConfirmation();
	@Then("^validate portal logo$")
	public void validate_portal_logo() throws Exception { 
        util.waitForElementToAppear(PortalLogoImg);
        Thread.sleep(2000);
        Assert.assertTrue("Portal Logo icon is present",util.isElementPresent(PortalLogoImg));
		Log.info("Portal logo image is displayed");
	}
	@Then("^Validate CSS property for portal logo$")
	public void validate_CSS_Menu_icon() throws Exception { 
		String CssValue=Launcher.getvaluefromExcelDataMap("PortalLogo_CSS_Properties_Value");
		util.Validate_CSS_Properties_Value(Launcher.getdriver().findElement(PortalLogoImg),CssValue);
	}
	@Then("^validate portal logo link$")
	public void validate_portal() throws Exception{
		Launcher.getdriver().findElement(PortalLogoLink).click();
		Launcher.getdriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actualtitle = Launcher.getdriver().getTitle();
		Log.info("Got portal title as "+ actualtitle);
		String expectedtitle =Launcher.getvaluefromExcelDataMap("CommonPortalDataSet_HomePageTitle");
		Assert.assertEquals(expectedtitle, actualtitle);
		if(actualtitle.equalsIgnoreCase(expectedtitle))
			Log.info("Title is matched");
		else
			Log.info("Title didn't match");
	}
	@Then("^Click portal logo link and landing in Portal Home page$")
	public void click_On_portal_logoLink() throws Exception{
		Launcher.getdriver().findElement(PortalLogoLink).click();
		Log.info("Click on Portal Logo Link and Landing in Home Page");
		Thread.sleep(1000);
	}
	@Then("^validate portal logo is not present$")
	public boolean validate_portal_logo_Notpresent() throws Exception { 
		try {
			if(!Launcher.getdriver().findElement(PortalLogoImg).isDisplayed());
			Log.info("Portal logo image is not displayed");
			return true;
		}catch (Exception e) {
			Log.info("Portal logo image is displayed");
			return false;
		}

	}
	@And("^Validate portal logo Dimension$")
	public void validate_portal_logo_Dimension() throws Throwable { 
		String dimension=Launcher.getvaluefromExcelDataMap("PortalLogo_Dimension");
        Assert.assertTrue("Validate Image Dimension",util.check_dimensions(Launcher.getdriver().findElement(SearchImg), dimension));
		Log.info("Validate search image dimension");
	}	
	
	
	//Ugames
	@Then("^Validate portal Logo Text$")
	public void validate_logo_Text() throws Exception { 
        util.waitForElementToAppear(LogoText);
        Assert.assertTrue("Portal Logo icon is present",util.isElementPresent(LogoText));
		Log.info("Portal logo image is displayed");
	}
	@Then("^Click and Validate Portal logo link$")
	public void Click_validate_portal_Link() throws Exception{
		Launcher.getdriver().findElement(LogoLink).click();
		Assert.assertTrue("Page confirmation", pageconfirmation.isHomePage());
		Log.info("Validate we in our expected Home page");
	}
}
