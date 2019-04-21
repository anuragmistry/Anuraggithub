package com.SeleniumWebsiteTest;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class facebook {
	static WebDriver driver;
	static String expValue;
	static String expDate;
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		expValue="First name";
		expDate="22";
		placeholder();
		radioButton();
		dropDown();
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		autoSuggest();
		concurrentKey();
		
	}



	static void placeholder()
	{
		String actValue=driver.findElement(By.id("u_0_j")).getAttribute("aria-label");
		System.out.println(actValue);
		if(actValue.equals(expValue))
		{
			System.out.println("====Test Case Pass====");
		}
		else
		{
			System.out.println("====Test Case Failed====");
		}
	}
	
	static void radioButton()
	{
		boolean radButM=driver.findElement(By.id("u_0_9")).isSelected();
		boolean radButF=driver.findElement(By.id("u_0_a")).isSelected();
		if(radButM==true)
		{
			System.out.println("====Test Case Failed====");
		}
		else
		{
			System.out.println("====Test Case passed====");
		}
		
		if(radButF==true)
		{
			System.out.println("====Test Case Failed====");
		}
		else
		{
			System.out.println("====Test Case passed====");
		}
	}
	
	static void dropDown()
	{
		
		WebElement dateList=driver.findElement(By.id("day"));
		Select selectDate=new Select(dateList);
		List <WebElement> dateValue=selectDate.getOptions();
		for(int i=0;i<=dateValue.size()-1;i++)
		{
			System.out.println(dateValue.get(i).getText());
			String actDate=dateValue.get(i).getText();
			if(expDate.equals(actDate))
			{
				selectDate.selectByVisibleText(actDate);
			}
		}
		
	}
	
	static void autoSuggest()
	{
		driver.findElement(By.name("q")).sendKeys("Game of Thrones");
		List <WebElement> lst=driver.findElements(By.xpath("//ul[@class='erkvQe']//li/preceding::div[@class='sbtc']"));
		System.out.println(lst.size());
		Actions act=new Actions(driver);
		System.out.println(lst.size());
		for(WebElement wb: lst )
		{
			System.out.println(wb.getText());
		}
		act.moveToElement(lst.get(5)).click().perform();
	}

	static void concurrentKey()
	{
		
	}

}