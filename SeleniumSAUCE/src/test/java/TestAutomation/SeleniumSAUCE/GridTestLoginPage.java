package TestAutomation.SeleniumSAUCE;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridTestLoginPage {
	RemoteWebDriver driver;
	@BeforeClass
	@Parameters("BrowserName")
	public void setup(String BrowserName) throws MalformedURLException{
		driver = WebGridDriverFactory.getWebDriver(BrowserName);
	}
	
	@Test
	public void testLogin() throws InterruptedException {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName("Admin")
				 .enterPassword("U@qBLVtm09")
				 .clickLoginButton();
	}
}
