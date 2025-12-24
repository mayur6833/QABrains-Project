package CBS_Branch_CustomerEnrollment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class Customer_Account_Details extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void AccountDetails() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigate 
		driver.navigate().to("https://demo.techplex.in/customer-enrollment/cust_account_details");
		Thread.sleep(2000);
		
		//Member ID 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("memberId"))).click();
		System.out.println("----------Add Member ID Manually----------");
		Thread.sleep(10000);
		
		//Click on Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Show Table']"))).click();
		Thread.sleep(10000);
	}
}
