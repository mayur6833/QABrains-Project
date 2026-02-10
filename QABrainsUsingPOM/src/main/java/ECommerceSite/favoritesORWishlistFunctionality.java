package ECommerceSite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class favoritesORWishlistFunctionality 
{
	private WebDriver driver;
	private WebDriverWait wait;
	
	public favoritesORWishlistFunctionality(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@FindBy(xpath = "(//*[name()='svg'][@class='w-5 h-5'])[1]")
	public WebElement addSampleShirtFAV;
	
	@FindBy(xpath = "(//*[name()='svg'][@class='w-5 h-5'])[2]")
	public WebElement addSampleShoeName;
	
	@FindBy(xpath = "//span[text()='test@qabrains.com'] ")
	public WebElement goToFav;
	
	@FindBy(xpath = "//*[contains(text(),'Favorite')]")
	public WebElement clickOnFavList;
	
	@FindBy(xpath = "(//*[name()='svg'][@class='w-5 h-5'])[1]")
	public WebElement removeProductFAV;
	
//	@FindBy(xpath = "(//*[name()='svg'][@class='w-5 h-5'])[2]")
//	public WebElement removeSecondProduct;
	
	@FindBy(xpath = "(//a[normalize-space()='Continue Shopping'])[1]")
	public WebElement continueShopping;
	
	public void productAddRemoveFromFavList() throws Exception
	{
		//ADD
		wait.until(ExpectedConditions.visibilityOf(addSampleShirtFAV)).click();
		wait.until(ExpectedConditions.visibilityOf(addSampleShoeName)).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(goToFav)).click();
		wait.until(ExpectedConditions.visibilityOf(clickOnFavList)).click();
		Thread.sleep(2000);
		
		//2ndTestCase
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Favorites']")));
		
		//Remove
		wait.until(ExpectedConditions.visibilityOf(removeProductFAV)).click();
		wait.until(ExpectedConditions.visibilityOf(removeProductFAV)).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(continueShopping)).click();
		
	}
}
