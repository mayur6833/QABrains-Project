package com.AutomationCBS.Practice;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class TestFDOpening 
{
	WebDriver driver;
	WebDriverWait wait;
	org.slf4j.Logger logger;
	
	@BeforeClass
	public void setUp() throws Exception 
	{
		logger =LoggerFactory.getLogger(TestFDOpening.class);
		logger.info("logger set");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\eclipse-workspace\\CBS_Branch\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://development.techplex.in/login");	
		
		//logInCode
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("branch01@techplex.com");	
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password2"))).sendKeys("branch01@techplex.com");	
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='loginEmail']//button[@type='submit'][normalize-space()='Login']"))).click();	
		Thread.sleep(3000);
		
		logger.info("Login Done");
	}
	
	@Test(priority = 1)
	public void FD_Account() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));

		//ClickOnCoreBankingServices
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Core Banking Service')]"))).click();
		Thread.sleep(2000);
		//ClickOnSavingAccount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Fixed Deposit')]"))).click();
		Thread.sleep(2000);	
		//ClickOnFDAccount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='FD Opening']"))).click();
		Thread.sleep(2000);	
	}
	
	
	
	@Test(priority = 2)
	public void DepositAccountTypeDetails() throws InterruptedException
	{
		System.out.println("DepositAccountTypeDetails == not working properly");
		
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//DepositType
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='deposit-type']"))).click();	
		Thread.sleep(3000);
		
		//DateOfDeposite(year taking more than 4 numbers)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='date_of_deposit']"))).sendKeys("10101999");	
		Thread.sleep(3000);
		
		//AccountType
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='account-type']"))).click();	
		Thread.sleep(3000);
		
		logger.info(" DepositAccountTypeDetails is woring");

	}
	
	
	//Once Add Member Number Then left information should not editable
	@Test(priority = 3)
	public void DepositorDetails() throws InterruptedException
	{
		System.out.println("DepositorDetails == not working properly");
		
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//MemberNo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='member-no']"))).sendKeys("0000000001");	
		Thread.sleep(3000);
		
		//Name(Should not be editable)
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='input-field']//input[@id='name']"))).clear();	
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='input-field']//input[@id='name']"))).sendKeys("Harry");	
//		Thread.sleep(3000);
//		
//		//Type
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='type']"))).clear();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='type']"))).sendKeys("Share Loader");	
//		Thread.sleep(3000);
//		
//		//Age(Taking more than 3 numbers)
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='age']"))).clear();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='age']"))).sendKeys("2300");	
//		Thread.sleep(3000);
//		
//		//Scroll
//		WebElement Scroll = driver.findElement(By.xpath("//input[@id='maturity-amount']"));
//	    Actions actions = new Actions(driver);
//	    actions.moveToElement(Scroll).perform();
//	    Thread.sleep(3000);
	    
	    logger.info("DepositorDetails is working");
	}
	
	
	//Once Add Member Number Then left information should not editable
	@Test(priority = 4)
	public void DepositDetails() throws InterruptedException
	{
		System.out.println("DepositorDetails == not working properly");
			
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			
//		//SelectPlan
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='plan-name']"))).sendKeys("0000000001");	
//		Thread.sleep(3000);
		
//		//Scroll
//		 WebElement Scroll = driver.findElement(By.xpath("//input[@id='maturity-amount']"));
//	     Actions actions = new Actions(driver);
//	     actions.moveToElement(Scroll).perform();
//	     Thread.sleep(3000);
		
		//for selecting random Plan
//		try 
//		{
//			List<WebElement> selectPlan=driver.findElements(By.xpath("//select[@id='plan-name']"));
//			
//			for (WebElement item : selectPlan) 
//			{
//                if (item.getText().contains("0000000001")) 
//                {
//                    item.click();
//                    break;
//                }
//			}
//			if (!selectPlan.isEmpty()) {
//				selectPlan.get(0).click(); // Select the first item
//                System.out.println("Plan option selected successfully.");
//            } else {
//                System.out.println("No plan options found.");
//            }
//		} 
//		catch (Exception e) {
//			System.out.println("not working");
//		}
	     
