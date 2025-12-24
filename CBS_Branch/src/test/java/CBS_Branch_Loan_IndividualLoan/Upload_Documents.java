package CBS_Branch_Loan_IndividualLoan;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//Pending

public class Upload_Documents extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void uploadDocuments() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation 
		driver.navigate().to("https://demo.techplex.in/branch-loan/uploaddocument");
		Thread.sleep(2000);
		
		//Select Loan Application
		Select selectLoanApplication = new Select(driver.findElement(By.id("application_no")));
		selectLoanApplication.selectByVisibleText("JAY PARDESHI");
		Thread.sleep(2000);
		
		//Enter Document Category
		Select selectDocumentCategory = new Select(driver.findElement(By.id("document_category")));
		selectDocumentCategory.selectByVisibleText("Identity Proof");
		Thread.sleep(2000);
		
		//Document List
		Select selectDocumentList = new Select(driver.findElement(By.id("documentlist")));
		selectDocumentList.selectByVisibleText("Adhar Card");
		Thread.sleep(2000);
		
		//Upload Document
		WebElement selectDocument = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("document_file")));
		String imagePath = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
		selectDocument.sendKeys(imagePath);
		Thread.sleep(2000);
		
		//Document Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("document_description"))).sendKeys("Testing Through Automation");
		Thread.sleep(2000);
		
		//Submit 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(5000);
	}
}
