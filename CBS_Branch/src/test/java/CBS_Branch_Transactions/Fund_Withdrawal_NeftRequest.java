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

//pending because its live

public class Fund_Withdrawal_NeftRequest extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void FundWithdrawal() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigate
		driver.navigate().to("https://demo.techplex.in/transaction/withdrawal");
		
		//AccountNumber
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountNo"))).click();
		System.out.println("----------Enter Account No Manually----------");
		Thread.sleep(10000);
		
		//ViewDetails
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("//button[@id='showButton']"))).click();
		Thread.sleep(2000);

		//PaymentMode
		WebElement paymentMode = driver.findElement(By.id("mode"));
		Select modes = new Select(paymentMode);
		List<WebElement> paymentOptions = modes.getOptions();
		String PM1="Payout";
		for (int i = 0; i < paymentOptions.size(); i++) 
		{
			if(paymentOptions.get(i).getText().equalsIgnoreCase(PM1))
			{
				paymentOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//NEFT FORM
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount"))).sendKeys("10");
		Thread.sleep(2000);
		
		//Beneficiary Details
		//Beneficiary Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("beneficiary_name"))).sendKeys("Sunitha");
		Thread.sleep(2000);

		//Beneficiary Account Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("beneficiary_accountno"))).sendKeys("003001200002");
		Thread.sleep(2000);
		
		//beneficiary Mobile Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("beneficiary_mobile"))).sendKeys("9988776655");
		Thread.sleep(2000);
		
		//beneficiary mail
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirm_beneficiary_account"))).sendKeys("sunitha@gmail.com");
		Thread.sleep(2000);
		
		//Bank Details
		//Bank Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("beneficiary_bank"))).sendKeys("SBI Bank");
		Thread.sleep(2000);
		
		//Branch Name 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("beneficiary_branch"))).sendKeys("Hinjewadi");
		Thread.sleep(2000);
		
		//IFSC Code
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("beneficiary_ifsc"))).sendKeys("SBIN1234");
		Thread.sleep(2000);
		
		//Beneficiary Address
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("beneficiary_address"))).sendKeys("Hinjewadi, Wipro circle phase 2, Pune");
		Thread.sleep(2000);
		
		//Transfer
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Transfer']"))).click();
		Thread.sleep(2000);
		
		//ClickOnOK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
	}
	
	@Test(priority = 2)
	public void checkNEFTRequest() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigate
		driver.navigate().to("https://demo.techplex.in/transaction/withdrawal");
		Thread.sleep(2000);
		
//		//Click On Transaction
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='menu-title title-color font-medium'][normalize-space()='Transaction']"))).click();
//		Thread.sleep(2000);
//		
//		//Click On Fund withdrawal
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Fund Withdrawal']"))).click();
//		Thread.sleep(2000);
//		
//		//Click on Neft Request
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='View Neft Request']"))).click();
//		Thread.sleep(2000);
		
		//Account No
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_no"))).sendKeys("003001100001");
		Thread.sleep(2000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchButton"))).click();
		Thread.sleep(4000);
		
		//Approve
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[14]/button[1]"))).click();
		Thread.sleep(5000);
		
	}
}
