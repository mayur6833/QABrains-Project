package CBS_Branch_Transactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//Not Working

public class Loan_Disbursment extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void Loan_Disbursement_Navigation() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/loandisbursementpayment");
		Thread.sleep(2000);
		
		//LoanNo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loanno"))).click();
		Thread.sleep(2000);
		
		//MemberID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mem"))).sendKeys("0000000001");
		Thread.sleep(2000);
		
		//LoanAccountHolderName
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accname"))).sendKeys("RAMESH");
		Thread.sleep(2000);
		
		//disbursmentPaymentDate
		
		
		//LoanProductName
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pname"))).sendKeys("GOLD LOAN");
		Thread.sleep(2000);
		
		//LoanAmount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amt"))).sendKeys("5000");
		Thread.sleep(2000);
		
		//Processing Fees
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fee"))).sendKeys("200");
		Thread.sleep(2000);
		
		//LoanInterest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("interest"))).sendKeys("2.9");
		Thread.sleep(2000);
		
		//GST
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gst"))).click();
		Thread.sleep(2000);
		
		//ConfirmButton
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchButton"))).click();
		Thread.sleep(2000);
		
		//OkButton
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
}
//Not Working