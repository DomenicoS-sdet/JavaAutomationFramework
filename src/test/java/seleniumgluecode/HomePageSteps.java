package seleniumgluecode;

import PageObjects.HomePagePO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import drivers.Browser.Chrome;
import org.junit.Assert;

import com.cucumber.listener.Reporter;

public class HomePageSteps {
	
	private HomePagePO homepage = new HomePagePO(Chrome.getDriver());
		
	@Given("^I Navigate to the home page$")
	public void i_Navigate_to_the_home_page() throws Throwable {
		homepage.goTo();	
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
