package CBS_Admin_BankingMaster;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import loginAdmin.baseLoginForAllAdminModules;

//First delete old data and then run

public class Add_Prematurity_Slabs extends baseLoginForAllAdminModules
{
	WebDriverWait wait;
	
	@Test(priority = 2)
	public void addFDSlab() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigation 
		driver.navigate().to("");
		
		//Deposit Type
		WebElement depositType1 = driver.findElement(By.id("plan_type"));
		Select selectDeposit1 = new Select(depositType1);
		List<WebElement> deposit1 = selectDeposit1.getOptions();
		String DT1= "FD";
		for (int i = 0; i < deposit1.size(); i++) 
		{
			if(deposit1.get(i).getText().equalsIgnoreCase(DT1))
			{
				deposit1.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Plan Type
		WebElement planType1 = driver.findElement(By.id("plan_name"));
		Select selectPlan1 = new Select(planType1);
		List<WebElement> plans1 = selectPlan1.getOptions();
		String plan1= "FD 1YR(12 MONTH-ROI 3.8%)";
		for (int i = 0; i < plans1.size(); i++) 
		{
			if(plans1.get(i).getText().equalsIgnoreCase(plan1))
			{
				plans1.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//EditAll
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("editAllBtn"))).click();
		Thread.sleep(2000);
		
		//Add Row
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addRowBtn"))).click();
		Thread.sleep(2000);
		
		//SlabFrom
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("slab_from"))).sendKeys("1");
		Thread.sleep(2000);
		
		//SlabTo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("slab_to"))).sendKeys("30");
		Thread.sleep(2000);
		
