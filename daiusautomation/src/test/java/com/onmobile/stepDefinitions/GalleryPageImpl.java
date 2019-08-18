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

public class GalleryPageImpl implements PortalXpath {
	static Logger Log = LogManager.getLogger("test");
	Util util = new Util();
	By temp;
	WebDriver webdriver = Launcher.getdriver();

	/********************************************************************************************
	 * @Function_Name : Validate_GalleryPage
	 * @Description : Validate all Image count, dimension,Image Title,Rating img in
	 *              Gallery Page
	 ***************************************************************************************/
	@Then("^Validate current Gallery Page Link$")
	public void Validate_CategoryText() throws Exception {
		util.waitForLoad(webdriver);
		String GalleryPageTitle = webdriver.findElement(CurrentPageLink).getText();
		Log.info("Current Gallery Page link Name-->" + GalleryPageTitle);
		String galleryurl = webdriver.getCurrentUrl();
		Log.info("Current Gallery page url-->" + galleryurl);
	}

	@Then("^Validate Gallery Banner and Description$")
	public void Validate_Banner_Description() throws Exception {
		util.waitForLoad(webdriver);
		webdriver.findElement(GalleryBanner).isDisplayed();
		Log.info("Gallery Banner is present");
		String Gallerydesc = webdriver.findElement(GalleryDescription).getText();
		Log.info("Gallery Description-->" + Gallerydesc);

	}

	@Then("^Validate all Gallery item$")
	public void Validate_GalleryPage() throws Exception {
		util.waitForLoad(webdriver);
		String dimension = Launcher.getvaluefromExcelDataMap("GalleryPage_Dimension");
		int count = Integer.parseInt(Launcher.getvaluefromExcelDataMap("GalleryPage_PaginationCount"));

		List<WebElement> thumbnailimg = new ArrayList<WebElement>();
		List<WebElement> thumbnailTitle = new ArrayList<WebElement>();
	//	List<WebElement> thumbnailImgRating = new ArrayList<WebElement>();

		thumbnailimg = webdriver.findElements(ThumbnailGallery);
		thumbnailTitle = webdriver.findElements(ThumbnailGalleryTitle);
	//	thumbnailImgRating = webdriver.findElements(ThumbnailRatingStar);

		int NumOfthumbnail = 0;
		NumOfthumbnail = webdriver.findElements(ThumbnailGallery).size();
		Log.info("Num of Thumbnail Image Present in Gallery Page-->" + NumOfthumbnail);

		/// Check the Pagination image count not more than 10 and continue validating
		if (NumOfthumbnail <= count) {

			int number = 0;
			List<String> titleText = new ArrayList<>();

			for (int i = 0; i < NumOfthumbnail; i++) {
				util.ScrollDown(thumbnailimg.get(i));
				thumbnailimg.get(i).isDisplayed();
				Log.info("Verify thumbnail Image is present");
				util.check_dimensions(thumbnailimg.get(i), dimension);
				util.ScrollDown(thumbnailTitle.get(i));
				Thread.sleep(3000);
				number = new Integer(number + 1);
				String text = thumbnailTitle.get(i).getText();
				titleText.add(text);
				Log.info("Verify number(" + number + ") of thumbnail Image Present in Gallery Page");
				Log.info("Gallery Title Name-->" + text);
				/*thumbnailImgRating.get(i).isDisplayed();
				Log.info("Verify Rating Image is present");*/

				////////////////////////////

				if (i + 1 == NumOfthumbnail) {
					try {
						Thread.sleep(500);
						webdriver.findElement(GalleryMoreButton).isDisplayed();
						webdriver.findElement(GalleryMoreButton).click();
						Log.info("Click on more button");
						util.waitForElementToAppear(ThumbnailGallery);
						Thread.sleep(3000);
						NumOfthumbnail = webdriver.findElements(ThumbnailGallery).size();
						Log.info("After click on More button Num of Thumbnail Image is-->" + NumOfthumbnail);

						thumbnailimg = webdriver.findElements(ThumbnailGallery);
						thumbnailTitle = webdriver.findElements(ThumbnailGalleryTitle);
					//	thumbnailImgRating = webdriver.findElements(ThumbnailRatingStar);

					} catch (Exception e) {
						Log.info("More button is not present");
					}

				} else {
					Log.info("====>Continue with loop===>");
				}

			}
			Log.info("All present Gallery Title Name are -->" + titleText);
		} else {
			Log.info("===>Pagination Count is more than 10=====>");
			Assert.fail("Pagination Count is more than 10");

		}
	}

