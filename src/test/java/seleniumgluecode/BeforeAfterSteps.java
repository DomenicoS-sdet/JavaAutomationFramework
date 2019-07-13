package seleniumgluecode;

import cucumber.api.java.Before;
import cucumber.api.java.After;
import drivers.Browser.Chrome;

public class BeforeAfterSteps {

    @Before
    public static void setUp(){   	
    	Chrome.start();
    }

    @After
    public void cleanUp(){
        Chrome.cleanUp();
        Chrome.dispose();
    }
}
