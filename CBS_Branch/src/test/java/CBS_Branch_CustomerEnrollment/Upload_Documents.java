package CBS_Branch_CustomerEnrollment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//Preview Pending

public class Upload_Documents extends BaseLoginForAllBranchModules 
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void uploadDoc() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigate 
		driver.navigate().to("https://demo.techplex.in/customer-enrollment/upload_documents");
		Thread.sleep(2000);
		
		//Enter Customer Code
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member_id"))).click();
		System.out.println("----------Add Member ID Manually----------");
		Thread.sleep(10000);
		
		//Aadhar Card Input
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Aadhaar Card Number']"))).sendKeys("879865436789");
		Thread.sleep(2000);
		
		//Aadhar Card 
		WebElement aadharCardDOC = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='upload_Aadhaar Card']")));
		String ACDOC = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
		aadharCardDOC.sendKeys(ACDOC);
		Thread.sleep(5000);
		
		
		//Preview
		//Pending
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[2]/td[3]/a[1]"))).click();
//		String originalWindow = driver.getWindowHandle();
//	    // Get all open window handles
//	    Set<String> allWindows = driver.getWindowHandles();
//	    // Switch to the new window
//	    for (String window : allWindows) 
//	    {
//	        if (!window.equals(originalWindow)) 
//	        {
//	            driver.switchTo().window(window);
//	            break;
//	        }
//	    }
//	    Thread.sleep(5000);
////	    // Now you are in the new tab
////	    System.out.println("New Tab Title: " + driver.getTitle());
//
//	    // Switch back to the original tab
//	    driver.switchTo().window(originalWindow);
////	    System.out.println("Back to Original Tab: " + driver.getTitle());
//	    Thread.sleep(5000);
		
	}
}
