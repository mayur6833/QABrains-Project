package SelenumCode;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckPriceRange 
{
	WebDriver driver;
	WebDriverWait wait;

	
	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.qabrains.com/");
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='E-Commerce Site']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/ecommerce/login']"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("test@qabrains.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Password123");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();
	}
	
	@Test(priority = 1)
	public void LowToHigh() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@role='combobox']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Low to High (Price)')]"))).click();
		
		Thread.sleep(10000);

		List<WebElement> priceElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(@class,'text-lg') and contains(@class,'font-bold')]")));
		
		List<Double> actualPrices = new ArrayList<Double>();
		
		for (WebElement prices : priceElements) 
		{
			String priceText = prices.getText().replaceAll("[^0-9.]", "");
			actualPrices.add(Double.parseDouble(priceText));
		}
		System.out.print("Low To High Actual Price : "+actualPrices+" ");
		System.out.println();
		
		List<Double> sortedPrice = new ArrayList<Double>(actualPrices);
		Collections.sort(sortedPrice);
		
		System.out.print("Low To High Sorted Price : "+sortedPrice+" ");
		
		Assert.assertEquals(actualPrices, sortedPrice, "Product Price Low To High are not sorted");
	}
	
//	@Test(priority = 2)
//	public void HighToLow()
//	{
//		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	}
//	
	@AfterClass
	public void exit()
	{
		if(driver != null)
		{
			driver.close();
		}
	}
}
