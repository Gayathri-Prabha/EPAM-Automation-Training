package TestAutomation.SeleniumProject.OrangeHRM;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAttendanceSheetPage {
	private WebDriver driver;
	private String orangeHRMUsername;
	private String orangeHRMPassword;
	private String platformName;
	@BeforeClass
	public void setup(ITestContext context) throws MalformedURLException{
		String browserName = context.getCurrentXmlTest().getParameter("BrowserName");
		String orangeHRMURL = context.getCurrentXmlTest().getParameter("OrangeHRMBaseURL");
		this.orangeHRMUsername = context.getCurrentXmlTest().getParameter("OrangeHRMUsername");
		this.orangeHRMPassword = context.getCurrentXmlTest().getParameter("OrangeHRMPassword");
		driver = WebDriverFactory.getWebDriver(browserName);
		driver.manage().window().maximize();
		driver.get(orangeHRMURL);
	}
	
	@Test(priority = 1)
	public void testLogin() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(this.orangeHRMUsername)
				 .enterPassword(this.orangeHRMPassword)
				 .clickLoginButton();
	}
	
	@Test(priority=2)
	public void testDashboard() throws InterruptedException{
		Dashboard dashboard=new Dashboard(driver);
		dashboard.clickAttendanceButton()
		  		 .clickMyAttendanceSheetButton();
	}
	
	@Test(priority=3)
	public void testAttendanceSheet() throws InterruptedException{
		AttendanceSheetPage as=new AttendanceSheetPage(driver);
		as.clickDateButton()
		  .deletePunchInandPunchoutOperations()
	  	  .clicktotalTimeBeforeAnyOperation()
		  .clickPunchInButton();
	}
	
	@Test(priority=4)
	public void testPunchInOut() throws InterruptedException{
		PunchInOutPage punch=new PunchInOutPage(driver);
		punch.selectPunchInDate("Thu, 10 Mar 2022")
			 .clickTimeButton("09:15")
			 .clickInButton()
			 .clickPunchOutButton()
			 .selectPunchInDate("Thu, 10 Mar 2022")
			 .clickTimeButton("09:00")
			 .clickOutButtonError()
			 .verifyInvalidPunchOut()
			 .clickTimeButton("11:15")
			 .clickOutButton();
	}
	
	@Test(priority=5)
	public void testTotalTime() throws InterruptedException{
		AttendanceSheetPage time=new AttendanceSheetPage(driver);
	    time.clicktotalTimeAfterAnyOperation()
			.verifyTotalHours()
			.clickDeleteButton("10 Mar")
			.clickDeleteMessage();
	}
}
