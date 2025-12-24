package CBS_Branch_CoreBankingService_SharePayment;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//Pending

public class Share_Transfer extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	
	@Test(priority = 1)
	public void shareReport() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/share-transfer");
		Thread.sleep(2000);
		
//		//From Member ID
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member_id"))).click();
//		System.out.println("-----Add Account No-----");
//		Thread.sleep(10000);
		
		System.out.println("-----Share Transfer Module are Peniding-----");
	
	}
}
