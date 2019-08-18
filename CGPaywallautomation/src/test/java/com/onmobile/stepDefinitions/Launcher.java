package com.onmobile.stepDefinitions;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.onmobile.dataProvider.ExcelReader;
import com.onmobile.dataProvider.PropertyReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Launcher {

	static WebDriver driver = null;
	// public static PropertyReader CFR;
	static Logger Log = LogManager.getLogger("test");

	public static LinkedHashMap<String, String> datamap;

	@Given("^Launch the browser$")
	public void launch_the_browser() throws Exception {

		// Load All the property at once and access in all project
		PropertyReader.loadAllProperties();

		String browserType = PropertyReader.readItem("browser");
		String downloadfolder = PropertyReader.readItem("Download_Folder_PATH");

		if (browserType.equalsIgnoreCase("Chrome")) {

			String t = PropertyReader.readItem("CHROMEEXT");
			System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + downloadfolder);

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addExtensions(new File(t));
			options.addArguments("window-size=1360,768");
			options.addArguments("disable-infobars");
			options.addArguments("--dns-prefetch-disable");

			driver = new ChromeDriver(options);

			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		}
		Log.info("Launching the [" + browserType + "] Browser");

	}

	/***************************************************************************************
	 * @Function_Name : set_headers
	 * @Description : Set the Browser plugIn(Modify Header) and pass the user
	 *              type as a argument
	 ***************************************************************************************/
	@Given("^Set the Headers with \"([^\"]*)\" IP range \"([^\"]*)\"$")
	public void set_headers(String Operator, String IP_Range) throws Throwable {

		driver.get("chrome-extension://innpjfdalfhpcoinfnehdnbkglpmogdi/options.html");
		driver.navigate().refresh();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@tooltip='Add New']")).click();

		WebElement actionElem = driver.findElement(By.name("action"));
		Select select = new Select(actionElem);
		select.selectByVisibleText("Add");

		WebElement nameElem = driver.findElement(By.name("name"));
		nameElem.sendKeys("User-Agent");

		WebElement valueElem = driver.findElement(By.name("value"));
		// valueElem.sendKeys("Mozilla/5.0 (Linux; Android 6.0.1; SM-G800F
		// Build/MMB29K) AppleWebKit/537.36 (KHTML, like Gecko)
		// Chrome/59.0.3071.125 Mobile Safari/537.36");
		valueElem.sendKeys(PropertyReader.readItem("USER-AGENT"));
		WebElement descElem = driver.findElement(By.name("description"));
		descElem.sendKeys("Add user agent for portal");
		Log.info("Add User Agent..........");
		driver.findElement(By.xpath("//button[@tooltip='Save']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@tooltip='Add New']")).click();

		WebElement actionElem1 = driver.findElement(By.name("action"));
		Select select1 = new Select(actionElem1);
		select1.selectByVisibleText("Add");

		WebElement nameElem1 = driver.findElement(By.name("name"));
		nameElem1.sendKeys("x-forwarded-for");

		WebElement valueElem1 = driver.findElement(By.name("value"));

		valueElem1.sendKeys(IP_Range);

		WebElement descElem1 = driver.findElement(By.name("description"));
		descElem1.sendKeys("Add the [" + Operator + "] IP range");
		Log.info("Add the [" + Operator + "] IP range--->" + IP_Range);

		driver.findElement(By.xpath("//button[@id='btn_save_2']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@tooltip='Start Modifying Headers']")).click();
		Thread.sleep(2000);

