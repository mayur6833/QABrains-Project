package com.AutomationCBS.Practice;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IndividualLoanLogic1 
{
	WebDriver driver;
	WebDriverWait wait;
	
	static final String URL = "https://demo.techplex.in/login";
	static final String Credentials [][] =
		{
			{"admin","demoadmin@gmail.com","Pawan@123"},
			{"branch","pawan01@gmail.com","pawan01@gmail.com"}
		};
	
	@BeforeClass
	public void setUp() throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Add Role (admin,branch)");
		String Role = sc.nextLine().trim().toLowerCase();
		sc.close();
		
		String ID = null;
		String Pass = null;
		
		for (String[] creds : Credentials) 
		{
			if(creds[0].equals(Role))
			{
				ID = creds[1];
				Pass = creds[2];
				break;
			}
		}
		if(ID == null)
		{
			System.out.println("Entered Invalid Role ..!");
			return;
		}
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\eclipse-workspace\\CBS_Branch\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(URL);	
		
		//login Code
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email Address']"))).sendKeys(ID);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordField"))).sendKeys(Pass);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='submitBtn']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 1)
	public void Apply_Individual() throws Exception
	{
		//direct Navigation 
		driver.navigate().to("https://demo.techplex.in/branch-loan/applyloan");
		Thread.sleep(2000);
				
		//member ID 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member-id"))).click();
		System.out.println("----------Add Member ID Manually---------");
		Thread.sleep(15000);
				
		//Select Loan Product
		WebElement selectProduct = driver.findElement(By.id("loan_product"));
		Select selectProducts = new Select(selectProduct);
		List<WebElement> products = selectProducts.getOptions();
		String SP = "Vehicle Loan";
		for (int i = 0; i < products.size(); i++) 
		{
			if(products.get(i).getText().equalsIgnoreCase(SP))
			{
				products.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
				
		//Purpose Of Loan
		WebElement LoanPurpose = driver.findElement(By.id("loan-purpose"));
		Select selectPurpose = new Select(LoanPurpose);
		List<WebElement> purpose = selectPurpose.getOptions();
		String PL = "Vehicle Loan";
		for (int i = 0; i < purpose.size(); i++) 
		{
			if(purpose.get(i).getText().equalsIgnoreCase(PL))
			{
				purpose.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
				
		//Interest Rate Type
		WebElement interestRateType = driver.findElement(By.id("interest-rate-type"));
		Select selectInterestType = new Select(interestRateType);
		List<WebElement> Interest = selectInterestType.getOptions();
		String SIT = "Flat";
		for (int i = 0; i < Interest.size(); i++) 
		{
			if(Interest.get(i).getText().equalsIgnoreCase(SIT))
			{
				Interest.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
				
		//Loan Cycle
		WebElement loanCycle = driver.findElement(By.xpath("//div[@id='individual-loan-form']//div[1]//div[2]//div[6]//select[1]"));
		Select selectloanCycle = new Select(loanCycle);
		List<WebElement> Loans = selectloanCycle.getOptions();
		String SLC = "Monthly";
		for (int i = 0; i < Loans.size(); i++) 
		{
			if(Loans.get(i).getText().equalsIgnoreCase(SLC))
			{
				Loans.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount"))).clear();		
		WebElement LoanAmount = driver.findElement(By.id("amount"));
		LoanAmount.click();
		System.out.println("----------Add Loan Amount----------");
		Thread.sleep(7000);
		String amountText = LoanAmount.getAttribute("value");
		amountText = amountText.replaceAll("[^\\d.]", "");
//		System.out.println("Loan amount = "+amountText);
		
		//InterestRate
		WebElement interestRate = driver.findElement(By.id("interest-rate"));
		interestRate.click();
		Thread.sleep(2000);
		String interestText = interestRate.getAttribute("value");
		interestText = interestText.replaceAll("[^\\d.]"," ");
//		System.out.println("Interest Rate = "+interestText);
		
		
		//Tenure
		WebElement tenure = driver.findElement(By.id("tenure"));
		tenure.click();
		System.out.println("----------Add Tenure----------");
		Thread.sleep(7000);
		String tenureText = tenure.getAttribute("value");
		tenureText = tenureText.replaceAll("[^\\d.]", " ");
//		System.out.println("Tenure Month = "+tenureText);
		
		//frequency
		WebElement Frequency = driver.findElement(By.id("frequency"));
		Select selectFrequency = new Select(Frequency);
		List<WebElement> frequencyOptions = selectFrequency.getOptions();
		String Fr= "Monthly";
		for (int i = 0; i < frequencyOptions.size(); i++) 
		{
			if (frequencyOptions.get(i).getText().equalsIgnoreCase(Fr))
			{
				frequencyOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//SelectCollector
		WebElement collector = driver.findElement(By.id("collector"));
		Select selectCollector = new Select(collector);
		List<WebElement> collectorOptions = selectCollector.getOptions();
		String C = "Collector 1";
		for (int i = 0; i < collectorOptions.size(); i++) 
		{
			if (collectorOptions.get(i).getText().equalsIgnoreCase(C))
			{
				collectorOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Pre-EMIInterest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pre-emi-interest"))).sendKeys("7");
		Thread.sleep(2000);
		
		//LSAccount
		//SelectNewAccount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='new-account2']"))).click();
		Thread.sleep(2000);
		
		//ClickOnCheckEMI
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check-emi"))).click();
		Thread.sleep(2000);
		
		//Calculation For Flat Interest Rate
		
		double loanAmount = Double.parseDouble(amountText); // Loan Amount    
		double annualROI = Double.parseDouble(interestText); // Interest Rate            
		int tenureMonths = Integer.parseInt(tenureText); // Tenure
		
		double tenureYears = tenureMonths / 12.0;
		double totalInterest = (loanAmount * annualROI * tenureYears) / 100;
		double totalPayment = loanAmount + totalInterest;
		double flatEMI = totalPayment / tenureMonths;
//	    System.out.printf("Flat ROI Actual EMI: %.2f%n", flatEMI);
	    
	    //System Generated EMI
	    WebElement SystemEMI = driver.findElement(By.xpath("//span[contains(text(),'₹')]"));
	    String SystemsEMI = SystemEMI.getText().replaceAll("[^\\d.]", "");
	    double systememiValue = Double.parseDouble(SystemsEMI);
//	    System.out.println("System Generated EMI Value = " + systememiValue);
		
		if(systememiValue == flatEMI)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("apply-loan-btn"))).click();
			Thread.sleep(2000);
			//ClickOnOk
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
			Thread.sleep(2000);
		}
		else
		{
			System.out.println("Wrong EMI Calculations");
			Thread.sleep(2000);
		}

	}
	
	@AfterClass
	public void exit() throws Exception
	{
		Thread.sleep(5000);
		if(driver != null)
		{
			driver.close();
		}
	}
	
}
