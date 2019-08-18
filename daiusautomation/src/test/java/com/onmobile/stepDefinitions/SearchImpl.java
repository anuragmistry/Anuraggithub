package com.onmobile.stepDefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.onmobile.utils.Util;
import com.onmobile.xpaths.PortalXpath;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;


public class SearchImpl implements PortalXpath{


	static Logger Log = LogManager.getLogger("test");
	Util util=new Util();
	PageConfirmation pageconfirmation=new PageConfirmation();
	WebDriver webdriver=Launcher.getdriver();
	/***************************************************************************************
	 * @Function_Name :  validate_Search_icon
	 * @Description   :  Validate search icon
	 ***************************************************************************************/
	@Then("^Validate search icon$")
	public void validate_Search_icon() throws Exception {
		util.waitForElementToAppear(SearchImg);
		Assert.assertTrue("Verify the Search Icon", util.isElementPresent(SearchImg));
		Log.info("Search icon is present");
	}
	@Then("^Validate search icon is not present$")
	public void validate_portal_logo_Notpresent() throws Exception { 
		Assert.assertTrue("Element is not visible",util.verifyElementAbsent(SearchImg));
	    Log.info("Search image is not displayed");
	}
	 @Then("^Validate CSS property for Search icon$")
	    public void validate_CSS_Menu_icon() throws Exception { 
	        String CssValue=Launcher.getvaluefromExcelDataMap("SearchBar_CSS_Properties_Value");
	    	util.Validate_CSS_Properties_Value(webdriver.findElement(SearchImg),CssValue);
	    }
	/***************************************************************************************
	 * @Function_Name :  validate_Search_image_Dimension
	 * @Description   :  Validate search image Dimension and compare with excel test data in favorite Page
	 ***************************************************************************************/
	@And("^Validate search image Dimension$")
	public void validate_Search_image_Dimension() throws Throwable { 
		String dimension=Launcher.getvaluefromExcelDataMap("SearchBar_Dimension");
        Assert.assertTrue("Validate Image Dimension", util.check_dimensions(webdriver.findElement(SearchImg), dimension));
		Log.info("Validate search image dimension");
	}
	/***************************************************************************************
	 * @Function_Name :  validate_Search_widget
	 * @Description   :  Click on Search icon and validate search box widget(Input box,Search button)
	 ***************************************************************************************/
	@And("^Click on Search icon and validate search box widget$")
	public void validate_Search_widget() throws InterruptedException { 
		webdriver.findElement(SearchImg).click();
		Log.info("Click on Search Icon");
		webdriver.findElement(SearchInputBox).isDisplayed();
		Log.info("Validate Search input Box");
		String text=webdriver.findElement(SearchInputBox).getAttribute("placeholder");
		Log.info("Validate PlaceHolder value-->"+text);
		webdriver.findElement(SearchButton);
		Log.info("Validate Search Button");
		webdriver.findElement(SearchImg).click();
	}
	/***************************************************************************************
	 * @Function_Name :  validate_search_operation
	 * @Description   :  Validate Search operation(Fetch the test data form excel and Search the content)
	 ***************************************************************************************/

	@Then("^Validate Search operation with \"([^\"]*)\"$")
	public void validate_search_operation(String searchCondition) throws Exception {
		String searchText=Launcher.getvaluefromExcelDataMap("SearchBar_SuccessSearchText");
		String noresultsearchText=Launcher.getvaluefromExcelDataMap("SearchBar_NoresultsSearchText");
        //Fetch the data from excel sheet and store in String array based on search condition.
		String[] SplitsText = null;
		if(searchCondition.equalsIgnoreCase("Success Content")) {
			SplitsText=searchText.split("::");
		}
		if(searchCondition.equalsIgnoreCase("Noresults Content")) {
			SplitsText=noresultsearchText.split("::");
		}
     //Now iterate one by one Test data and perform below the operation.
		for(String text:SplitsText) {
			Thread.sleep(1000);
			util.safeJavaScriptClick(SearchImg);
			Log.info("Click on Search Icon");
			util.waitForElementToAppear(SearchInputBox);
			webdriver.findElement(SearchInputBox).sendKeys(text);
			Log.info("Enter the search string in Input Box");
			webdriver.findElement(SearchButton).click();
			Log.info("Click on Search Button");
			util.waitForLoad(webdriver);
			Thread.sleep(2000);
			String currentURL=webdriver.getCurrentUrl();
			Log.info("Fetch the Search Current Page url is-->"+currentURL);
			 
			//Below code for validate the text based on search content text.
			
			if(searchCondition.equalsIgnoreCase("Noresults Content")) {
				webdriver.findElement(NoResults).isDisplayed();
				String noText=webdriver.findElement(NoResults).getText();
				Log.info("No results text is-->"+noText);
				Log.info("No results Found after search");
			}
			if(searchCondition.equalsIgnoreCase("Success Content")) {
				webdriver.findElement(Searchtitle).isDisplayed();
				Log.info("Results Found after search");
				String foundtext=webdriver.findElement(Searchtitle).getText();
				Log.info("Results text is present-->"+foundtext);
			}
			util.safeJavaScriptClick(PortalLogoLink);
			Log.info("Click on PortalLogoLink and landing in Home Page");
			util.waitForLoad(webdriver);
		}

	}
	@Then("^Validate search Category Title$")
	public void validate_Search_title() throws Exception {
		util.waitForElementToAppear(Searchtitle);
		webdriver.findElement(Searchtitle).isDisplayed();
		Log.info("Results Found after search");
		String foundtext=webdriver.findElement(Searchtitle).getText();
		Log.info("Results text is present-->"+foundtext);
	}
	
