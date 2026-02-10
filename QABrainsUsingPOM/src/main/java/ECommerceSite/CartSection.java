package ECommerceSite;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSection 
{
	private WebDriver driver;
	private WebDriverWait wait;
	
	public CartSection(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//navigate to e-Commerce
	@FindBy(xpath = "//span[text()='E-Commerce Site']")
	public WebElement navigateToECommerce;
	
	//visit demo site
	@FindBy(xpath = "//a[@href='/ecommerce/login']")
	public WebElement visitSite;
	
	public void navigateToECommerceWebSite()
	{
		WebElement clickToNavigateWebsite = wait.until(ExpectedConditions.visibilityOf(navigateToECommerce));
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", clickToNavigateWebsite);
		clickToNavigateWebsite.click();
		
		WebElement visitDemo = wait.until(ExpectedConditions.visibilityOf(visitSite));
		visitDemo.click();
		
		wait.until(ExpectedConditions.urlContains("/ecommerce/login"));
	}
	
	//---------------------------------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------------
	
	@FindBy(xpath = "//div[3]//div[1]//button[1]")
	public WebElement addToCartSimpleJacketName;
	
	@FindBy(xpath = "//div[3]//a[2]")
	public WebElement jacketNameFromDashBoard;
	
	@FindBy(xpath = "//h3[normalize-space()='Sample Jacket Name']")
	public WebElement jacketnameFromCart;
	
	@FindBy(xpath = "//div[6]//div[1]//button[1]")
	public WebElement addToCartSampleSunglassName;
	
	@FindBy(xpath ="//div[6]//a[2]")
	public WebElement sunglassNameFromDashboard;
	
	@FindBy(xpath = "//h3[normalize-space()='Sample Sunglass Name']")
	public WebElement sunglassNameFromCart;
	
	//ClickOnCart
	@FindBy(xpath = "//*[local-name()='path' and contains(@d,'528.12')]")
	public WebElement clickOnCart;
	
	public void addToCart() throws Exception
	{
		WebElement jacket = wait.until(ExpectedConditions.elementToBeClickable(addToCartSimpleJacketName));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", jacket);
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", jacket);
		jacket.click();
		
		Thread.sleep(2000);
		
//		WebElement sunglass = wait.until(ExpectedConditions.elementToBeClickable(addToCartSampleSunglassName));
//		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", sunglass);
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", sunglass);
//		sunglass.click();
//		
//		Thread.sleep(2000);
	}
	
//	public void verifyProduct() throws Exception
//	{
//		WebElement clickOnCartbtn = wait.until(ExpectedConditions.visibilityOf(clickOnCart));
//		((JavascriptExecutor)driver).executeScript("arguments[0].click()", clickOnCartbtn);
//		clickOnCartbtn.click();
//		
//		String dashboardProductName1 = wait.until(ExpectedConditions.visibilityOf(jacketNameFromDashBoard)).getText();
//		String cartProductName1 = wait.until(ExpectedConditions.visibilityOf(jacketnameFromCart)).getText();
//		Assert.assertEquals(dashboardProductName1, cartProductName1, "Jacket Product is not added");
//		
//		
//		String dashboardProductName2 = wait.until(ExpectedConditions.visibilityOf(sunglassNameFromDashboard)).getText();
//		String cartProductName2 = wait.until(ExpectedConditions.visibilityOf(sunglassNameFromCart)).getText();
//		Assert.assertEquals(dashboardProductName2, cartProductName2, "Sunglass Product is not added");
//		
//		Thread.sleep(3000);
//	}
	
	//---------------------------------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------------
	
	@FindBy(xpath = "//button[@type='button' and contains(text(),'+')]")
	public WebElement increaseQuantity;
	
	@FindBy(xpath = "//button[contains(@class,'cursor-pointer') and text()='-']")
	public WebElement decreaseQuantity;
	
	public void quantityUpdate() throws Exception
	{	
		
		WebElement clickOnCartbtn = wait.until(ExpectedConditions.visibilityOf(clickOnCart));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", clickOnCartbtn);
//		((JavascriptExecutor)driver).executeScript("arguments[0].click()", clickOnCartbtn);
		clickOnCartbtn.click();
		
		WebElement increaseCount = wait.until(ExpectedConditions.visibilityOf(increaseQuantity));
		increaseCount.click();
		
		Thread.sleep(3000);
		
		WebElement decreaseCount = wait.until(ExpectedConditions.visibilityOf(decreaseQuantity));
		decreaseCount.click();
		
		Thread.sleep(3000);
	}
	
	//---------------------------------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------------------------------
	
	@FindBy(xpath = "//button[normalize-space()='Remove']")
	public WebElement removeProduct;
	
	@FindBy(xpath = "//button[contains(@class,'bg-red-500') and normalize-space()='Remove']")
	public WebElement removeAlert;
	
	public void removeProducts() throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(removeProduct)).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(removeAlert)).click();
		Thread.sleep(3000);
	}
}



























