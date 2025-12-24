package CBS_Branch_CoreBankingService_MIS;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//Pending

public class MIS_Renewal extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void MISRenewal() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		System.out.println("MIS_Renewal Section is pending");
		
		//Customer Account No
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accno"))).click();
		System.out.println("-----Add Account No-----");
		Thread.sleep(10000);
		
		//Confirm
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchButton"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(10000);
	}
}
