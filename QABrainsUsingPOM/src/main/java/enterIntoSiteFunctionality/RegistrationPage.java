package enterIntoSiteFunctionality;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage 
{
	private WebDriver driver;
	private WebDriverWait wait;
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@FindBy(xpath = "//span[text()='Registration']")
	public WebElement navToReg;
	
	@FindBy(id = "name")
	public WebElement Name;
	
	@FindBy(id = "country")
	public WebElement country;
	
	@FindBy(id = "account")
	public WebElement accountType;
	
	@FindBy(id = "email")
	public WebElement email;
	
	@FindBy(id = "password")
	public WebElement passWord;
	
	@FindBy(id = "confirm_password")
	public WebElement confirmPassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement signUp;
	
	public void signUpToApp(String NAME, String registerEmail, String newPassword, String passwordAgain) throws Exception
	{
		//Navigate to Registration
		WebElement registerNav = wait.until(ExpectedConditions.elementToBeClickable(navToReg));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", registerNav);
		registerNav.click();
				
		//Name
		wait.until(ExpectedConditions.visibilityOf(Name)).sendKeys(NAME);
		
		//Select Country
		WebElement selectCountry = wait.until(ExpectedConditions.visibilityOf(country));
		Select SC = new Select(selectCountry);
		SC.selectByValue("India");
		
		//Account Type
		WebElement accountTypes = wait.until(ExpectedConditions.visibilityOf(accountType));
		Select AT = new Select(accountTypes);
		AT.selectByValue("Engineer");
		
		//email
		wait.until(ExpectedConditions.visibilityOf(email)).sendKeys(registerEmail);
		
		//Password
		wait.until(ExpectedConditions.visibilityOf(passWord)).sendKeys(newPassword);
		
		//confirmPassword 
		wait.until(ExpectedConditions.visibilityOf(confirmPassword)).sendKeys(passwordAgain);
		
		Thread.sleep(2000);
		
		//signUp
		WebElement signUpBTN = wait.until(ExpectedConditions.elementToBeClickable(signUp));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", signUpBTN);
//		((JavascriptExecutor) driver).executeScript("arguments[0].click()", signUpBTN);
		signUpBTN.click();
		
		Thread.sleep(5000);

	}
}
