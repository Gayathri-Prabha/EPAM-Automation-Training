package TestAutomation.selenium.orangeHRMPOM.pages;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import TestAutomation.selenium.WebDriverFactory;

public class TestOrangeHRMLoginPage {
	WebDriver driver;
	@BeforeClass
	@Parameters("browserName")
	public void setup(String browserName) {
		driver = WebDriverFactory.getWebDriver(browserName);
	}

	@Test
	public void testLogin() throws InterruptedException {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		LoginPageSS loginPage = new LoginPageSS(driver);
		loginPage.enterUserName("Admin")
				 .enterPassword("U@qBLVtm09")
			//	 .printElementInputFields();
				 .clickLoginButton()
				 .testScreenShot();
	}
	
//	@Test
	public void testInvalidLogin() throws InterruptedException {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName("Admin")
				 .enterPassword("U@qBLVtm0")
				 .clickLoginButton();
		assertTrue(driver.getCurrentUrl().endsWith("securityAuthentication/retryLogin"));
		assertNotNull(driver.findElement(By.xpath("//*[@class='col s12']")));
	}	
}
