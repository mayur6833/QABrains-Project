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

//Done

public class Search_Current_Account extends BaseLoginForAllBranchModules
{
	 WebDriverWait wait;

	
	@Test(priority = 1)
	public void Search_Current_AC() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/baccounts/search-current");
		Thread.sleep(2000);
		
		//Search Type
		WebElement searchType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_type")));
		Select selectType = new Select(searchType);
		List<WebElement> types = selectType.getOptions();
		String ST = "Account No.";
		for (int i = 0; i < types.size(); i++) 
		{
			if(types.get(i).getText().equalsIgnoreCase(ST))
			{
				types.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
				
		//Enter Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-content"))).click();
		System.out.println("-----Add Account NO-----");
		Thread.sleep(10000);
				
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(5000);
	}
}
