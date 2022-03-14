package TestAutomation.ProgramsPortal.Selenium.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
	static WebDriver driver;
	public static WebDriver getWebDriver(String browserName) {
		if (browserName.equals("Firefox")) {
			String driverPath = "C:\\browserDriver\\geckodriver-v0.30.0-win64\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();
		} 
		else if (browserName.equals("Chrome")) {
			String driverPath = "C:\\browserDriver\\chromedriver_win32\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
		} 
		else {
			driver=null;
		}
		return driver;
	}
}
