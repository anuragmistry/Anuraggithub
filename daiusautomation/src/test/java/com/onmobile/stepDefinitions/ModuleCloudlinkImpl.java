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

import cucumber.api.java.en.Then;

public class ModuleCloudlinkImpl implements PortalXpath{
	static Logger Log = LogManager.getLogger("test");
	Util util=new Util();
	
	WebDriver webdriver=Launcher.getdriver();
	
	/***************************************************************************************
	 * @Function_Name :  validate_Module_Link
	 * @Description   :  Validate Module Link Text in Home Page
	 ***************************************************************************************/
	@Then("^Validate Module Link Text$")
	public void validate_Module_Link() throws Exception {
		util.ScrollDown(wordcloudlink);
		List<WebElement> wordlink=webdriver.findElements(wordcloudlink);
		int wordlinkNum=wordlink.size();
		Log.info("Num of word cloud link Present in Home Page-->"+wordlinkNum);
		
		for(WebElement element: wordlink){
			Assert.assertTrue("Verify link Text",element.isDisplayed());
			String text=element.getText();
			Log.info("Verify Module link Text ["+text+"] Present!");
		}
	}	
	@Then("^Validate CSS property for Module links$")
	public void validate_CSS_Menu_icon() throws Exception { 
		String CssValue=Launcher.getvaluefromExcelDataMap("ModuleLink_CSS_Properties_Value");
		
		List<WebElement> link = webdriver.findElements(wordcloudlink);
		for(WebElement element: link){
			util.ScrollDown(element);
			util.Validate_CSS_Properties_Value(element,CssValue);
		}
	}
	/***************************************************************************************
	 * @Function_Name :  Compare_Module_Link
	 * @Description   :  Compare Module LinkText with excel test data
	 ***************************************************************************************/
	@Then("^Compare Module LinkText with excel test data$")
	public void Compare_Module_Link() throws Exception {
		List<String> LinkText= util.getOptionValue(wordcloudlink);
		Log.info("The word cloud link Text Present in Home Page-->"+LinkText);
		String MenuList=Launcher.getvaluefromExcelDataMap("ModuleLink_LinkText");
		List<String> list = new ArrayList<String>(Arrays.asList(MenuList.trim().split("::")));
		Log.info("Fetch the module link from Excel are"+list);
		Assert.assertTrue("Comapare both link Text", util.ComparetoListvalue(LinkText, list));
	}
}
