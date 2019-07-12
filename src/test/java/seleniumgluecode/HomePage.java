package seleniumgluecode;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class HomePage {
	
	public static WebDriver driver;
	
	@Given("^I Navigate to the home page$")
	public void i_Navigate_to_the_home_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:/Temp/chromedriver.exe");
		
	   driver = new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.manage().window().maximize();
       driver.get("https://www.phptravels.net/");
	}

	@When("^I am on the home page$")
	public void i_am_on_the_home_page() throws Throwable {
	    Assert.assertTrue("Not on the correct page", driver.getTitle().equalsIgnoreCase("PHPTRAVELS | Travel Technology Partner"));
	}

	@Then("^The search button is available$")
	public void the_search_button_is_available() throws Throwable {
	   Assert.assertTrue(driver.findElement(By.xpath("//button[text() = ' Search']")).isDisplayed());
	    
	   driver.quit();
	}
}
