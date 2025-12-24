package CBS_Branch_Agent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class Collection_Sheet_Report extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void collectionSheetReport() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation 
		driver.navigate().to("https://demo.techplex.in/customer-enrollment/agentcollection");
		Thread.sleep(2000);
		
		//Agent No
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("done_by"))).sendKeys("SWMT-A0036");
		Thread.sleep(2000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-submit']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(10000);
	}
}
