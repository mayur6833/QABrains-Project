package FormSubmission;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class formSubmissionDemo 
{
	private WebDriver driver;
	private WebDriverWait wait;
	
	public formSubmissionDemo(WebDriver driver) 
	{	
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@FindAll({
		@FindBy(id = "form-submission"),
		@FindBy(xpath = "//span[text()='Form Submission']")
	})
	public WebElement navigateToFormSubmission;
	
	@FindBy(id = "name")
	public WebElement name; 
	
	@FindBy(id ="email")
	public WebElement email;
	
	@FindBy(id = "contact")
	public WebElement contactNo; 
	
	@FindBy(id = "date")
	public WebElement date;
	
	@FindBy(id = "Red")
	public WebElement color;
	
	@FindBy(id = "Pizza")
	public WebElement food;
	
	@FindBy(id = "country")
	public WebElement Country;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement submit;
	
	@FindBy(xpath = "//h2[text()='successfully submitted']")
	public WebElement successMessage;
	
	public void form(String NAME, String mailID, String contactNO, String DATE) throws Exception
	{
		//Navigation
		WebElement formSubmission = wait.until(ExpectedConditions.elementToBeClickable(navigateToFormSubmission));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", formSubmission);
		formSubmission.click();
		
		//name
		wait.until(ExpectedConditions.visibilityOf(name)).sendKeys(NAME);
		
		//Email
		wait.until(ExpectedConditions.visibilityOf(email)).sendKeys(mailID);
		
		//Contact No
		wait.until(ExpectedConditions.visibilityOf(contactNo)).sendKeys(contactNO);
		
		//Date
		wait.until(ExpectedConditions.visibilityOf(date)).sendKeys(DATE);
		Thread.sleep(2000);
		
		//uploadFile (without page factory)
		WebElement uploadFile  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("file")));
		String file = "C:\\Users\\Mahindarr\\Desktop\\novaClick.txt";
		uploadFile.sendKeys(file);
		
		//Color
		WebElement selectColor = wait.until(ExpectedConditions.visibilityOf(color));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", selectColor);
		selectColor.click();
		
		//Food
		WebElement selectFood = wait.until(ExpectedConditions.visibilityOf(food));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", selectFood);
		selectFood.click();
		
		WebElement selectCountry = wait.until(ExpectedConditions.visibilityOf(Country));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", selectCountry);
		Select SC = new Select(selectCountry);
		SC.selectByValue("India");
		
		//Submit
		WebElement submitBTN = wait.until(ExpectedConditions.visibilityOf(submit));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", submitBTN);
		submitBTN.click();
		
		Thread.sleep(5000);
	}
	
	public boolean isFormSubmittedSuccessfully()
	{
		return wait.until(ExpectedConditions.visibilityOf(successMessage)).isDisplayed();
	}
}
































