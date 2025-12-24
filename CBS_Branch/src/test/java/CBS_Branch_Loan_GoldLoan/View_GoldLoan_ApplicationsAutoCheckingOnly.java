package CBS_Branch_Loan_GoldLoan;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class View_GoldLoan_ApplicationsAutoCheckingOnly extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void ViewGoldLoanApplications_Navigation() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//SlideBar
		//ClickOnLoan
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/section[1]/aside[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[7]/button[1]"))).click();	
		Thread.sleep(3000);
		
		//ClickOnGoldLoan
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/div[1]/aside[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/button[1]"))).click();	
		Thread.sleep(3000);
		
		//ClickOnViewGoldLoanApplications
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='View Gold Loan Applications']"))).click();	
		Thread.sleep(3000);

	}
	
	@Test(priority = 2)
	public void ViewGoldLoanApplications_actions() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
//startDate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("startDate"))).click();
		Thread.sleep(2000);
		//SelectMonth
		WebElement selectmonth = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/select[1]"));
		Select month = new Select(selectmonth);
		month.selectByValue("10");
		Thread.sleep(2000);
		//year
		WebElement selectyear = driver.findElement(By.xpath("(//span[@class='arrowDown'])[1]"));
		int clickCount = 20;
		 for (int i = 0; i < clickCount; i++) 
        {
              selectyear.click();
        }
        Thread.sleep(3000);
        //Date
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[2]/div[1]/span[8]"))).click();
		Thread.sleep(2000);
		
		
//EndDate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("endDate"))).click();
		Thread.sleep(2000);
//		//SelectMonth
//		WebElement selectmonth1 = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[4]/input[1]"));
//		Select month1 = new Select(selectmonth1);
//		month1.selectByValue("10");
//		Thread.sleep(2000);
//		//year
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flatpickr-calendar animate open arrowTop arrowLeft rightMost']//input[@aria-label='Year']"))).click();
//		Thread.sleep(2000);
        //Date
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[4]/div[2]/div[1]/div[2]/div[1]/span[20]"))).click();
		Thread.sleep(2000);
		
//Actions Types,Status,Process
//Loan Types, Statuses and processes
		
		//, "Interest"
       String[] loanTypes = {"Emi"};
       //"Denied","Approved"
       String[] loanStatuses = {"Pending"};
       //, "Cibil Verification", "Address Verification", "Document Verification", "Print Documents"
       String[] loanProcesses = {"Coapplicant"};
       
       for (String loanType : loanTypes) 
       {
    	   for (String loanStatus : loanStatuses)
           {
    		   for (String loanProcess : loanProcesses)
               {
                   // Select Loan Type
                   Select loanTypeSelect = new Select(driver.findElement(By.id("loanType")));
                   loanTypeSelect.selectByVisibleText(loanType);
                   
                   Thread.sleep(2000);
                   
                   // Select Loan Status
                   Select loanStatusSelect = new Select(driver.findElement(By.id("loanStatus")));
                   loanStatusSelect.selectByVisibleText(loanStatus);
                   
                   Thread.sleep(2000);

                   // Select Loan Process
                   Select loanProcessSelect = new Select(driver.findElement(By.id("processStage")));
                   loanProcessSelect.selectByVisibleText(loanProcess);
                   
                   Thread.sleep(2000);

                   // Click Search
                   WebElement searchBtn = driver.findElement(By.xpath("(//button[normalize-space()='Search'])[1]"));
                   searchBtn.click();
                   
                   Thread.sleep(2000);
              }
           } 
	   }
//Dummy Code for testing specific section 
       
       //LoanType
