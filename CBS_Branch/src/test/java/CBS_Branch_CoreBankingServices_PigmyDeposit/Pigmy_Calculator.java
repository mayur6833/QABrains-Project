package CBS_Branch_CoreBankingServices_PigmyDeposit;

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

//Need to check Calculations

public class Pigmy_Calculator extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	int installmentAmount;
	double systememROIValue;
	double systemInterestAmount;
	double systemMaturityAmount;
	
	//Convert to Decimal
	DecimalFormat df = new DecimalFormat("###0.00");
	
	@Test(priority = 1)
	public void Pigmy_Calculator_Navigation() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigations
		driver.navigate().to("https://demo.techplex.in/baccounts/pigmy_calcu");
		Thread.sleep(2000);
		
		//SelectPlan
		WebElement SelectPlan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("select-plan")));
		Select selectPlans = new Select(SelectPlan);
		List<WebElement> plans = selectPlans.getOptions();
		String SP = "PIGMY 1YR(12 MONTH-ROI 6.9%)";
		for (int i = 0; i < plans.size(); i++) 
		{
			if(plans.get(i).getText().equalsIgnoreCase(SP))
			{
				plans.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//TypeOfCustomer
		WebElement typeOfCustomer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer-type")));
		Select selectCustomer = new Select(typeOfCustomer);
		selectCustomer.selectByValue("normal");
		Thread.sleep(2000);
		
		//Installment Frequency
		WebElement installmentFrequency = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("premium")));
		Select selectFrequency = new Select(installmentFrequency);
		selectFrequency.selectByValue("Daily");
		Thread.sleep(2000);
		
		//Application Generated ROI    
        WebElement SystemROI = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("roiinterest")));
        String SystemROIText = SystemROI.getAttribute("value").replaceAll("[^\\d.]", "").trim();
        systememROIValue = Math.round(Double.parseDouble(SystemROIText)*100.0)/100.0;
        System.out.println("System Generated ROI: "+ df.format(systememROIValue));
        Thread.sleep(2000);
		
		//DepositAmount
		WebElement installment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("deposit-amount")));
		installment.sendKeys("1000");
		String appInstallmentAmount = installment.getAttribute("value").replaceAll("[^\\d.]", "").trim();
		installmentAmount = Integer.parseInt(appInstallmentAmount);
		System.out.println("Application's Installment Amount = "+installmentAmount);
		Thread.sleep(2000);
		
		//Calculate Pigmy
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Calculate PIGMY']"))).click();
		Thread.sleep(2000);	
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
        
        //Interest Earn
        WebElement interestAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='calculation-results']//div[4]")));
        String SystemInterestText = interestAmount.getText().replaceAll("[^\\d.]", "").trim();
        systemInterestAmount = Double.parseDouble(SystemInterestText);
        System.out.println("System Maturity Amount: " +df.format(systemInterestAmount));
        Thread.sleep(2000);
        
        //Application Maturity Amount
        WebElement maturityAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='calculation-results']//div[5]")));
        String SystemMaturityText = maturityAmount.getText().replaceAll("[^\\d.]", "").trim();
        systemMaturityAmount = Double.parseDouble(SystemMaturityText);
        System.out.println("System Maturity Amount: " +df.format(systemMaturityAmount));
        Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void pigmyCalculations()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		double dailyDeposit = installmentAmount;
		double annualRate = systememROIValue;
		int tenureInYears = 1;
		int compoundingPeriodsPerYear = 4;

		int totalDays = tenureInYears * 365;
		double totalPrincipal = dailyDeposit * totalDays;
		double rateDecimal = annualRate / 100.0;

		double maturityAmount = totalPrincipal * Math.pow(1 + rateDecimal / compoundingPeriodsPerYear, compoundingPeriodsPerYear * tenureInYears);

		double interestEarned = maturityAmount - totalPrincipal;
		System.out.println("\nScript Calculation");
		System.out.println("------------------------------------------");
		System.out.println("Total Principal: " + df.format(totalPrincipal));
		System.out.println("Total Interest Earned: " + df.format(interestEarned));
		System.out.println("------------------------------------------");
		System.out.println("Total Maturity Amount: " + df.format(maturityAmount));
		System.out.println("==========================================");
		
		
		if(Math.abs(maturityAmount - systemMaturityAmount) <0.01)
        {
        	if(Math.abs(interestEarned - systemInterestAmount)< 0.01)
        	{        		
        		System.out.println("Showing Right Calculations For Pigmy");
        	}
        }
        else
        {
        	System.out.println("Showing Wrong Calculations For Pigmy");
        }
	}
}
