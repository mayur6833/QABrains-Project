package CBS_Branch_Transactions;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;


public class Fund_Withdrawal extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	double availableBalanceBeforeWithdraw2;
	double availableBalanceAfterwithdraw2;
	int withdrawAmountCal;
	
	@Test(priority = 1)
	public void Fund_Withdrawal_Navigation() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));	
		
		//Direct Navigate
		driver.navigate().to("https://demo.techplex.in/transaction/withdrawal");
		Thread.sleep(2000);

		//AccountNumber
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountNo"))).sendKeys("003001200001");
		Thread.sleep(2000);
		
		//ViewDetails
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showButton"))).click();
		Thread.sleep(2000);
		
		System.out.println("Amount Before Withdraw");
		
		//Available Balance
		WebElement balance1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='modal-balance']")));
		String BalanceBeforeWithdraw2 = balance1.getAttribute("value").replaceAll("[^\\d.]", "").trim();
		availableBalanceBeforeWithdraw2 = Math.round(Double.parseDouble(BalanceBeforeWithdraw2) * 100.0) / 100.0;
		System.out.println("Balance before withdraw = " +availableBalanceBeforeWithdraw2);	
		Thread.sleep(5000);
		
		//Payment Mode 
		WebElement paymentMode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mode")));
		Select selectPaymentMode = new Select(paymentMode);
		List<WebElement> mode = selectPaymentMode.getOptions();
		String PM = "Cash";
		for (int i = 0; i < mode.size(); i++) 
		{
			if(mode.get(i).getText().equalsIgnoreCase(PM))
			{
				mode.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Table
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denomination_100"))).sendKeys("1");
		Thread.sleep(2000);
		
		//withdrawal Amount
		WebElement Amount1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount")));
		String withdrawAmount1 = Amount1.getAttribute("value").replaceAll("[^\\d.]", "").trim();
		withdrawAmountCal = Integer.parseInt(withdrawAmount1);
		System.out.println("Withdrawal Amount = " +withdrawAmountCal);	
		Thread.sleep(5000);
		
		System.out.println();
		
		//remark
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("remark"))).sendKeys("Done");
		Thread.sleep(2000);
		
		//Submit Transaction
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit Transaction']"))).click();
		System.out.println("----------Copy Voucher No----------");
		Thread.sleep(10000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test (priority = 2)
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
	
	@Test(priority = 3)
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
		
		System.out.println();
		
		//Available Balance
		WebElement balance2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='modal-balance']")));
		String BalanceAfterwithdraw2 = balance2.getAttribute("value").replaceAll("[^\\d.]", "").trim();
		availableBalanceAfterwithdraw2  = Math.round(Double.parseDouble(BalanceAfterwithdraw2 )* 100.0) / 100.0;
		System.out.println("Balance After Deposit = " +availableBalanceAfterwithdraw2);	
		
		System.out.println("Balance Change");
		System.out.println();
		System.out.println("Calculations..");
		System.out.println("Calculation = " + availableBalanceBeforeWithdraw2 + " -s " +withdrawAmountCal +" = " + (availableBalanceBeforeWithdraw2 - withdrawAmountCal));	
		System.out.println("Balance After withdrawal = " +availableBalanceAfterwithdraw2);
	}
}