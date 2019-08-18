package com.onmobile.stepDefinitions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.onmobile.utils.JSCHHandler;
import com.onmobile.utils.Util;
import com.onmobile.xpaths.PortalXpath;

import cucumber.api.java.en.Then;

public class DM_LogValidation implements PortalXpath{

	
	static Logger Log = LogManager.getLogger("test");
    static WebDriver webdriver = Launcher.getdriver();
	Util util=new Util();
	DB_Connection dbconnection= new DB_Connection();
	By temp;
	
	@Then("^Validate is Portal Banner present$")
	public void validate_POrtal_Banner() throws Exception{
		util.isElementPresent(Banner_Img);
		Log.info("Tourist Banner is present");
	}
	@Then("^Validate is Ugames SlideShow Banner present$")
	public void validate_UgamesSlideShow_Banner() throws Exception{
		util.isElementPresent(SlideShowBanner);
		Log.info("Portal Banner is present");
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
	@Then("^Get all Cookies value$")
	public void Get_all_Cookies() throws Exception{

		Set<Cookie> Cookies= Util.getCookieValue();
		Log.info("Browser all Cookies value-->"+Cookies);
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
	@Then("Validate \"([^\"]*)\" User \"([^\"]*)\" DM Log details with Action \"([^\"]*)\" for DM Subscription flow")
	public void validate_DM_Log_for_DM_User_Subscription(String DM_DB,String Number,String Action) throws Exception{
		
		util.GetCurrenturlAndTitle();
		
		if(DM_DB.equalsIgnoreCase("DIAUS_INDIA_DB")){
			validate_DM_Log(Number,Action,"DIAUS_DB_URL");
		}
		if(DM_DB.equalsIgnoreCase("DIAUS_UK_DB")){
			validate_DM_Log(Number,Action,"DIAUS_UK_DB_URL");
		}
	}
	
	
	@Then("^Validate User \"([^\"]*)\" DM Log information Action \"([^\"]*)\" from DIAUS DB$")
	public void validate_DM_Log(String Number,String Action,String DM_DB) throws Exception{

		String dbName=null;
		String query_DM=null;
		String query_count=null;
		String Fianl_count=null;

		if(Action.equalsIgnoreCase("Landing_Subscription_Page")) {

			query_count=Launcher.CFR.getProperty("Entry_Count");

			String query =Launcher.CFR.getProperty("Landing_Subscription_Page");
			if(DM_DB.equalsIgnoreCase("DIAUS_DB_URL")) {
				dbName =Launcher.CFR.getProperty("DIAUS_DB_Name");
				query_DM=query.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number);
				Log.info("Query for get Top Entry from DM Log Table==>"+query_DM);
				Fianl_count=query_count.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number);
				Log.info("Query for get Count from DM Log Table==>"+Fianl_count);
			}
			if(DM_DB.equalsIgnoreCase("DIAUS_UK_DB_URL")) {
				dbName =Launcher.CFR.getProperty("DIAUS_UK_DB_Name");
				query_DM=query.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number);
				Log.info("Query for get Top Entry from DM Log Table==>"+query_DM);
				Fianl_count=query_count.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number);
				Log.info("Query for get Count from DM Log Table==>"+Fianl_count);
			}

