package SeleniumWebsiteTest.SeleniumTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripCheap {

	public static void main(String[] args) 
	{
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.cleartrip.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions act=new Actions(driver); 
		driver.findElement(By.id("FromTag")).sendKeys("Bangalore");
		act.sendKeys(Keys.ENTER);
		driver.findElement(By.id("ToTag")).sendKeys("Raipur");
		act.sendKeys(Keys.ENTER);
		driver.findElement(By.id("DepartDate")).click();
		driver.findElement(By.xpath("//tbody/tr[3]/td[1]/a")).click();
		driver.findElement(By.xpath("//input[@value='Search flights']")).click();
		List<WebElement> lst=driver.findElements(By.xpath("//th[@id='BaggageBundlingTemplate']"));
		System.out.println(lst.size());
		
		ArrayList<Integer> prices=new ArrayList<Integer>();
		for(int i=0;i<lst.size();i++)
		{
			//System.out.println(price.get(i).getText());
			Integer priceInt = Integer.valueOf(lst.get(i).getText().replace(",", ""));
			prices.add(priceInt);
		}
		Integer minPrice = Collections.min(prices);
		System.out.println("Min Price is "+minPrice);

		//compare all the prices with lowest price and click the corresponding book button
		/*List<WebElement> allBookbtn = driver.findElements(By.xpath("//*[@id='content']/div/div[5]/div[5]/div[2]/div/div[2]/div[2]/div[7]/p/a"));
		for(int i=0;i<lst.size();i++)
		{
			Integer priceInt1 = Integer.valueOf(lst.get(i).getText().replace(",", ""));
			//String price1 = price.get(i).getText();
			System.out.println(priceInt1);
			if(priceInt1.equals(minPrice))
			{
				allBookbtn.get(i).click();
				break;
			}
		}*/
	}
	
}
