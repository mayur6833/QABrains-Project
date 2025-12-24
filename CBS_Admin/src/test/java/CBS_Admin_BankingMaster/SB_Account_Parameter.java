package CBS_Admin_BankingMaster;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import loginAdmin.baseLoginForAllAdminModules;


public class SB_Account_Parameter extends baseLoginForAllAdminModules
{
	WebDriverWait wait ;
	String SchemeNameText;
	
	@BeforeTest
	public void SBAccountParameterNavigation()
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct navigation
		driver.navigate().to("https://demo.techplex.in/transaction/sbAcc-parameter");
	}
	
	@Test(priority = 1)
	public void SB_AccountScheme() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
//		//Direct navigation
//		driver.navigate().to("https://demo.techplex.in/transaction/sbAcc-parameter");
//		Thread.sleep(2000);
		
		//Create Account Scheme
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='toggleAccountSchemeBtn']"))).click();
		Thread.sleep(2000);
		
		//Account Scheme Name		
		WebElement SchemeName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='account_scheme_name']")));
		SchemeName.sendKeys("Auto Testing Scheme");
		SchemeNameText = SchemeName.getAttribute("value");
		//System.out.println(SchemeNameText);
		Thread.sleep(2000);
		
		//Submit Account Scheme
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save Account Scheme']"))).click();
		Thread.sleep(2000);
		
		//ClickOnOk
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);

//Add SB Account Parameter
		//SBType
		WebElement SBType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sb_type")));
		Select accountType = new Select(SBType);
		List<WebElement> types = accountType.getOptions();
		String SBT = SchemeNameText;
		for (int i = 0; i < types.size(); i++) 
		{
			if(types.get(i).getText().equalsIgnoreCase(SBT))
			{
				types.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//SBMinimumBalance
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter minimum balance']"))).sendKeys("2000");
		Thread.sleep(2000);
		
		//SB Maximum Balance
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter maximum balance']"))).sendKeys("10000000");
		Thread.sleep(2000);
		
		//SB RateOfInterest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter rate of interest']"))).sendKeys("7.5");
		Thread.sleep(2000);
		
		//Pay Interest On
		WebElement payInterest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("interest_payon")));
		Select selectInterestType = new Select(payInterest);
		selectInterestType.selectByValue("Monthly");
		Thread.sleep(2000);
		
		//SB Minimum Period
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter minimum period']"))).sendKeys("1");
		Thread.sleep(2000);
		
		//Service charge of Pre-closuer
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter service charges']"))).sendKeys("1000");
		Thread.sleep(2000);
		
		//Penalty If Minimum Balance Not Maintained
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter penalty']"))).sendKeys("500");
		Thread.sleep(2000);
		
		//Min Balance with Cheque (Staff)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter minimum balance (cheque staff)']"))).sendKeys("2000");
		Thread.sleep(2000);
		
		//Min Balance without Cheque (Staff) 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter minimum balance (no cheque staff)']"))).sendKeys("50000");
		Thread.sleep(2000);
		
		//InterestRateForStaff
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter staff interest rate']"))).sendKeys("8");
		Thread.sleep(2000);
		
		//ATM Charges
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter ATM charges']"))).sendKeys("250");
		Thread.sleep(2000);
		
		//ATM Withdraw Limit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter ATM withdraw limit']"))).sendKeys("100000");
		Thread.sleep(2000);
		
		//Withdraw Limit /Day
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter daily withdraw limit']"))).sendKeys("100000");
		Thread.sleep(2000);
		
		//UPI Daily Limit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter UPI daily limit']"))).sendKeys("100000");
		Thread.sleep(2000);
		
		//Deposit Limit / Day
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter deposit limit']"))).sendKeys("80000");
		Thread.sleep(2000);
		
		//Deposit Penalty (%)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter deposit penalty']"))).sendKeys("200");
		Thread.sleep(2000);
		
		//DisplayOnWebsiteButton
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='is_display_website']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='is_display_website']"))).click();
		Thread.sleep(2000);
		
		//Click on Add/Update Parameters
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Add/Update Parameters']"))).click();
		Thread.sleep(2000);
		
		//ClickOnOk
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		System.out.println("Scroll the page for checeking newly added SB Parameter");
		Thread.sleep(10000);
	}
}
