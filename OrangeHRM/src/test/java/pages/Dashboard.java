package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Dashboard {
	private final WebDriver driver;
	
	@FindBy(id = "logoutLink")
	private WebElement logOutButton;
	
	@FindBy(xpath = "//i[contains(text(),'keyboard_arrow_down')]")
	private WebElement downArrow;
	
	public Dashboard(WebDriver driver) {
		this.driver=driver;
		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this);
	}
	
	public LoginPage logOut() {
		downArrow.click();
		logOutButton.click();
		return new LoginPage(driver);
	}
}
