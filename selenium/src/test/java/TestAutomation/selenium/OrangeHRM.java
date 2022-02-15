package TestAutomation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class OrangeHRM {
	@Test
	public void LoadWebDriver() {
		String driverPath="C:\\browserDriver\\geckodriver-v0.30.0-win64\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		WebDriver driver=new FirefoxDriver();
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("U@qBLVtm09");
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div/form/div[3]/button")).click();
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("menu_admin_UserManagement")).click();
		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/crud-panel/div/div/list/table/tbody/tr[6]/td[8]")).click();
		/*WebElement dropdown=driver.findElement(By.xpath("//*[@id=\"modal-holder\"]/div/div/div/div[2]/form/oxd-decorator[3]/div/div[1]/div/div[1]/button"));
		Select drop=new Select(dropdown);
		drop.selectByVisibleText("India");*/
	}
}
