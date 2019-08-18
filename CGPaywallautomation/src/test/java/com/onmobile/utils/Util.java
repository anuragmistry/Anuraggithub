package com.onmobile.utils;



import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FilenameUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.onmobile.stepDefinitions.Launcher;


public class Util extends Launcher{
    static WebDriver webDriver=Launcher.getdriver();
	static Logger Log = LogManager.getLogger("test");
    By temp; 

	/***************************************************************************************
	 * @Function_Name :  ComparetoListvalue
	 * @Description   :  Compare 2 list of String and return boolean
	 ***************************************************************************************/
	public boolean ComparetoListvalue(List<String>actual,List<String>expected){
		boolean status = false;
		int expectedLength = expected.size();
		if (expectedLength == actual.size()) {
			for (int i = 0 ; i < expectedLength ; i++) {
				String actualValue=actual.get(i).trim();
				String expectedValue=expected.get(i).trim();

				status=actualValue.equalsIgnoreCase(expectedValue);

			}
		}
		return status;
	}
	/***************************************************************************************
	 * @Function_Name :  CheckImage
	 * @Description   :  Validate Image is loaded in GUI using javascriptExecuter
	 ***************************************************************************************/
	public void CheckImage(By xpath) throws Exception {
		Thread.sleep(1000);
		WebElement ImageFile = webDriver.findElement(xpath);
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor)webDriver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
		if (!ImagePresent)
		{
			System.out.println("Image is not loaded in UI.");
		}
		else
		{
			System.out.println("Image is loaded in UI.");
		}
	}


	/***************************************************************************************
	 * @Function_Name :  checkLinks
	 * @Description   :  Validate all  links
	 ***************************************************************************************/

	public Boolean checkLinks(WebElement Im, String MarkerForRelativeUrls) {
		int Response = 0;
		String Source = "";
		try {
			Source = Im.getAttribute("src");
			if (Source.equals("#"))
				return false;
			if (Source.startsWith(MarkerForRelativeUrls)) {
				String BaseUrl = new URL(webDriver.getCurrentUrl()).getHost();
				Source = BaseUrl + Source;
			}
			HttpURLConnection Connect = (HttpURLConnection) (new URL(Source)).openConnection();
			Response = Connect.getResponseCode();
			System.out.println("Responsecode: " + Response);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (!((Response + "").startsWith("4") || (Response + "").startsWith("5"))) {
			System.out.println("Valid Source:" + ((Source == null) ? "null" : Source));
			return true;
		} else {
			System.out.println("Invalid Source:" + ((Source == null) ? "null" : Source));
			return false;
		}
	}
	/***************************************************************************************
	 * @Function_Name :  safeJavaScriptClick
	 * @Description   :  Click operation with explicit wait and JavascriptExecutor
	 ***************************************************************************************/
	public void safeJavaScriptClick(final By Xpath) throws Exception {
		WebElement element = null;
		try {
			element = webDriver.findElement(Xpath);
			if (element.isEnabled() && element.isDisplayed()) {
				System.err.println("Clicking on element with using java script click");
				WebDriverWait wait = new WebDriverWait(webDriver,60);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", element);
			} else {
				System.err.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.err.println("Element is not attached to the page document "+ e.getStackTrace());
			Assert.fail("Element is not attached to the page document");
		} catch (NoSuchElementException e) {
			System.err.println("Element was not found in DOM "+ e.getStackTrace());
			Assert.fail("Element was not found in DOM");
		} catch (Exception e) {
			System.err.println("Unable to click on element "+ e.getStackTrace());
			Assert.fail("Unable to click on element");
		}
	}
	
	
	/***************************************************************************************
	 * @Function_Name :  sendKeysValue
	 * @Description   :  Enter the value in textbox using Sendkeys
	 ***************************************************************************************/
	public WebElement sendKeysValue(final By Xpath, String value) throws Exception {
		WebElement webElement = null;
		int time = 20;
		try {							
			if(waitForXpathToAppear(Xpath, time)) {				
				webElement = webDriver.findElement(Xpath);
				webElement.clear();
				webElement.sendKeys(value);
			} else {
				throw new Exception() {
					private static final long serialVersionUID = 1L;
					public String getMessage() {
						return "Could not find element with xPath: " + Xpath;
					}
				};
			}
		} catch(UnhandledAlertException alert){
	       alert.printStackTrace();			

		} catch(NoSuchElementException e) {
			e.printStackTrace();			
		} catch(Exception e) {

		}
		return webElement;
	}
	/***************************************************************************************
	 * @Function_Name :  waitForXpathToAppear
	 * @Description   :  Wait for element with specific time
	 ***************************************************************************************/
	public boolean waitForXpathToAppear(By xpath,int Timeout){
		int iCount = Timeout, I = 0;

		try {
			Thread.sleep(1000);
		} catch (Exception e) {

		}
		while (I < iCount) {
			try {
				//System.out.println("Inside Wait for XPath");
				webDriver.findElement(xpath);
				try {
					Thread.sleep(1000);
				} catch (Exception e) {

				}

				return true;
			} catch (Exception t) {
				I++;
				continue;
			}

		}
		return false;
	}
	/***************************************************************************************
	 * @Function_Name :  waitForElementToAppear
	 * @Description   :  Wait for element with explicitly wait
	 ***************************************************************************************/
	public boolean waitForElementToAppear(By locator) throws Exception{
		try{
			WebDriverWait wait = new WebDriverWait(webDriver,60);
			//	wait.until(ExpectedConditions.invisibilityOfElementLocated(PageLoadingImg));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			wait.until(ExpectedConditions.elementToBeClickable(locator));	
		}catch(Exception e){
			throw e;
		}
		return true;
	}

	/***************************************************************************************
	 * @Function_Name :  getOptionValue
	 * @Description   :  Get the multiple web-element value and return as String type list
	 ***************************************************************************************/
	public List<String> getOptionValue(By xpath) throws Exception {
		waitForXpathToAppear(xpath, 20);
		List<String> OutPutText=new ArrayList<String>();
		List<WebElement> value = webDriver.findElements(xpath);
		for (WebElement ele: value) {
			if(ele.isDisplayed()){
				OutPutText.add(ele.getText());
			}
		}
		return OutPutText;

	}
	/***************************************************************************************
	 * @Function_Name :  check_dimensions
	 * @Description   :  Validate Image dimension and return type boolean
	 ***************************************************************************************/
	public boolean check_dimensions(WebElement element,String dimension) throws Exception{

		//  WebElement element = webDriver.findElement(xpath);
		Dimension elementdimensions = element.getSize();
		Log.info("Fetch the Acutal UI Element Dimension"+elementdimensions);
		String[] dim=dimension.split("X");
		float height = 0;
		float width = 0;
		for(int i=0;i<=dim.length;i++) {
			height = Float.valueOf(dim[0]);
			width= Float.valueOf(dim[1]);
		}


		//Read dimension input from excel for specific module/web element
		//Split height and width and assign to integer variables
		//int h=44,w=302;

		//Compare with elementdimensions.height and elementdimensions.width
		Log.info("Actual UI Element dimensions " + "Height :" + elementdimensions.height + " Width : "+ elementdimensions.width);

		Log.info("Expected dimensions from Test Data" + " Height :" + height + " Width : "+ width);

		if((height==elementdimensions.height) && (width==elementdimensions.width)) {
			Log.info("Dimension is Matching PASS: "+elementdimensions.height+" X "+elementdimensions.width);
			return true;
		} else {
			Log.info("Dimension is NOT Matching FAILED: "+elementdimensions.height+" X "+elementdimensions.width);
			return false;
		}
	}
	/***************************************************************************************
	 * @throws Exception 
	 * @Function_Name :  ScrollDown
	 * @Description   :  Scroll down based on xpath position
	 ***************************************************************************************/
	public void ScrollDown(final By Xpath) throws Exception {
		try {
			WebElement Element =FindElement(Xpath,60);
			int y = Element.getLocation().getY();
			JavascriptExecutor js = (JavascriptExecutor)webDriver;
			js.executeScript("window.scrollTo(0,"+y+")");
			Thread.sleep(1000);
			Log.info("Scroll down");
		} catch (Exception e) {
			Log.info("Exception occured<br></br>" + e.getStackTrace());
			System.err.println("Element is not present in UI");
		}

	}
	/***************************************************************************************
	 * @Function_Name :  ScrollDown
	 * @Description   :  Scroll down based on xpath position
	 ***************************************************************************************/
	public void ScrollDown(WebElement element) throws InterruptedException {
		int y = element.getLocation().getY();
		JavascriptExecutor js = (JavascriptExecutor)webDriver;
		js.executeScript("window.scrollTo(0,"+y+")");
		Thread.sleep(1000);
		Log.info("Scroll down");

	}
	/***************************************************************************************
	 * @Function_Name :  ScrollDown
	 * @Description   :  Scroll down with pixel size
	 ***************************************************************************************/
	public void ScrollDownUsingPixel(int val) throws InterruptedException{
		((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0,"+val+")");
	}
	/***************************************************************************************
	 * @Function_Name :  modifyXpath
	 * @Description   :  Replace the "replaceMe" String with value and make a Xpath
	 ***************************************************************************************/
	public By modifyXpath (By element, String substitutionValue ) {		
		String xpath = element.toString();
		xpath = xpath.substring(10);
		xpath = xpath.replace("replaceMe", substitutionValue);

		return By.xpath(xpath);
	}
	
	/***************************************************************************************
	 * @Function_Name :  waitForLoad
	 * @Description   :  wait for Page Load 
	 ***************************************************************************************/
	public void waitForLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new
				ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(pageLoadCondition);
	}

	/***************************************************************************************
	 * @Function_Name :  GotoPageEnd
	 * @Description   :  Navigate to end of the page
	 ***************************************************************************************/
	public void GotoPageEnd() {
		Actions actions = new Actions(webDriver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();

	}
	/***************************************************************************************
	 * @Function_Name :  GotoHomePage
	 * @Description   :  Navigate to start of the page
	 ***************************************************************************************/
	public void GotoHomePage() {
		Actions actions = new Actions(webDriver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
	}
	/***************************************************************************************
	 * @Function_Name :  ActionsClick
	 * @Description   :  Mouse hover on element and click
	 ***************************************************************************************/
	public void ActionsClick(final By Xpath) throws Exception{
		WebElement element = webDriver.findElement(Xpath);
		Actions actions = new Actions(webDriver);
		Thread.sleep(500);
		actions.moveToElement(element).click().perform();
	}
	/***************************************************************************************
	 * @Function_Name :  HoverOperation
	 * @Description   :  Normal mouse hover on element
	 ***************************************************************************************/
	public void HoverOperation(By Xpath) throws Exception {
		WebElement element = webDriver.findElement(Xpath);
		Actions builder = new Actions(webDriver);
		Thread.sleep(500);
		Actions hover= builder.moveToElement(element);
		hover.build().perform();
	}
	/***************************************************************************************
	 * @Function_Name :  ConvertintoSec
	 * @Description   :  Convert mm:ss to sec
	 ***************************************************************************************/
	public int ConvertintoSec(String time) throws Exception {
		String[] units = time.split(":"); //will break the string up into an array
		int minutes = Integer.parseInt(units[0]); //first element
		int seconds = Integer.parseInt(units[1]); //second element
		int duration = 60 * minutes + seconds; //add up our values
		return duration;
	}
	/***************************************************************************************
	 * @Function_Name :  deleteAllCookies
	 * @Description   :  delete All Cookies
	 ***************************************************************************************/
	public void deleteAllCookies() {
	 webDriver.manage().deleteAllCookies();
	}
	/***************************************************************************************
	 * @Function_Name :  RefreshThePage
	 * @Description   :  Refresh The Page
	 ***************************************************************************************/
	public void RefreshThePage() {
		webDriver.navigate().refresh();
	}
	
	public void ScrollDownOperation(By xpath) throws Exception {
		for(int i=0;i<=25;i++) {
			try {
				webDriver.findElement(xpath).isDisplayed();
				break;
			}catch (Exception e) {
               Robot robot=new Robot();
               robot.keyPress(KeyEvent.VK_DOWN);
               robot.keyRelease(KeyEvent.VK_DOWN);
              
			}
		}
	}

	/***************************************************************************************
	 * @Function_Name :  SplitStringAndStoreInMap
	 * @Description   :  Split String based on Dilemiter And Store In Map
	 ***************************************************************************************/
  public static Map<String, List<String>> SplitStringAndStoreInMap(String input) {
	    Map<String, List<String>> map = new HashMap<>();
	    // You have to split input data with ; dilemiter
	    for (String outer : splitBy(input, ";")) {
	        List<String> inner = splitBy(outer, "-"); // for example: outer="ASIA@$@INDIA::TAILANDIA::RUSIA"
	        // Make sure, you have two inner input-elements
	        if (inner.size() == 2) {
	            String key = inner.get(0); // First element of List = Key[ASIA]
	            String value = inner.get(1); // Second element of List = Value[INDIA::TAILANDIA::RUSIA]
	           /* List<String> Titlelist = new ArrayList<String>(Arrays.asList(value.split("::")));*/
	            List<String> Titlelist=splitBy(value, "||");
	            map.put(key, Titlelist);
	        }
	    }
	    return map;
	}
  
  
  /***************************************************************************************
	 * @Function_Name :  splitBy
	 * @Description   :  split By delimiter
	 ***************************************************************************************/
	private static List<String> splitBy(String toSplit, String delimiter) {
	    List<String> tokens = new ArrayList<>();
	    StringTokenizer tokenizer = new StringTokenizer(toSplit, delimiter);
	    while (tokenizer.hasMoreTokens()) {
	        tokens.add(tokenizer.nextToken());
	    }
	    return tokens;
	}
	/***************************************************************************************
	 * @Function_Name :  GetValuefromMap
	 * @Description   : Pass the Key value if key is match then it return Value of Map Key
	 ***************************************************************************************/
	public static List<String> GetValuefromMap(Map<String, List<String>> map,String key) {
		List<String> values = null;
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			if(key.equalsIgnoreCase(entry.getKey())){
				values = entry.getValue();
				Log.info("Key ["+key+"] and Values = "+values);
			}
			
		}
		return values;
	}
	
	/***************************************************************************************
	 * @Function_Name :  VerifyElementAbsent
	 * @Description   : Pass the Key value if key is match then it return Value of Map Key
	 ***************************************************************************************/
	public boolean verifyElementAbsent(By xpath) throws Exception {
		boolean status = false;
		try {
			String vaule=webDriver.findElement(xpath).getCssValue("visibility");
			if(vaule.equalsIgnoreCase("hidden")) {
				System.out.println("Return true if Element is absent");
				status=true;
			}
		 }catch (NoSuchElementException e) {
			//webDriver.findElement(xpath).isDisplayed();
			System.err.println("Return false if Element Present");
			status=false;
		}
		return status;
	}
	
	/********************************************************************************************
	 * @Function_Name :  Validate_CSS_Properties_Value
	 * @Description   : Validate CSS Properties Value
	 ***************************************************************************************/
	public void Validate_CSS_Properties_Value(WebElement element,String CssPorperties) throws Exception {

		String[] lines = CssPorperties.split("\\s*\\r?\\n\\s*");
		for(String line : lines) {
			String[]CSSpropertiesVal=line.trim().split(":",-1);
			String ExpectedCSSValue=CSSpropertiesVal[1];
			if(ExpectedCSSValue != null && !ExpectedCSSValue.isEmpty()) { 
				String ActualCSSvalue=element.getCssValue(CSSpropertiesVal[0]);
				Log.info("CSS Property [ "+CSSpropertiesVal[0]+" ] and actual Value is [ "+ActualCSSvalue+" ]");
				Log.info("CSS Property [ "+CSSpropertiesVal[0]+" ] and expected Value is [ "+ExpectedCSSValue+" ]");
				try {
				Assert.assertTrue("Compare both value", ExpectedCSSValue.equalsIgnoreCase(ActualCSSvalue));
				Log.info("Compare CSS Property with test Data");
				}catch (Exception e) {
					System.err.println("Failed Compare CSS Property ["+ExpectedCSSValue+"]with test Data");
				}
			}else {
				Log.info("CSS Property [ "+CSSpropertiesVal[0]+" ] and Value is Empty");
			}
		}
	}
    	
	/********************************************************************************************
	 * @Function_Name :  isElementPresent
	 * @Description   : Element is Present in UI 
	 ***************************************************************************************/
	public boolean isElementPresent(By element) {
		WebElement webElement = null;
		try {
			webElement = webDriver.findElement(element);
			webElement.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not Found");
			return false;
		} catch(InvalidElementStateException ignored) {
			Assert.fail("InvalidElementState");
			return false;
		}catch(StaleElementReferenceException ignored) {
			Assert.fail("StaleElementReference Exception");
			return false;
		}catch (TimeoutException e) {
			throw new TimeoutException("Element is not Displayed", e);
		}catch (Exception e) {
			Log.info("Exception occured<br></br>" + e.getStackTrace());
			Assert.fail("Element is not present"); 
			return false;
		}
		

	}
	/********************************************************************************************
	 * @Function_Name :  waitForElementToAppear
	 * @Description   : waitForElementToAppear in UI using fluentWait
	 ***************************************************************************************/
	public  boolean waitForElementToAppear(WebElement element) {
		boolean webElementPresence = false;
		try {
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(webDriver).pollingEvery(2, TimeUnit.SECONDS)
					.withTimeout(60, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.visibilityOf(element));
			if (element.isDisplayed()) {
				webElementPresence= true;
			}
		} catch (TimeoutException toe) {
			Log.info("Timeout waiting for webelement to be present<br></br>" + toe.getStackTrace());
		} catch (Exception e) {
			Log.info("Exception occured<br></br>" + e.getStackTrace());
		}
		return webElementPresence;
	}
	/********************************************************************************************
	 * @Function_Name :  FindElement
	 * @Description   : FindElement in UI using Explicitly wait
	 ***************************************************************************************/
	public WebElement FindElement(By by, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds);
		wait.until( ExpectedConditions.presenceOfElementLocated(by) ); //throws a timeout exception if element not present after waiting <timeoutInSeconds> seconds
		return webDriver.findElement(by);
	}
	/********************************************************************************************
	 * @Function_Name :  GetJSONData
	 * @Description   : GetJSONData for POST Request
	 ***************************************************************************************/
	public static boolean GetJSONData(String apiUrl)throws  Exception{  
		Boolean status=false;
		URL url = new URL(apiUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		try {
			conn.setDoOutput(true);
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			conn.setRequestProperty("Accept", "application/json");
			conn.setConnectTimeout(40000);
		    conn.setReadTimeout(40000);
		    
		    System.out.println("Response Code="+conn.getResponseMessage());
		    BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output="";
			String tp;

			while ((tp = br.readLine()) != null) {
				output=output+tp;
			}
			conn.disconnect();
			//Get the data and Print
			JSONObject jobj = new JSONObject(output);
			System.out.println(jobj);
			System.err.println("HTTP Response Code is : "+conn.getResponseCode());
			if (conn.getResponseCode() ==200 || conn.getResponseCode()==400) {
				
				System.err.println("Number is deactivate or Allready deactivated");
		        status=false;    
			}
			    

		}catch(Exception e){
			System.out.println("Exception"+e);  
			System.err.println("Failed : HTTP error code : " + conn.getResponseCode());
			  status=false;    
		}
		return status;
		
		

	}
	/********************************************************************************************
	 * @Function_Name :  SelectValuefromDropdown
	 * @Description   : Select Valuefrom Dropdown using Select class
	 ***************************************************************************************/
	public void SelectValuefromDropdown(WebElement mySelectElement,String value) throws Exception{
		Select dropdown= new Select(mySelectElement);
		List<WebElement> options = dropdown.getOptions();
		
		dropdown.selectByVisibleText(value);
	}
	/********************************************************************************************
	 * @Function_Name :  GetCurrenturlAndTitle
	 * @Description   : Get Current Page url And Title
	 ***************************************************************************************/
	public void GetCurrenturlAndTitle() throws Exception{
		waitForLoad(webDriver);
		String currentURL=webDriver.getCurrentUrl();
		Log.info("Fetch teh Current Page url is-->"+currentURL);
		String homeTitle = webDriver.getTitle();
		Log.info("Current Page Title-->"+homeTitle);
	}
	/********************************************************************************************
	 * @Function_Name :  GetValue
	 * @Description   : Get the Value Based on Key in Map
	 ***************************************************************************************/
	public Object GetValue(Map<String, Object>map,String key) {
		Object values = null;
		for (Map.Entry<String,Object> entry : map.entrySet()) {
			if(key.equalsIgnoreCase(entry.getKey())){
				values = entry.getValue();
				Log.info("Key ["+key+"] and Values = "+values);
			}
			
		}
		return values;
	}
	/********************************************************************************************
	 * @Function_Name :  getCookieValue
	 * @Description   : get Cookie Value in store in Set
	 ***************************************************************************************/
	public static Set<Cookie> getCookieValue() throws InterruptedException {

        Set<Cookie> totalCookies = webDriver.manage().getCookies();
        Log.info("Total Number Of cookies : " +totalCookies.size());
        for (Cookie currentCookie : totalCookies) {
        	Log.info(String.format("%s -> %s -> %s", "Domain Name : "+currentCookie.getDomain(), "Cookie Name : "+currentCookie.getName(), "Cookie Value : "+currentCookie.getValue()));
		  }
		return totalCookies;
    }
	
	/********************************************************************************************
	 * @Function_Name :  FindStatus
	 * @Description   : Find Status Text in Thank You Page(For Onmobile)
	 ***************************************************************************************/
	public String FindStatus(String s) {
		//String s="The charging is PENDING, you can continue by clicking on the button below.";
		String status ="";
		String[] str=s.split(" ");
		for(String inputString : str) {
			String afterReplace=inputString.replaceAll("[-+.^:,]","");
			if(isUpperCase(afterReplace)) {
				status=inputString;
			}
		}
		return status;
	}
	
	
	public static boolean isUpperCase(String s)
	{
		for (int i=0; i<s.length(); i++)
		{
			if (!Character.isUpperCase(s.charAt(i)))
			{
				return false;
			}
		}
		return true;
	}
	
	
	/********************************************************************************************
	 * @Function_Name :  SplitString
	 * @Description   :Split String and Store as Key value pair in Map
	 ***************************************************************************************/
	public  Map<String,String> SplitString(String inputString)
	{
		Map<String,String> map = new LinkedHashMap<>();
		String key=null;
		String value=null;
		// You have to split input data with & delimeter
		for (String outer : splitBy(inputString, "&")) {
			String[] inner=outer.split("=");
           try {
			key = inner[0];   // First element is Key ex-STATUS
			value = inner[1];  // Second element is value ex-ACTIVE	 
			
           }catch (Exception e) {
        	   value=null;
		    }
           map.put(key, value);
		}
		return map;
	}
	
	
	/********************************************************************************************
	 * @Function_Name :  SplitStringComma
	 * @Description   :Split String based on comma separator and Store as Key value pair in Map
	 ***************************************************************************************/
	public  Map<String,String> SplitStringComma(String inputString)
	{
		Map<String,String> map = new LinkedHashMap<>();
		String key=null;
		String value=null;
		// You have to split input data with & delimeter
		for (String outer : splitBy(inputString, ",")) {
			String[] inner=outer.split("=");
           try {
			key = inner[0];   // First element is Key ex-STATUS
			value = inner[1];  // Second element is value ex-ACTIVE	 
			
           }catch (Exception e) {
        	   value=null;
		    }
           map.put(key, value);
		}
		return map;
	}
	
	/********************************************************************************************
	 * @Function_Name :  SplitStringSeparator
	 * @Description   :Split String based on passed separator and Store as Key value pair in Map
	 ***************************************************************************************/
	public  Map<String,String> SplitStringSeparator(String inputString,String separator)
	{
		Map<String,String> map = new LinkedHashMap<>();
		String key=null;
		String value=null;
		for (String outer : splitBy(inputString,separator)) {
           try {     	  
        	int index = outer.indexOf("=");
 	   		key = outer.substring(0,index);
			value = outer.substring(index + 1);
			
           }catch (Exception e) {
        	   value=null;
		    }
           map.put(key, value);
		}
		return map;
	}
	
	
	
	
	/********************************************************************************************
	 * @Function_Name :  GetJSONArray
	 * @Description   : Get the API response as JSONArray
	 ***************************************************************************************/
	public JSONObject GetJSONArray(String apiUrl)throws  Exception{  
   	 
		URL url = new URL(apiUrl);
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    conn.setRequestProperty("Accept", "application/json");
	    conn.setConnectTimeout(40000);
	    conn.setReadTimeout(40000);
	  


	    if (conn.getResponseCode() != 200) {
	           throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
	    }

	    BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	    
	    String output="";
	    String tp;
	    
	    while ((tp = br.readLine()) != null) {
	           output=output+tp;
	    }

	    conn.disconnect();
	    //Get the data and Print
	    JSONObject jobj = new JSONObject(output);
	   // JSONArray statData = jobj.getJSONArray("value");
	    
	    System.out.println(jobj);
	    return jobj;   
	
    }
	
	public String GetJSONResponseValue(String apiUrl)throws  Exception{  
	   	 
		URL url = new URL(apiUrl);
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    conn.setRequestProperty("Accept", "application/json");
	    conn.setConnectTimeout(40000);
	    conn.setReadTimeout(40000);
	  
	    
	    if (conn.getResponseCode() != 200) {
	           throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
	    }

	    BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	    
	    String output="";
	    String tp;
	    
	    while ((tp = br.readLine()) != null) {
	           output=output+tp;
	    }

	    conn.disconnect();

	    
	    System.out.println("URL Hit response: "+output);
	    return output;   
	
    }
	
	/********************************************************************************************
	 * @Function_Name :  SelectMultipleValuefromDropdown
	 * @Description   :Select the Multiple Option In Dropdown Box
	 ***************************************************************************************/
	public void SelectMultipleValuefromDropdown(WebElement element,String value) {
		final String[] textOptions = value.split(",");
		final Select dropdown = new Select(element);
		final List<WebElement> options = dropdown.getOptions();
		final Actions builder = new Actions(webDriver);
		final boolean isMultiple = dropdown.isMultiple();
		if (isMultiple) {
			dropdown.deselectAll();
		}
		builder.keyDown(Keys.CONTROL).build().perform();
		for (String textOption : textOptions) {
			for (WebElement option : options) {
				final String optionText = option.getText().trim();
				if (optionText.equalsIgnoreCase(textOption)) {
					if (isMultiple) {
						if (!option.isSelected()) {
							builder.click(option);
						}
					} else {
						option.click();
					}
					break;
				}
			}
		}
		builder.keyUp(Keys.CONTROL).build().perform();
	}
	/********************************************************************************************
	 * @Function_Name :  SelectMultipleValue
	 * @Description   : Select the Multiple Option In Dropdown Box.
	 ***************************************************************************************/
	public void SelectMultipleValue(WebElement element,By xpath,String value) {
		final String[] textOptions = value.split(",");
		Log.info("I want to Select Option in DropDown Box-->"+value);
		final Select dropdown = new Select(element);
		List<String> selectOptions=new ArrayList<String>();
		List<WebElement> options = dropdown.getOptions();
		for (WebElement option : options) {
			selectOptions.add(option.getText().trim());
		}
		Log.info("List of Option Type present in DropDown Box-->"+selectOptions);

		Actions builder = new Actions(webDriver);
		final boolean isMultiple = dropdown.isMultiple();
		if (isMultiple) {
			dropdown.deselectAll();
		}
		for (String textOption : textOptions) {
			if (selectOptions.contains(textOption)) {
				if (isMultiple) {
					temp=modifyXpath(xpath, textOption);
					WebElement ele=webDriver.findElement(temp);
					if (!ele.isSelected()) {
						Action selectobject = builder.moveToElement(ele).click().build();
						selectobject.perform();
					}
				}
				} else {
					Log.info("Expected Option is NOT present in DropDown Box-->"+textOption);
				}


			}

		}
	/********************************************************************************************
	 * @Function_Name :  ClickAndSelectOptionFromDropDown
	 * @Description   : Mouse hover on DropDown box and Select the Option using Action Class 
	 ***************************************************************************************/
	public void ClickAndSelectOptionFromDropDown(By xpath,String value) {
		Actions builder = new Actions(webDriver);
		temp=modifyXpath(xpath,value);
		WebElement ele=webDriver.findElement(temp);
		if (!ele.isSelected()) {
			Action selectobject = builder.moveToElement(ele).click().build();
			selectobject.perform();
		}
	}
	/********************************************************************************************
	 * @Function_Name :  ComparetwoLinkHashMapvalue
	 * @Description   : Compare two Map based on key and Value
	 ***************************************************************************************/
	public boolean ComparetwoLinkHashMapvalue(Map<String,String> actual,Map<String,String> expected){
		boolean status = false;
		if (actual.size() == expected.size()) {
			
			 for( Map.Entry<String,String> entry : actual.entrySet()){
				  String key = entry.getKey();
				  String value = entry.getValue();
				 
				  if(expected.containsKey(key)){
					  Log.info("Key is Present in expected map-"+key);
					  String expectedValue = expected.get(key);
					  Log.info("Compare the actual value-["+value+"] with expected value-["+expectedValue+"]");
					  if(value.equalsIgnoreCase(expectedValue)) {
						  status = true;
					   }else {
						   status = false; 
					   }
				  }else{
					  status = false; 
				  }
				}

		    }else{
		    	 System.out.println("Maps do not have the same size:" + actual.size() + " != " + expected.size());
		    }
		
		
		
		return status;
	   }
	
	
	public static void WaitForDownloadFile(String downloadPath,String fileName) throws Exception{
		File dir = new File(downloadPath);
		for (int i = 0; i < 30; i++)
		{
			if(dir.listFiles().length != 1 || dir.listFiles()[0].getName().startsWith(fileName)) {
				break; 
			} 
			Thread.sleep(1000);
		}
		
	}
	public static File ValidateDownloadFile(String downloadPath){
		File folder = new File(downloadPath);
		File[] listOfFiles = folder.listFiles();                           
		Arrays.sort(listOfFiles, Comparator.comparingLong(File::lastModified));
		for(int i=0;i<listOfFiles.length;i++){
			File file =listOfFiles[i];             
			System.out.printf("File: %s - " + new Date(file.lastModified()) + "\n", listOfFiles[0].getName());
		}
		
		String fileName=listOfFiles[0].getName();
		long filesize=listOfFiles[0].length();
		if(fileName.contains(".")) {
			String extension = fileName.substring(fileName.lastIndexOf("."));
			System.out.println("File Name "+fileName+"\t"+"Extension"+"\t"+extension);
		}
		if(filesize>0){
			System.out.println("Content is present.");
		}else{
			System.out.println("No Content is present.");
		}
		System.out.println("Value is "+folder+"\t"+fileName+"\t"+filesize);
		return folder;
	}
	/* Get the latest file from a specific directory*/
	public static String getLatestFilefromDir(String downloadPath){
		   File dir = new File(downloadPath);
		   File[] files = dir.listFiles();
		   if (files == null || files.length == 0) {
			   return null;
		   }
		   File lastModifiedFile = files[0];
		   for (int i = 1; i < files.length; i++) {
			   if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				   lastModifiedFile = files[i];
			   }
		   }
		   String fileName=lastModifiedFile.getName();
		   long filesize=lastModifiedFile.length();
		   System.out.println("File Name "+fileName+"\t"+"size"+"\t"+filesize);
		   if(fileName.contains(".")) {
			   String extension = fileName.substring(fileName.lastIndexOf("."));
			   System.out.println("File Name "+fileName+"\t"+"Extension"+"\t"+extension);
		   }
		   if(filesize>0){
				System.out.println("Content is present.");
			}else{
				System.out.println("No Content is present.");
			}
		   String fileNameWithOutExt = FilenameUtils.removeExtension(fileName);
		   return fileNameWithOutExt;
	   }
	public static boolean deleteDownloadedFile(String downloadPath) throws IOException{
		File downloadDir =new File(downloadPath);
		if(downloadDir.exists() && downloadDir.isDirectory()){
			for (File file: downloadDir.listFiles()) {
			    if (!file.isDirectory()) file.delete();
			} 
			if(downloadDir.list() != null){
				System.out.println("Files inside download Directory deleted !!");
			}else{
				System.err.println("Files inside download Directory could not be deleted");
			}
		}else{
			System.err.println("download Directory does not Exist.");
		}	
		return true;
	}
	public void verifyimageActive(WebElement imgElement) {
		try {
			System.setProperty("http.proxyHost", "10.9.16.176");
	        System.setProperty("http.proxyPort", "80");
	        System.setProperty("http.proxyUser","asif.choudhury@onmobile.com");
	        System.setProperty("http.proxyPassword","Qwerty@1234");
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imgElement.getAttribute("src"));
			HttpResponse response = client.execute(request);
			// verifying response code he HttpStatus should be 200 if not,
			// increment as invalid images count
			if (response.getStatusLine().getStatusCode() != 200) {
				
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
