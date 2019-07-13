package PageObjects;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.io.FileUtils;

public class PageObject {
	protected WebDriver driver;
	
	protected String uri;
	protected String pageName;
	
	private String screenShootPath = "C:/Temp/JavaTestResults/";

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
    
    public String takeScreenshot(String filename) {
    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	try {
    		String fileName = screenShootPath + filename;
			FileUtils.copyFile(scrFile, new File(screenShootPath + filename));
			return fileName;
		} catch (IOException e) {			
			e.printStackTrace();
			return null;
		}
    }
}
