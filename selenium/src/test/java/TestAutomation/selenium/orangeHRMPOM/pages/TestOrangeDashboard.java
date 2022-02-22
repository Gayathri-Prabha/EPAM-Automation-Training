package TestAutomation.selenium.orangeHRMPOM.pages;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestAutomation.selenium.WebDriverFactory;

public class TestOrangeDashboard {
	WebDriver driver;
	@BeforeClass
	@Parameters("browserName")
	public void setup(String browserName) {
		driver = WebDriverFactory.getWebDriver(browserName);
	}

	@Test
	public void testLogin() throws InterruptedException {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		TestDashboard loginPage = new TestDashboard(driver);
		loginPage.enterUsername("Admin").enterPassword("U@qBLVtm09").loginButton().navigateToLeaveList().configure();
		Set<String> windows = driver.getWindowHandles();
		for (Iterator iterator = windows.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println("-->" + string);
		}
	}
}
