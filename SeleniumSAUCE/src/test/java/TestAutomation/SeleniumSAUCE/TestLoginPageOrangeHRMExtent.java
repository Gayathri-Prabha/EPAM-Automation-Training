package TestAutomation.SeleniumSAUCE;

import java.io.File;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestLoginPageOrangeHRMExtent {
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
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName("Admin")
				 .enterPassword("U@qBLVtm09")
				 .clickLoginButton();
	/*	if(driver.getTitle().equals("Dashboard")) {
			test.log(LogStatus.PASS,"Navigated to the specified URL");
		}
		else {
			test.log(LogStatus.FAIL,"Test Failed");
		} */
	}
	
	@AfterMethod
	public void writeTestLog(ITestResult result) throws Exception{
		if(result.isSuccess()) {
			String screenshotPath = getScreenShot(driver, result.getName());
			test.log(LogStatus.PASS, "Test Passed" + result.getTestName(), test.addScreenCapture(screenshotPath));
		}
		else {
			String screenshotPath = getScreenShot(driver, result.getName());
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		}
	}
	
	public String getScreenShot(WebDriver driver, String screenshotName) throws Exception{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String fileName = screenshotName+dateName+".png";
		String destination = ".//src/main/resources//"+screenshotName+dateName+".png";
		java.io.File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return fileName;
	}
	
	@AfterClass
	public void close() {
		driver.close();
		driver.quit();
		report.endTest(test);
		report.flush();
	}
}
