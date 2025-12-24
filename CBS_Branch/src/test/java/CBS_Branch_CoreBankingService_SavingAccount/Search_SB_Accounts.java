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

public class Search_SB_Accounts extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void Search_SBAccount() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation 
		driver.navigate().to("https://demo.techplex.in/baccounts/viewsb_sbopening");
		Thread.sleep(2000);
		
		//Search Type
		WebElement searchType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_type")));
		Select selectSearchType = new Select(searchType);
		List<WebElement> Types = selectSearchType.getOptions();
		String ST = "Account No.";
		for (int i = 0; i < Types.size(); i++) 
		{
			if(Types.get(i).getText().equalsIgnoreCase(ST))
			{
				Types.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Enter Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-content"))).click();
		System.out.println("-----Add Account No Manually-----");
		Thread.sleep(10000);
		
		//ClickOnSearch
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-submit']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(10000);
	}
}
