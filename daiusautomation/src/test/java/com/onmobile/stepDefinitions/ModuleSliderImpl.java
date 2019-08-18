package com.onmobile.stepDefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.onmobile.utils.Util;
import com.onmobile.xpaths.PortalXpath;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ModuleSliderImpl implements PortalXpath{
	
	static Logger Log = LogManager.getLogger("test");
	Util util=new Util();
	
    WebDriver webdriver=Launcher.getdriver();
	By temp;
	By temptitle;

	/***************************************************************************************
	 * @Function_Name :  validate_carousel
	 * @Description   :  validate carousel item and fetch the title inside silder module in Category Page
	 ***************************************************************************************/	
	@When("^Validate module carousel slider and carousel item$")
	public void validate_carousel() throws Exception{
		util.waitForLoad(webdriver);
		String menu=Util.getCurrentMenuSelection();
		String ExpectedModuleTitle=Launcher.getvaluefromExcelDataMap("CategoryPage_SliderModuleTitles");
		Map<String, List<String>> data = new HashMap<String, List<String>>();
		//Fetch the data from excel sheet and Store in Map
		data= Util.SplitStringAndStoreInMap(ExpectedModuleTitle);
		//Pass the Key value and get the Value
		List<String> Titlelist=Util.GetValuefromMap(data,menu);
		Titlelist.remove("CATEGORÍAS");
		
		for(String title:Titlelist) {
			List<String> Actualtitle = new ArrayList<>();
			temp=util.modifyXpath(ThumbnailImage,title);
			List<WebElement> modulebanner = webdriver.findElements(temp);
			int num = modulebanner.size();
			temptitle=util.modifyXpath(ThumbnailImgTitle,title);
			List<WebElement> modulebannerTitle = webdriver.findElements(temptitle);
			
			for(int i=0;i<num;i++) {
				/*if(i==2) {
					try {
					    Thread.sleep(500);
						Actions move = new Actions(webdriver);
						move.moveToElement(modulebanner.get(i)).clickAndHold();
						move.moveByOffset(10,0);
						move.release();
						move.perform();
						Log.info("Image Swiped");
					}catch (Exception e) {
						Log.info("Image Not Swiped");
					}
			}*/
				util.ScrollDown(modulebanner.get(i));
				modulebanner.get(i).isDisplayed();
				Log.info(title+"-->under Image is Present");
				String text=modulebannerTitle.get(i).getText();
				Actualtitle.add(text);

			}
			Log.info("Module title is ["+title+"] and under present image title are"+Actualtitle);
		}
		
	}
   
}
