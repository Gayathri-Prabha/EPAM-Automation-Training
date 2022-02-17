package TestAutomation.selenium;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ApplyLeaveAssignment {
	WebDriver driver;
	@Test
	public void LoadWebDriver() throws InterruptedException {
		String driverPath="C:\\browserDriver\\geckodriver-v0.30.0-win64\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver=new FirefoxDriver();
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("U@qBLVtm09");
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div/form/div[3]/button")).click();
		
		driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
		driver.findElement(By.id("menu_leave_applyLeave")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(25));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"leaveType_inputfileddiv\"]/div/input"))).click();
		driver.findElement(By.xpath("//li/span[contains(text(),'Sick Leave - US')]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"applyLeaveForm\"]/div[1]/materializecss-decorator[2]/div/sf-decorator[1]/div/span[1]/span/i")).click();
		Thread.sleep(30000);
		driver.findElement(By.xpath("//*[@id=\"P1626460654_root\"]/div/div/div/div/div[2]/div/div[2]/input")).click();
		driver.findElement(By.xpath("//li/span[contains(text(),'2022')]")).click();
		driver.findElement(By.xpath("//*[@id=\"P2134961784_root\"]/div/div/div/div/div[2]/div/div[1]/span")).click();
		driver.findElement(By.xpath("//li/span[contains(text(),'February')]")).click();
		driver.findElement(By.xpath("//tr/td/div[contains(text(),'18')]')]")).click();
	}
}
