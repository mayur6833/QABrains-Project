package CBS_Branch_TransactionReports;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//Pending

public class Transaction extends BaseLoginForAllBranchModules 
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void transations() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/transaction/approvetransaction");
		Thread.sleep(2000);
		
		System.out.println("-----The Transaction Module are Pending-----");
		
	}
	
	@Test(priority = 2)
	public void rejectTransactions() throws Exception
	{
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/transaction/approvetransaction");
		Thread.sleep(2000);
		
		//Reject 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn-submit']"))).click();
		Thread.sleep(2000);
		
		System.out.println("-----The Reject Transaction Module are Pending-----");
	}
	

}
