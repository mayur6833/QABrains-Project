package CBS_Branch_CoreBankingService_MIS;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import CBS_Branch_Transactions.Voucher_Approval;
import LoginBranch.BaseLoginForAllBranchModules;

// Pending (Voucher Accept)

public class MIS_PayMaturity extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	String policyNumber ;
	String payMaturityVoucherNo;
	
	Voucher_Approval approve = new Voucher_Approval();
	
	@Test(priority = 1)
	public void MISpayMaturity() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigate
		driver.navigate().to("https://demo.techplex.in/transaction/mispay");
		Thread.sleep(2000);
		
		//Enter Policy No
		WebElement policyNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("policy-number")));
		policyNo.click();
		System.out.println("----------Add Policy No Manually----------");
		Thread.sleep(10000);
		policyNumber= policyNo.getAttribute("value");
		System.out.println("Policy No: "+policyNumber);
		
		//fetched Maturity details 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@value='Fetch Maturity Details']"))).click();
		Thread.sleep(10000);
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[normalize-space()='OK'])[1]"))).click();
		Thread.sleep(10000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@value='Fetch Maturity Details']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[normalize-space()='OK'])[1]"))).click();
		Thread.sleep(2000);
		
		//Transfer Account
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='amount_transfer_to_acc']"))).click();
		System.out.println("-----Select Transfer Account-----");
		Thread.sleep(10000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addButton"))).click();
		WebElement copyPaymaturityVoucherNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/p[2]")));
		payMaturityVoucherNo = copyPaymaturityVoucherNo.getText().replaceAll("Voucher No: ", "").trim();
		System.out.println("Voucher NO: "+payMaturityVoucherNo);
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[normalize-space()='OK'])[1]"))).click();
		Thread.sleep(2000);
		
	}
	
	@Test(priority = 2)
	public void acceptVoucher() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigate
		driver.navigate().to("https://demo.techplex.in/transaction/showpendingvoucher");
		Thread.sleep(2000);
		
		//Automatically fetch Voucher Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("voucher_no"))).sendKeys(payMaturityVoucherNo);
		Thread.sleep(2000);
		
		approve.VoucherApprove();
	}
	
	@Test(priority = 3)
	public void MISledger() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Account Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acc_no"))).sendKeys(policyNumber);
		Thread.sleep(2000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBtn"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(7000);
	}
}
