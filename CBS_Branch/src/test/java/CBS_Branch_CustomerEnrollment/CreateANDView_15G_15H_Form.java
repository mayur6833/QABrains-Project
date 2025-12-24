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

public class CreateANDView_15G_15H_Form extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void GForm() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigate
		driver.navigate().to("https://demo.techplex.in/customer-enrollment/fifteenG_fifttenH");
		Thread.sleep(2000);
		
		//member ID 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member_id"))).click();
		System.out.println("----------Add member ID manually----------");
		Thread.sleep(10000);
		
		//Account No
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_no"))).sendKeys("87835427425");
		Thread.sleep(2000);
		
		//select Form
		WebElement selectForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("document_type")));
		Select selectFormType = new Select(selectForm);
		List<WebElement> formType = selectFormType.getOptions();
		String SF = "15G form";
		for (int i = 0; i < formType.size(); i++) 
		{
			if(formType.get(i).getText().equalsIgnoreCase(SF))
			{
				formType.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Select Document
		WebElement selectDoc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("document")));
		String docpath = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
		selectDoc.sendKeys(docpath);
		Thread.sleep(2000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button']"))).click();
		Thread.sleep(2000);
		
//		//Are you Sure 
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Yes, submit it!']"))).click();
//		Thread.sleep(2000);
//		
//		//OK
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
//		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void GFormView() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigate
		driver.navigate().to("https://demo.techplex.in/customer-enrollment/view_fifteenG_fifteenH");
		Thread.sleep(2000);
		
		//member ID 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member_id"))).click();
		System.out.println("----------Add member ID manually----------");
		Thread.sleep(10000);
		
		//select Form
		WebElement selectForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("form_type")));
		Select selectFormType = new Select(selectForm);
		List<WebElement> formType = selectFormType.getOptions();
		String SF = "15G";
		for (int i = 0; i < formType.size(); i++) 
		{
			if(formType.get(i).getText().equalsIgnoreCase(SF))
			{
				formType.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchButton"))).click();
		Thread.sleep(2000);	
		
	}
	
	@Test(priority = 3)
	public void HForm() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigate
		driver.navigate().to("https://demo.techplex.in/customer-enrollment/fifteenG_fifttenH");
		Thread.sleep(2000);
		
		//member ID 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member_id"))).click();
		System.out.println("----------Add member ID manually----------");
		Thread.sleep(10000);
		
		//Account No
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_no"))).sendKeys("87835427425");
		Thread.sleep(2000);
		
		//select Form
		WebElement selectForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("document_type")));
		Select selectFormType = new Select(selectForm);
		List<WebElement> formType = selectFormType.getOptions();
		String SF = "15H form";
		for (int i = 0; i < formType.size(); i++) 
		{
			if(formType.get(i).getText().equalsIgnoreCase(SF))
			{
				formType.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Select Document
		WebElement selectDoc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("document")));
		String docpath = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
		selectDoc.sendKeys(docpath);
		Thread.sleep(2000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button']"))).click();
		Thread.sleep(2000);
		
//		//Are you Sure 
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Yes, submit it!']"))).click();
//		Thread.sleep(2000);
//		
//		//OK
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
//		Thread.sleep(2000);
	}
	
	@Test(priority = 4)
	public void HFormView() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigate
		driver.navigate().to("https://demo.techplex.in/customer-enrollment/view_fifteenG_fifteenH");
		Thread.sleep(2000);
		
		//member ID 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member_id"))).click();
		System.out.println("----------Add member ID manually----------");
		Thread.sleep(10000);
		
		//select Form
		WebElement selectForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("form_type")));
		Select selectFormType = new Select(selectForm);
		List<WebElement> formType = selectFormType.getOptions();
		String SF = "15H";
		for (int i = 0; i < formType.size(); i++) 
		{
			if(formType.get(i).getText().equalsIgnoreCase(SF))
			{
				formType.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchButton"))).click();
		Thread.sleep(2000);
	}
}
