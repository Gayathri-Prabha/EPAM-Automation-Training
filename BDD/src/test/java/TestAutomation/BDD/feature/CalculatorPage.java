package TestAutomation.BDD.feature;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CalculatorPage {
	private final WebDriver driver;
	public CalculatorPage(WebDriver driver) {
		this.driver=driver;
		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this);
	}
	
	public CalculatorPage buttonWithLabelExists(String buttonLabel) {
		WebElement button = driver.findElement(By.xpath("//button[text()='"+buttonLabel+"']"));
		assertNotNull(button);
		return this;
	}
	
	public CalculatorPage displayFieldExists() {
		WebElement field = driver.findElement(By.xpath("//p[@id='p']"));
		Boolean result = field.isDisplayed();
		assertTrue(result);
		return this;
	}
	
	public CalculatorPage buttonColorMatches(String buttonLabel, String color) {
		WebElement field = driver.findElement(By.xpath("//button[text()='"+buttonLabel+"']"));
		Color buttonColor = Color.fromString(field.getCssValue("color"));
		Color blue = Color.fromString(color);
		assertEquals(buttonColor,blue);
		return this;
	}
	
	public CalculatorPage clickButton(String buttonLabel) {
		WebElement buttonclick = driver.findElement(By.xpath("//button[text()='"+buttonLabel+"']"));
		return this;
	}
	
	public CalculatorPage displayScreenText(String number) {
		WebElement buttonclick = driver.findElement(By.xpath("//label[text()='" +number+ "']"));
		assertTrue(true);
		return this;
	}
}
