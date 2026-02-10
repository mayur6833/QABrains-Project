package ECommerceSite;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckPriceRange 
{
	private WebDriver driver;
	private WebDriverWait wait;

	public CheckPriceRange(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(xpath = "//button[@role='combobox']")
	public WebElement orderBySelect;

	@FindBy(xpath = "//div[contains(text(),'Low to High (Price)')]")
	public WebElement selectOptionLowToHigh;

	@FindBy(xpath = "//span[contains(@class,'text-lg') and contains(@class,'font-bold')]")
	public List<WebElement> allActualPrices;

	public void validatePriceLowToHigh() throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(orderBySelect)).click();
		wait.until(ExpectedConditions.elementToBeClickable(selectOptionLowToHigh)).click();

		wait.until(ExpectedConditions.visibilityOfAllElements(allActualPrices));

		List<Double> actualPrices = extractPrices();

		List<Double> sortedPrices = new ArrayList<>(actualPrices);
		Collections.sort(sortedPrices);

		System.out.println("Actual Prices : " + actualPrices);
		System.out.println("Sorted Prices : " + sortedPrices);

		Assert.assertEquals(actualPrices, sortedPrices, " Prices are NOT sorted Low to High");

	}

	@FindBy(xpath = "//div[contains(text(),'High to Low (Price)')]")
	public WebElement selectOptionHighToLow;

	public void validatePriceHighToLow() {
		wait.until(ExpectedConditions.elementToBeClickable(orderBySelect)).click();
		wait.until(ExpectedConditions.elementToBeClickable(selectOptionHighToLow)).click();

		wait.until(ExpectedConditions.visibilityOfAllElements(allActualPrices));

		List<Double> actualPrices = extractPrices();

		List<Double> sortedPrices = new ArrayList<>(actualPrices);
		Collections.sort(sortedPrices, Collections.reverseOrder());

		System.out.println("Actual Prices : " + actualPrices);
		System.out.println("Sorted Prices : " + sortedPrices);

		Assert.assertEquals(actualPrices, sortedPrices, " Prices are NOT sorted High to Low");
	}

	private List<Double> extractPrices() {
		List<Double> prices = new ArrayList<>();
		for (WebElement price : allActualPrices) {
			String text = price.getText().replaceAll("[^0-9.]", "");
			prices.add(Double.parseDouble(text));
		}
		return prices;
	}
}
