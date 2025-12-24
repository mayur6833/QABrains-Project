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

//pending

public class Credit_Request extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void Credit_Request_Navigation() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
//		//ClickOnTransaction
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='menu-title font-medium'][normalize-space()='Transaction']"))).click();
//		Thread.sleep(2000);	
//		//ClickOnCredit_Request
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Credit Request']"))).click();
//		Thread.sleep(2000);	
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/transaction/requestcredit");
		
		//Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount"))).sendKeys("100000");
		Thread.sleep(2000);
		
		//Transaction type 
		WebElement transactionType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("type_of_transaction")));
		Select selectType = new Select(transactionType);
		List<WebElement> types = selectType.getOptions();
		String TT = "Withdrawal";
		for (int i = 0; i < types.size(); i++) 
		{
			if(types.get(i).getText().equalsIgnoreCase(TT))
			{
				types.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Branch Code 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("branch"))).sendKeys("SWMT-001");
		Thread.sleep(2000);
		
		//Transaction No 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("transaction_no"))).sendKeys("12345678910");
		Thread.sleep(2000);
		
		//Remarks
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("remark"))).sendKeys("DONE");
		Thread.sleep(2000);
		
		//Select Document
		WebElement selectDocument = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("document")));
		String doc = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
		selectDocument.sendKeys(doc);	
		Thread.sleep(2000);	
		
		//Add
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchButton"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
}
//Actions Pending
