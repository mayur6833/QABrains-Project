package CBS_Branch_Loan_LoanReports;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//Not working

public class Loan_Account_Details extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void loanAccountDetails() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/branch-loan/loanaccountdetails");
		Thread.sleep(2000);
		
		//Select search Field
		WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_based_on")));
		Select sc = new Select(searchField);
		sc.selectByValue("member_no");
		Thread.sleep(2000);
		
		//Enter data
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_content"))).click();
		System.out.println("-----Add Search Data (Member no)-----");
		Thread.sleep(10000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))).click();
		Thread.sleep(10000);	
	}
}
