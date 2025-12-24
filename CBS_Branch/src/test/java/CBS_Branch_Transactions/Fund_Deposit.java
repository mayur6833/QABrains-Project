package CBS_Branch_Transactions;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class Fund_Deposit extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	String memberAccountNumber;
	double amountBeforeDeposit ;
	double availableBalanceAfterDeposit ;
	int depositAmountCal;
	String voucherNo;
	
	//Convert to decimal
	DecimalFormat df = new DecimalFormat("###0.00");
	
	//all class Object that will use to run Fund_Deposit
	Voucher_Approval acceptVoucher = new Voucher_Approval();
	
	
	@Test(priority = 1)
	public void fundDeposit() throws Exception
	{
		//Before Deposit Amount
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation 
		driver.navigate().to("https://demo.techplex.in/transaction/deposit");
		Thread.sleep(2000);
				
		//Account NO
		//Used Account where money deposited
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountNo"))).click();
		System.out.println("----------Add Account No ----------");
		Thread.sleep(10000);
		
		WebElement accountNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountNo")));
		memberAccountNumber = accountNumber.getAttribute("value").trim();
//		System.out.println("Memeber Account Number: "+memberAccountNumber);
		Thread.sleep(2000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='showRemainingFields()']"))).click();
		Thread.sleep(2000);
		
		//Actual Amount
		WebElement ActualAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='modal-balance']")));
		String ActualBalanceText = ActualAmount.getAttribute("value").replaceAll("[^\\d.]", "").trim();
		amountBeforeDeposit = Math.round(Double.parseDouble(ActualBalanceText) * 100.0) / 100.0;
//		System.out.println("Balance Before Deposit: "+df.format(amountBeforeDeposit));		
		Thread.sleep(2000);
		
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
		
		//deposit Amount
		WebElement Amount1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount")));
		String depositAmount1 = Amount1.getAttribute("value").replaceAll("[^\\d.]", "").trim();
		depositAmountCal = Integer.parseInt(depositAmount1);
//		System.out.println("Deposit Amount = " +depositAmountCal);	
		Thread.sleep(5000);
		
		System.out.println();
		
		//remark
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("remark"))).sendKeys("Done");
		Thread.sleep(2000);
		
		//Submit Transaction
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit Transaction']"))).click();
	    WebElement copyVoucherNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]")));
	    voucherNo = copyVoucherNo.getText().replaceAll("Voucher No: ", "").trim();
	    System.out.println("Voucher No: "+voucherNo);
	    Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);

	}
	
	@Test (priority = 2)
	public void approveVoucher() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//clickOnVoucher
		//direct Navigate
		driver.navigate().to("https://demo.techplex.in/transaction/showpendingvoucher");
		Thread.sleep(2000);
		
		//Automatically fetch Voucher Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("voucher_no"))).sendKeys(voucherNo);
		Thread.sleep(2000);
		
		acceptVoucher.VoucherApprove();	
	}
	
	@Test(priority = 3)
	public void fundDeposit_ForBalanceCheckAfterDeposit() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		System.out.println("Balance Before Deposit: "+df.format(amountBeforeDeposit));
		System.out.println("Deposit Amount = " +depositAmountCal);
		
		//Direct Navigation 
		driver.navigate().to("https://demo.techplex.in/transaction/deposit");
		
		//Account NO
		//Used Account where money deposited
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountNo"))).sendKeys(memberAccountNumber);
		Thread.sleep(2000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='showRemainingFields()']"))).click();
		Thread.sleep(2000);
		
		//Available Balance after deposit
		WebElement balance2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='modal-balance']")));
		String BalanceAfterDeposit2 = balance2.getAttribute("value").replaceAll("[^\\d.]", "").trim();
		availableBalanceAfterDeposit = Math.round(Double.parseDouble(BalanceAfterDeposit2)* 100.0) / 100.0;
		System.out.println("Balance After Deposit = " +availableBalanceAfterDeposit);	
		
		System.out.println();
		System.out.println("Calculations..");
		System.out.println("Calculation = " + amountBeforeDeposit + " + " +depositAmountCal +" = " + (amountBeforeDeposit + depositAmountCal));	
		System.out.println("Balance After Depost = " +availableBalanceAfterDeposit);
	}
}