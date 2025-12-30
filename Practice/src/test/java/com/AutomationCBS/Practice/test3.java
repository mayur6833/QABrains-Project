package com.AutomationCBS.Practice;

import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class test3 
{
	private WebDriver driver;
	private Scanner sc ;
 
	@Test(priority = 0)
	public void setup() throws Exception
	{
		System.setProperty("driver.chrome.driver", "C:\\Users\\Shree\\eclipse-workspace\\Practice\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		System.out.println("Add URL : ");
		String URLInput = sc.nextLine();
		
		Thread.sleep(8000);
		System.out.println("Add LoginID : ");
		String EmailInput = sc.nextLine();
		
		Thread.sleep(8000);
		System.out.println("Add Password : ");
		String passInput = sc.nextLine();
		
		//getURL
		driver.get(URLInput);
		
		WebElement emailID = driver.findElement(By.id("email"));
		emailID.sendKeys(EmailInput);
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(passInput);
		
		WebElement loginButton = driver.findElement(By.xpath("//div[@id='loginEmail']//button[@type='submit'][normalize-space()='Login']"));
		loginButton.click();
	}
	
	@Test(priority = 1)
	public void test1()
	{
		System.out.println("Login Working");
	}
}
