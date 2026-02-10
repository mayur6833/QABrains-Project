package SelenumCode;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * 1. click on search bar and select search
 * 2. Set the range using drag & drop
 * 3. compare the set range min/max to product price
 * (split the range amount and store it onto array 
 *  get product values in list (get text -> covert into integer)
 *  compare the the value to min/max range)
 */

public class AutomatePriceRange 
{
	WebDriver driver; 
	WebDriverWait wait;
	
	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.myntra.com/");
	}
	
	@Test
	public void checkProductPriceRange() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='desktop-searchBar']"))).sendKeys("Shoes");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Shoes Men']"))).click();
		Thread.sleep(2000);
		
		WebElement min = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rootRailThumbLeft")));
		WebElement max = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rootRailThumbRight")));
		Actions act = new Actions(driver);
		act.clickAndHold(min).moveByOffset(50, 0).release().perform();
		Thread.sleep(2000);
		act.clickAndHold(max).moveByOffset(-100, 0).release().perform();
		Thread.sleep(2000);
		
		//Get price text
		String priceRangeText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("slider-dotContainer"))).getText();
		String priceRangeText2 = priceRangeText.replaceAll("[^0-9\\-]", "");
		String price[]= priceRangeText2.split("-");
		int minPrice = Integer.parseInt(price[0].trim());
		System.out.println("Minimum Range Price: "+minPrice);
		int maxPrice = Integer.parseInt(price[1].trim());
		System.out.println("Maximum Range Price: "+maxPrice);
		Thread.sleep(2000);
		
		List<WebElement> productpricetext1 = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("product-discountedPrice")));
		
		for (WebElement productPrice : productpricetext1) 
		{
			String productPriceText2 = productPrice.getText().replaceAll("[^0-9]", "");
			int priceAmount= Integer.parseInt(productPriceText2);
			System.out.println("Range Amount: "+priceAmount);
			Assert.assertTrue(priceAmount >= minPrice && priceAmount <= maxPrice,"Shwoing Wrong price");
		}
	}
	
	@AfterMethod
	public void takeScreenShotIfFail(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			File set = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File location = new File("C:\\Users\\Mahindarr\\git\\repository\\Practice\\ScreenShots\\"+result.getName()+".png");
			FileUtils.copyFile(set, location);
		}
	}
	
	@AfterClass
	public void exit()
	{
		if(driver != null)
		{
			driver.quit();
		}
	}
}
