package seleniumgluecode;

import PageObjects.PageCollection.Pages;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import com.cucumber.listener.Reporter;

public class SearchResultsSteps {
	
	@Then("^a list of hotels is returned$")
	public void a_list_of_hotels_is_returned() throws Throwable {
	    
		Assert.assertTrue(Pages.searchResultPage().isListOfResultsReturned());
		Reporter.addScreenCaptureFromPath(Pages.searchResultPage().takeScreenshot());
	}

}
