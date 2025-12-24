package CBS_Admin_GoldLoan_ManageGoldRate;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import loginAdmin.baseLoginForAllAdminModules;


//not Working -> addGoldLoanSchemeByAmount()


public class Manage_Rate extends baseLoginForAllAdminModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void manageGoldRate() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigate
		driver.navigate().to("https://demo.techplex.in/admin-loan/showgoldrate");
		Thread.sleep(2000);
		
		//Select Item Group
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gold_product"))).sendKeys("24K Pure Gold");
		Thread.sleep(2000);
		
		//Market Rate (per gm)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("marketRate"))).sendKeys("7000");
		Thread.sleep(2000);
		
		//Note
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("note"))).sendKeys("100% Pure Gold");
		Thread.sleep(2000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='addPenalty']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	
//		//Edit
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-edit edit-btn btn-submit']"))).click();
//		Thread.sleep(2000);
//		
//		//Change Rate
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(""))).sendKeys("7500.21");
//		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void goldLoanScheme() throws Exception
	{
		//Direct Navigate 
		driver.navigate().to("https://demo.techplex.in/admin-loan/showgoldloanscheme");
		Thread.sleep(2000);
		
		//Scheme Type
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("scheme_type"))).sendKeys("Gold Profit");
		Thread.sleep(2000);
		
		//Scheme Name 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("scheme_name"))).sendKeys("New Gold Scheme");
		Thread.sleep(2000);
		
		//Product
		//not Editable
		
		//Applicable From
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("applicable_from"))).sendKeys("10102022");
		Thread.sleep(2000);
		
		//To
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("to"))).sendKeys("10102030");
		Thread.sleep(2000);
		
		//calculation Basis
		WebElement calculationBasis = driver.findElement(By.id("calc_basis"));
		Select selectCalculationBasis = new Select(calculationBasis);
		List<WebElement> calculation = selectCalculationBasis.getOptions();
		String CB = "Monthly";
		for (int i = 0; i < calculation.size(); i++) 
		{
			if(calculation.get(i).getText().equalsIgnoreCase(CB))
			{
				calculation.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Pre Closure Min. Time(Months)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pre_closure_time"))).sendKeys("12");
		Thread.sleep(2000);
		
		//Penalty Type
		WebElement penaltyType = driver.findElement(By.id("penalty_type"));
		Select penalty = new Select(penaltyType);
		List<WebElement> types = penalty.getOptions();
		String PT = "Percent";
		for (int i = 0; i < types.size() ; i++) 
		{
			if(types.get(i).getText().equalsIgnoreCase(PT))
			{
				types.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Penalty
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("penalty"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("penalty"))).sendKeys("6");
		Thread.sleep(2000);
		
		//Min Loan Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("min_loan_amt"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("min_loan_amt"))).sendKeys("60000");
		Thread.sleep(2000);
		
		//Max Loan Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("max_loan_amt"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("max_loan_amt"))).sendKeys("1000000");
		Thread.sleep(2000);
		
		//Payment Basis On
		WebElement paymentBasis = driver.findElement(By.id("payment_basis"));
		Select selectPaymentBasis = new Select(paymentBasis);
		List<WebElement> payment = selectPaymentBasis.getOptions();
		String SPB = "Interest";
		for (int i = 0; i < payment.size(); i++) 
		{
			if(payment.get(i).getText().equalsIgnoreCase(SPB))
			{
				payment.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Loan Period(Months)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loan_period"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loan_period"))).sendKeys("24");
		Thread.sleep(2000);
		
		//Gold Approval
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gold_approval_percent"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gold_approval_percent"))).sendKeys("80");
		Thread.sleep(2000);
		
		//Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description"))).sendKeys("DONE");
		Thread.sleep(2000);
		
