package com.SeleniumWebsiteTest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Google {

	public static void main(String[] args) throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https:\\www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("seldom");
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		List<WebElement>list=driver.findElements(By.tagName("a"));
		List <WebElement> links=new ArrayList<WebElement>();
		for(WebElement link: list)
		{
			if(link.getAttribute("href")!=null)
			{
				links.add(link);
			}
		}
		for(int i=0;i<=4;i++)
		{
			links.get(4).click();
		}
		
		
		
	}

}
