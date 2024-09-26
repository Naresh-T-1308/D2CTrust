package testCases;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class D2CTrustDemo {

	@Test
	public void Demo() throws Exception
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://d2ctrust.com");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Actions a= new Actions(driver);
		
		a.scrollToElement(driver.findElement(By.cssSelector("a[class~='whiteColor']"))).perform();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("a[class~='whiteColor']")).click();
		String parentHandle=   driver.getWindowHandle();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button[title='Get Started']")).click();
		Set<String> handles= driver.getWindowHandles();
		for(String handle:handles)
		{
			if(!handle.equals(parentHandle))
			{
				driver.switchTo().window(handle);
				Thread.sleep(3000);
				driver.close();
			}
			driver.switchTo().window(parentHandle);
	}
		Reporter.log("successfuly executed....",true);
}
}
