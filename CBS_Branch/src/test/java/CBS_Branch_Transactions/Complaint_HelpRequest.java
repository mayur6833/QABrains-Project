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

public class Complaint_HelpRequest extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void complaintHelpRequest() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/comphelprequesttran");
		Thread.sleep(2000);
		
		//Related Services
		WebElement relatedServices = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service")));
		Select selectServices = new Select(relatedServices);
		List<WebElement> services = selectServices.getOptions();
		String RS = "SAVING ACCOUNT";
		for (int i = 0; i < services.size(); i++) 
		{
			if(services.get(i).getText().equalsIgnoreCase(RS))
			{
				services.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Complaint Type 
		WebElement complaintType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("complaint_type")));
		Select selectComplaintType = new Select(complaintType);
		List<WebElement> complaint = selectComplaintType.getOptions();
		String CT = "ACCOUNT RELATED";
		for (int i = 0; i < complaint.size(); i++) 
		{
			if(complaint.get(i).getText().equalsIgnoreCase(CT))
			{
				complaint.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Priority
		WebElement priority = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("priority")));
		Select selectPriority = new Select(priority);
		List<WebElement> priorities = selectPriority.getOptions();
		String SP = "HIGH";
		for (int i = 0; i < complaint.size(); i++) 
		{
			if(priorities.get(i).getText().equalsIgnoreCase(SP))
			{
				priorities.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Complaint Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description"))).sendKeys("Created Complaint Through Automation");
		Thread.sleep(2000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit Complaint']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
}
