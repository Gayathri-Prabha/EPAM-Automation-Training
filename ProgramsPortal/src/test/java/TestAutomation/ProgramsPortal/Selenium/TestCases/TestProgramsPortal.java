package TestAutomation.ProgramsPortal.Selenium.TestCases;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import TestAutomation.ProgramsPortal.Selenium.DriverFactory.WebDriverFactory;
import TestAutomation.ProgramsPortal.Selenium.Pages.ProgramsPage;
import TestAutomation.ProgramsPortal.Selenium.Pages.SignInPage;
import TestAutomation.ProgramsPortal.Selenium.Pages.SignUpPage;
import TestAutomation.ProgramsPortal.Selenium.Pages.SpeakersPage;

public class TestProgramsPortal {
	private WebDriver driver;
	private String browserName;
	private String programsPortalURL;
	private String programsPortalEmailAddress;
	private String programsPortalPassword;
	private String speakersName;
	private String speakerProfile;
	@BeforeClass
	public void setUp(ITestContext context) throws MalformedURLException{
		browserName = context.getCurrentXmlTest().getParameter("BrowserName");
		programsPortalURL = context.getCurrentXmlTest().getParameter("ProgramsPortalBaseURL");
		this.programsPortalEmailAddress = context.getCurrentXmlTest().getParameter("ProgramsPortalEmailAddress");
		this.programsPortalPassword = context.getCurrentXmlTest().getParameter("ProgramsPortalPassword");
		this.speakersName = context.getCurrentXmlTest().getParameter("SpeakersName");
		this.speakerProfile = context.getCurrentXmlTest().getParameter("SpeakersProfile");
	}
	
	@Test(priority = 1)
	public void testCookies() {
		driver = WebDriverFactory.getWebDriver(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(programsPortalURL);
		driver.manage().deleteAllCookies();
	}
	
	@Test(priority = 2)
	public void testSignInPage() throws InterruptedException {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.clicksignUpButton();
	}
	
	@Test(priority = 3)
	public void testSignUpPage() throws InterruptedException {
		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.enterEmailAddress(this.programsPortalEmailAddress)
				  .enterPassword(this.programsPortalPassword)
				  .clickSignUpButton();
	}
	
	@Test(priority = 4)
	public void testSignInPageAfterSignUp() throws InterruptedException {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.enterEmailAddress(this.programsPortalEmailAddress)
		          .enterPassword(this.programsPortalPassword)
		          .clickSubmitButton();
	}
	
	@Test(priority = 5)
	public void testProgramsPage() throws InterruptedException {
		ProgramsPage programsPage = new ProgramsPage(driver);
		programsPage.clickMenuButton()
		            .clickMasterDataManagementButton()
		            .clickSpeakersButton();
	}
	
	@Test(priority = 6)
	public void testSpeakersPage() throws InterruptedException {
		SpeakersPage speakersPage = new SpeakersPage(driver);
		speakersPage.clickAddSpeakerButton()
				    .enterSpeakerName(this.speakersName)
				    .enterSpeakerEmail(this.programsPortalEmailAddress)
				    .enterSpeakerProfile(this.speakerProfile)
				    .clickSaveButton();
	}
	
	@AfterMethod
	public void testScreenshot(ITestResult result){
		if(ITestResult.FAILURE==result.getStatus()){
			try{
				TakesScreenshot screenshot=(TakesScreenshot)driver;
				File src=screenshot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("./FailedTestCasesScreenshots/"+result.getName()+".png"));
				System.out.println("Screenshot is captured successfully");
			}
			catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
