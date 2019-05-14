package SeleniumWebsiteTest.SeleniumTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameSwitch {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://seleniumhq.github.io/selenium/docs/api/java/index.html");
		List<WebElement> lst=driver.findElements(By.tagName("frame"));
		System.out.println(lst.size());
		driver.switchTo().frame("packageListFrame");
		String linkName1=driver.findElement(By.xpath("//a[@href='org/openqa/selenium/package-frame.html']")).getText();
		System.out.println(linkName1);
		driver.findElement(By.xpath("//a[@href='org/openqa/selenium/package-frame.html']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("//a[@href='TakesScreenshot.html']")).click();
		driver.switchTo().defaultContent();
	}

}
