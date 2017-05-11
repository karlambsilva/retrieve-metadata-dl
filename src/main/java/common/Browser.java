package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	
	private static WebDriver driver;
	
	//Diretorio do chrome driver
	public static String PATH_TO_CHROME_DRIVER = "/Applications/Selenium/ChromeDriverSelenium/chromedriver";
	
	public static WebDriver getDriver(){
		
		if (driver == null){
			System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
			driver = new ChromeDriver();
		}
		
		return driver;
	}
	
}
