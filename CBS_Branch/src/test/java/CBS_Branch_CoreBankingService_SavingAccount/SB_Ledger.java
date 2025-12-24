package CBS_Branch_CoreBankingService_SavingAccount;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//change direct navigate path according to URL

public class SB_Ledger extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void checkSBLedger() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigation
		driver.navigate().to("https://demo.techplex.in/baccounts/ledger_sb");
		Thread.sleep(2000);
		
		//account Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acc_no"))).click();
		System.out.println("----------Add Account No Manually------------");
		Thread.sleep(10000);
		
		//search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))).click();
		Thread.sleep(10000);
	}
}
