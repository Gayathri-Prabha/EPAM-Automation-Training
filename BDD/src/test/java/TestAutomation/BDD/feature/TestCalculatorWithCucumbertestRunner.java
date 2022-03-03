package TestAutomation.BDD.feature;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import driverFactory.WebDriverFactoryProvider;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(
		features = "src\\test\\resources\\features\\Calculator.feature",
		glue = {"TestAutomation.BDD.feature"},
		dryRun=true
		)

public class TestCalculatorWithCucumbertestRunner {
	private TestNGCucumberRunner runner;
	private String platformName;
	private String browserName;
	protected static WebDriver driver;
	@BeforeClass
	public void setUp(ITestContext context) throws MalformedURLException {
		runner = new TestNGCucumberRunner(this.getClass());
		String browserName = context.getCurrentXmlTest().getParameter("BrowserName");
	    platformName = context.getCurrentXmlTest().getParameter("OrangeHRMTestExecutionPlatform");
	    driver = WebDriverFactoryProvider.getWebDriverFactory(platformName).getWebDriver(browserName);
		driver.manage().window().maximize();
	}
	
	@Test(groups="cucumber",dataProvider="scenarios")
	public void testCucumberScenario(PickleWrapper pickle, FeatureWrapper feature) {
		runner.runScenario(pickle.getPickle());
	}
	
	@DataProvider
	public Object[][] scenarios(){
		return runner.provideScenarios();
	}
	
	@AfterClass
	public void tearDown() {
		runner.finish();
	}
}
