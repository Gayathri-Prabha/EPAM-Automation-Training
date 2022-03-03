package TestAutomation.selenium;

import static org.testng.Assert.assertEquals;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestExplicit {
	WebDriver driver;
	@BeforeClass
	@Parameters("browserName")
	public void setup(String browserName) {
	driver = WebDriverFactory.getWebDriver(browserName);
	}
	
	@Test
	public void method() throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@class='password-input']")).sendKeys("U@qBLVtm09");
		driver.findElement(By.xpath("//img[@class=\"icon login-icon\"]")).click();
		driver.findElement(By.partialLinkText("Admin")).click();
		driver.findElement(By.id("menu_admin_UserManagement")).click();
		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td/ng-include[span='amanda']/parent::td/parent::tr//i['ohrm_edit']"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"modal-holder\"]/div/div/div/div[2]/form/oxd-decorator[3]/div/div[1]/div/div[2]/div/button")).click();
		driver.findElement(By.id("bs-select-3-2")).click();
		driver.findElement(By.id("modal-save-button")).click();
		Thread.sleep(5000);
		String s=driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/crud-panel/div/div/list/table/tbody/tr[6]/td[3]/ng-include/span")).getText();
		String arr[]=s.split(",");
		assertEquals(arr[2]," Global Admin");
		Thread.sleep(5000);
		
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td/ng-include[span='amanda']/parent::td/parent::tr//i['ohrm_edit']"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"modal-holder\"]/div/div/div/div[2]/form/oxd-decorator[3]/div/div[1]/div/div[2]/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"bs-select-6-0\"]")).click();
		driver.findElement(By.id("modal-save-button")).click();
		Thread.sleep(5000);
		String s1=driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/crud-panel/div/div/list/table/tbody/tr[6]/td[3]/ng-include/span")).getText();
		String arr1[]=s1.split(",");
		assertEquals(arr1.length,2);
		driver.findElement(By.id("user-dropdown")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("logoutLink")).click();
	}
}
