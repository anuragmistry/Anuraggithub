package com.onmobile.stepDefinitions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

public class DownloadPageImpl implements PortalXpath {
	static Logger Log = LogManager.getLogger("test");
	Util util = new Util();

	WebDriver webdriver = Launcher.getdriver();
	static String downloadPath=System.getProperty("user.dir")+"\\"+Launcher.CFR.getProperty("Download_Folder_PATH");
	@Then("^Validate Download thumbnail$")
	public void validate_Download_Thumbnail_image() throws Exception {
		util.waitForLoad(webdriver);
		String currentURL = webdriver.getCurrentUrl();
		Log.info("Fetch teh Current Page url is-->" + currentURL);
		Thread.sleep(500);
		webdriver.findElement(DownLoadThumbnail).isDisplayed();
		Log.info("Thumbnail Image is present");
	}

	@And("^Validate Download thumbnail Dimension$")
	public void validate_Download_thumbnail_image_Dimension() throws Exception {
		String dimension = Launcher.getvaluefromExcelDataMap("Subscription_Dimension");
		Log.info("Got preview image size from excel sheet");
		util.check_dimensions(webdriver.findElement(DownLoadThumbnail), dimension);
	}

	@And("^Validate Download thumbnail Title$")
	public void validate_Download_thumbnail_title() throws Exception {
		Thread.sleep(1000);
		util.ScrollDown(DownLoadThumbnailTitle);
		webdriver.findElement(DownLoadThumbnailTitle).isDisplayed();
		Log.info("Download thumbnail Title is present");
		String Imgtitle = webdriver.findElement(DownLoadThumbnailTitle).getText();
		Log.info("Download thumbnail Title is-->" + Imgtitle);
	}

	@And("^Validate Download thumbnail description$")
	public void validate_Download_thumbnail_description() throws Exception {
		Thread.sleep(1000);
		util.ScrollDown(PreviewThumbnailDescrip);
		util.isElementPresent(DownLoadDescriptionText);
		Log.info(" Download thumbnail description is present");
		String desc = webdriver.findElement(DownLoadDescriptionText).getText();
		Log.info(" Download thumbnail description is-->" + desc);
	}

	@And("^Validate Download thumbnail Rating$")
	public void validate_Download_thumbnail_rating() throws Exception {
		Thread.sleep(1000);
		util.ScrollDown(DownLoadThumbnailRatingImg);
		util.isElementPresent(DownLoadThumbnailRatingImg);
		Log.info("Download thumbnail Rating Image is present");
	}

	@And("^Validate thumbnail Download button$")
	public void validate_Download_button() throws Exception {
		Thread.sleep(1000);
		util.ScrollDown(DownLoadButton);
		util.isElementPresent(DownLoadButton);
		Log.info("Thumbnail Download button is present");
		String Imgtitle = webdriver.findElement(DownLoadButton).getText();
		Log.info("Thumbnail Download button name is-->" + Imgtitle);
	}

	@And("^Validate Download credit message button$")
	public void validate_Download_creditMsg() throws Exception {
		Thread.sleep(1000);
		util.ScrollDown(DownLoadCreditMsgText);
		util.isElementPresent(DownLoadCreditMsgText);
		Log.info("DownLoad CreditMsg Text is present");
		String text = webdriver.findElement(DownLoadCreditMsgText).getText();
		Log.info("DownLoad Credit Msg Text-->" + text);
	}

	@And("^Validate Download thumbnail screenshot Section$")
	public void validate_Download_screenshot_Section() throws Exception {
		Thread.sleep(1000);
		util.ScrollDown(DownLoadScreenShotSection);
		util.isElementPresent(DownLoadScreenShotSection);
		Log.info("DownLoad ScreenShot Section is present");
		List<WebElement> screenshot = webdriver.findElements(DownLoadScreenshotImg);
		Log.info("Num of screenshot Present in Download Page-->" + screenshot.size());
	}

	@Then("^Validate Download thumbnail Description Title and description text$")
	public void validate_Download_Description_text() throws Exception {
		Thread.sleep(1000);
		util.ScrollDown(DownLoadDescripTitle);
		util.isElementPresent(DownLoadDescripTitle);
		Log.info("DownLoad Description Title is present");
		String headerText = webdriver.findElement(DownLoadThumbnailratingtitle).getText();
		Log.info("DownLoad Thumbnail rating title-->" + headerText);
		String text = webdriver.findElement(DownLoaddescriptionText).getText();
		Log.info("DownLoad description text msg-->" + text);
	}

	@Then("^Validate Download thumbnail rating title and ratingshistogram section$")
	public void validate_Download_rating_title_ratingshistogram() throws Exception {
		Thread.sleep(1000);
		util.ScrollDown(DownLoadThumbnailratingtitle);
		util.isElementPresent(DownLoadThumbnailratingtitle);
		Log.info("DownLoad Thumbnail rating title is present");
		String headerText = webdriver.findElement(DownLoadThumbnailratingtitle).getText();
		Log.info("DownLoad Thumbnail rating title-->" + headerText);
		util.isElementPresent(DownLoadratingshistogram);
		Log.info("DownLoad ratings histogram is present");
	}
	
