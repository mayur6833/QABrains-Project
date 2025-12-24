package CBS_Branch_CoreBankingServices_PigmyWithdraw;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//Pending

public class View_Pigmy_Withdraw extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void viewPigmyWithdraw() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation 
		driver.navigate().to("https://demo.techplex.in/baccounts/view_pigmy_withdraw");
		Thread.sleep(2000);
		
		//Search Type 
		WebElement searchType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_type")));
		Select selectSearchType = new Select(searchType);
		List<WebElement> types = selectSearchType.getOptions();
		String ST = "Account No.";
		for(int i = 0; i < types.size(); i++)
		{
			if(types.get(i).getText().equalsIgnoreCase(ST))
			{
				types.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Enter data
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-content"))).click();
		System.out.println("-----Add Account No-----");
		Thread.sleep(10000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-submit']"))).click();
		Thread.sleep(10000);
	}
}
