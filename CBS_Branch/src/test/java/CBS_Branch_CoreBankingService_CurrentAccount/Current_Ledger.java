package CBS_Branch_CoreBankingService_CurrentAccount;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class Current_Ledger extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	
	@Test(priority = 1)
	public void currentLedger() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigation
		driver.navigate().to("https://demo.techplex.in/baccounts/ledger_current");
		Thread.sleep(2000);
		
		//account Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acc_no"))).click();
		System.out.println("-----Add Account no Manually-----");
		Thread.sleep(10000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(5000);
	}	
}
