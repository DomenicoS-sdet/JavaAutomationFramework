package seleniumgluecode;

import PageObjects.SearchResultPO;
import cucumber.api.java.en.Then;
import drivers.Browser.Chrome;
import org.junit.Assert;

import com.cucumber.listener.Reporter;

public class SearchResultsSteps {
	
	private SearchResultPO searchResultPage = new SearchResultPO(Chrome.getDriver());
	
	@Then("^a list of hotels is returned$")
	public void a_list_of_hotels_is_returned() throws Throwable {
	    
		Assert.assertTrue(searchResultPage.isListOfResultsReturned());
		Reporter.addScreenCaptureFromPath(searchResultPage.takeScreenshot());
	}

}
