package com.AutomationCBS.Practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class loginThroughPropertiesFile 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@Test
	public void Login() throws Exception
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Shree\\eclipse-workspace\\CBS_Branch\\configBranch.properties");
		Properties pro1 = new Properties();
		pro1.load(file);
		
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\Shree\\eclipse-workspace\\CBS_Branch\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(pro1.getProperty("URL"));
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email Address']"))).sendKeys(pro1.getProperty("USERNAME"));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordField"))).sendKeys(pro1.getProperty("PASSWORD"));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitBtn"))).click();
		Thread.sleep(2000);

	}
}
