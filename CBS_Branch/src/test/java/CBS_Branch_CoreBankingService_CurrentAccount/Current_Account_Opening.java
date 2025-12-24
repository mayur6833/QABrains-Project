package CBS_Branch_CoreBankingService_CurrentAccount;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//Working

public class Current_Account_Opening extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void currentAccountOpening() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/baccounts/open-current");
		Thread.sleep(2000);
		
		//CurrentAccountType
		WebElement accountType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("current_account_type")));
		Select selectAccountType = new Select(accountType);
		List<WebElement> typeOptions = selectAccountType.getOptions();
		String AT ="BUSINESS ACCOUNT COMPANY";
		for (int i = 0; i < typeOptions.size(); i++) 
		{
			if(typeOptions.get(i).getText().equalsIgnoreCase(AT))
			{
				typeOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//AccountType
		WebElement accountType1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_type")));
		Select selectAccountType1 = new Select(accountType1);
		List<WebElement> typeOptions1 = selectAccountType1.getOptions();
		String AT1 ="Individual";
		for (int i = 0; i < typeOptions1.size(); i++) 
		{
			if(typeOptions1.get(i).getText().equalsIgnoreCase(AT1))
			{
				typeOptions1.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);

		//MemberNo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member-no"))).click();
		System.out.println("----------Add Member ID Manually----------");
		Thread.sleep(10000);
		
		//AgentID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reffered-by"))).sendKeys("SWMT-A0026");
		Thread.sleep(2000);	
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit Application']"))).click();
		System.out.println("----------Copy Account No Manually----------");
		Thread.sleep(10000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
}










