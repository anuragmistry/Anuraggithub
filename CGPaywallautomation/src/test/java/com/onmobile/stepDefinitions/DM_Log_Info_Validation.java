package com.onmobile.stepDefinitions;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.onmobile.dataProvider.PropertyReader;
import com.onmobile.utils.Util;
import com.onmobile.xpaths.PortalXpath;

import cucumber.api.java.en.Then;

public class DM_Log_Info_Validation implements PortalXpath{
	static Logger Log = LogManager.getLogger("test");
    static WebDriver webdriver = Launcher.getdriver();
	Util util=new Util();
	DB_Connection dbconnection= new DB_Connection();
	By temp;
	@Then("^Validate is Tourist Banner present$")
	public void validate_Tourist_Banner() throws Exception{
		util.isElementPresent(Banner_Img);
		Log.info("Tourist Banner is present");
	}
	@Then("^Validate is Subscribe Text$")
	public void validate_Subscribe_text() throws Exception{
		util.GotoPageEnd();
		util.isElementPresent(Subscription_Title);
		String text=webdriver.findElement(Subscription_Title).getText();
		Log.info("Subscribe Title is-->"+text);
		String text1=webdriver.findElement(Subscription_Text).getText();
		Log.info("Subscribe Text  is-->"+text1);
	}
	@Then("^Click on Subscribe Active Button$")
	public void Click_on_Subscribe_Active_btn() throws Exception {
		util.isElementPresent(Subscribe_Active_Btn);
		String text=webdriver.findElement(Subscribe_Active_Btn).getText();
		Log.info("Button text is-->"+text);
		util.safeJavaScriptClick(Subscribe_Active_Btn);
		Log.info("Click on Subscribe Active Button");
		util.GetCurrenturlAndTitle();
	}	
	@Then("^Validate is Subscribe Tick image and Text$")
	public void validate_Subscribe_Tick_Img_text() throws Exception{
		util.isElementPresent(Subscribed_IMG);
		Log.info("Subscribed Tick IMG is present");
		String text1=webdriver.findElement(Subscribed_Text).getText();
		Log.info("User Subscribed Text  is-->"+text1);
	}
	
	@Then("^Click on Continue Button$")
	public void Click_on_Continue_btn() throws Exception {
		util.GotoPageEnd();
		util.isElementPresent(Continue_Btn);
		String text=webdriver.findElement(Continue_Btn).getText();
		Log.info("Continue Button text is-->"+text);
		util.safeJavaScriptClick(Continue_Btn);
		Log.info("Click on Continue Button");
		util.GetCurrenturlAndTitle();
	}	
	
	@Then("^Validate User \"([^\"]*)\" DM Log details with Action \"([^\"]*)\" for DM Subscription flow$")
	public void Validate_DM_Subscription_Log_Infor(String Number,String Action) throws Exception{
		
		if(Action.equalsIgnoreCase("Landing_Subscription_Page") || Action.equalsIgnoreCase("Landing_Confirmation_Page")) {
			String query =PropertyReader.readItem("Landing_Subscription_Page");
			String query_DM=query.replaceFirst("Number", Number);
			Log.info("Query for get Top Entry from DM Log Table==>"+query_DM);
					
			Map<Integer, Map<String, Object>> DM_log=DB_Connection.GetDMLogDataRowBased(query_DM,"DIAUS_UK_DB_URL");
			Log.info("DM Log==>"+DM_log);
			Map<String,Object> DM_log_landing_subs_page=DM_log.get(1);
			Log.info("Map value==>"+DM_log_landing_subs_page);
			
			Object ID= util.GetValue(DM_log_landing_subs_page,"ID");
			Object userID=util.GetValue(DM_log_landing_subs_page,"UserID");
			Object storeID= util.GetValue(DM_log_landing_subs_page,"StoreID");
			Object OperatorName= util.GetValue(DM_log_landing_subs_page,"Operator");
			
			int ActualactivityType= (int) util.GetValue(DM_log_landing_subs_page,"ActivityType");
			int ExpectedActivityType=0;
			if(Action.equalsIgnoreCase("Landing_Subscription_Page")) {
				ExpectedActivityType=NameToActivityType("SubscribePageLoad");
				Assert.assertEquals("Compare Activity Type", ActualactivityType, ExpectedActivityType);
				Log.info("Validate Actual ActivityType Id==>"+ActualactivityType+"with our Expected ActivityType==>"+ExpectedActivityType);
			}
			if(Action.equalsIgnoreCase("Landing_Confirmation_Page")) { 
				ExpectedActivityType=NameToActivityType("DMVendorCallbackAPI");
				
				Assert.assertEquals("Compare Activity Type", ActualactivityType, ExpectedActivityType);
				Log.info("Validate Actual ActivityType Id==>"+ActualactivityType+"with our Expected ActivityType==>"+ExpectedActivityType);
			}
			Log.info("DM Log Information : UserID==>["+userID+"] and ID==>["+ID+"] and StoreID==>["+storeID+"] and ActivityType==>["+ActualactivityType+"] and operatorName==>["+OperatorName+"]");
			
		
			Object campaignSource= util.GetValue(DM_log_landing_subs_page,"CampaignSource");
			Object campaignID= util.GetValue(DM_log_landing_subs_page,"CampaignID");
			Object campaignSessionID= util.GetValue(DM_log_landing_subs_page,"CampaignSessionID");
			Object campaignMedium= util.GetValue(DM_log_landing_subs_page,"CampaignMedium");
			
			if(!(campaignSource!=null) && !(campaignID!=null) &&!(campaignSessionID!=null) &&!(campaignMedium!=null)) {
				Log.info("DM Log Information : CampaignSource==>["+campaignSource+"] and CampaignID==>["+campaignID+"] and CampaignSessionID==>["+campaignSessionID+"] and CampaignMedium==>["+campaignMedium+"]");
			}else {
				Log.info("DM Log Information : CampaignSource==>["+campaignSource+"] and CampaignID==>["+campaignID+"] and CampaignSessionID==>["+campaignSessionID+"] and CampaignMedium==>["+campaignMedium+"]");
			//	Assert.fail("NULL");
				
			}
		}
	}
	public int NameToActivityType(String Action){

		switch(Action){
		case "SubscribePageLoad" : return 48;
		case "UserClickedSubscribeConfirm" : return 7;
		case "Confirmationpage" : return 13;
		case "SuccessfulSubscription" : return 25;
		case "DMVendorCallbackAPI" : return 14;
		default: System.err.println("This Action is not Valid");
		return 0;
		}

	}
}
