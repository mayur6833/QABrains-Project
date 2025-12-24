package CBS_Branch_Transactions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

// For RD
//Showing static data

public class Auto_Debit extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void autoDebit() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/enach");
		Thread.sleep(2000);
		
		//Search Type 
		WebElement searchType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_type")));
		Select selectType = new Select(searchType);
		List<WebElement> types = selectType.getOptions();
		String ST = "Member ID";
		for (int i = 0; i < types.size(); i++) 
		{
			if(types.get(i).getText().equalsIgnoreCase(ST))
			{
				types.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Member ID 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_value"))).click();
		System.out.println("----------Add Member ID----------");
		Thread.sleep(10000);
		
		//Search 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBtn"))).click();
		Thread.sleep(10000);
//		
//		//Product Type 
//		WebElement productType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("")));
//		Select selectProductType = new Select(productType);
//		List<WebElement> productTypes = selectProductType.getOptions();
//		String PT = "Recurring Deposit (RD)";
//		for (int i = 0; i < productTypes.size(); i++) 
//		{
//			if(productTypes.get(i).getText().equalsIgnoreCase(PT))
//			{
//				productTypes.get(i).click();
//				break;
//			}
//		}
//		Thread.sleep(2000);
//		
//		//RD Account No 
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(""))).click();
//		System.out.println("----------Add RD Account No Manually----------");
//		Thread.sleep(10000);
		
	}
}
