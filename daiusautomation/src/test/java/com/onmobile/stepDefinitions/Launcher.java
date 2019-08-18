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

import com.onmobile.dataProvider.ConfigFileReader;
import com.onmobile.dataProvider.ExcelReader;
import com.onmobile.utils.CheckBrokenLinks;
import com.onmobile.utils.Util;
import com.onmobile.xpaths.PortalXpath;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Launcher implements PortalXpath{

	static WebDriver driver = null;
	ChromeOptions options=null;
	public static ConfigFileReader CFR;
	static Logger Log = LogManager.getLogger("test");

	public static LinkedHashMap<String, String> datamap;

	@Given("^Launch the browser with config \"([^\"]*)\"$")
	public void launch_the_browser(String configname) throws Exception {
		CFR = new ConfigFileReader();
		CFR.configFileReader(configname);

		String browserType=CFR.getProperty("browser");
		String downloadfolder=CFR.getProperty("Download_Folder_PATH");
		if(browserType.equalsIgnoreCase("Chrome")) {


			System.setProperty("webdriver.chrome.driver","lib\\chromedriver.exe");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("download.default_directory",System.getProperty("user.dir")+ File.separator + downloadfolder);

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addExtensions(new File(CFR.getProperty("CHROMEEXT")));
			options.addArguments("window-size=1360,768");
			options.addArguments("disable-infobars");
			options.addArguments("--dns-prefetch-disable");

			driver = new ChromeDriver(options);

			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS); 
			//  driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);

			//////Old code
			/*System.setProperty("webdriver.chrome.driver","lib\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addExtensions(new File(CFR.getProperty("CHROMEEXT")));
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(options);*/
		}
		else if(browserType.equalsIgnoreCase("FireFox")) {

		}
		Log.info("Launching the ["+browserType+"] Browser");
		//		
		//		Dimension d = new Dimension(800,480);
		//		//Resize current window to the set dimension
		//		driver.manage().window().setSize(d);

		//	driver.manage().window().maximize();	

	}
	/***************************************************************************************
	 * @Function_Name :  set_headers
	 * @Description   :  Set the Browser plugIn(Modify Header) and pass the user type as a argument
	 ***************************************************************************************/
	@And("^set headers with \"([^\"]*)\" number$")
	public void set_headers(String userType) throws Throwable {

		driver.get("chrome-extension://innpjfdalfhpcoinfnehdnbkglpmogdi/options.html");
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// setup ModHeader with name and value
		driver.navigate().refresh();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@tooltip='Add New']")).click();

		WebElement actionElem = driver.findElement(By.name("action"));
		Select select = new Select(actionElem);
		select.selectByVisibleText("Add");

		WebElement nameElem = driver.findElement(By.name("name"));
		nameElem.sendKeys("User-Agent");

		WebElement valueElem = driver.findElement(By.name("value"));
		//valueElem.sendKeys("Mozilla/5.0 (Linux; Android 6.0.1; SM-G800F Build/MMB29K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.125 Mobile Safari/537.36");
		valueElem.sendKeys(CFR.getProperty("USER-AGENT"));
		WebElement descElem = driver.findElement(By.name("description"));
		descElem.sendKeys("Add user agent for portal");

		driver.findElement(By.xpath("//button[@tooltip='Save']")).click();
		Thread.sleep(1000);

		if(userType.equalsIgnoreCase("UIM")) {
			Log.info("Add Modify Header for UIM===>");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@tooltip='Start Modifying Headers']")).click();
			driver.findElement(By.xpath("//button[@tooltip='Enable']")).click();
			Log.info("Enable the User Agent Header===>");
		}else {

			driver.findElement(By.xpath("//button[@tooltip='Add New']")).click();

			WebElement actionElem1 = driver.findElement(By.name("action"));
			Select select1 = new Select(actionElem1);
			select1.selectByVisibleText("Add");

			WebElement nameElem1 = driver.findElement(By.name("name"));
			nameElem1.sendKeys("x-up-subno");

			WebElement valueElem1 = driver.findElement(By.name("value"));


			if(userType.equalsIgnoreCase("NewUser")) {
				valueElem1.sendKeys(CFR.getProperty("NewUser_xUPSUBNO"));
			}
			if(userType.equalsIgnoreCase("SubscribeUser")) {
				valueElem1.sendKeys(CFR.getProperty("SubscribeUser_xUPSUBNO"));
			}
			if(userType.equalsIgnoreCase("UnSubscribeUser")) {
				valueElem1.sendKeys(CFR.getProperty("UnSubscribeUser_xUPSUBNO"));
			}else {
				valueElem1.sendKeys(userType);
			}

			WebElement descElem1 = driver.findElement(By.name("description"));
			descElem1.sendKeys("Add Msisdn for portal");

			driver.findElement(By.xpath("//button[@id='btn_save_2']")).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//button[@tooltip='Start Modifying Headers']")).click();


			driver.findElement(By.xpath("//button[@tooltip='Enable']")).click();


			driver.findElement(By.xpath("//button[@id='btn_enable_2']")).click();
		}///UIM else
	}
	/***************************************************************************************
	 * @Function_Name :  Reading_test_data
	 * @Description   :  Reading the test Data from Excel Sheet and Make a LinkedHashMap
	 ***************************************************************************************/
	@Given("^Reading test data \"([^\"]*)\"$")
	public void Reading_test_data(String TestDataFilePath) throws Exception {
		datamap = ExcelReader.ReadHeadingAndData(CFR.getProperty(TestDataFilePath));
		//	System.out.println(datamap);
		Log.info("Reading the Test Data from Excel Sheet===>");
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

		valueElem.sendKeys(CFR.getProperty("USER-AGENT"));
		WebElement descElem = driver.findElement(By.name("description"));
		descElem.sendKeys("Add user agent for portal");
       
		driver.findElement(By.xpath("//button[@tooltip='Save']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@tooltip='Start Modifying Headers']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@tooltip='Enable']")).click();
		Log.info("Navigate to Mod Header===>");
	}

	@Given("^Set \"([^\"]*)\" with \"([^\"]*)\" in Header$")
	public void Set_MSISDN_headers(String requestHaederName,String msisdn) throws Throwable {

		driver.findElement(By.xpath("//button[@tooltip='Add New']")).click();

		WebElement actionElem = driver.findElement(By.name("action"));
		Select select = new Select(actionElem);
		select.selectByVisibleText("Add");

		WebElement nameElem = driver.findElement(By.name("name"));
		if(requestHaederName.equalsIgnoreCase("x-up-subno")) {
			nameElem.sendKeys("x-up-subno");
		}
		if(requestHaederName.equalsIgnoreCase("x-msisdn")) {
			nameElem.sendKeys("x-msisdn");
		}
		WebElement valueElem = driver.findElement(By.name("value"));

		valueElem.sendKeys(msisdn);

		WebElement descElem = driver.findElement(By.name("description"));
		descElem.sendKeys("Add user "+requestHaederName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='btn_save_2']")).click();
		Thread.sleep(1000);	
		driver.findElement(By.xpath("//button[@id='btn_enable_2']")).click();
		Log.info("Add the ["+requestHaederName+"] and value ["+msisdn+"] in Mod Header");
	}
	
	@Given("^Change the Number \"([^\"]*)\" in Mod Header$")
	public void Change_Num_ModHeader(String number) throws Throwable {

		String mainTab=Launcher.Open_New_Tab();
		Log.info("Open The New Tab");
		driver.findElement(By.xpath("//button[@id='btn_edit_2']")).click();
		Thread.sleep(500);
		WebElement valueElem1 = driver.findElement(By.name("value"));
		valueElem1.clear();
		valueElem1.sendKeys(number);
		driver.findElement(By.xpath("//button[@id='btn_save_2']")).click();
		Thread.sleep(1000);
		driver.switchTo().window(mainTab);
		Log.info("Switch to the Main Tab");
		Log.info(driver.getTitle());
		driver.manage().deleteAllCookies();
	}
	
	@Given("^Open a new Tab$")
	public static String Open_New_Tab() throws Throwable {
		String parentHandle = driver.getWindowHandle();
		((JavascriptExecutor)driver).executeScript("window.open()");
		String currentHandle ="";
		// below driver is your webdriver object
		Set<String> win  = driver.getWindowHandles();   

		Iterator<String> it =  win.iterator();
		if(win.size() > 1){
			while(it.hasNext()){
				String handle = it.next();
				if (!handle.equalsIgnoreCase(parentHandle)){
					driver.switchTo().window(handle);
					currentHandle = handle;

					driver.get("chrome-extension://innpjfdalfhpcoinfnehdnbkglpmogdi/options.html");
					driver.navigate().refresh();
					Thread.sleep(1000);
				}
			}
		}
		else{
			System.out.println("Unable to switch");
		}
		return parentHandle;

	}

	@When("^navigate to url \"([^\"]*)\"$")
	public void navigate_to_url(String urlconfig) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(CFR.getProperty(urlconfig));
		Log.info("URL \""+ CFR.getProperty(urlconfig) +"\" is loaded");
		Util.setCurrentPortalName(CFR.getProperty("PORTAL"));

	}
	
	@When("^Navigate to url \"([^\"]*)\"$")
	public void Navigate_to_URL(String urlconfig) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(CFR.getProperty(urlconfig));
		Log.info("URL \""+ CFR.getProperty(urlconfig) +"\" is loaded");
		Util.setCurrentPortalName(CFR.getProperty("PORTAL"));
	}
	
	@Then("^Deactivate the Active User msisdn \"([^\"]*)\" from app \"([^\"]*)\" and pack \"([^\"]*)\"$")
	public void DeActivedUser(String msisdn, String app, String pack) throws Throwable{		
		String url=CFR.getProperty("DeactivatePackUrl").replace("ReplaceNum", msisdn).replace("ReplaceApp", app).replace("ReplacePack", pack);
		Util.GetJSONData_POST(url);
	}

	public static WebDriver getdriver() {
		return driver;
	}

	void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public static String getvaluefromExcelDataMap(String key) {
		String value = datamap.get(key);
		return value;
	}


	@Then("^validate Broken Links$")
	public void validate_Broken_Links() throws Throwable{	
		CheckBrokenLinks.findBrokenLinks();
	}


	@Then("^close browser$")
	public void close_browser() throws Throwable {
		driver.quit();
		
		//driver.close();
		Log.info("closed browser");
	}
	
	@Given("^not used$")
	public void NotUsed() {
		Log.info("Not used only for testing purpose");
	}
	
	@Given("^KIll the Chrome exe Process$")
	public static void KillChromeExeProcess() {
		String command="taskkill /F /IM chrome.exe /T";
		try {
			Process process = Runtime.getRuntime().exec(command);
			System.out.println("the output stream is "+process.getOutputStream());
			BufferedReader reader=new BufferedReader( new InputStreamReader(process.getInputStream()));
			String s; 
			while ((s = reader.readLine()) != null){
				System.out.println("The inout stream is " + s);
			}                   
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    @Given("^Launch the browser with arguments msisdn \"([^\"]*)\"$")
	public void launch_the_browser_add_Argument(String num) throws Exception {
		CFR = new ConfigFileReader();
		CFR.configFileReader("config");
		String browserType=CFR.getProperty("browser");
		String msisdn="--x-up-subno="+num+"";
		if(browserType.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver","lib\\chromedriver.exe");
		    options = new ChromeOptions();
			options.addArguments("--user-agent=Mozilla/5.0 (Linux; Android 4.4.4; XT1022 Build/KXC21.5-40) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Mobile Safari/537.36");
			options.addArguments("--x-up-subno=11877899999991");
			options.addArguments("window-size=1360,768");
			options.addArguments("disable-infobars");
			options.addArguments("--dns-prefetch-disable");

			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS); 
			
		}
		Log.info("Launching the ["+browserType+"] Browser");
	

	}
    @Given("^Change the Chrome browser arguments$")
    public void Change_the_Chrome_Argument() throws Exception {
    	options.addArguments("--start-maximized");
    	options.addArguments("--incognito");
    	options.addArguments("--x-up-subno=110351400000000");
    	driver = new ChromeDriver(options);
    }
}