			boolean entry_Status=isEntryCreated(Fianl_count,DM_DB,1);
			if(entry_Status==true) {
				Map<Integer, Map<String, Object>> DM_log=DB_Connection.GetDMLogDataRowBased(query_DM,DM_DB);
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
					Log.info("Validate Actual ActivityType Id==>["+ActualactivityType+"] with our Expected ActivityType==>["+ExpectedActivityType+"]");
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
					

				}
			}else {
				System.err.println("<====Expected Entry is NOT Created===>"+Action);
			}
		}
		
		if(Action.equalsIgnoreCase("Click_Subscription_Successfully")) {
			
			dbName =Launcher.CFR.getProperty("DIAUS_UK_DB_Name");
			query_count=Launcher.CFR.getProperty("Entry_Count");
			Fianl_count=query_count.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number);
			Log.info("Query for get Count from DM Log Table==>"+Fianl_count);
			
			String query =Launcher.CFR.getProperty("Click_Subscription_Successfully");
			query_DM=query.replaceFirst("DataBaseName", dbName).replaceFirst("Number",Number);
			Log.info("Query for get Top Entry from DM Log Table==>"+query_DM);
			
			

			boolean entry_Status=isEntryCreated(Fianl_count,DM_DB,4);
			if(entry_Status==true) {
				Map<Integer, Map<String, Object>> DM_log=DB_Connection.GetDMLogDataRowBased(query_DM,DM_DB);
				Log.info("DM Log==>"+DM_log);

				//	String[] action= {"UserClickedSubscribeConfirm","Confirmationpage","SuccessfulSubscription"};


				String[] action;
				if(DM_DB.equalsIgnoreCase("DIAUS_DB_URL")){
					action =new String[] {"UserClickedSubscribeConfirm","Confirmationpage","SuccessfulSubscription"};
				}
				else{
					action =new String[] {"UserClickedSubscribeConfirm","Confirmationpage","SuccessfulSubscription"};
				}

				for(String actionType : action) {

					int ExpectedActivityType=0;
					int ActualActivityType=0;

					Object ID=null;
					Object userID=null;
					Object storeID=null;
					Object OperatorName=null;


					switch(actionType){
					case "UserClickedSubscribeConfirm" :
						Map<String,Object> one=DM_log.get(3);
						Log.info("Map value==>"+one);

						ID= util.GetValue(one,"ID");
						userID=util.GetValue(one,"UserID");
						storeID= util.GetValue(one,"StoreID");
						OperatorName= util.GetValue(one,"Operator");

						ExpectedActivityType=NameToActivityType("UserClickedSubscribeConfirm");
						Log.info("Expected ActivityType Id==>"+ExpectedActivityType);
						ActualActivityType=(int) one.get("ActivityType");
						Log.info("Actual [UserClickedSubscribeConfirm] ActivityType Id==>"+ActualActivityType);
						Log.info("DM Log Information : UserID==>["+userID+"] and ID==>["+ID+"] and StoreID==>["+storeID+"] and ActivityType==>["+ActualActivityType+"] and operatorName==>["+OperatorName+"]");

						Assert.assertEquals("Compare Activity Type", ActualActivityType, ExpectedActivityType);
						Log.info("Validate Actual ActivityType Id==>"+ActualActivityType+"with our Expected ActivityType==>"+ExpectedActivityType);
						break;
					case "Confirmationpage" : 
						Map<String,Object> two=DM_log.get(2);
						Log.info("Map value==>"+two);

						ID= util.GetValue(two,"ID");
						userID=util.GetValue(two,"UserID");
						storeID= util.GetValue(two,"StoreID");
						OperatorName= util.GetValue(two,"Operator");

						ExpectedActivityType=NameToActivityType("Confirmationpage");
						Log.info("Expected ActivityType Id==>"+ExpectedActivityType);
						ActualActivityType=(int) two.get("ActivityType");
						Log.info("Actual [Confirmationpage] ActivityType Id==>"+ActualActivityType);
						Log.info("DM Log Information : UserID==>["+userID+"] and ID==>["+ID+"] and StoreID==>["+storeID+"] and ActivityType==>["+ActualActivityType+"] and operatorName==>["+OperatorName+"]");
						Assert.assertEquals("Compare Activity Type", ActualActivityType, ExpectedActivityType);
						Log.info("Validate Actual ActivityType Id==>"+ActualActivityType+"with our Expected ActivityType==>"+ExpectedActivityType);
						break;
					case "SuccessfulSubscription" :
						Map<String,Object> three=DM_log.get(1);
						Log.info("Map value==>"+three);

						ID= util.GetValue(three,"ID");
						userID=util.GetValue(three,"UserID");
						storeID= util.GetValue(three,"StoreID");
						OperatorName= util.GetValue(three,"Operator");

						ExpectedActivityType=NameToActivityType("SuccessfulSubscription");
						Log.info("Expected ActivityType Id==>"+ExpectedActivityType);
						ActualActivityType=(int) three.get("ActivityType");
						Log.info("Actual [SuccessfulSubscription] ActivityType Id==>"+ActualActivityType);
						Log.info("DM Log Information : UserID==>["+userID+"] and ID==>["+ID+"] and StoreID==>["+storeID+"] and ActivityType==>["+ActualActivityType+"] and operatorName==>["+OperatorName+"]");

						Assert.assertEquals("Compare Activity Type", ActualActivityType, ExpectedActivityType);
						Log.info("Validate Actual ActivityType Id==>"+ActualActivityType+"with our Expected ActivityType==>"+ExpectedActivityType);
						break;

					default: System.err.println("This Action is not Valid");
					break;
					}
				}
			}else {
				System.err.println("<====Expected Entry is NOT Created or More Entry is Created===>"+Action);
			}
		}
	}
	public int NameToActivityType(String Action){

		switch(Action){
		case "SubscribePageLoad" : return 48;
		case "UserClickedSubscribeConfirm" : return 7;
		case "Confirmationpage" : return 25;
		case "SuccessfulSubscription" : return 14;
		case "DMVendorCallbackAPI" : return 2;
		default: System.err.println("This Action is not Valid");
		return 0;
		}

	}
	public boolean isEntryCreated(String query,String DM_DB,int rowEntry) throws ClassNotFoundException, SQLException, InterruptedException{

		boolean status=false;
		Log.info("Query for get count==>"+query+" DM_DB ==>"+DM_DB+" and expected num of rowEntry==>"+rowEntry);
		for(int i=0;i<30;i++) {

			int count=DB_Connection.CountRowEntry(query,DM_DB);
			if(count==rowEntry) {
				Log.info("Expected DB Entry is Created for this Number");
				status=true;
				break;
			}else {
				Thread.sleep(5000);
				System.err.println("Waiting ..................");
			}

		}
		return status;
	}
	@Then("Delete \"([^\"]*)\" the Log Entry for User \"([^\"]*)\" form DM Log Table")
	public void Delete_the_Log_Entry(String DM_DB,String Number) throws Exception{
		if(DM_DB.equalsIgnoreCase("DIAUS_INDIA_DB")){
			isEntryDeleted(Number,"DIAUS_DB_URL");
		}
		if(DM_DB.equalsIgnoreCase("DIAUS_UK_DB")){
			isEntryDeleted(Number,"DIAUS_UK_DB_URL");
		}
	}
	public void isEntryDeleted(String Number,String DM_DB) throws ClassNotFoundException, SQLException, InterruptedException{
		String dbName=null;
		String Delete_Entry=null;
		String query=Launcher.CFR.getProperty("Delete_Entry");
		
		if(DM_DB.equalsIgnoreCase("DIAUS_DB_URL")) {
			dbName =Launcher.CFR.getProperty("DIAUS_DB_Name");
			Delete_Entry=query.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number);
			Log.info("Query for Delete log Entry from DM Log Table==>"+Delete_Entry);
		}
		if(DM_DB.equalsIgnoreCase("DIAUS_UK_DB_URL")) {
			dbName =Launcher.CFR.getProperty("DIAUS_UK_DB_Name");
			Delete_Entry=query.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number);
			Log.info("Query for Delete log Entry from DM Log Table==>"+Delete_Entry);
		}
		
		boolean status=DB_Connection.DeleteRow(Number, DM_DB, Delete_Entry);
		Log.info("Query for Delete log Entry status is==>"+status);
		
	//	Assert.assertTrue("Checked the Status",status);
	}
	public void ClickSubscribeButton(By xpath) throws Exception {
		util.isElementPresent(xpath);
		String text=webdriver.findElement(xpath).getText();
		Log.info("Button text is-->"+text);
		util.safeJavaScriptClick(xpath);
		Log.info("Click on Subscribe Active Button");
		util.GetCurrenturlAndTitle();
	}	
	
	@Then("^Click on \"([^\"]*)\" Subscribe Button$")
	public void Click_on_Subscribe_BTN(String portal) throws Exception {
		
		if(portal.equalsIgnoreCase("UGames")) {
			ClickSubscribeButton(BtnSubscribe2);
		}
		if(portal.equalsIgnoreCase("UGamesContentFlow")) {
			ClickSubscribeButton(ActiveBtn);
		}
	}
	@Then("^Validate Subscription Tick image and text$")
	   public void validate_Subscribed_TICK_Image_Text() throws Exception {
		   Thread.sleep(3000);
		   util.isElementPresent(SubscribeConfirmationImg);
		   Log.info("Verify SubscribedTick Img is displayed in Subscribed Page");
		   util.isElementPresent(SubscribeConfirmationText);
		   Log.info("Verify Subscribedtext is displayed in Subscribed Page");
		   String text=webdriver.findElement(SubscribeConfirmationText).getText();
		   Log.info("Actual Subscribed text is-->"+text); 

	   }
	@Then("^Validate is Subscribe Game image and Name$")
	public void validate_Game_Img_text() throws Exception{
		util.isElementPresent(GameImg);
		Log.info("Subscribe Game IMG is present");
		String text=webdriver.findElement(GameText).getText();
		Log.info("Game Name is-->"+text);
	}
	@Then("^Validate NoThanks and Active Button is Present$")
	public void validate_Nothanks_Active_Btn() throws Exception {
		util.ScrollDown(NoThanks);
		String btn = webdriver.findElement(NoThanks).getText();
		Log.info("No Thanks Btn Text-->" + btn);
		String btn1 = webdriver.findElement(ActiveBtn).getText();
		Log.info("Active Btn Text-->" + btn1);
	}
	
	@Then("^Validate is Promption Text$")
	public void validate_Promo_TEXT() throws Exception{
		util.GotoPageEnd();
		util.isElementPresent(SubcribeText);
		String text=webdriver.findElement(SubcribeText).getText();
		Log.info("Promption Text is-->"+text);
	}
	
	@Then("^Validate User \"([^\"]*)\" DM Log Details for Activity Type \"([^\"]*)\" and Campaign Data Set \"([^\"]*)\" from DIAUS DB \"([^\"]*)\"$")
    public void Validate_DM_Log_Basednn_ActivityType_CampaignData(String Number,String ActivityType,String campaignData,String DM_DB) throws Exception{

           Map<String, String> actualCampaignDataSet=util.SplitString(campaignData);
           String dbName=null;
           
     Map<String, String> expectedCampaignDataSet=new LinkedHashMap<>();
                 
           String query_DM_Log=Launcher.CFR.getProperty("Query_DM_Log_Entry");
           String query_Entry_count=Launcher.CFR.getProperty("Query_Entry_Count");

           Map<String, Object> DM_log = new LinkedHashMap<>();

           if(DM_DB.equalsIgnoreCase("DIAUS_DB_URL")) {
                  dbName =Launcher.CFR.getProperty("DIAUS_DB_Name");

                  query_Entry_count=query_Entry_count.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number).replaceFirst("Indexcode",ActivityType);
                  Log.info("Query for Entry from DM Log Table==>"+query_Entry_count);

                  query_DM_Log=query_DM_Log.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number).replaceFirst("Indexcode",ActivityType);
                  Log.info("Query for get Top Entry from DM Log Table==>"+query_DM_Log);

           }
           if(DM_DB.equalsIgnoreCase("DIAUS_UK_DB_URL")) {
                  dbName =Launcher.CFR.getProperty("DIAUS_UK_DB_Name");
                  query_Entry_count=query_Entry_count.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number).replaceFirst("Indexcode",ActivityType);
                  Log.info("Query for Entry from DM Log Table==>"+query_Entry_count);

                  query_DM_Log=query_DM_Log.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number).replaceFirst("Indexcode",ActivityType);
                  Log.info("Query for get Top Entry from DM Log Table==>"+query_DM_Log);
           }

           boolean entry_Status=isEntryCreated(query_Entry_count,DM_DB,1);
           if(entry_Status==true) {
                  DM_log=DB_Connection.GetDMLogDetailsBasedOnActivityType(query_DM_Log,DM_DB);
                  Log.info("DM log entry Value==>"+DM_log);


                  Object ID= util.GetValue(DM_log,"ID");
                  Object userID=util.GetValue(DM_log,"UserID");
                  Object storeID= util.GetValue(DM_log,"StoreID");
                  Object OperatorName= util.GetValue(DM_log,"Operator");

                  Log.info("DM Log Information : UserID==>["+userID+"] and ID==>["+ID+"] and StoreID==>["+storeID+"] and ActivityType==>["+ActivityType+"] and operatorName==>["+OperatorName+"]");

                  Object campaignSource= util.GetValue(DM_log,"CampaignSource");
                  expectedCampaignDataSet.put("CampaignSource",(String) campaignSource);
                  
                  Object campaignMedium= util.GetValue(DM_log,"CampaignMedium");
                  expectedCampaignDataSet.put("CampaignMedium",(String) campaignMedium);
                  
                  Object campaignID= util.GetValue(DM_log,"CampaignID");
                  expectedCampaignDataSet.put("CampaignID",(String) campaignID);
                  
                  Object campaignSessionID= util.GetValue(DM_log,"CampaignSessionID");
                  expectedCampaignDataSet.put("CampaignSessionID",(String) campaignSessionID);
                  

                  if((campaignSource!=null) && (campaignID!=null) &&(campaignSessionID!=null) &&(campaignMedium!=null)) {
                        Log.info("Expected DM Log Information : CampaignSource==>["+campaignSource+"] and CampaignID==>["+campaignID+"] and CampaignSessionID==>["+campaignSessionID+"] and CampaignMedium==>["+campaignMedium+"]");
                        Log.info("Actual DM log Campaign data set value==>"+actualCampaignDataSet);
                        boolean status= util.ComparetwoLinkHashMapvalue(actualCampaignDataSet,expectedCampaignDataSet);
                        
                        Log.info("Two Map comparison  "+status);
                        
                        if(status==true) {
                                 Log.info("CAMPAIGN DATA SET ARE EQUALS..............");
                        }else {
                               Assert.fail("CAMPAIGN DATA SET ARE NOT EQUALS.................");
                        }

                  }else {
                        Log.info("DM Log Information : CampaignSource==>["+campaignSource+"] and CampaignID==>["+campaignID+"] and CampaignSessionID==>["+campaignSessionID+"] and CampaignMedium==>["+campaignMedium+"]");
                        Assert.fail("Campaign Value is NULL........................");
                  }
                  
           }else {
                  Log.info("DM LOG ENTRY IS NOT CREATED......"+entry_Status);
                  Assert.fail("DM LOG ENTRY IS NOT CREATED");
           }

    }
	
