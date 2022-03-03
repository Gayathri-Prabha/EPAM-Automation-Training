package TestAutomation.BDD.feature;

import static org.testng.Assert.assertTrue;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import driverFactory.WebDriverFactoryProvider;
import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.UsersPage;

public class CucumberDefinitionImpl {
	private static WebDriver driver;
	private static String platformname;
	private static String orangeHRMURL;
	private static LoginPage loginPage;
	private static UsersPage usersPage;
	@BeforeTest
	public static void setup(ITestContext context)throws MalformedURLException
	{
		String browserName = context.getCurrentXmlTest().getParameter("BrowserName");
		platformname = context.getCurrentXmlTest().getParameter("OrangeHRMTestExecutionPlatform");
		orangeHRMURL = context.getCurrentXmlTest().getParameter("OrangeHRMBaseURL");
		driver = WebDriverFactoryProvider.getWebDriverFactory(platformname).getWebDriver(browserName);
		loginPage = new LoginPage(driver);
	}

	@Given("Open Browser")
	public void open_browser() {
		loginPage = new LoginPage(driver);
		driver.get(orangeHRMURL);
	}

	@Given("Username is {string} and password is {string}")
	public void username_is_and_password_is(String userName, String password) {
		loginPage = loginPage.enterUserName(userName)
							 .enterPassword(password);
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		loginPage.clickLoginButton();
	}

	@Then("user should navigate to Dashboard")
	public void user_should_navigate_to_dashboard() {
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.endsWith("dashboard"));
	}

/*	@Then("user should navigate to Retry Page")
	public void user_should_navigate_to_retry_page() {
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.endsWith("retry"));
	}  */
	
	@Given("Login Page is Opened")
	public void login_page_is_opened() {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/auth/login");
	}
	
	@Then("user should navigate to {string}")
	public void user_should_navigate_to(String string) {
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.endsWith(string));
	}
	
	@When("user click on admin option")
	public void user_click_on_admin_option() throws InterruptedException {
	    usersPage=new UsersPage(driver);
	    usersPage.clickAdminButton();
	}

	@And("user click on user management option")
	public void user_click_on_user_management_option() throws InterruptedException {
		usersPage.clickUserManagementButton();
	}

	@And("user click on users option")
	public void user_click_on_users_option() throws InterruptedException {
		usersPage.clickUsersButton();
	}

	@Then("user should navigate to Users Page")
	public void user_should_navigate_to_users_page() {
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.endsWith("systemUsers"));
	}

	@When("user click on edit icon where Username is amanda")
	public void user_click_on_edit_icon_where_username_is_amanda() throws InterruptedException {
		usersPage.clickEditButton();
	}

	@And("user click on admin role dropdown")
	public void user_click_on_admin_role_dropdown() throws InterruptedException {
		usersPage.clickAdminRoleDropdown();
	}

	@Then("user should select Global Admin")
	public void user_should_select_global_admin() throws InterruptedException {
		usersPage.selectGlobalAdmin();
	}

	@And("user should click on save button")
	public void user_should_click_on_save_button() throws InterruptedException {
		usersPage.clickSaveButton();
	}

	@Then("user should be able to see Global Admin under User Role\\(s) for amanda")
	public void user_should_be_able_to_see_global_admin_under_user_role_s_for_amanda() throws InterruptedException {
		usersPage.verifyGlobalAdminAfterAdding();
	}

	@Then("user should select --Select--")
	public void user_should_select_select() throws InterruptedException {
		usersPage.clickSelectOption();
	}

	@Then("Global Admin should not be present under User Role\\(s) for amanda")
	public void global_admin_should_not_be_present_under_user_role_s_for_amanda() throws InterruptedException {
		usersPage.verifyGlobalAdminAfterDeleting();
	}

	@When("user click on dropdown")
	public void user_click_on_dropdown() throws InterruptedException {
		usersPage.clickDownArrow();
	}

	@And("user click on Logout button")
	public void user_click_on_logout_button() throws InterruptedException {
		usersPage.clickLogoutButton();
	}

	@Then("user should navigate to Login Page")
	public void user_should_navigate_to_login_page() {
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.endsWith("login"));
	}
}
