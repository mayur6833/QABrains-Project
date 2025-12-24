package CBS_Branch_CoreBankingService_SavingAccount;

import java.text.DecimalFormat;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class SB_Calulator extends BaseLoginForAllBranchModules
{
	WebDriver driver;
	WebDriverWait wait;
	double depositAmount;
	double interestAmount;
	double interest;
	
	//Convert to Decimal
	DecimalFormat df = new DecimalFormat("###0.00");
	
	@Test(priority = 1)
	public void SB_Calculator_Deposit() throws InterruptedException
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/sbcalculator");
		Thread.sleep(2000);

		//Amount
		WebElement Amount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount")));
		Amount.sendKeys("10000");
		
		//TransactionType	
		//Deposit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("deposit-label"))).click();
		Thread.sleep(2000);
		
		//InterestRate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("interestRate"))).sendKeys("12");
		Thread.sleep(2000);
		
		//TransactionDate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("transactionDate"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("transactionDate"))).sendKeys("2024-10-09");
		Thread.sleep(2000);
		
		//clickOnAddTransaction
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("interestRate"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Add Transaction']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//Current balance
		WebElement balanceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("totalBalanceDisplay")));
        String amountText = balanceElement.getText().replaceAll("[^\\d.]", "").trim();;
        depositAmount = Math.round(Double.parseDouble(amountText)*100.00)/100.00;
        System.out.println("depositAmount: " + df.format(depositAmount));
        Thread .sleep(2000);
	}
	
	@Test(priority = 2)
	public void calculator_Withdraw() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount"))).sendKeys("10000");
		Thread.sleep(2000);
		
		//TransactionType	
		//withdraw
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("withdraw-label"))).click();
		Thread.sleep(2000);
		
		//InterestRate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("interestRate"))).clear();
		WebElement interestRate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("interestRate")));
		interestRate.sendKeys("12");
		String deposit = interestRate.getAttribute("value").replaceAll("[^\\d.]", "").trim();
		interest = Math.round(Double.parseDouble(deposit)*100.0)/100.0;
		System.out.println("ROI = "+df.format(interest));
		Thread.sleep(2000); 
		
		//TransactionDate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("transactionDate"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("transactionDate"))).sendKeys("2025-10-09");
		Thread.sleep(2000);
		
		//clickOnAddTransaction
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("interestRate"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//Interest Amount
		WebElement interestA = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("totalInterestDisplay")));
        String interestAmountText = interestA.getText().replaceAll("[^\\d.]", "").trim();;
        interestAmount = Math.round(Double.parseDouble(interestAmountText)*100.00)/100.00;
        System.out.println("Interest Amount: " + df.format(interestAmount));
        Thread.sleep(2000);
	}
	
	@Test(priority = 3)
	public void calculations() throws Exception
	{
		System.out.println("\n\n-----Script Calculation-----");
		
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		double deposit = depositAmount;
		int tenure = 12;
		double interestRate = interest;
		
		//Calculations
		double tenureInYears = tenure / 12.0;
		double simpleInterest = (deposit * interestRate * tenureInYears) / 100;
		double totalEarnedAmount = deposit + simpleInterest;
		double interestEarn = totalEarnedAmount - deposit;
		
		System.out.println("Total Interst Earn: "+df.format(interestEarn));
        System.out.println("Total Earned Amount: " + df.format(totalEarnedAmount));
        
        if(Math.round(interestEarn - interestAmount) < 0.01)
        {
        	System.out.println("Calculation is right");
        }
        else
        {
        	System.out.println("Calculation is wrong");
        }
	}
	
	@Test(priority = 3)
	public void clearAll() throws InterruptedException
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//ClickOnClearAll
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/button[1]"))).click();
		Thread.sleep(2000);
		
		//ClickOnPopUp
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[3]/button[2]"))).click();
		Thread.sleep(2000);
	}
}
