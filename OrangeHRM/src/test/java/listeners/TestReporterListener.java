package listeners;

import static org.testng.Assert.assertTrue;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import driverFactory.WebDriverFactoryProvider;

@Listeners(ReporterListenerImpl.class)

public class TestReporterListener {
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
		context.setAttribute("WebDriver", driver);
	}
	
	@Test
	public void testFailure() {
		driver.findElement(By.xpath("//input[@type='tex']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("U@qBLVtm09");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Test
	public void testLogin () {
		assertTrue(true);
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
