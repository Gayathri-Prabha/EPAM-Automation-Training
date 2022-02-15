package TestAutomation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class OrangehrmExample {
	@Test
	public void LoadWebDriver() {
		String driverPath="C:\\browserDriver\\geckodriver-v0.30.0-win64\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.orangehrm.com/");
		driver.findElement(By.id("myText")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("linkadd")).click();
		driver.findElement(By.id("Form_submitForm_subdomain")).sendKeys("https:demo.com");
		driver.findElement(By.id("Form_submitForm_Name")).sendKeys("xyz");
		driver.findElement(By.id("Form_submitForm_Contact")).sendKeys("6392456178");
		WebElement country=driver.findElement(By.id("Form_submitForm_Country"));
		Select dropDown=new Select(country);
		dropDown.selectByVisibleText("India");
		WebElement state=driver.findElement(By.id("Form_submitForm_State"));
		Select drop=new Select(state);
		drop.selectByVisibleText("Telangana");
		//driver.findElement(By.id("Form_submitForm_action_request")).click();
	}
}