//       WebElement loanType = driver.findElement(By.id("loanType"));
//       Select type = new Select(loanType);
//       List<WebElement> typeOption=type.getOptions();
//       String s1="Interest";
//       for (int i = 0; i < typeOption.size(); i++) 
//       {
//    	   if(typeOption.get(i).getText().equalsIgnoreCase(s1))
//    	   {
//    		   typeOption.get(i).click();
//    		   break;
//    	   }
//       }
//       Thread.sleep(2000);
//       //LoanStatus
//       WebElement loanType1 = driver.findElement(By.id("loanStatus"));
//       Select type1 = new Select(loanType1);
//       List<WebElement> typeOption1=type1.getOptions();
//       String s11="Approved";
//       for (int i = 0; i < typeOption1.size(); i++) 
//       {
//    	   if(typeOption1.get(i).getText().equalsIgnoreCase(s11))
//    	   {
//    		   typeOption1.get(i).click();
//    		   break;
//    	   }
//       }
//       Thread.sleep(2000);
//       //Loanprocess
//       WebElement loanType12 = driver.findElement(By.id("processStage"));
//       Select type12 = new Select(loanType12);
//       List<WebElement> typeOption12=type12.getOptions();
//       String s112="Print Documents";
//       for (int i = 0; i < typeOption12.size(); i++) 
//       {
//    	   if(typeOption12.get(i).getText().equalsIgnoreCase(s112))
//    	   {
//    		   typeOption12.get(i).click();
//    		   break;
//    	   }
//       }
//       Thread.sleep(2000);
//     // Click Search
//     WebElement searchBtn = driver.findElement(By.xpath("(//button[normalize-space()='Search'])[1]"));
//     searchBtn.click();
       
       
       //clickOnManage
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn-submit']"))).click();	
	   Thread.sleep(3000);
	}
	
	@Test(priority = 3)
	public void LoanReport_ApplicationForm() throws InterruptedException
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
//		//ClickOnApplicationINFO
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='step-2'] a:nth-child(1) span:nth-child(1)"))).click();	
//		Thread.sleep(3000);
		
		//LoanMemberDetails
		//MemberID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member_id"))).click();	
		Thread.sleep(2000);
		
		//MemberName
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member_name"))).click();	
		Thread.sleep(2000);
		
		//ScrollPage
		WebElement ScrollPage=driver.findElement(By.id("interest_type"));
		Actions act = new Actions(driver);
		act.moveToElement(ScrollPage).build().perform();
		
		//NomineeDetails
		//Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).click();	
		Thread.sleep(2000);
		
		//Relation
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("relation"))).click();	
		Thread.sleep(2000);
		
		//NomineeDOB
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dob"))).click();	
		Thread.sleep(2000);
		
		//Age
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("age"))).click();	
		Thread.sleep(2000);
		
		//LoanDetails
		//SelectPaymentType
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='select_payment_type']"))).click();	
		Thread.sleep(2000);
		
		//SelectScheme
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("select_scheme"))).click();	
		Thread.sleep(2000);
		
		//Tenure
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tenure"))).click();	
		Thread.sleep(2000);
		
		//InterestRate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("interest_rate"))).click();	
		Thread.sleep(2000);
		
		//Frequency
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frequency"))).click();	
		Thread.sleep(2000);
		
		//LoanAmount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loan_amount"))).click();	
		Thread.sleep(2000);
		
		//LoanNumber
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loan_no"))).click();	
		Thread.sleep(2000);
		
		//LoanDate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='loan_date']"))).click();	
		Thread.sleep(2000);
		
		//SelectInterestType
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("interest_type"))).click();	
		Thread.sleep(2000);
		
		//ScrollUp
		WebElement scrollUp = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[2]/div[2]/a[1]"));
		Actions act2=new Actions(driver);	
		act2.moveToElement(scrollUp).build().perform();
		Thread.sleep(2000);
	}
	
	//AddReadOnlyMode
	@Test(priority = 4)
	public void LoanReport_AddItemsInfo() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//ClickOnAddItemsInfo
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[2]/div[2]/a[1]"))).click();	
//		Thread.sleep(2000);
		
		driver.navigate().to("https://development.techplex.in/branch-loan/additems/1");
		Thread.sleep(4000);
		
		//forScrolling
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='remarks']"))).click();	
		Thread.sleep(3000);
		
		//UploadImage
		
		
		//SaveDetails
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save Details']"))).click();	
		Thread.sleep(2000);
		
		//OKButton
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();	
		Thread.sleep(2000);
		
	}
	
	@Test(priority = 5)
	public void LoanReport_SendForApproval() throws InterruptedException
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//ClickOnSendForApproval
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[2]/div[3]/a[1]"))).click();	
		Thread.sleep(4000);
		
		//LoanNo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loan_no"))).click();	
		Thread.sleep(2000);
		
		//LoanDate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loan_date"))).click();	
		Thread.sleep(2000);
		
		//GrossWt
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gross_wt"))).click();	
		Thread.sleep(2000);
		
		//StoneWt
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("stone_weight"))).click();	
		Thread.sleep(2000);
		
		//NetWt
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("net_weight"))).click();	
		Thread.sleep(2000);
		
		//ValueForNetWt
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("value_for_net_weight"))).click();	
		Thread.sleep(2000);
		
		//Lending%
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lending_percent"))).click();	
		Thread.sleep(2000);
		
		//EligibleAmount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("eligible_amount"))).click();	
		Thread.sleep(2000);
		
		//Req.LoanAmount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("required_loan_amount"))).click();	
		Thread.sleep(2000);
		
		//SchemeType
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("scheme_id"))).click();	
		Thread.sleep(2000);
		
		//AppraiserName
		//Accepting Numbers and SpecialCharacters
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='text'])[13]"))).sendKeys("John Wick");
		Thread.sleep(3000);
		
		//AppraiserCode
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='text'])[14]"))).sendKeys("1S2ds4");	
		Thread.sleep(3000);
		
		//PageScroll
		WebElement scrollToDown=driver.findElement(By.xpath("//button[normalize-space()='Approve']"));
		Actions sTD=new Actions(driver);
		sTD.moveToElement(scrollToDown).build().perform();
		Thread.sleep(2000);
		
		//InterestType
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payment_basis"))).click();	
		Thread.sleep(2000);
		
		//Tenure
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tenure"))).click();	
		Thread.sleep(2000);
		
		//InterestRate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("interest_rate"))).click();	
		Thread.sleep(2000);
		
		//Frequency
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("installment_frequency"))).click();	
		Thread.sleep(2000);
		
		//InterestType
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("interest_type"))).click();	
		Thread.sleep(2000);
		
		//SanctionedAmount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sanctioned_amount"))).click();	
		Thread.sleep(2000);
		
//ClickOnApprove
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Approve']"))).click();	
		Thread.sleep(2000);
		
//OkButton
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[6]/button[1]"))).click();	
		Thread.sleep(2000);
				
	}
}
