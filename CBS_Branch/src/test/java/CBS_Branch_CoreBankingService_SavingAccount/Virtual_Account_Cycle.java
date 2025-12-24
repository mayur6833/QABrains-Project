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

//Pending
// Virtual Account Request   --> Not Working
// Approval Virtual Request  --> Not Working
// Virtual Account status    --> Not Working


public class Virtual_Account_Cycle extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	String AccountNumber;
	
	@Test(priority = 1)
	public void VirtualACRRequest() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation 
		driver.navigate().to("https://demo.techplex.in/baccounts/virtual_req_sb");
		Thread.sleep(2000);
		
		//SelectSearchField
		WebElement SearchField2= driver.findElement(By.id("search-field"));
		Select selectSearchField2 = new Select(SearchField2);
		List<WebElement> searchOptions2= selectSearchField2.getOptions();
		String SF2="Account Number";
		for (int i = 0; i < searchOptions2.size(); i++) 
		{
			if(searchOptions2.get(i).getText().equalsIgnoreCase(SF2))
			{
				searchOptions2.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		
		
		//Enter Value
       	WebElement enterValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-value")));
		enterValue.click();
		System.out.println("-----Add Account Number-----");
		Thread.sleep(10000);
		AccountNumber = enterValue.getAttribute("value").replaceAll("[^\\d.]", "").trim();
//		AccountNumber = Integer.parseInt(number);
		System.out.println(AccountNumber);
	
		//DateRange
		WebElement dateRange1 = driver .findElement(By.id("date_range"));
		Select selectRange1 = new Select(dateRange1);
		List<WebElement> rangeOptions1 = selectRange1.getOptions();
		String range1 = "Today";
		for (int i = 0; i < rangeOptions1.size(); i++) 
		{
			if(rangeOptions1.get(i).getText().equalsIgnoreCase(range1))
			{
				rangeOptions1.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		
		//SearchButton
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-submit']"))).click();	
		Thread.sleep(2000);
		
		//OkButton
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();	
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void virtualAccountRequest() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation 
		driver.navigate().to("https://demo.techplex.in/baccounts/virtual_app_sb");
		Thread.sleep(2000);
		
		//Search Field
		WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-field")));
		Select selectSearchField = new Select(searchField);
		List<WebElement> search = selectSearchField.getOptions();
		String SSF = "Account Number";
		for (int i = 0; i < search.size(); i++) 
		{
			if(search.get(i).getText().equalsIgnoreCase(SSF))
			{
				search.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Enter Value 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-value"))).sendKeys(AccountNumber);
		Thread.sleep(2000);
		
		//Search 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button']"))).click();
		Thread.sleep(2000);
		
		//OkButton
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();	
		Thread.sleep(2000);
	}
	
	@Test(priority = 3)
	public void virtualACStatus()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		System.out.println("-----Virtual Account status module are pending-----");
	}
}