//		//Submit
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitFormBtn"))).click();
//		Thread.sleep(2000);
		
		//Processing Fee details 
		//Percentage of Loan Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"))).sendKeys("3");
		Thread.sleep(2000);
		
		//Min Charges
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/input[1]"))).sendKeys("500");
		Thread.sleep(2000);
		
		//Max Charges
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/input[1]"))).sendKeys("5000");
		Thread.sleep(2000);
		
		//From Loan Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("interest_from[]"))).sendKeys("50000");
		Thread.sleep(2000);
		
		//To Loan Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("interest_to[]"))).sendKeys("1000000");
		Thread.sleep(2000);
		
		//Interest Type
		WebElement interestType = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/select[1]"));
		Select selectInterestType = new Select(interestType);
		List<WebElement> interesttypes = selectInterestType.getOptions();
		String IT = "Simple";
		for (int i = 0; i < interesttypes.size(); i++) 
		{
			if(interesttypes.get(i).getText().equalsIgnoreCase(IT))
			{
				interesttypes.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Interest Rate 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/input[1]"))).sendKeys("7");
		Thread.sleep(2000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitFormBtn"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	//(Not Working)
//	@Test(priority = 3)
	public void addGoldLoanSchemeByAmount() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigate
		driver.navigate().to("https://demo.techplex.in/admin-loan/addGoldLoan_Amount");
		Thread.sleep(2000);
		
		//Scheme Type
		WebElement schemeType = driver.findElement(By.id("scheme_type"));
		Select selectSchemeType = new Select(schemeType);
		List<WebElement> schemes = selectSchemeType.getOptions();
		String SST = "Gold Loan";
		for (int i = 0; i < schemes.size() ; i++) 
		{
			if(schemes.get(i).getText().equalsIgnoreCase(SST))
			{
				schemes.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Scheme Name 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("scheme_name"))).sendKeys("Diwali Scheme");
		Thread.sleep(2000);
		
		//Product
		WebElement product = driver.findElement(By.id("product"));
		Select selectProduct = new Select(product);
		List<WebElement> products = selectProduct.getOptions();
		String SP = "Gold";
		for (int i = 0; i < products.size(); i++) 
		{
			if(products.get(i).getText().equalsIgnoreCase(SP))
			{
				products.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Applicable Date from
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("applicable_from"))).sendKeys("10102021");
		Thread.sleep(2000);
		
		//To
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("to"))).sendKeys("10102030");
		Thread.sleep(2000);
		
		//calculation Basis
		WebElement calculationBasis1 = driver.findElement(By.id("calc_basis"));
		Select selectCalculationBasis1 = new Select(calculationBasis1);
		List<WebElement> calculation1 = selectCalculationBasis1.getOptions();
		String CB1 = "Monthly";
		for (int i = 0; i < calculation1.size(); i++) 
		{
			if(calculation1.get(i).getText().equalsIgnoreCase(CB1))
			{
				calculation1.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Calculation Method
		WebElement calculationMethod = driver.findElement(By.id("calc_method"));
		Select selectCalculationMethod= new Select(calculationMethod);
		List<WebElement> calculationM = selectCalculationMethod.getOptions();
		String CM = "Multiple";
		for (int i = 0; i < calculationM.size(); i++) 
		{
			if(calculationM.get(i).getText().equalsIgnoreCase(CM))
			{
				calculationM.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Payment Frequency
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payment_freq"))).sendKeys("1");
		Thread.sleep(2000);
		
		//Compound 
		WebElement compound = driver.findElement(By.id("compound"));
		Select selectCompound= new Select(compound);
		List<WebElement> compounds = selectCompound.getOptions();
		String COM = "Yes";
		for (int i = 0; i < compounds.size(); i++) 
		{
			if(compounds.get(i).getText().equalsIgnoreCase(COM))
			{
				compounds.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Payment In Advance
		WebElement paymentInAdvance = driver.findElement(By.xpath("//select[@id='compound']"));
		Select selectpaymentInAdvance= new Select(paymentInAdvance);
		List<WebElement> options = selectpaymentInAdvance.getOptions();
		String PIA = "Yes";
		for (int i = 0; i < options.size(); i++) 
		{
			if(options.get(i).getText().equalsIgnoreCase(PIA))
			{
				options.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Pre Clouser Min Time 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pre_closure_time"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pre_closure_time"))).sendKeys("12");
		Thread.sleep(2000);
		
		//Penalty Type
		WebElement penaltyType1 = driver.findElement(By.id("penalty_type"));
		Select penalty1 = new Select(penaltyType1);
		List<WebElement> types1 = penalty1.getOptions();
		String PT1 = "Percent";
		for (int i = 0; i < types1.size() ; i++) 
		{
			if(types1.get(i).getText().equalsIgnoreCase(PT1))
			{
				types1.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//penalty
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("penalty"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("penalty"))).sendKeys("9");
		Thread.sleep(2000);
		
		//Min Loan Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("min_loan_amt"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("min_loan_amt"))).sendKeys("50000");
		Thread.sleep(2000);
		
		//Max Loan Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("max_loan_amt"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("max_loan_amt"))).sendKeys("1000000");
		Thread.sleep(2000);
		
		//Payment Basis On
		WebElement paymentBasis1 = driver.findElement(By.id("payment_basis"));
		Select selectPaymentBasis1 = new Select(paymentBasis1);
		List<WebElement> payment1 = selectPaymentBasis1.getOptions();
		String PB1 = "Interest";
		for (int i = 0; i < payment1.size(); i++) 
		{
			if(payment1.get(i).getText().equalsIgnoreCase(PB1))
			{
				payment1.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Loan Period (Months)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loan_period"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loan_period"))).sendKeys("24");
		Thread.sleep(2000);
		
		//Gold Approval
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gold_approval_percent"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gold_approval_percent"))).sendKeys("85");
		Thread.sleep(2000);
		
		//Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description"))).sendKeys("DONE");
		Thread.sleep(2000);
		
		//Scheme Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='scheme_name[]']"))).sendKeys("Diwali Scheme");
		Thread.sleep(2000);
		
		//(%) on Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='percent_on_amount[]']"))).sendKeys("11");
		Thread.sleep(2000);
		
		//Interest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='interest[]']"))).sendKeys("11");
		Thread.sleep(2000);
		
		//Duration
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='duration[]']"))).sendKeys("24");
		Thread.sleep(2000);
		
		//Max Loan Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='max_loan_amount[]']"))).sendKeys("1000000");
		Thread.sleep(2000);
		
		//Add Row
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Add row']"))).click();
		Thread.sleep(2000);
		
		//SURE pop-up
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Yes, add it!']"))).click();
		Thread.sleep(2000);
		
		//clickOnOK
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
        Thread.sleep(3000);
        
        //Submit
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/div[2]/div[2]/button[1]"))).click();
        Thread.sleep(3000);
        
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
}

