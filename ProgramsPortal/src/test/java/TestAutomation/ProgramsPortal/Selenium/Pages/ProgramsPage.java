package TestAutomation.ProgramsPortal.Selenium.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ProgramsPage {
	private final WebDriver driver;
	
	public ProgramsPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(xpath = "//div[@class='uui-toggle-box']")
	private WebElement menuButton;
	
	public ProgramsPage clickMenuButton() throws InterruptedException
	{
		Thread.sleep(3000);
		this.menuButton.click();
		return this;
	}
	
	@FindBy(xpath = "//div[@id='mCSB_2_container']//span[contains(text(),'Master Data management')]")
	private WebElement masterDataManagementButton;
	
	public ProgramsPage clickMasterDataManagementButton() throws InterruptedException
	{
		Thread.sleep(3000);
		this.masterDataManagementButton.click();
		return this;
	}
	
	@FindBy(xpath = "//div[@id='mCSB_2_container']//span[contains(text(),'Speakers')]")
	private WebElement speakersButton;
	
	public SpeakersPage clickSpeakersButton() throws InterruptedException
	{
		Thread.sleep(3000);
		this.speakersButton.click();
		return new SpeakersPage(driver);
	}
}
