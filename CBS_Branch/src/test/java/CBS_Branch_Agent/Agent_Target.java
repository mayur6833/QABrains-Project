package CBS_Branch_Agent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import LoginBranch.BaseLoginForAllBranchModules;

public class Agent_Target extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void agentTarget() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigate
		driver.navigate().to("https://demo.techplex.in/customer-enrollment/agent_target");
		Thread.sleep(2000);
		
		//Agent
		WebElement agent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("agent_no")));
		Select selectAgent = new Select(agent);
		selectAgent.selectByValue("SWMT-A0037");
		Thread.sleep(2000);
		
		//Period End 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("period_end"))).click();
		Thread.sleep(1000);
		WebElement selectMonthAndYear = driver.findElement(By.xpath("//div[@class='air-datepicker-nav--action']//*[name()='svg']"));
		int clickcount = 24;  //for Above 18
		for (int i = 0; i < clickcount; i++) 
		{
			selectMonthAndYear.click();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[4]"))).click();
		Thread.sleep(2000);
		
		//FD Target
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fd_target"))).sendKeys("20");
		Thread.sleep(2000);
		
		//RD Target
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rd_target"))).sendKeys("20");
		Thread.sleep(2000);
		
		//SB Target
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sb_target"))).sendKeys("20");
		Thread.sleep(2000);
		
		//Current Account Target
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("current_target"))).sendKeys("20");
		Thread.sleep(2000);
		
		//MIS Target
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mis_target"))).sendKeys("20");
		Thread.sleep(2000);
		
		//Pigmy Target
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pigmy_target"))).sendKeys("20");
		Thread.sleep(2000);
		
		//Collection Target
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("collection_target"))).sendKeys("100000");
		Thread.sleep(2000);
		
		//OD Target
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("od_target"))).sendKeys("20");
		Thread.sleep(2000);
		
		//LOD Target
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lod_target"))).sendKeys("20");
		Thread.sleep(2000);
		
		//Assign Target
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Assign Target']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//Agent
		WebElement agent1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("agent_no")));
		Select selectAgent1 = new Select(agent1);
		selectAgent1.selectByValue("SWMT-A0037");
		Thread.sleep(10000);
	}
}
