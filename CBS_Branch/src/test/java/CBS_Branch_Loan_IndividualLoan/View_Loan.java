package CBS_Branch_Loan_IndividualLoan;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class View_Loan extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;

	
	@Test(priority = 1)
	public void View_Loan_Navigation() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));	
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/branch-loan/searchviewloan");
		Thread.sleep(2000);
		
		//Member ID 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mem_id"))).click();
		System.out.println("----------Add Member ID Manually for View Loan----------");
		Thread.sleep(10000);
		
		//click On Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-btn"))).click();
		Thread.sleep(10000);
		
	}
		
//	@Test(priority = 2)
//	public void view_Loan_Actions() throws Exception
//	{
//		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
//		
//		//StartDate
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='startDate']"))).click();
//		//month
//		WebElement month = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/select[1]"));
//		Select selectMonth = new Select(month);
//		List<WebElement> monthOptions = selectMonth.getOptions();
//		String SM = "October";
//		for (int i = 0; i < monthOptions.size(); i++) 
//		{
//			if(monthOptions.get(i).getText().equalsIgnoreCase(SM))
//			{
//				monthOptions.get(i).click();
//				break;
//			}
//		}
//		Thread.sleep(2000);
//		//Year
//		WebElement selectyear = driver.findElement(By.xpath("(//span[@class='arrowDown'])[1]"));
//		int clickCount = 6;
//		 for (int i = 0; i < clickCount; i++) 
//        {
//              selectyear.click();
//        }
//		 Thread.sleep(2000);
//		//Date
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[2]/div[1]/span[19]"))).click();	
//		Thread.sleep(2000);
//		
//		//EndDate
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='endDate']"))).click();
//		//SelectDate
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[4]/div[2]/div[1]/div[2]/div[1]/span[5]"))).click();	
//		Thread.sleep(2000);
//		
//		//DropDowns
//		String loanTypes[]= {"With Emi","Without Emi"};
//		String loanStatuses[]= {"Denied","Approved","Pending"};
//		String loanProcesses[]= {"Print Documents","Document Verification","Address Verification","Cibil Verification","Coapplicant"};
//		
//		
//		 for (String loanType : loanTypes) 
//	       {
//	    	   for (String loanStatus : loanStatuses)
//	           {
//	    		   for (String loanProcess : loanProcesses)
//	               {
//	                   // Select Loan Type
//	                   Select loanTypeSelect = new Select(driver.findElement(By.id("loanType")));
//	                   loanTypeSelect.selectByVisibleText(loanType);
//	                   
//	                   Thread.sleep(2000);
//	                   
//	                   // Select Loan Status
//	                   Select loanStatusSelect = new Select(driver.findElement(By.id("loanStatus")));
//	                   loanStatusSelect.selectByVisibleText(loanStatus);
//	                   
//	                   Thread.sleep(2000);
//
//	                   // Select Loan Process
//	                   Select loanProcessSelect = new Select(driver.findElement(By.id("processStage")));
//	                   loanProcessSelect.selectByVisibleText(loanProcess);
//	                   
//	                   Thread.sleep(2000);
//
//	                   // Click Search
//	                   WebElement searchBtn = driver.findElement(By.xpath("//button[@id='search-btn']"));
//	                   searchBtn.click();
//	                   
//	                   Thread.sleep(2000);
//	              }
//	           } 
//		   }
//	}
}
