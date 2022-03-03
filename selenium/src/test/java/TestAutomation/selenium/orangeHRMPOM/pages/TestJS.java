package TestAutomation.selenium.orangeHRMPOM.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestAutomation.selenium.WebDriverFactory;

public class TestJS {
	WebDriver driver;
	@BeforeClass
	@Parameters("browserName")
	public void setup(String browserName) {
		driver = WebDriverFactory.getWebDriver(browserName);
	}

	@Test
	public void testLogin() throws InterruptedException {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		LoginPageJSExecutor loginPage = new LoginPageJSExecutor(driver);
		loginPage.enterUserName("\"Admin\"")
				 .enterPassword("\"U@qBLVtm09\"")
				 .clickLoginButton();
	}
}
