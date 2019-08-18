package com.onmobile.stepDefinitions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class ModuleCarouselnopaddingImpl implements PortalXpath {
	static Logger Log = LogManager.getLogger("test");
	Util util = new Util();
	By temp;
	WebDriver webdriver = Launcher.getdriver();

	/***************************************************************************************
	 * @Function_Name : validate_Map_Image
	 * @Description : Validate Continent Map Image in Home page
	 ***************************************************************************************/
	@Then("^Validate Continent Map Image$")
	public void validate_Map_Image() throws Exception {
		util.ScrollDown(MapImage);
		List<WebElement> MapImg = webdriver.findElements(MapImage);
		int MapImgNum = MapImg.size();
		Log.info("Num of Continent Map Image Present in Home Page-->" + MapImgNum);
		for (WebElement element : MapImg) {
			Assert.assertTrue("Verify continent Map Image", element.isDisplayed());
			Log.info("Verify Continent Map Image Present in Home Page");
		}
	}
	@Then("^Validate CSS property for carousel no padding images$")
	public void validate_CSS_Menu_icon() throws Exception { 
		String CssValue=Launcher.getvaluefromExcelDataMap("HomePage_CSS_Properties_Value");
		List<WebElement> body=webdriver.findElements(ModuleBody);
		for(WebElement element: body){
			util.ScrollDown(element);
			util.Validate_CSS_Properties_Value(element,CssValue);
		}
	}

	/***************************************************************************************
	 * @Function_Name : validate_SubscribedImage_Text
	 * @Description : Validate Continent Map image Dimension and compare with excel
	 *              test data in Home Page
	 ***************************************************************************************/
	@And("^Validate Continent Map image Dimension$")
	public void validate_Map_image_Dimension() throws Throwable {
		String dimension = Launcher.getvaluefromExcelDataMap("ContinentMapImage_Dimension");
		List<WebElement> MapImg = webdriver.findElements(MapImage);
		for (WebElement element : MapImg) {
			Assert.assertTrue("Validate Image Dimension", util.check_dimensions(element, dimension));
			Log.info("Validate search image dimension");
		}
	}

	public void validate_ModuleCarousel_NoPaddingBanner_ImgDimension(String Data) throws Exception {
		// Fetch the current selected Menu name
		String menu = Util.getCurrentMenuSelection();
		Log.info("Current seleted menu is=> " + menu);
		String ExpectedModuleTitle = Data;
		Map<String, List<String>> data = new HashMap<String, List<String>>();
		// Fetch the test data from excel sheet and Store in Map
		data = Util.SplitStringAndStoreInMap(ExpectedModuleTitle);
		Log.info("After spilt with delimeter=> " + data);
		// Pass the Key value and get the Value
		List<String> Menu_Paddingdata = Util.GetValuefromMap(data, menu);

		// Fetch the Padding count from Test data
		int ExpectedPaddingCount = Integer.parseInt(Menu_Paddingdata.get(0));
		Log.info("Expected Module Padding Count is==>" + ExpectedPaddingCount);
		util.ScrollDown(Modulecarouselnopadding);
		List<WebElement> modulePadding = webdriver.findElements(Modulecarouselnopadding);
		int ActualPaddingnum = modulePadding.size();
		Log.info("Actual Module Padding Count is==>" + ActualPaddingnum);
		Assert.assertTrue("Compare padding num", ActualPaddingnum == ExpectedPaddingCount);
		Log.info("Compare Num of [" + ActualPaddingnum + "] actual Module Padding Count with expected Padding Count["
				+ ExpectedPaddingCount + "]");
		List<String> carouselCountList = Arrays.asList(Menu_Paddingdata.get(1).split(":"));
		// Outer loop used for validate carousel padding
		for (int i = 0; i < ActualPaddingnum; i++) {

			temp = util.modifyXpath(ModulecarouselnopaddingImage, String.valueOf(i + 1));
			List<WebElement> modulecarouselImg = webdriver.findElements(temp);
			int Actualnum = modulecarouselImg.size();
			int Expectednum = Integer.parseInt(carouselCountList.get(i).trim());

			Log.info("Num of [" + Actualnum + "] carousel is present inside at [" + (i + 1) + "] Module padding");
			Assert.assertTrue("Comapare the num of carousel", Actualnum == Expectednum);
			Log.info("Compare Num of [" + Actualnum + "] actual Module carousel with expected carousel num[ "
					+ Expectednum + "]");
			// Inner loop is use for inside padding image valiadtion
			for (int j = 0; j < Actualnum; j++) {
				util.ScrollDown(modulecarouselImg.get(j));
				modulecarouselImg.get(j).isDisplayed();
				Log.info("Verify [" + (j + 1) + "] carousel image is present");
				// Assert.assertTrue("Validate Image
				// Dimension",util.check_dimensions(modulecarouselImg.get(i),dimension));
				// Log.info("Compare ["+(j+1)+"] carousel image dimension with test data");
			}
		}

	}

	@Then("^Validate HomePage module carousel no padding images and dimension$")
	public void validate_Home_module_carousel_dimesion() throws Exception {
		String Data = Launcher.getvaluefromExcelDataMap("HomePage_Menu_PaddingCount_EachSectionCarouselCount");
		validate_ModuleCarousel_NoPaddingBanner_ImgDimension(Data);

	}
}
