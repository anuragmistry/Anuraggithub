package com.onmobile.stepDefinitions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.onmobile.utils.Util;
import com.onmobile.xpaths.PortalXpath;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ConfirmationPageImpl implements PortalXpath{
	static Logger Log = LogManager.getLogger("test");
	Util util=new Util();
	
   WebDriver webdriver = Launcher.getdriver();
   static String PageTitle=null;
	/***************************************************************************************
	 * @Function_Name :  validate_SubscribedImage_Text
	 * @Description   :  validate subscribed image and text and compare with excel test data in confirmation page
	 ***************************************************************************************/
   @Then("^Validate subscribed image and text$")
   public void validate_SubscribedImage_Text() throws Exception {
	   Thread.sleep(3000);
	   webdriver.findElement(SubscribedTickImg).isDisplayed();
	   Log.info("Verify SubscribedTick Img is displayed in Subscribed Page");
	   webdriver.findElement(Subscribedtext).isDisplayed();
	   Log.info("Verify Subscribedtext is displayed in Subscribed Page");
	   String text=webdriver.findElement(Subscribedtext).getText();
	   Log.info("Subscribed text is-->"+text);
	   String Actualtext=Launcher.getvaluefromExcelDataMap("ConfirmationPage_SubscribedText");
	   Assert.assertTrue(text.equalsIgnoreCase(Actualtext));
	   Log.info("Compare subscribed price text with excel data");
   }
	/***************************************************************************************
	 * @Function_Name :  validate_subscribed_image_Dimension
	 * @Description   :  validate Subscribed image Dimension in confirmation page
	 ***************************************************************************************/ 
   
   @And("^Validate Subscribed image Dimension$")
   public void validate_subscribed_image_Dimension() throws Exception{
       webdriver.findElement(SubscribedImage).isDisplayed();
       Log.info("Verify Subscribed Image is present");
	   String dimension=Launcher.getvaluefromExcelDataMap("ConfirmationPage_Dimension");
	   Log.info("Got preview image size from excel sheet");
	   util.check_dimensions(webdriver.findElement(SubscribedImage), dimension);
   }
   @Then("^Validate Subscribed thumbnail image$")
   public void validate_subscribed_thumbnail_image() throws Exception{
       util.isElementPresent(SubscribedThumbnail);
       Log.info("Verify Subscribed thumbnail Image is present");
   }
   @Then("^Validate Editorial Subscribed image$")
   public void validate_editorial_subscribed_image() throws Exception{
       util.isElementPresent(EditorialConfirmContentImg);
       Log.info("Verify Subscribed thumbnail Image is present");
   }
   
	/***************************************************************************************
	 * @Function_Name :  validate_SubscribedImage_Text
	 * @Description   :  validate only continue button and inside text and compare with excel test data in confirmation page
	 ***************************************************************************************/
   @And("^Validate continue button and inside text$")
   public void validate_continuebtn_text() throws Exception{
	   Thread.sleep(1000);
       webdriver.findElement(ContinueButton).isDisplayed();
       Log.info("Verify ContinueButton is displayed in Subscribed Page");
	   String text=webdriver.findElement(ContinueButton).getText();
	   Log.info("Inside button text is-->"+text);
	   String Actualtext=Launcher.getvaluefromExcelDataMap("ConfirmationPage_ButtonText");
	   Assert.assertTrue(text.equalsIgnoreCase(Actualtext));
	   Log.info("Compare button text with excel data");
	
   }
   @And("^Validate CSS property for Continue Button$")
   public void validate_CSS_Menu_icon() throws Exception { 
       String CssValue=Launcher.getvaluefromExcelDataMap("ConfirmationPage_ContinueBtn_CSS_Properties_Value");
       util.Validate_CSS_Properties_Value(webdriver.findElement(ContinueButton),CssValue);
   }

	/***************************************************************************************
	 * @Function_Name :  validate_points_text
	 * @Description   :  validate all user subscribed points and compare with excel test data in confirmation page
	 ***************************************************************************************/
   @And("^Validate all user subscribed points$")
   public void validate_points_text() throws Exception{
	   Thread.sleep(1000);
	   util.ScrollDown(Points);
	   webdriver.findElement(Points).isDisplayed();
	   Log.info("Verify the points section is present");
	   List<String> points=util.getOptionValue(PointsText);
	   Log.info("Subscribed points present in confirmation page-->"+points);
	   String ListofPoints=Launcher.getvaluefromExcelDataMap("ConfirmationPage_SubscribedPoints");
	   List<String> list = new ArrayList<String>(Arrays.asList(ListofPoints.split("::")));
	   Log.info("Fetch the list of points from Excel are"+list);
	   Assert.assertTrue("Comapare both points List",util.ComparetoListvalue(points, list));
   }
   /***************************************************************************************
	 * @Function_Name :  validate_points_img_dimension
	 * @Description   :  validate points image Dimension in confirmation page
	 ***************************************************************************************/ 
   @And("^Validate points image Dimension$")
   public void validate_points_img_dimension() throws Exception{
	//   List<WebElement> wordlink=webdriver.findElements(wordcloudlink);
       webdriver.findElement(Points).isDisplayed();
       Log.info("Verify Subscribed Image is present");
	   String dimension=Launcher.getvaluefromExcelDataMap("Subscription_Dimension");
	   Log.info("Got preview image size from excel sheet");
	   util.check_dimensions(webdriver.findElement(SubscribedImage), dimension);
   }
	/***************************************************************************************
	 * @Function_Name :  validate_Many_More_Link
	 * @Description   :  validate Many more Text and portal link in confirmation page
	 ***************************************************************************************/
   @And("^Validate Many more Text and portal link$")
   public void validate_Many_More_Link() throws Exception{
	   Thread.sleep(1000);
	   util.ScrollDown(CaptionText);
       webdriver.findElement(CaptionText).isDisplayed();
       Log.info("Verify Subscribed Image is present");
       String text=webdriver.findElement(CaptionText).getText();
	   Log.info("Subscribed text is-->"+text);
	   webdriver.findElement(CaptionLink).isDisplayed();
       Log.info("Verify Subscribed Image is present");
       String link=webdriver.findElement(CaptionLink).getText();
	   Log.info("Subscribed Portal link is-->"+link);
   }
	/***************************************************************************************
	 * @Function_Name :  validate_conditions_Link
	 * @Description   :  validate Conditions link of service and compare with excel test data in confirmation page
	 ***************************************************************************************/
   @And("^Validate Conditions link of service$")
   public void validate_conditions_Link() throws Exception{
	   Thread.sleep(1000);
	   util.ScrollDown(CaptionsConditionLink);
       webdriver.findElement(CaptionsConditionLink).isDisplayed();
       Log.info("Verify Condition Link is present");
       String text=webdriver.findElement(CaptionsConditionLink).getText();
	   Log.info("Captions Condition Link text is-->"+text);
	   String Actualtext=Launcher.getvaluefromExcelDataMap("ConfirmationPage_ConditionsLink");
	   Assert.assertTrue(text.equalsIgnoreCase(Actualtext));
	   Log.info("Compare button text with excel data");
	   webdriver.findElement(CaptionsConditionLink).click();
	   Log.info("Click on Terms Condition Link");
   }
   @And("^Validate Subscribed image Title$")
   public void validate_Subscribed_image_title() throws Exception { 
	   Thread.sleep(1000);
	   util.ScrollDown(SubscribeImageTitle);
	   webdriver.findElement(SubscribeImageTitle).isDisplayed();
	   Log.info("Preview Image Title is present");
	   String Imgtitle=webdriver.findElement(SubscribeImageTitle).getText();
	   Log.info("Preview Image Title is-->"+Imgtitle);
   }
   @And("^Validate Subscribed thumbnail description$")
   public void validate_Subscribed_description() throws Exception { 
	   Thread.sleep(1000);
	   util.ScrollDown(PreviewThumbnailDescrip);
	   webdriver.findElement(PreviewThumbnailDescrip).isDisplayed();
	   Log.info("Preview Image Title is present");
	   String Imgtitle=webdriver.findElement(PreviewThumbnailDescrip).getText();
	   Log.info("Preview Image Title is-->"+Imgtitle);
   }
   @And("^Validate Editorial Subscribed Content Title$")
   public void validate_Editorial_ubscribed_image_title() throws Exception { 
	   Thread.sleep(1000);
	   util.ScrollDown(EditorialConfirmContentTitle);
	   webdriver.findElement(EditorialConfirmContentTitle).isDisplayed();
	   Log.info("Content Title is present");
	   String Imgtitle=webdriver.findElement(EditorialConfirmContentTitle).getText();
	   Log.info("Content Title is-->"+Imgtitle);
   }
   @And("^Validate Subscribed image Rating$")
   public void validate_preview_image_rating() throws Exception { 
	   Thread.sleep(1000);
	   util.ScrollDown(PreviewImageRating);
	   webdriver.findElement(PreviewImageRating).isDisplayed();
	   Log.info("Preview Rating Image is present");
   }
   @Then("^Validate Subscribed Thumbnail$")
   public void validate_Subscribed_image() throws Exception { 
	   Thread.sleep(1000);
	   util.ScrollDown(SubscribedPreviewImage);
	   util.isElementPresent(SubscribedPreviewImage);
	   Log.info("Subscribed Preview Image is present");
   }
   @Then("^Validate \"([^\"]*)\" subscribed image and text$")
   public void validate_Portal_SubscribedImage_Text(String portal) throws Exception {
	   Thread.sleep(3000);
	   webdriver.findElement(SubscribedTickImg).isDisplayed();
	   Log.info("Verify ["+portal+"] SubscribedTick Img is displayed in Subscribed Page");
	   if(portal.equalsIgnoreCase("Tourist")) {
		   webdriver.findElement(SubscribedMsg).isDisplayed();
		   Log.info("Verify ["+portal+"] Subscribedtext is displayed in Subscribed Page");
		   String text=webdriver.findElement(SubscribedMsg).getText();
		   Log.info("Subscribed text is-->"+text);
	   }
	   if(portal.equalsIgnoreCase("PlayOn")) {
		   webdriver.findElement(SubscribedMsg).isDisplayed();
		   Log.info("Verify ["+portal+"] Subscribedtext is displayed in Subscribed Page");
		   String text=webdriver.findElement(SubscribedMsg).getText();
		   Log.info("Subscribed text is-->"+text);
	   }
	   if(portal.equalsIgnoreCase("PDMT")) {
		   webdriver.findElement(SubscribedMsg).isDisplayed();
		   Log.info("Verify ["+portal+"] Subscribedtext is displayed in Subscribed Page");
		   String text=webdriver.findElement(SubscribedMsg).getText();
		   Log.info("Subscribed text is-->"+text);
	   }
   }
   @Then("^Validate user subscribed points$")
   public void validate_subscribed_points_text() throws Exception{
	   util.ScrollDown(Points);
	   util.isElementPresent(Points);
	   Log.info("Verify the points section is present");
	   List<String> points=util.getOptionValue(PointsText);
	   Log.info("Subscribed points present in confirmation page-->"+points);
   }
   @Then("^Validate continue button is Present$")
   public void Validate_continuebtn_text() throws Exception{
       util.isElementPresent(ContinueButton);
       Log.info("Verify ContinueButton is displayed in Subscribed Page");
	   String text=webdriver.findElement(ContinueButton).getText();
	   Log.info("Inside button text is-->"+text);	
   }
   
   @Then("^Click \"([^\"]*)\" on Continue Button$")
   public void Click_On_Continue_BTN(String portal) throws Exception { 

	   util.ScrollDown(ContinueButton);
	   util.safeJavaScriptClick(ContinueButton);
	   Log.info(portal+"-->Click on Continue Button");
	   util.waitForLoad(webdriver);
	   util.GetCurrenturlAndTitle();
   }	
   @Then("^Validate View Article button is Present$")
   public void Validate_viewarticlebtn_text() throws Exception{
       util.isElementPresent(EditorialViewArticleBtn);
       Log.info("Verify ContinueButton is displayed in Subscribed Page");
   	   String text=webdriver.findElement(EditorialViewArticleBtn).getText();
   	   Log.info("Inside button text is-->"+text);	
   }

   @Then("^Click \"([^\"]*)\" on View Article Button$")
   public void Click_On_viewarticle_btn(String portal) throws Exception { 

   	   util.ScrollDown(EditorialViewArticleBtn);
   	   util.safeJavaScriptClick(EditorialViewArticleBtn);
   	   Log.info(portal+"-->Click on Continue Button");
   	   util.waitForLoad(webdriver);
   	   util.GetCurrenturlAndTitle();
   	}
}
