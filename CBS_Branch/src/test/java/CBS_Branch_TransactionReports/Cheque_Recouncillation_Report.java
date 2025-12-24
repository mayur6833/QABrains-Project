package CBS_Branch_TransactionReports;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//Pending

public class Cheque_Recouncillation_Report extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void fundWithdrawalByCheque() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigate
		driver.navigate().to("https://demo.techplex.in/transaction/chk_reconci_report");
		Thread.sleep(2000);
		
		//AccountNumber
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountNo"))).click();
		System.out.println("----------Add Account No Manually----------");
		Thread.sleep(10000);
		
		//ViewDetails
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showButton"))).click();
		Thread.sleep(2000);
		
		//Remark
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='remark']"))).sendKeys("DONE");
		Thread.sleep(2000);
		
		//PaymentMode
		WebElement paymentMode = driver.findElement(By.id("mode"));
		Select modes = new Select(paymentMode);
		List<WebElement> paymentOptions = modes.getOptions();
		String PM1="Cheque";
		for (int i = 0; i < paymentOptions.size(); i++) 
		{
			if(paymentOptions.get(i).getText().equalsIgnoreCase(PM1))
			{
				paymentOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Withdrawal Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount"))).sendKeys("100");
		Thread.sleep(2000);
		
		//Cheque Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cheque_no"))).sendKeys("123456");
		Thread.sleep(2000);
		
		//Cheque Date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cheque_date"))).sendKeys("24/06/2025");
		Thread.sleep(2000);
		
		//Bank Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bank_name"))).sendKeys("SBI Bank");
		Thread.sleep(2000);
		
		//Remark
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("remark"))).sendKeys("Cheque Payment");
		Thread.sleep(2000);
		
		//submit transaction
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit Transaction']"))).click();
		System.out.println("****************Copy Voucher No****************");
		Thread.sleep(5000);
		
		//ClickOnOK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void ChequeRecouncillation() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigate
		driver.navigate().to("https://demo.techplex.in/transaction/chk_reconci_report");
		Thread.sleep(2000);
		
		System.out.println("Check Recouncillation Pending");
	}
}
