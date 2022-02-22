package TestAutomation.selenium.orangeHRMPOM.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestAutomation.selenium.WebDriverFactory;

public class TestAction {
	
		WebDriver driver;
		@BeforeClass
		@Parameters("browserName")
		public void setup(String browserName) {
			driver = WebDriverFactory.getWebDriver(browserName);
		}

		@Test
		public void testLogin() throws InterruptedException {
			driver.get("https://prasoonr-trials73.orangehrmlive.com/");
			LoginPageActionClass loginPage = new LoginPageActionClass(driver);
			loginPage.enterUserName("Admin")
					 .enterPassword("U@qBLVtm09")
					 .clickLoginButton();
		}
}
