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

public class Create_ViewCenter extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void CreateCenter() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/customer-enrollment/create_center_name");
		Thread.sleep(2000);
		
		//Select State
		WebElement selectState = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("state")));
		Select selectStates = new Select(selectState);
		List<WebElement> states = selectStates.getOptions();
		String STATE = "MAHARASHTRA";
		for(int i = 0; i < states.size(); i++)
		{
			if(states.get(i).getText().equalsIgnoreCase(STATE))
			{
				states.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Select District 
		WebElement selectDistrict = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("district")));
		Select selectDistricts = new Select(selectDistrict);
		List<WebElement> District = selectDistricts.getOptions();
		String Districts = "Pune";
		for(int i = 0; i < District.size(); i++)
		{
			if(District.get(i).getText().equalsIgnoreCase(Districts))
			{
				District.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Village
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("village"))).sendKeys("Haveli");
		Thread.sleep(2000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitBtn"))).click();
		Thread.sleep(2000);
		
		//Are You Sure 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Yes, submit!']"))).click();	 
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void viewCenter() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigate
		driver.navigate().to("https://demo.techplex.in/customer-enrollment/view-update_center");
		Thread.sleep(2000);
		
		//Pending
		System.out.println("View Center Section is pending!!!");
		Thread.sleep(2000);
	}
	
}
