package CBS_Admin_BankingMaster;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import loginAdmin.baseLoginForAllAdminModules;

//Not Working

public class Loan_On_Deposit_Parameter extends baseLoginForAllAdminModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void loanOnDepositForFD() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/loanOnDeposit-parameter");
		Thread.sleep(2000);
		
		//Deposit Type 	
		WebElement depositType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='deposit_type']")));
		Select selectDepositType = new Select(depositType);
		selectDepositType.selectByContainsVisibleText("FD");
		Thread.sleep(2000);
		
		//Loan Rate On Deposit Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rate-on-deposit-amt"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rate-on-deposit-amt"))).sendKeys("50");
		Thread.sleep(2000);
		
		//Interest Calculation
		WebElement interestCalculation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("interest-calculation")));
		Select selectInterestCalculation = new Select(interestCalculation);
		List<WebElement> interest = selectInterestCalculation.getOptions();
		String s1 = "Quarterly";
		for (int i = 0; i < interest.size(); i++) 
		{
			if(interest.get(i).getText().equalsIgnoreCase(s1))
			{
				interest.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Loan ROI above Deposit rate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("roi-deposit-rate"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("roi-deposit-rate"))).sendKeys("6.5");
		Thread.sleep(2000);
		
		//Save Parameter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save Parameters']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(5000);
	}
	
	@Test(priority = 2)
	public void loanOnDepositForPigmy() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/loanOnDeposit-parameter");
		Thread.sleep(2000);
		
		//Deposit Type 	
		WebElement depositType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='deposit_type']")));
		Select selectDepositType = new Select(depositType);
		selectDepositType.selectByContainsVisibleText("Pigmy");
		Thread.sleep(2000);
		
		//Loan Rate On Deposit Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rate-on-deposit-amt"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rate-on-deposit-amt"))).sendKeys("50");
		Thread.sleep(2000);
		
		//Interest Calculation
		WebElement interestCalculation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("interest-calculation")));
		Select selectInterestCalculation = new Select(interestCalculation);
		List<WebElement> interest = selectInterestCalculation.getOptions();
		String s1 = "Quarterly";
		for (int i = 0; i < interest.size(); i++) 
		{
			if(interest.get(i).getText().equalsIgnoreCase(s1))
			{
				interest.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Loan ROI above Deposit rate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("roi-deposit-rate"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("roi-deposit-rate"))).sendKeys("6.5");
		Thread.sleep(2000);
		
		//Save Parameter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save Parameters']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(5000);
	}
	
	@Test(priority = 3)
	public void loanOnDepositForRD() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/loanOnDeposit-parameter");
		Thread.sleep(2000);
		
		//Deposit Type 	
		WebElement depositType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='deposit_type']")));
		Select selectDepositType = new Select(depositType);
		selectDepositType.selectByContainsVisibleText("RD");
		Thread.sleep(2000);
		
		//Loan Rate On Deposit Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rate-on-deposit-amt"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rate-on-deposit-amt"))).sendKeys("50");
		Thread.sleep(2000);
		
		//Interest Calculation
		WebElement interestCalculation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("interest-calculation")));
		Select selectInterestCalculation = new Select(interestCalculation);
		List<WebElement> interest = selectInterestCalculation.getOptions();
		String s1 = "Quarterly";
		for (int i = 0; i < interest.size(); i++) 
		{
			if(interest.get(i).getText().equalsIgnoreCase(s1))
			{
				interest.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Loan ROI above Deposit rate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("roi-deposit-rate"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("roi-deposit-rate"))).sendKeys("6.5");
		Thread.sleep(2000);
		
		//Save Parameter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save Parameters']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(5000);
	}
	
	@Test(priority = 4)
	public void loanOnDepositForMIS() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/loanOnDeposit-parameter");
		Thread.sleep(2000);
		
		//Deposit Type 	
		WebElement depositType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='deposit_type']")));
		Select selectDepositType = new Select(depositType);
		selectDepositType.selectByContainsVisibleText("MIS");
		Thread.sleep(2000);
		
		//Loan Rate On Deposit Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rate-on-deposit-amt"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rate-on-deposit-amt"))).sendKeys("50");
		Thread.sleep(2000);
		
		//Interest Calculation
		WebElement interestCalculation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("interest-calculation")));
		Select selectInterestCalculation = new Select(interestCalculation);
		List<WebElement> interest = selectInterestCalculation.getOptions();
		String s1 = "Quarterly";
		for (int i = 0; i < interest.size(); i++) 
		{
			if(interest.get(i).getText().equalsIgnoreCase(s1))
			{
				interest.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Loan ROI above Deposit rate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("roi-deposit-rate"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("roi-deposit-rate"))).sendKeys("6.5");
		Thread.sleep(2000);
		
		//Save Parameter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save Parameters']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(5000);
	}	
}
