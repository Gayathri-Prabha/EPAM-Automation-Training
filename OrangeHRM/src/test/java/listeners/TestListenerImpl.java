package listeners;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListenerImpl implements ITestListener {
	@Override
	public void onTestFailure(ITestResult result) {	
		System.out.println("ON TEST FAILURE");
		ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver)context.getAttribute("WebDriver");	
		System.out.println("Driver -> " + driver);
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File screenShotFile = screenShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShotFile, new File("./loginPage2.jpg"));
		} catch (IOException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
