package TestAutomation.selenium.orangeHRMPOM.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPageActionClass {
	private final WebDriver driver;
	@FindBy(id = "txtUsername")
	private WebElement userName;
	
	@FindBy(id = "txtPassword")
	private WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	private WebElement loginButton;

	@FindBy(className = "form-body")
	private WebElement form;

	public LoginPageActionClass(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}
	
	public LoginPageActionClass enterUserName(String userName)
	{
		this.userName.sendKeys(userName);
		return this;
	}

	public LoginPageActionClass enterPassword(String password)
	{
		this.password.sendKeys(password);
		return this;
	}

	public LoginPageActionClass clickLoginButton() throws InterruptedException
	{
		//this.loginButton.click();
		//this.form.submit();
		Actions actions=new Actions(driver);
		actions.moveToElement(this.loginButton).click().perform();
		return this;
	}
}
