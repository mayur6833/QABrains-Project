package com.AutomationCBS.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumChecking404ErrorCode 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@Test (priority = -1)
	public void login()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\eclipse-workspace\\CBS_Branch\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.google.com/");
	}
	
	@Test(priority = 1)
	public void checkErrorThroughAssert() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		System.out.println("URL" + driver.getCurrentUrl()); 
		System.out.println();
//		System.out.println("Page Source "+ driver.getPageSource());
		
		Assert.assertEquals(driver.getPageSource().contains("200"), true);
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email Address']"))).sendKeys("SWMT-E0053");
//		Thread.sleep(2000);
//		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordField"))).sendKeys("Automation@123");
//		Thread.sleep(2000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitBtn"))).click();
//		Thread.sleep(2000);
	}
}
