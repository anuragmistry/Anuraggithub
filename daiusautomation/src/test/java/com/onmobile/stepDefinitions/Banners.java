package com.onmobile.stepDefinitions;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.onmobile.utils.Util;
import com.onmobile.xpaths.PortalXpath;

import cucumber.api.java.en.Then;

public class Banners implements PortalXpath{
	
	
	static Logger Log = LogManager.getLogger("test");
	WebDriver webdriver = Launcher.getdriver();
	Util util=new Util();
	By temp;
	@Then("^validate is banner present$")
	public void validate_banner() throws Exception{
		webdriver.findElement(BannerImage).isDisplayed();
		Log.info("Banner is present");
	}
	@Then("^Validate CSS property for banner images$")
	public void validate_CSS_Menu_icon() throws Exception { 
		String CssValue=Launcher.getvaluefromExcelDataMap("Banner_CSS_Properties_Value");
		
		List<WebElement> BanImg = webdriver.findElements(BannerImage);
		for(WebElement element: BanImg){
			util.ScrollDown(element);
			util.Validate_CSS_Properties_Value(element,CssValue);
		}
	}
	@Then("^validate the dimension of banner$")
	public void validate_banner_dim() throws Exception{
		String dim=Launcher.getvaluefromExcelDataMap("Banner_Dimension");
		List<WebElement> BannImg=webdriver.findElements(BannerImage);
		for(WebElement element: BannImg){
			Assert.assertTrue("Validate Image Dimension", util.check_dimensions(element, dim));
			Log.info("Got banner dimension from excelsheet");
		}
	}
	
	@Then("^validate banner image$")
	public void validate_banner_image() throws Exception{		
		util.ScrollDown(BannerImage);
		List<WebElement> BanImg = webdriver.findElements(BannerImage);
		int BannImgNum = BanImg.size();
		Log.info("Num of Banner Image Present in Home Page-->"+BannImgNum);
		for(WebElement element: BanImg){
			Assert.assertTrue("Banner Image validation",element.isDisplayed());
			Log.info("Banner image validated");
		}
	}
	@Then("^Click on \"([^\"]*)\" Banner$")
	public void Click_On_Banner(String nth) throws Exception{		
		util.ScrollDown(BannerImage);
		List<WebElement> BanImg = webdriver.findElements(BannerImage);
		int BannImgNum = BanImg.size();
		Log.info("Num of Banner Image Present in Home Page-->"+BannImgNum);
		temp=util.modifyXpath(ClickOnNthBanner,nth);
		util.ScrollDown(temp);
		util.safeJavaScriptClick(temp);
		Log.info("Click on ["+nth+"] banner in Home page");
		String currentURL=webdriver.getCurrentUrl();
		Log.info("Fetch the current Page url is-->"+currentURL);

		String currentTitle = webdriver.getTitle();
		Log.info("Current Page Title-->"+currentTitle);
	}
	@Then("^Click on \"([^\"]*)\" Carousel Thumbnail$")
	public void Click_On_Carousel_Thumbnail(String nth) throws Exception{		
		util.ScrollDown(ThumbnailGallery);
		List<WebElement> BanImg = webdriver.findElements(ThumbnailGallery);
		int BannImgNum = BanImg.size();
		Log.info("Num of Banner Image Present in Home Page-->"+BannImgNum);
		temp=util.modifyXpath(ClickOnNthThumbnail,nth);
		util.ScrollDown(temp);
		util.safeJavaScriptClick(temp);
		Log.info("Click on ["+nth+"] banner in Home page");
		String currentURL=webdriver.getCurrentUrl();
		Log.info("Fetch the current Page url is-->"+currentURL);

		String currentTitle = webdriver.getTitle();
		Log.info("Current Page Title-->"+currentTitle);
	}
	@Then("^Validate is Content banner present$")
	public void validate_content_banner() throws Exception{
		util.isElementPresent(ContentBanner);
		Log.info("Content Banner is present");
	}
	@Then("^Click on Content banner$")
	public void ClickOn_content_banner() throws Exception{
		util.safeJavaScriptClick(ContentBanner);
		Log.info("Click on Content Banner");
	}
	
	@Then("^Validate Download Banner in Home page$")
	public void validate_module_content_item() throws Exception{
		util.ScrollDown(ModuleContentItem);
		util.isElementPresent(ModuleContentItem);
		Log.info("Module Content Item is present");
		String text=webdriver.findElement(ModuleContentItemTexth1).getText();
		Log.info("Module Content Item Text-->"+text);
		
		util.isElementPresent(ModuleContentItemImg);
		Log.info("Module Content Item Img is present");
		
		String text1=webdriver.findElement(ModuleContentItemTexth2).getText();
		Log.info("Module Content Item Text(style h2)-->"+text1);
		String text2=webdriver.findElement(ModuleContentItemTexth3).getText();
		Log.info("Module Content Item Text(style h3)-->"+text2);
		util.isElementPresent(ItemdownloadImg);
		Log.info("Module Content Item download Img is present");
	}
}