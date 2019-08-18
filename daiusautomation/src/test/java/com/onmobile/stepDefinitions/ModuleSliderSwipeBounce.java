package com.onmobile.stepDefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.onmobile.utils.Util;
import com.onmobile.xpaths.PortalXpath;

import cucumber.api.java.en.Then;

public class ModuleSliderSwipeBounce implements PortalXpath{
	static Logger Log = LogManager.getLogger("test");
	Util util=new Util();
	
    WebDriver webdriver=Launcher.getdriver();
	
    @Then("^Validate swipe module$")
    public void validate_swipe_module() throws Exception { 
    	Assert.assertTrue(webdriver.findElement(SwipeModule).isDisplayed());
    	Log.info("Swipe module is present");
    }
    @Then("^Validate CSS property for Module Swipe Bounce Image Title and Rating Image$")
    public void validate_CSS_Menu_icon() throws Exception { 
    	String Image_CssValue=Launcher.getvaluefromExcelDataMap("SwipeBounceModule_CarouselImg_CSS_Properties_Value");
    	String Title_CssValue=Launcher.getvaluefromExcelDataMap("SwipeBounceModule_CarouselTitle_CSS_Properties_Value");
    	String RateImg_CssValue=Launcher.getvaluefromExcelDataMap("SwipeBounceModule_CarouselRatingImg_CSS_Properties_Value");

    	List<WebElement> swipeImage=webdriver.findElements(TopCarouselImg);
    	WebElement title=webdriver.findElement(CarouselTitle);
    	WebElement ratingImg=webdriver.findElement(CarouselRatingImage);
    			for(WebElement element: swipeImage){
    				util.ScrollDown(element);
    				util.Validate_CSS_Properties_Value(element,Image_CssValue);
    				util.Validate_CSS_Properties_Value(title,Title_CssValue);
    				util.Validate_CSS_Properties_Value(ratingImg,RateImg_CssValue);
    			}
    }
    @Then("^Validate carousel module swipe$")
    public void validate_carousal_swipe() throws Throwable{
    	
    	String ExpectedImgCount=Launcher.getvaluefromExcelDataMap("SwipeBounceModule_CarouselimgCount");
    	int ActualImgCount=webdriver.findElements(ListOfImage).size();
    	Log.info("Num of carousel-item present are-->"+ActualImgCount);
    	Assert.assertTrue("Compare the Image Count", ActualImgCount==Integer.parseInt(ExpectedImgCount));
    	Log.info("Compare the Carousel image count with expected test data");
    	util.ScrollDown(TopCarouselImg);
    	String title=webdriver.findElement(TopCarouselImgTitle).getText();
    	Log.info("Carousel image Title is-->"+title);
    	
    	Assert.assertTrue(webdriver.findElement(CarouselRatingImage).isDisplayed());
    	Log.info("Carousel Rating image is present");
    	
//    	List<WebElement> CarouselImg=webdriver.findElements(CarouselImage);
//    	List<WebElement> CarouselImgTitle=webdriver.findElements(CarouselTitle);
//    	List<WebElement> CarouselImgrating=webdriver.findElements(CarouselRatingImage);
//    	
//    	List<String> titleText= new ArrayList<>();
    	
    	
//    	Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_F12);
//		robot.keyRelease(KeyEvent.VK_F12);
//		Thread.sleep(500);
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_SHIFT);
//		robot.keyPress(KeyEvent.VK_M);
//		
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		robot.keyRelease(KeyEvent.VK_SHIFT);
//		robot.keyRelease(KeyEvent.VK_M);
    	
//    	for(int i=2;i<ImgNum;i++){
//            
//    		Assert.assertTrue(CarouselImg.get(i).isDisplayed());
//    		Log.info("Thumbnail Image is present");
//    		
//    		Dimension dim=CarouselImg.get(i).getSize();
//    		int x=dim.getWidth();
//    		
//    		Actions builder = new Actions(webdriver);
//    		
//    		builder.clickAndHold(CarouselImg.get(i)).moveByOffset(-100,0).release().build().perform();
    		
    		
    		//builder.dragAndDropBy(CarouselImg.get(i),80,0)
    		//.build().perform();
    		
    		
    		
    		/*//util.ScrollDown(CarouselTitle);
    		Assert.assertTrue(CarouselImgTitle.get(i).isDisplayed());
    		Log.info("Thumbnail Image Title is present");
    		String text=CarouselImgTitle.get(i).getText();
    		titleText.add(text);
    		Log.info("Gallery Title Name-->"+text);
    		Assert.assertTrue(CarouselImgrating.get(i).isDisplayed());
    		Log.info("Thumbnail Rating is present");*/

    	//}
    //	Log.info("All Gallery Title Name-->"+titleText);
    }
}
