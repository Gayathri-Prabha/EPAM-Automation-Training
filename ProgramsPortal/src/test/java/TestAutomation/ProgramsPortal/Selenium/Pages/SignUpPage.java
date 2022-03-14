package TestAutomation.ProgramsPortal.Selenium.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SignUpPage {
	private final WebDriver driver;
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(xpath = "//input[@placeholder='Email address']")
	private WebElement emailAddress;
	
	public SignUpPage enterEmailAddress(String emailAddress) throws InterruptedException
	{
		Thread.sleep(3000);
		this.emailAddress.sendKeys(emailAddress);
		return this;
	}
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;
	
	public SignUpPage enterPassword(String password) throws InterruptedException
	{
		Thread.sleep(3000);
		this.password.sendKeys(password);
		return this;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	private WebElement signUpButton;
	
	public SignInPage clickSignUpButton() throws InterruptedException
	{
		Thread.sleep(3000);
		this.signUpButton.click();
		return new SignInPage(driver);
	}
}
