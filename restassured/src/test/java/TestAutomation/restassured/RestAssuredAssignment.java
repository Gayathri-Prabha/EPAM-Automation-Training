package TestAutomation.restassured;

import static org.hamcrest.CoreMatchers.equalTo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class RestAssuredAssignment {
	@BeforeClass
	public static void setup() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
	}
	@Test
	public void testPostonPostObject() {
		TestTodos t=new TestTodos();
		t.setUserId(11);
		t.setId(201);
		t.setTitle("Todos for Rest Assured");
		t.setCompleted(true);
		given()
			.header("Content-Type", "application/json")
			.and()
			.body(t)
		.when()
			.post("/todos")
		.then()
			.statusCode(201)
			.body("title",equalTo("Todos for Rest Assured"));
		System.out.println("userId is: "+t.userId);
		System.out.println("Id is: "+t.Id);
		System.out.println("title is: "+t.title);
		System.out.println("completed is: "+t.completed);
	}
	@Test
	public void testGetonGetObject() {
		TestTodos object= given()
			.when()
				.get("/todos/1")
				.as(TestTodos.class);
		System.out.println(object.toString());
	}
}
