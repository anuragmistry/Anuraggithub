package SeleniumWebsiteTest.SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IsDisplayed {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.goindigo.in/");
		
		String test="//input[@class='form-control or-src-city']";
		boolean flag=driver.findElement(By.xpath(test)).isDisplayed();
		System.out.println(flag);
	}

}
