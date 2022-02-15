package TestAutomation.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestWebDriver {
	@Test
	public void LoadWebDriver() {
		String driverPath="C:\\browserDriver\\geckodriver-v0.30.0-win64\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.orangehrm.com/");
		String driverPathChrome="C:\\browserDriver\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPathChrome);
		WebDriver chromeDriver=new ChromeDriver();
		chromeDriver.get("https://www.orangehrm.com/");
	}
}
