package drivers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCollection {
	
	public interface IBrowser {
		WebDriver getDriver();
		void start();
		void cleanUp();
		void dispose();
		boolean canInit(String browserName);
	}
	
	public class Chrome implements IBrowser {
		
		protected WebDriver driver;
		
		public boolean canInit(String browserName) {
			return browserName.equalsIgnoreCase("Chrome");
		}
		
		public WebDriver getDriver() {
			return driver;
		}
		
		public void start() {
			System.setProperty("webdriver.chrome.driver","C:/Temp/chromedriver.exe");
	    	driver = new ChromeDriver();
	 	   	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
		}
		
		public void cleanUp() {
			driver.manage().deleteAllCookies();
		}
		
		public void dispose() {
			driver.close();
		}
	}
	
	public static class Browser {
		
		protected static WebDriver driver;
		
		protected static BrowserCollection bc = new BrowserCollection();
		
		protected static List<IBrowser> browsersList = new ArrayList<IBrowser>() {{
			add(bc.new Chrome());
		}};
		
		public static IBrowser getBrowser() {
			Properties prop = new Properties();
			String browsername = null;
			try {
			FileInputStream ip = new FileInputStream("src/config.properties");
			prop.load(ip);
			browsername = prop.getProperty("Browser");
			}
			catch(IOException e) {
				return null;
			}
			
			for (IBrowser iBrowser : browsersList) {
				if(iBrowser.canInit(browsername))
					return iBrowser;
			}
			
			return null;
		}
		
		
	}

}
