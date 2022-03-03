package TestAutomation.SeleniumSAUCE;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestLoginPageOrangeHRMSoftAssert {
	private ExtentTest test;
	private ExtentReports report;
	WebDriver driver;
	@BeforeClass
	@Parameters("BrowserName")
	public void setup() throws MalformedURLException{
		String filePath = ".//src/main/resources//ExtentReportResults.html";
		report = new ExtentReports(filePath);
		test = report.startTest("ExtentDemo");
		driver = WebDriverFactory.getWebDriver("Chrome");
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void testLogin() throws InterruptedException {
		SoftAssert softAssert=new SoftAssert();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName("Admin")
				 .enterPassword("U@qBLVtm09")
				 .clickLoginButton();
		softAssert.assertTrue(false, "SOFTAssert Failes.. continuing");
		softAssert.assertEquals(driver.getTitle(), "OrangeHRM", "SOFTAssert Failes.. continuing");
		System.out.println("After test case failed");
		
		if(driver.getTitle().equals("OrangeHRM")) {
			test.log(LogStatus.PASS,"Navigated to the specified URL");
		}
		else {
			test.log(LogStatus.FAIL,"Test Failed");
		}
		softAssert.assertAll();
	}

	@AfterClass
	public void close()
	{
		driver.close();
		driver.quit();
		report.endTest(test);
		report.flush();
	}
}
