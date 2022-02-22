package TestAutomation.selenium.orangeHRMPOM.pages;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPageJSExecutor {
		private final WebDriver driver;
		@FindBy(id = "txtUsername")
		private WebElement userName;
		
		@FindBy(id = "txtPassword")
		private WebElement password;
		
		@FindBy(xpath="//button[contains(text(),'Login')]")
		private WebElement loginButton;
		
		@FindBy(className = "form-body")
		private WebElement form;

		public LoginPageJSExecutor(WebDriver driver) {
			this.driver = driver;
			AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
			PageFactory.initElements(factory, this);
		}

		public LoginPageJSExecutor enterUserName(String userName)
		{
			//this.userName.sendKeys(userName);
			String script="document.getElementById('txtUsername').value= "+userName;
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript(script);
			//String scriptForElement="document.getElementById('txtUsername')";
			//WebElement userNameElement=(WebElement)js.executeScript(scriptForElement);
			//userNameElement.click();
			return this;
		}

		public LoginPageJSExecutor enterPassword(String password)
		{
			String script="document.getElementById('txtPassword').value= "+password;
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript(script);
			//this.password.sendKeys(password);
			return this;
		}

		public LoginPageJSExecutor clickLoginButton() throws InterruptedException
		{
			String script="document.querySelector('button[type=submit]').click()";
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript(script);
			//this.loginButton.click();
			//this.form.submit();
			return this;
		}	
}
