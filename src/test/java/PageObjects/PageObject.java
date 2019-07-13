package PageObjects;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
	protected WebDriver driver;
	
	private String screenShootPath = "C:/Temp/JavaTestResults/";
	
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
    
    public String takeScreenshot() {
    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	
    	Random rand = new Random();

    	int n = rand.nextInt(2147483647);
    	String fileName = screenShootPath + n + ".jpg";
    	try {
    		
			FileUtils.copyFile(scrFile, new File(fileName));
			return fileName;
		} catch (IOException e) {			
			e.printStackTrace();
			return null;
		}
    }
}
