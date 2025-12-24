package CBS_Branch_CoreBankingService_RD;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import CBS_Branch_Transactions.Voucher_Approval;
import LoginBranch.BaseLoginForAllBranchModules;

// Transfer Account Details , Penalty details Pending

public class Pay_Maturity extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	String PolicyNumber;
	String PayMaturityVoucherNO;
	
	Voucher_Approval vc = new Voucher_Approval();
	
	@Test(priority = 1)
	public void PayMaturity() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/rd-maturity");
		Thread.sleep(2000);
		
		//Enter Policy Number 
		WebElement policyNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("policy-number")));
		policyNo.click();
		System.out.println("-----Enter Policy Number-----");
		Thread.sleep(10000);
		PolicyNumber = policyNo.getAttribute("value");
		System.out.println("Policy No: "+PolicyNumber);
		
		//Fetch Maturity details 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@value='Fetch Maturity Details']"))).click();
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//Transfer to Account
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount_transfer_to_acc"))).click();
		System.out.println("-----Select Transfer Account Number-----");
		Thread.sleep(10000);
		
		//Submit 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='addButton']"))).click();
		WebElement copyPayMaturityVoucherNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='swal2-html-container'])[1]")));
		PayMaturityVoucherNO = copyPayMaturityVoucherNo.getText().replaceAll("Voucher generated successfully. Awaiting approval. Voucher No: ", "").trim();
		Thread.sleep(10000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void voucherAccept() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigate
		driver.navigate().to("https://demo.techplex.in/transaction/showpendingvoucher");
		Thread.sleep(2000);
		
		//Automatically fetch Voucher Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("voucher_no"))).sendKeys(PayMaturityVoucherNO);
		Thread.sleep(2000);
		
		vc.VoucherApprove();
	}
	
	@Test(priority = 3)
	public void checkReport() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct navigation
		driver.navigate().to("https://demo.techplex.in/baccounts/view_rdreports");
		Thread.sleep(2000);
		
		//Search Type
		WebElement searchType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_type")));
		Select selectSearchType = new Select(searchType);
		selectSearchType.selectByValue("account_no");
		Thread.sleep(2000);
		
		//Enter Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-content"))).sendKeys(PolicyNumber);
		Thread.sleep(2000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-submit']"))).click();
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(7000);	
	}
}
