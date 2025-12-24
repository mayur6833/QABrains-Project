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

//Not Working

public class Approval_Virtual_Account extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void VirtualAccount() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Select Search Field
		//Member ID
		WebElement selectSearchField2=driver.findElement(By.xpath("//div[@class='card']//div[1]//select[1]"));
		Select  selectField2 = new Select(selectSearchField2);
		List<WebElement> fieldOptions2 = selectField2.getOptions();
		String SSF2 = "Member ID";
		for (int i = 0; i < fieldOptions2.size(); i++) 
		{
			if(fieldOptions2.get(i).getText().equalsIgnoreCase(SSF2))
			{
				fieldOptions2.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		
		//Member Name
		WebElement selectSearchField3=driver.findElement(By.xpath("//div[@class='card']//div[1]//select[1]"));
		Select  selectField3 = new Select(selectSearchField3);
		List<WebElement> fieldOptions3 = selectField3.getOptions();
		String SSF3 = "Member Name";
		for (int i = 0; i < fieldOptions3.size(); i++) 
		{
			if(fieldOptions3.get(i).getText().equalsIgnoreCase(SSF3))
			{
				fieldOptions3.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		
		//Mobile No
		WebElement selectSearchField4=driver.findElement(By.xpath("//div[@class='card']//div[1]//select[1]"));
		Select  selectField4 = new Select(selectSearchField4);
		List<WebElement> fieldOptions4 = selectField4.getOptions();
		String SSF4 = "Mobile No";
		for (int i = 0; i < fieldOptions4.size(); i++) 
		{
			if(fieldOptions4.get(i).getText().equalsIgnoreCase(SSF4))
			{
				fieldOptions4.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		
		//Account Number
		WebElement selectSearchField1=driver.findElement(By.xpath("//div[@class='card']//div[1]//select[1]"));
		Select  selectField1 = new Select(selectSearchField1);
		List<WebElement> fieldOptions1 = selectField1.getOptions();
		String SSF1 = "Account Number";
		for (int i = 0; i < fieldOptions1.size(); i++) 
		{
			if(fieldOptions1.get(i).getText().equalsIgnoreCase(SSF1))
			{
				fieldOptions1.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		
		//EnterSearchData
		//Accepting space,special characters and alphabets
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountNo"))).sendKeys("JG B b&% ^% &");	
		Thread.sleep(3000);
		
		
		//DataRange
		//Today
		WebElement dataRange1=driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[2]/div[2]/div[3]/select[1]"));
		Select  selectRange1 = new Select(dataRange1);
		List<WebElement> rangeOptions1 = selectRange1.getOptions();
		String SR1 = "Today";
		for (int i = 0; i < rangeOptions1.size(); i++) 
		{
			if(rangeOptions1.get(i).getText().equalsIgnoreCase(SR1))
			{
				rangeOptions1.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		
		//Yesterday
		WebElement dataRange2=driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[2]/div[2]/div[3]/select[1]"));
		Select  selectRange2 = new Select(dataRange2);
		List<WebElement> rangeOptions2 = selectRange2.getOptions();
		String SR2 = "Yesterday";
		for (int i = 0; i < rangeOptions2.size(); i++) 
		{
			if(rangeOptions2.get(i).getText().equalsIgnoreCase(SR2))
			{
				rangeOptions2.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		
		//This Month
		WebElement dataRange3=driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[2]/div[2]/div[3]/select[1]"));
		Select  selectRange3 = new Select(dataRange3);
		List<WebElement> rangeOptions3 = selectRange3.getOptions();
		String SR3 = "This Month";
		for (int i = 0; i < rangeOptions3.size(); i++) 
		{
			if(rangeOptions3.get(i).getText().equalsIgnoreCase(SR3))
			{
				rangeOptions3.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		
		//This week
		WebElement dataRange4=driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[2]/div[2]/div[3]/select[1]"));
		Select  selectRange4 = new Select(dataRange4);
		List<WebElement> rangeOptions4 = selectRange4.getOptions();
		String SR4 = "This week";
		for (int i = 0; i < rangeOptions4.size(); i++) 
		{
			if(rangeOptions4.get(i).getText().equalsIgnoreCase(SR4))
			{
				rangeOptions4.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		
		//This year
		WebElement dataRange5=driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[2]/div[2]/div[3]/select[1]"));
		Select  selectRange5 = new Select(dataRange5);
		List<WebElement> rangeOptions5 = selectRange5.getOptions();
		String SR5 = "This year";
		for (int i = 0; i < rangeOptions5.size(); i++) 
		{
			if(rangeOptions5.get(i).getText().equalsIgnoreCase(SR5))
			{
				rangeOptions5.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		
		//searchButton
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-submit']"))).click();	
		Thread.sleep(3000);
		
		//OkButton
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();	
		Thread.sleep(3000);
		
	}
}
