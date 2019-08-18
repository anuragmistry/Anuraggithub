package com.onmobile.stepDefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.onmobile.utils.Util;
import com.onmobile.xpaths.PortalXpath;

import cucumber.api.java.en.Then;
import org.junit.Assert;

public class UnsubUserText implements PortalXpath {
	
	static Logger Log = LogManager.getLogger("test");
	Util util=new Util();
	@Then("^validate the unsubscribed user text banner$")
	public void validate_unsub_user_text() throws Exception{
		if(Launcher.getdriver().findElement(UNSubsPriceText).isDisplayed()){
			Log.info("Element is Visible");
		}else{
			Log.info("Element is InVisible");
		}
	}
	 @Then("^Validate CSS property for unsubscribed user text$")
	    public void validate_CSS_Menu_icon() throws Exception { 
	        String CssValue=Launcher.getvaluefromExcelDataMap("UnsubUserText_CSS_Properties_Value");
	    	util.Validate_CSS_Properties_Value(Launcher.getdriver().findElement(UNSubsPriceText),CssValue);
	    }
	@Then("^Validate the Unsubscribed text$")
	public void validate_text() throws Exception{
		String expectedtext = Launcher.getdriver().findElement(UNSubsPriceText).getText();
		Log.info("Unsubscribed user text==>"+expectedtext);
		String actualtext = Launcher.getvaluefromExcelDataMap("UnsubUserText_Data");
		Assert.assertEquals(expectedtext, actualtext);
		Log.info("Unsubscribed user text assertion done");
	}
	@Then("^validate the unsubscribed user text is not present$")
	public void validate_unsub_user_text_notPresent() throws Exception{
		Assert.assertTrue("Element is not visible",util.verifyElementAbsent(UNSubsPriceText));
	    Log.info("UNSubsPrice Text is Not Visible");
	}
	@Then("^Validate the subscribed user text$")
	public void validate_sub_user_text_Present() throws Exception{
		String expectedtext = Launcher.getdriver().findElement(SubcribedPricetext).getText();
		Log.info("Subscribed user text==>"+expectedtext);
		String actualtext = Launcher.getvaluefromExcelDataMap("HomePage_SubscribedText");
		Assert.assertEquals(expectedtext, actualtext);
		Log.info("Compare the Subscribed user text");
	}
	
	@Then("^Validate the Service promotion text$")
	public void validate_Service_promotion_text() throws Exception{
		Thread.sleep(2000);
		String textbold = Launcher.getdriver().findElement(ServicepromotionInbold).getText();
		Log.info("Service-promotion user text bold==>"+textbold);
		String textItalic = Launcher.getdriver().findElement(ServicepromotionInItalic).getText();
		Log.info("Service-promotion text in italic==>"+textItalic);
		String expectedtext = Launcher.getvaluefromExcelDataMap("ServicePromotion_ServicePromotionText");
		Assert.assertEquals(textbold, expectedtext);
		Log.info("Compare service promotion text are equals");
	}
	
	
}