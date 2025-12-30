package com.AutomationCBS.Practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.testng.ITestResult;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ScreenshotCode 
{
	WebDriver driver;
	WebDriverWait wait;
	String mailID;

	@BeforeClass
	public void setup() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\eclipse-workspace\\CBS_Branch\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demo.techplex.in/login");
		
		//Explicit Wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//LogIN Code 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email Address']"))).sendKeys("SWMT-E0053");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordField"))).sendKeys("Automation@123");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='submitBtn']"))).click();
		Thread.sleep(2000);
	}
	
	public void takeScreenshot(String name) {
	    try {
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        File destDir = new File("C:\\Users\\Shree\\eclipse-workspace\\Practice\\screenshot.png");
	        if (!destDir.exists()) {
	            destDir.mkdirs();
	        }
	        File dest = new File(destDir, name + ".png");
	        FileUtils.copyFile(src, dest);
	        System.out.println("Screenshot saved: " + dest.getAbsolutePath());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	@Test(priority = 1)
	public void viewCustomer() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigate 
		driver.navigate().to("https://demo.techplex.in/customer-enrollment/view_custome_enrollment");
		Thread.sleep(2000);
		
		//Member ID 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchMemberId"))).click();
		System.out.println("----------Add Member ID Manually----------");
		Thread.sleep(10000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='']"))).click();
		Thread.sleep(2000);
		
		//Action
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='odd']//i[@class='fas fa-eye']"))).click();
		Thread.sleep(10000);
		
	}
	
	@AfterClass
	public void exit(ITestResult result) throws Exception 
	{
	    Thread.sleep(2000);
	    if (result.getStatus() == ITestResult.FAILURE) 
	    {
	        takeScreenshot(result.getName() + "_Failure");
	    }
	}
}
