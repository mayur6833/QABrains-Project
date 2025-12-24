package CBS_Admin_BankingMaster;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import loginAdmin.baseLoginForAllAdminModules;

// DONE
public class Current_Account_Parameter extends baseLoginForAllAdminModules
{
	WebDriverWait wait;
	String SchemeNameText;
	
	@Test(priority = 1)
	public void CurrentAccountScheme() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/currentAcc-parameter");
		Thread.sleep(2000);
		
		//AddExtraParameter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Add Extra Parameter']"))).click();
		Thread.sleep(2000);
		
		//AccountSchemeName
		WebElement accountScheme = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter scheme name']")));
		accountScheme.sendKeys("Auto Test Scheme");
		SchemeNameText = accountScheme.getAttribute("value");
//		System.out.println(SchemeNameText);
		Thread.sleep(2000);
		
		//ClickOnAddExtraParameter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit Extra Parameter']"))).click();
		Thread.sleep(2000);
		
		//Current Account Type
		WebElement currentAccountType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='current_type']")));
		Select accountType = new Select(currentAccountType);
		List<WebElement> types = accountType.getOptions();
		String CAT = SchemeNameText;
		for (int i = 0; i < types.size(); i++) 
		{
			if(types.get(i).getText().equalsIgnoreCase(CAT))
			{
				types.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Current Minimum Balance
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter current minimum balance']"))).sendKeys("20000");
		Thread.sleep(2000);
		
		//Current Maximum Balance
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter current maximum balance']"))).sendKeys("1000000");
		Thread.sleep(2000);
		
		//Minimum Balance Penalty
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter minimum balance penalty']"))).sendKeys("5000");
		Thread.sleep(2000);
		
		//Minimum Balance Without Cheque
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter minimum balance without cheque']"))).sendKeys("90000");
		Thread.sleep(2000);
		
		//Minimum Balance Without Cheque
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter minimum balance with cheque']"))).sendKeys("200000");
		Thread.sleep(2000);
		
		//ATM Charges
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter atm charges']"))).sendKeys("500");
		Thread.sleep(2000);
		
		//TransactionLimit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter transaction limit']"))).sendKeys("200000");
		Thread.sleep(2000);
		
		//PerDayLimit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter per day limit']"))).sendKeys("150000");
		Thread.sleep(2000);
		
		//Add/UpdateParameters
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Display on Website']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).sendKeys("150000");
		System.out.println("Scroll for check new parameter added OR Not");
		Thread.sleep(10000);	
	}	
}
