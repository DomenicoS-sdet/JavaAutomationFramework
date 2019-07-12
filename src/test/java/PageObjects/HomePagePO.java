package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class HomePagePO extends PageObject {
	
	@FindBy(xpath="//button[text() = ' Search']")
	private WebElement searchBtn;
	
	public HomePagePO(WebDriver driver) {
		super(driver, "https://www.phptravels.net/", "PHPTRAVELS | Travel Technology Partner");
	}
	
	public Boolean isHomePageReady() {
		return searchBtn.isDisplayed();
	}

}
