package CBS_Branch_CoreBankingService_CurrentAccount;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class Clouser_Current_Account extends BaseLoginForAllBranchModules
{
	WebDriverWait wait; 
	Search_Current_Account searchCA = new Search_Current_Account();
	
	@Test(priority = 1)
	public void ClouserCurrentAccount() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/baccounts/closer_current");
		Thread.sleep(2000);
		
		//MemberID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountNo"))).click();
		System.out.println("-----Add Account No-----");
		Thread.sleep(10000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//Close Account 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[12]/button[1]"))).click();
		Thread.sleep(2000);
	}
	
	//Check Account Status [CBS Current Account -> Search_Current_Account]
	@Test(priority = 2)
	public void checkAccountStatus() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		searchCA.Search_Current_AC();
	}
}
