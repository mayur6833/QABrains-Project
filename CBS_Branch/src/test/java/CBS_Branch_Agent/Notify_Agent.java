package CBS_Branch_Agent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class Notify_Agent extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void notifyAgent() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/customer-enrollment/notify_agent");
		Thread.sleep(2000);
		
		//Notification Heading
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notification_heading"))).sendKeys("Testing");
		Thread.sleep(2000);
		
		//Notification Message
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notification_message"))).sendKeys("Automation Testing");
		Thread.sleep(2000);
		
		//submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit']"))).click();
		Thread.sleep(10000);		
	}
}
