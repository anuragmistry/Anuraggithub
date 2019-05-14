package SeleniumWebsiteTest.SeleniumTest;

import org.testng.annotations.*;

public class SampleTestNG 
{
	@BeforeSuite
	public void DBConnectionOn()
	{
		System.out.println("++++++++Database connected+++++++++");
	}
	
	@BeforeClass
	public void LaunchBrowserOn()
	{
		System.out.println("+++++++++++Launch Browser+++++++++++");
	}
	
	@BeforeMethod
	public void LoginOn()
	{
		System.out.println("+++++++++++Logged in++++++++++++++");
	}
	@Test
	public void a()
	{
		System.out.println("Method 1");
	}
	
	@Test
	public void b()
	{
		System.out.println("Method 2");
	}
	
	@AfterMethod
	public void LogOut()
	{
		System.out.println("+++++++++++Logged out++++++++++++++");
	}
	
	@AfterClass
	public void LaunchBrowserOff()
	{
		System.out.println("+++++++++++Closed Browser+++++++++++");
	}
	
	@AfterSuite
	public void DBConnectionOff()
	{
		System.out.println("++++++++Database disconnected+++++++++");
	}
	
	


}
