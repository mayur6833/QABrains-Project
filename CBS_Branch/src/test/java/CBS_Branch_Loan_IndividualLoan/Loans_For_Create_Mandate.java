package CBS_Branch_Loan_IndividualLoan;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//Pending

public class Loans_For_Create_Mandate extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;

	
	@Test(priority = 1)
	public void LoansForCreateMandate() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/admin-loan/view_mandate_loan");
		Thread.sleep(2000);
			
		//Loan Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Date']"))).click();
		System.out.println("-----Add Loan Number-----");
		Thread.sleep(10000);

		//Search 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='searchButton']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(10000);
	}
}
