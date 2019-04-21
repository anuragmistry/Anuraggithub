package com.SeleniumWebsiteTest;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles 
{

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\WebsiteTest\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("samsung",Keys.ENTER);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Samsung Galaxy On8 (Blue, 64 GB)']")).click();
		JavascriptExecutor jsr=(JavascriptExecutor)driver;
		jsr.executeScript("window.scrollBy(0,800)");
		driver.findElement(By.xpath("//div[text()='Samsung Galaxy On Max (Gold, 32 GB)']")).click();
		String expected="Samsung Galaxy On Max ( 32 GB ROM, 4 GB RAM ) Online at Best Price On Flipkart.com";
		Set <String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		//String parentwindow=it.next();
		//String childwindow=it.next();
		
		for(int i=0;i<=set.size();i++) 
		 {
			System.out.println(driver.getTitle());
			if (driver.getTitle().equals(expected)) 
			{
				jsr.executeScript("window.scrollBy(0,200)");
				driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2kuvG8 _7UHT_c']")).click();
			}
			else
			{
				driver.switchTo().window(it.next());
			}
			
		 }
	}
}