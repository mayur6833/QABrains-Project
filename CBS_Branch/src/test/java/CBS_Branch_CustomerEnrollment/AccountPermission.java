package CBS_Branch_CustomerEnrollment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//Pending

public class AccountPermission extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void ACPermission() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigation
		driver.navigate().to("https://demo.techplex.in/customer-enrollment/accountPermissions");
		Thread.sleep(2000);
		
		//Member ID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member_id"))).click();
		System.out.println("----------Add Member ID manually----------");
		Thread.sleep(10000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchButton"))).click();
		Thread.sleep(2000);
		
		//Pending
	}
}
