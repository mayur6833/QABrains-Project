package CBS_Branch_Loan_LoanReports;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//not Working

public class Overdue_Report extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void OverdueReport() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/branch-loan/overdue");
		Thread.sleep(2000);
		
		//No of Days
		WebElement noOfDays = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("type_of_transaction")));
		Select selectNoOFDays = new Select(noOfDays);
		List<WebElement> days = selectNoOFDays.getOptions();
		String NOD = "0-30 Days";
		for (int i = 0; i < days.size(); i++) 
		{
			if(days.get(i).getText().equalsIgnoreCase(NOD))
			{
				days.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Select Product
		WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='loanFilterForm']//div[2]//select[1]")));
		Select selectProduct = new Select(product);
		selectProduct.selectByValue("Deposit");
		Thread.sleep(2000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))).click();
		Thread.sleep(2000);
	}
}
