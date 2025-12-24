package CBS_Branch_CoreBankingService_SharePayment;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class View_ShareReport extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void viewShareReport() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/view-sharePayment");
		Thread.sleep(2000);
		
		//member ID 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member_id"))).click();
		System.out.println("-----Add Member ID-----");
		Thread.sleep(10000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchButton"))).click();
		Thread.sleep(10000);
	}
}
