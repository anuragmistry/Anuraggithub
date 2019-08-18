package com.onmobile.stepDefinitions;


import com.onmobile.utils.Util;
import com.onmobile.xpaths.*;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterLinks implements PortalXpath {
	
	static Logger Log = LogManager.getLogger("test");
	Util util=new Util();
	By temp;
    WebDriver webdriver = Launcher.getdriver();
   
   @When("^Footer link section is present$")
   public void check_footer_section() throws Exception{
	   webdriver.findElement(FooterSection).isDisplayed();
	   Log.info("Footer section is present");
	   }
   @Then("^Validate CSS property for footer links$")
   public void validate_CSS_Menu_icon() throws Exception { 
	   String CssValue=Launcher.getvaluefromExcelDataMap("Footer_CSS_Properties_Value");
	   util.ScrollDown(FooterTextlink);
	   List<WebElement> footerlink=webdriver.findElements(FooterTextlink);
	   for(WebElement element: footerlink){
		   util.ScrollDown(element);
		   util.Validate_CSS_Properties_Value(element,CssValue);
	   }
   }
   @Then("^Validate footers$")
   public void validate_footers() throws Exception {
		  
		   List<String> footerlinks=new ArrayList<String>(); 
		   footerlinks=util.getOptionValue(FooterTextlink);
		   Log.info("footer Links from GUI are"+footerlinks);
		   String Links = Launcher.getvaluefromExcelDataMap("Footer_FooterLink");
		   Log.info("Excel sheet footer links are:"+Links);
		   List<String> Link = Arrays.asList(Links.split("::"));
		   Assert.assertTrue("Comapare both footer links",util.ComparetoListvalue(footerlinks, Link));  
		    }
   
   @Then("^Check footer links are present$")
   public void validate_footer_links() throws Exception{
	   util.ScrollDown(FooterTextlink);
	   List<WebElement> footerlink=webdriver.findElements(FooterTextlink);
	   int footerlinkNum=footerlink.size();
	   Log.info("Num of footer links Present in Home Page-->"+footerlinkNum);
	   for(WebElement element: footerlink){
		   Assert.assertTrue("Verify link Text",element.isDisplayed());
		   Log.info("Verify link Text Present in Home Page");


	   }
}
   @Then("^validate footer link pages$")
   public void footer_link_click() throws Exception {
	   List<String> footerlinks=new ArrayList<String>(); 
	   footerlinks=util.getOptionValue(FooterTextlink);
	   Log.info("footer Links from GUI are"+footerlinks);
	   for(String element: footerlinks){
		   util.ScrollDown(FooterSection);
		   Thread.sleep(2000);
		   temp=util.modifyXpath(Footerlink,element);
		   Thread.sleep(1000);
		   webdriver.findElement(temp).isDisplayed();
		   webdriver.findElement(temp).click();
		   Log.info("Clicked on Footer link ["+element+"] option");
		   Thread.sleep(1000);
		   String title = webdriver.getTitle();
		   Log.info("Current page title is" + title);
		   webdriver.navigate().back();
		   Thread.sleep(3000);
	   }
	   //String Links = Launcher.getvaluefromExcelDataMap("Footer_FooterLink");
	   //Log.info("Excel sheet footer links are:"+Links);
	   //List<String> Link = Arrays.asList(Links.split("::"));
	   //Assert.assertTrue("Comapare both footer links",util.ComparetoListvalue(footerlinks, Link));  
   }
   
   //Ugames
   @When("^Footer section is present$")
   public void Validate_footersection() throws Exception{
	   util.ScrollDown(Footer);
	   util.isElementPresent(Footer);
	   Log.info("Footer section is present");
	   }
   @Then("^Validate footer links are present$")
   public void validate_footer_links_Present() throws Exception{
	   util.ScrollDown(FooterLink);
	   List<WebElement> footerlink=webdriver.findElements(FooterLink);
	   int footerlinkNum=footerlink.size();
	   Log.info("Num of footer links Present in This Page-->"+footerlinkNum);
	   for(WebElement element: footerlink){
		   Assert.assertTrue("Verify link Text",element.isDisplayed());
		   Log.info("link Text Present in This Page--->"+element.getText());
		   Log.info("Verify link Text Present in This Page");
	   }
}
   @When("^Click on footer \"([^\"]*)\" link$")
	public void Click_On_footerLink(String link) throws Exception{
		temp=util.modifyXpath(SelectMenu,link);
		util.ScrollDown(temp);
		util.safeJavaScriptClick(temp);
		Log.info("Click on footer link--> "+link);
		util.waitForLoad(webdriver);
		String currentURL=webdriver.getCurrentUrl();
		Log.info("Fetch the Current Page url is-->"+currentURL);
	
	}
   @Then("^Validate Footer link section is present$")
   public void Validate_footer_section() throws Exception{
	   webdriver.findElement(FooterSection).isDisplayed();
	   Log.info("Footer section is present");
	   }
}
