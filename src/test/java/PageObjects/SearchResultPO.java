package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import drivers.Browser.Chrome;

public class SearchResultPO extends PageObject{
	
	@FindBy(xpath = "//table[@class=\"bgwhite table table-striped\"]")
	private WebElement resultTable;
	
	public SearchResultPO(WebDriver driver) {
		super(driver, "https://www.phptravels.net/hotels/search/", "Search Results");
	}
	
	public Boolean isListOfResultsReturned() {
		return resultTable.isDisplayed();
	}

}
