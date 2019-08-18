package com.onmobile.stepDefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


import com.onmobile.utils.Util;
import com.onmobile.xpaths.PortalXpath;

import cucumber.api.java.en.Then;

public class PageConfirmation implements PortalXpath{

	static Logger Log = LogManager.getLogger("test");
	Util util=new Util();
	
	WebDriver webdriver=Launcher.getdriver();
	private String CurrentPageTitle=webdriver.getTitle();
	private String currentURL=webdriver.getCurrentUrl();

@Then("^Confirm Home Page Navigation$")
public boolean isHomePage() {
	
	try {
		util.waitForLoad(webdriver);
		Thread.sleep(2000);
		currentURL=webdriver.getCurrentUrl();
		Log.info("Fetch the Current Page url-->"+currentURL);
		CurrentPageTitle = webdriver.getTitle();
		Log.info("Current Page Title-->"+CurrentPageTitle);
		
		if(!CurrentPageTitle.contains("Error")) {
			Assert.assertTrue("Find the String in Page title",CurrentPageTitle.contains("Inicio"));
		}
		Log.info("Current page is Home page");
		return true;

		}catch (Exception e) {
			Log.info("Exception occured<br></br>" + e.getStackTrace());
			Log.info("Current page is NOT Home page");
			return false; 
		}	
	}

@Then("^Confirm Search Page Navigation$")
public boolean isSearchPage() {
	
	try {
		util.waitForLoad(webdriver);
		Thread.sleep(2000);
		String CurrentURL=webdriver.getCurrentUrl();
		Log.info("Fetch the Current Page url -->"+CurrentURL);
		String CurrentPageTitle = webdriver.getTitle();
		Log.info("Current Page Title-->"+CurrentPageTitle);
		
		if(!CurrentPageTitle.contains("Error")) {
			Assert.assertTrue("Find the String in Page url",CurrentURL.contains("Search"));
		}else {
			Assert.assertTrue("Find the String in Page title",CurrentPageTitle.contains("Busqueda")||currentURL.contains("Buscar"));
		}
		Log.info("Current page is Search page");
		return true;
		

	}catch (Exception e) {
		Log.info("Exception occured<br></br>" + e.getStackTrace());
		Log.info("Current page is NOT Search page");
		return false; 
	}
}

@Then("^Confirm Subsciption Confirmation Page Navigation$")
public boolean isSubscibeConfirmationPage() {
		
	try {
		util.waitForLoad(webdriver);
		Thread.sleep(2000);
		String CurrentURL=webdriver.getCurrentUrl();
		Log.info("Fetch the Subsciption Confirmation Current Page url -->"+currentURL);
		String CurrentPageTitle = webdriver.getTitle();
		Log.info("Current Page Title-->"+CurrentPageTitle);
		if(!CurrentPageTitle.contains("Error")) {
			Assert.assertTrue("Find the String in Page url",CurrentURL.contains("RedirectReturn")||currentURL.contains("Subscription"));
		}else {
			Assert.assertTrue("Find the String in Page title",CurrentPageTitle.contains("Confirmacion de suscripcion"));
			Log.info("Current page is Subscription confirmation page");
		}
		return true;
		

	}catch (Exception e) {
		Log.info("Exception occured<br></br>" + e.getStackTrace());
		Log.info("Current page is NOT Subscription confirmation page");
		return false; 
	}
}

@Then("^Confirm Gallery Page Navigation$")
public boolean isGalleryPage() {
	try {
		util.waitForLoad(webdriver);
		Thread.sleep(2000);
		String currentURL=webdriver.getCurrentUrl();
		Log.info("Fetch the Current Page url -->"+currentURL);
		String CurrentPageTitle = webdriver.getTitle();
		Log.info("Current Page Title-->"+CurrentPageTitle);
	//	Assert.assertTrue("Find the String in Page url",currentURL.contains("Gallery"));
		Log.info("Current page is Gallery page");
		return true;

	}catch (Exception e) {
		Log.info("Exception occured<br></br>" + e.getStackTrace());
		Log.info("Current page is NOT Gallery page");
		return false; 
	}	
}

@Then("^Confirm Category Page Navigation$")
public boolean isCategoryPage() {
	
	try {
		util.waitForLoad(webdriver);
		Thread.sleep(2000);
		String currentURL=webdriver.getCurrentUrl();
		Log.info("Fetch the Current Page url -->"+currentURL);
		String CurrentPageTitle = webdriver.getTitle();
		Log.info("Current Page Title-->"+CurrentPageTitle);
	//	Assert.assertTrue("Find the String in Page url",currentURL.contains("Home/Category"));
		Log.info("Current page is Categories page");
		return true;

	}catch (Exception e) {
		Log.info("Exception occured<br></br>" + e.getStackTrace());
		Log.info("Current page is NOT Category page");
		return false; 
	}	
}

@Then("^Confirm Preview Page Navigation$")
public boolean isPreviewPage() {
	
	try {
		util.waitForLoad(webdriver);
		Thread.sleep(2000);
		String currentURL=webdriver.getCurrentUrl();
		Log.info("Fetch the Current Page url -->"+currentURL);
		String CurrentPageTitle = webdriver.getTitle();
		Log.info("Current Page Title-->"+CurrentPageTitle);
		
		if(!CurrentPageTitle.contains("Error")) {
			Assert.assertTrue("Find the String in Page title",CurrentPageTitle.contains("Suscripcion"));
		}else {
			Assert.assertFalse("Check Download button is not present",util.isElementPresent(DownLoadButton));
		}
		Log.info("Current page is Preview page");
		return true;

	}catch (Exception e) {
		Log.info("Exception occured<br></br>" + e.getStackTrace());
		Log.info("Current page is NOT Preview page");
		return false; 
	}	
}

@Then("^Confirm MyLocker Page Navigation$")
public boolean isMyLockerPage() {
	
	try {
		util.waitForLoad(webdriver);
		Thread.sleep(2000);
		String currentURL=webdriver.getCurrentUrl();
		Log.info("Fetch the Current Page url -->"+currentURL);
		String CurrentPageTitle = webdriver.getTitle();
		Log.info("Current Page Title-->"+CurrentPageTitle);
		Assert.assertTrue("Find the String in Page url",currentURL.contains("Locker"));
		Log.info("Current page is Locker page");
		return true;

	}catch (Exception e) {
		Log.info("Exception occured<br></br>" + e.getStackTrace());
		Log.info("Current page is NOT Locker page");
		return false; 
	}	
}

@Then("^Confirm Terms and Conditions Page Navigation$")
public boolean isTermsPage() {
	
	try {
		util.waitForLoad(webdriver);
		Thread.sleep(2000);
		String currentURL=webdriver.getCurrentUrl();
		Log.info("Fetch the Current Page url -->"+currentURL);
		String CurrentPageTitle = webdriver.getTitle();
		Log.info("Current Page Title-->"+CurrentPageTitle);
		Assert.assertTrue("Find the String in Page url",currentURL.contains("terms"));
		Log.info("Current page is Terms page");
		return true;

	}catch (Exception e) {
		Log.info("Exception occured<br></br>" + e.getStackTrace());
		Log.info("Current page is NOT Terms page");
		return false; 
	}	
}

@Then("^Confirm Cookie Page Navigation$")
public boolean isCookiePage() {
	
	try {
		util.waitForLoad(webdriver);
		Thread.sleep(2000);
		String currentURL=webdriver.getCurrentUrl();
		Log.info("Fetch the Current Page url -->"+currentURL);
		String CurrentPageTitle = webdriver.getTitle();
		Log.info("Current Page Title-->"+CurrentPageTitle);
		Assert.assertTrue("Find the String in Page Title",CurrentPageTitle.contains("cookies"));
		Assert.assertTrue("Find the String in Page url",currentURL.contains("cookies"));
		Log.info("Current page is Cookies page");
		return true;

	}catch (Exception e) {
		Log.info("Exception occured<br></br>" + e.getStackTrace());
		Log.info("Current page is NOT Cookies page");
		return false; 
	}	
}

@Then("^Confirm App Store Page Navigation$")
public boolean isAppStorePage() {
	
	try {
		util.waitForLoad(webdriver);
		Thread.sleep(2000);
		String currentURL=webdriver.getCurrentUrl();
		Log.info("Fetch the Current App Stor Page url -->"+currentURL);
		String CurrentPageTitle = webdriver.getTitle();
		Log.info("Current Page Title-->"+CurrentPageTitle);
		Assert.assertTrue("Find the String in App Stor Page Title",CurrentPageTitle.contains("Apps on Google Play"));
		Assert.assertTrue("Find the String in App Store Page url",currentURL.contains("store/apps"));
		Log.info("Current page is Google play app page");
		return true;

	}catch (Exception e) {
		Log.info("Exception occured<br></br>" + e.getStackTrace());
		Log.info("Current page is NOT Google play app page");
		return false; 
	}
}

@Then("^Confirm UIM View Page Navigation$")
public boolean isUIMViewPage() {
	
	try {
		util.waitForLoad(webdriver);
		Thread.sleep(2000);
		String currentURL=webdriver.getCurrentUrl();
		Log.info("Fetch the Current uim/view Page url -->"+currentURL);
		String CurrentPageTitle = webdriver.getTitle();
		Log.info("Current Page Title-->"+CurrentPageTitle);
		Assert.assertTrue("Find the String in uim/view Page Title",CurrentPageTitle.contains("Emocion"));
		Assert.assertTrue("Find the String in uim/view Page url",currentURL.contains("uim/view"));
		Log.info("Current page is uim/view page");
		return true;

	}catch (Exception e) {
		Log.info("Exception occured<br></br>" + e.getStackTrace());
		Log.info("Current page is NOT uim/view page");
		return false; 
	}
}

@Then("^Confirm UIM Gateway Page Navigation$")
public boolean isUIMGatewayPage() {
	
	try {
		util.waitForLoad(webdriver);
		Thread.sleep(2000);
		String currentURL=webdriver.getCurrentUrl();
		Log.info("Fetch the Current UIMGateway Page url -->"+currentURL);
		String CurrentPageTitle = webdriver.getTitle();
		Log.info("Current Page Title-->"+CurrentPageTitle);
		Assert.assertTrue("Find the String in UIMGateway Page url",currentURL.contains("Home/UIMGateway"));
		Log.info("Current page is Home/UIMGateway page");
		return true;

	}catch (Exception e) {
		Log.info("Exception occured<br></br>" + e.getStackTrace());
		Log.info("Current page is NOT Home/UIMGateway page");
		return false; 
	}
}

@Then("^Confirm Product Page Navigation$")
public boolean isProductPage() {
	try {
		util.waitForLoad(webdriver);
		Thread.sleep(2000);
		String currentURL=webdriver.getCurrentUrl();
		Log.info("Fetch the Current Page url -->"+currentURL);
		String CurrentPageTitle = webdriver.getTitle();
		Log.info("Current Page Title-->"+CurrentPageTitle);
		Assert.assertTrue("Find the String in Page url",currentURL.contains("Product"));
		Log.info("Current page is Product page");
		return true;

	}catch (Exception e) {
		Log.info("Exception occured<br></br>" + e.getStackTrace());
		Log.info("Current page is NOT Product page");
		return false; 
	}	
}

@Then("^Confirm Legal Advise Page Navigation$")
public boolean isLegalPage() {
	
	try {
		util.waitForLoad(webdriver);
		Thread.sleep(2000);
		String currentURL=webdriver.getCurrentUrl();
		Log.info("Fetch the Current Page url -->"+currentURL);
		String CurrentPageTitle = webdriver.getTitle();
		Log.info("Current Page Title-->"+CurrentPageTitle);
		Assert.assertTrue("Find the String in Page Title",CurrentPageTitle.contains("legal"));
		Assert.assertTrue("Find the String in Page url",currentURL.contains("legal"));
		Log.info("Current page is Legal page");
		return true;

	}catch (Exception e) {
		Log.info("Exception occured<br></br>" + e.getStackTrace());
		Log.info("Current page is NOT Legal page");
		return false; 
	}	
}

@Then("^Confirm Help Page Navigation$")
public boolean isHelpPage() {
	
	try {
		util.waitForLoad(webdriver);
		Thread.sleep(2000);
		String currentURL=webdriver.getCurrentUrl();
		Log.info("Fetch the Current Page url -->"+currentURL);
		String CurrentPageTitle = webdriver.getTitle();
		Log.info("Current Page Title-->"+CurrentPageTitle);
		Assert.assertTrue("Find the String in Page Title",CurrentPageTitle.contains("ayuda"));
		Assert.assertTrue("Find the String in Page url",currentURL.contains("ayuda"));
		Log.info("Current page is Movistar Help page");
		return true;

	}catch (Exception e) {
		Log.info("Exception occured<br></br>" + e.getStackTrace());
		Log.info("Current page is NOT Movistar Help page");
		return false; 
	}	
}

@Then("^Confirm My Subscriptions Page Navigation$")
public boolean isMySubscriptionsPage() {
	
	try {
		util.waitForLoad(webdriver);
		Thread.sleep(2000);
		String currentURL=webdriver.getCurrentUrl();
		Log.info("Fetch the Current Page url -->"+currentURL);
		String CurrentPageTitle = webdriver.getTitle();
		Log.info("Current Page Title-->"+CurrentPageTitle);
		Assert.assertTrue("Find the String in Page Title",CurrentPageTitle.contains("Mis compras y suscripciones"));
		Assert.assertTrue("Find the String in Page url",currentURL.contains("micuentamovil"));
		Log.info("Current page is MySubscriptions page");
		return true;

	}catch (Exception e) {
		Log.info("Exception occured<br></br>" + e.getStackTrace());
		Log.info("Current page is NOT MySubscriptions page");
		return false; 
	}
}

@Then("^Confirm Service presentation Page Navigation$")
public boolean isServicePresentationPage() {
	
	try {
		util.waitForLoad(webdriver);
		Thread.sleep(2000);
		String currentURL=webdriver.getCurrentUrl();
		Log.info("Fetch the Current Page url -->"+currentURL);
		String CurrentPageTitle = webdriver.getTitle();
		Log.info("Current ServicePresentation Title-->"+CurrentPageTitle);
		Assert.assertTrue("Find the String in Page Title",CurrentPageTitle.contains("Presentacion y suscripcion"));
		Assert.assertTrue("Find the String in Page url",currentURL.contains("servicio"));
		Log.info("Current page is Service Presentation Page");
		return true;

	}catch (Exception e) {
		Log.info("Exception occured<br></br>" + e.getStackTrace());
		Log.info("Current page is NOT Service Presentation Page");
		return false; 
	}

}
}
