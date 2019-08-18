package com.onmobile.stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.onmobile.utils.Util;
import com.onmobile.xpaths.PortalXpath;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WatchVideoPageImpl implements PortalXpath{
	static Logger Log = LogManager.getLogger("test");
	Util util=new Util();
	
   WebDriver webdriver = Launcher.getdriver();
   /***************************************************************************************
	 * @Function_Name :  Validate_Watch_Video_Title
	 * @Description   : Validate Watch Video page url and Title  and previous page link text in watch video page
	 ***************************************************************************************/
   @When("^Validate Watch Video Title$")
   public void Validate_Watch_Video_Title() throws Exception {
	     util.waitForLoad(webdriver);
	     String currentURL=webdriver.getCurrentUrl();
		 Log.info("Fetch the Watch Video Page url is-->"+currentURL);
	     Thread.sleep(2000);
		 webdriver.findElement(PreviousPageTitle).isDisplayed();
	     Log.info("Verify Previous Page Title is present");
	     
	     String previousText=webdriver.findElement(PreviousPageTitle).getText();
	     Log.info("Previous Page Title-->"+previousText);
	     util.isElementPresent(CurrentPageTitle);
	     Log.info("Verify Previous Page Title is present");
	     String currentText=webdriver.findElement(CurrentPageTitle).getText();
	     Log.info("Current Page Title-->"+currentText); 
   }
   /***************************************************************************************
	 * @Function_Name :  Validate_Video_container
	 * @Description   : Validate Video container and click on Play Button in watch video page
	 ***************************************************************************************/
   @Then("^Validate Video container and click on Play Button$")
   public void Validate_Video_container() throws Exception {
     webdriver.findElement(Playercontainer).isDisplayed();
     Log.info("Player container is present");
     util.safeJavaScriptClick(PlayVideoButton);
     Log.info("Click on Play video Button");
    // Validate_streaming_Video_Player();
   }
   /***************************************************************************************
	 * @Function_Name :  Validate_streaming_Video_Player
	 * @Description   : Validate Live video control bar and all type of operation(calculate duration time,mute,unmute,fullscreen etc) 
	 ***************************************************************************************/
   @Then("^Validate Live video control bar and video display time$")
   public void Validate_streaming_Video_Player() throws Exception {
	   webdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	   Log.info("waiting for 10 Sec");
	   util.ScrollDownUsingPixel(600);
	   util.isElementPresent(PrograssBar);
	   Log.info("Verify Prograss Bar is present");
	   Thread.sleep(15000);
	   util.HoverOperation(PauseBtn);
       String time1=webdriver.findElement(VideoDisplayTime).getText();
	   int totaldurationTime=util.ConvertintoSec(time1);
	   Log.info("Video duration Time-->"+time1);
	  // webdriver.findElement(PauseBtn).isDisplayed();
	  // Log.info("Verify Play Btn is present");
	   
	   Thread.sleep(10000);
	   
	   util.ActionsClick(PauseBtn);
	   Log.info("Verify Play Btn is present and Click on Pause Button");
	  
	   int NowTime=util.ConvertintoSec(webdriver.findElement(CurrentVideoTime).getText());
	   Log.info("After click on Pause button time is-->"+NowTime); 
	   
	   util.ActionsClick(PlayBtn);
	   Log.info("Click on Play Button");
	   Thread.sleep(10000);
	   Log.info("Agnain waiting for 10 Sec");
	  
	   util.ActionsClick(PauseBtn);
	   Log.info("Click on Pause Button");
	  
	   int ndTime=util.ConvertintoSec(webdriver.findElement(CurrentVideoTime).getText());
	   Log.info("After 2nd time click on Pause button the current video time is-->"+ndTime);
	   
	   if(NowTime<ndTime && NowTime<totaldurationTime) {
		    Log.info("Play and Pause is working fine");
	    }else {
	    	Log.info("Play and Pause is not working");
	    }
	   
	   Thread.sleep(1000);
	   util.ActionsClick(MuteBtn);
	   Log.info("Click on Mute Button");
	   Thread.sleep(1000);
	   util.ActionsClick(UnMuteBtn);
	   Log.info("Click on UnMute Button");
	   Thread.sleep(1000);
	   util.ActionsClick(FullScreenBtn);
	   Log.info("Click on FullScreenBtn Button");
	  
	   util.ActionsClick(NONFullScreenBtn);
	   Log.info("Click on Non-FullScreenBtn Button");
   }
   /***************************************************************************************
	 * @Function_Name :  Validate_Video_Title_RatingImg
	 * @Description   : Validate Live Video Title and Rating Image
	 ***************************************************************************************/
   @Then("^Validate Live Video Title and Rating Image$")
   public void Validate_Video_Title_RatingImg() throws Exception {
         util.isElementPresent(VideoTitle);
	     Log.info("Verify Video Title is present");
	     String videoTitle=webdriver.findElement(VideoTitle).getText();
	     Log.info("Live Video Title-->"+videoTitle);
	     util.isElementPresent(VideoRatingImg);
	     Log.info("Verify Video Rating Img is present");
   }
   /***************************************************************************************
	 * @Function_Name :  Validate_rating_info
	 * @Description   : Validate all types of ratings info in watch video page
	 ***************************************************************************************/
   @Then("^Validate all types of ratings info$")
   public void Validate_rating_info() throws Exception {

	   List<WebElement> ratinginfoImg=webdriver.findElements(RatingInfoImg);
	   List<WebElement> ratingText=webdriver.findElements(RatingInfo);
	   List<String> titleText= new ArrayList<>();
	   for(int i=0;i<ratinginfoImg.size();i++){
           util.ScrollDown(ratinginfoImg.get(i));
		   Assert.assertTrue(ratinginfoImg.get(i).isDisplayed());
		   Log.info("Rating info Image is present");
		   Assert.assertTrue(ratingText.get(i).isDisplayed());
		   Log.info("Rating Image info is present");
		   String text=ratingText.get(i).getText();
		   titleText.add(text);
	   }
	   Log.info("All Gallery Title Name-->"+titleText);
   }
   /***************************************************************************************
	 * @Function_Name :  locker_favourite_container
	 * @Description   :Validate favourite section and compare with test data in watch video page
	 ***************************************************************************************/
   @Then("^Validate favourite section in watch video page$")
   public void locker_favourite_container() throws Exception {
	   
	     String btntext=Launcher.getvaluefromExcelDataMap("WatchVideoPage_BtnText");
	     String premsg=Launcher.getvaluefromExcelDataMap("WatchVideoPage_PreMessage");
	     String postmsg=Launcher.getvaluefromExcelDataMap("WatchVideoPage_PostMessage");
	     util.ScrollDownUsingPixel(1200);
	     
	     util.isElementPresent(FavouriteTitle);
	     Log.info("Verify favourite Title is present");
	     
	     String fvrtTitle=webdriver.findElement(FavouriteTitle).getText();
	     Log.info("Favourite Title Text-->"+fvrtTitle);
	     
	     try {
	     String Premessage=webdriver.findElement(FavouritePremessage).getText();
	     Log.info("Verify favourite Pre message-->"+Premessage);
	     Assert.assertTrue("Compare post msg Text",Premessage.equalsIgnoreCase(premsg));
		 Log.info("Compare pre message text");
	     
		 webdriver.findElement(FavouriteBtnText).isDisplayed();
	     Log.info("Verify favourite Button text is present");
	     String Btntext=webdriver.findElement(FavouriteBtnText).getText();
	     Log.info("Favourite Btn Text-->"+Btntext);
	     Assert.assertTrue("Compare Btntext Text", Btntext.equalsIgnoreCase(btntext));
		 Log.info("Compare Favourite button text");
		 
	     webdriver.findElement(FavouriteBtnImg).isDisplayed();
	     Log.info("Verify favourite Btn Img is present");
	     util.safeJavaScriptClick(FavouriteBtnText);
	     Log.info("Click on favourite Button");
	     Thread.sleep(3000);
	    
	     String Postmessage=webdriver.findElement(FavouritePostmessage).getText();
	     Log.info("Verify favourite Post message-->"+Postmessage);
	     Assert.assertTrue("Compare Post message Text", Postmessage.equalsIgnoreCase(postmsg));
		 Log.info("Compare post message text");
	     
		 webdriver.findElement(FavouriteBtnDisabled).isDisplayed();
	     Log.info("Verify favourite Btn is disabled");
	     
	     }catch (Exception e) {
	    	 Log.info("This Item is already added in Favourites");
		}
   }
   @Then("^Validate rating table and click on rate images$")
   public void Validate_ratingTable_and_Rated() throws Exception {
	   String clickRatecount=Launcher.getvaluefromExcelDataMap("WatchVideoPage_BtnText");
	   util.ScrollDown(RateContent);
	   util.isElementPresent(RateContent);
	   Log.info("Validate Rate Content Section is present");
	   List<WebElement> ratingstartImg=webdriver.findElements(RatingStarImg);
	   for(int i=0;i<Integer.parseInt(clickRatecount);i++){
		   Assert.assertTrue(ratingstartImg.get(i).isDisplayed());
		   Log.info("Rating Star Image is present");
		   ratingstartImg.get(i).click();
		   Log.info("Click on Rating Star image");
	   }
   }
   @Then("^Validate Description Title and Text$")
   public void Validate_Description_Title_Text() throws Exception {
	   util.ScrollDown(DescriptionTitle);
	   util.isElementPresent(DescriptionTitle);
	   Log.info("Validate Description Title is present");
	   String Destext=webdriver.findElement(DescriptionText).getText();
	   Log.info("Description Text-->"+Destext); 
   }
   @Then("^Validate Upcoming episode recomendation section$")
	public void validate_Upcoming_episode_recomendation_section() throws Exception {
		Thread.sleep(1000);
		util.ScrollDown(RecomendationHeader);
		util.isElementPresent(RecomendationHeader);
		Log.info("Upcoming episode Recomendation Header title is present");
		String headerText = webdriver.findElement(RecomendationHeader).getText();
		Log.info("Upcoming episode Recomendation Header->" + headerText);
		
		List<WebElement> thumbnailimg = new ArrayList<WebElement>();
		List<WebElement> thumbnailTitle = new ArrayList<WebElement>();
		
		thumbnailimg = webdriver.findElements(RecomendationThumbnail);
		thumbnailTitle = webdriver.findElements(RecomendationThumbnailTitle);
		Log.info("Num of ["+thumbnailimg.size()+"] recomends Video present under Upcoming episode Recomendation Section");
		
	
		int number = 0;
		List<String> titleText = new ArrayList<>();
		for (int i = 0; i <thumbnailimg.size(); i++) {
			thumbnailimg.get(i).isDisplayed();
			Log.info("Verify thumbnail Image is present");
			number = new Integer(number + 1);
			String text = thumbnailTitle.get(i).getText();
			titleText.add(text);
			Log.info("Verify number(" + number + ") of thumbnail Image Present");
			Log.info("Upcoming episode Video thumbnail Title Name-->" + text);
		}
		Log.info("Upcoming episode Video Title Name are-->" + titleText);
	}
}
