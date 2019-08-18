package com.onmobile.stepDefinitions;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.onmobile.dataProvider.PropertyReader;
import com.onmobile.utils.JSCHHandler;
import com.onmobile.utils.Util;
import com.onmobile.xpaths.PortalXpath;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DM_Flow implements PortalXpath {
	static Logger Log = LogManager.getLogger("test");
	static WebDriver webdriver = Launcher.getdriver();
	Util util = new Util();
	DB_Connection dbconnection = new DB_Connection();
	By temp;

	private static String DBType = PropertyReader.readItem("Current_DB_Type");

	// Store the current DBType option using from config and pass the value
	// using Getter and setter
	public static String getCurrentDBType() {
		return DBType;
	}
	/*
	 * private void setCurrentDBType() { DBType =
	 * PropertyReader.readItem("Current_DB_Type"); }
	 */

	@Then("^Waiting for few sec....$")
	public void wait_for_sec() throws Exception {
		// Thread.sleep(30000);
		Thread.sleep(1 * // minutes to sleep
				60 * // seconds to a minute
				1000); // milliseconds to a second
		Log.info("Waiting for few Sec.....");
	}

	@Then("^Click on Banner \"([^\"]*)\" Link in AD2C url$")
	public void Click_on_Banner_Link(String linkName) throws Exception {
		temp = util.modifyXpath(BannerLink, linkName);
		util.safeJavaScriptClick(temp);
		Log.info("Click on [" + linkName + "] Banner Link");
		util.GetCurrenturlAndTitle();
	}

	@Then("^Validate DM task information from DIAUS DB$")
	public void validate_DM_Task() throws Exception {
		String query_DM = "SELECT TOP 1 * FROM [DigitalMarketing_auto].[dbo].[DM_Tasks] order by [TID] desc";
		DB_Connection.ConnectSQLServerDB(query_DM, "DIAUS_DB_URL");
	}

	@Given("^Change the Number \"([^\"]*)\" in Mod Header$")
	public void Change_Num_ModHeader(String number) throws Throwable {

		String mainTab = Launcher.Open_New_Tab();
		Log.info("Open The New Tab");
		webdriver.findElement(By.xpath("//button[@id='btn_edit_2']")).click();
		Thread.sleep(500);
		WebElement valueElem1 = webdriver.findElement(By.name("value"));
		valueElem1.clear();
		valueElem1.sendKeys(number);
		webdriver.findElement(By.xpath("//button[@id='btn_save_2']")).click();
		Thread.sleep(1000);
		webdriver.switchTo().window(mainTab);
		Log.info("Switch to the Main Tab");
		Log.info(webdriver.getTitle());
		webdriver.manage().deleteAllCookies();
	}

	@Given("^Open New Tab and Set \"([^\"]*)\" with Number \"([^\"]*)\" in Mod Header$")
	public void Set_Num_ModHeader(String requestHaederName, String number) throws Throwable {

		String mainTab = Launcher.Open_New_Tab();
		Log.info("Opened The New Tab");

		webdriver.findElement(By.xpath("//button[@tooltip='Add New']")).click();

		WebElement actionElem = webdriver.findElement(By.name("action"));
		Select select = new Select(actionElem);
		select.selectByVisibleText("Add");

		WebElement nameElem = webdriver.findElement(By.name("name"));
		if (requestHaederName.equalsIgnoreCase("x-up-subno")) {
			nameElem.sendKeys("x-up-subno");
		}
		if (requestHaederName.equalsIgnoreCase("x-msisdn")) {
			nameElem.sendKeys("x-msisdn");
		}
		WebElement valueElem = webdriver.findElement(By.name("value"));

		valueElem.sendKeys(number);

		WebElement descElem = webdriver.findElement(By.name("description"));
		descElem.sendKeys("Add user " + requestHaederName);
		Thread.sleep(1000);
		webdriver.findElement(By.xpath("//button[@id='btn_save_3']")).click();
		Thread.sleep(1000);
		webdriver.findElement(By.xpath("//button[@id='btn_enable_3']")).click();
		Thread.sleep(1000);

		// Close the new window if that window no more required
		webdriver.close();

		webdriver.switchTo().window(mainTab);
		Log.info("Switch to the Main Tab");
		Log.info(webdriver.getTitle());
		webdriver.manage().deleteAllCookies();
	}

	@Then("^Validate DM task information after redirect with callBack url$")
	public void validate_DM_Task_after_redirct_CallBack() throws Exception {

		String SessionId = null;
		String ParentId = null;
		String UserID = null;
		String TID = null;
		Map<String, Object> DM_Task_Data = null;
		Map<String, Object> DM_Task_2ndEntryData = null;
		String query_DM_Task = null;
		String dbName = null;

		if (DBType.equalsIgnoreCase("MSSQLSERVER")) {
			query_DM_Task = PropertyReader.readItem("Query_DM_Task_Entry");
			dbName = PropertyReader.readItem("DIAUS_DB_Name");
			query_DM_Task = query_DM_Task.replaceFirst("DataBaseName", dbName);
			Log.info("Query for DM task Entry from DM Log Table==>" + query_DM_Task);
			DM_Task_Data = DB_Connection.ConnectSQLServerDB(query_DM_Task, "DIAUS_DB_URL");

		}
		if (DBType.equalsIgnoreCase("MARIADB")) {
			query_DM_Task = PropertyReader.readItem("Maria_Query_DM_Task_Entry");
			Log.info("Query for DM task Entry from DM Log Table==>" + query_DM_Task);
			DM_Task_Data = DB_Connection.GetDMLogDetailsBasedOnActivityType(query_DM_Task, "MARIADB");
		}

		// Validate DM Task Entry is Created or Not
		if (DM_Task_Data == null || DM_Task_Data.isEmpty()) {
			Log.info("DM Task Entry is NOT Created============>");
			Assert.assertTrue(DM_Task_Data.isEmpty());
			Assert.fail("DM Task 1st Entry is NOT Created==>");
		} else {
			Log.info("DM Task Entry is Created==========>");
			Log.info("DM Task Entry Data==========>" + DM_Task_Data);
			SessionId = String.valueOf(util.GetValue(DM_Task_Data, "SessionID"));
			ParentId = String.valueOf(util.GetValue(DM_Task_Data, "ParentTID"));
			UserID = String.valueOf(util.GetValue(DM_Task_Data, "UserID"));
			TID = String.valueOf(util.GetValue(DM_Task_Data, "TID"));
			Log.info("DM Task UserID==>[" + UserID + "] and TID==>[" + TID + "] and SessionId==>[" + SessionId
					+ "] and Parent Id is==>" + ParentId);

			// If DM Entry is Created then fetch the parent ID,SessionId and
			// Pass TID as ParentTID in 2nd Entry Query
			if (DBType.equalsIgnoreCase("MSSQLSERVER")) {
				query_DM_Task = PropertyReader.readItem("Query_DM_Task_2ndEntry");
				query_DM_Task = query_DM_Task.replaceFirst("DataBaseName", dbName).replaceFirst("ReplaceTID", TID)
						.replaceFirst("ReplaceSessionId", SessionId);
				Log.info("Query for DM task 2nd Entry from DM Log Table==>" + query_DM_Task);
				DM_Task_2ndEntryData = DB_Connection.ConnectSQLServerDB(query_DM_Task, "DIAUS_DB_URL");

			}
			if (DBType.equalsIgnoreCase("MARIADB")) {
				query_DM_Task = PropertyReader.readItem("Maria_Query_DM_Task_2ndEntry");
				Log.info("Query for DM task 2nd Entry from DM Log Table==>" + query_DM_Task);
				DM_Task_Data = DB_Connection.GetDMLogDetailsBasedOnActivityType(query_DM_Task, "MARIADB");
			}

			if (DM_Task_2ndEntryData == null || DM_Task_2ndEntryData.isEmpty()) {
				Log.info("DM Task 2nd Entry is NOT Created==>");
				Assert.assertTrue(DM_Task_2ndEntryData.isEmpty());
				Assert.fail("DM Task 2nd Entry is NOT Created==>");
			} else {
				Log.info("DM Task 2nd Entry is Created======>");
				Log.info("DM Task 2nd Entry Data==========>" + DM_Task_2ndEntryData);
				TID = String.valueOf(util.GetValue(DM_Task_Data, "TID"));
				UserID = String.valueOf(util.GetValue(DM_Task_2ndEntryData, UserID));
				Log.info("DM Task UserID==>[" + UserID + "] and TID==>[" + TID + "] and Parent Id is==>" + ParentId);
			}
		}
	}

	@Then("^Validate User \"([^\"]*)\" DM Log Details for Activity Type \"([^\"]*)\" from DIAUS DB \"([^\"]*)\"$")
	public void validate_DM_Log_BasedOn_ActivityType(String Number, String ActivityType, String DM_DB)
			throws Exception {

		String dbName = null;
		String query_DM_Log = null;
		String query_Entry_count = null;

		Map<String, Object> DM_log = new LinkedHashMap<>();

		if (DM_DB.equalsIgnoreCase("DIAUS_DB_URL")) {
			if (DBType.equalsIgnoreCase("MSSQLSERVER")) {
				dbName = PropertyReader.readItem("DIAUS_DB_Name");
				query_DM_Log = PropertyReader.readItem("Query_DM_Log_Entry");
				query_Entry_count = PropertyReader.readItem("Query_Entry_Count");

				query_Entry_count = query_Entry_count.replaceFirst("DataBaseName", dbName)
						.replaceFirst("Number", Number).replaceFirst("Indexcode", ActivityType);
				Log.info("Query for Entry from DM Log Table==>" + query_Entry_count);
				query_DM_Log = query_DM_Log.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number)
						.replaceFirst("Indexcode", ActivityType);
				Log.info("Query for get Top Entry from DM Log Table==>" + query_DM_Log);

			}
			if (DBType.equalsIgnoreCase("MARIADB")) {
				query_DM_Log = PropertyReader.readItem("Maria_Query_DM_Log_Entry");
				query_Entry_count = PropertyReader.readItem("Maria_Query_Entry_Count");
				query_Entry_count = query_Entry_count.replaceFirst("Number", Number).replaceFirst("Indexcode",
						ActivityType);
				Log.info("Query for Entry from DM Log Table==>" + query_Entry_count);
				query_DM_Log = query_DM_Log.replaceFirst("Number", Number).replaceFirst("Indexcode", ActivityType);
				Log.info("Query for get Top Entry from DM Log Table==>" + query_DM_Log);
			}
		}
		if (DM_DB.equalsIgnoreCase("DIAUS_UK_DB_URL")) {
			dbName = PropertyReader.readItem("DIAUS_DB_Name");
			query_Entry_count = query_Entry_count.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number)
					.replaceFirst("Indexcode", ActivityType);
			Log.info("Query for Entry from DM Log Table==>" + query_Entry_count);

			query_DM_Log = query_DM_Log.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number)
					.replaceFirst("Indexcode", ActivityType);
			Log.info("Query for get Top Entry from DM Log Table==>" + query_DM_Log);
		}

		boolean entry_Status = isEntryCreated(query_Entry_count, DM_DB, 1);

		if (entry_Status == true) {
			DM_log = DB_Connection.GetDMLogDetailsBasedOnActivityType(query_DM_Log, DM_DB);
			Log.info("DM log entry Value==>" + DM_log);

			Object ID = util.GetValue(DM_log, "ID");
			Object userID = util.GetValue(DM_log, "UserID");
			Object storeID = util.GetValue(DM_log, "StoreID");
			Object OperatorName = util.GetValue(DM_log, "Operator");

			Log.info("DM Log Information : UserID==>[" + userID + "] and ID==>[" + ID + "] and StoreID==>[" + storeID
					+ "] and ActivityType==>[" + ActivityType + "] and operatorName==>[" + OperatorName + "]");

			Object campaignSource = util.GetValue(DM_log, "CampaignSource");
			Object campaignID = util.GetValue(DM_log, "CampaignID");
			Object campaignSessionID = util.GetValue(DM_log, "CampaignSessionID");
			Object campaignMedium = util.GetValue(DM_log, "CampaignMedium");

			if ((campaignSource != null) && (campaignID != null) && (campaignSessionID != null)
					&& (campaignMedium != null)) {
				Log.info("DM Log Information : CampaignSource==>[" + campaignSource + "] and CampaignID==>["
						+ campaignID + "] and CampaignSessionID==>[" + campaignSessionID + "] and CampaignMedium==>["
						+ campaignMedium + "]");
			} else {
				Log.info("DM Log Information : CampaignSource==>[" + campaignSource + "] and CampaignID==>["
						+ campaignID + "] and CampaignSessionID==>[" + campaignSessionID + "] and CampaignMedium==>["
						+ campaignMedium + "]");
				Assert.fail("NULL");
			}

		} else {
			Log.info("DM LOG ENTRY IS NOT CREATED......" + entry_Status);
			Assert.fail("NULL");
		}

	}

	public boolean isEntryCreated(String query, String DM_DB, int rowEntry)
			throws ClassNotFoundException, SQLException, InterruptedException {

		boolean status = false;
		Log.info("Query for get count==>" + query + " DM_DB ==>" + DM_DB + " and expected num of rowEntry==>"
				+ rowEntry);
		int dbqueryretrycount = Integer.parseInt(PropertyReader.readItem("DB_QUERY_RETRY_COUNT"));

		for (int i = 0; i < dbqueryretrycount; i++) {

			int count = DB_Connection.CountRowEntry(query, DM_DB);
			if (rowEntry <= count) {
				Log.info("Expected DB Entry is Created for this Number");
				status = true;
				break;
			} else {
				Thread.sleep(5000);
				System.err.println("Waiting ..................");
			}

		}
		return status;
	}

	@Then("Delete \"([^\"]*)\" the Log Entry for User \"([^\"]*)\" form DM Log Table")
	public void Delete_the_Log_Entry(String DM_DB, String Number) throws Exception {
		String query = null;

		if (DM_DB.equalsIgnoreCase("DIAUS_INDIA_DB")) {
			if (DBType.equalsIgnoreCase("MSSQLSERVER")) {
				query = PropertyReader.readItem("Delete_Query_DM_Log");
			}
			if (DBType.equalsIgnoreCase("MARIADB")) {
				query = PropertyReader.readItem("Maria_Query_Delete_DM_Log");
			}
			isEntryDeleted(Number, "DIAUS_DB_URL", query);
		}
		if (DM_DB.equalsIgnoreCase("DIAUS_UK_DB")) {
			query = PropertyReader.readItem("Delete_Query_DM_Log");
			isEntryDeleted(Number, "DIAUS_UK_DB_URL", query);
		}
	}

	public void isEntryDeleted(String Number, String DM_DB, String query)
			throws ClassNotFoundException, SQLException, InterruptedException {
		String dbName = null;
		String Delete_Entry = null;
		// String query=PropertyReader.readItem("Delete_Query_DM_Log");

		if (DM_DB.equalsIgnoreCase("DIAUS_DB_URL")) {

			if (DBType.equalsIgnoreCase("MSSQLSERVER")) {
				dbName = PropertyReader.readItem("DIAUS_DB_Name");
				Delete_Entry = query.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number);
				Log.info("Query for Delete log Entry from DM Log Table==>" + Delete_Entry);
				boolean status = DB_Connection.DeleteRow(Number, DM_DB, Delete_Entry);
				Log.info("Query for Delete log Entry status is==>" + status);
			}
			if (DBType.equalsIgnoreCase("MARIADB")) {

				Delete_Entry = query.replaceFirst("Number", Number);
				Log.info("Query for Delete log Entry from DM Log Table==>" + Delete_Entry);
				boolean status = DB_Connection.MariaDB_DeleteRow(Number, DM_DB, Delete_Entry);
				Log.info("Query for Delete log Entry status is==>" + status);
			}

		}
		if (DM_DB.equalsIgnoreCase("DIAUS_UK_DB_URL")) {
			dbName = PropertyReader.readItem("DIAUS_UK_DB_Name");
			Delete_Entry = query.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number);
			Log.info("Query for Delete log Entry from DM Log Table==>" + Delete_Entry);
			boolean status = DB_Connection.DeleteRow(Number, DM_DB, Delete_Entry);
			Log.info("Query for Delete log Entry status is==>" + status);
		}

	}


	@Then("Delete \"([^\"]*)\" the User Entry \"([^\"]*)\" form DIAUS UserManagement Table")
	public void Delete_the_Data_Entry_FromTable(String DM_DB, String Number) throws Exception {
		String query = PropertyReader.readItem("Delete_Query_AspNetUsers");
		query = query.replaceFirst("ReplaceNumber", Number);
		Log.info("Query for Delete log Entry from AspNetUsers Table==>" + query);
		boolean status = DB_Connection.DeleteRow(Number, DM_DB, query);
		Log.info("Query for Delete log Entry status is==>" + status);
	}

	@Then("^Validate User \"([^\"]*)\" DM Log Details for Activity Type \"([^\"]*)\" and Campaign Data Set \"([^\"]*)\" from DIAUS DB \"([^\"]*)\"$")
	public void Validate_DM_Log_Basednn_ActivityType_CampaignData(String Number, String ActivityType,
			String campaignData, String DM_DB) throws Exception {

		Map<String, String> actualCampaignDataSet = util.SplitStringComma(campaignData);
		String dbName = null;

		Map<String, String> expectedCampaignDataSet = new LinkedHashMap<>();

		String query_DM_Log = PropertyReader.readItem("Query_DM_Log_Entry");
		String query_Entry_count = PropertyReader.readItem("Query_Entry_Count");

		Map<String, Object> DM_log = new LinkedHashMap<>();

		if (DM_DB.equalsIgnoreCase("DIAUS_DB_URL")) {
			dbName = PropertyReader.readItem("DIAUS_DB_Name");

			query_Entry_count = query_Entry_count.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number)
					.replaceFirst("Indexcode", ActivityType);
			Log.info("Query for Entry from DM Log Table==>" + query_Entry_count);

			query_DM_Log = query_DM_Log.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number)
					.replaceFirst("Indexcode", ActivityType);
			Log.info("Query for get Top Entry from DM Log Table==>" + query_DM_Log);

		}
		if (DM_DB.equalsIgnoreCase("DIAUS_UK_DB_URL")) {
			dbName = PropertyReader.readItem("DIAUS_DB_Name");
			query_Entry_count = query_Entry_count.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number)
					.replaceFirst("Indexcode", ActivityType);
			Log.info("Query for Entry from DM Log Table==>" + query_Entry_count);

			query_DM_Log = query_DM_Log.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number)
					.replaceFirst("Indexcode", ActivityType);
			Log.info("Query for get Top Entry from DM Log Table==>" + query_DM_Log);
		}

		boolean entry_Status = isEntryCreated(query_Entry_count, DM_DB, 1);
		if (entry_Status == true) {
			DM_log = DB_Connection.GetDMLogDetailsBasedOnActivityType(query_DM_Log, DM_DB);
			Log.info("DM log entry Value==>" + DM_log);

			Object ID = util.GetValue(DM_log, "ID");
			Object userID = util.GetValue(DM_log, "UserID");
			Object storeID = util.GetValue(DM_log, "StoreID");
			Object OperatorName = util.GetValue(DM_log, "Operator");

			Log.info("DM Log Information : UserID==>[" + userID + "] and ID==>[" + ID + "] and StoreID==>[" + storeID
					+ "] and ActivityType==>[" + ActivityType + "] and operatorName==>[" + OperatorName + "]");

			Object campaignSource = util.GetValue(DM_log, "CampaignSource");
			expectedCampaignDataSet.put("CampaignSource", (String) campaignSource);

			Object campaignMedium = util.GetValue(DM_log, "CampaignMedium");
			expectedCampaignDataSet.put("CampaignMedium", (String) campaignMedium);

			Object campaignID = util.GetValue(DM_log, "CampaignID");
			expectedCampaignDataSet.put("CampaignID", (String) campaignID);

			Object campaignSessionID = util.GetValue(DM_log, "CampaignSessionID");
			expectedCampaignDataSet.put("CampaignSessionID", (String) campaignSessionID);

			if ((campaignSource != null) && (campaignID != null) && (campaignSessionID != null)
					&& (campaignMedium != null)) {
				Log.info("Expected DM Log Information : CampaignSource==>[" + campaignSource + "] and CampaignID==>["
						+ campaignID + "] and CampaignSessionID==>[" + campaignSessionID + "] and CampaignMedium==>["
						+ campaignMedium + "]");
				Log.info("Actual DM log Campaign data set value==>" + actualCampaignDataSet);
				boolean status = util.ComparetwoLinkHashMapvalue(actualCampaignDataSet, expectedCampaignDataSet);

				Log.info("Two Map comparison  " + status);

				if (status == true) {
					Log.info("CAMPAIGN DATA SET ARE EQUALS..............");
				} else {
					Assert.fail("CAMPAIGN DATA SET ARE NOT EQUALS.................");
				}

			} else {
				Log.info("DM Log Information : CampaignSource==>[" + campaignSource + "] and CampaignID==>["
						+ campaignID + "] and CampaignSessionID==>[" + campaignSessionID + "] and CampaignMedium==>["
						+ campaignMedium + "]");
				Assert.fail("Campaign Value is NULL........................");
			}

		} else {
			Log.info("DM LOG ENTRY IS NOT CREATED......" + entry_Status);
			Assert.fail("DM LOG ENTRY IS NOT CREATED");
		}

	}

	@Then("^Validate Campaign Data in Prism TLogs$")
	public void Validate_PrismTLog_withCampaignData() throws Exception {
		String HostName = PropertyReader.readItem("Prism_HostName");
		String UserName = PropertyReader.readItem("Host_UserName");
		String Password = PropertyReader.readItem("Host_Password");
		String command = "cd /opt/vineet/apache-tomcat-8.5.23/logs && sed -n \"/storesessionid=18452/p\" TLOG_Petar.txt";

		// JSCHHandler.executecommand("172.16.5.108", "root", "cvasqa108", "cd
		// /opt/vineet/apache-tomcat-8.5.23/logs && sed -n
		// \"/storesessionid=18452/p\" TLOG_Petar.txt");

		String CampaignDataSet = JSCHHandler.executecommand(HostName, UserName, Password, command);
		Log.info("CAMPAIGN DATA SET ARE IN PRISM LOG FILE-->" + CampaignDataSet);

	}

	@Then("^Validate User \"([^\"]*)\" DM Log Details for Activity Type \"([^\"]*)\" and Campaign Data Set \"([^\"]*)\" and I want validate Prism TLogs Campaign Data \"([^\"]*)\" and compare with \"([^\"]*)\" Database$")
	public void Validate_DM_Log_ActivityType_CampaignData_ValidatePrismTLog(String Number, String ActivityType,
			String campaignDataType, String isPrismTlogValidate, String DM_DB) throws Exception {

		String campaignData = null;
		String dbName = null;
		String ID = null;
		String userID = null;
		String storeID = null;
		String OperatorName = null;
		String SessionId = null;

		// Read the Campaign Data set from Config file
		campaignData = PropertyReader.readItem(campaignDataType + "_CampaignDataSet");

		Log.info("Campaign Data Set from Config File==>" + campaignData);
		// Use this map for Split with Key,Value pair and Store Campaign Data
		// Set(from Config File)
		Map<String, String> actualCampaignDataSet = util.SplitStringComma(campaignData);
		// Use this map for Store Key,Value pair Campaign Data Set(from DM log
		// Table)
		Map<String, String> expectedCampaignDataSet = new LinkedHashMap<>();
		// Use this map for Split with Key,Value pair and Store Campaign Data
		// Set(from Prism TLOG File)
		Map<String, String> PrismTlogCampaignDataSet = new LinkedHashMap<>();

		String query_DM_Log = PropertyReader.readItem("Query_DM_Log_Entry");
		String query_Entry_count = PropertyReader.readItem("Query_Entry_Count");

		Map<String, Object> DM_log = new LinkedHashMap<>();

		if (DM_DB.equalsIgnoreCase("DIAUS_DB_URL")) {
			dbName = PropertyReader.readItem("DIAUS_DB_Name");

			query_Entry_count = query_Entry_count.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number)
					.replaceFirst("Indexcode", ActivityType);
			Log.info("Query for Entry from DM Log Table==>" + query_Entry_count);

			query_DM_Log = query_DM_Log.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number)
					.replaceFirst("Indexcode", ActivityType);
			Log.info("Query for get Top Entry from DM Log Table==>" + query_DM_Log);

		}
		if (DM_DB.equalsIgnoreCase("DIAUS_UK_DB_URL")) {
			dbName = PropertyReader.readItem("DIAUS_DB_Name");
			query_Entry_count = query_Entry_count.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number)
					.replaceFirst("Indexcode", ActivityType);
			Log.info("Query for Entry from DM Log Table==>" + query_Entry_count);

			query_DM_Log = query_DM_Log.replaceFirst("DataBaseName", dbName).replaceFirst("Number", Number)
					.replaceFirst("Indexcode", ActivityType);
			Log.info("Query for get Top Entry from DM Log Table==>" + query_DM_Log);
		}

		boolean entry_Status = isEntryCreated(query_Entry_count, DM_DB, 1);
		if (entry_Status == true) {
			DM_log = DB_Connection.GetDMLogDetailsBasedOnActivityType(query_DM_Log, DM_DB);
			Log.info("DM log entry Value==>" + DM_log);

			ID = String.valueOf(util.GetValue(DM_log, "ID"));
			userID = String.valueOf(util.GetValue(DM_log, "UserID"));
			storeID = String.valueOf(util.GetValue(DM_log, "StoreID"));
			OperatorName = String.valueOf(util.GetValue(DM_log, "Operator"));
			SessionId = String.valueOf(util.GetValue(DM_log, "SessionID"));

			Log.info("DM Log Information : UserID==>[" + userID + "] and ID==>[" + ID + "] and StoreID==>[" + storeID
					+ "] and ActivityType==>[" + ActivityType + "] and operatorName==>[" + OperatorName + "]");

			String campaignSource = String.valueOf(util.GetValue(DM_log, "CampaignSource"));
			expectedCampaignDataSet.put("CampaignSource", campaignSource);

			String campaignMedium = String.valueOf(util.GetValue(DM_log, "CampaignMedium"));
			expectedCampaignDataSet.put("CampaignMedium", campaignMedium);

			String campaignID = String.valueOf(util.GetValue(DM_log, "CampaignID"));
			expectedCampaignDataSet.put("CampaignID", campaignID);

			String campaignSessionID = String.valueOf(util.GetValue(DM_log, "CampaignSessionID"));
			expectedCampaignDataSet.put("CampaignSessionID", campaignSessionID);

			Log.info("Campaign Data Set from DM Log Table==>" + expectedCampaignDataSet);

			// Here We are validate our Expected Campaign Data with Actual
			// Campaign Data from DM log Table
			if ((campaignSource != null) && (campaignID != null) && (campaignSessionID != null)
					&& (campaignMedium != null)) {
				Log.info("Expected DM Log Information : CampaignSource==>[" + campaignSource + "] and CampaignID==>["
						+ campaignID + "] and CampaignSessionID==>[" + campaignSessionID + "] and CampaignMedium==>["
						+ campaignMedium + "]");
				Log.info("Actual DM log Campaign data set value==>" + actualCampaignDataSet);
				boolean status = util.ComparetwoLinkHashMapvalue(actualCampaignDataSet, expectedCampaignDataSet);

				Log.info("Two Map comparison  " + status);

				if (status == true) {
					Log.info("CAMPAIGN DATA SET ARE EQUALS..............");
				} else {
					Assert.fail("CAMPAIGN DATA SET ARE NOT EQUALS.................");
				}

			} else {
				Log.info("DM Log Information : CampaignSource==>[" + campaignSource + "] and CampaignID==>["
						+ campaignID + "] and CampaignSessionID==>[" + campaignSessionID + "] and CampaignMedium==>["
						+ campaignMedium + "]");
				Assert.fail("Campaign Value is NULL........................");
			}

		} else {
			Log.info("DM LOG ENTRY IS NOT CREATED......" + entry_Status);
			Assert.fail("DM LOG ENTRY IS NOT CREATED");
		}

		// Here We are Validate our Expected Campaign Data with Prism TLOGs
		if (isPrismTlogValidate.equalsIgnoreCase("TRUE")) {
			String PrismTlogCampaignData = Get_CampaignData_from_PrismTLog(SessionId);
			PrismTlogCampaignDataSet = util.SplitString(PrismTlogCampaignData);
			Log.info("Prism TLOG CAMPAIGN DATA SET ARE===>" + PrismTlogCampaignDataSet);

			boolean status = util.ComparetwoLinkHashMapvalue(PrismTlogCampaignDataSet, expectedCampaignDataSet);
			Log.info("Two Map comparison  " + status);

			if (status == true) {
				Log.info("CAMPAIGN DATA SET ARE EQUALS with Prism TLOG .............");
			} else {
				Assert.fail("CAMPAIGN DATA SET ARE NOT EQUALS with Prism TLOG.................");
			}
		}

	}

	public static String Get_CampaignData_from_PrismTLog(String sessionID) throws Exception {

		String HostName = PropertyReader.readItem("Prism_HostName");
		String UserName = PropertyReader.readItem("Host_UserName");
		String Password = PropertyReader.readItem("Host_Password");
		// Pass the Tlog file location
		String command = "cd /opt/vineet/apache-tomcat-8.5.23/logs && sed -n \"/storesessionid=" + sessionID
				+ "/p\" *.tmp";

		// JSCHHandler.executecommand("172.16.5.108", "root", "cvasqa108", "cd
		// /opt/vineet/apache-tomcat-8.5.23/logs && sed -n
		// \"/storesessionid=18452/p\" TLOG_Petar.txt");

		String CampaignDataSet = JSCHHandler.executecommand(HostName, UserName, Password, command);
		Log.info("CAMPAIGN DATA SET ARE IN PRISM LOG FILE-->" + CampaignDataSet);
		return CampaignDataSet;

	}

}
