package TestAutomation.SeleniumProject.OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {
	private final WebDriver driver;
	@FindBy(id = "txtUsername")
	private WebElement userName;
	
	@FindBy(id = "txtPassword")
	private WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	private WebElement loginButton;
	
	@FindBy(className = "form-body")
	private WebElement form;
	
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
}
