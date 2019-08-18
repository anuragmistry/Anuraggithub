package com.onmobile.stepDefinitions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.onmobile.utils.Util;
import com.onmobile.xpaths.PortalXpath;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class MenuImpl implements PortalXpath {
	
	static Logger Log = LogManager.getLogger("test");
	Util util=new Util();
	By temp;
    WebDriver webdriver = Launcher.getdriver();
   /***************************************************************************************
	 * @Function_Name :  validate_Menu_icon
	 * @Description   :  validate Menu icon in Home Page
	 ***************************************************************************************/
    @Then("^Validate CSS property for Menu icon$")
    public void validate_CSS_Menu_icon() throws Exception { 
        String CssValue=Launcher.getvaluefromExcelDataMap("MenuBar_CSS_Properties_Value");
       
    	util.Validate_CSS_Properties_Value(webdriver.findElement(MenuImg),CssValue);
    }

    @Then("^Validate Menu icon$")
    public void validate_Menu_icon() throws Exception { 
    	Assert.assertTrue("Menu icon is present",util.isElementPresent(MenuImg));
    	Log.info("Menu icon is present");
    	
    }
    /***************************************************************************************
	 * @Function_Name :  validate_menu_image_Dimension
	 * @Description   :  validate menu image Dimension in Home Page
	 ***************************************************************************************/
    @Then("^Validate menu image Dimension$")
    public void validate_menu_image_Dimension() throws Exception{
    	String dimension=Launcher.getvaluefromExcelDataMap("MenuBar_Dimension");
    	Log.info("Got menu image size from excel sheet");
    	util.check_dimensions(webdriver.findElement(MenuImg), dimension);
    }
    /***************************************************************************************
	 * @Function_Name :  validate_menu_Option
	 * @Description   :  Click on Menu icon and validate menu option and compare with excel test data in Home Page
	 ***************************************************************************************/
	@Then("^Click on Menu icon and validate menu option$")
	public void validate_menu_Option() throws Exception{
		
		webdriver.findElement(MenuImg).click();	
		Log.info("Click on Menu item");
		List<String> OptionText=new ArrayList<String>();
		OptionText=util.getOptionValue(MenuOption);
		Log.info("Fetch the Menu List from GUI are"+OptionText);
		String MenuList=Launcher.getvaluefromExcelDataMap("MenuBar_MenuList");
		List<String> list = new ArrayList<String>(Arrays.asList(MenuList.split("::")));
		Log.info("Fetch the Menu List from Excel are"+list);
		Assert.assertTrue("Comapare both menu List",util.ComparetoListvalue(OptionText, list));
		Thread.sleep(500);
		webdriver.findElement(MenuImg).click();	
	}
	 /***************************************************************************************
		 * @Function_Name :  navigate_Menu_Option
		 * @Description   :  Validate Page navigation menu option and compare with excel test data in Home Page
		 ***************************************************************************************/
    @Then("^Select the menu option and validate Page navigation$")
    public void navigate_Menu_Option() throws Exception { 
    	  String MenuList=Launcher.getvaluefromExcelDataMap("MenuBar_ClickOnMenu");
    	  String PageTitle=Launcher.getvaluefromExcelDataMap("MenuBar_PageTitle");
 		  List<String> list = new ArrayList<String>(Arrays.asList(MenuList.split("::")));
    
		 for(String menu:list) {
			 util.waitForElementToAppear(MenuImg);
			 webdriver.findElement(MenuImg).click();	
	 		 Log.info("Clicked on Menu Icon");
			 temp=util.modifyXpath(MenuOptionText,menu);
			 Thread.sleep(3000);
			 util.safeJavaScriptClick(temp);
			 Log.info("Clicked on Menu item");
			 util.waitForLoad(webdriver);
			 String currentURL=webdriver.getCurrentUrl();
			 Log.info("Fetch the Actual Current Page["+menu+"] url is-->"+currentURL);
			 Thread.sleep(3000);
			 String currentTitle = webdriver.getTitle();
			 Log.info("Current Category Page Title-->"+currentTitle);
			 String currentPageLinkText=webdriver.findElement(CurrentPageLink).getText();
			 Log.info("Current Page ["+menu+"] Link is-->"+currentPageLinkText);
			 
			 Assert.assertTrue("Compare Menu Text", menu.equalsIgnoreCase(currentPageLinkText));
			 Log.info("Compare Menu item with navigate page link text");
			 
			 String currentPageTitle=PageTitle+"-"+menu;
			 Log.info("Current Page title after concate menu text");
			 
			 Assert.assertTrue("Compare Page title with Menu Text", currentTitle.equalsIgnoreCase(currentPageTitle));
			 Log.info("Compare Page title with Menu Text");
			
			 webdriver.findElement(HomePageLink).isDisplayed();
			 
			 temp=util.modifyXpath(ControlerHome,currentPageLinkText);
			 webdriver.findElement(temp).isDisplayed();
			 Log.info("Page Controler [ Home/"+menu+"] Link is present");
			 webdriver.findElement(HomePageLink).click();
			 Log.info("Click on Home Page Link");
			 util.waitForLoad(webdriver);
			 String homeTitle = webdriver.getTitle();
			 Log.info("Home Page Title-->"+homeTitle);
			 String homePageTitle=Launcher.getvaluefromExcelDataMap("CommanPortalDataSet_HomePageTitle");
			 Assert.assertTrue("Compare Menu Text", homePageTitle.equalsIgnoreCase(homeTitle));
			 
			/* try 
			    {
				 
			    } 
			    catch (Exception e) 
			    {   
			    	Assert.fail();
			    }*/
			 
			 
		    }
				
    }
    /***************************************************************************************
   	 * @Function_Name :  Click_On_menu
   	 * @Description   :  Click on single Menu icon in Home Page
   	 ***************************************************************************************/
	@When("^Click on menu \"([^\"]*)\" option$")
	public void Click_On_menu(String menu) throws Exception{
		//String menu=Launcher.getvaluefromExcelDataMap("GalleryPage_ClickOnMenu");
		webdriver.findElement(MenuImg).click();	
		Log.info("Click on Menu icon");
		temp=util.modifyXpath(MenuOptionText,menu);
		Thread.sleep(2000);
		webdriver.findElement(temp).click();
		Log.info("Clicked on Menu ["+menu+"] option");
		//Store the current selected menu inside the util use for fetch the current selected menu in any page
		util.waitForLoad(webdriver);
		Util.setCurrentMenuSelection(menu);
	}
	@Then("^Validate Menu icon is not present$")
	public boolean validate_portal_logo_Notpresent() throws Exception { 
		boolean status=util.verifyElementAbsent(MenuImg);
		Assert.assertTrue("Element is not visible",status);
		Log.info("Menu icon is not displayed");
		return status;

	}
	 @Then("^Validate ic-Menu Image$")
	    public void validate_Menu_img() throws Exception { 
	    	Assert.assertTrue("Menu icon is present",util.isElementPresent(MenuIcon));
	    	Log.info("Menu icon is present");
	    	
	    }
	 @Then("^Click on Ic-Menu icon$")
	    public void Click_on_ICMenu_icon() throws Exception { 
		   
		   util.safeJavaScriptClick(MenuIcon);
	       Log.info("Click on menu icon");
	    	
	    }
	 @Then("^Validate Menu name and Image$")
		public void validate_Icmenu_Option_Img() throws Exception{
            
			List<String> OptionText=new ArrayList<String>();
			OptionText=util.getOptionValue(MenuList);
			Log.info("Fetch the Menu List from GUI are"+OptionText);
			String MenuList=Launcher.getvaluefromExcelDataMap("MenuBar_MenuList");
			List<String> list = new ArrayList<String>(Arrays.asList(MenuList.split("::")));
			Log.info("Fetch the Menu List from Excel are"+list);
			Assert.assertTrue("Comapare both menu List",util.ComparetoListvalue(OptionText, list));
			
			for(String option:OptionText){
				temp=util.modifyXpath(Validate_Menu_Img, option);
				util.isElementPresent(temp);
				Log.info("Menu  img is present with Menu-->"+option);
			}
			 util.safeJavaScriptClick(CloseIcon);
		} 
	 @Then("^Validate Menu Header Title$")
	    public void validate_Menu_header() throws Exception { 
	    	Assert.assertTrue("Menu Header Title is present",util.isElementPresent(LogoTitle));
	    	Log.info("Menu Header Title is present");
	    	
	    }
	 @Then("^Validate Menu Header text$")
	    public void validate_Menu_HeaderText() throws Exception { 
		   util.ScrollDown(MenuHeaderH1);
	    	String h1=webdriver.findElement(MenuHeaderH1).getText();
	    	Log.info("Menu Header text is "+h1);
	    	
	    }
	 
		@When("^Click on ic menu \"([^\"]*)\" option$")
		public void Click_On_ICmenu(String menu) throws Exception{
			temp=util.modifyXpath(SelectMenu,menu);
			util.ScrollDown(temp);
			util.safeJavaScriptClick(temp);
			Log.info("Click on Categoies option--> "+menu);
			String currentURL=webdriver.getCurrentUrl();
			util.waitForLoad(webdriver);
			Log.info("Fetch the Current Page url is-->"+currentURL);
			Util.setCurrentMenuSelection(menu);
		}
		@Then("^Click on ic-menu \"([^\"]*)\" option$")
		public void Click_On_icmenu(String menu) throws Exception{
			temp=util.modifyXpath(SelectMenu,menu);
			Thread.sleep(2000);
			webdriver.findElement(temp).click();
			Log.info("Clicked on Menu ["+menu+"] option");
			util.waitForLoad(webdriver);
			Util.setCurrentMenuSelection(menu);
			String currentURL = webdriver.getCurrentUrl();
			Log.info("Fetch teh Current Page url is-->" + currentURL);
			String Title = webdriver.getTitle();
		    Log.info("Current Page Title-->"+Title);
		}		
}
