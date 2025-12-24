package CBS_Branch_Loan_IndividualLoan;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class Loan_Calculator extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void Loan_Details() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Navigate To Loan Calculator
		driver.navigate().to("https://demo.techplex.in/admin-loan/loancalcu");
		Thread.sleep(2000);
		
		//InterestType
		WebElement interesType = driver.findElement(By.id("interest_type"));
		Select selectInterestType = new Select(interesType);
		List<WebElement> types = selectInterestType.getOptions();
		String IT="Flat";
		for (int i = 0; i < types.size(); i++) 
		{
			if(types.get(i).getText().equalsIgnoreCase(IT))
			{
				types.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//LoanAppliedDate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loan_applied_date"))).click();
		WebElement selectYear = driver.findElement(By.xpath("//span[@class='arrowDown']"));
		int clickCount =1;
		for (int i = 0; i < clickCount; i++) 
		{
			selectYear.click();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[2]/div[1]/span[30]"))).click();
		Thread.sleep(2000);
		
		//LoanAmount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loan_amount"))).sendKeys("100000");
		Thread.sleep(2000);
		
		//RateOFInterest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("roi"))).sendKeys("10");
		Thread.sleep(2000);	
		
		//LoanTenure
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loan_tenure"))).sendKeys("12");
		Thread.sleep(2000);
		
		//InstallmentFrequency
		WebElement installmentFrequency = driver.findElement(By.id("installment_frequency"));
		Select selectFrequency = new Select(installmentFrequency);
		List<WebElement> installmentOptions = selectFrequency.getOptions();
		String IF ="Monthly";
		for (int i = 0; i < installmentOptions.size(); i++) 
		{
			if(installmentOptions.get(i).getText().equalsIgnoreCase(IF))
			{
				installmentOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//ClickOnCalculateEMI
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Calculate EMI']"))).click();
		Thread.sleep(4000);
		
		//ScrollDown
		WebElement scrollDown = driver.findElement(By.xpath("//tbody/tr[12]/td[4]"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(scrollDown).build().perform();
		Thread.sleep(10000);
	}
}
