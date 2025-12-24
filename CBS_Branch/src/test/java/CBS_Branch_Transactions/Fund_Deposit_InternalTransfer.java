package CBS_Branch_Transactions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//Done
public class Fund_Deposit_InternalTransfer extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	double availableBalanceBeforeDeposit2 ;
	double availableBalanceAfterDeposit2 ;
	
	@Test(priority = 1)
	public void fundDeposit_ForBalanceCheck1() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation 
		driver.navigate().to("https://demo.techplex.in/transaction/deposit");
				
		//Account NO
		//Used Account where money deposited
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountNo"))).click();
		System.out.println("----------Add Account No ----------");
		Thread.sleep(10000);
				
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='showRemainingFields()']"))).click();
		Thread.sleep(2000);
				
		//Available Balance
		WebElement balance1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='modal-balance']")));
		String BalanceBeforeDeposit2 = balance1.getAttribute("value").replaceAll("[^\\d.]", "").trim();
		availableBalanceBeforeDeposit2 = Math.round(Double.parseDouble(BalanceBeforeDeposit2) * 100.0) / 100.0;
		System.out.println("Balance After Depost = " +availableBalanceBeforeDeposit2);	
		Thread.sleep(5000);
	}
	
	@Test(priority = 2)
	public void Fund_Deposit_IT() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigate
		driver.navigate().to("https://demo.techplex.in/transaction/deposit");
		Thread.sleep(3000);

		//InternalTransfer
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Internal Transfer']"))).click();
		Thread.sleep(2000);
		
		//From Account Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acc_no"))).click();
		System.out.println("----------Add Account No Manually----------");
		Thread.sleep(10000);
		
		//To Account Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acc_no_to"))).click();		
		System.out.println("----------Add Account No Manually----------");
		Thread.sleep(10000);
		
		//Payment Through
		//selected ByDefault
		
		//EnterAmount 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount"))).sendKeys("1000");
		Thread.sleep(2000);
		
		//Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description"))).sendKeys("Done Through Automation");
		Thread.sleep(2000);
		
		//ClickOnSubmit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit']"))).click();
		Thread.sleep(2000);
		
		//pop-up Accept
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Yes, transfer it!']"))).click();
		System.out.println("----------Copy Voucher code----------");
		Thread.sleep(10000);
		
		//ClickOnOK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);		
	}
	

	@Test (priority = 3)
	public void checkRequestInVoucher() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//clickOnVoucher
		//direct Navigate
		driver.navigate().to("https://demo.techplex.in/transaction/showpendingvoucher");
		Thread.sleep(2000);
		
		//addVoucherNumberManualy
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("voucher_no"))).click();
		System.out.println("-------Add Voucher number manually-------");
		Thread.sleep(10000);
		
		//SearchTransaction
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search Transaction']"))).click();
		Thread.sleep(2000);
		
		//Click on Approve voucher
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Approve Voucher']"))).click();
		Thread.sleep(10000);
		
		//ApproveTransaction
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Approve Transaction']"))).click();
		Thread.sleep(2000);
		
		//YesApprove
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Yes, Approve']"))).click();
		Thread.sleep(2000);
		
		//ClickOnOK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 4)
	public void fundDeposit_ForBalanceCheck2() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation 
		driver.navigate().to("https://demo.techplex.in/transaction/deposit");
		
		//Account NO
		//Used Account where money deposited
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountNo"))).click();
		System.out.println("----------Add Account No ----------");
		Thread.sleep(10000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='showRemainingFields()']"))).click();
		Thread.sleep(2000);
		
		//Available Balance
		WebElement balance2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='modal-balance']")));
		String BalanceAfterDeposit2 = balance2.getAttribute("value").replaceAll("[^\\d.]", "").trim();
		availableBalanceAfterDeposit2 = Math.round(Double.parseDouble(BalanceAfterDeposit2)* 100.0) / 100.0;
		System.out.println("Balance After Deposit = " +availableBalanceAfterDeposit2);	
		
		System.out.println("Balance Change");
		System.out.println();
		System.out.println("Balance before Deposit = " +availableBalanceBeforeDeposit2);	
		System.out.println("Balance After Deposit = " +availableBalanceAfterDeposit2);
		System.out.println("Balance Added = "+(availableBalanceAfterDeposit2 - availableBalanceAfterDeposit2));
	}
}
