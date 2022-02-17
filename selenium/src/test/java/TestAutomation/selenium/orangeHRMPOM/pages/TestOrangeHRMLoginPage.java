package TestAutomation.selenium.orangeHRMPOM.pages;

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
		driver=WebDriverFactory.getWebDriver(browserName);
	}
	
	@Test(priority=1)
	public void testLoginFunctionality() {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserName("Admin")	
				 .enterPassword("U@qBLVtm09")
				 .clickLoginButton();
	}
	
	/*@Test(priority=2)
	public void testLoginFunctionalityWithoutEnteringEachElement() {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login("", "");
	}*/
}