	/********************************************************************************************
	 * @Function_Name : Navigate_To_GalleryPage
	 * @Description : Navigate to Gallery page based on category title(Fetch from
	 *              test data Sheet)
	 ***************************************************************************************/
	@Then("^Navigate to Gallery page based on category title$")
	public void Navigate_To_GalleryPage() throws Exception {
		String categoryTitle = Launcher.getvaluefromExcelDataMap("GalleryPage_CategoryTitleName");
		temp = util.modifyXpath(CategoryTitleName, categoryTitle);
		util.ScrollDown(temp);
		webdriver.findElement(temp).isDisplayed();
		Log.info("Category Ttile [" + categoryTitle + "] is present");
		try {
			temp = util.modifyXpath(MoreBtnCategoryName, categoryTitle);
			webdriver.findElement(temp).isDisplayed();
			Log.info("More button is present");
			util.safeJavaScriptClick(temp);
			Log.info("Click on More Button");
		} catch (Exception e) {
			Log.info("More Button is not present");
		}
	}

	@Then("^Navigate to Gallery page based on Banner Image$")
	public void Navigate_To_GalleryPage_Banner_Img() throws Exception {
		util.waitForLoad(webdriver);
		List<WebElement> bannerImg = webdriver.findElements(BannerImage);
		int BannerNum = bannerImg.size();
		Log.info("Num of Banner Image Present in Home Page-->" + BannerNum);
		bannerImg.get(0).click();
		Log.info("Click on Category Banner Image");
		Thread.sleep(5000);
	}

	
	//Ugmaes
	@Then("^Validate Back-Arrow link is present$")
	public void validate_back_ArrowLink() throws Exception {
		Assert.assertTrue("Back Arrow is present", util.isElementPresent(BackArrow));
		webdriver.findElement(BackArrow).isDisplayed();
		Log.info(" Back-Arrow link is present");
	}
	
	@Then("^Validate all Gallery Content list item$")
	public void Validate_Gallery_ContentList() throws Exception {
		
	//	List<WebElement> Ranking = webdriver.findElements(ModuleContentListRanking);
		List<WebElement> CarouselImage = webdriver.findElements(ModuleContentListCarouselImg);
		List<WebElement> Caption =  webdriver.findElements(GalleryModuleContentListcaption);
		List<WebElement> developer =  webdriver.findElements(ModuleContentListDeveloper);
		List<WebElement> OnlineImg =  webdriver.findElements(ModuleContentListratingImg);
			
		
		int NumOfcarouselImg = CarouselImage.size();
		Log.info("Num of carousel Image Present in Gallery Page-->" + NumOfcarouselImg);
		List<String> titleText = new ArrayList<>();
		
        for(int i=0;i<NumOfcarouselImg;i++) {
        	
        	util.ScrollDown(CarouselImage.get(i));
        	
        	/*Ranking.get(i).isDisplayed();
        	String rank = Ranking.get(i).getText();
			Log.info("Verify Ranking is present");
			Log.info("Verify Ranking (" + rank + ") of carousel Image in Gallery Page");*/
			
			CarouselImage.get(i).isDisplayed();
			Log.info("Verify carousel Image is present");
			Log.info("Verify number(" + (i+1) + ") of carousel Image Present in Gallery Page");
			
			String text = Caption.get(i).getText();
			Log.info("Carousel Name-->" + text);
			titleText.add(text);
			
			String develop = developer.get(i).getText();
			Log.info("Game developer Name-->" + develop);
			/*
			ImgRating.get(i).isDisplayed();
			Log.info("Verify Rating Image is present");*/
        }
        int NumofonlineImg = OnlineImg.size();
		Log.info("Num of Online Image Present in Gallery Page-->" + NumofonlineImg);
        
        Log.info("All present Gallery Title Name are -->" + titleText); 
		util.safeJavaScriptClick(BackIcon);
		Log.info("Click on Back Icon and goto Home Page");
	}

	@Then("^Validate all Ranking item$")
	public void Validate_Ranking_Item() throws Exception {
		
		List<WebElement> Ranking = webdriver.findElements(ModuleContentListRanking);
		util.waitForLoad(webdriver);
		for(int i=0;i<Ranking.size();i++) {
			Ranking.get(i).isDisplayed();
			String rank = Ranking.get(i).getText();
			Log.info("Verify Ranking is present");
			Log.info("Verify Ranking (" + rank + ") of carousel Image in Gallery Page");
		}
	}
	@Then("^Click on Game Thumbnail Text and go to Preview Page$")
	public void ClickOn_Category_Name() throws Exception{
		
		String GalleryName=Launcher.getvaluefromExcelDataMap("Subscription_SelectOnGameName");
		temp=util.modifyXpath(SelectGameGallery,GalleryName);
		util.ScrollDown(temp);
		util.safeJavaScriptClick(temp);
		Log.info("Click on Game Gallery Name--> "+GalleryName);
	}
}