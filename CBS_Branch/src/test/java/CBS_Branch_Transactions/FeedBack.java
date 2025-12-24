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

public class FeedBack extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void ServiceFeedback() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/transaction/feedbacktran");
		Thread.sleep(2000);
		
		//Services
		WebElement services = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service")));
		Select selectServices = new Select(services);
		List<WebElement> service = selectServices.getOptions();
		String SS = "SAVING ACCOUNT";
		for (int i = 0; i < service.size(); i++) 
		{
			if(service.get(i).getText().equalsIgnoreCase(SS))
			{
				service.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit']"))).click();
		Thread.sleep(2000);
		
		//ok
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
}
