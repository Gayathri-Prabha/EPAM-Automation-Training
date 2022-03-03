package TestAutomation.BDD.feature;

import static org.testng.Assert.assertEquals;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import driverFactory.WebDriverFactoryProvider;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.UsersPage;

public class CalculatorImpl {
	private static WebDriver driver;
	private static String platformname;
	private static String browserName;
	private static String calculatorURL;
	private static CalculatorPage calculatorPage;
	@BeforeAll
	public static void setup() throws MalformedURLException {
		browserName = "Chrome";
		platformname = "LocalWebDriver";
		calculatorURL = "C:/Users/Gayathriprabha_Malla/TestAutomation/BDD/src/main/resources/Calculator.html";
		driver = WebDriverFactoryProvider.getWebDriverFactory(platformname).getWebDriver(browserName);
		driver.manage().window().maximize();
		driver.navigate().to(calculatorURL);
		calculatorPage = new CalculatorPage(driver);
	}
	
	@Given("Browser is open")
	public void browser_is_loaded() throws MalformedURLException {
		
	}
	
	@Given("Calculator page is open")
	public void calculator_page_is_open() {
		
	}

	@Then("Calculator has number {string}")
	public void calculator_has_number(String buttonLabel) {
		calculatorPage.buttonWithLabelExists(buttonLabel);
	}

	@Then("Calculator has operator {string}")
	public void calculator_has_operator(String buttonLabel) {
		calculatorPage.buttonWithLabelExists(buttonLabel);
	}

	@Then("Calculator has display field")
	public void calculator_has_display_field() {
		calculatorPage.displayFieldExists();
	}

	@Then("Calculator {string} has color {string}")
	public void calculator_has_color(String buttonLabel, String color) {
		calculatorPage.buttonColorMatches(buttonLabel, color);
	}

	@Given("number button is clicked {string}")
	public void number_button_is_clicked(String buttonLabel) {
		calculatorPage.clickButton(buttonLabel);
	}

	@Given("Operator button is clicked {string}")
	public void operator_button_is_clicked(String buttonLabel) {
		calculatorPage.clickButton(buttonLabel);
	}

	@Given("Number button is click {string}")
	public void number_button_is_click(String buttonLabel) {
		calculatorPage.clickButton(buttonLabel);
	}

	@Then("display screen should have number {string}")
	public void display_screen_should_have_number(String text) {
		calculatorPage.displayScreenText(text);
	}
	
	@Given("Following button are clicked")
	public void following_button_are_clicked(io.cucumber.datatable.DataTable dataTable) {
	    List<List<String>>values=dataTable.asLists(String.class);
	    for(Iterator iterator=values.iterator();iterator.hasNext();) {
	    	List<String>list=(List<String>)iterator.next();
	    	for(Iterator iterator1=list.iterator();iterator1.hasNext();) {
	    		String string=(String)iterator1.next();
	    		System.out.println("Values: "+string);
	    	}
	    }
	}

	@Then("Display field should have {int}")
	public void display_field_should_have(Integer int1) {
	    
	}
	
/*	@Given("Library has following book")
	public void library_has_following_book(io.cucumber.datatable.DataTable dataTable) {
		 List<Book> books=dataTable.asLists(Book.class);
		 List<List<String>>buttonColor=dataTable.asLists(String.class);
		 for(Iterator iterator=buttonColor.iterator();iterator.hasNext();) {
			 List<String>list=(List<String>)iterator.next();
			 for(Iterator iterator1=list.iterator();iterator1.hasNext();) {
		    		String string=(String)iterator1.next();
		    		System.out.println("--> "+list);
			 }
		 }
	}  */

	@When("you add a new book with name {string} and author name {string}")
	public void you_add_a_new_book_with_name_and_author_name(String string, String string2) {
	    
	}

	@Then("Final book list is")
	public void final_book_list_is(io.cucumber.datatable.DataTable dataTable) {
	    
	}
}
