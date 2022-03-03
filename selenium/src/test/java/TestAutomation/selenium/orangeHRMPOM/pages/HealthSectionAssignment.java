package TestAutomation.selenium.orangeHRMPOM.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import TestAutomation.selenium.WebDriverFactory;

public class HealthSectionAssignment {
	WebDriver driver;
	@BeforeClass
	@Parameters("browserName")
	public void setup(String browserName) {
		driver = WebDriverFactory.getWebDriver(browserName);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test
	public void testLogin() throws InterruptedException {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/client/#/pim/employees/13/personal_details");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName("Admin")
				 .enterPassword("U@qBLVtm09")
				 .clickLoginButton()
				 .clickRadioButton()
				 .clickCheckBox1()
				 .clickCheckBox2();
	}
}
