package driverFactory;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;

public abstract class DriverFactory {
	public abstract WebDriver getWebDriver(String browserName) throws MalformedURLException;
}
