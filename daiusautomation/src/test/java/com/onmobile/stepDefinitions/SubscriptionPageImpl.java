package com.onmobile.stepDefinitions;

import java.io.File;
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

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SubscriptionPageImpl implements PortalXpath{
	static Logger Log = LogManager.getLogger("test");
	Util util=new Util();
	PageConfirmation pageconfirmation=new PageConfirmation();
	static String downloadPath=System.getProperty("user.dir")+"\\"+Launcher.CFR.getProperty("Download_Folder_PATH");
	WebDriver webdriver = Launcher.getdriver();
	static String PageTitle=null;
	static String PreviewImgtitle=null;
	By temp;
	/***************************************************************************************
	 * @Function_Name :  Click_Carousel_Image
	 * @Description   :  Click on Carousel Image
	 ***************************************************************************************/
   @When("^Click on Swipe-boune Carousel Image$")
   public String Click_Carousel_Image() throws Exception {
	   util.waitForLoad(webdriver);
	   Thread.sleep(2000);
	   util.ScrollDown(TopCarouselImg);
	   webdriver.findElement(CarouselImgLink).isDisplayed();
	   Log.info("Verify Image is present");
	   Thread.sleep(500);
	   PageTitle = webdriver.getTitle();
	   Log.info("Current Page Title-->"+PageTitle);
	  // webdriver.findElement(CarouselImgLink).click();
	   util.safeJavaScriptClick(CarouselImgLink);
	   Log.info("Click on carousel image");
	   
	   return PageTitle;
   }
	/***************************************************************************************
	 * @Function_Name :  validate_preview_image
	 * @Description   :  validate image in preview Page
	 ***************************************************************************************/
   @Then("^Validate preview image$")
   public void validate_preview_image() throws Exception { 

	   util.waitForLoad(webdriver);
	   String currentURL=webdriver.getCurrentUrl();
	   Log.info("Fetch teh Current Page url is-->"+currentURL);
	   Thread.sleep(500);
	   webdriver.findElement(PreviewImage).isDisplayed();
	   Log.info("Preview Image is present");
   }
   @Then("^Validate Thumbnail image$")
   public void validate_Thumbnail_image() throws Exception { 

	   util.waitForLoad(webdriver);
	   String currentURL=webdriver.getCurrentUrl();
	   Log.info("Fetch teh Current Page url is-->"+currentURL);
	   Thread.sleep(500);
	   webdriver.findElement(PreviewThumbnailImage).isDisplayed();
	   Log.info("Thumbnail Image is present");
   }
   @And("^Validate preview image Title$")
   public void validate_preview_image_title() throws Exception { 
	   util.ScrollDown(PreviewImageTtile);
	   webdriver.findElement(PreviewImageTtile).isDisplayed();
	   Log.info("Preview Image Title is present");
	   util.ScrollDown(PreviewImageTtile);
	   PreviewImgtitle=webdriver.findElement(PreviewImageTtile).getText();
	   Log.info("Preview Image Title is-->"+PreviewImgtitle);
   }
   @And("^Validate preview thumbnail image Title$")
   public void validate_preview_thumbnail_image_title() throws Exception { 
	   util.ScrollDown(PreviewThumbnailtitle);
	   webdriver.findElement(PreviewThumbnailtitle).isDisplayed();
	   Log.info("Preview Thumbnail Image Title is present");
	   String thumbnailImgtitle=webdriver.findElement(PreviewThumbnailtitle).getText();
	   Log.info("Preview thumbnail Image Title is-->"+thumbnailImgtitle);
   }
   
   @And("^Validate preview image Rating$")
   public void validate_preview_image_rating() throws Exception { 
	   util.ScrollDown(PreviewImageRating);
	   webdriver.findElement(PreviewImageRating).isDisplayed();
	   Log.info("Preview Rating Image is present");
   }
	/***************************************************************************************
	 * @Function_Name :  validate_subscribe_price
	 * @Description   :  validate subscribe price and compare with excel test data
	 ***************************************************************************************/
   @And("^Validate subscribe price text$")
   public void validate_subscribe_price() throws Exception { 
	   util.ScrollDown(SubsPriceText);
       util.isElementPresent(SubsPriceText);
	   Log.info("Verify the Subscribe text price");
	   String text=webdriver.findElement(SubsPriceText).getText();
	   Log.info("Subs Price Text in Subscribe Page-->"+text);
	   String actualtext=Launcher.getvaluefromExcelDataMap("Subscription_Sub-PriceText");
	   Assert.assertTrue(text.equalsIgnoreCase(actualtext));
	   Log.info("Compare subs price text with excel data");
   }
	/***************************************************************************************
	 * @Function_Name :  validate_preview_image_Dimension
	 * @Description   :  validate preview image Dimension and compare with excel test data in preview Page
	 ***************************************************************************************/
   @And("^Validate preview image Dimension$")
   public void validate_preview_image_Dimension() throws Exception{
   	String dimension=Launcher.getvaluefromExcelDataMap("Subscription_Dimension");
   	Log.info("Got preview image size from excel sheet");
   	util.check_dimensions(webdriver.findElement(PreviewImage), dimension);
   }
   @And("^Validate thumbnail image Dimension$")
   public void validate_thumbnail_image_Dimension() throws Exception{
   	String dimension=Launcher.getvaluefromExcelDataMap("Subscription_Dimension");
   	Log.info("Got preview image size from excel sheet");
   	util.check_dimensions(webdriver.findElement(PreviewThumbnailImage), dimension);
   }
	/***************************************************************************************
	 * @Function_Name :  Click_on_Cancel_Active
	 * @Description   :  Click on Cancel or Active (The Parameter pass inside test case in feature file)
	 ***************************************************************************************/
   @Then("^Click on \"([^\"]*)\" Button$")
   public void Click_on_Cancel_Active(String option) throws Exception { 
	   util.ScrollDown(CancelButton);
	   if(option.equalsIgnoreCase("Cancel")) {
		   util.ScrollDown(CancelButton);
		   Assert.assertTrue("Cancel button is display", util.isElementPresent(CancelButton));
		   Log.info("Verify Cancel button is present");
		   util.safeJavaScriptClick(CancelButton);
		   Log.info("Click on Cancel Button");
		   //Landing Home Page and Validate Page Title
		   util.waitForLoad(webdriver);
		   String homeTitle = webdriver.getTitle();
		   Log.info("Current Page Title-->"+homeTitle);
		   String currentURL=webdriver.getCurrentUrl();
		   Log.info("Fetch the Current Page url is-->"+currentURL);
	   }
	   if(option.equalsIgnoreCase("Active")) {
		   util.ScrollDown(ActiveButton);
		   Assert.assertTrue("Active button is display", util.isElementPresent(CancelButton));
		   Log.info("Verify Active button is present");
		   util.safeJavaScriptClick(ActiveButton);
		   Log.info("Click on Active Button");
		   util.waitForLoad(webdriver);
		   String homeTitle = webdriver.getTitle();
		   Log.info("Subscribed Page Title-->"+homeTitle);
	   }
   }
   @Then("^Validate Cancel and Acitve Button is Present$")
   public void Validate_Cancel_Active_Button() throws Exception { 
	   util.ScrollDown(CancelButton);
	   webdriver.findElement(CancelButton).isDisplayed();
	   Log.info("Verify Cancel button is present");
	   webdriver.findElement(ActiveButton).isDisplayed();
	   Log.info("Verify Active button is present");
   }
	/***************************************************************************************
	 * @Function_Name :  validate_subscribe_smallprintText
	 * @Description   :  validate subscribe smallprint text and compare with test data
	 ***************************************************************************************/
   @And("^Validate subscribe smallprint text$")
   public void validate_subscribe_smallprintText() throws Exception {
	   webdriver.findElement(TermsConditionText).isDisplayed();
	   Log.info("Verify Subscribe smallprint is present");
	   String actualtext=webdriver.findElement(TermsConditionText).getText();
	   Log.info("Actual Subscribe smallprint is present in Subscribe Page-->"+actualtext);
	   String Expectedtext=Launcher.getvaluefromExcelDataMap("Subscription_Subscribe-SmallPrintText");
	   Log.info("Expected Subscribe smallprint is -->"+Expectedtext);
	   Assert.assertTrue(Expectedtext.equalsIgnoreCase(actualtext));
	   Log.info("Compare smallprint text with excel data");
   }
   @Then("^Navigate to subscription page based on Gallery Image$")
   public String Navigate_To_subscriptionPage_Gallery_Img() throws Exception {	
	   util.waitForLoad(webdriver);
	   List<WebElement> Img=webdriver.findElements(ThumbnailGallery);
	   List<WebElement> Title=webdriver.findElements(ThumbnailGalleryTitle);
	   int BannerNum=Img.size();
	   Log.info("Num of Thumbnail Image Present in Gallery Page-->"+BannerNum);
	   String text=Title.get(0).getText();
	   Log.info("Thumbnail Image title is-->"+text);
	   Img.get(1).click();
	   Log.info("Click on 1st Thumbnail");
	   Thread.sleep(5000);
	   return text;

   }
   @And("^Validate PPU price text$")
   public void validate_ppu_price() throws Exception { 
	   util.ScrollDownOperation(PPUpriceInfo);
	   Thread.sleep(500);
	   webdriver.findElement(PPUpriceInfo).isDisplayed();
	   Log.info("Verify the PPU Subscribe text price");
	   String text=webdriver.findElement(PPUpriceInfo).getText();
	   Log.info("PPU Price Text in Subscribe Page-->"+text);
//	   String actualtext=Launcher.getvaluefromExcelDataMap("Subscription_Sub-PriceText");
//	   Assert.assertTrue(text.equalsIgnoreCase(actualtext));
//	   Log.info("Compare subs price text with excel data");
   }
   @And("^Click on to Buy Button$")
   public String Click_ToBuy_Btn() throws Exception { 
	   util.ScrollDown(DownLoadThumbnailTitle);
	   String title=webdriver.findElement(DownLoadThumbnailTitle).getText();
	   Log.info("DownLoad Thumbnail Title-->"+title);
	   util.ScrollDown(BuyButton);
	   webdriver.findElement(BuyButton).isDisplayed();
	   Log.info("Verify ToBuy button is present");
	 //  webdriver.findElement(BuyButton).click();
	   util.safeJavaScriptClick(BuyButton);
	   Log.info("Click on TOBuy Button");
	   util.waitForLoad(webdriver);
	   Thread.sleep(20000);
	   String DownloadPageurl = webdriver.getCurrentUrl();
	   Log.info("Current Download Page url-->"+DownloadPageurl);
	   String PageTitle = webdriver.getTitle();
	   Log.info("Current Download Page Title-->"+PageTitle);
	return title;
   }
   
   @And("^Validate Previous and current page link$")
   public void Validate_Previous_Current_Link() throws Exception { 
	   util.waitForLoad(webdriver);
	   webdriver.findElement(PreviousPageLink).isDisplayed();
	   Log.info("Verify Previous Page Link");
	   String text=webdriver.findElement(PreviousPageLink).getText();
	   Log.info("Previous Page Link Text-->"+text);
	   webdriver.findElement(CurrentPageLink).isDisplayed();
	   Log.info("Verify Current Page Link");
	   String crntPageText=webdriver.findElement(CurrentPageLink).getText();
	   Log.info("current Page Text-->"+crntPageText);
   }
   @And("^Validate Download Image Title and rating image$")
   public void Validate_download_Image_Title() throws Exception { 
	   util.waitForLoad(webdriver);
	   webdriver.findElement(DownLoadThumbnail).isDisplayed();
	   Log.info("Verify DownLoad Thumbnail is present");
	   
	   String title=webdriver.findElement(DownLoadThumbnailTitle).getText();
	   Log.info("DownLoad Thumbnail Title-->"+title);
	   
	   webdriver.findElement(DownLoadThumbnailRatingImg).isDisplayed();
	   webdriver.findElement(DownLoadThumbnailRatingImg).getCssValue("");
	   Log.info("Verify DownLoad Thumbnail RatingImg is present");
	   
	   
   }
   @And("^Validate subscribe purchase and Download Button$")
   public void Validate_download_subscribe_DownloadBtn() throws Exception { 
	   util.ScrollDown(DownLoadsubscribeMsg);
	   String subscribeMsg=webdriver.findElement(DownLoadsubscribeMsg).getText();
	   Log.info("DownLoad subscribe Msg Text-->"+subscribeMsg);
	   
	   String purchaseMsg=webdriver.findElement(DownLoadpurchaseMsg).getText();
	   Log.info("DownLoad purchase Msg Text-->"+purchaseMsg);
	   
	   String description=webdriver.findElement(DownLoadDescriptionText).getText();
	   
	   Log.info("DownLoad Description Text-->"+description);
	   
	   webdriver.findElement(DownLoadButton).isDisplayed();
	   Log.info("Verify DownLoad Button is present");
   }
   @And("^Click on Buy button and Validate the Download file$")
   public void Validate_Download_file() throws Exception { 
	   //Delete the existing file in Download folder
	    Delete_Downloaded_file();
	   String downloadImgTitle=Click_ToBuy_Btn();
	   // String downloadImgTtile="4x4 Rally Champions";
	   String after =downloadImgTitle.trim().replaceAll("\\s","");
	   Util.WaitForDownloadFile(downloadPath,after);
	   Thread.sleep(10000);
	   String downloadedFileName=Util.getLatestFilefromDir(downloadPath);
	   System.out.println("Downloaded File Name====>["+downloadedFileName+"] and Actual file name from UI ["+after+"]");
	   Util.ValidateDownloadFile(downloadPath);
   }
   
   @And("^Delete all the old download files$")
   public void Delete_Downloaded_file() throws Exception { 
	   Util.deleteDownloadedFile(downloadPath);
    }
   @Then("^Validate CSS property for \"([^\"]*)\" Button$")
	public void validate_CSS_Menu_icon(String option) throws Exception { 
		String CancelBtnCssValue=Launcher.getvaluefromExcelDataMap("Subscription_CancelBtn_CSS_Properties_Value");
		String ActiveBtnCssValue=Launcher.getvaluefromExcelDataMap("Subscription_ActiveBtn_CSS_Properties_Value");
		if(option.equalsIgnoreCase("Cancel")) {
			util.ScrollDown(CancelButton);
			util.Validate_CSS_Properties_Value(Launcher.getdriver().findElement(CancelButton),CancelBtnCssValue);
		}
		if(option.equalsIgnoreCase("Active")) {
			util.ScrollDown(ActiveButton);
			util.Validate_CSS_Properties_Value(Launcher.getdriver().findElement(ActiveButton),ActiveBtnCssValue);
		}
	}
   
   @Then("^Click on thumbnail Image based on Title Name$")
	public void ClickOn_CarousalImg_title() throws Exception{
		
		String ExpectedModuleTitle=Launcher.getvaluefromExcelDataMap("Subscription_CategoryTitleName");
		By temp = util.modifyXpath(ThumbnailImage,ExpectedModuleTitle);
		util.ScrollDown(temp);
		util.safeJavaScriptClick(temp);
		Log.info("Click on Frist Image under module title==>"+ExpectedModuleTitle);
	}
   
   
	@And("^Validate Preview thumbnail description$")
	public void validate_Download_thumbnail_description() throws Exception {
		Thread.sleep(1000);
		util.ScrollDown(PreviewThumbnailDescrip);
		util.isElementPresent(PreviewThumbnailDescrip);
		Log.info(" Preview thumbnail description is present");
		String desc = webdriver.findElement(PreviewThumbnailDescrip).getText();
		Log.info(" Preview thumbnail description is-->" + desc);
	}
	
	@And("^Validate Preview subcription text$")
	public void validate_Download_creditMsg() throws Exception {
		Thread.sleep(1000);
		util.ScrollDown(DownLoadCreditMsgText);
		util.isElementPresent(DownLoadCreditMsgText);
		Log.info("DownLoad CreditMsg Text is present");
		String text = webdriver.findElement(DownLoadCreditMsgText).getText();
		Log.info("DownLoad Credit Msg Text-->" + text);
	}
	
	
	//Ugames
	
	@Then("^Validate Preview product image and Title Description$")
	public void validate_Product_Img() throws Exception { 
		String ThumbnailTitle=Launcher.getvaluefromExcelDataMap("Subscription_SelectOnGameName");
		util.waitForLoad(webdriver);
		String currentURL=webdriver.getCurrentUrl();
		Log.info("Fetch teh Current Page url is-->"+currentURL);
		Thread.sleep(500);
		String Title = webdriver.getTitle();
	    Log.info("Current Page Title-->"+Title);
		webdriver.findElement(ProductBanner).isDisplayed();
		Log.info("Preview Bannner is present");

		webdriver.findElement(Productthumbnail).isDisplayed();
		Log.info("Preview product-thumbnail is present");

		webdriver.findElement(ProductDownloadImg).isDisplayed();
		Log.info("Preview Product Download Img is present");
		
		String text = webdriver.findElement(ProductTitle).getText();
		Log.info("Preview Product Title-->" + text);
		temp=util.modifyXpath(ValidateProductTitle,ThumbnailTitle);
		Assert.assertTrue("Text is present", util.isElementPresent(temp));
		Log.info("Validate the Selected Product in preview Page");
		String text1=webdriver.findElement(ProductDev).getText();
		Log.info("Product Developer text-->"+text1);
		String text2=webdriver.findElement(ProductDesc).getText();
		Log.info("Preview Product Desc-->"+text2);
	}
	@Then("^Validate Download thumbnail screenshot$")
	public void validate_Download_screenshot_Image() throws Exception {
		Thread.sleep(1000);
		util.ScrollDown(ScreenShotImg);
		util.isElementPresent(ScreenShotImg);
		Log.info("Preview Thumbnail ScreenShot Section is present");
		List<WebElement> screenshot = webdriver.findElements(ScreenShotImg);
		Log.info("Num of Preview Thumbnai screenshot Present-->" + screenshot.size());
	}
	
	@Then("^Validate Preview Thumbnail File Size$")
	public void validate_Thumbnail_FileSize() throws Exception {
		Thread.sleep(1000);
		util.ScrollDown(FileSize);
		String size = webdriver.findElement(FileSize).getText();
		Log.info("Preview Thumbnail File Size-->" + size);
	}
	
	@Then("^Click on Download icon and go to Subscribe Page$")
	public void Click_Download_Icon() throws Exception {
		util.ScrollDown(ProductDownloadImg);
		util.safeJavaScriptClick(ProductDownloadImg);
		Log.info("Click on Download Icon");
		util.waitForLoad(webdriver);
		String currentURL=webdriver.getCurrentUrl();
		Log.info("Fetch the Current Page url is-->"+currentURL);
		String Title = webdriver.getTitle();
		Log.info("Current Page Title-->"+Title);
	}
	@Then("^Validate Subscribe Image and Title$")
	public void Validate_Subcribe_Image_Title() throws Exception {
		String ThumbnailTitle=Launcher.getvaluefromExcelDataMap("Subscription_SelectOnGameName");
		String text = webdriver.findElement(ProductTitle).getText();
		Assert.assertTrue("Validate Text",ThumbnailTitle.equalsIgnoreCase(text));
		Log.info("Validate Product Title-->"+text);
		Assert.assertTrue("Validate Image", util.isElementPresent(Productthumbnail));
		Log.info("Validate Subscribe Image");
	}
	
	@Then("^Validate Subscirbe Box and Text$")
	public void validate_Subscirbe_TextBox() throws Exception {
		util.ScrollDown(SubscribeBoxText);
		String text = webdriver.findElement(SubscribeBoxText).getText();
		Log.info("Subscribe Box Text-->" + text);
	}
	
	@Then("^Validate Cancel and Active Button Preview Page$")
	public void validate_Cencel_Active_Btn() throws Exception {
		util.ScrollDown(PositiveBtn);
		String btn = webdriver.findElement(PositiveBtn).getText();
		Log.info("Active Btn Text-->" + btn);
		util.ScrollDown(PositiveBtn);
		String btn1 = webdriver.findElement(NegativeBtn).getText();
		Log.info("Cancel Btn Text-->" + btn1);
	}
	
	@Then("^Click on Active Button$")
	public void Click_on_Active_Btn() throws Exception {
		util.ScrollDown(PositiveBtn);
		String text = webdriver.findElement(PositiveBtn).getText();
		Log.info("Positive Btn Text-->" + text);
		util.safeJavaScriptClick(PositiveBtn);
		Log.info("Click on Active Button");
		util.waitForLoad(webdriver);
		String currentURL=webdriver.getCurrentUrl();
		Log.info("Fetch the Current Page url is-->"+currentURL);
		String Title = webdriver.getTitle();
	    Log.info("Current Page Title-->"+Title);
	}
	
	@Then("^Validate the App Promotion text$")
	public void validate_App_Promotion_text_Present() throws Exception{
		String expectedtext = Launcher.getdriver().findElement(AppPromotionText).getText();
		Log.info("App Promotion text==>"+expectedtext);
	}
	@Then("^Click on App store link and Validate the App store Page$")
	public void validate_App_Store_Page() throws Exception{
		util.safeJavaScriptClick(AppPromotionGreenImg);
		Log.info("Click on App Promotion Green Img");
		Assert.assertTrue("Validate AppStore Page",pageconfirmation.isAppStorePage());
		Log.info("Validate we are in App Store Page");
		webdriver.navigate().back();
		Log.info("Back in Previous Page ====>");
		Assert.assertTrue("Validate AppStore Page",pageconfirmation.isHomePage());
		Log.info("Validate we are in App Store Page");
	}
	@Then("^Click on Close Button and validate app-promotion text is disappear$")
	public void Click_on_Close_Btn() throws Exception {
		util.safeJavaScriptClick(ApppromotionClose);
		Log.info("Click on App promotion Close icon");
		Assert.assertTrue("App promotion text is disappear", util.isElementDisappear(AppPromotionText));
		Log.info("App promotion text is disappear");
		Assert.assertTrue("App promotion Close icon is disappear", util.isElementDisappear(ApppromotionClose));
		Log.info("App promotion Close icon is disappear");
	}
	
	@Then("^Close the Alert Container$")
	public void Close_Alert_Container() throws Exception {
		try {
			util.isElementPresent(AlertContainer);
			util.safeJavaScriptClick(AlertContainerClose);
			Log.info("Close the Alert Container");
		}catch (Exception e) {
			Log.info("Not Close the Alert Container");
		}
		

	}
	@Then("^Validate UIM Gateway Page$")
	public void Validate_UIM_Gateway_Page() throws Exception {
		
		Assert.assertTrue("Validate UIMGateway Page",pageconfirmation.isUIMGatewayPage());
		Log.info("Validate we are in UIMGateway Page");
		
		String text = webdriver.findElement(UIMErrorTitle).getText();
		Log.info("UIM Error Title-->" +text);
		
		String ParaText = webdriver.findElement(UIMErrorParaText).getText();
		Log.info("UIM Error Para Text-->" +ParaText);
		
		util.safeJavaScriptClick(ContinueBtn);
		Log.info("Click on Continue Button");
		
		Assert.assertTrue("Validate UIM View Page",pageconfirmation.isUIMViewPage());
		Log.info("Validate we are in UIM View Page");
	}	
	@Then("^Validate UIM View Page and Enter MSISDN \"([^\"]*)\"$")
	public void Validate_UIM_View_Page(String msisdn) throws Exception {
		
		String text = webdriver.findElement(SmalltextDigital).getText();
		Log.info("UIM Small text Digital-->" +text);
		
		String GreyText = webdriver.findElement(SmallTextDigitalGrey).getText();
		Log.info("UIM Small Text Digital Grey-->" +GreyText);
		
		util.waitForElementToAppear(InputboxbigName);
		webdriver.findElement(InputboxbigName).sendKeys(msisdn);
		Log.info("Enter the MSISDN in Input Box");
		
		util.safeJavaScriptClick(REBICIRENLACEBtn);
		Log.info("Click on REBICIR ENLACEB Button");
		
	}	
	@Then("^Validate \"([^\"]*)\" portal logo$")
	public void validate_Logo_Portal(String portal) throws Exception { 
		if(portal.equalsIgnoreCase("Tourist")) {
			ValidateLogo(portal,PortalLogoImg);
		}
		if(portal.equalsIgnoreCase("PlayOn")) {
			ValidateLogo(portal,PortalLogoImg);
		}
		if(portal.equalsIgnoreCase("PDMT")) {
			ValidateLogo(portal,PortalLogoImg);
		}
	}
	public void ValidateLogo(String portal,By xpath) {
		util.isElementPresent(xpath);
        Assert.assertTrue("Portal Logo Banner is present",util.isElementPresent(xpath));
		Log.info("Portal ["+portal+"] logo  Banner is displayed");
	}
	
	@Then("^Validate \"([^\"]*)\" Portal Banner Image$")
	public void validate_Banner_Img(String portal) throws Exception { 
           util.GetCurrenturlAndTitle();
		   util.isElementPresent(BannerImg);
		   Log.info("Preview Banner is present in-->"+portal);
	}
	@Then("^Validate \"([^\"]*)\" subscribe price text$")
	public void Validate_Portal_subscribe_price(String portal) throws Exception { 
		util.ScrollDown(SubsPriceText);
		util.isElementPresent(SubsPriceText);
		Log.info("Verify the Subscribe text price");
		String text=webdriver.findElement(SubsPriceText).getText();
		Log.info("Subs Price Text in Subscribe Page-->"+text);
/*		String actualtext=Launcher.getvaluefromExcelDataMap("Subscription_Sub-PriceText");
		Assert.assertTrue(text.equalsIgnoreCase(actualtext));
		Log.info("Compare subs price text with excel data");*/
	}
	@Then("^Validate \"([^\"]*)\" Cancel and Acitve Button$")
	public void Validate_Cancel_Active_BTN(String portal) throws Exception { 
		util.ScrollDown(CancelButton);
		webdriver.findElement(CancelButton).isDisplayed();
		Log.info("Verify Cancel button is present");
		String text=webdriver.findElement(CancelButton).getText();
		Log.info("Cancel buttonText in SubscribeApp Page-->"+text);
		webdriver.findElement(ActiveButton).isDisplayed();
		Log.info("Verify Active button is present");
		String text1=webdriver.findElement(ActiveButton).getText();
		Log.info("Active button Text in SubscribeApp Page-->"+text1);
	}
	@Then("^Click \"([^\"]*)\" on Active Button$")
	public void Click_On_ACTIVE_BTN(String portal) throws Exception { 
		  
		   util.ScrollDown(ActiveButton);
		   Assert.assertTrue("Active button is display", util.isElementPresent(ActiveButton));
		   Log.info("Verify Active button is present");
		   util.safeJavaScriptClick(ActiveButton);
		   Log.info("Click on Active Button");
		   
		   util.waitForLoad(webdriver);
           util.GetCurrenturlAndTitle();
	   }	
	@Then("^Validate \"([^\"]*)\" Preview Image and Text$")
	public void Validate_Banner_(String portal) throws Exception { 
		if(portal.equalsIgnoreCase("Tourist")) {
			Validate_Preview_Banner(portal,SubscribeApppreviewImg);
			Validate_Preview_Banner_Text(portal,SubscribeApppreviewTitle);
			Validate_Preview_Banner_Rating(portal,SubscribeApppreviewRating);
		}
		if(portal.equalsIgnoreCase("PlayOn")) {
			ValidateLogo(portal,PortalLogoImg);
		}
		if(portal.equalsIgnoreCase("PDMT")) {
			ValidateLogo(portal,PortalLogoImg);
		}
	}
	  public void Validate_Preview_Banner(String portal,By Xpath) throws Exception { 
           util.isElementPresent(Xpath);
           Log.info("Portal ["+portal+"] Preview  Banner is displayed");
	   }
	  public void Validate_Preview_Banner_Text(String portal,By Xpath) throws Exception { 
          util.isElementPresent(Xpath);
          Log.info("Portal ["+portal+"] Preview Banner Text is displayed");
          String text=webdriver.findElement(Xpath).getText();
  		  Log.info("Preview Text in SubscribeApp Page-->"+text);
	   }
	  public void Validate_Preview_Banner_Rating(String portal,By Xpath) throws Exception { 
          util.isElementPresent(Xpath);
          Log.info("Portal ["+portal+"] Preview  Banner Rating is displayed");
	   }
}