package SeleniumWebsiteTest.SeleniumTest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getWindowHandle {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("file:///D:/Selenium%20Test%20Website/WebPage.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='New WebPage']")).click();
		driver.findElement(By.xpath("//a[text()=' Link to frame Web Page']")).click();
		String homepage=driver.getWindowHandle();
		System.out.println(homepage);
		Set<String>lstWindow=driver.getWindowHandles();
		Iterator <String> it=lstWindow.iterator();
		String expTitle="Text Testing";
		while(it.hasNext())
		{
			String child=it.next();
			System.out.println(driver.switchTo().window(child).getTitle());
			Thread.sleep(1000);
			if(expTitle.equals(child))
			{
				System.out.println(child);
				driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello");
				break;
			}
			else
			{
				driver.switchTo().window(it.next());
			}
		}
		
		
	}

}
