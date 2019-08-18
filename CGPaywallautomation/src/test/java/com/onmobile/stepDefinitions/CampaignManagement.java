package com.onmobile.stepDefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.onmobile.utils.Util;
import com.onmobile.xpaths.PortalXpath;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CampaignManagement implements PortalXpath{

	static Logger Log = LogManager.getLogger("test");
	static WebDriver webdriver = Launcher.getdriver();
	Util util=new Util();
	By temp;	

	@Then("^Validate is Onmo Logo Image present$")
	public void validate_OnmoLogo_image() throws Exception{
		util.isElementPresent(Onmo_Logo);
		Log.info("Validate Logo is present");
		util.safeJavaScriptClick(SubmitBTN);
		Log.info("Click on Submit Button");
	}
	@When("^I Click on Add Partner Tab$")
	public void Click_on_Partner_Tab() throws Exception {
		util.safeJavaScriptClick(PartnerTab);
		Log.info("Click on Partner Tab");
	}
	@When("^I Click on Campaigns Tab$")
	public void Click_on_Campaign_Tab() throws Exception {
		util.safeJavaScriptClick(CampaignTab);
		Log.info("Click on Campaigns Tab");
	}
	@When("^I Login as UserName \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void Enter_LogIn_User_PAssword(String userName,String pwd) throws Exception {
		util.sendKeysValue(UserName, userName);
		Log.info("Enter the UserName-->"+userName);
		
        util.sendKeysValue(Password, pwd);
		Log.info("Enter the User Password-->"+pwd);
		
		util.safeJavaScriptClick(SubmitBTN);
		Log.info("Click on Submit Button");
	}
	@Then("^Click on Add Partner Button$")
	public void Click_on_Partner_btn() throws Exception {
		util.isElementPresent(PartnerText);
		Log.info("Validate PartnerText is present");
		util.safeJavaScriptClick(AddPartnerBTN);
		Log.info("Click on Add Partner Button");
		util.GetCurrenturlAndTitle();
		util.isElementPresent(CreatePartnerHeading);
		Log.info("Validate CreatePartnerHeading is present");
	}
	@Then("^Click on Create Campaign Button$")
	public void Click_on_CreateCampaign_btn() throws Exception {
		util.isElementPresent(CampaignText);
		Log.info("Validate CampaignText is present");
		util.safeJavaScriptClick(AddPartnerBTN);
		Log.info("Click on Add Campaign Button");
		util.GetCurrenturlAndTitle();
		util.isElementPresent(CreateCampaignHeading);
		Log.info("Validate Create Campaign Heading is present");
	}
	@Then("^I Validate General Information Label$")
	public void validate_General_Info() throws Exception{
		util.isElementPresent(General_Info);
		Log.info("Validate General_Info label is present");
	}
	
	
	@And("^I Enter the Name \"([^\"]*)\"$")
	public void Enter_Partner_Name(String Name) throws Exception {
		util.sendKeysValue(Input_Name, Name);
		Log.info("Enter the Partner Name-->"+Name);
	}
	@And("^I Enter the Email \"([^\"]*)\"$")
	public void Enter_Partner_Email(String Email) throws Exception {
		util.sendKeysValue(Input_Email, Email);
		Log.info("Enter the Partner Email-->"+Email);
	}
	@And("^I Enter the Phone \"([^\"]*)\"$")
	public void Enter_Partner_Phone(String Phone) throws Exception {
		util.sendKeysValue(Input_Phone, Phone);
		Log.info("Enter the Partner Phone-->"+Phone);
	}
	@And("^I Enter the Company \"([^\"]*)\"$")
	public void Enter_Partner_Company(String Company) throws Exception {
		util.sendKeysValue(Input_Comapny, Company);
		Log.info("Enter the Partner Company-->"+Company);
	}
	@And("^I Enter the AddressLine1 \"([^\"]*)\"$")
	public void Enter_Partner_AddressLine1(String AddressLine1) throws Exception {
		util.sendKeysValue(Input_AddressLine1, AddressLine1);
		Log.info("Enter the Partner AddressLine1-->"+AddressLine1);
	}
	@And("^I Enter the AddressLine2 \"([^\"]*)\"$")
	public void Enter_Partner_AddressLine2(String AddressLine2) throws Exception {
		util.sendKeysValue(Input_AddressLine2, AddressLine2);
		Log.info("Enter the Partner AddressLine1-->"+AddressLine2);
	}
	@And("^I Enter the Partner URL Params \"([^\"]*)\"$")
	public void Enter_Partner_PartnerUrl(String PartnerUrl) throws Exception {
		util.sendKeysValue(Input_PartnerUrl, PartnerUrl);
		Log.info("Enter the Partner PartnerUrl-->"+PartnerUrl);
	}
	
	@Then("^I Validate CallBack Configuration Label$")
	public void validate_CallBack_Config() throws Exception{
		util.ScrollDown(CallBackConfig);
		util.isElementPresent(CallBackConfig);
		Log.info("Validate CallBack label is present");
	}
	
	@And("^I Enter the CallBack URL \"([^\"]*)\"$")
	public void Enter_CallBackUrl(String url) throws Exception {
		util.sendKeysValue(Input_CallBackUrl, url);
		Log.info("Enter the CallBack URL-->"+url);
	}
	
	@And("^I Select the Call Back Option \"([^\"]*)\" from DropDown$")
	public void Select_CallBackOption_Name(String callback) throws Exception {
		WebElement mySelectElement = webdriver.findElement(Select_CallBackType);
		util.SelectValuefromDropdown(mySelectElement,callback);
		Log.info("Select the [ "+callback+" ] CallBack");
	}
	@Then("^I Edit the Selected Call Back Option \"([^\"]*)\" from DropDown$")
	public void Edit_CallBack_Option(String callback) throws Exception {
		WebElement mySelectElement = webdriver.findElement(Edit_CallBackType);
		util.SelectValuefromDropdown(mySelectElement,callback);
		Log.info("Select the [ "+callback+" ] CallBack");
	}
	
	@Then("^I Validate Restrictions Label$")
	public void validate_Restriction_Label() throws Exception{
		util.ScrollDown(RestrictionLabel);
		util.isElementPresent(RestrictionLabel);
		Log.info("Validate Restriction label is present");
	}
	
	@And("^I Select the Campaign Type Restrictions \"([^\"]*)\" from DropDown$")
	public void Select_CampaignType_Restriction(String type) throws Exception {
		WebElement mySelectElement = webdriver.findElement(Select_CampaignTypeList);
		util.safeJavaScriptClick(Select_Icon_CampaignType);
		util.SelectMultipleValue(mySelectElement,TypeValue,type);
		Log.info("Selected the [ "+type+" ] Campaign Type");
	}
	
	@And("^I Select the Service WhiteList Type Restrictions \"([^\"]*)\" from DropDown$")
	public void Select_ServiceWhiteList_Restriction(String type) throws Exception {
		WebElement mySelectElement = webdriver.findElement(Select_ProductWhitelist);
		util.safeJavaScriptClick(Select_Icon_ServiceWhitelist);
		util.SelectMultipleValue(mySelectElement,TypeValue,type);
		Log.info("Select the [ "+type+" ] WhiteList Type");
	}
	
	@Then("^I Click on Create Button$")
	public void Click_on_CraeateButton() throws Exception {
		util.safeJavaScriptClick(CreateButton);
		Log.info("Click on Create Button");
		util.GetCurrenturlAndTitle();
	}
	
	@Then("^I Validate Created New Partner \"([^\"]*)\" in Partners Table$")
	public void Validate_Created_NewPartner(String partnerName) throws Exception{
		temp=util.modifyXpath(CreatedPartnerName, partnerName);
		util.isElementPresent(temp);
		Log.info("Validate Created Partner Name is present");
	}
	
	@When("^I Click on \"([^\"]*)\" Edit Button$")
	public void Click_on_EditButton(String partnerName) throws Exception {
		temp=util.modifyXpath(EditPartnerName, partnerName);
		util.safeJavaScriptClick(temp);
		Log.info("Click on Edit Button");
		util.GetCurrenturlAndTitle();
	}
	
	@Then("^I Click on Save Button$")
	public void Click_on_SaveButton() throws Exception {
		util.safeJavaScriptClick(SaveButton);
		Log.info("Click on Save Button");
		util.GetCurrenturlAndTitle();
	}
	
	@When("^I Search \"([^\"]*)\" Key Word$")
	public void Click_on_Search_Key(String searchText) throws Exception {
		WebElement element = util.FindElement(SearchBox,5);
	    element.sendKeys(searchText);
	}
	
	@Then("^I Click on Add CallBack Event Button$")
	public void Click_on_AddEventButton() throws Exception {
		util.safeJavaScriptClick(AddEventButton);
		Log.info("Click on AddEvent Button");
		util.GetCurrenturlAndTitle();
	}
	
	@And("^I Enter the Campaign Name \"([^\"]*)\"$")
	public void Enter_CAmpaign_Name(String Name) throws Exception {
		util.sendKeysValue(Input_CampaignName, Name);
		Log.info("Enter the Campaig Name-->"+Name);
		util.safeJavaScriptClick(BtnCheckCampaignName);
		Log.info("Click on CheckCampaignName Button");


		boolean status=util.isElementPresent(CampaignNameAvailableText);
		if(status==true) {
			Log.info("Validate Campaign Name Available Text is present");
			util.safeJavaScriptClick(OkBTN);
			Log.info("Click on Ok Button");
		}else {
			util.isElementPresent(CampaignNameAlreadyExitText);
			Log.info("Validate Created Partner Name is present");
			util.safeJavaScriptClick(OkBTN);
			Log.info("Click on Ok Button");
			String newname=Name+"_Test";
			util.sendKeysValue(Input_CampaignName, newname);
			Log.info("Enter the Campaig Name-->"+newname);
		}
	}
	
	@And("^I Enter the Promotion Title \"([^\"]*)\"$")
	public void Enter_Promotion_Title(String title) throws Exception {
		util.sendKeysValue(Input_PromotionTitle, title);
		Log.info("Enter the Promotion Title-->"+title);
	}
	@And("^I Enter the Promotion Description \"([^\"]*)\"$")
	public void Enter_Promotion_Descriptio(String desc) throws Exception {
		util.sendKeysValue(Input_PromotionDesc, desc);
		Log.info("Enter the Promotion Descriptio-->"+desc);
	}
	@And("^I Enter the OM Revenue Share \"([^\"]*)\"$")
	public void Enter_OMRevenue(String rev) throws Exception {
		util.sendKeysValue(Input_OMRevenue, rev);
		Log.info("Enter the OM Revenue Share-->"+rev);
	}
	@And("^I Enter the OM Cost Share \"([^\"]*)\"$")
	public void Enter_OM_Cost_Share(String cost) throws Exception {
		util.sendKeysValue(Input_OMCost, cost);
		Log.info("Enter the OM Cost Share-->"+cost);
	}
	@And("^I Select the Service Option \"([^\"]*)\" from DropDown$")
	public void Select_Service_Name(String service) throws Exception {
		WebElement mySelectElement = webdriver.findElement(Select_Service);
		util.SelectValuefromDropdown(mySelectElement,service);
		Log.info("Select the [ "+service+" ] Service Option");
	}
	
	@And("^I Select the Partner Option \"([^\"]*)\" from DropDown$")
	public void Select_Partner_Option(String partner) throws Exception {
		util.safeJavaScriptClick(Select_Partner_Icon);
		util.ClickAndSelectOptionFromDropDown(Select_Option_Value,partner);
		Log.info("Selected the [ "+partner+" ] Partner Option");
	}

	@And("^I Select the Campaign Type Option \"([^\"]*)\" from DropDown$")
	public void Select_CampaignType_Option(String type) throws Exception {
		util.safeJavaScriptClick(Select_CampaignType_Icon);
		util.ClickAndSelectOptionFromDropDown(Select_Option_Value,type);
		Log.info("Select the [ "+type+" ] Campaign Type Option");
	}
	
	@And("^I Enter the Campaign Value Cost \"([^\"]*)\"$")
	public void Enter_Campaign_Cost_VAlue(String cost) throws Exception {
		util.sendKeysValue(Input_CampaignValueCost, cost);
		Log.info("Enter the Campaign Value Coste-->"+cost);
	}
	@And("^I Select the Language Option \"([^\"]*)\" from DropDown$")
	public void Select_Languagee_Option(String type) throws Exception {
		util.ScrollDown(Select_Language_Icon);
		util.safeJavaScriptClick(Select_Language_Icon);
		util.ClickAndSelectOptionFromDropDown(Select_Option_Value,type);
		Log.info("Select the [ "+type+" ] Language Option");
	}
	@And("^I Select the Landing Flow Option \"([^\"]*)\" from DropDown$")
	public void Select_LandingFlow_Option(String type) throws Exception {
		util.safeJavaScriptClick(Select_Landing_Icon);
		util.ClickAndSelectOptionFromDropDown(Select_Option_Value,type);
		Log.info("Select the [ "+type+" ] Landing Flow Option");
	}
	@And("^I Select the PricePoint Option \"([^\"]*)\" from DropDown$")
	public void Select_PricePoint_Option(String type) throws Exception {
		util.safeJavaScriptClick(Select_PricePoint_Icon);
		util.ClickAndSelectOptionFromDropDown(Select_Option_Value,type);
		Log.info("Select the [ "+type+" ] PricePoint Option");
	}
	@And("^I Enter the Banner URL \"([^\"]*)\"$")
	public void Enter_BannerUR_VAlue(String val) throws Exception {
		util.sendKeysValue(Input_BannerURL, val);
		Log.info("Enter the Banner URL-->"+val);
	}
	@And("^I Enter the Generic Redirection URL \"([^\"]*)\"$")
	public void Enter_GenericRedirectionURL_VAlue(String val) throws Exception {
      //	util.ScrollDown(Input_RedirectionURL);
		util.sendKeysValue(Input_RedirectionURL, val);
		Log.info("Enter the Generic Redirection URL-->"+val);
	}
	@And("^I Select the Recur Every Days To Run \"([^\"]*)\" from DropDown$")
	public void Select_Select_DaysToRun_Icon(String type) throws Exception {
		WebElement mySelectElement = webdriver.findElement(Select_DaysToRun);
		util.safeJavaScriptClick(Select_DaysToRun_Icon);
		util.SelectMultipleValue(mySelectElement,TypeValue,type);
		Log.info("Select the [ "+type+" ] Days To Run");
	}
	
	@And("^I Enter Campaign Start and End Date Time \"([^\"]*)\"$")
	public void Enter_Campaign_startTime(String time) throws Exception {
		util.ScrollDown(Campaign_StartDateTime);
		util.safeJavaScriptClick(Campaign_StartDateTime);
		util.sendKeysValue(Campaign_StartDateTime, time);
		Log.info("Enter the Campaign blackout start time-->"+time);
	}
	
	@And("^I Enter Campaign blackout start time \"([^\"]*)\"$")
	public void Enter_Campaign_blackoutstartTime(String time) throws Exception {
		
		util.safeJavaScriptClick(Input_StartTime);
		util.sendKeysValue(Input_StartTime, time);
		Log.info("Enter the Campaign blackout start time-->"+time);
	}
	@And("^I Enter Campaign blackout End time \"([^\"]*)\"$")
	public void Enter_Campaign_blackoutEndTime(String time) throws Exception {
		util.sendKeysValue(Input_EndTime, time);
		Log.info("Enter the Campaign blackout End time-->"+time);
	}
	
	@And("^I Select the Allowed Operating System \"([^\"]*)\" from DropDown$")
	public void Select_Operating_Sysytem_Icon(String type) throws Exception {
		WebElement mySelectElement = webdriver.findElement(Select_SupportedOS);
		util.safeJavaScriptClick(Select_SupportedOS_Icon);
		util.SelectMultipleValue(mySelectElement,TypeValue,type);
		Log.info("Select the [ "+type+" ] Operating System");
	}
	
	@And("^I Select the Allowed Countries \"([^\"]*)\" from DropDown$")
	public void Select_AllowedCountries_Icon(String type) throws Exception {
		WebElement mySelectElement = webdriver.findElement(Select_AllowedCountries);
		util.safeJavaScriptClick(Select_AllowedCountries_Icon);
		util.SelectMultipleValue(mySelectElement,TypeValue,type);
		Log.info("Select the [ "+type+" ] Allowed Countries");
	}
	
	@And("^I Enter Callback Percentage \"([^\"]*)\"$")
	public void Enter_Callback_Percentage(String val) throws Exception {
		util.sendKeysValue(Input_CallbackPercentage, val);
		Log.info("Enter the Callback Percentage-->"+val);
	}
	@And("^I Enter Callback Cap Minutes \"([^\"]*)\"$")
	public void Enter_Callback_Cap_Minutes(String val) throws Exception {
		util.sendKeysValue(Input_CallbackCapMinutes, val);
		Log.info("Enter the Callback Cap Minutes-->"+val);
	}
	
	@And("^I Enter Minimum price for Callback \"([^\"]*)\"$")
	public void Enter_Min_Price_Callback(String val) throws Exception {
		util.sendKeysValue(Input_MinPriceForCallback, val);
		Log.info("Enter the Minimum price for Callback-->"+val);
	}
	
	@Then("^I Validate Capping Configuration Label$")
	public void validate_CappingConfig_Label() throws Exception{
		util.ScrollDown(CappingConfiguration);
		util.isElementPresent(CappingConfiguration);
		Log.info("Validate Capping Configuration label is present");
	}
	
	@And("^I Select the Capping Type Option \"([^\"]*)\" from DropDown$")
	public void Select_CappingType_Name(String option) throws Exception {
		WebElement mySelectElement = webdriver.findElement(Select_CappingType);
		util.SelectValuefromDropdown(mySelectElement,option);
		Log.info("Select the [ "+option+" ] Capping Option");
	}
	@And("^I Select the Capping Action Option \"([^\"]*)\" from DropDown$")
	public void Select_CappingAction_Name(String option) throws Exception {
		WebElement mySelectElement = webdriver.findElement(Select_CampaignCapping_Action);
		util.SelectValuefromDropdown(mySelectElement,option);
		Log.info("Select the [ "+option+" ] Capping Action Option");
	}
	
	@And("^I Enter Capping Count Limit \"([^\"]*)\"$")
	public void Enter_CappingCountLimit(String val) throws Exception {
		util.sendKeysValue(Input_CappingCountLimit, val);
		Log.info("Enter the Capping Count Limit-->"+val);
	}
	
	@And("^I Enter Capping Redirect URL \"([^\"]*)\"$")
	public void Enter_CappingRedirectURL(String val) throws Exception {
		util.sendKeysValue(Input_CappingRedirectURL, val);
		Log.info("Enter the Capping Redirect URL-->"+val);
	}
	
	@Then("^I Validate Campaign URL Label$")
	public void validate_CampaignURL_Label() throws Exception{
		util.ScrollDown(CampaignURL);
		util.isElementPresent(CampaignURL);
		Log.info("Validate Campaign URL label is present");
	}
	
	@And("^I Enter Campaign URL \"([^\"]*)\"$")
	public void Enter_CampaignURL_value(String val) throws Exception {
		String prefix=webdriver.findElement(Prefix_CampaignURL).getAttribute("value");
		Log.info("Fetch prefix Campaign URL from Input Box-->"+prefix);
		util.sendKeysValue(Input_CampaignURL, val);
		Log.info("Enter the Campaign URL-->"+val);
		util.isElementPresent(Btn_CopyClipboard);
		Log.info("Validate Copy Clipboard button is present");
		
	}
	
	@Then("^I Click on CreateCampaign Button$")
	public void Click_on_CreateCampaign() throws Exception {
		util.safeJavaScriptClick(Btn_CreateCampaign);
		Log.info("Click on CreateCampaign Button");
		util.GetCurrenturlAndTitle();
	}
	
	@Then("^I Validate Created New Campaign \"([^\"]*)\" in Campaign Table$")
	public void Validate_Created_NewCampaign(String Name) throws Exception{
		WebElement element = util.FindElement(SearchBox,5);
	    element.sendKeys(Name);
		temp=util.modifyXpath(CreatedPartnerName,Name);
		util.isElementPresent(temp);
		Log.info("Validate Created Campaign Name is present");
	}
	@Then("^I Edit the Selected Campaign Type Option \"([^\"]*)\" from DropDown$")
	public void Edit_CampaignType_Option(String type) throws Exception {
		util.ScrollDown(Edit_Select_CampaignTypeIcon);
		util.safeJavaScriptClick(Edit_Select_CampaignTypeIcon);
		util.ClickAndSelectOptionFromDropDown(Select_Option_Value,type);
		Log.info("Select the [ "+type+" ] Campaign Type");
	}
	
	@Then("^I Edit the Selected Language Option \"([^\"]*)\" from DropDown$")
	public void Edit_CampaignTypeLanguage_Option(String type) throws Exception {
		WebElement mySelectElement = webdriver.findElement(Select_Language_Option);
		util.SelectValuefromDropdown(mySelectElement,type);
		Log.info("Select the [ "+type+" ] Campaign Type");
	}
	
	@Then("^I Edit the Selected Landing Flow Option \"([^\"]*)\" from DropDown$")
	public void Edit_LandingFlow_Option(String type) throws Exception {
		util.safeJavaScriptClick(EditSelect_Landing_Icon);
		util.ClickAndSelectOptionFromDropDown(Select_Option_Value,type);
		Log.info("Select the [ "+type+" ] Landing Flow Option");
	}
	
	@And("^I Edit the Selected Recur Days To Run \"([^\"]*)\" from DropDown$")
	public void Edit_Seletced_DaysToRun_Icon(String type) throws Exception {
		WebElement mySelectElement = webdriver.findElement(Select_DaysToRun);
		util.safeJavaScriptClick(EditSelect_DaysToRun_Icon);
		util.SelectMultipleValue(mySelectElement,TypeValue,type);
		Log.info("Select the [ "+type+" ] Days To Run");
	}
	
	@And("^I Edit Select the Allowed Operating System \"([^\"]*)\" from DropDown$")
	public void EditSelect_Operating_Sysytem_Icon(String type) throws Exception {
		WebElement mySelectElement = webdriver.findElement(Select_SupportedOS);
		util.safeJavaScriptClick(EditSelect_SupportedOS_Icon);
		util.SelectMultipleValue(mySelectElement,TypeValue,type);
		Log.info("Select the [ "+type+" ] Operating System");
	}
	
	@And("^I Edit the Selected Allowed Countries \"([^\"]*)\" from DropDown$")
	public void EditSelect_AllowedCountries_Icon(String type) throws Exception {
		WebElement mySelectElement = webdriver.findElement(Select_AllowedCountries);
		util.safeJavaScriptClick(EditSelect_AllowedCountries_Icon);
		util.SelectMultipleValue(mySelectElement,ReplaceOptionValue,type);
		Log.info("Select the [ "+type+" ] Allowed Countries");
	}
	
	@And("^I Edit the Selected Capping Type Option \"([^\"]*)\" from DropDown$")
	public void EditSelect_CappingType_Name(String option) throws Exception {
		WebElement mySelectElement = webdriver.findElement(EditSelect_CappingType);
		util.SelectValuefromDropdown(mySelectElement,option);
		Log.info("Select the [ "+option+" ] Capping Option");
	}
	@And("^I Edit the Selected Capping Action Option \"([^\"]*)\" from DropDown$")
	public void EditSelect_CappingAction_Name(String option) throws Exception {
		WebElement mySelectElement = webdriver.findElement(EditSelect_CampaignCapping_Action);
		util.SelectValuefromDropdown(mySelectElement,option);
		Log.info("Select the [ "+option+" ] Capping Action Option");
	}
}
