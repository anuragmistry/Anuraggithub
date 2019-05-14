package DropDown;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandling {

	static WebDriver driver;
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//driver.get("https://www.facebook.com");
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//dropDownSel();
		multiDropSel();
	}
	
	static void dropDownSel()
	{
		String expOp="23";
		WebElement wb=driver.findElement(By.id("day"));
		Select sel=new Select(wb);
		List<WebElement> dropLst=sel.getOptions();
		for(int i=0;i<=dropLst.size()-1;i++)
		{
			String actOp=dropLst.get(i).getText();
			if(actOp.equals(expOp))
			{
				sel.selectByVisibleText(actOp);
			}
			System.out.println(actOp);
		}
		driver.close();	
	}
	static void multiDropSel()
	{
	
		
		String []arr= {"Volvo", "Opel"};
		WebElement wb=driver.findElement(By.xpath("//select[@name='cars']"));
		Select sel=new Select(wb);
		System.out.println("Is it Multi Select?"+sel.isMultiple());
		List <WebElement> mulLst=sel.getOptions();
		for(int i=0;i<=mulLst.size()-1;i++)
		{
			String str=mulLst.get(i).getText();
			for(int j=0;j<=arr.length-1;j++)
			{
				if(str.equals(arr[j]))
				{
					sel.selectByVisibleText(str);
				}
			}
		}
	}
}
