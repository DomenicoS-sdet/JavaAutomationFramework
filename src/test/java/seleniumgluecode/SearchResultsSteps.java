package seleniumgluecode;

import PageObjects.PageCollection.Pages;
import PageObjects.SearchResultPO;
import cucumber.api.java.en.Then;
import drivers.BrowserCollection.Browser;
import drivers.BrowserCollection.Chrome;
import org.junit.Assert;

import com.cucumber.listener.Reporter;

public class SearchResultsSteps {
	
	
	
	@Then("^a list of hotels is returned$")
	public void a_list_of_hotels_is_returned() throws Throwable {
	    
		Assert.assertTrue(Pages.searchResultPage().isListOfResultsReturned());
		Reporter.addScreenCaptureFromPath(Pages.searchResultPage().takeScreenshot());
	}

}
