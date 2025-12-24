package CBS_Branch_Agent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;


public class View_Agent extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void viewAgent() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//navigate to view Agent
		driver.navigate().to("https://demo.techplex.in/customer-enrollment/view_agent");
		Thread.sleep(2000);
		
		//Agent No
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("agent_bo"))).sendKeys("SWMT-A0052");
		Thread.sleep(2000);
		
		//Search 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBtn"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(10000);
	}
}
