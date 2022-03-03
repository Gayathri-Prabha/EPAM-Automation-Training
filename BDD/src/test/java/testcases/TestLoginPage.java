package testcases;

import static org.testng.Assert.assertTrue;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import driverFactory.WebDriverFactoryProvider;
import pages.LoginPage;

public class TestLoginPage {
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
	
	@Test
	public void testLogin() throws InterruptedException{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(this.orangeHRMUsername)
				 .enterPassword(this.orangeHRMPassword)
				 .clickLoginButton()
				 .logOut();
	}
	
	@Test
	public void testLoginwithProxy() throws InterruptedException{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNamewithFindElement(this.orangeHRMUsername)
				 .enterPassword(this.orangeHRMPassword)
				 .clickLoginButton()
				 .logOut();
	}
	
	@Test
	public void testLoginUsingJavascript() throws InterruptedException{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(this.orangeHRMUsername)
				 .enterPassword(this.orangeHRMPassword)
				 .clickLoginButtonUsingJavascript()
				 .logOut();
	}
	
	@AfterMethod
	public void setStatus(ITestResult result)
	{
		if(platformName.equalsIgnoreCase("SAUCEWebDriver"))
		{
			String resultFortest = result.isSuccess() ? "passed":"failed";
			((RemoteWebDriver)driver).executeScript("sauce:job-result="+ resultFortest);
		}
	} 
	
	@AfterClass
	public void close()
	{
		driver.close();
		driver.quit();
	}
}
