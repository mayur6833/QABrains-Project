package CBS_Branch_Agent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class Loan_Collection_Report extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void LoanCollectionReport() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation 
		driver.navigate().to("https://demo.techplex.in/customer-enrollment/loan_coll_rep");
		Thread.sleep(2000);
		
		//Agent No
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("agent_no"))).sendKeys("SWMT-A0037");
		Thread.sleep(2000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).sendKeys("SWMT-A0037");
		Thread.sleep(10000);
	}
}
