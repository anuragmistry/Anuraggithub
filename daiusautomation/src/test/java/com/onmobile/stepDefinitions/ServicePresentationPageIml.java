package com.onmobile.stepDefinitions;

import java.util.ArrayList;
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

public class ServicePresentationPageIml implements PortalXpath{
	static Logger Log = LogManager.getLogger("test");
	Util util=new Util();
	PageConfirmation pageconfirmation=new PageConfirmation();
	WebDriver webdriver = Launcher.getdriver();
	By temp;

	@Then("^Click on service presentation subscribe Text link$")
	public void Click_On_service_Presentation_TextLink() throws Exception{
		util.safeJavaScriptClick(ServicepromotionPageLink);
		Log.info("service presentation subscribe Text link");
		pageconfirmation.isServicePresentationPage();

	}
	@Then("^Validate Service Presentation Logo Text$")
	public void validate_ServicePresentationLogoText() throws Exception { 
		Assert.assertTrue("Service Presentation Logo Text is present",util.isElementPresent(ServicePresentationLogoText));
		Log.info("Service Presentation Logo Text is present");

	}
	@Then("^Validate service presentation slide show section$")
	public void Validate_service_Presentation_slideshow() throws Exception{
		util.isElementPresent(Slideshow);
		Log.info("service presentation Slide show");
	}
	@Then("^Validate service presentation Subscirbe Text$")
	public void Validate_service_presentation_SubsText() throws Exception {
		String text = webdriver.findElement(ServicepresentationSubscribeText).getText();
		Log.info("service presentation Subscirbe Text-->" + text);
		String text1 = webdriver.findElement(ServicepresentationSubscribeGreenText).getText();
		Log.info("service presentation Subscirbe Green price Text-->" + text1);
	}
	@Then("^Validate Subscribe and No Thanks Button is Present$")
	public void Validate_Subscribe_NoThanks_Button() throws Exception { 
		util.isElementPresent(BtnSubscribe1);
		Log.info("Verify Subscribe button is present");
		util.isElementPresent(BtnViewGames1);
		Log.info("Verify No Thanks button is present");
	}

	@Then("^Validate Subscribe category text and image in service presentation Page$")
	public void validate_Subscribe_contentList() throws Exception{
		List<WebElement> SubscribeCategoryHeadingText=webdriver.findElements(ServicepresentationSubscribeCategoryText);
		List<WebElement> SubscribeCategoryDescriptionText=webdriver.findElements(ServicepresentationCategoryDescribeText);
		List<WebElement> SubscribeCategoryImage=webdriver.findElements(ServicepresentationImg);

		int count = SubscribeCategoryHeadingText.size();
		Log.info("Num of ["+count+"] Subscribe Heading Text Present");
		List<String> SubscribeCategoryHeading=new ArrayList<String>();
		for(int i=0;i<count;i++) {
			util.safeJavaScriptClick(ScrolldownArrows);
			Log.info("Click on Scroll Down Arrows");

			String Title=SubscribeCategoryHeadingText.get(i).getText();
			Log.info("Varify ["+(i+1)+"] Subscribe Category Heading Text is present");
			SubscribeCategoryHeading.add(Title);
			String description=SubscribeCategoryDescriptionText.get(i).getText();
			Log.info("Fetch ["+Title+"] Subscribe Category Heading Text and Description "+description);
			SubscribeCategoryImage.get(i).isDisplayed();
			Log.info("Varify ["+(i+1)+"] Subscribe Category Image is present");
		}
		Log.info("All Subscribe Category Heading"+SubscribeCategoryHeading+" present in Service Presentation");
	}

	@Then("^Validate service presentation Footer Section$")
	public void Validate_service_presentation_Footer_Section() throws Exception {

		util.ScrollDown(ServicePresentationFooter);
		util.isElementPresent(ServicePresentationFooter);
		Log.info("service presentation footer section");

		List<WebElement> footerWhiteText=webdriver.findElements(ServicePresentationFooterWhiteText);

		for(int i=0;i<footerWhiteText.size();i++) {
			util.ScrollDown(footerWhiteText.get(i));
			String text=footerWhiteText.get(i).getText();
			Log.info("Fetch ["+text+"] Service Presentation Footer White Text-->"+text);
		}

		util.isElementPresent(BtnSubscribe2);
		Log.info("Verify Subscribe button is present");
		util.isElementPresent(BtnViewGames2);
		Log.info("Verify No Thanks button is present");
	}
	
	@Then("^Click on Service presentation NoThanks Button$")
	public void Click_on_ServicePre_NoThanks_btn() throws Exception { 
		util.ScrollDown(BtnViewGames1);
		util.safeJavaScriptClick(BtnViewGames1);
		Log.info("Click on No Thanks Button");
	}
	
	@Then("^Click on Service presentation Subscribe Button$")
	public void Click_on_Service_Pre_Subscribe_btn() throws Exception { 	
		util.ScrollDown(BtnSubscribe1);
		util.safeJavaScriptClick(BtnSubscribe1);
		Log.info("Click on Subcribe Button");

	}
	
	@Then("^Validate the Service presentation Subscribe text$")
	public void validate_Subscribe_text_Present() throws Exception{
		String expectedtext = webdriver.findElement(SubcribeSpanText).getText();
		Log.info("Service presentation Subscribe text==>"+expectedtext);
	}
	
	@Then("^Click on Enjoy your Games button$")
	public void ClickOn_Enjoy_YourGame_Btn() throws Exception{
		util.GotoHomePage();
		String btntext = webdriver.findElement(EnjoyYourGameBtn).getText();
		Log.info("Enjoy Your Games button text==>"+btntext);
		util.safeJavaScriptClick(EnjoyYourGameBtn);
		Log.info("Click on Enjoy Your Game Btn");
	}
	
	@Then("^Validate the Service presentation Devices image$")
	public void validate_Service_Presentation_Device_Image() throws Exception{
		util.isElementPresent(DevicesImage);
		Log.info("Validate the Service presentation Devices image");
	}
	
	@Then("^Click on Google Play Image$")
	public void ClickOn_GooglePlay_Image() throws Exception{
		util.ScrollDown(GooglePlayImage);
		util.safeJavaScriptClick(GooglePlayImage);
		Log.info("Click on Google Play Image");
		//Renderded in AppStorePage
		pageconfirmation.isAppStorePage();
		//Back to previous Page
		webdriver.navigate().back();
		Thread.sleep(3000);
	}
	
	
	
	@Then("^Validate content banner product image$")
	public void validate_Product_Img() throws Exception { 
		util.isElementPresent(ProductBanner);
		Log.info("Preview Bannner is present");
		
		util.isElementPresent(Productthumbnail);
		Log.info("Preview product-thumbnail is present");
		
		util.isElementPresent(ProductToPlayImg);
		Log.info("Preview Product Download Img is present");
	}
	
	@Then("^Validate content banner product Title and description$")
	public void validate_Product_Title_description() throws Exception {
	
		String text = webdriver.findElement(ProductTitle).getText();
		Log.info("Preview Product Title-->" + text);

		String text1=webdriver.findElement(ProductDev).getText();
		Log.info("Product Developer text-->"+text1);
		String text2=webdriver.findElement(ProductDesc).getText();
		Log.info("Preview Product Desc-->"+text2);
	}
}
