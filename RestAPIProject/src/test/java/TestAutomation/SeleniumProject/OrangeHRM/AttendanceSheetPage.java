package TestAutomation.SeleniumProject.OrangeHRM;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AttendanceSheetPage {
	public static String totaltimebeforepunchin;
	public static String totaltimebeafterpunchin;
	static int totaltimebeforepunchinminutes;
	static int totaltimeafterpunchinminutes;
	private final WebDriver driver;
	public AttendanceSheetPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(xpath="//li[@id='date_2022-03-10']/div")
	private WebElement dateButton;
	
	public AttendanceSheetPage clickDateButton() throws InterruptedException {
		Thread.sleep(5000);
		this.dateButton.click();
		return this;
	}
	
	@FindBy(xpath="//button[@data-icon='delete_forever']")
	private WebElement acceptingdelete;
	
	List<WebElement> deletedetails;
	
	public AttendanceSheetPage deletePunchInandPunchoutOperations() throws InterruptedException {
		Thread.sleep(5000);
		this.deletedetails=driver.findElements(By.xpath("//div[@class='timesheetDate'][(text()='10 Mar')]//parent::span//parent::div//parent::li//div[@aria-label='Delete']"));
		for(WebElement deleteoption:deletedetails) {
			deleteoption.click();
			Thread.sleep(5000);
			acceptingdelete.click();
		}
		return this;
	}
	
	@FindBy(xpath="//div[contains(@class,'pay-hours-duration pay-hours-duration-0')]")
	private WebElement totalTime;
	
	public AttendanceSheetPage clicktotalTimeBeforeAnyOperation() throws InterruptedException {
		Thread.sleep(3000);
		totalTime.click();
		totaltimebeforepunchin=totalTime.getText();
		System.out.println("Total time before punchin "+totaltimebeforepunchin);
		totaltimebeforepunchinminutes=PayHours.converttominutes2(totaltimebeforepunchin);
		System.out.println("Total time before conversion into minutes "+totaltimebeforepunchinminutes);
		return this;
	}
	
	@FindBy(xpath="//span[@class='punch-in-icon material-icons']")
	private WebElement punchInButton;
	
	public PunchInOutPage clickPunchInButton() throws InterruptedException {
		Thread.sleep(5000);
		this.punchInButton.click();
		return new PunchInOutPage(driver);
	}
	
	@FindBy(xpath="//span[contains(@class,'punch-out-icon material-icons')]")
	private WebElement punchOutButton;
	
	public PunchInOutPage clickPunchOutButton() throws InterruptedException {
		Thread.sleep(7000);
		this.punchOutButton.click();
		return new PunchInOutPage(driver);
	}
	
	public AttendanceSheetPage clicktotalTimeAfterAnyOperation() throws InterruptedException {
		Thread.sleep(3000);
		totalTime.click();
		totaltimebeafterpunchin=totalTime.getText();
		System.out.println("Total time afetr punchout "+totaltimebeafterpunchin);
		totaltimeafterpunchinminutes=PayHours.converttominutes2(totaltimebeafterpunchin);
		System.out.println("Total time after conversion into minutes "+totaltimeafterpunchinminutes);
		return this;
	}
	
	public AttendanceSheetPage verifyTotalHours() {
		totaltimebeforepunchinminutes=totaltimebeforepunchinminutes+120;
		assertEquals(totaltimebeforepunchinminutes,totaltimeafterpunchinminutes);
		return this;
	}

	private WebElement deleteButton;
	
	public AttendanceSheetPage clickDeleteButton(String date) throws InterruptedException {
		Thread.sleep(5000);
		deleteButton=driver.findElement(By.xpath("//div[@class='timesheetDate'][(text()=\""+date+"\")]//parent::span//parent::div//parent::li//div[@aria-label='Delete']"));
		this.deleteButton.click();
		return this;
	}
	
	@FindBy(xpath="//button[@data-icon='delete_forever']")
	private WebElement deleteMessage;
	
	public AttendanceSheetPage clickDeleteMessage() throws InterruptedException {
		Thread.sleep(5000);
		this.deleteMessage.click();
		return this;
	}
}
