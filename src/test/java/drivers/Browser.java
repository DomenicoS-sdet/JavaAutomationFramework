package drivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

	
	public static class Chrome {
		
		protected static WebDriver driver;
		
		public static WebDriver getDriver() {
			return driver;
		}
		
		public static void start() {
			System.setProperty("webdriver.chrome.driver","C:/Temp/chromedriver.exe");
	    	driver = new ChromeDriver();
	 	   	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
		}
		
		public static void cleanUp() {
			driver.manage().deleteAllCookies();
		}
		
		public static void dispose() {
			driver.close();
		}

		public static String takeScreenshot() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
