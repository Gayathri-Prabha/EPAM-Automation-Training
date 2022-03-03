package TestAutomation.selenium.orangeHRMPOM.pages;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPageSS {
	private final WebDriver driver;
	@FindBy(id = "txtUsername")
	private WebElement userName;
	
	@FindBy(id = "txtPassword")
	private WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	private WebElement loginButton;
	
	@FindBy(className = "form-body")
	private WebElement form;

	public LoginPageSS(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}

	public LoginPageSS enterUserName(String userName)
	{
		this.userName.sendKeys(userName);
		return this;
	}

	public LoginPageSS enterPassword(String password)
	{
		this.password.sendKeys(password);
		return this;
	}

	public LoginPageSS clickLoginButton() throws InterruptedException
	{
		//this.loginButton.click();
		this.form.submit();
		return this;
	}
	
	public LoginPageSS testScreenShot() {
		String nameForTheCurrentWindow = driver.getWindowHandle();
		System.out.println("Name of the current Window : " + nameForTheCurrentWindow);
		Set<String> windowHandler = driver.getWindowHandles();
		for (Iterator iterator = windowHandler.iterator(); iterator.hasNext();) {
			String windowName = (String) iterator.next();
			System.out.println("window Name - > " + windowName);
		}
		// ScreenShot capturing in selenium
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File screenShotFile = screenShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShotFile, new File("./loginPage.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
}