//	    List<WebElement> options = driver.findElements(By.cssSelector("#plan-name"));
//	    String s1="FD 1YR(12 MONTH - ROI 3%)";
//	    for (WebElement option : options) 
//	    {
//	        if (option.getText().equals(s1)) 
//	        {
//	            option.click();
//	            break;
//	        }
//	    }
		
		//SelectPlan
		WebElement selectPlan=driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/select[1]"));
		Select plans= new Select(selectPlan);
		List<WebElement> planOptions= plans.getOptions();
		String plan1="FD 1YR(12 MONTH - ROI 10%)";
		for (int i = 0; i < planOptions.size(); i++) 
		{
			if(planOptions.get(i).getText().equalsIgnoreCase(plan1))
			{
				planOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		
	    //MinimumDeposit
		//ReadOnlyMode
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='minimum-deposit']"))).click();	
	    Thread.sleep(3000);
	    
	    //DepositAmount
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='deposit-amount']"))).sendKeys("500");	
	    Thread.sleep(3000);
	    
	    //ClickOnSC_ROI
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='senior-citizen']"))).click();	
	    Thread.sleep(3000);
	    
	    logger.info("DepositDetails is working");
	    
	}
	
	@Test(priority = 5)
	public void maturityDetails() throws Exception
	{
		System.out.println("MaturityDetails == not working properly");
		
		//InterestPayOutType(Not Able to Select)
		WebElement interestPayoutType = driver.findElement(By.xpath("//select[@id='interest-payout-type']"));
		Select payoutType = new Select(interestPayoutType);
		List<WebElement> payoutTypeOptions = payoutType.getOptions();
		String type="Periodic";
		for (int i = 0; i < payoutTypeOptions.size(); i++) 
		{
			if(payoutTypeOptions.get(i).getText().equalsIgnoreCase(type))
			{
				payoutTypeOptions.get(i).click();
				break;
			}
			
		}
		Thread.sleep(3000); 

	    //ActionOnMaturity
		WebElement actionOnMaturity = driver.findElement(By.xpath("//select[@id='action-on-maturity']"));
		Select action=new Select(actionOnMaturity);
		List<WebElement> actionOption= action.getOptions();
		String action1="Decide On Maturity Date";
		for (int i = 0; i < actionOption.size(); i++) 
		{
			if(actionOption.get(i).getText().equalsIgnoreCase(action1))
			{
				actionOption.get(i).click();
				break;
			}
		}
	    Thread.sleep(3000);
	    
	    //RateOfInterest
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rate-of-interest"))).click();	
	    Thread.sleep(3000);
	    
	    //InterestAmount
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("interest-amount"))).click();	
	    Thread.sleep(3000);
	    
	  //MaturityDate
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("maturity_date"))).click();	
	    Thread.sleep(3000);
	    
	  //MaturityAmount
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("maturity-amount"))).click();	
	    Thread.sleep(3000);
	    
	  //Scroll Page
	    WebElement Scroll1 = driver.findElement(By.xpath("//button[normalize-space()='Submit Application']"));
	    Actions actions = new Actions(driver);
	    actions.moveToElement(Scroll1).perform();
	    Thread.sleep(3000);
	  
	    logger.info("maturityDetails is working");
	}
	
	
	@Test(priority = 6)
	public void NomineeDetails() throws Exception
	{
		System.out.println("NomineeDetails == not working properly");
		
		//NomineeName
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nominee-name"))).click();	
	    Thread.sleep(3000);
	    
	  //Relation
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("relation"))).click();	
	    Thread.sleep(3000);
	    
	  //NomineeAddress
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nominee-address"))).click();	
	    Thread.sleep(3000);
	    
	  //NomineeDateOfBirth
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nominee_dob"))).click();	
	    Thread.sleep(3000);
	    
	  //NomineeAge
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nominee-age"))).click();	
	    Thread.sleep(3000);
	    
	  //GuardianName
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gur-name"))).click();	
	    Thread.sleep(3000);
	    
	    logger.info("NomineeDetails is working");
	}
	
	@Test(priority = 7)
	public void ReferredDetails() throws Exception
	{
		//ReferredBy(Accepting numbers and special characters)
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("referred-by"))).sendKeys("John Wick");;	
	    Thread.sleep(3000);
	    
	    logger.info("ReferredDetails is working");
	}
	
	@Test(priority = 8)
	public void SubmitApplication() throws Exception
	{
		//ClickOnSubmit
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit Application']"))).click();	
	    Thread.sleep(3000);
	    
	    logger.info("SubmitApplication is working");
	}

}
