package SeleniumWebsiteTest.SeleniumTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Auto_suggest {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys("hello");
		List<WebElement> lst=driver.findElements(By.xpath("//ul[@class='erkvQe']/li"));
		System.out.println(lst.size());
		for(int i=0;i<=lst.size()-1;i++)
		{
			String actStr=lst.get(i).getText();
			System.out.println(actStr);
			if(actStr.equals("hello movie"))
			{
				lst.get(i).click();
				break;
			}
		}
		
	}

}