//		driver.findElement(By.xpath("//button[@tooltip='Enable All']")).click();
//		Thread.sleep(500);
//		driver.findElement(By.xpath("//button[text()='Yes']")).click();
		
		driver.findElement(By.xpath("//button[@tooltip='Enable']")).click();
		driver.findElement(By.xpath("//button[@id='btn_enable_2']")).click();

	}
	

	@Given("^Set the Headers with User Agent$")
	public void set_headers_with_User_Agent() throws Throwable {

		driver.get("chrome-extension://innpjfdalfhpcoinfnehdnbkglpmogdi/options.html");
		driver.navigate().refresh();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@tooltip='Add New']")).click();

		WebElement actionElem = driver.findElement(By.name("action"));
		Select select = new Select(actionElem);
		select.selectByVisibleText("Add");

		WebElement nameElem = driver.findElement(By.name("name"));
		nameElem.sendKeys("User-Agent");

		WebElement valueElem = driver.findElement(By.name("value"));

		valueElem.sendKeys(PropertyReader.readItem("USER-AGENT"));
		WebElement descElem = driver.findElement(By.name("description"));
		descElem.sendKeys("Add user agent for portal");

		driver.findElement(By.xpath("//button[@tooltip='Save']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@tooltip='Start Modifying Headers']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@tooltip='Enable']")).click();

	}

	@Given("^Set \"([^\"]*)\" with \"([^\"]*)\" in Header$")
	public void Set_MSISDN_headers(String requestHaederName, String msisdn) throws Throwable {

		driver.findElement(By.xpath("//button[@tooltip='Add New']")).click();

		WebElement actionElem = driver.findElement(By.name("action"));
		Select select = new Select(actionElem);
		select.selectByVisibleText("Add");

		WebElement nameElem = driver.findElement(By.name("name"));
		if (requestHaederName.equalsIgnoreCase("x-up-subno")) {
			nameElem.sendKeys("x-up-subno");
		}
		if (requestHaederName.equalsIgnoreCase("x-msisdn")) {
			nameElem.sendKeys("x-msisdn");
		}
		WebElement valueElem = driver.findElement(By.name("value"));

		valueElem.sendKeys(msisdn);

		WebElement descElem = driver.findElement(By.name("description"));
		descElem.sendKeys("Add user " + requestHaederName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='btn_save_2']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='btn_enable_2']")).click();
	}

	
	@Given("^Open New Tab and remove entry \"([^\"]*)\" in Mod Header$")
	public void Remove_entry_From_ModHeader(String entryindex) throws Throwable {

		String mainTab = Launcher.Open_New_Tab();
		Log.info("Open The New Tab");
		//Stop Modify header if no header present
		if (entryindex.equalsIgnoreCase("1"))
			driver.findElement(By.xpath("//button[@tooltip='Stop Modifying Headers']")).click();
		
		// webdriver.findElement(By.xpath("//button[@id='btn_delete_3']")).click();
		driver.findElement(By.xpath("//button[@id='btn_delete_" + entryindex + "']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Yes']")).click();
		Thread.sleep(1000);
		Log.info("Deleted entry" + entryindex + " from Mod Header.");

		// Close the new window if that window no more required
		driver.close();

		driver.switchTo().window(mainTab);
		Log.info("Switch to the Main Tab");
		Log.info(driver.getTitle());
		driver.manage().deleteAllCookies();
		Log.info("Successfully Remove the entry - " + entryindex);
	}
	
	
	@Given("^Open New Tab and remove the Number \"([^\"]*)\" in Mod Header$")
	public void Remove_Num_From_ModHeader(String number) throws Throwable {

		String mainTab = Launcher.Open_New_Tab();
		Log.info("Open The New Tab");
		driver.findElement(By.xpath("//button[@id='btn_delete_3']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Yes']")).click();
		Thread.sleep(1000);

		// Close the new window if that window no more required
		driver.close();

		driver.switchTo().window(mainTab);
		Log.info("Switch to the Main Tab");
		Log.info(driver.getTitle());
		driver.manage().deleteAllCookies();
		Log.info("Successfully Remove the MSISDN Header-->" + number);
	}
	
	
	
	
	/***************************************************************************************
	 * @Function_Name : Reading_test_data
	 * @Description : Reading the test Data from Excel Sheet and Make a
	 *              LinkedHashMap
	 ***************************************************************************************/
	@Given("^Reading test data$")
	public void Reading_test_data() throws Exception {

		datamap = ExcelReader.ReadHeadingAndData();
		// System.out.println(datamap);
	}

	@When("^Navigate to url \"([^\"]*)\"$")
	public void navigate_to_url(String urlconfig) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// driver.navigate().to(PropertyReader.readItem(urlconfig));
		String navigationUrl = PropertyReader.baseurl;
		Log.info("Current BASEURL value : " + navigationUrl + ",and Navigation URL is : "
				+ PropertyReader.readItem(urlconfig));

		if (!navigationUrl.equals(PropertyReader.readItem(urlconfig)))
			navigationUrl = navigationUrl + PropertyReader.readItem(urlconfig);

		driver.get(navigationUrl);
		Log.info("URL \"" + navigationUrl + "\" is loaded");
	}

	public static WebDriver getdriver() {
		return driver;
	}

	void setDriver(WebDriver driver) {
		driver = Launcher.driver;
	}

	public static String getvaluefromExcelDataMap(String key) {
		String value = datamap.get(key);
		return value;
	}

	@Then("^Close the browser$")
	public void close_browser() throws Throwable {
		// driver.quit();
		driver.close();
		Log.info("Closed the browser");
	}

	@Then("^Quit the browser$")
	public static void closeBrowser() throws Exception {
		if (driver == null) {
			return;
		}
		driver.quit();
		driver = null;
		Log.info("closed the browser");
	}

	@Given("^Open a new Tab$")
	public static String Open_New_Tab() throws Throwable {
		String parentHandle = driver.getWindowHandle();
		((JavascriptExecutor) driver).executeScript("window.open()");
		String currentHandle = "";
		// below driver is your webdriver object
		Set<String> win = driver.getWindowHandles();

		Iterator<String> it = win.iterator();
		if (win.size() > 1) {
			while (it.hasNext()) {
				String handle = it.next();
				if (!handle.equalsIgnoreCase(parentHandle)) {
					driver.switchTo().window(handle);
					currentHandle = handle;

					driver.get("chrome-extension://innpjfdalfhpcoinfnehdnbkglpmogdi/options.html");
					driver.navigate().refresh();
					Thread.sleep(1000);
				}
			}
		} else {
			System.out.println("Unable to switch");
		}
		return parentHandle;

	}

	@Given("^KIll the Chrome exe Process$")
	public static void KillChromeExeProcess() {
		String command = "taskkill /F /IM chrome.exe /T";
		try {
			Process process = Runtime.getRuntime().exec(command);
			System.out.println("the output stream is " + process.getOutputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String s;
			while ((s = reader.readLine()) != null) {
				System.out.println("The inout stream is " + s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}