/*	@Then("^Validate Campaign Data in Prism TLogs$")
	public void Validate_PrismTLog_withCampaignData() throws Exception{
	String HostName=Launcher.CFR.getProperty("Prism_HostName");
	String UserName=Launcher.CFR.getProperty("Host_UserName");
	String Password=Launcher.CFR.getProperty("Host_Password");
	String command="cd /PRISM/TOMCAT/apache-tomcat-7.0.54/TOMCAT_LOGS/TLOG/BILLING_REALTIME && sed -n \"/storesessionid=18630/p\" TLOG_BILLING_REALTIME*.tmp";

//		JSCHHandler.executecommand("172.16.5.108", "root", "cvasqa108", "cd /opt/vineet/apache-tomcat-8.5.23/logs && sed -n \"/storesessionid=18452/p\" TLOG_Petar.txt");

	String CampaignDataSet=JSCHHandler.executecommand(HostName, UserName,Password, command);
	Log.info("CAMPAIGN DATA SET ARE IN PRISM LOG FILE-->"+CampaignDataSet);
	}*/

	
	@Then("^Validate Campaign Data in Prism TLogs with the help of User \"([^\"]*)\" SessionID$")
    public void Validate_PrismTLog_withCampaignData(String number) throws Exception{

           String query_sessionId=Launcher.CFR.getProperty("Get_SessionId");
           String dbName =Launcher.CFR.getProperty("DIAUS_UK_DB_Name");
           query_sessionId=query_sessionId.replaceFirst("DataBaseName", dbName).replaceFirst("Number", number);
           Log.info("Query for fetch Session ID from DM Log Table==>"+query_sessionId);
           String sessionID=null;
           
           ResultSet rs=DB_Connection.Connect_SQLServerDB(query_sessionId,"DIAUS_UK_DB_URL");
           while (rs.next()) {
        sessionID = rs.getString(1);
           }
//           System.out.println(sessionID);
           
           String HostName=Launcher.CFR.getProperty("Prism_HostName");
           String UserName=Launcher.CFR.getProperty("Host_UserName");
           String Password=Launcher.CFR.getProperty("Host_Password");
           
           String command="cd /PRISM/TOMCAT/apache-tomcat-7.0.54/TOMCAT_LOGS/TLOG/BILLING_REALTIME && sed -n \"/storesessionid="+sessionID+"/p\" *.tmp";
           
           //     JSCHHandler.executecommand("172.16.5.108", "root", "cvasqa108", "cd /opt/vineet/apache-tomcat-8.5.23/logs && sed -n \"/storesessionid=18452/p\" TLOG_Petar.txt");
   
    }
	
	
	@Then("^Validate User \"([^\"]*)\" DM Log Details for Activity Type \"([^\"]*)\" and Campaign Data Set \"([^\"]*)\" and I want validate Prism TLogs Campaign Data \"([^\"]*)\" and compare with \"([^\"]*)\" Database$")
	public void Validate_DM_Log_ActivityType_CampaignData_ValidatePrismTLog(String Number,String ActivityType,String campaignDataType,String isPrismTlogValidate,String DM_DB) throws Exception{
        
		String campaignData=null;
		String dbName=null;
		String ID=null;
		String userID=null;
		String storeID=null;
		String OperatorName=null;
		String SessionId=null;
		//Read the Campaign Data set from Config file
		
		campaignData=Launcher.CFR.getProperty(campaignDataType+"_CampaignDataSet");
	
		Log.info("Campaign Data Set from Config File==>"+campaignData);
		//Use this map for Split with Key,Value pair and Store Campaign Data Set(from Config File)
		Map<String, String> actualCampaignDataSet=util.SplitString(campaignData);
		//Use this map for Store Key,Value pair Campaign Data Set(from  DM log Table)
        Map<String, String> expectedCampaignDataSet=new LinkedHashMap<>();
      //Use this map for Split with Key,Value pair and Store Campaign Data Set(from Prism TLOG File)
        Map<String, String> PrismTlogCampaignDataSet=new LinkedHashMap<>();
        
		String query_DM_Log=Launcher.CFR.getProperty("Query_DM_Log_Entry");
		String query_Entry_count=Launcher.CFR.getProperty("Query_Entry_Count");

		Map<String, Object> DM_log = new LinkedHashMap<>();

		if(DM_DB.equalsIgnoreCase("DIAUS_DB_URL")) {
			dbName =Launcher.CFR.getProperty("DIAUS_DB_Name");

			query_Entry_count=query_Entry_count.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number).replaceFirst("Indexcode",ActivityType);
			Log.info("Query for Entry from DM Log Table==>"+query_Entry_count);

			query_DM_Log=query_DM_Log.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number).replaceFirst("Indexcode",ActivityType);
			Log.info("Query for get Top Entry from DM Log Table==>"+query_DM_Log);

		}
		if(DM_DB.equalsIgnoreCase("DIAUS_UK_DB_URL")) {
			dbName =Launcher.CFR.getProperty("DIAUS_DB_Name");
			query_Entry_count=query_Entry_count.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number).replaceFirst("Indexcode",ActivityType);
			Log.info("Query for Entry from DM Log Table==>"+query_Entry_count);

			query_DM_Log=query_DM_Log.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number).replaceFirst("Indexcode",ActivityType);
			Log.info("Query for get Top Entry from DM Log Table==>"+query_DM_Log);
		}

		boolean entry_Status=isEntryCreated(query_Entry_count,DM_DB,1);
		if(entry_Status==true) {
			DM_log=DB_Connection.GetDMLogDetailsBasedOnActivityType(query_DM_Log,DM_DB);
			Log.info("DM log entry Value==>"+DM_log);


			 ID= String.valueOf(util.GetValue(DM_log,"ID"));
			 userID=String.valueOf(util.GetValue(DM_log,"UserID"));
			 storeID= String.valueOf(util.GetValue(DM_log,"StoreID"));
			 OperatorName= String.valueOf(util.GetValue(DM_log,"Operator"));
			 SessionId=String.valueOf(util.GetValue(DM_log,"SessionID"));
			 
			Log.info("DM Log Information : UserID==>["+userID+"] and ID==>["+ID+"] and StoreID==>["+storeID+"] and ActivityType==>["+ActivityType+"] and operatorName==>["+OperatorName+"]");

			String campaignSource=String.valueOf(util.GetValue(DM_log,"CampaignSource"));
			expectedCampaignDataSet.put("CampaignSource",campaignSource);
			
			String campaignMedium=String.valueOf(util.GetValue(DM_log,"CampaignMedium"));
			expectedCampaignDataSet.put("CampaignMedium",campaignMedium);
			
			String campaignID= String.valueOf(util.GetValue(DM_log,"CampaignID"));
			expectedCampaignDataSet.put("CampaignID",campaignID);
			
			String campaignSessionID=String.valueOf(util.GetValue(DM_log,"CampaignSessionID"));
			expectedCampaignDataSet.put("CampaignSessionID",campaignSessionID);
			
			Log.info("Campaign Data Set from DM Log Table==>"+expectedCampaignDataSet);
			
           //Here We are validate our Expected Campaign Data with Actual Campaign Data from DM log Table
			if((campaignSource!=null) && (campaignID!=null) &&(campaignSessionID!=null) &&(campaignMedium!=null)) {
				Log.info("Expected DM Log Information : CampaignSource==>["+campaignSource+"] and CampaignID==>["+campaignID+"] and CampaignSessionID==>["+campaignSessionID+"] and CampaignMedium==>["+campaignMedium+"]");
				Log.info("Actual DM log Campaign data set value==>"+actualCampaignDataSet);
				boolean status= util.ComparetwoLinkHashMapvalue(actualCampaignDataSet,expectedCampaignDataSet);
				
				Log.info("Two Map comparison  "+status);
				
				if(status==true) {
					  Log.info("CAMPAIGN DATA SET ARE EQUALS..............");
				}else {
					Assert.fail("CAMPAIGN DATA SET ARE NOT EQUALS.................");
				}

			}else {
				Log.info("DM Log Information : CampaignSource==>["+campaignSource+"] and CampaignID==>["+campaignID+"] and CampaignSessionID==>["+campaignSessionID+"] and CampaignMedium==>["+campaignMedium+"]");
				Assert.fail("Campaign Value is NULL........................");
			}
			
		}else {
			Log.info("DM LOG ENTRY IS NOT CREATED......"+entry_Status);
			Assert.fail("DM LOG ENTRY IS NOT CREATED");
		}
		
	 //Here We are Validate our Expected Campaign Data with Prism TLOGs	
		if(isPrismTlogValidate.equalsIgnoreCase("TRUE")) {
			String PrismTlogCampaignData=Get_CampaignData_from_PrismTLog(SessionId);
			PrismTlogCampaignDataSet=util.SplitString(PrismTlogCampaignData);
			Log.info("Prism TLOG CAMPAIGN DATA SET ARE===>"+PrismTlogCampaignDataSet);
			 
			boolean status= util.ComparetwoLinkHashMapvalue(PrismTlogCampaignDataSet,expectedCampaignDataSet);
			Log.info("Two Map comparison  "+status);
			
			if(status==true) {
				  Log.info("CAMPAIGN DATA SET ARE EQUALS with Prism TLOG .............");
			}else {
				Assert.fail("CAMPAIGN DATA SET ARE NOT EQUALS with Prism TLOG.................");
			}
		}

	}
	
	public static String Get_CampaignData_from_PrismTLog(String sessionID) throws Exception{
		
		String HostName=Launcher.CFR.getProperty("Prism_HostName");
		String UserName=Launcher.CFR.getProperty("Host_UserName");
		String Password=Launcher.CFR.getProperty("Host_Password");
		//Pass the Tlog file location 
		String command="cd /opt/vineet/apache-tomcat-8.5.23/logs && sed -n \"/storesessionid="+sessionID+"/p\" *.tmp";
		
		//	JSCHHandler.executecommand("172.16.5.108", "root", "cvasqa108", "cd /opt/vineet/apache-tomcat-8.5.23/logs && sed -n \"/storesessionid=18452/p\" TLOG_Petar.txt");
		
		String CampaignDataSet=JSCHHandler.executecommand(HostName, UserName,Password, command);
		Log.info("CAMPAIGN DATA SET ARE IN PRISM LOG FILE-->"+CampaignDataSet);
		return CampaignDataSet;
		
	}

}
