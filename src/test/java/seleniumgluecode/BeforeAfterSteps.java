package seleniumgluecode;

import drivers.Browser.Chrome;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.AfterStep;

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
