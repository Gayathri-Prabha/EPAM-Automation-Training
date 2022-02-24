package TestAutomation.selenium.listeners;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import TestAutomation.selenium.WebDriverFactory;

@Listeners(ReporterListenerImpl.class)

public class TestReporterListener {
	WebDriver driver;
	@BeforeClass
	public void setup(ITestContext context) {
		driver = WebDriverFactory.getWebDriver("Firefox");
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.manage().window().maximize();
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
}
