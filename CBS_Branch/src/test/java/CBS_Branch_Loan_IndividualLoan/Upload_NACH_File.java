package CBS_Branch_Loan_IndividualLoan;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//not working

public class Upload_NACH_File extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void uploadNACH() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/admin-loan/upload_nach_file");
		
		//import excel file
		WebElement importFile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nach_file")));
		String ExcelPath = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\items_bulk_format_factory_panel_realistic_full_1000.xlsx";
		importFile.sendKeys(ExcelPath);
		Thread.sleep(2000);
		
		//Submit 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchButton"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
}
