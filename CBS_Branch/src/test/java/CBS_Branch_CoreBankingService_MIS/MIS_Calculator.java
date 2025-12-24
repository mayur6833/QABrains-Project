package CBS_Branch_CoreBankingService_MIS;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class MIS_Calculator extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	double systemDepositAmount;
	double systemROI;
	double systemMaturityAmount;
	
	@Test(priority = 1)
	public void MISCalculator() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation 
		driver.navigate().to("https://demo.techplex.in/slab-calculator/miscalculator");
		Thread.sleep(2000);
		
		//SelectPlanType
		WebElement selectPlanType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("select-plan")));
		Select selectPlan = new Select(selectPlanType);
		List<WebElement> planTypes = selectPlan.getOptions();
		String SPT = "MIS 2YR(24 MONTH-ROI 7%)";
		for (int i = 0; i < planTypes.size(); i++) 
		{
			if(planTypes.get(i).getText().equalsIgnoreCase(SPT))
			{
				planTypes.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//deposit Account
		//DepositAmount
		WebElement depositAmountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("deposit-amount")));
		depositAmountInput.sendKeys("100000");
		//Taking Deposit amount Text
	    String depositAmountText = depositAmountInput.getAttribute("value").replaceAll("[^\\d.]", "").trim();
        systemDepositAmount = Double.parseDouble(depositAmountText);
        System.out.printf("System Deposit Amount: %.2f%n" , systemDepositAmount);
        Thread.sleep(2000);
		
		//calculate MIS
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Calculate MIS']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
        //Rate of interest
        WebElement roiElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("roiinterest")));
        String roiText = roiElement.getAttribute("value").replaceAll("[^\\d.]", "").trim();
        systemROI = Math.round(Double.parseDouble(roiText) * 100.0) / 100.0;
        System.out.printf("System ROI: %.2f%n" , systemROI);
        Thread.sleep(2000);
        
        //Maturity Amount
        WebElement maturityAmountElement = driver.findElement(By.xpath("//div[@id='calculation-results']//div[5]"));
        String maturityAmountText = maturityAmountElement.getAttribute("value").replaceAll("[^\\d.]", "").trim();
        systemMaturityAmount = Math.round(Double.parseDouble(maturityAmountText) * 100.0) / 100.0;
        System.out.printf("System Maturity Amount = %.2f%n", systemMaturityAmount);
        Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void calculation2() throws Exception
	{
		double P = systemDepositAmount;  // Principal amount
        double rPercent = systemROI; // Annual rate of interest (7%)
        int t = 2;           // Time in years

        // Convert the percentage rate to decimal (7% = 7/100 = 0.07)
        double r = rPercent / 100;

        // Simple Interest formula to calculate the total amount (A)
        double A = P * (1 + r * t);

        // Calculate total interest earned
        double totalInterest = A - P;

        // Monthly income (divide total interest by number of months)
        double monthlyIncome = totalInterest / (12 * t);

        // Output the result
        System.out.println();
        System.out.println("----Simple Interest----");
        System.out.printf("Annual Interest Rate: %.2f%%%n", rPercent); // Display the rate as 7%
        System.out.printf("Total Amount (A):  %.2f%n", A);
        System.out.printf("Total Interest Earned: %.2f%n", totalInterest);
        System.out.printf("Monthly Income: %.2f%n", monthlyIncome);
        System.out.println();
        
        if(Math.abs(A - systemMaturityAmount) < 0.01)
        {
        	System.out.println("MIS Calculation is right");
        }
        else
        {
        	System.out.println("Wrong MIS Calculations");
        }
	}
}
