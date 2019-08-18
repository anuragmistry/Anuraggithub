package com.onmobile.stepDefinitions;

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

import cucumber.api.java.en.Then;

public class AppLandFlow implements PortalXpath{
	static Logger Log = LogManager.getLogger("test");
	static WebDriver webdriver = Launcher.getdriver();
	Util util=new Util();
	DB_Connection dbconnection= new DB_Connection();
	By temp;	


	
	@Then("^Validate is Logo Image present$")
	public void validate_Logo_image() throws Exception{
		util.isElementPresent(AppLandLogoImg);
		Log.info("Validate Logo is present");
	}
	
	@Then("^Click on \"([^\"]*)\" Button$")
	public void Click_on_Basic_Family_btn(String plan) throws Exception {
		if(plan.equalsIgnoreCase("Basic")) {
			util.safeJavaScriptClick(BasicBTN);
			Log.info("Click on Basic Plan Button");
		}
		if(plan.equalsIgnoreCase("Family")) {
			util.safeJavaScriptClick(FamilyBTN);
			Log.info("Click on Family Plan Button");
		}
	}
	
	
	@Then("^Click on \"([^\"]*)\" Plan Continue Button$")
	public void Click_on_Continue_btn_BasedOnPackName(String plan) throws Exception {
		    util.isElementPresent(ChosePlanAndClickHeading);
		    Log.info("Chose Plan And Click Heading  is Present");
			util.safeJavaScriptClick(util.modifyXpath(ClickOnPackContinueBTN,plan));
			Log.info("Click on "+plan+" Continue Button");
		
	}
	
	@Then("^Validate \"([^\"]*)\" Subscribe Packs details message$")
	public void Validate_Basic_Family_Subscribe_msg(String plan) throws Exception{
		if(plan.equalsIgnoreCase("Basic")) {
			String text=webdriver.findElement(BasicPackDetails).getText();
			Log.info("Basic Subscribe Packs details message-->"+text);
		}
		if(plan.equalsIgnoreCase("Family")) {
			String text=webdriver.findElement(FamilyPackDetails).getText();
			Log.info("Family Subscribe Packs details message-->"+text);
		}


	}
	@Then("^Click on the Confirm Button$")
	public void Click_on_Appland_Confirm_BTN() throws Exception {
		util.ScrollDown(AppLandConfirmBtn);
		util.isElementPresent(AppLandConfirmBtn);
		String btntext=webdriver.findElement(AppLandConfirmBtn).getText();
		Log.info("Button text is-->"+btntext);
		util.safeJavaScriptClick(AppLandConfirmBtn);
		Log.info("Click on Subscribe Button");
		util.GetCurrenturlAndTitle();
	}
	
	@Then("^Click on \"([^\"]*)\" Continue Button$")
	public void Click_on_Basic_Family_Continue_Btn(String plan) throws Exception {
		if(plan.equalsIgnoreCase("Basic")) {
			util.safeJavaScriptClick(BasicContinueBTN);
			Log.info("Click on Basic Continue Button");
		}
		if(plan.equalsIgnoreCase("Family")) {
			util.safeJavaScriptClick(FamilyContinueBTN);
			Log.info("Click on Family Continue Button");
		}
		util.GetCurrenturlAndTitle();
	}
	
	@Then("^Validate Joint Family Account Button is Present$")
	public void Validate_Joint_Family_Account_BTN() throws Exception{
		util.isElementPresent(JointAccount);
		Log.info("Joint Family Account Button is present");
		String text=webdriver.findElement(JointAccount).getText();
		Log.info("Joint Family Account Button text-->"+text);
	}
	
	@Then("^Click on Joint Family Account Button$")
	public void Click_on_JointFamily_BTN() throws Exception {
		util.isElementPresent(JointAccount);
		util.safeJavaScriptClick(JointAccount);
		Log.info("Click on JointAccount Button");
		util.GetCurrenturlAndTitle();
	}
	
	@Then("^Validate Terms and Conditions text and Value$")
	public void Validate_TermsConditions_Link() throws Exception {
		util.isElementPresent(TermsCondition);
		Log.info("Terms Conditions Link  is present");
		String text=webdriver.findElement(TermsCondition).getAttribute("href");
		Log.info("Terms Conditions Link valiue-->"+text);
	}
	
