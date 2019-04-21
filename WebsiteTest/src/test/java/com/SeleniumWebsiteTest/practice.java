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

public class practice {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement dragWb=driver.findElement(By.id("draggable"));
		WebElement dropWb=driver.findElement(By.id("droptarget"));
		
		Actions act=new Actions(driver);
		act.dragAndDrop(dragWb, dropWb).perform();
	}		

}
