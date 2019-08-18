package com.onmobile.stepDefinitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.onmobile.utils.Util;
import com.onmobile.xpaths.PortalXpath;

import cucumber.api.java.en.Then;

public class InternalLinkPageValidation implements PortalXpath{
	
	static Logger Log = LogManager.getLogger("test");
	Util util=new Util();
	By temp;
    WebDriver webdriver = Launcher.getdriver();
	PageConfirmation pageconfirmation=new PageConfirmation();
    @Then("^Validate footer Internal Link Pages$")
    public void footer_InternalLink_Page() throws Exception {
    	String ExpectedInternalLinkAndTitle=Launcher.getvaluefromExcelDataMap("Footer_InternalLinkNameAndTitle");
    	Map<String, List<String>> data = new LinkedHashMap<String, List<String>>();
    	//Fetch the data from excel sheet and Store in Map
    	data= Util.SplitStringAndStoreInMap(ExpectedInternalLinkAndTitle);
    	Log.info("Expected Internal Link are ===>"+ExpectedInternalLinkAndTitle);
    	
    	for (Map.Entry<String, List<String>> entry : data.entrySet()) {
    		String InterLink =entry.getKey();
    		List<String> ExpectedStaticTitle = entry.getValue();
    		System.out.println("Key = " + InterLink);
    		System.out.println("Values = " + ExpectedStaticTitle);

    		util.ScrollDown(FooterSection);
    		Thread.sleep(2000);
    		temp=util.modifyXpath(Footerlink,InterLink);
    		util.safeJavaScriptClick(temp);
    		Log.info("Clicked on Footer link ["+InterLink+"] option");
    		util.waitForLoad(webdriver);
    		Thread.sleep(2000);
    		String currentURL=webdriver.getCurrentUrl();
    		Log.info("Fetch the Current Internal link ["+InterLink+"] Page url is-->"+currentURL);
    		String CurrentPageTitle = webdriver.getTitle();
    		Log.info("Current Internal link ["+InterLink+"] Page Title-->"+CurrentPageTitle);
    		
    		util.isElementPresent(InterNalLinkTermsSection);
    		Log.info("InterNal Link Terms Section is Present");
    		List<String> ActualStaticTitle=util.getOptionValue(InterNalLinkStaticTitle);
    		int num = ActualStaticTitle.size();
    		List<String> StaticParaGraph=util.getOptionValue(InterNalLinkStaticParaGraph);
    		Log.info("Num of ["+StaticParaGraph.size()+"] InterNal Link Static ParaGraph are["+StaticParaGraph+"]");
    		Log.info("Num of ["+num+"] Static title Present and Title are["+ActualStaticTitle+"]");
    	//	Assert.assertTrue("Compare both title list", util.ComparetoListvalue(ExpectedStaticTitle, ActualStaticTitle));
    		Log.info("Compare Expected  Excel test Data ["+ExpectedStaticTitle+"] with Actual Static Title["+ActualStaticTitle+"]");
    		
    		Log.info("Validate Complete Intermnal Link ["+InterLink+"] and Go Back to Home Page");
    		webdriver.navigate().back();
    		pageconfirmation.isHomePage();
    	}
}
}