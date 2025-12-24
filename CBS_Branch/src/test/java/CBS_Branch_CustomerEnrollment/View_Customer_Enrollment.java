package CBS_Branch_CustomerEnrollment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class View_Customer_Enrollment extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void viewCustomer() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigate 
		driver.navigate().to("https://demo.techplex.in/customer-enrollment/view_custome_enrollment");
		Thread.sleep(2000);
		
		//Member ID 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchMemberId"))).sendKeys("003001100001");
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))).click();
		//Action
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='odd']//i[@class='fas fa-eye']"))).click();
		Thread.sleep(10000);
		
	}

}
