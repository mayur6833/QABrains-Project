package CBS_Branch_CoreBankingServices_PigmyDeposit;

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
	public void InstallmentEnquiry() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/baccounts/pigmy_install_enq");
		Thread.sleep(2000);
		
		//Customer account No
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accno"))).click();
		System.out.println("-----Add Account No-----");
		Thread.sleep(10000);
		
		//Confirm
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchButton"))).click();
		Thread.sleep(10000);
	}
}
