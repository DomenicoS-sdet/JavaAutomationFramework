package seleniumgluecode;

import PageObjects.HomePagePO;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import drivers.Browser.Chrome;

import java.util.List;

import org.junit.Assert;

import com.cucumber.listener.Reporter;

public class HomePageSteps {
	
	private HomePagePO homepage = new HomePagePO(Chrome.getDriver());
		
	@Given("^I Navigate to the home page$")
	public void i_Navigate_to_the_home_page() throws Throwable {
		homepage.goTo();	
		Reporter.addScreenCaptureFromPath(homepage.takeScreenshot());
	}
	
	@When("^I fill the hotel search with the following data$")
	public void i_fill_the_hotel_search_with_the_following_data(DataTable arg1) throws Throwable {
	    List<String> list = arg1.asList(String.class);
	    
	    homepage.fillHotelSearchFields(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
	    Reporter.addScreenCaptureFromPath(homepage.takeScreenshot());	    
	}

	@When("^I click on the button Search$")
	public void i_click_on_the_button_Search() throws Throwable {
	    homepage.startSearch();
	    Reporter.addScreenCaptureFromPath(homepage.takeScreenshot());    
	}

	@When("^I am on the home page$")
	public void i_am_on_the_home_page() throws Throwable {
	  Assert.assertTrue(homepage.isAt());
	  Reporter.addScreenCaptureFromPath(homepage.takeScreenshot());
	}

	@Then("^The search button is available$")
	public void the_search_button_is_available() throws Throwable {
	   Assert.assertTrue(homepage.isHomePageReady()); 
	   Reporter.addScreenCaptureFromPath(homepage.takeScreenshot());
	}
}
