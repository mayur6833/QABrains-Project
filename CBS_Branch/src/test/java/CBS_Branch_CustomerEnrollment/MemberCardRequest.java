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

//Pending

public class MemberCardRequest extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void MCRequest() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigate 
		driver.navigate().to("https://demo.techplex.in/customer-enrollment/membercard_request");
		Thread.sleep(2000);
		
		//Member ID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member_id"))).click();
		System.out.println("----------Add Member ID Manually----------");
		Thread.sleep(10000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))).click();
		Thread.sleep(2000);
		
		//Apply
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Apply']"))).click();
		Thread.sleep(2000);
		
		//Card Type 
		WebElement cardType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("card_type")));
		Select selectCardType = new Select(cardType);
		List<WebElement> cards = selectCardType.getOptions();
		String CT = "Premium";
		for (int i = 0; i < cards.size(); i++) 
		{
			if(cards.get(i).getText().equalsIgnoreCase(CT))
			{
				cards.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
//		//Account Type
//		WebElement accountType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reason")));
//		Select selectAccountType = new Select(accountType);
//		List<WebElement> accounts = selectAccountType.getOptions();
//		String AT = "";
//		for (int i = 0; i < accounts.size(); i++) 
//		{
//			if(accounts.get(i).getText().equalsIgnoreCase(AT))
//			{
//				accounts.get(i).click();
//				break;
//			}
//		}
//		Thread.sleep(2000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitCardApplication"))).click();
		Thread.sleep(2000);
	}
}
