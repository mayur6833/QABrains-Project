package com.AutomationCBS.Practice;

import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class workOnSiteLogin2 
{
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	static final String URL = "https://app.sonamuralamps.com/login";
	
	static final String credentials[][]= 
		{
			{"admin","sonamuralamps@gmail.com","sonamuralamps@gmail.com"},
			{"branch","sonamnew@gmail.com","sonamnew@gmail.com"}
		};
	
	@Test
	public void setUp() throws Exception 
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Add Role (Admin/Branch) :- ");
		String role = sc.nextLine().trim().toLowerCase();
		
		String ID = null,Pass = null;
		for (String[] cred : credentials) 
		{
			if(cred[0].equals(role))
			{
				ID = cred[1];
				Pass = cred[2];
				break;
			}
		}
		if(ID == null)
		{
			System.out.println("Invalid Role entered");
			return;
		}
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\eclipse-workspace\\CBS_Admin\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);
		
		WebElement loginID = driver.findElement(By.id("email"));
		loginID.sendKeys(ID);
		Thread.sleep(2000);
		
		WebElement loginPass = driver.findElement(By.id("password2"));
		loginPass.sendKeys(Pass);
		Thread.sleep(2000);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='loginEmail']//button[@type='submit'][normalize-space()='Login']"))).click();
		Thread.sleep(2000);
	}
	
}
