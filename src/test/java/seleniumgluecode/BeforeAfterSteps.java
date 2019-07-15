package seleniumgluecode;

import cucumber.api.java.Before;

import cucumber.api.java.After;
import drivers.BrowserCollection.Browser;

public class BeforeAfterSteps {
	

    @Before
    public static void setUp(){   	
    	Browser.getBrowser().start();
    }

    @After
    public void cleanUp(){
        Browser.getBrowser().cleanUp();
        Browser.getBrowser().dispose();
    }
}
