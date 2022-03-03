package TestAutomation.selenium.orangeHRMPOM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Dashboard {
	private final WebDriver driver;
	public Dashboard(WebDriver driver) {
		this.driver=driver;
		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this);
	}
	public LeaveList navigateToLeaveList() {
		driver.navigate().to("https://prasoonr-trials73.orangehrmlive.com/client/#/leave/view_leave_list");
		return new LeaveList(driver);
	}
}
