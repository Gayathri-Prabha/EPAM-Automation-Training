package TestAutomation.selenium;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import TestAutomation.selenium.orangeHRMPOM.pages.LoginPage;
import TestAutomation.selenium.orangeHRMPOM.pages.LoginPageSS;

public class ApplyLeaveAssignment {
	WebDriver driver;
	@BeforeClass
	@Parameters("browserName")
	public void setup(String browserName) {
		driver = WebDriverFactory.getWebDriver(browserName);
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testLogin() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName("Admin")
				 .enterPassword("U@qBLVtm09")
				 .clickLoginButton();
	}
	
	@Test(dependsOnMethods= {"testLogin"})
	public void testApplyLeave() throws InterruptedException {	
		ApplyLeave applyLeave = new ApplyLeave(driver);
		applyLeave.clickLeaveButton()
				  .clickApplyButton()
				  .clickLeaveType()
				  .selectSickLeave()
				  .selectFromDate("Fri, 04 Mar 2022")
				  .selectToDate("Thu, 03 Mar 2022")
				  .errorMessageandColor()
				  .selectFromDate("Thu, 03 Mar 2022")
				  .selectToDate("Fri, 04 Mar 2022")
				  .enterComments("Sick Leave")
				  .submitLeave()
				  .verifyBalanceMessageandClose()
				  .clickCheckBalance()
				  .verifyAvailableBalanceandClose();
	}
}
