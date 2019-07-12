package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
	protected WebDriver driver;
	
	protected String uri;
	protected String pageName;

    public PageObject(WebDriver driver, String uri, String pageName){
        this.driver = driver;
        this.uri = uri;
        this.pageName = pageName;
        PageFactory.initElements(driver, this);
    }
    
    public void goTo() {
    	driver.get(uri);
    }
    
    public Boolean isAt() {
    	return driver.getTitle().equalsIgnoreCase(pageName);
    }
}
