package TestAutomation.SeleniumProject.OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Dashboard {
	private final WebDriver driver;
	public Dashboard(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Attendance')]")
	private WebElement attendanceButton;
	
	public Dashboard clickAttendanceButton() throws InterruptedException {
		this.attendanceButton.click();
		return this;
	}
	
	@FindBy(xpath="//span[contains(text(),'My Attendance Sheet')]")
	private WebElement myAttendanceSheetButton;
	
	public AttendanceSheetPage clickMyAttendanceSheetButton() {
		this.myAttendanceSheetButton.click();
		return new AttendanceSheetPage(driver);
	}
}
