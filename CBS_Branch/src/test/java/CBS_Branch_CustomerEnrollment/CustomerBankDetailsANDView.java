package CBS_Branch_CustomerEnrollment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class CustomerBankDetailsANDView extends BaseLoginForAllBranchModules
{
	WebDriverWait wait; 
	
	@Test(priority = 1)
	public void AddBankDetails() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigate 
		driver.navigate().to("https://demo.techplex.in/customer-enrollment/add_cust_bank_details");
		Thread.sleep(2000);
		
		//Member ID 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member_id"))).click();
		System.out.println("----------Add Member ID manually----------");
		Thread.sleep(10000);
		
		//Submit 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit']"))).click();
		Thread.sleep(2000);
		
		//Member Name
		String name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value=' SHUBHAM SINGH']"))).getAttribute("value");
		System.out.println(name);
		
		//Priority Type 
		WebElement priorityType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("priority_type")));
		Select selectType = new Select(priorityType);
		List<WebElement> types = selectType.getOptions();
		String PT = "Primary";
		for (int i = 0; i < types.size(); i++) 
		{
			if(types.get(i).getText().equalsIgnoreCase(PT))
			{
				types.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Account Type
		WebElement accountType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("priority_type")));
		Select selectAccountType = new Select(accountType);
		List<WebElement> accounttypes = selectAccountType.getOptions();
		String AT = "Saving Account";
		for (int i = 0; i < accounttypes.size(); i++) 
		{
			if(accounttypes.get(i).getText().equalsIgnoreCase(AT))
			{
				accounttypes.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Bank Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bank_name"))).sendKeys("CBS BANK PVT LTD");
		Thread.sleep(2000);
		
		//Account Holder Name 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acc_holder_name"))).sendKeys(name);
		Thread.sleep(2000);
		
		//Account No 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_no"))).sendKeys("989898765675");
		Thread.sleep(2000);
		
		//Bank Branch Details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bank_branch_details"))).sendKeys("Hinjewadi Pune-411051");
		Thread.sleep(2000);
		
		//IFSC Code
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ifsc_code"))).sendKeys("CBSB0000123456");
		Thread.sleep(2000);
		
		//Submit Bank Details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saveChangesBtn"))).click();
		Thread.sleep(2000);
		
		//are you sure 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Yes, save it!']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void viewBankDetails() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigate
		driver.navigate().to("https://demo.techplex.in/customer-enrollment/view_cust_bank_detials");
		Thread.sleep(2000);
		
		//Member ID 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member_id"))).click();
		System.out.println("----------Add Member ID Manually----------");
		Thread.sleep(10000);
		
		//search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))).click();
		Thread.sleep(10000);
	}

}
