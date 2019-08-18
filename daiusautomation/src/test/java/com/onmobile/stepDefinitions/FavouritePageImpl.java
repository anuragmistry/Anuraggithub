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

public class FavouritePageImpl implements PortalXpath{
	static Logger Log = LogManager.getLogger("test");
	Util util=new Util();
	MenuImpl menuimpl=new MenuImpl();
	By temp;
    WebDriver webdriver = Launcher.getdriver();
	/***************************************************************************************
	 * @Function_Name :  Validate_favourite_container
	 * @Description   :  Validate favorite page title and locker title and compare with excel test data in favorite Page
	 ***************************************************************************************/
   @Then("^Validate favourite page title and locker title$")
   public void Validate_favourite_container() throws Exception {
	     String lockerTitle=Launcher.getvaluefromExcelDataMap("FavouritesPage_LockerTitle");
	     util.waitForLoad(webdriver);
	     String currentURL=webdriver.getCurrentUrl();
		 Log.info("Fetch the favourite Page url is-->"+currentURL);
	    
		 String currentTitle = webdriver.getTitle();
		 Log.info("Current favourite Title-->"+currentTitle);
	     
		 String LockerTitle=webdriver.findElement(Favouritelockertitle).getText();
	     Log.info("Verify favourite Page Title is present");
	    
	     Assert.assertTrue("Compare caption Text",LockerTitle.equalsIgnoreCase(lockerTitle));
		 Log.info("Compare favourite locker Title");
   }
	/***************************************************************************************
	 * @Function_Name :  Validate_Favourite_ContentItem
	 * @Description   :  Validate My favourite Content all item like (Image title and Button) in favorite Page
	 ***************************************************************************************/
   @Then("^Validate My favourite Content item Image title and Button$")
   public void Validate_Favourite_ContentItem() throws Exception {
	   
	   List<WebElement> FavrtImg=webdriver.findElements(Favouritethumbnail);
	   List<WebElement> FavrtImageTitle=webdriver.findElements(Favouritelockercaption);
	   List<WebElement> DeleteIcon=webdriver.findElements(DeleteBtn);
	   List<WebElement> RedownloadIcon=webdriver.findElements(RedownloadBtn);

	   int itemSize=FavrtImg.size();
	   Log.info("Num of Thumbnail Image Present in my favourite Page-->"+itemSize);

	   for(int i=0;i<itemSize;i++){

		   FavrtImg.get(i).isDisplayed();
		   Log.info("Verify favourite image is present");

		   String lockercaption=FavrtImageTitle.get(i).getText();
		   Log.info("favourite locker caption text-->"+lockercaption);

		   RedownloadIcon.get(i).isDisplayed();
		   Log.info("VerifyRe download Btn is present");

		   DeleteIcon.get(i).isDisplayed();
		   Log.info("Verify Delete Btn Title is present");
	   } 
	   
   }
	/***************************************************************************************
	 * @Function_Name :  validate_menu_image_Dimension
	 * @Description   :  validate thumbnail and Button Dimension and compare with excel test data in favorite Page
	 ***************************************************************************************/
   @Then("^Validate image and Button Dimension$")
   public void validate_menu_image_Dimension() throws Exception{
   	String imgdimension=Launcher.getvaluefromExcelDataMap("FavouritesPage_ImgDimension");
   	String btndimension=Launcher.getvaluefromExcelDataMap("FavouritesPage_ButtonDimension");
   	util.check_dimensions(webdriver.findElement(Favouritethumbnail), imgdimension);
   	util.check_dimensions(webdriver.findElement(RedownloadBtn), btndimension);
   	util.check_dimensions(webdriver.findElement(DeleteBtn), btndimension);
   }
	/***************************************************************************************
	 * @Function_Name :  Click_on_favourite
	 * @Description   :  Add the item in my favorite using click on favrt button and return item title name in watch video page
	 ***************************************************************************************/
   @Then("^Click on Favourite Button$")
   public String Click_on_favourite() throws Exception {
	   util.ScrollDown(VideoTitle);
	   String videoTitle=webdriver.findElement(VideoTitle).getText();
	   Log.info("Live Video Title-->"+videoTitle);
	   util.ScrollDown(FavouriteBtnText);
	   try {
		   webdriver.findElement(FavouriteBtnDisabled).isDisplayed();
		   Log.info("Already added if favourite and favourite Btn is disabled");
	   }catch (Exception e) {
		   util.safeJavaScriptClick(FavouriteBtnText);
		   Log.info("Click on favourite Button");
		   Thread.sleep(3000);
		   webdriver.findElement(FavouriteBtnDisabled).isDisplayed();
		   Log.info("Verify favourite Btn is disabled");
	   }
	   return videoTitle;
   }
	/***************************************************************************************
	 * @Function_Name :  Validate_Favourite_Matched_Item
	 * @Description   :  Validate  Matching Item in favorite Page(Pass the Thumbnail image name as argument) 
	 ***************************************************************************************/
   @Then("^Validate Favourite Matched \"([^\"]*)\" Item$")
   public void Validate_Favourite_Matched_Item(String Imgname) throws Exception {
	   util.waitForLoad(webdriver);
	   Log.info("Favourite Image Title-->"+Imgname);
	   temp=util.modifyXpath(Favourite_Img_Title,Imgname);
	   util.ScrollDown(temp);
	   webdriver.findElement(temp).isDisplayed();
	   Log.info("favourite Img Title ["+Imgname+"] is present");
	   
	   temp=util.modifyXpath(Favourite_thumbnail,Imgname);
	   webdriver.findElement(temp).isDisplayed();
	   Log.info("favourite thumbnail is present");
	   
	   temp=util.modifyXpath(Favourite_redownload,Imgname);
	   webdriver.findElement(temp).isDisplayed();
	   Log.info("favourite redownload icon is present");
	   
	   temp=util.modifyXpath(Favourite_Delete,Imgname);
	   webdriver.findElement(temp).isDisplayed();
	   Log.info("favourite Delete icon is present");
	   
	   } 
	/***************************************************************************************
	 * @Function_Name :  Add_to_favourite_and_Validate
	 * @Description   :  Navigate the Add to favourite flow and validate all content in favorite Page
	 ***************************************************************************************/
   @Then("^Add item in My favourite and validate all content$")
   public void Add_to_favourite_and_Validate() throws Exception {
	    String menu=Launcher.getvaluefromExcelDataMap("FavouritesPage_MenuOption");
	    String ImgName=Click_on_favourite();
	    menuimpl.Click_On_menu(menu);
	    Validate_Favourite_Matched_Item(ImgName);
   }
   @Then("^Select the Favourite item and click on delete$")
   public void Delete_to_favourite_item() throws Exception {
	   util.ScrollDown(Favouritelockercaption);
	   String FavouriteVideoTitle= webdriver.findElement(Favouritelockercaption).getText();
	   Log.info("Favourite Video Title is-->"+FavouriteVideoTitle);
	   util.safeJavaScriptClick(DeleteBtn);
	   Log.info("Click on Delete Button");
	   util.waitForLoad(webdriver);
	   Thread.sleep(2000);
	   temp=util.modifyXpath(Favourite_Img_Title,FavouriteVideoTitle);
	   Assert.assertFalse("False the condition",util.isElementPresent(temp));
	   Log.info("Verify the Favourite locker image title is not Present");
   }
   @Then("^Validate No favourites content$")
   public void No_favourite_Content() throws Exception {
	    String ExpectedNoContent=Launcher.getvaluefromExcelDataMap("FavouritesPage_NoFavoriteContent");
	    String ActualFavouriteContent= webdriver.findElement(NoFavrtItemText).getText();
	    Log.info("No Favourite Content is=>"+ActualFavouriteContent);
	    Assert.assertTrue("Compare both text", ExpectedNoContent.equalsIgnoreCase(ActualFavouriteContent));
	    Log.info("Compare No favourite content");
	    }
   
   @Then("^Validate My Downloded Games$")
   public void Validate_Downloaded_Games() throws Exception {
	   List<WebElement> GamesImg=webdriver.findElements(MyDownloadedGame);
	   List<WebElement> FavrtImageTitle=webdriver.findElements(MyDownloadedGameTitle);

	   int itemSize=GamesImg.size();
	   Log.info("Num of Thumbnail Image Present in my My Download Page-->"+itemSize);
	   if(itemSize==0) {
		   Log.info("Download Games count is Empty");
		   util.isElementPresent(EmptyDownloadButton);
		   Log.info("Empty Download Button is present");
	   }else {
		   for(int i=0;i<itemSize;i++){
			   GamesImg.get(i).isDisplayed();
			   Log.info("Verify Games Img is present");
			   String lockercaption=FavrtImageTitle.get(i).getText();
			   Log.info("Download Game caption text-->"+lockercaption);
		   } 
	   } 
   }
}
