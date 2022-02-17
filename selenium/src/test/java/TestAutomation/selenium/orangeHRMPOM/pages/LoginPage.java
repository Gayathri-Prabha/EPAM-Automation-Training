package TestAutomation.selenium.orangeHRMPOM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private final WebDriver driver;
	
	@FindBy(id="txtUsername")
	private WebElement userName;
	
	@FindBy(id="txtPassword")
	private WebElement password;
	
	@FindBy(xpath="//*[@id=\"divLogin\"]/div[2]/div/form/div[3]/button")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage enterUserName(String userName) {
		this.userName.sendKeys(userName);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		this.password.sendKeys(password);
		return this;
	}
	
	public LoginPage clickLoginButton() {
		this.loginButton.click();
		return this;
	}
	
	public LoginPage login(String userName, String password) {
		this.enterUserName(userName)
			.enterPassword(password)
			.clickLoginButton();
		return this;
	}
}
