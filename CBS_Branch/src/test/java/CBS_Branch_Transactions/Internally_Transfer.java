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

//Pending

public class Internally_Transfer extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void internallyTransfer() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/internalTransfer");
		Thread.sleep(2000);
		
		// from Account
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("from_account_number"))).click();
		System.out.println("---------Add From Account No----------");
		Thread.sleep(10000);
		
		//Verify account
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("verifyFromAccountBtn"))).click();	
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//To Account
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("to_account_number"))).click();
		System.out.println("---------Add To Account No----------");
		Thread.sleep(10000);
		
		//Verify account
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("verifyToAccountBtn"))).click();	
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		
		//Account Type 
		WebElement accountType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("to_account_type")));
		Select selectAccountType = new Select(accountType);
		List<WebElement> types = selectAccountType.getOptions();
		String AT= "Savings Bank (SB)";
		for (int i = 0; i < types.size(); i++) 
		{
			if(types.get(i).getText().equalsIgnoreCase(AT))
			{
				types.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Transfer Details 
		//Payment Through
		WebElement paymentThrough = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payment_through")));
		Select paymentThroughType = new Select(paymentThrough);
		List<WebElement> types1 = paymentThroughType.getOptions();
		String PT= "TRANSFER";
		for (int i = 0; i < types1.size(); i++) 
		{
			if(types1.get(i).getText().equalsIgnoreCase(PT))
			{
				types1.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Transfer Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("transfer_amount"))).sendKeys("100");
		Thread.sleep(2000);
		
		//Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description"))).sendKeys("Okay");
		Thread.sleep(2000);
		
		//Process Transfer
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fas fa-paper-plane']"))).click();		
		Thread.sleep(2000);
		
		//Yes Transfer
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Yes, Transfer!']"))).click();		
		Thread.sleep(5000);
		
		//OK
	}
}
