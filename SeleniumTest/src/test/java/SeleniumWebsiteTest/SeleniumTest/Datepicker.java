package SeleniumWebsiteTest.SeleniumTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Datepicker {

	static WebDriver driver;
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		driver.findElement(By.xpath("//p[@class='priceLow todayPrice']/parent::div/p[text()='23']")).click();
		driver.findElement(By.xpath("//a[text()='Search']")).click();
	}

}