	@Then("^Validate AlbumImg is present$")
	public void validate_Banner() throws Exception{
		util.isElementPresent(AlbumImg);
		Log.info("AlbumImg is present");
	}
	
	@Then("^Validate SignUp is present$")
	public void validate_SignUp() throws Exception{
		util.isElementPresent(SignUpHeading);
		Log.info("SignUp is present");
		util.isElementPresent(CreateFamilyAccountText);
		Log.info("Create Family Account Text is present");
		String text=webdriver.findElement(CreateFamilyAccountText).getText();
		Log.info("CreateFamilyAccount text-->"+text);
	}
	
	@Then("^Validate Mobile Number Label and inside Value \"([^\"]*)\" in SignUp Page$")
	public void validate_MobilenumberLabel_Value(String mobilenum) throws Exception{
		util.isElementPresent(EnterMobileNum);
		Log.info("MobileNum field is present");
		String text=webdriver.findElement(EnterMobileNum).getAttribute("value");
		Log.info("Mobile Number in inside text box-->"+text);
		Assert.assertTrue("Compare with mobile number", mobilenum.equalsIgnoreCase(text));
		Log.info("Compare Expected Mobile Number["+mobilenum+"] with inside text box value-->"+text);
	}
	
	@Then("^Enter the Password and Confrim Password \"([^\"]*)\"$")
	public void Enter_Password_Confrim(String pwd) throws Exception {
		WebElement inputbox1 =util.FindElement(EnterPassword,100);
		util.isElementPresent(EnterPassword);
		Log.info("InputBox EnterPassword is present");
		inputbox1.clear();
		inputbox1.sendKeys(pwd);
		Log.info("Enter the Password-->"+pwd);
		
		WebElement inputbox2 =util.FindElement(EnterConfirmPassword,100);
		//util.isElementPresent(InputBoxMSISDN);
		util.isElementPresent(EnterConfirmPassword);
		Log.info("InputBox Confrim Password is present");
		inputbox2.clear();
		inputbox2.sendKeys(pwd);
		Log.info("Confrim Password-->"+pwd);
	}
	
	@Then("^Validate Cancel and Continue Button is Present in SignUp Page$")
	public void validate_Cancel_Continue_Btn_SignUpPage() throws Exception{
		util.isElementPresent(CancelBTN);
		Log.info("Cancel Button is present");
		String btntext=webdriver.findElement(CancelBTN).getText();
		Log.info("Cancel Button text is-->"+btntext);
		util.isElementPresent(ContinueBTN);
		Log.info("Continue Button is present");
		
	}
	
	@Then("^Click on Continue Button in SignUp Page$")
	public void Click_on_Signup_Continue_BTN() throws Exception {
		util.isElementPresent(ContinueBTN);
		util.safeJavaScriptClick(ContinueBTN);
		Log.info("Click on Continue Button");
		util.GetCurrenturlAndTitle();
	}
	
	
	@Then("^Validate SignUp User \"([^\"]*)\" data from DIAUS DB$")
	public void validate_DM_Task_after_landingPage(String msisdn) throws Exception{
		
		String query_DM = "SELECT TOP 1 *  FROM [OnmoPay_UserManagement_Dev].[dbo].[AspNetUsers] WHERE PhoneNumber='"+msisdn+"'";
		Object ID = null;
		Object email = null;
		Object phoneNumber  =null;
		Object userName  =null;
		Map<String,Object> data=DB_Connection.ConnectSQLServerDB(query_DM,"DIAUS_DB_URL");
		Log.info("User Data for AspNetUsers==>"+data);
		if (data == null || data.isEmpty()) {
			Log.info("User Data is not Created==>");
			Assert.assertTrue(data.isEmpty());
		    } 
		else {
			Log.info("User Entry is Created======>");
			ID=util.GetValue(data,"Id");
			email=util.GetValue(data,"Email");
			phoneNumber=util.GetValue(data,"PhoneNumber");
			userName=util.GetValue(data, "UserName");
			Log.info("User Details UserID==>["+ID+"] and phoneNumber==>["+phoneNumber+"] and email==>["+email+"] and userName is==>"+userName);
		}
	}
	
	
	@Then("^Delete All Signed Users from DIAUS DB$")
	public void delete_All_Signed_Users() throws Exception{
		
		try{
			String query_DM = "DELETE FROM [OnmoPay_UserManagement_Dev].[dbo].[AspNetUsers]";
		Map<String,Object> data=DB_Connection.ConnectSQLServerDB(query_DM,"DIAUS_DB_URL");
		if (data != null) {
			Log.info("User Acconts not Deleted======>");
			Assert.fail("Failed to delete User Accounts.");
		}
		}
	catch(Exception e){
		Log.info("User Accounts Deleted Successfully");
		
	}
	}
	
	
	
	
	@Then("^Validate Access Service and UnSubscribe Button is Present$")
	public void validate_AccessService_UnSubscribe_BTN() throws Exception{
		util.ScrollDown(AccessServiceBTN);
		util.isElementPresent(AccessServiceBTN);
		Log.info("Access Service Button is present");
		String btntext=webdriver.findElement(AccessServiceBTN).getText();
		Log.info("Access Service Button text is-->"+btntext);
		String text=webdriver.findElement(UnsubscribeBTN).getAttribute("value");
		Log.info("UnSubscribe Button valiue-->"+text);
	}

