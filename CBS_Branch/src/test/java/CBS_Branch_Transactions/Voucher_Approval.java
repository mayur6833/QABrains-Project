package CBS_Branch_Transactions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class Voucher_Approval extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void VoucherApproveforTransactionModule() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//clickOnVoucher
		//direct Navigate
		driver.navigate().to("https://demo.techplex.in/transaction/showpendingvoucher");
		Thread.sleep(2000);
		
		//Automatically fetch Voucher Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("voucher_no"))).click();
		System.out.println("-----Add Voucher NO Manually-----");
		Thread.sleep(10000);
	}
	
	@Test(priority = 2)
	public void VoucherApprove() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
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
}
