package TestAutomation.restassured;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;
import java.util.Iterator;
import java.util.List;
import static io.restassured.RestAssured.*;
import java.util.Random;

public class TestApiAssignment {
	String token;
	int id;
	int random;
	int num;
	@BeforeTest
	public void testLogin() {
		RestAssured.baseURI = "http://restapi.adequateshop.com/api";
		String data="{\r\n"
				+ "	\"email\":\"testautomation13@gmail.com\",\r\n"
				+ "	\"password\":123456789\r\n"
				+ "}";
		Random random = new Random();
		num = random.nextInt(100);
		token=given()
				.header("Content-type","application/json")
				.and()
				.body(data)
			.when()
				.post("/authaccount/login")
			.then()
				.statusCode(200)
				.extract().jsonPath().getString("data.Token");
		System.out.println("Token is: "+token);
	}
	@Test
	public void testApiPOSTResponse() {
		String data = "{\r\n" + "\"id\":1234,\r\n" + " \"name\": \"RestAssured22\",\r\n"
				+ " \"email\": \"RestAssured22" +num+"@gmail.com\",\r\n"
				+ " \"profilepicture\": \"http://restapi.adequateshop.com/Media/Images/a97579ae-86ec-41db-8810-018ffd7dba3c.png\",\r\n"
				+ " \"location\": \"Hyderabad, Telangana, India\",\r\n"
				+ " \"createdat\": \"2020-05-05T07:25:56.5590666\"\r\n" + "}";
		id = given()
				.header("Authorization", "Bearer " + token)
				.and()
				.header("Content-type", "application/json")
				.body(data)
			.when()
				.post("/users")
			.then()
				.extract().jsonPath().getInt("id");
		System.out.println("Id is: " + id);
	}
	@Test(dependsOnMethods= {"testApiPOSTResponse"})
	public void testApiGETResponse() {
		given()
			.header("Authorization","Bearer "+token)
			.and()
		.when()
			.get("/users/"+id)
		.then()
			.statusCode(200);
	}
	@Test(dependsOnMethods= {"testApiGETResponse"})
	public void testApiPUTResponse() {
		String data = "{\r\n" + "\"id\":"+id+",\r\n" + " \"name\": \"APIRestAssured20\",\r\n"
				+ " \"email\": \"APIRestAssured20@gmail.com\",\r\n"
				+ " \"profilepicture\": \"http://restapi.adequateshop.com/Media/Images/a97579ae-86ec-41db-8810-018ffd7dba3c.png\",\r\n"
				+ " \"location\": \"Hyderabad, Telangana, India\",\r\n"
				+ " \"createdat\": \"2020-05-05T07:25:56.5590666\"\r\n" + "}";
		given()
			.pathParam("id",id) 
			.header("Authorization","Bearer "+token) 
			.and() 
			.header("Content-type","application/json") 
			.body(data) 
		.when() 
			.put("/users/{id}")
		.then() 
			.statusCode(200);
	}
	@Test(dependsOnMethods= {"testApiPUTResponse"})
	public void testApiDELETEResponse() {
		given().pathParam("id",id)
			.header("Authorization","Bearer "+token) 
			.and()
			.header("Content-type","application/json") 
		.when() 
			.delete("/users/{id}")
		.then() 
			.statusCode(200);
	}
}
