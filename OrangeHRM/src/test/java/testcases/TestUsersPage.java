package testcases;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import driverFactory.WebDriverFactoryProvider;
import pages.LoginPage;
import pages.UsersPage;

public class TestUsersPage {
	private WebDriver driver;
	private String orangeHRMUsername;
	private String orangeHRMPassword;
	private String platformName;
	@BeforeClass
	public void setup(ITestContext context) throws MalformedURLException{
		String browserName = context.getCurrentXmlTest().getParameter("BrowserName");
	    platformName = context.getCurrentXmlTest().getParameter("OrangeHRMTestExecutionPlatform");
		String orangeHRMURL = context.getCurrentXmlTest().getParameter("OrangeHRMBaseURL");
		this.orangeHRMUsername = context.getCurrentXmlTest().getParameter("OrangeHRMUsername");
		this.orangeHRMPassword = context.getCurrentXmlTest().getParameter("OrangeHRMPassword");
		driver = WebDriverFactoryProvider.getWebDriverFactory(platformName).getWebDriver(browserName);
		driver.manage().window().maximize();
		driver.get(orangeHRMURL);
	}
	
	@Test(priority=1)
	public void testLogin() throws InterruptedException{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(this.orangeHRMUsername)
				 .enterPassword(this.orangeHRMPassword)
				 .clickLoginButton();
	}
	
	@Test(priority=2)
	public void testAmanda() throws InterruptedException{
		UsersPage usersPage = new UsersPage(driver);
		usersPage.clickAdminButton()
				 .clickUserManagementButton()
				 .clickUsersButton()
				 .clickEditButton()
				 .clickAdminRoleDropdown()
				 .selectGlobalAdmin()
				 .clickSaveButton()
				 .verifyGlobalAdminAfterAdding()
				 .clickEditButton()
				 .clickAdminRoleDropdown()
				 .clickSelectOption()
				 .clickSaveButton()
				 .verifyGlobalAdminAfterDeleting()
				 .clickDownArrow()
				 .clickLogoutButton();
	}
}
