package TestAutomation.BDD.feature;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src\\test\\resources\\features\\LoginFeature.feature",
		glue = {"TestAutomation.BDD.feature"}
		)

public class TestLoginPage extends AbstractTestNGCucumberTests{
	@Test(enabled=false)
	public void testDummy() {
		assertTrue(true);
	}
}
