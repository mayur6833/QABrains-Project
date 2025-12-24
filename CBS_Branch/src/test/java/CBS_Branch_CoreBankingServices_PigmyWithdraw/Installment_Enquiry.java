package CBS_Branch_CoreBankingServices_PigmyWithdraw;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//Pending

public class Installment_Enquiry extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void installmentEnquiry() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/baccounts/closure_pigmy_withdraw");
		Thread.sleep(2000);
		
		//Account NO
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accno"))).click();
		System.out.println("-----Add Account No-----");
		Thread.sleep(10000);
				
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='searchButton']"))).click();
//		Thread.sleep(2000);
//				
//		//OK
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(10000);
	}
}
