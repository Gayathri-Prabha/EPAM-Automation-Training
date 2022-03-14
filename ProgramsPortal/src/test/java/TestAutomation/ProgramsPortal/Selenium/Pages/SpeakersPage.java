package TestAutomation.ProgramsPortal.Selenium.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SpeakersPage {
	private final WebDriver driver;
	
	public SpeakersPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(xpath = "//button[contains(text(),'Add Speaker')]")
	private WebElement addSpeakerButton;
	
	public SpeakersPage clickAddSpeakerButton() throws InterruptedException
	{
		Thread.sleep(3000);
		this.addSpeakerButton.click();
		return this;
	}
	
	@FindBy(xpath = "//input[@name='speakerName']")
	private WebElement speakerName;
	
	public SpeakersPage enterSpeakerName(String speakerName) throws InterruptedException
	{
		Thread.sleep(3000);
		this.speakerName.sendKeys(speakerName);
		return this;
	}
	
	@FindBy(xpath = "//input[@name='speakerEmail']")
	private WebElement speakerEmail;
	
	public SpeakersPage enterSpeakerEmail(String speakerEmail) throws InterruptedException
	{
		Thread.sleep(3000);
		this.speakerEmail.sendKeys(speakerEmail);
		return this;
	}
	
	@FindBy(xpath = "//input[@name='speakerProfile']")
	private WebElement speakerProfile;
	
	public SpeakersPage enterSpeakerProfile(String speakerProfile) throws InterruptedException
	{
		Thread.sleep(3000);
		this.speakerProfile.sendKeys(speakerProfile);
		return this;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement saveButton;
	
	public SpeakersPage clickSaveButton() throws InterruptedException
	{
		Thread.sleep(3000);
		this.saveButton.click();
		return this;
	}
	
	public SpeakersPage verifyAlertMessage() {
		Alert alert = driver.switchTo().alert();
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		alert.dismiss();
		return this;
	}
}
