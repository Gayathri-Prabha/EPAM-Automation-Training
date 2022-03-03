package TestAutomation.BDD.feature;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src\\test\\resources\\features\\Calculator.feature",
		glue = {"TestAutomation.BDD.feature"}
//		tags="@DataTable"
		)

public class TestCalculatorPage extends AbstractTestNGCucumberTests {
	
}
