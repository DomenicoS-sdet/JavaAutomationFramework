package seleniumgluecode;

import PageObjects.PageCollection.Pages;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import java.util.List;

import org.junit.Assert;

import com.cucumber.listener.Reporter;

public class HomePageSteps {
	

		
	@Given("^I Navigate to the home page$")
	public void i_Navigate_to_the_home_page() throws Throwable {
		Pages.homepage().goTo();	
		Reporter.addScreenCaptureFromPath(Pages.homepage().takeScreenshot());
	}
	
	@When("^I fill the hotel search with the following data$")
	public void i_fill_the_hotel_search_with_the_following_data(DataTable arg1) throws Throwable {
	    List<String> list = arg1.asList(String.class);
	    
	    Pages.homepage().fillHotelSearchFields(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
	    Reporter.addScreenCaptureFromPath(Pages.homepage().takeScreenshot());	    
	}

	@When("^I click on the button Search$")
	public void i_click_on_the_button_Search() throws Throwable {
		Pages.homepage().startSearch();
	    Reporter.addScreenCaptureFromPath(Pages.homepage().takeScreenshot());    
	}

	@When("^I am on the home page$")
	public void i_am_on_the_home_page() throws Throwable {
	  Assert.assertTrue(Pages.homepage().isAt());
	  Reporter.addScreenCaptureFromPath(Pages.homepage().takeScreenshot());
	}

	@Then("^The search button is available$")
	public void the_search_button_is_available() throws Throwable {
	   Assert.assertTrue(Pages.homepage().isHomePageReady()); 
	   Reporter.addScreenCaptureFromPath(Pages.homepage().takeScreenshot());
	}
}
