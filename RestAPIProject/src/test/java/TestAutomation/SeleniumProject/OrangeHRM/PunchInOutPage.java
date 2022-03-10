package TestAutomation.SeleniumProject.OrangeHRM;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PunchInOutPage {
	private final WebDriver driver;
	public PunchInOutPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(xpath="//input[@name='dateTextInput']")
	private WebElement punchInDate;
	
	public PunchInOutPage selectPunchInDate(String date) throws InterruptedException {
		Thread.sleep(5000);
		this.punchInDate.click();
		this.punchInDate.clear();
		this.punchInDate.sendKeys(date);
		return this;
	}
	
	@FindBy(xpath="//input[@id='time']")
	private WebElement timeButton;
	
	public PunchInOutPage clickTimeButton(String time) throws InterruptedException {
		Thread.sleep(5000);
		this.timeButton.click();
		this.timeButton.clear();
		this.timeButton.sendKeys(time);
		return this;
	}
	
	@FindBy(xpath="//div[@id='allowedActionButtonsDiv']/button[@type='button']")
	private WebElement InButton;
	
	public AttendanceSheetPage clickInButton() throws InterruptedException {
		this.InButton.click();
		return new AttendanceSheetPage(driver);
	}
	
	@FindBy(xpath="//span[contains(text(),'Punch out time should be later than punch in time')]")
	private WebElement invalidPunchOut;
	
	public PunchInOutPage verifyInvalidPunchOut() throws InterruptedException {
		String later=invalidPunchOut.getText();
		System.out.println(later);
		assertEquals(later,"Punch out time should be later than punch in time");
		return this;
	}
	
	@FindBy(xpath="//div[@id='allowedActionButtonsDiv']/button[@type='button']")
	private WebElement OutButtonError;
	
	public PunchInOutPage clickOutButtonError() throws InterruptedException {
		this.OutButtonError.click();
		return this;
	}
	
	@FindBy(xpath="//div[@id='allowedActionButtonsDiv']/button[@type='button']")
	private WebElement OutButton;
	
	public AttendanceSheetPage clickOutButton() throws InterruptedException {
		this.OutButton.click();
		return new AttendanceSheetPage(driver);
	}
}
