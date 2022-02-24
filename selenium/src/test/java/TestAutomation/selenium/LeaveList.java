package TestAutomation.selenium;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LeaveList {
	private final WebDriver driver;
	public LeaveList(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(xpath = "//input[contains(@id,'from')]")
	private WebElement selectFromDate;
	
	@FindBy(xpath = "//label[contains(.,'All')]")
	private WebElement showLeavewithStatus;
	
	@FindBy(xpath = "//*[@id=\"subunit_inputfileddiv\"]/div/input")
	private WebElement SubunitDropdown;
	
	@FindBy(xpath = "//span[contains(.,'Architecture Team')]")
	private WebElement Architecture;
	
	@FindBy(xpath = "//button[contains(.,'Search')]")
	private WebElement searchButton;
	
	@FindBy(xpath = "//div[@class='toast-message'][contains(.,'No Records Found')]")
	private WebElement toastMessage;
	
	@FindBy(id = "menu_leave_viewLeaveList")
	private WebElement LeaveListButton;
	
	public LeaveList enterFromDate(String fromdate)
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.selectFromDate.click();
		this.selectFromDate.clear();
		this.selectFromDate.sendKeys(fromdate);
		return this;
	}
	
	public LeaveList selectSubUnit()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.SubunitDropdown.click();
		return this;
	}
	
	public LeaveList selectArchitecture()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.Architecture.click();
		return this;
	}
	
	public LeaveList selectCheckBoxAll()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.showLeavewithStatus.click();
		return this;
	}
	
	public LeaveList searchClick()
	{
		this.searchButton.click();
		return this;
	}
	
	public LeaveList verifyRecordsNotFound()
	{
		Boolean result=this.toastMessage.isDisplayed();
		assertTrue(result);
		return this;
	}
	
	public LeaveList clickLeaveListButton()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.LeaveListButton.click();
		return this;
	}
}
