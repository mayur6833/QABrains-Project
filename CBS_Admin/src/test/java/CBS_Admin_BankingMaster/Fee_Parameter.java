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

public class Fee_Parameter extends baseLoginForAllAdminModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void feeParameterForShareHolder() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/transaction/fee-parameter");
		
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
		
		//Share Fee
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shareFee"))).sendKeys("250");
		Thread.sleep(2000);		
		
		//ADM Fee
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("admFee"))).sendKeys("25");
		Thread.sleep(2000);
		
		//Death Fund Fee
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("deathFundFee"))).sendKeys("25");
		Thread.sleep(2000);
		
		//building Fund Fee
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buildingFundFee"))).sendKeys("25");
		Thread.sleep(2000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit']"))).click();
		System.out.println("Scroll page manually to see Parameter");
		Thread.sleep(10000);
	}	
	
	@Test(priority = 2)
	public void feeParameterForOrdinaryMember() throws Exception
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
		
		//Share Fee
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shareFee"))).sendKeys("300");
		Thread.sleep(2000);		
		
		//ADM Fee
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("admFee"))).sendKeys("30");
		Thread.sleep(2000);
		
		//Death Fund Fee
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("deathFundFee"))).sendKeys("30");
		Thread.sleep(2000);
		
		//building Fund Fee
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buildingFundFee"))).sendKeys("30");
		Thread.sleep(2000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit']"))).click();
		System.out.println("Scroll page manually to see Parameter");
		Thread.sleep(10000);
	}
}

