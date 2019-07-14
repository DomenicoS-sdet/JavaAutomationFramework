package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class HomePagePO extends PageObject {

	@FindBy(xpath = "//button[text() = ' Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//*[text()='Search by Hotel or City Name']/parent::a/parent::div//input")
	private WebElement citySearch;

	@FindBy(xpath = "//input[@placeholder=\"Check in\" and @name='checkin']")
	private WebElement checkIn;

	@FindBy(xpath = "//input[@placeholder=\"Check out\" and @name='checkout']")
	private WebElement checkOut;

	@FindBy(id = "travellersInput")
	private WebElement travellersInput;

	@FindBy(id = "adultInput")
	private WebElement adultInput;

	@FindBy(id = "childInput")
	private WebElement childInput;

	public HomePagePO(WebDriver driver) {
		super(driver, "https://www.phptravels.net/", "PHPTRAVELS | Travel Technology Partner");
	}

	public Boolean isHomePageReady() {
		return searchBtn.isDisplayed();
	}

	public void fillHotelSearchFields(String city, String checkin, String checkout, String adults, String childs) {
		citySearch.sendKeys(city);
		driver.findElement(By.xpath("//*[text()='Locations']/following-sibling::ul/li//span[text()='" + city + "']"))
				.click();

		checkIn.sendKeys(checkin);
		checkOut.sendKeys(checkout);

		travellersInput.click();

		while (!adultInput.getAttribute("value").equals(adults)) {

			if (Integer.parseInt(adultInput.getAttribute("value")) < Integer.parseInt(adults)) {
				driver.findElement(By.id("adultPlusBtn")).click();
			} else {
				driver.findElement(By.id("adultMinusBtn")).click();
			}
		}

		while (!childInput.getAttribute("value").equals(childs)) {

			if (Integer.parseInt(childInput.getAttribute("value")) < Integer.parseInt(childs)) {
				driver.findElement(By.id("childPlusBtn")).click();
			} else {
				driver.findElement(By.id("childMinusBtn")).click();
			}
		}
		
		travellersInput.click();

	}

	public void startSearch() {
		searchBtn.click();
	}

}
