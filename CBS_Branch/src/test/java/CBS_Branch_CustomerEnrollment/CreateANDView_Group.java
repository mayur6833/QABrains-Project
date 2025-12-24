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

public class CreateANDView_Group extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;

	@Test(priority = 1)
	public void createGroup() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigation
		driver.navigate().to("https://demo.techplex.in/customer-enrollment/create_group");
		Thread.sleep(2000);
		
		//group name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("//input[@placeholder='Enter Group Name']"))).sendKeys("Test Group 1");
		Thread.sleep(2000);
		
		//select State 
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
		WebElement selectDistrict = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("district")));
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
		
		//Select Center Name 
		WebElement selectCenterName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("district")));
		Select centerName = new Select(selectCenterName);
		List<WebElement> center = centerName.getOptions();
		String centers = "Banaras";
		for(int i = 0; i < District.size(); i++)
		{
			if(center.get(i).getText().equalsIgnoreCase(centers))
			{
				center.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//mobile
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Mobile No']"))).sendKeys("8989765487");
		Thread.sleep(2000);
		
		//email
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Email']"))).sendKeys("testCenter@gmail.com");
		Thread.sleep(2000);
		
		//Address 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Address']"))).sendKeys("Hinjewadi Pune-411051");
		Thread.sleep(2000);
		
		//PinCode
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Pin Code']"))).sendKeys("411051");
		Thread.sleep(2000);
		
		//City 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter City']"))).sendKeys("Pune");
		Thread.sleep(2000);
		
		//Taluka
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Taluka']"))).sendKeys("Pune");
		Thread.sleep(2000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("submitButton"))).click();
		Thread.sleep(2000);
		
		//yes Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Yes, Submit!']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void viewGoup() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigate
		driver.navigate().to("https://demo.techplex.in/customer-enrollment/view_group_member");
		Thread.sleep(2000);
		
		//Group Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("group_no"))).click();
		System.out.println("----------Add Group NO Manually----------");
		Thread.sleep(10000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))).click();
		Thread.sleep(10000);
	}

}














