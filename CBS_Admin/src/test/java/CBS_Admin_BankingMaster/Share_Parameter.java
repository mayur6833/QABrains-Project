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

public class Share_Parameter extends baseLoginForAllAdminModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void addShareHolderParameters() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/transaction/share-parameter");
		Thread.sleep(2000);
		
		//Member Type
		WebElement memberType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("memberType")));
		Select selectMemberType = new Select(memberType);
		List<WebElement> type = selectMemberType.getOptions();
		String SMT="Share Holder";
		for (int i = 0; i < type.size(); i++) 
		{
			if(type.get(i).getText().equalsIgnoreCase(SMT))
			{
				type.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//per Share Value
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shareValue"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shareValue"))).sendKeys("100.50");
		Thread.sleep(2000);
		
		//Minimum share
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("minShares"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("minShares"))).sendKeys("25");
		Thread.sleep(2000);
		
		//Maximum Share 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("maxShares"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("maxShares"))).sendKeys("125");
		Thread.sleep(2000);
		
		//dividend Declared
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dividendDeclared"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dividendDeclared"))).sendKeys("3.5");
		Thread.sleep(2000);
		
		//Save Parameter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button']"))).click();
		Thread.sleep(2000);
		
		//ClickOnOk
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		System.out.println("Scroll page manually to see Parameter");
		Thread.sleep(10000);
	}
	
	@Test(priority = 2)
	public void addOrdinaryMemberParameters() throws InterruptedException
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Member Type
		WebElement memberType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("memberType")));
		Select selectMemberType = new Select(memberType);
		List<WebElement> type = selectMemberType.getOptions();
		String SMT="Ordinary Member";
		for (int i = 0; i < type.size(); i++) 
		{
			if(type.get(i).getText().equalsIgnoreCase(SMT))
			{
				type.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
			
		//per Share Value
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shareValue"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shareValue"))).sendKeys("90");
		Thread.sleep(2000);
			
		//Minimum share
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("minShares"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("minShares"))).sendKeys("10");
		Thread.sleep(2000);
				
		//Maximum Share 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("maxShares"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("maxShares"))).sendKeys("10");
		Thread.sleep(2000);
				
		//dividend Declared
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dividendDeclared"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dividendDeclared"))).sendKeys("3.5");
		Thread.sleep(2000);
		
		//Save Parameter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button']"))).click();
		Thread.sleep(2000);
		
		//ClickOnOk
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		System.out.println("Scroll page manually to see Parameter");
		Thread.sleep(10000);
	}	
}
