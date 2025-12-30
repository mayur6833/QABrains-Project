package com.AutomationCBS.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TakingAccountNumberByAutomationWay 
{
	WebDriver driver;
	@BeforeClass
	public void method()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\eclipse-workspace\\Practice\\Driver\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://development.techplex.in/login");
	}
	
	//Using POM
	@FindBy(id = "email") WebElement UserMail;
	@FindBy(id = "password2") WebElement password;
	@FindBy(xpath = "//div[@id='loginEmail']//button[@type='submit'][normalize-space()='Login']") WebElement login;
	
	@Test(priority = 1)
	public void setup() throws Exception
	{
		UserMail.sendKeys("automation@gmail.com");
		Thread.sleep(2000);
				
		password.sendKeys("automation@gmail.com");
		Thread.sleep(2000);
		
		login.click();
		Thread.sleep(2000);
	}
}














