package CBS_Admin_BankingMaster;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import loginAdmin.baseLoginForAllAdminModules;
//Done

public class Plan_Parameter extends baseLoginForAllAdminModules
{
	WebDriverWait wait;
	String FDPlanName;
	String RDPlanName;
	String MISPlanName;
	String PigmyPlanName;
	
	@BeforeTest
	public void planParameterNavigation() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/plan-parameter");
	}
	
//FD	
	@Test(priority = 1)
	public void AddFDPlan() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Plan Type
		WebElement planType1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan-type")));
		Select selectFDPlan = new Select(planType1);
		selectFDPlan.selectByValue("FD");
		Thread.sleep(2000);
		
		//Plan Name
		WebElement planName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan-name")));
		planName.sendKeys("AUTOFD 1YR(12 MONTH-ROI 4%)");
		FDPlanName = planName.getAttribute("value");
		System.out.println("FD Plan Name: "+FDPlanName);
		Thread.sleep(2000);
		
		//Plan Code
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan-code"))).sendKeys("FD 1YR");
		Thread.sleep(2000);
		
		//plan Duration(In Month)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan-duration"))).sendKeys("12");
		Thread.sleep(2000);
		
		//Duration Type
		WebElement durationType1 = driver.findElement(By.id("durationd"));
		Select selectDuration1 = new Select(durationType1);
		selectDuration1.selectByValue("months");
		Thread.sleep(2000);
		
		//Rate OF Interest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rate-of-interest"))).sendKeys("4");
		Thread.sleep(2000);
		
		//Agent Commission
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("agent-commission"))).sendKeys("1");
		Thread.sleep(2000);
		
		//Compound Interest
		WebElement compountInterest1 = driver.findElement(By.id("compounding-period"));
		Select selectInterest1 = new Select(compountInterest1);
		selectInterest1.selectByValue("quarterly");
		Thread.sleep(2000);
		
		//Minimum Deposit Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("minimum-deposit-amount"))).sendKeys("5000");
		Thread.sleep(2000);
		
		//Minimum period
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("minimum-period"))).sendKeys("1");
		Thread.sleep(2000);
		
		//Senior Citizen Interest Rate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("senior-citizen-interest-rate"))).sendKeys("4.5");
		Thread.sleep(2000);
		
		//Add Parameter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Add Parameters']"))).click();
		Thread.sleep(2000);
		
		//ClickOnOk
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		System.out.println("Scroll page manually to see Parameter");
		Thread.sleep(7000);
	}
	
	@Test(priority = 2, dependsOnMethods = {"AddFDPlan"})
	public void createSlabForFD() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/slab");
		Thread.sleep(2000);	
		
		//First Slab
		//Deposit Type 
		WebElement depositPlan1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan_type")));
		Select selectDepositPlan1 = new Select(depositPlan1);
		selectDepositPlan1.selectByValue("FD");
		Thread.sleep(2000);
		
		//PlanType
		WebElement planType1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan_name")));
		Select selectPlanType1 = new Select(planType1);
		List<WebElement> types1 = selectPlanType1.getOptions();
		String PT1 = FDPlanName;
		for (int i = 0; i < types1.size(); i++) 
		{
			if(types1.get(i).getText().equalsIgnoreCase(PT1))
			{
				types1.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Add New Row
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addRowBtn"))).click();
		Thread.sleep(2000);
		
		//Slab From
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Slab From']"))).sendKeys("1");
		//Slab To
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Slab To']"))).sendKeys("150");
		//Penalty Rate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Penalty Rate']"))).sendKeys("2");
		//PreMaturity Interest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Interest']"))).sendKeys("2");
		Thread.sleep(2000);
		
		//Save All
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='saveAllBtn']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//Second Slab
		//Deposit Type 
		WebElement depositPlan11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan_type")));
		Select selectDepositPlan11 = new Select(depositPlan11);
		selectDepositPlan11.selectByValue("FD");
		Thread.sleep(2000);
		
		//PlanType
		WebElement planType11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan_name")));
		Select selectPlanType11 = new Select(planType11);
		List<WebElement> types11 = selectPlanType11.getOptions();
		String PT11 = FDPlanName;
		for (int i = 0; i < types11.size(); i++) 
		{
			if(types11.get(i).getText().equalsIgnoreCase(PT11))
			{
				types11.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Add New Row
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addRowBtn"))).click();
		Thread.sleep(2000);
		
		//Slab From
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Slab From']"))).sendKeys("151");
		//Slab To (Need to change to 365)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Slab To']"))).sendKeys("360");
		//Penalty Rate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Penalty Rate']"))).sendKeys("1");
		//PreMaturity Interest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Interest']"))).sendKeys("3");
		Thread.sleep(2000);
		
		//Save All
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='saveAllBtn']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//Check Slab
		//Deposit Type 
		WebElement depositPlan111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan_type")));
		Select selectDepositPlan111 = new Select(depositPlan111);
		selectDepositPlan111.selectByValue("FD");
		Thread.sleep(2000);
		
		//PlanType
		WebElement planType111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan_name")));
		Select selectPlanType111 = new Select(planType111);
		List<WebElement> types111 = selectPlanType111.getOptions();
		String PT111 = FDPlanName;
		for (int i = 0; i < types111.size(); i++) 
		{
			if(types111.get(i).getText().equalsIgnoreCase(PT111))
			{
				types111.get(i).click();
				break;
			}
		}
		Thread.sleep(5000);	
	}
	
	
//RD	
	@Test(priority = 3)
	public void AddRDPlan() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Plan Type
		WebElement planType1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan-type")));
		Select selectFDPlan = new Select(planType1);
		selectFDPlan.selectByValue("RD");
		Thread.sleep(2000);
		
		//Plan Name
		WebElement planName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan-name")));
		planName.sendKeys("AUTORD 1YR(12 MONTH-ROI 4%)");
		RDPlanName = planName.getAttribute("value");
		System.out.println("RD Plan Name: "+RDPlanName);
		Thread.sleep(2000);
		
		//Plan Code
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan-code"))).sendKeys("RD 1YR");
		Thread.sleep(2000);
		
		//plan Duration(In Month)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan-duration"))).sendKeys("12");
		Thread.sleep(2000);
		
		//Duration Type
		WebElement durationType1 = driver.findElement(By.id("durationd"));
		Select selectDuration1 = new Select(durationType1);
		selectDuration1.selectByValue("months");
		Thread.sleep(2000);
		
		//Rate OF Interest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rate-of-interest"))).sendKeys("4");
		Thread.sleep(2000);
		
		//Agent Commission
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("agent-commission"))).sendKeys("1");
		Thread.sleep(2000);
		
		//Compound Interest
		WebElement compountInterest1 = driver.findElement(By.id("compounding-period"));
		Select selectInterest1 = new Select(compountInterest1);
		selectInterest1.selectByValue("quarterly");
		Thread.sleep(2000);
		
		//Minimum Deposit Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("minimum-deposit-amount"))).sendKeys("5000");
		Thread.sleep(2000);
		
		//Minimum period
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("minimum-period"))).sendKeys("1");
		Thread.sleep(2000);
		
		//Senior Citizen Interest Rate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("senior-citizen-interest-rate"))).sendKeys("4.5");
		Thread.sleep(2000);
		
		//Add Parameter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Add Parameters']"))).click();
		Thread.sleep(2000);
		
		//ClickOnOk
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		System.out.println("Scroll page manually to see Parameter");
		Thread.sleep(7000);
	}
		
	@Test(priority = 4, dependsOnMethods = {"AddRDPlan"})
	public void createSlabForRD() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/slab");
		Thread.sleep(2000);
		
		//Deposit Type 
		WebElement depositPlan1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan_type")));
		Select selectDepositPlan1 = new Select(depositPlan1);
		selectDepositPlan1.selectByValue("RD");
		Thread.sleep(2000);
		
		//PlanType
		WebElement planType1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan_name")));
		Select selectPlanType1 = new Select(planType1);
		List<WebElement> types1 = selectPlanType1.getOptions();
		String PT1 = RDPlanName;
		for (int i = 0; i < types1.size(); i++) 
		{
			if(types1.get(i).getText().equalsIgnoreCase(PT1))
			{
				types1.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//First Slab
		//Add New Row
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addRowBtn"))).click();
		Thread.sleep(2000);
		
		//Slab From
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Slab From']"))).sendKeys("1");
		//Slab To
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Slab To']"))).sendKeys("150");
		//Penalty Rate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Penalty Rate']"))).sendKeys("2");
		//PreMaturity Interest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Interest']"))).sendKeys("2");
		Thread.sleep(2000);
		
		//Save All
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='saveAllBtn']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//Second Slab
		//Deposit Type 
		WebElement depositPlan11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan_type")));
		Select selectDepositPlan11 = new Select(depositPlan11);
		selectDepositPlan11.selectByValue("RD");
		Thread.sleep(2000);
		
		//PlanType
		WebElement planType11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan_name")));
		Select selectPlanType11 = new Select(planType11);
		List<WebElement> types11 = selectPlanType11.getOptions();
		String PT11 = RDPlanName;
		for (int i = 0; i < types11.size(); i++) 
		{
			if(types11.get(i).getText().equalsIgnoreCase(PT11))
			{
				types11.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Add New Row
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addRowBtn"))).click();
		Thread.sleep(2000);
		
		//Slab From
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Slab From']"))).sendKeys("151");
		//Slab To (Need to change to 365)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Slab To']"))).sendKeys("360");
		//Penalty Rate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Penalty Rate']"))).sendKeys("1");
		//PreMaturity Interest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Interest']"))).sendKeys("3");
		Thread.sleep(2000);
		
		//Save All
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='saveAllBtn']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//Check Slab
		//Deposit Type 
		WebElement depositPlan111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan_type")));
		Select selectDepositPlan111 = new Select(depositPlan111);
		selectDepositPlan111.selectByValue("RD");
		Thread.sleep(2000);
		
		//PlanType
		WebElement planType111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan_name")));
		Select selectPlanType111 = new Select(planType111);
		List<WebElement> types111 = selectPlanType111.getOptions();
		String PT111 = RDPlanName;
		for (int i = 0; i < types111.size(); i++) 
		{
			if(types111.get(i).getText().equalsIgnoreCase(PT111))
			{
				types111.get(i).click();
				break;
			}
		}
		Thread.sleep(5000);	
	}

//MIS	
	@Test(priority = 5)
	public void AddMISPlan() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Plan Type
		WebElement planType1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan-type")));
		Select selectFDPlan = new Select(planType1);
		selectFDPlan.selectByValue("MIS");
		Thread.sleep(2000);
		
		//Plan Name
		WebElement planName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan-name")));
		planName.sendKeys("AUTOMIS 1YR(12 MONTH-ROI 4%)");
		MISPlanName = planName.getAttribute("value");
		System.out.println("MIS Plan Name: "+MISPlanName);
		Thread.sleep(2000);
		
		//Plan Code
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan-code"))).sendKeys("MIS 1YR");
		Thread.sleep(2000);
		
		//plan Duration(In Month)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan-duration"))).sendKeys("12");
		Thread.sleep(2000);
		
		//Duration Type
		WebElement durationType1 = driver.findElement(By.id("durationd"));
		Select selectDuration1 = new Select(durationType1);
		selectDuration1.selectByValue("months");
		Thread.sleep(2000);
		
		//Rate OF Interest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rate-of-interest"))).sendKeys("4");
		Thread.sleep(2000);
		
		//Agent Commission
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("agent-commission"))).sendKeys("1");
		Thread.sleep(2000);
		
		//Compound Interest
		WebElement compountInterest1 = driver.findElement(By.id("compounding-period"));
		Select selectInterest1 = new Select(compountInterest1);
		selectInterest1.selectByValue("quarterly");
		Thread.sleep(2000);
		
		//Minimum Deposit Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("minimum-deposit-amount"))).sendKeys("1000");
		Thread.sleep(2000);
		
		//Minimum period
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("minimum-period"))).sendKeys("1");
		Thread.sleep(2000);
		
		//Senior Citizen Interest Rate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("senior-citizen-interest-rate"))).sendKeys("4.5");
		Thread.sleep(2000);
		
		//Add Parameter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Add Parameters']"))).click();
		Thread.sleep(2000);
		
		//ClickOnOk
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		System.out.println("Scroll page manually to see Parameter");
		Thread.sleep(7000);
	}
	
	@Test(priority = 6, dependsOnMethods = {"AddMISPlan"})
	public void createSlabForMIS() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/slab");
		Thread.sleep(2000);
		
		//Deposit Type 
		WebElement depositPlan1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan_type")));
		Select selectDepositPlan1 = new Select(depositPlan1);
		selectDepositPlan1.selectByValue("MIS");
		Thread.sleep(2000);
		
		//PlanType
		WebElement planType1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan_name")));
		Select selectPlanType1 = new Select(planType1);
		List<WebElement> types1 = selectPlanType1.getOptions();
		String PT1 = MISPlanName;
		for (int i = 0; i < types1.size(); i++) 
		{
			if(types1.get(i).getText().equalsIgnoreCase(PT1))
			{
				types1.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//First Slab
		//Add New Row
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addRowBtn"))).click();
		Thread.sleep(2000);
		
		//Slab From
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Slab From']"))).sendKeys("1");
		//Slab To
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Slab To']"))).sendKeys("150");
		//Penalty Rate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Penalty Rate']"))).sendKeys("2");
		//PreMaturity Interest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Interest']"))).sendKeys("2");
		Thread.sleep(2000);
		
		//Save All
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='saveAllBtn']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//Second Slab
		//Deposit Type 
		WebElement depositPlan11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan_type")));
		Select selectDepositPlan11 = new Select(depositPlan11);
		selectDepositPlan11.selectByValue("MIS");
		Thread.sleep(2000);
		
		//PlanType
		WebElement planType11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan_name")));
		Select selectPlanType11 = new Select(planType11);
		List<WebElement> types11 = selectPlanType11.getOptions();
		String PT11 = MISPlanName;
		for (int i = 0; i < types11.size(); i++) 
		{
			if(types11.get(i).getText().equalsIgnoreCase(PT11))
			{
				types11.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Add New Row
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addRowBtn"))).click();
		Thread.sleep(2000);
		
		//Slab From
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Slab From']"))).sendKeys("151");
		//Slab To (Need to change to 365)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Slab To']"))).sendKeys("360");
		//Penalty Rate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Penalty Rate']"))).sendKeys("1");
		//PreMaturity Interest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Interest']"))).sendKeys("3");
		Thread.sleep(2000);
		
		//Save All
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='saveAllBtn']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//Check Slab
		//Deposit Type 
		WebElement depositPlan111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan_type")));
		Select selectDepositPlan111 = new Select(depositPlan111);
		selectDepositPlan111.selectByValue("MIS");
		Thread.sleep(2000);
		
		//PlanType
		WebElement planType111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan_name")));
		Select selectPlanType111 = new Select(planType111);
		List<WebElement> types111 = selectPlanType111.getOptions();
		String PT111 = MISPlanName;
		for (int i = 0; i < types111.size(); i++) 
		{
			if(types111.get(i).getText().equalsIgnoreCase(PT111))
			{
				types111.get(i).click();
				break;
			}
		}
		Thread.sleep(5000);
	}

//PIGMY	
	@Test(priority = 7)
	public void AddPIGMYPlan() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Plan Type
		WebElement planType1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan-type")));
		Select selectFDPlan = new Select(planType1);
		selectFDPlan.selectByValue("PIGMY");
		Thread.sleep(2000);
		
		//Type
		WebElement Type1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("type")));
		Select selectType1 = new Select(Type1);
		selectType1.selectByValue("Fixed");
		Thread.sleep(2000);
		
		//Plan Name
		WebElement planName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan-name")));
		planName.sendKeys("AUTOPIGMY 1YR(12 MONTH-ROI 4%)");
		PigmyPlanName = planName.getAttribute("value");
		System.out.println("PIGMY Plan Name: "+PigmyPlanName);
		Thread.sleep(2000);
		
		//Plan Code
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan-code"))).sendKeys("PIGMY 1YR");
		Thread.sleep(2000);
		
		//plan Duration(In Month)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan-duration"))).sendKeys("12");
		Thread.sleep(2000);
		
		//Duration Type
		WebElement durationType1 = driver.findElement(By.id("durationd"));
		Select selectDuration1 = new Select(durationType1);
		selectDuration1.selectByValue("months");
		Thread.sleep(2000);
		
		//Rate OF Interest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rate-of-interest"))).sendKeys("4");
		Thread.sleep(2000);
		
		//Agent Commission
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("agent-commission"))).sendKeys("1");
		Thread.sleep(2000);
		
		//Compound Interest
		WebElement compountInterest1 = driver.findElement(By.id("compounding-period"));
		Select selectInterest1 = new Select(compountInterest1);
		selectInterest1.selectByValue("quarterly");
		Thread.sleep(2000);
		
		//Minimum Deposit Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("minimum-deposit-amount"))).sendKeys("1000");
		Thread.sleep(2000);
		
		//Minimum period
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("minimum-period"))).sendKeys("1");
		Thread.sleep(2000);
		
		//Senior Citizen Interest Rate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("senior-citizen-interest-rate"))).sendKeys("4.5");
		Thread.sleep(2000);
		
		//Add Parameter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Add Parameters']"))).click();
		Thread.sleep(2000);
		
		//ClickOnOk
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		System.out.println("Scroll page manually to see Parameter");
		Thread.sleep(7000);
	}
	
	@Test(priority = 8, dependsOnMethods = {"AddPIGMYPlan"})
	public void createSlabForPigmy() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/slab");
		Thread.sleep(2000);
		
		//Deposit Type 
		WebElement depositPlan1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan_type")));
		Select selectDepositPlan1 = new Select(depositPlan1);
		selectDepositPlan1.selectByValue("PIGMY");
		Thread.sleep(2000);
		
		//PlanType
		WebElement planType1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan_name")));
		Select selectPlanType1 = new Select(planType1);
		List<WebElement> types1 = selectPlanType1.getOptions();
		String PT1 = PigmyPlanName;
		for (int i = 0; i < types1.size(); i++) 
		{
			if(types1.get(i).getText().equalsIgnoreCase(PT1))
			{
				types1.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//First Slab
		//Add New Row
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addRowBtn"))).click();
		Thread.sleep(2000);
		
		//Slab From
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Slab From']"))).sendKeys("1");
		//Slab To
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Slab To']"))).sendKeys("150");
		//Penalty Rate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Penalty Rate']"))).sendKeys("2");
		//PreMaturity Interest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Interest']"))).sendKeys("2");
		Thread.sleep(2000);
		
		//Save All
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='saveAllBtn']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//Second Slab
		//Deposit Type 
		WebElement depositPlan11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan_type")));
		Select selectDepositPlan11 = new Select(depositPlan11);
		selectDepositPlan11.selectByValue("PIGMY");
		Thread.sleep(2000);
		
		//PlanType
		WebElement planType11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan_name")));
		Select selectPlanType11 = new Select(planType11);
		List<WebElement> types11 = selectPlanType11.getOptions();
		String PT11 = PigmyPlanName;
		for (int i = 0; i < types11.size(); i++) 
		{
			if(types11.get(i).getText().equalsIgnoreCase(PT11))
			{
				types11.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Add New Row
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addRowBtn"))).click();
		Thread.sleep(2000);
		
		//Slab From
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Slab From']"))).sendKeys("151");
		//Slab To (Need to change to 365)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Slab To']"))).sendKeys("360");
		//Penalty Rate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Penalty Rate']"))).sendKeys("1");
		//PreMaturity Interest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Interest']"))).sendKeys("3");
		Thread.sleep(2000);
		
		//Save All
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='saveAllBtn']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//Check Slab
		//Deposit Type 
		WebElement depositPlan111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan_type")));
		Select selectDepositPlan111 = new Select(depositPlan111);
		selectDepositPlan111.selectByValue("PIGMY");
		Thread.sleep(2000);
		
		//PlanType
		WebElement planType111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan_name")));
		Select selectPlanType111 = new Select(planType111);
		List<WebElement> types111 = selectPlanType111.getOptions();
		String PT111 = PigmyPlanName;
		for (int i = 0; i < types111.size(); i++) 
		{
			if(types111.get(i).getText().equalsIgnoreCase(PT111))
			{
				types111.get(i).click();
				break;
			}
		}
		Thread.sleep(5000);
	}
}
