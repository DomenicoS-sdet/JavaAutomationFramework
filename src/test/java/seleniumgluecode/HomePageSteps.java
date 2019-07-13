package seleniumgluecode;

import PageObjects.PagesCollection.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import com.cucumber.listener.Reporter;

public class HomePageSteps {
	
	@Given("^I Navigate to the home page$")
	public void i_Navigate_to_the_home_page() throws Throwable {
		Pages.homePage.goTo();	
		Reporter.addScreenCaptureFromPath(Pages.homePage.takeScreenshot());
	}

	@When("^I am on the home page$")
	public void i_am_on_the_home_page() throws Throwable {
	  Assert.assertTrue(Pages.homePage.isAt());
	  Reporter.addScreenCaptureFromPath(Pages.homePage.takeScreenshot());
	}

	@Then("^The search button is available$")
	public void the_search_button_is_available() throws Throwable {
	   Assert.assertTrue(Pages.homePage.isHomePageReady()); 
	   Reporter.addScreenCaptureFromPath(Pages.homePage.takeScreenshot());
	}
}
