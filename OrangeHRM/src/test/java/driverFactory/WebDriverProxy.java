package driverFactory;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverProxy extends RemoteWebDriver{
	private WebDriver driver;

	public WebDriverProxy(WebDriver driver) {
		this.driver = driver;
	}
	
	@Override
	public void get(String url) {
		driver.get(url);	
	}

	@Override
	public String getCurrentUrl() {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

	@Override
	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return driver.findElements(by);
	}

	@Override
	public WebElement findElement(By by) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	//	return driver.findElement(by);
	}

	@Override
	public String getPageSource() {
		// TODO Auto-generated method stub
		return driver.getPageSource();
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		driver.close();
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		driver.quit();
	}

	@Override
	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return driver.getWindowHandles();
	}

	@Override
	public String getWindowHandle() {
		// TODO Auto-generated method stub
		return driver.getWindowHandle();
	}

	@Override
	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return driver.switchTo();
	}

	@Override
	public Navigation navigate() {
		// TODO Auto-generated method stub
		return driver.navigate();
	}

	@Override
	public Options manage() {
		// TODO Auto-generated method stub
		return driver.manage();
	}
	
	@Override
	public Object executeScript(String script, Object... args) {
		// TODO Auto-generated method stub
		return ((RemoteWebDriver)driver).executeScript(script, args);
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
		// TODO Auto-generated method stub
		return ((RemoteWebDriver)driver).getScreenshotAs(outputType);
	}
}
