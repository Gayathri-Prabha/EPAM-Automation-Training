package TestAutomation.SeleniumSAUCE;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	private final WebDriver driver;
	@FindBy(id = "txtUsername")
	private WebElement userName;
	
	@FindBy(id = "txtPassword")
	private WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	private WebElement loginButton;

	@FindBy(className = "input-field")
	private List<WebElement> inputFields;

	@FindBys({@FindBy(className = "input-field"), @FindBy(tagName = "td")})
	private List<WebElement> inputFieldsBYS;

	@FindAll({@FindBy(className = "input-field"), @FindBy(tagName = "td")})
	private List<WebElement> inputFieldsBYALL;

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

	public LoginPage clickLoginButton() throws InterruptedException
	{
		//this.loginButton.click();
		this.form.submit();
		return this;
	}

	public LoginPage printElementInputFields()
	{
		System.out.println("Number of element : " + inputFields.size());
		for (Iterator iterator = inputFields.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			System.out.println("Element : " + webElement.getTagName());
		}
		System.out.println("Number of element : " + inputFieldsBYS.size());
		for (Iterator iterator = inputFieldsBYS.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			System.out.println("Element : " + webElement.getTagName());
		}
		System.out.println("Number of element : " + inputFieldsBYALL.size());
		for (Iterator iterator = inputFieldsBYALL.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			System.out.println("Element : " + webElement.getTagName());
		}
		return this;
	}

	public LoginPage login(String userName, String password) throws InterruptedException
	{
		this.enterUserName(userName)
			.enterPassword(password)
			.clickLoginButton();
		return this;
	}
	
	@FindBy(xpath="//label[@for='30_Yes']")
	private WebElement radioButton;
	
	@FindBy(xpath="//label[@for='26Dairy-Free']")
	private WebElement checkBox1;
	
	@FindBy(xpath="//label[@for='26Gluten-Free']")
	private WebElement checkBox2;
	
	public LoginPage clickRadioButton()
	{
		this.radioButton.click();
		return this;
	}
	
	public LoginPage clickCheckBox1()
	{
		this.checkBox1.click();
		return this;
	}
	
	public LoginPage clickCheckBox2()
	{
		this.checkBox2.click();
		return this;
	}
}
