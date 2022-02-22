package TestAutomation.selenium.alert;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import TestAutomation.selenium.WebDriverFactory;

public class alert {
	WebDriver driver;
	@BeforeTest
	@Parameters("BrowserName")
	public void setup(String BrowserName) {
		driver = WebDriverFactory.getWebDriver(BrowserName);
	}

//	@Test
	public void testLogin() throws InterruptedException {
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("1234");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		alert.accept();
	}

//	@Test
	public void testWindow() throws InterruptedException {
		driver.get("https://demo.guru99.com/popup.php");
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		String parent = driver.getWindowHandle();
		System.out.println("Parent window is " + parent);
		Set<String> s = driver.getWindowHandles();
		for (String ele : s) {
			System.out.println("Child windows are " + ele);
		}
		Iterator<String> I = s.iterator();
		while (I.hasNext()) {
			String child = I.next();
			if (!parent.equals(child)) {
				driver.switchTo().window(child);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("1234");
			}
		}
	}

	@Test
	public void testDragandDrop() {
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();
		Actions draganddrop = new Actions(driver);
		WebElement from = driver.findElement(By.xpath("//a[contains(text(),'BANK')]"));
		WebElement to = driver.findElement(By.xpath("//ol[@id='bank']/li"));
		draganddrop.dragAndDrop(from, to).perform();
	}
}