	@Then("^Validate Current Plan Heading and All Active Plan text is Present$")
	public void validate_CurrentPlan_text() throws Exception{
		util.ScrollDown(CurrentPlanHeading);
		util.isElementPresent(CurrentPlanHeading);
		Log.info("Current Plan is present");
		List<WebElement> allText= webdriver.findElements(ActivePlansHeading);
		List<WebElement> allValue= webdriver.findElements(ActivePlansValue);
		for(int i=0;i<allText.size()-1;i++)
		{
			Log.info("Active Plans text-->"+allText.get(i).getText());
			if(i<allValue.size()) {
				Log.info("Active Plans Value-->"+allValue.get(i).getText());
			}
		}
	}
	
	@Then("^Validate Current Active plan Amount with Symbol$")
	public void validate_CurrentActive_paln_Amount() throws Exception{
		util.ScrollDown(AccessServiceBTN);
		util.isElementPresent(ActivePlans);
		String text=webdriver.findElement(ActivePlans).getText();
		Log.info("Currency Symbol -->"+text.substring(0,1));
		Log.info("Current Active plan Amount -->"+text.substring(1));
	}
	
	@Then("^Click on \"([^\"]*)\" Button in MyAccount Page$")
	public void Click_on_AccessService_Unsubscribe_Btn(String btn) throws Exception {
		if(btn.equalsIgnoreCase("Access Service")) {
			util.safeJavaScriptClick(AccessServiceBTN);
			Log.info("Click on Access Service Button");
		}
		if(btn.equalsIgnoreCase("UnSubscribe")) {
			util.safeJavaScriptClick(UnsubscribeBTN);
			Log.info("Click on Unsubscribe Button");
		}
		util.GetCurrenturlAndTitle();
	}
	
	@Then("^Validate My Family is present$")
	public void validate_MyFamily() throws Exception{
		util.isElementPresent(MyFamilyHeading);
		Log.info("My Family Heading is present");
		String text=webdriver.findElement(CreateFamilyAccountText).getText();
		Log.info("CreateFamilyAccount text-->"+text);
	}
	
	@Then("^Enter the Mobile Number \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void Enter_Mobile_PAssword(String mobileNum,String pwd) throws Exception {
		WebElement inputbox1 =util.FindElement(EnterMobileNum,100);
		util.isElementPresent(EnterMobileNum);
		Log.info("InputBox EnterMobileNum is present");
		inputbox1.clear();
		inputbox1.sendKeys(mobileNum);
		Log.info("Enter the Mobile Number-->"+mobileNum);
		
		WebElement inputbox2 =util.FindElement(EnterPassword,100);
		util.isElementPresent(EnterPassword);
		Log.info("InputBox EnterPassword is present");
		inputbox2.clear();
		inputbox2.sendKeys(pwd);
		Log.info("Enter the User Password-->"+pwd);
	}
	
	@Then("^Click on Join Button$")
	public void Click_on_Join_BTN() throws Exception {
		util.isElementPresent(JointBTN);
		util.safeJavaScriptClick(JointBTN);
		Log.info("Click on Joint Button");
		util.GetCurrenturlAndTitle();
	}
}
