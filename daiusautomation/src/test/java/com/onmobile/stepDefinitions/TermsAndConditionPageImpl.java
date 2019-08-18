package com.onmobile.stepDefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.onmobile.utils.Util;
import com.onmobile.xpaths.PortalXpath;

import cucumber.api.java.en.Then;

public class TermsAndConditionPageImpl implements PortalXpath{
	static Logger Log = LogManager.getLogger("test");
	Util util=new Util();
	
   WebDriver webdriver = Launcher.getdriver();
	/***************************************************************************************
	 * @Function_Name :  validate_terms_condition
	 * @Description   :  validate terms and condition link and click in Subscription page
	 ***************************************************************************************/
   @Then("^Validate terms and condition link text$")
   public void validate_terms_condition() throws Exception {
	   webdriver.findElement(TermsConditionLink).isDisplayed();
	   Log.info("Verify Terms and Condition link is present");
	   String text=webdriver.findElement(TermsConditionLink).getText();
	   Log.info("Terms and Condition link text is-->"+text);
	   
	   String linktext=Launcher.getvaluefromExcelDataMap("TermsAndConditions_TermsConditionLinkText");
	   Assert.assertTrue(text.equalsIgnoreCase(linktext));
	   Log.info("Compare terms and Condition link text with excel data-"+linktext);
   }
   @Then("^Click on Terms and Conditions link$")
   public void Click_On_terms_condition() throws Exception {
	   webdriver.findElement(TermsConditionLink).click();
	   Log.info("Click on Terms Condition Link");
   }
	/***************************************************************************************
	 * @Function_Name :  validate_termsCondition_Page
	 * @Description   : validate terms and condition page
	 ***************************************************************************************/
   @Then("^Validate terms and condition page$")
   public void validate_termsCondition_Page() throws Exception {
	   util.waitForLoad(webdriver);
	   String currentURL=webdriver.getCurrentUrl();
	   Log.info("Fetch teh Current Page url is-->"+currentURL);
	   util.GotoPageEnd();
	   Log.info("Goto Page down");
	   util.GotoHomePage();
	   Log.info("Goto Page up");
	   
   }
}
