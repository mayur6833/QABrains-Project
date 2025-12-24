package CBS_Branch_CoreBankingService_FD;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import CBS_Branch_Transactions.Voucher_Approval;
import LoginBranch.BaseLoginForAllBranchModules;


public class FD_PayMaturity extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	String PolicyNumber;
	String payMaturityVoucher;
	
	//all class Object that will use to run FD_PayMaturity
	Voucher_Approval approve = new Voucher_Approval();
	
	@Test(priority = 1)
	public void PayMaturity() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation 
		driver.navigate().to("https://demo.techplex.in/baccounts/fdMaturity");
		Thread.sleep(2000);
		
		//EnterPolicyNumber
		WebElement policyNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("policy-number")));
		policyNo.click();
		System.out.println("-----Add Policy Number-----");
		Thread.sleep(10000);
		PolicyNumber = policyNo.getAttribute("value");
		System.out.println(PolicyNumber);
		
		
		//Fetch button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@value='Fetch PreMaturity Details']"))).click();
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//Transfer to Select
		WebElement transferToAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='amount_transfer_to_acc']")));
		Select selectTransferType = new Select(transferToAccount);
		List<WebElement> transfer = selectTransferType.getOptions();
		String TTS = "Cash";
		for (int i = 0; i < transfer.size(); i++) 
		{
			if(transfer.get(i).getText().equalsIgnoreCase(TTS))
			{
				transfer.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Submit 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addButton"))).click();
		WebElement copyPayMaturityVoucher = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/p[2]")));
		payMaturityVoucher = copyPayMaturityVoucher.getText().replaceAll("Voucher No: ", "").trim();
		Thread.sleep(10000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void vocherAccept() throws Exception
	{	
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//clickOnVoucher
		//direct Navigate
		driver.navigate().to("https://demo.techplex.in/transaction/showpendingvoucher");
		Thread.sleep(2000);
		
		//Automatically fetch Voucher Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("voucher_no"))).sendKeys(payMaturityVoucher);
		Thread.sleep(2000);
		
		approve.VoucherApprove();
	}
	
	@Test(priority = 3)
	public void checkReport() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigate
		driver.navigate().to("https://demo.techplex.in/View_fd_account");
		Thread.sleep(2000);	
			
		//AccountNo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_no"))).sendKeys(PolicyNumber);
		Thread.sleep(2000);
			
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))).click();
		Thread.sleep(2000);
			
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(10000);
	}
}
