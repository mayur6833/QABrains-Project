package CBS_Branch_CoreBankingService_SavingAccount;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;


public class Closure_SB_Accounts extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	Search_SB_Accounts searchSBAccount = new Search_SB_Accounts();

		
	@Test(priority = 1)
	public void Closure_SB() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/baccounts/closer_sb");
		Thread.sleep(2000);
		
		//Account No
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountNo"))).click();
		System.out.println("-----Account No Manually-----");
		Thread.sleep(10000);
			
		//ClickOnSearch
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))).click();	
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();	
		Thread.sleep(2000);
		
		//Action Closed 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Mark Inactive']"))).click();
		Thread.sleep(2000);
		
//		//Sure Pop-up
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Yes, close it!']"))).click();
//		Thread.sleep(2000);
//		
//		//OK
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
//		Thread.sleep(2000);
		
	}
	
	@Test(priority = 2)
	public void checkAccountStatus() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		searchSBAccount.Search_SBAccount();
	}
	
}
