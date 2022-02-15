package TestAutomation.restassured;

import org.testng.annotations.BeforeClass;
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

public class TestPost {
	@BeforeClass
	public static void setup() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
	}
	@Test
	public static void testPostObjectGETResponse() {
		given()
		.when()
			.get("/posts")
		.then()
			.statusCode(200);
	}
	@Test
	public static void testPostObjectWithID() {
		given().pathParam("id",1)
		.when()
			.get("/posts/{id}")
		.then()
			.statusCode(200)
			.body("userId",equalTo(1))
			.body("title",equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
	}
	@Test(dataProvider="userIDDataProvider")
	public static void testObjectwithQueryParam(int userID,int id) {
		List<Object> posts=given().queryParam("userId",userID)
		.when()
			.get("/posts")
		.then()
			.statusCode(200)
			.body("[0].id",equalTo(id))
			.extract().jsonPath().getList("$");
		assertEquals(posts.size(),10);
	}
	@Test(dataProvider="userIDDataProvider2")
	public static void testObjectwithQueryParam2(int userID) {
		List<Object> posts=given().queryParam("userId",userID)
		.when()
			.get("/posts")
		.then()
			.statusCode(200)
			.body("[0].userId",equalTo(userID))
			.extract().jsonPath().getList("$");
		assertEquals(posts.size(),10);
	}
	@DataProvider(name="userIDDataProvider")
	public Object[][] testgetuserIdDataprovvider() {
		return new Object[][]{{2,11},{3,21},{4,31},{5,41}};
	}
	@DataProvider(name="userIDDataProvider2")
	public Object[][] testgetuserIdDataprovvider2() {
		return new Object[][]{{2},{3},{4},{5}};
	}
	@Test
	public static void testObjectPOSTResponse() {
		String postRequestBody="{\r\n"
				+ "    \"userId\":66,\r\n"
				+ "    \"title\":\"Sample request for rest assured\",\r\n"
				+ "    \"body\":\"Sample request\"\r\n"
				+ "}";
		given()
			.header("Content-type","application/json")
			.and()
			.body(postRequestBody)
		.when()
			.post("/posts")
		.then()
			.statusCode(201)
			.body("id",equalTo(101));
	}
	@Test
	public static void testObjectPUTResponse() {
		String data="{\r\n"
				+ "    \"id\":1,\r\n"
				+ "    \"userId\":66,\r\n"
				+ "    \"title\":\"Sample request for assured automation\",\r\n"
				+ "    \"body\":\"Sample request automation\"\r\n"
				+ "}";
		given().pathParam("id", 1)
			.header("Content-type","application/json")
			.and()
			.body(data)
		.when()
			.put("/posts/{id}")
		.then()
			.statusCode(200)
			.body("title",equalTo("Sample request for assured automation"));
	}
	@Test
	public static void testObjectPATCHResponse() {
		String data1="{\r\n"
				+ "    \"title\":\"Sample Request for Assured\"\r\n"
				+ "}";
		given().pathParam("id", 1)
			.header("Content-type","application/json")
			.and()
			.body(data1)
		.when()
			.patch("/posts/{id}")
		.then()
			.statusCode(200)
			.body("title",equalTo("Sample Request for Assured"));
	}
}
