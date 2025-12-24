package CBS_Branch_CoreBankingService_LoanOnDeposit;

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

public class View_Deposit_Loan extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void viewAccount() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Navigate to View 
		driver.navigate().to("https://demo.techplex.in/baccounts/view_depositloan");
		Thread.sleep(2000);
		
		//searchType
		WebElement searchType = driver.findElement(By.id("search_type"));
		Select selectSearch = new Select(searchType);
		List<WebElement> types = selectSearch.getOptions();
		String SST = "Member ID";
		for (int i = 0; i < types.size(); i++) 
		{
			if(types.get(i).getText().equalsIgnoreCase(SST))
			{
				types.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
				
		//searchContent
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_content"))).click();
		System.out.println("-----Add Member ID-----");
		Thread.sleep(10000);
				
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='Submit']"))).click();
		Thread.sleep(6000);
	}
}
