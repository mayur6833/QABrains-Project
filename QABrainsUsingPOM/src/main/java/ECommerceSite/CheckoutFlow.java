package ECommerceSite;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutFlow 
{
	private WebDriver driver;
	private WebDriverWait wait;
	
	public CheckoutFlow(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/button[1]")
	public WebElement sampleShirtAddToCart;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/button[1]")
	public WebElement sampleShoeAddToCart;
	
	@FindBy(xpath = "//*[name()='path' and contains(@d,'M528.12 30')]")
	public WebElement clickOnCart;
	
	@FindBy(xpath = "(//button[@class='flex items-center gap-2 bg-qa-clr hover:bg-blue-600 transition duration-300 ease-in-out text-white px-6 py-2 rounded-3xl cursor-pointer'])[1]")
	public WebElement checkoutBtn;
	
	
	public void addToCart() throws Exception
	{
		WebElement product1 = wait.until(ExpectedConditions.visibilityOf(sampleShirtAddToCart));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", product1);
		product1.click();
		
		wait.until(ExpectedConditions.visibilityOf(sampleShoeAddToCart)).click();
		Thread.sleep(1000);
		
		WebElement clickOnCartbtn = wait.until(ExpectedConditions.visibilityOf(clickOnCart));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", clickOnCartbtn);
		clickOnCartbtn.click();
		
		WebElement clickOnCheckOut = wait.until(ExpectedConditions.visibilityOf(checkoutBtn));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", clickOnCheckOut);
		clickOnCheckOut.click();
	}
	
	@FindBy(xpath = "//input[@placeholder='Ex. John']")
	public WebElement firstName;
	
	@FindBy(xpath = "//input[@placeholder='Ex. Doe']")
	public WebElement lastName;
	
	@FindBy(xpath = "//input[@value='1207']")
	public WebElement zipCode;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/button[2]")
	public WebElement continueBtn;
	
	public void checkoutInf(String fName, String lName, String zip) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(fName);
		wait.until(ExpectedConditions.visibilityOf(lastName)).sendKeys(lName);
		wait.until(ExpectedConditions.visibilityOf(zipCode)).clear();
		wait.until(ExpectedConditions.visibilityOf(zipCode)).sendKeys(zip);
		Thread.sleep(1000);
		
		WebElement clickOnContinue = wait.until(ExpectedConditions.visibilityOf(continueBtn));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickOnContinue);
		clickOnContinue.click();
	}
	
	@FindBy(xpath = "//p[normalize-space()='Total']/following-sibling::p")
	public List<WebElement> productPrice;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[3]/p[1]")
	public WebElement totalPrice;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[3]/p[2]")
	public WebElement taxAmount;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[3]/p[3]")
	public WebElement grandtotal;
	
	@FindBy(xpath = "(//button[@class='flex items-center gap-2 bg-qa-clr hover:bg-blue-600 transition duration-300 ease-in-out text-white px-8 py-2 rounded-3xl cursor-pointer'])[1]")
	public WebElement finishbtn;
	
	
	public void overview() throws Exception
	{
		//Addition of all product prices that are present in cart
		double calculateproductPrice = 0.0;
		List<WebElement> productPrices = wait.until(ExpectedConditions.visibilityOfAllElements(productPrice));
		for (WebElement prices : productPrices) 
		{
			String productPriceText = prices.getText().replaceAll("[^0-9.]","");
			calculateproductPrice += Double.parseDouble(productPriceText);
		}
		System.out.println("Product Total Price from Cart: "+calculateproductPrice);
		
		Thread.sleep(5000);
		
		// Product Prices that already shown
		WebElement totalPrice1 = wait.until(ExpectedConditions.visibilityOf(totalPrice));
		String totalPriceText =	totalPrice1.getText().replaceAll("[^0-9.]", "");
		double totalPrice = Math.round(Double.parseDouble(totalPriceText)*100.00)/100.00;
		System.out.println("Product Total Prive From Bill section: "+totalPrice);
		
		Thread.sleep(5000);
		
		//Tax Amount that already shown
		WebElement totaltaxAmount1 = wait.until(ExpectedConditions.visibilityOf(taxAmount)); 
		String totalTaxAmounttext = totaltaxAmount1.getText().replaceAll("[^0-9.]", "");
		double totalTaxAmount = Math.round(Double.parseDouble(totalTaxAmounttext)*100)/100.00;
		System.out.println("Tax Amount: "+totalTaxAmount);
		
		Thread.sleep(5000);
		
		//Grand total that already shown
		WebElement grandTotalAmount1 = wait.until(ExpectedConditions.visibilityOf(grandtotal));
		String grandTotalText = grandTotalAmount1.getText().replaceAll("[^0-9.]", "");
		double maxTotal = Math.round(Double.parseDouble(grandTotalText)*100.00)/100.00;
		System.out.println("Grandtotal Amount: "+maxTotal);
		
		Thread.sleep(5000);
		
		//Addition of grand total (tax + all product price)
		double grandTotalCalculation = totalTaxAmount + calculateproductPrice;
		System.out.println("Grand Calculated Amount: "+grandTotalCalculation);
		
		Thread.sleep(5000);
		
		if(Math.abs(calculateproductPrice - totalPrice) < 0.01)
		{
			if(Math.abs(grandTotalCalculation - maxTotal) < 0.01)
			{
				WebElement clickOnFinish = wait.until(ExpectedConditions.visibilityOf(finishbtn));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", clickOnFinish);
				clickOnFinish.click();
				Thread.sleep(5000);
			}
		}
		else
		{
			System.out.println("Showing Wrong Prices");
		}
	}
}
