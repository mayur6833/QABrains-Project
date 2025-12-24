package CBS_Branch_Loan_IndividualLoan;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import LoginBranch.BaseLoginForAllBranchModules;

//Pending

public class Repayment_Schedule extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	public void repaymentSchedule() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct navigation
		driver.navigate().to("https://demo.techplex.in/admin-loan/repayment_schedule");
		
		//Member ID 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Date']"))).click();
		System.out.println("-----Add Member ID-----");
		Thread.sleep(10000);
		
		//Search 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='searchButton']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(10000);
	}
}
