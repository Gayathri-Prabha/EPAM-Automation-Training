package pages;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	private final WebDriver driver;
	@FindBy(id = "txtUsername")
	private WebElement userName;
	
	@FindBy(id = "txtPassword")
	private WebElement password;
	
	private WebElement userNamewithFind;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	private WebElement loginButton;

	@FindBy(className = "form-body")
	private WebElement form;
	
	private Dashboard dashboard;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}

	public LoginPage enterUserName(String userName)
	{
		this.userName.sendKeys(userName);
		return this;
	}
	
	public LoginPage enterUserNamewithFindElement(String userName)
	{
		userNamewithFind = driver.findElement(By.id("txtUsername"));
		this.userNamewithFind.sendKeys(userName);
		return this;
	}

	public LoginPage enterPassword(String password)
	{
		this.password.sendKeys(password);
		return this;
	}

	public Dashboard clickLoginButton()
	{
		//this.loginButton.click();
		this.form.submit();
		return new Dashboard(driver);
	}

	public LoginPage login(String userName, String password) throws InterruptedException
	{
		this.enterUserName(userName)
			.enterPassword(password)
			.clickLoginButton();
		return this;
	}
	
	public Dashboard clickLoginButtonUsingJavascript() throws InterruptedException
	{
		//this.loginButton.click();
		JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
		jsDriver.executeScript("document.getElementById('txtUsername')");
		this.form.submit();
		return new Dashboard(driver);
	}
}
