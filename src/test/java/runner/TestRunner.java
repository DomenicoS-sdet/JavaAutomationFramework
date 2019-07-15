package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;
import drivers.BrowserCollection.Chrome;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/java/features"
,glue= {"seleniumgluecode"},
plugin = { "com.cucumber.listener.ExtentCucumberFormatter:C:/Temp/JavaTestResults/report.html"}, 
monochrome = true
)

public class TestRunner {


}
