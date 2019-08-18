package com.onmobile.stepDefinitions;

import java.util.List;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import com.onmobile.utils.Util;
import com.onmobile.xpaths.PortalXpath;

import cucumber.api.java.en.Then;

public class CookiesPageImpl implements PortalXpath{
	static Logger Log = LogManager.getLogger("test");
	Util util=new Util();
	
	WebDriver webdriver=Launcher.getdriver();
	
	@Then("^Validate cookie message$")
	public void validate_cookie_message() throws Exception {
		Set<Cookie> ckText=webdriver.manage().getCookies();
		Log.info("Get the Cookies Here Link-->"+ckText);
		util.deleteAllCookies();
		Log.info("Delete all the cookies");
		util.RefreshThePage();
		Log.info("Refresh the Page");
		util.waitForElementToAppear(CookiesText);
		webdriver.findElement(CookiesText).isDisplayed();
		Log.info("Validate Cookies Messages");
		String text=webdriver.findElement(CookiesText).getText();
		Log.info("Get the cookies messages-->"+text);
		
		webdriver.findElement(CookiesHereLink).isDisplayed();
		Log.info("Validate Cookies Here Link");
		String link=webdriver.findElement(CookiesHereLink).getText();
		Log.info("Get the Cookies Here Link-->"+link);
		
		util.safeJavaScriptClick(CookiesHereLink);
		Log.info("Click on Cookies Here Link");
	}
	
	@Then("^Click on aqui link within the message and Navigate the cookie Page$")
	public void validate_Navigate_cookies_Page() throws Exception {
		util.waitForLoad(webdriver);
		String currentURL=webdriver.getCurrentUrl();
		Log.info("Fetch teh Current cookie Page url is-->"+currentURL);
		Thread.sleep(500);
		String PageTitle = webdriver.getTitle();
		Log.info("Current cookie Page Title-->"+PageTitle);
		List<String> Text= util.getOptionValue(CookiesHeaderTitle);
		Log.info("Cookies Header Title is Cookie Page-->"+Text);
		util.GotoPageEnd();
	}
	@Then("^Validate cookie notice and click on Entendido button$")
	public void validate_cookie_notice_EntendidoBtn() throws Exception {
		Set<Cookie> ckText=webdriver.manage().getCookies();
		Log.info("Get the Cookies Here Link-->"+ckText);
		util.deleteAllCookies();
		Log.info("Delete all the cookies");
		util.RefreshThePage();
		Log.info("Refresh the Page");
		util.waitForElementToAppear(CookieNotice);
		util.isElementPresent(CookieNotice);
		Log.info("Validate CookieNotice Messages");
		String text=webdriver.findElement(CookieNotice).getText();
		Log.info("Get the CookieNotice messages-->"+text);
		
		/*util.isElementPresent(Understoodbtn);
		Log.info("Validate Understood Btn");
		
		util.isElementPresent(MoreInfoBtn);
		Log.info("Validate MoreInfo Btn");
		
		util.safeJavaScriptClick(Understoodbtn);
		Log.info("Click on Entendido Button");*/
	}
	
	@Then("^Validate cookie notice$")
	public void validate_cookie_notice_Ugames() throws Exception {
		Set<Cookie> ckText=webdriver.manage().getCookies();
		Log.info("Get the Cookies Here Link-->"+ckText);
		util.deleteAllCookies();
		Log.info("Delete all the cookies");
		util.RefreshThePage();
		Log.info("Refresh the Page");
		util.waitForElementToAppear(CookieNotice);
		util.isElementPresent(CookieNotice);
		Log.info("Validate CookieNotice Messages");
		String text=webdriver.findElement(CookieNotice).getText();
		Log.info("Get the CookieNotice messages-->"+text);
		
		util.isElementPresent(CloseCookieNotice);
		Log.info("Validate Close Btn");
		
		util.isElementPresent(CookiesMoreInfo);
		Log.info("Validate Aqui link");
		
	}
	@Then("^Click on aqui link and Navigate to cookie Page$")
	public void validate_Navigate_cookies_Page_Ugames() throws Exception {
		util.safeJavaScriptClick(CookiesMoreInfo);
		Log.info("Click on Aqui link");
		Thread.sleep(500);
		util.waitForLoad(webdriver);		
		for(String winHandle:webdriver.getWindowHandles()){
		    webdriver.switchTo().window(winHandle); 
		}
		String currentURL=webdriver.getCurrentUrl();
		Log.info("Fetch the Current cookie Page url is-->"+currentURL);
		Thread.sleep(500);
		String PageTitle = webdriver.getTitle();
		Log.info("Current cookie Page Title-->"+PageTitle);
		List<String> Text= util.getOptionValue(CookiePageHeaders);
		Log.info("Cookies Header Title is Cookie Page-->"+Text);
		util.GotoPageEnd();
		
		webdriver.close();
		for(String winHandle:webdriver.getWindowHandles()){
		    webdriver.switchTo().window(winHandle); 
		}
		Thread.sleep(500);
		
		util.safeJavaScriptClick(CloseCookieNotice);
		Log.info("Click on Close cookie noice button");
	}
}
	
