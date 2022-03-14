package TestAutomation.ProgramsPortal.Selenium.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SignInPage {
	private final WebDriver driver;
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Sign up')]")
	private WebElement signUpButton;
	
	public SignUpPage clicksignUpButton() throws InterruptedException
	{
		Thread.sleep(3000);
		this.signUpButton.click();
		return new SignUpPage(driver);
	}
	
	@FindBy(xpath = "//input[@placeholder='Email address']")
	private WebElement emailAddress;
	
	public SignInPage enterEmailAddress(String emailAddress) throws InterruptedException
	{
		Thread.sleep(3000);
		this.emailAddress.sendKeys(emailAddress);
		return this;
	}
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;
	
	public SignInPage enterPassword(String password) throws InterruptedException
	{
		Thread.sleep(3000);
		this.password.sendKeys(password);
		return this;
	}
	
	@FindBy(xpath = "//button[contains(text(),'SUBMIT')]")
	private WebElement submitButton;
	
	public ProgramsPage clickSubmitButton() throws InterruptedException
	{
		Thread.sleep(3000);
		this.submitButton.click();
		return new ProgramsPage(driver);
	}
}
