package TestAutomation.selenium;

import static org.testng.Assert.assertEquals;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class OrangehrmAssignment {
	@Test
	public void method() throws InterruptedException
	{
		String driverPath = "C:\\browserDriver\\geckodriver-v0.30.0-win64\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@class='password-input']")).sendKeys("U@qBLVtm09");
		driver.findElement(By.xpath("//img[@class=\"icon login-icon\"]")).click();
		driver.findElement(By.partialLinkText("Admin")).click();
		driver.findElement(By.partialLinkText("User Management")).click();
		driver.findElement(By.partialLinkText("Users")).click();
		Thread.sleep(31000);
		
		driver.findElement(By.xpath("//td/ng-include[span='amanda']/parent::td/parent::tr//i['ohrm_edit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"modal-holder\"]/div/div/div/div[2]/form/oxd-decorator[3]/div/div[1]/div/div[2]/div/button")).click();
		driver.findElement(By.id("bs-select-3-2")).click();
		driver.findElement(By.id("modal-save-button")).click();
		Thread.sleep(5000);
		String s=driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/crud-panel/div/div/list/table/tbody/tr[6]/td[3]/ng-include/span")).getText();
		String arr[]=s.split(",");
		assertEquals(arr[2]," Global Admin");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//td/ng-include[span='amanda']/parent::td/parent::tr//i['ohrm_edit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"modal-holder\"]/div/div/div/div[2]/form/oxd-decorator[3]/div/div[1]/div/div[2]/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"bs-select-6-0\"]")).click();
		driver.findElement(By.id("modal-save-button")).click();
		Thread.sleep(5000);
		String s1=driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/crud-panel/div/div/list/table/tbody/tr[6]/td[3]/ng-include/span")).getText();
		String arr1[]=s1.split(",");
		assertEquals(arr1.length,2);
		driver.findElement(By.xpath("//a/span/i[\"keyboard_arrow_down\"]")).click();
		driver.findElement(By.id("logoutLink")).click();
	}
}
