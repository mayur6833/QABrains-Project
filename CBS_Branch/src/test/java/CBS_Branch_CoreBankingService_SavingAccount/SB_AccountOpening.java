package CBS_Branch_CoreBankingService_SavingAccount;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;


public class SB_AccountOpening extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	Search_SB_Accounts search = new Search_SB_Accounts();
	
	@Test(priority = 1)
	public void SB_Account() throws Exception
	{
	    wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	  
	    //Direct Navigation
	   driver.navigate().to("https://demo.techplex.in/baccounts/open-sb");
	   Thread.sleep(2000);
			
		//AccountType
		WebElement AccountType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saving_account_type")));
		Select selectAT=new Select(AccountType);
		List<WebElement> selectAccountType = selectAT.getOptions();
		String s1="BUSINESS ACCOUNT";
		for (int i = 0; i < selectAccountType.size(); i++) 
		{
			if(selectAccountType.get(i).getText().equalsIgnoreCase(s1))
			{
				selectAccountType.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);	
			
		//AccountType
		WebElement AccountType1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_type")));
		Select selectAT1=new Select(AccountType1);
		List<WebElement> selectAccountType1 = selectAT1.getOptions();
		String s11 = "Joint";
		for (int i = 0; i < selectAccountType1.size(); i++) 
		{
			if(selectAccountType1.get(i).getText().equalsIgnoreCase(s11))
			{
				selectAccountType1.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
	
		//Depositor Details
		//Member No
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member-no"))).click();
		System.out.println("----------Add Member ID Manually----------");
		Thread.sleep(10000);
			
		//AgentID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reffered-by"))).sendKeys("SWMT-A0026");
		Thread.sleep(2000);
		
		//SubmitApplication
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit Application']"))).click();
		System.out.println("-----Copy Account Number-----");
		Thread.sleep(10000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void SearchSB() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		search.Search_SBAccount();
	}
}
