package CBS_Branch_Loan_GoldLoan;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//pending

public class View_Gold_Loan_Details extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void View_Gold_Loan_Details_Navigation() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//SlideBar
		//ClickOnLoan
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/section[1]/aside[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[7]/button[1]"))).click();	
		Thread.sleep(3000);
		
		//ClickOnGoldLoan
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/div[1]/aside[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/button[1]"))).click();	
		Thread.sleep(3000);
		
		//ClickOnLoan_Clousure_EMI_Type
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Loan Closure EMI Type']"))).click();	
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void View_Gold_Loan_Details_Actions()
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Pending
	}
}