	//Ugames
	@Then("^Validate ic search icon$")
	public void validate_icSearch_icon() throws Exception {
		util.waitForElementToAppear(SearchIcon);
		Assert.assertTrue("Verify the Search Icon", util.isElementPresent(SearchIcon));
		Log.info("Search icon is present");
	}
	@And("^Validate search box inside text$")
	public void validate_Search_Box() throws InterruptedException { 
		webdriver.findElement(SearchBoxInsideText).isDisplayed();
		Log.info("Validate Search input Box text");
	}
	@Then("^Click on Search icon$")
	public void Click_Search_icon() throws Exception {
		util.waitForElementToAppear(SearchIcon);
		Assert.assertTrue("Verify the Search Icon", util.isElementPresent(SearchIcon));
		Log.info("Search icon is present");
		util.safeJavaScriptClick(SearchIcon);
		Log.info("Click on Ic-Search icon");
		String currentURL=webdriver.getCurrentUrl();
		Log.info("Fetch the Search Current Page url is-->"+currentURL);
	}
	/***************************************************************************************
	 * @Function_Name :  validate_icsearch_operation
	 * @Description   :  Validate Search operation(Pass the search String from feature file with Search Condition(Success or NoTfound content))
	 ***************************************************************************************/
	@Then("^Validate Search \"([^\"]*)\" text with \"([^\"]*)\"$")
	public void validate_icsearch_operation(String Text,String searchCondition) throws Exception {
		String SearchText=null;
		if(searchCondition.equalsIgnoreCase("Success Content")) {
			SearchText=Text;
		}
		if(searchCondition.equalsIgnoreCase("Noresults Content")) {
			SearchText=Text;
		}
		Log.info("Search Text==>"+SearchText);
	//	util.waitForElementToAppear(ICSearchInputBox);
		Thread.sleep(1000);
		util.sendKeys(ICSearchInputBox,SearchText);
		Log.info("Enter the search string in Input Box");
		webdriver.findElement(IcSearchButton).click();
		Log.info("Click on Search Button");
       
		//Make sure in Serch Page
		Assert.assertTrue(pageconfirmation.isSearchPage());

		//Below code for validate the text based on search content text.

		if(searchCondition.equalsIgnoreCase("Success Content")) {
			webdriver.findElement(SearchCaption).isDisplayed();
			Log.info("Results Found after search");
			String foundtext=webdriver.findElement(SearchCaption).getText();
			Log.info("Results text is present-->"+foundtext);
			Assert.assertTrue("Compare the both Search Text", foundtext.contains(SearchText));
			By temp=util.modifyXpath(SearchImage,foundtext);
			util.isElementPresent(temp);
			Log.info("Search image is present-->");
		}
		if(searchCondition.equalsIgnoreCase("Noresults Content")) {
			webdriver.findElement(SearchFailedImg).isDisplayed();
			Log.info("No results Found img is present");
			String FailedText=webdriver.findElement(SearchFailedText).getText();
			Log.info("No results text is-->"+FailedText);
			String tryanotherText=webdriver.findElement(TryAnotherSearch).getText();
			Log.info("Try another text is-->"+ tryanotherText);

		}
		util.safeJavaScriptClick(SearchBackIcon);
		Log.info("Click on back icon and landing in Home Page");
		util.waitForLoad(webdriver);
	}
	
	
}

