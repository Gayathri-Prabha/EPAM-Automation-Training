package TestAutomation.SeleniumSAUCE;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebSaucedDriverFactory {
	private static final String hubURL="http://localhost:4444/wd/hub";
	public static RemoteWebDriver getWebDriver(String BrowserName) throws MalformedURLException {
		RemoteWebDriver driver= null;
		// setting up SAUCE properties/credenials
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("username", "oauth-mallavarapugp-9dbb8");
		//sauceOptions.setCapability("password", "oauth-prasoon.rana-5c24c"); // in case of password as credentials
		sauceOptions.setCapability("accessKey", "a26e2965-cd56-43fe-888d-4f9bf389e5d0");
		sauceOptions.setCapability("browserVersion", "latest");
		ChromeOptions options = new ChromeOptions();
		options.setCapability("sauce:options", sauceOptions);
		URL url = new URL("https://oauth-mallavarapugp-9dbb8:a26e2965-cd56-43fe-888d-4f9bf389e5d0@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
		driver = new RemoteWebDriver(url, options);
	if(BrowserName.equalsIgnoreCase("Chrome")) {
		ChromeOptions options1 = new ChromeOptions();
		options1.setCapability("sauce:options", sauceOptions);
		driver=new RemoteWebDriver(url,options1);
	}
	else if(BrowserName.equalsIgnoreCase("Firefox")) {
		FirefoxOptions options1 = new FirefoxOptions();
		options1.setCapability("sauce:options", sauceOptions);
		driver=new RemoteWebDriver(url,options1);
	}
	else {
		driver=null;
	}
	return driver;
	}
}
