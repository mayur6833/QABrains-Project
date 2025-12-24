package CBS_Branch_Transactions;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//Pending

public class Cheque_Clearance extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void Cheque_Clearance_Navigation() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
//		//ClickOnTransaction
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='menu-title font-medium'][normalize-space()='Transaction']"))).click();
//		Thread.sleep(2000);	
//		
//		//ClickOnCheque_Clearance
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Cheque Clearance']"))).click();
//		Thread.sleep(2000);	
		
		//Direct Navigations 
		driver.navigate().to("https://demo.techplex.in/transaction/checkreconcillation");
		Thread.sleep(2000);
		
		//SelectBank
		WebElement selectBank= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sendto_bank")));
		Select banks = new Select(selectBank);
		List<WebElement> banksOption= banks.getOptions();
		String SB = "Bank of India";
		for (int i = 0; i < banksOption.size(); i++) 
		{
			if(banksOption.get(i).getText().equalsIgnoreCase(SB))
			{
				banksOption.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//clickOnProcessSelectedCheques
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Process Selected Cheques']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 3)
	public void AssignChequeFunctionality() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//ScrollDown
		WebElement scrollDown = driver.findElement(By.xpath("//a[normalize-space()='Payplex Technology']"));
		Actions act1= new Actions(driver);
		act1.moveToElement(scrollDown).build().perform();
		Thread.sleep(3000);
		
		//ScrollRight
		WebElement scrollRight = driver.findElement(By.xpath("//tbody/tr[1]/td[12]/button[1]"));
		Actions act2= new Actions(driver);
		act2.moveToElement(scrollRight).build().perform();
		Thread.sleep(2000);
		
		//Select
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='cheques[365]']"))).click();
		Thread.sleep(2000);
		
		//Action
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[12]/button[1]"))).click();
		Thread.sleep(2000);
	}
}
