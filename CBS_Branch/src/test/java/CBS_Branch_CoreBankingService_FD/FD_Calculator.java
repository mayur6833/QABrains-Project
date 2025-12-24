package CBS_Branch_CoreBankingService_FD;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class FD_Calculator extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	int depositAmount;
	double systemeROI;
	double systemGeneratedInterest;
	double SystemTotalMaturityAmount;
	
	DecimalFormat df = new DecimalFormat("###0.00");
	
	@Test(priority = 1)
	public void FDCalculator() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigate
		driver.navigate().to("https://demo.techplex.in/fdCalculator");
		Thread.sleep(2000);
		
		//SelectPlan
		WebElement selectPlan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("select-plan")));
		Select plans = new Select(selectPlan);
		List<WebElement> planOptions = plans.getOptions();
		String P = "FD 1YR(12 MONTH-ROI 3.8%)";
		for (int i = 0; i < planOptions.size(); i++) 
		{
			if(planOptions.get(i).getText().equalsIgnoreCase(P))
			{
				planOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		
		//TypeOfCustomer
		WebElement typeOfCustomer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer-type")));
		Select selectType = new Select(typeOfCustomer);
		selectType.selectByValue("normal");
		Thread.sleep(2000);
		
		//Application Generated ROI    
        WebElement SystemROI = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("roiinterest")));
        String SystemROIText = SystemROI.getAttribute("value").replaceAll("[^\\d.]"," ").trim();
        systemeROI = Math.round(Double.parseDouble(SystemROIText)*100.0)/100.0;
        System.out.println("System Generated ROI: "+df.format(systemeROI));
        Thread.sleep(2000);
		
		//DepositAmount
		WebElement installment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("deposit-amount")));
		installment.sendKeys("100000");
		String appInstallmentAmount = installment.getAttribute("value").replaceAll("[^\\d.]", "").trim();
		depositAmount = Integer.parseInt(appInstallmentAmount);
		System.out.println("Application's Installment Amount = "+depositAmount);
		Thread.sleep(2000);
		
		//CalculateFD
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='submit']"))).click();
		Thread.sleep(2000);
		
		//Interest Amount 
		WebElement interestAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='interest_amount']")));
		String interestText = interestAmount.getText().replaceAll("[^\\d.]", "").trim();
		systemGeneratedInterest = Double.parseDouble(interestText);
		System.out.println("System Generated Interest: "+df.format(systemGeneratedInterest));
		Thread.sleep(2000);
        
        //Maturity Amount 
        WebElement maturityAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='calculation-results']//div[5]")));
        String systemMaturityAmount = maturityAmount.getText().replaceAll("[^\\d.]"," ").trim();
        SystemTotalMaturityAmount = Double.parseDouble(systemMaturityAmount);
        System.out.println("System Generated Maturity Amount: "+ df.format(SystemTotalMaturityAmount));
        Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void calcultion()
	{
		System.out.println();
		System.out.println("--------Automation Script Logic--------");
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		double principal = depositAmount;  // Deposit Amount
        double rate = systemeROI;         // Interest Rate in %
        int tenure = 1;              // Tenure in years
        int compoundingPeriod = 1;   // Compounded yearly
        
//      int compoundingPeriod = 4;   // Compounded Quarterly
//      int compoundingPeriod = 2;   // Compounded half yearly
//      int compoundingPeriod = 365; // Compounded Daily
//      int compoundingPeriod = 12;  // Compounded Monthly

        double amount = principal * Math.pow(1 + (rate / 100) / compoundingPeriod, compoundingPeriod * tenure);

        double interest = amount - principal;

        System.out.println("Total Maturity Amount = "+df.format(amount));
        System.out.println("Interest Earned = "+df.format(interest));
        
        if(Math.abs(amount - SystemTotalMaturityAmount) < 0.01)
	     {
	 		if(Math.abs(interest - systemGeneratedInterest) < 0.01)
	 		{
	 			System.out.println("FD Calculation is Right");
	 		}
	     }
	     else
	     {
	    	 System.out.println("FD calculations is wrong");
	    	 driver.close();
	     }
	}
}
