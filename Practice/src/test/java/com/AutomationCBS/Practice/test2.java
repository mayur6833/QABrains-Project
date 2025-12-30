package com.AutomationCBS.Practice;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class test2 
{	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	Scanner sc = new Scanner(System.in);
	
	@Test(priority = 1)
	public void setup() throws Exception
	{
		sc = new Scanner(System.in);
		System.out.println("Add Any Branch URL : ");
		String URLinput = sc.nextLine();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\eclipse-workspace\\Practice\\Driver\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URLinput);
		Thread.sleep(4000);
	}
	
	@Test(priority = 2)
	public void login() throws Exception
	{
		sc = new Scanner(System.in);
		
		System.out.println("Add email ID : ");
		String emailInput = sc.nextLine();
		Thread.sleep(8000);
		
		System.out.println("Add Password : ");
		String passInput = sc.nextLine();
		Thread.sleep(8000);
		
		WebElement loginID = driver.findElement(By.id("email"));
		loginID.sendKeys(emailInput);
		Thread.sleep(2000);
		
		WebElement password = driver.findElement(By.id("password2"));
		password.sendKeys(passInput);
		
		WebElement loginButtonClick = driver.findElement(By.xpath("//div[@id='loginEmail']//button[@type='submit'][normalize-space()='Login']"));
		loginButtonClick.click();
	}
	
//	@AfterClass
//	public void exit() throws Exception
//	{
//		Thread.sleep(5000);
//		if(driver != null)
//		{
//			driver.close();
//		}
//	}
	
}
