package pages;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class UsersPage {
	private final WebDriver driver;
	@FindBy(linkText="Admin")
	private WebElement adminButton;
	
	@FindBy(xpath="//span[contains(text(),'User Management')]")
	private WebElement userManagementButton;
	
	@FindBy(xpath="//span[contains(text(),'Users')]")
	private WebElement usersButton;
	
	@FindBy(xpath = "//td/ng-include[span='amanda']/parent::td/parent::tr//i['ohrm_edit']")
	private WebElement editButton;
	
	@FindBy(xpath = "(//i[contains(.,'arrow_drop_down')])[3]")
	private WebElement adminRoleDropdown;
	
	@FindBy(xpath = "//span[@class='text'][contains(text(),'Global Admin')]")
	private WebElement globalAdmin;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement saveButton;
	
	@FindBy(xpath="(//a[contains(.,'-- Select --')])[3]")
	private WebElement select;
	
	@FindBy(xpath="(//span[contains(text(),'Default ESS, Default Supervisor')])[6]")
	private WebElement verify;
	 
	@FindBy(xpath="//a[@id='logoutLink']")
    private WebElement logout;

	@FindBy(xpath="//i[contains(text(), 'keyboard_arrow_down')]")
	private WebElement downArrow;
	
	public UsersPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}
	
	public UsersPage clickAdminButton() throws InterruptedException
	{
		this.adminButton.click();
		return this;
	}
	
	public UsersPage clickUserManagementButton() throws InterruptedException
	{
		this.userManagementButton.click();
		return this;
	}
	
	public UsersPage clickUsersButton() throws InterruptedException
	{
		this.usersButton.click();
		return this;
	}
	
	public UsersPage clickEditButton() throws InterruptedException
	{
		Thread.sleep(5000);
		this.editButton.click();
		return this;
	}
	
	public UsersPage clickAdminRoleDropdown() throws InterruptedException
	{
		Thread.sleep(5000);
		this.adminRoleDropdown.click();
		return this;
	}
	
	public UsersPage selectGlobalAdmin() throws InterruptedException
	{
		Thread.sleep(5000);
		this.globalAdmin.click();
		return this;
	}
	
	public UsersPage clickSaveButton() throws InterruptedException
	{
		Thread.sleep(5000);
		this.saveButton.click();
		return this;
	}
	
	public UsersPage verifyGlobalAdminAfterAdding() throws InterruptedException 
	{
	    Thread.sleep(3000);
	 	this.verify.click();
	 	String s=verify.getText();
		String arr[]=s.split(",");
		assertEquals(arr[2]," Global Admin");
		return this;
	}
	
	public UsersPage clickSelectOption() throws InterruptedException
	{
		Thread.sleep(5000);
		this.select.click();
		return this;
	}
	
	public UsersPage verifyGlobalAdminAfterDeleting() throws InterruptedException 
	{
	    Thread.sleep(3000);
	 	this.verify.click();
	 	String s=verify.getText();
		String arr[]=s.split(",");
		assertEquals(arr.length,2);
		return this;
	}
	
	public UsersPage clickDownArrow() throws InterruptedException{
		Thread.sleep(5000);
		this.downArrow.click();
		return this;
	}
	
	public UsersPage clickLogoutButton() throws InterruptedException{
		Thread.sleep(5000);
		this.logout.click();
		return this;
	}
}
