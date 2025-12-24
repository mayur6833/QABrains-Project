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

public class Renewals extends BaseLoginForAllBranchModules
{
    WebDriverWait wait;
    
    @Test(priority = 1)
    public void RenewalsActions_ForTransactionModule() throws Exception
    {
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/renewals");
		Thread.sleep(2000);
		
		//CustomerAccountNo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accno"))).click();
		System.out.println("----------Add Account No----------");
		Thread.sleep(10000);
		
		//Confirm
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchButton"))).click();
		Thread.sleep(2000);
    }
	
	@Test(priority = 2)
	public void Renewals_Actions() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//mode Of payment 
		WebElement modeOFPayment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payment_mode")));
		Select selectMOP = new Select(modeOFPayment);
		List<WebElement> mode = selectMOP.getOptions();
		String MOP = "Cash";
		for (int i = 0; i < mode.size(); i++) 
		{
			if(mode.get(i).getText().equalsIgnoreCase(MOP))
			{
				mode.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Add Payment in Table
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='denomination_500']"))).sendKeys("2");
		Thread.sleep(2000);
		
		//Continue
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='renewButton']"))).click();
		Thread.sleep(2000);
		
		//OKButton
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Continue']"))).click();
		Thread.sleep(2000);
	}	
}

