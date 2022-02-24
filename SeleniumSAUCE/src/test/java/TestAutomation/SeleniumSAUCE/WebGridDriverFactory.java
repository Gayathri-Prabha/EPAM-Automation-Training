package TestAutomation.SeleniumSAUCE;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebGridDriverFactory {
	private static final String hubURL="http://localhost:4444/wd/hub";
	public static RemoteWebDriver getWebDriver(String BrowserName) throws MalformedURLException {
		RemoteWebDriver driver= null;
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setPlatform(Platform.WIN10);
		if (BrowserName.equals("firefox")) {
			capabilities.setBrowserName("firefox");
			driver=new RemoteWebDriver(new URL(hubURL),capabilities);
		} 
		else if (BrowserName.equals("chrome")) {
			capabilities.setBrowserName("chrome");
			driver=new RemoteWebDriver(new URL(hubURL),capabilities);
		} 
		else {
			driver=null;
		}
		return driver;
	}
}
