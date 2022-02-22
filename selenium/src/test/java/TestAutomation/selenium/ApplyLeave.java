package TestAutomation.selenium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplyLeave {
	private final WebDriver driver;
	@FindBy(id="menu_leave_viewLeaveModule")
	private WebElement LeaveButton;
	
	@FindBy(id="menu_leave_applyLeave")
	private WebElement ApplyButton;
	
	@FindBy(xpath = "//input[@value='-- Select --']")
	private WebElement LeaveType;
	
	@FindBy(xpath = "//li/span[contains(text(),'Sick Leave - US')]")
	private WebElement SickLeave;
	
	@FindBy(xpath = "//input[contains(@id,'from')]")
	private WebElement FromDate;
	
	@FindBy(xpath = "//input[contains(@id,'to')]")
	private WebElement ToDate;
	
	@FindBy(xpath = "//span[contains(text(),'From date should be before to date')]")
	private WebElement ErrorMessage;
	
	@FindBy(xpath = "//textarea[contains(@id,'comment')]")
	private WebElement Comment;
	
	@FindBy(xpath = "//button[contains(text(),'Apply')]")
	private WebElement  Apply;
	
	@FindBy(xpath = "//a[contains(text(),'Available balance for this period is not sufficient')]")
	private WebElement InsufficientBalanceMessage;
	
	@FindBy(xpath = "//a[contains(text(),'Close')]")
	private WebElement InsufficientBalanceClose;
	
	@FindBy(xpath = "//a[contains(text(),'Check Leave Balance')]")
	private WebElement CheckBalance;
	
	@FindBy(xpath = "//span[contains(text(),'0.00')]")
	private WebElement AvailableBalance;
	
	@FindBy(xpath = "//a[contains(text(),'Close')]")
	private WebElement CheckBalanceClose;
	
	public ApplyLeave(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}
	
	public ApplyLeave clickLeaveButton() {
		this.LeaveButton.click();
		return this;
	}
	
	public ApplyLeave clickApplyButton() {
		this.ApplyButton.click();
		return this;
	}
	
	public ApplyLeave clickLeaveType() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.LeaveType.click();
		return this;
	}
	
	public ApplyLeave selectSickLeave() {
		this.SickLeave.click();
		return this;
	}
	
	public ApplyLeave selectFromDate(String fromDate) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.FromDate.click();
		this.FromDate.clear();
		this.FromDate.sendKeys(fromDate);
		return this;
	}
	
	public ApplyLeave selectToDate(String toDate) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.ToDate.click();
		this.ToDate.clear();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'to')]")));
		this.ToDate.sendKeys(toDate);
		return this;
	}
	
	public ApplyLeave errorMessageandColor()
	{
		this.FromDate.click();		
		Boolean result=this.ErrorMessage.isDisplayed();
		assertTrue(result);
		String message=this.ErrorMessage.getText();
		assertEquals(message,"From date should be before to date");
		String Color=this.ErrorMessage.getCssValue("color");
		assertEquals(Color,"rgb(244, 67, 54)");
		return this;
	}
	
	public ApplyLeave enterComments(String comment)
	{
		this.Comment.click();
		this.Comment.sendKeys(comment);
		return this;
	}
	
	public ApplyLeave submitLeave()
	{
		this.Apply.click();
		this.Apply.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return this;
	}
	
	public ApplyLeave verifyBalanceMessageandClose()
	{
		String message=this.InsufficientBalanceMessage.getText();
		assertEquals(message,"Available balance for this period is not sufficient");
		this.InsufficientBalanceClose.click();
		return this;
	}
	
	public ApplyLeave clickCheckBalance()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.CheckBalance.click();
		return this;
	}
    
	public ApplyLeave verifyAvailableBalanceandClose()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean result=this.AvailableBalance.isDisplayed();
		assertTrue(result);
		this.CheckBalanceClose.click();
		return this;
	}
}
