package TestAutomation.SeleniumSAUCE;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestLoginPageOrangeHRM {
	protected RemoteWebDriver driver;
	@BeforeClass
	@Parameters("BrowserName")
	public void setup() throws MalformedURLException{
		driver = WebSaucedDriverFactory.getWebDriver("Chrome");
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
	}

	@Test
	public void testLogin() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName("Admin")
				 .enterPassword("U@qBLVtm09")
				 .clickLoginButton();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		String resultFortest = result.isSuccess() ? "passed":"failed";
		driver.executeScript("sauce:job-result="+ resultFortest);
	}

	@AfterClass
	public void close()
	{
		driver.close();
		driver.quit();
	}
}