		//Penalty
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("penalty_rate"))).sendKeys("6.7");
		Thread.sleep(2000);
		
		//Prematurity Interest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("prematurity_interest"))).sendKeys("11.4");
		Thread.sleep(2000);
		
		//Save All
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='saveAllBtn']"))).click();
		Thread.sleep(2000);
		
		//ClickOnOk
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		System.out.println("Scroll page manually to see Parameter");
		Thread.sleep(5000);
	}
	
	@Test(priority = 3)
	public void addRDSlab() throws Exception
	{
		//Deposit Type
		WebElement depositType2 = driver.findElement(By.id("plan_type"));
		Select selectDeposit2 = new Select(depositType2);
		List<WebElement> deposit2 = selectDeposit2.getOptions();
		String DT2= "RD";
		for (int i = 0; i < deposit2.size(); i++) 
		{
			if(deposit2.get(i).getText().equalsIgnoreCase(DT2))
			{
				deposit2.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Plan Type
		WebElement planType2 = driver.findElement(By.id("plan_name"));
		Select selectPlan2 = new Select(planType2);
		List<WebElement> plans2 = selectPlan2.getOptions();
		String plan2 = "RD 1YR(12 MONTH-ROI 4.8%)";
		for (int i = 0; i < plans2.size(); i++) 
		{
			if(plans2.get(i).getText().equalsIgnoreCase(plan2))
			{
				plans2.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//EditAll
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("editAllBtn"))).click();
		Thread.sleep(2000);
		
		//Add Row
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addRowBtn"))).click();
		Thread.sleep(2000);
		
		//SlabFrom
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='editing new-row']//input[@placeholder='Slab From']"))).sendKeys("1");
		Thread.sleep(2000);
		
		//SlabTo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='editing new-row']//input[@placeholder='Slab To']"))).sendKeys("30");
		Thread.sleep(2000);
		
		//Penalty
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='editing new-row']//input[@placeholder='Penalty Rate']"))).sendKeys("6.2");
		Thread.sleep(2000);
		
		//Prematurity Interest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='editing new-row']//input[@placeholder='Interest']"))).sendKeys("11.1");
		Thread.sleep(2000);
		
		//Save All
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='saveAllBtn']"))).click();
		Thread.sleep(2000);
		
		//ClickOnOk
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		System.out.println("Scroll page manually to see Parameter");
		Thread.sleep(5000);
	}
	
	@Test(priority = 4)
	public void addMISSlab() throws Exception
	{
		//Deposit Type
		WebElement depositType3 = driver.findElement(By.id("plan_type"));
		Select selectDeposit3 = new Select(depositType3);
		List<WebElement> deposit3 = selectDeposit3.getOptions();
		String DT3= "MIS";
		for (int i = 0; i < deposit3.size(); i++) 
		{
			if(deposit3.get(i).getText().equalsIgnoreCase(DT3))
			{
				deposit3.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Plan Type
		WebElement planType3 = driver.findElement(By.id("plan_name"));
		Select selectPlan3 = new Select(planType3);
		List<WebElement> plans3 = selectPlan3.getOptions();
		String plan3 = "MIS 1YR(12 MONTH-ROI 6.5%)";
		for (int i = 0; i < plans3.size(); i++) 
		{
			if(plans3.get(i).getText().equalsIgnoreCase(plan3))
			{
				plans3.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//EditAll
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("editAllBtn"))).click();
		Thread.sleep(2000);
		
		//Add Row
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addRowBtn"))).click();
		Thread.sleep(2000);
		
		//SlabFrom
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='editing new-row']//input[@placeholder='Slab From']"))).sendKeys("1");
		Thread.sleep(2000);
		
		//SlabTo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='editing new-row']//input[@placeholder='Slab To']"))).sendKeys("30");
		Thread.sleep(2000);
		
		//Penalty
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='editing new-row']//input[@placeholder='Penalty Rate']"))).sendKeys("6.4");
		Thread.sleep(2000);
		
		//Prematurity Interest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='editing new-row']//input[@placeholder='Interest']"))).sendKeys("10.5");
		Thread.sleep(2000);
		
		//Save All
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='saveAllBtn']"))).click();
		Thread.sleep(2000);
		
		//ClickOnOk
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		System.out.println("Scroll page manually to see Parameter");
		Thread.sleep(5000);
	}
	
	@Test(priority = 5)
	public void addPIGMYSlab() throws Exception
	{
		//Deposit Type
		WebElement depositType4 = driver.findElement(By.id("plan_type"));
		Select selectDeposit4 = new Select(depositType4);
		List<WebElement> deposit4 = selectDeposit4.getOptions();
		String DT4 = "PIGMY";
		for (int i = 0; i < deposit4.size(); i++) 
		{
			if(deposit4.get(i).getText().equalsIgnoreCase(DT4))
			{
				deposit4.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Plan Type
		WebElement planType4 = driver.findElement(By.id("plan_name"));
		Select selectPlan4 = new Select(planType4);
		List<WebElement> plans4 = selectPlan4.getOptions();
		String plan4 = "PIGMY 1YR(12 MONTH-ROI 6.9%)";
		for (int i = 0; i < plans4.size(); i++) 
		{
			if(plans4.get(i).getText().equalsIgnoreCase(plan4))
			{
				plans4.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//EditAll
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("editAllBtn"))).click();
		Thread.sleep(2000);
		
		//Add Row
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addRowBtn"))).click();
		Thread.sleep(2000);
		
		//SlabFrom
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='editing new-row']//input[@placeholder='Slab From']"))).sendKeys("1");
		Thread.sleep(2000);
		
		//SlabTo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='editing new-row']//input[@placeholder='Slab To']"))).sendKeys("30");
		Thread.sleep(2000);
		
		//Penalty
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='editing new-row']//input[@placeholder='Penalty Rate']"))).sendKeys("6.6");
		Thread.sleep(2000);
		
		//Prematurity Interest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='editing new-row']//input[@placeholder='Interest']"))).sendKeys("10.9");
		Thread.sleep(2000);
		
		//Save All
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='saveAllBtn']"))).click();
		Thread.sleep(2000);
		
		//ClickOnOk
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		System.out.println("Scroll page manually to see Parameter");
		Thread.sleep(5000);
	}	
}
