package CBS_Branch_Loan_GoldLoan;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import LoginBranch.BaseLoginForAllBranchModules;

//Pending

public class Repayment_Schedule extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void Repayment_Schedule_Navigation() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//SlideBar
		//ClickOnLoan
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/section[1]/aside[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[7]/button[1]"))).click();	
		Thread.sleep(3000);
		
		//ClickOnGoldLoan
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/div[1]/aside[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/button[1]"))).click();	
		Thread.sleep(3000);
		
		//ClickOnRepayment_Schedule
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/div[1]/aside[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/ul[1]/li[5]/a[1]/span[1]"))).click();	
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void Repayment_Schedule_Actions()
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Pending
	}
}