	@Then("^Validate Download thumbnail recomendation section$")
	public void validate_Download_recomendation_section() throws Exception {
		Thread.sleep(1000);
		util.ScrollDown(RecomendationHeader);
		util.isElementPresent(RecomendationHeader);
		Log.info("DownLoad Recomendation Header title is present");
		String headerText = webdriver.findElement(RecomendationHeader).getText();
		Log.info("DownLoad Recomendation Header->" + headerText);
		util.isElementPresent(RecomendationMoreBtn);
		Log.info("DownLoad Recomendation More Btn is present");
		
		List<WebElement> thumbnailimg = new ArrayList<WebElement>();
		List<WebElement> thumbnailTitle = new ArrayList<WebElement>();
		
		thumbnailimg = webdriver.findElements(RecomendationThumbnail);
		thumbnailTitle = webdriver.findElements(RecomendationThumbnailTitle);
		Log.info("Num of ["+thumbnailimg.size()+"] recomends thumbnail present under Download Recomendation Section");
		
	
		int number = 0;
		List<String> titleText = new ArrayList<>();
		for (int i = 0; i <thumbnailimg.size(); i++) {
			thumbnailimg.get(i).isDisplayed();
			Log.info("Verify thumbnail Image is present");
			number = new Integer(number + 1);
			String text = thumbnailTitle.get(i).getText();
			titleText.add(text);
			Log.info("Verify number(" + number + ") of thumbnail Image Present");
			Log.info("Recomendation thumbnail Title Name-->" + text);
		}
		Log.info("All Recomendation thumbnail Title Name are-->" + titleText);
	}
	
	@And("^Click on to Download Button$")
	   public String Click_On_Download_Btn() throws Exception { 
		   util.ScrollDown(DownLoadThumbnailTitle);
		   String title=webdriver.findElement(DownLoadThumbnailTitle).getText();
		   Log.info("DownLoad Thumbnail Title-->"+title);
		   util.ScrollDown(DownLoadButton);
		   util.isElementPresent(DownLoadButton);
		   Log.info("Verify ToBuy button is present");
		   util.safeJavaScriptClick(DownLoadButton);
		   Log.info("Click on TOBuy Button");
		   util.waitForLoad(webdriver);
		   Thread.sleep(20000);
		   String DownloadPageurl = webdriver.getCurrentUrl();
		   Log.info("Current Download Page url-->"+DownloadPageurl);
		   String PageTitle = webdriver.getTitle();
		   Log.info("Current Download Page Title-->"+PageTitle);
		return title;
	   }
	@Then("^Click on Download button and Validate the Download file$")
	   public void Validate_Download_Button_Download_file() throws Exception { 
		   String downloadImgTitle=Click_On_Download_Btn();
		   // String downloadImgTtile="4x4 Rally Champions";
		   String after =downloadImgTitle.trim().replaceAll("\\s","");
		   Util.WaitForDownloadFile(downloadPath,after);
		   Thread.sleep(10000);
		   String downloadedFileName=Util.getLatestFilefromDir(downloadPath);
		   System.out.println("Downloaded File Name====>["+downloadedFileName+"] and Actual file name from UI ["+after+"]");
		   Util.ValidateDownloadFile(downloadPath);
	   }
//Ugames
	 @Then("^Validate subscription confirmation image and text$")
	   public void validate_Subscribed_confirmation_Image_Text() throws Exception {
		   Thread.sleep(5000);
		   util.isElementPresent(SubscribeConfirmationImg);
		   Log.info("Verify SubscribedTick Img is displayed in download Page");
		   util.isElementPresent(SubscribeConfirmationText);
		   Log.info("Verify Subscribedtext is displayed in Subscribed Page");
		   String text=webdriver.findElement(SubscribeConfirmationText).getText();
		   Log.info("Actual Subscribed text is-->"+text);
		   String Actualtext=Launcher.getvaluefromExcelDataMap("ConfirmationPage_SubscribedText");
		 
		   try {
			   Assert.assertTrue(text.equalsIgnoreCase(Actualtext));
			   Log.info("Compare subscribed price text with excel data");
		   } catch (Exception e) {
			   System.err.println("NOT same price text with expected excel data");
		   } 

	   }
	@Then("^Validate Downloading Image$")
	public void validate_Download_image() throws Exception {
		util.waitForLoad(webdriver);
		String currentURL = webdriver.getCurrentUrl();
		Log.info("Fetch teh Current Page url is-->" + currentURL);
		String Title = webdriver.getTitle();
	    Log.info("Current Page Title-->"+Title);
		Thread.sleep(500);
		webdriver.findElement(DownloadingImage).isDisplayed();
		Log.info("Downloading Image is present");
	}
	@And("^Validate Download Image Title and Size text$")
	public void validate_Download_Image_title_Size() throws Exception {
		Thread.sleep(1000);
		util.ScrollDown(DownloadSafeText);
		webdriver.findElement(DownloadSafeText).isDisplayed();
		Log.info("Download thumbnail Title is present");
		String text = webdriver.findElement(DownloadingText).getText();
		Log.info("Downloading Text is-->" + text);
		String text1 = webdriver.findElement(DownloadingFileSize).getText();
		Log.info("Downloading File sSize is-->" + text1);
	}

