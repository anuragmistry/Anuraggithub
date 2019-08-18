package com.onmobile.utils;



import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
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
import org.json.JSONArray;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.onmobile.stepDefinitions.Launcher;


public class Util extends Launcher{
    static WebDriver webDriver=Launcher.getdriver();
	static Logger Log = LogManager.getLogger("test");
	//Store the current selected menu option
	private static String currentMenuSelection = "HOME";
	private static String currentDownloadFile = "DownloadFile";
	private static String currentPortalName = "PortalName";

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
                if(status == false) {
                	System.err.println("Expected String is-->"+actualValue);
                	System.err.println("Failed for String is-->"+expectedValue);
                }
			}
			return status;
		}else {
			System.err.println("Both List Size is not equals Expected-->"+expectedLength+" and Actual-->"+actual.size());
			return status;
		}
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
	 * @Description   :  Click operation with explicit wait (When normal click is not work use this method)
	 ***************************************************************************************/
	public void safeJavaScriptClick(final By Xpath) throws Exception {
		WebElement element = null;
		try {
			element = webDriver.findElement(Xpath);
			if (element.isEnabled() && element.isDisplayed()) {
				Log.info("Element is Present and Display");
				WebDriverWait wait = new WebDriverWait(webDriver,60);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", element);
				Log.info("Clicking on element with using java script click");
			} else {
				Log.info("Unable to click on element"+Xpath);
			}
		} catch (StaleElementReferenceException e) {
			Log.info("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			Log.info("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			Log.info("Unable to click on element "+ e.getStackTrace());
			Log.info("Unable to click on element"+Xpath);
		}
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
	public WebElement sendKeys(final By Xpath, String value) throws Exception {
		WebElement webElement = null;
		int time = 10;
		try {							
			if(waitForXpathToAppear(Xpath, time)) {				
				webElement = webDriver.findElement(Xpath);
				webElement.clear();
				webElement.sendKeys(value);
			} 
		} catch(UnhandledAlertException alert){
			alert.printStackTrace();			
			throw alert;
		} catch(InvalidElementStateException ie){
			ie.printStackTrace();			
			throw ie;
		} catch(Error e) {									
			e.printStackTrace();			
			throw e;
		}
		return webElement;
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
		actions.moveToElement(element).click().build().perform();
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
	//Store the current selected menu option using Getter and setter
	public static String getCurrentMenuSelection() {
		return currentMenuSelection;
	}
	public static void setCurrentMenuSelection(String currentMenuSelection) {
		Util.currentMenuSelection = currentMenuSelection;
	}
	//Store the current download file using Getter and setter
	public static String getCurrentDownloadFile() {
		return currentDownloadFile;
	}
	public static void SetCurrentDownloadFile(String currentDownloadFile) {
		Util.currentDownloadFile = currentDownloadFile;
	}
	
	public static String getCurrentPortalName() {
		return currentPortalName;
	}
	public static void setCurrentPortalName(String currentPortalName) {
		Util.currentPortalName = currentPortalName;
	}
	
	/***************************************************************************************
	 * @Function_Name :  SplitStringAndStoreInMap
	 * @Description   :  Split String based on Dilemiter And Store In Map
	 ***************************************************************************************/
  public static Map<String, List<String>> SplitStringAndStoreInMap(String input) {
	    Map<String, List<String>> map = new LinkedHashMap<>();
	    // You have to split input data with ; dilemiter
	    for (String outer : splitBy(input, ";")) {
	        List<String> inner = splitBy(outer, "@$@"); // for example: outer="ASIA@$@INDIA::TAILANDIA::RUSIA"
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
	
	public boolean isElementDisappear(By xpath) throws Exception {
		boolean status=true;
		try {
			webDriver.findElement(xpath).isDisplayed();
			status=false;
		 }catch (Exception e) {
			System.err.println("Return true if Element is not Present");
			status=true;
		}
		return status;
	}
	
	public static boolean WaitForDownloadFile(String downloadPath,String fileName) throws Exception{
		File dir = new File(downloadPath);

		boolean flag = false;
		for (int i = 0; i < 100; i++)
		{
			if(dir.listFiles().length != 1 || dir.listFiles()[0].getName().startsWith(fileName)) {
			    flag = true;
				break; 
				
			} 
			Thread.sleep(1000);
		}
		return flag;
		
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
	 * @Description   : Wait for element to appear
	 ***************************************************************************************/
	public boolean isElementPresent(By element) {
		WebElement webElement = null;
		try {
			webElement = FindElement(element,50);
			webElement.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		} catch(InvalidElementStateException ignored) {
			return false;
		}catch(StaleElementReferenceException ignored) {
			return false;
		}catch (TimeoutException e) {
			throw new TimeoutException("Element is not Displayed", e);
		}catch (Exception e) {
			Log.info("Exception occured<br></br>" + e.getStackTrace());
			return false; 
		}

	}
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
	public WebElement FindElement(By by, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds);
		wait.until( ExpectedConditions.presenceOfElementLocated(by) ); //throws a timeout exception if element not present after waiting <timeoutInSeconds> seconds
		return webDriver.findElement(by);
	}
	
	public static boolean GetJSONData_POST(String apiUrl)throws Exception{ 
		Boolean status=false;
		String output="";
		String tp;
		BufferedReader reader=null;
		URL url = new URL(apiUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		try {
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
		conn.setRequestProperty("Accept", "application/json");
		conn.setConnectTimeout(40000);
		conn.setReadTimeout(40000);

		System.err.println("Response Message=>["+conn.getResponseMessage()+"] and HTTP Response Code is : "+conn.getResponseCode());	
		if (conn.getResponseCode() ==200) {

		reader = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		status=true; 
		System.err.println("Number is successfully deactivated");
		}

		if (conn.getResponseCode()==400) {

		reader = new BufferedReader(new InputStreamReader((conn.getErrorStream()), Charset.forName("UTF-8")));
		status=true;
		System.err.println("Number is Allready deactivated");
		}

		while ((tp = reader.readLine()) != null) {
		output=output+tp;
		}
		JSONObject jobj = new JSONObject(output);
		System.out.println(jobj);


		conn.disconnect();



		}catch(Exception e){
		System.out.println("Exception"+e); 
		System.err.println("Failed : HTTP error code : " + conn.getResponseCode());
		status=false; 
		}
		return status;
		}
	
/*	public static boolean GetJSONData(String apiUrl)throws  Exception{  
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
		    
		    System.out.println("Response Message=>"+conn.getResponseMessage());
		    
			if (conn.getResponseCode() ==200 || conn.getResponseCode()==400) {
				
			    BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				String output="";
				String tp;

				while ((tp = br.readLine()) != null) {
					output=output+tp;
				}
				
				//Get the data and Print
				JSONObject jobj = new JSONObject(output);
				System.out.println(jobj);
				System.err.println("HTTP Response Code is : "+conn.getResponseCode());
				conn.disconnect();
				
				System.err.println("Number is deactivate or Allready deactivated");
		        status=true;    
			}
			    

		}catch(Exception e){
			System.out.println("Exception"+e);  
			System.err.println("Failed : HTTP error code : " + conn.getResponseCode());
			status=false;    
		}
		return status;
		
	}*/
	
	public void GetCurrenturlAndTitle() throws Exception{
		waitForLoad(webDriver);
		String currentURL=webDriver.getCurrentUrl();
		Log.info("Fetch teh Current Page url is-->"+currentURL);
		String homeTitle = webDriver.getTitle();
		Log.info("Current Page Title-->"+homeTitle);
	}
	
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
/*	public static Set<Cookie> getCookieValue() throws InterruptedException {

        Set<Cookie> totalCookies = webDriver.manage().getCookies();
		System.out.println("Total Number Of cookies : " +totalCookies.size());
        return totalCookies;
    }*/
	public static Set<Cookie> getCookieValue() throws InterruptedException {

        Set<Cookie> totalCookies = webDriver.manage().getCookies();
        Log.info("Total Number Of cookies : " +totalCookies.size());
        for (Cookie currentCookie : totalCookies) {
        	Log.info(String.format("%s -> %s -> %s", "Domain Name : "+currentCookie.getDomain(), "Cookie Name : "+currentCookie.getName(), "Cookie Value : "+currentCookie.getValue()));
		  }
		return totalCookies;
    }
	
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
	
	
	
	/********************************************************************************************
	 * @Function_Name :  SplitString
	 * @Description   :Split String and Store as Key value pair in Map
	 ***************************************************************************************/
	public  Map<String,String> SplitString(String inputString)
	{
		Map<String,String> map = new LinkedHashMap<>();
		String key=null;
		String value=null;
		// You have to split input data with & dilemiter
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
	 * @Function_Name :  SplitStringComma
	 * @Description   :Split String based on comma seprator and Store as Key value pair in Map
	 ***************************************************************************************/
	public  Map<String,String> SplitStringComma(String inputString)
	{
		Map<String,String> map = new LinkedHashMap<>();
		String key=null;
		String value=null;
		// You have to split input data with & dilemiter
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

}
