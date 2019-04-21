package com.SeleniumWebsiteTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
	public static void main(String []args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("file:///D:/Selenium%20Test%20Website/WebPage.html");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='New WebPage']")).click();
		driver.findElement(By.xpath("//a[text()=' Link to frame Web Page']")).click();
		Set<String> winLst=driver.getWindowHandles();
		System.out.println(winLst.size());
		Iterator<String>it=winLst.iterator();
		/*List<String>lst=new ArrayList<String>(winLst);
		lst.get(1);*/
		String strng="Text Testing";
		for(int i=0;i<=winLst.size()-1;i++)
		{
			if(driver.getTitle().equals(strng))
			{
				System.out.println(driver.getTitle());
				driver.findElement(By.name("txtUsername")).click();
			}
			else
			{
				System.out.println(driver.getTitle());
				driver.switchTo().window(it.next());
			}
		}
	}


}
