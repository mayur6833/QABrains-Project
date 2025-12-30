package com.AutomationCBS.Practice;


import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Scroll2000Pixels 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@Test (priority = 1)
	public void login()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\eclipse-workspace\\CBS_Branch\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://search.brave.com/search?q=facebook");
	}
	
	@Test(priority = 2)
	public void scrollpage() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
	}
}
