package CBS_Branch_Loan_GoldLoan;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;


public class Disbursement_Gold_Loan_Applications extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
//	@Test(priority = 1)
//	public void Disbursement_Gold_Loan_Applications_Navigation() throws Exception
//	{
//		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
//		
//		//SlideBar
//		//ClickOnLoan
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/section[1]/aside[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[7]/button[1]"))).click();	
//		Thread.sleep(3000);
//		
//		//ClickOnGoldLoan
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/div[1]/aside[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/button[1]"))).click();	
//		Thread.sleep(3000);
//		
//		//ClickOnDisbursement_Gold_Loan_Applications
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Disbursement Of Approved Loan']"))).click();	
//		Thread.sleep(3000);
//		
//	}

	@Test(priority = 1)
	public void Disbursement_Gold_Loan_Applications_Actions() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation 
		driver.navigate().to("https://demo.techplex.in/branch-loan/viewgoldloandisburse");
		Thread.sleep(2000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))).click();
		Thread.sleep(2000);
		
//Need to add Search Code		
		//003001100022	ASTA BLACK
		
		//Account Create
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[9]/button[1]"))).click();
		Thread.sleep(2000);
	}
}
