package CBS_Branch_Agent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class Agent_Report extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test (priority = 1)
	public void agentReport() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct navigation
		driver.navigate().to("https://demo.techplex.in/customer-enrollment/agentreport");
		Thread.sleep(2000);
		
		//Agent ID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("agent_id"))).sendKeys("SWMT-A0052");
		Thread.sleep(2000);
		
		//report option
		String reportXpaths[] = {
		    "//div[@onclick=\"selectReportType('staff-downline', event)\"]",
		    "//div[@onclick=\"selectReportType('daily-collection', event)\"]",
		    "//div[@onclick=\"selectReportType('staff-business', event)\"]"
		};
		for (int i = 0; i< reportXpaths.length;i++) 
		{
			WebElement report = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reportXpaths[i])));
			report.click();
			Thread.sleep(15000);
		}
	}
}