	@And("^Validate Download does Not start Text and link$")
	public void validate_Download_DoesNotStartText_link() throws Exception {
		util.ScrollDown(AutomaticDownloadText);
		util.isElementPresent(AutomaticDownloadText);
		Log.info(" Automatic Download does not start Text is present");
		String desc = webdriver.findElement(AutomaticDownloadText).getText();
		Log.info(" Automatic Download does not start Text-->" + desc);
	}
	
	@Then("^Click on Download Green Button$")
	public void validate_Download_Close_button() throws Exception {
		Thread.sleep(1000);
		util.ScrollDown(DownloadGreenBtn);
		String Imgtitle = webdriver.findElement(DownloadGreenBtn).getText();
		Log.info("Download Close button name is-->" + Imgtitle);
		util.safeJavaScriptClick(DownloadGreenBtn);
		Log.info("Thumbnail Download button is present");
	    util.GetCurrenturlAndTitle();
	}

	@Then("^Validate Download Green Button$")
	public void validate_Subscirbe_TextBox() throws Exception {
		util.ScrollDown(DownloadGreenBtn);
		String text = webdriver.findElement(DownloadGreenBtn).getText();
		Log.info("Download Green Btn-->"+text);
	}
	@Then("^Validate App Img is present$")
	public void validate_APP_Img() throws Exception {
		util.ScrollDown(AppImg);
		util.isElementPresent(AppImg);
		Log.info("Verify the App Img is present");
	}
	@Then("^Validate Movistar Header is present$")
	public void validate_MovistarHeader() throws Exception {
		util.isElementPresent(MovistarHeader);
		Log.info("Verify the App Img is present");
		String text = webdriver.findElement(MovistarHeader).getText();
		Log.info("MovistarHeader Text-->" + text);
	}
	@And("^Validate all download subscribed points$")
	   public void validate_points_text() throws Exception{
		   Thread.sleep(1000);
		   util.ScrollDown(DownloadPoints);
		   util.isElementPresent(DownloadPoints);
		   Log.info("Verify the points section is present");
		   List<String> points=util.getOptionValue(DownloadPoints);
		   Log.info("Subscribed points present in confirmation page-->"+points);
		   String ListofPoints=Launcher.getvaluefromExcelDataMap("ConfirmationPage_SubscribedPoints");
		   List<String> list = new ArrayList<String>(Arrays.asList(ListofPoints.split("::")));
		   Log.info("Fetch the list of points from Excel are"+list);
		   Assert.assertTrue("Comapare both points List",util.ComparetoListvalue(points, list));
	   }
	
	@Then("^Click on Product Download icon$")
	public void Click_Download_Icon() throws Exception {
		String productname=webdriver.findElement(ProductTitle).getText();
		util.safeJavaScriptClick(ProductDownloadImg);
		Log.info("Click on Download Icon");
		util.waitForLoad(webdriver);
		String Title = webdriver.getTitle();
		Log.info("Current Page Title-->"+Title);
        Util.SetCurrentDownloadFile(productname);
		try {
			String text = webdriver.findElement(DownloadHeavyPopupContent).getText();
			Log.info("Heavy Download popup content-->" + text);
			String text1 = webdriver.findElement(DownloadHeavyPopupText).getText();
			Log.info("Heavy Download popup details text-->" + text1);
			//util.safeJavaScriptClick(Understoodbtn);
		//	Log.info("Click on Entendido Button");
		}catch(Exception e){
			Log.info("Click on Entendido Button");
		}
	}
	@Then("^Click on Product Download icon and Validate the Download file$")
	public void Validate_Product_Download_file() throws Exception { 
		util.safeJavaScriptClick(DownloadGame);
		Log.info("Click on Download Icon");
		util.waitForLoad(webdriver);
		String downloadTitle=Util.getCurrentDownloadFile();
		// String downloadImgTtile="4x4 Rally Champions";
		String after =downloadTitle.trim().replaceAll("\\s","");
		boolean status=Util.WaitForDownloadFile(downloadPath,after);
		//Thread.sleep(20000);
		webdriver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
		String downloadedFileName=Util.getLatestFilefromDir(downloadPath);
		System.out.println("Downloaded File Name====>["+downloadedFileName+"] and Actual file name from UI ["+after+"]");
		Util.ValidateDownloadFile(downloadPath);
	}
}
