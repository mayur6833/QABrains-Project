package com.AutomationCBS.Practice;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testSBOPening 
{
	WebDriver driver;
	WebDriverWait wait;
	Scanner sc= new Scanner(System.in);
		
	@BeforeClass
	public void setUp() throws Exception 
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Add Any Branch URL : ");
		String URLinput = sc.nextLine();
			
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\eclipse-workspace\\Practice\\Driver\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URLinput);
		Thread.sleep(4000);
				
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
	@Test(priority = 1)
	public void SB_Account() throws Exception
	{
	    wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	    
//	   //ClickOnCoreBankingServices
//	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Core Banking Service')]"))).click();
//	   Thread.sleep(2000);
//	   //ClickOnSavingAccount
//	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Saving Account')]"))).click();
//	   Thread.sleep(2000);	
//	   //ClickOnSbOPening
//	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='SB Opening']"))).click();
	    
	    driver.navigate().to("https://app.sonamuralamps.com/baccounts/open-sb");
	   System.out.println("ClickOnCreateSBAccount is working");
	}
		
	@Test(priority = 2)
	public void DepositAndAccountTypeDetails() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			
		//AccountType
		//Having multiple same types
		WebElement AccountType=driver.findElement(By.id("saving_account_type"));
		Select selectAT=new Select(AccountType);
		List<WebElement> selectAccountType = selectAT.getOptions();
		String s1="Govt Servent";
		for (int i = 0; i < selectAccountType.size(); i++) 
		{
			if(selectAccountType.get(i).getText().equalsIgnoreCase(s1))
			{
				selectAccountType.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);	
			
		//AccountType
		WebElement AccountType1=driver.findElement(By.id("account_type"));
		Select selectAT1=new Select(AccountType1);
		List<WebElement> selectAccountType1 = selectAT1.getOptions();
		String s11="Individual";
		for (int i = 0; i < selectAccountType1.size(); i++) 
		{
			if(selectAccountType1.get(i).getText().equalsIgnoreCase(s11))
			{
				selectAccountType1.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
			
		System.out.println("DepositAndAccountTypeDetails is working");
	}
		
	@Test(priority = 3)
	public void DepositorDetails() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			
		//Member No
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member-no"))).sendKeys("004001100004");
		Thread.sleep(3000);
		
		//Scrolldown
		WebElement scrolldown1 = driver.findElement(By.xpath("//button[normalize-space()='Submit Application']"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(scrolldown1).build().perform();
		
	}
	@Test(priority = 5)
	public void agentDetails() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			
		//AgentID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reffered-by"))).sendKeys("SONM-A0002");
		Thread.sleep(2000);
		
		//AgentName
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='referred-by-2']"))).click();
		Thread.sleep(2000);
		
		//SubmitApplication
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit Application']"))).click();
		Thread.sleep(5000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 6)
	public void checkAccountCreated() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.navigate().to("https://app.sonamuralamps.com/baccounts/viewsb_sbopening");
		Thread.sleep(2000);
		
		//Search Type
		WebElement searchType =  driver.findElement(By.xpath("//select[@id='search_type']"));
		Select selectType = new Select(searchType);
		List<WebElement> types = selectType.getOptions();
		String ST = "Member ID";
		for (int i = 0; i < types.size(); i++) 
		{
			if(types.get(i).getText().equalsIgnoreCase(ST))
			{
				types.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Enter Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-content"))).sendKeys("004001100004");
		Thread.sleep(8000);
		System.out.println("Scroll down for see Account Details");
	}
		
	@AfterClass
	public void exit() throws Exception
	{
		Thread.sleep(5000);
		if(driver!=null)
		{
			driver.close();
		}
	}
}


