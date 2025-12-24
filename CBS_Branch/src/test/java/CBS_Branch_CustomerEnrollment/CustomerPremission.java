package CBS_Branch_CustomerEnrollment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//Pending

public class CustomerPremission extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void customerPermission() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Enter Member ID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member_id"))).click();
		System.out.println("----------Add Member ID Manually----------");
		Thread.sleep(10000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("searchButton"))).click();
		Thread.sleep(2000);
		
		//Permission
		//Net banking
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='net_banking']"))).click();
		Thread.sleep(2000);
		
		//Update
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("updatePermissionsButton"))).click();
		Thread.sleep(2000);
	}	
}
