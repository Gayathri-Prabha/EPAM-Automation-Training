package TestAutomation.RestAPIProject.OrangeHRM;

import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import java.net.MalformedURLException;
import java.util.LinkedHashMap;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAPIOrangeHRM {
	String token;
	String cookie;
	String punchInId;
	@BeforeTest
	public void setup(ITestContext context) throws MalformedURLException
	{
		this.token=context.getCurrentXmlTest().getParameter("token");
		this.cookie=context.getCurrentXmlTest().getParameter("cookie");
		RestAssured.baseURI="https://prasoonr-trials73.orangehrmlive.com/";
	}
	
	@Test(priority=1)
	public void testAttendanceSheet() {
		String latestSheetId=given()
				.header("Authorization", "Bearer " + token)
				.and()
				.header("Cookie", cookie)
				.and()
				.header("Content-type", "application/x-www-form-urlencoded")
			.when()
				.get("api/attendanceSheet")
			.then()
				.statusCode(200).extract().jsonPath().getString("data.latestSheetId");
		assertNotNull(latestSheetId);
		System.out.println(latestSheetId);
	}
	
	@Test(priority=2)
	public void testAttendanceSheetWithID() {
		String time=given()
				.header("Authorization", "Bearer " + token)
				.and()
				.header("Cookie", cookie)
				.and()
				.header("Content-type", "application/x-www-form-urlencoded")
			.when()
				.get("api/attendanceSheet?id=653")
			.then()
				.statusCode(200).extract().jsonPath().getString("data.total");
		System.out.println(time);
	}
	
	@Test(priority=3)
	public void testConfig() {
		given()
			.header("Authorization", "Bearer " + token)
			.and()
			.header("Cookie", cookie)
			.and()
			.header("Content-type", "application/x-www-form-urlencoded")
		.when()
			.get("api/attendance/config")
		.then()
			.statusCode(200);
	}
	
	@Test(priority=4)
	public void testAttendanceRecordsPunchIn() {
		String data="{\r\n"
				+ "    \"date\": \"2022-04-06\",\r\n"
				+ "    \"empNumber\": \"13\",\r\n"
				+ "    \"forcePunchIn\": false,\r\n"
				+ "    \"time\": \"16:00\",\r\n"
				+ "    \"timezoneOffset\": \"5.5\"\r\n"
				+ "}";
		LinkedHashMap res=given()
				.header("Authorization", "Bearer " + token)
				.and()
				.header("Cookie", cookie)
				.and()
				.header("Content-Type", "application/json")
				.body(data)
			.when()
				.post("api/attendanceRecords")
			.then()
				.statusCode(201).extract().jsonPath().get("data");
		System.out.println((String)res.get("id"));
		punchInId = (String)res.get("id");
	}
	
	@Test(priority=5)
	public void testAttendanceRecordsPunchOut() {
		String data="{\r\n"
				+ "    \"date\": \"2022-04-06\",\r\n"
				+ "    \"empNumber\": \"13\",\r\n"
				+ "    \"time\": \"17:00\",\r\n"
				+ "    \"timezoneOffset\": \"5.5\"\r\n"
				+ "}";
		given()
			.pathParam("PunchInId", punchInId)
			.header("Authorization", "Bearer " + token)
			.and()
			.header("Cookie", cookie)
			.and()
			.header("Content-Type", "application/json")
			.body(data)
		.when()
			.patch("api/attendanceRecord/{PunchInId}")
		.then()
			.statusCode(200);
	}
	
	@Test(priority=6)
	public void testInvalidFormat() {
		String data="{\r\n"
				+ "    \"empNumber\": \"13\",\r\n"
				+ "    \"mode\": \"checkPunchInOverlappingRecords\",\r\n"
				+ "    \"punchInDate\": \"2022-03-21\",\r\n"
				+ "    \"punchInTime\": \"11:0\",\r\n"
				+ "    \"punchInTimezoneOffset\": \"5.5\"\r\n"
				+ "}";
		String res=given()
				.header("Authorization", "Bearer " + token)
				.and()
				.header("Cookie", cookie)
				.and()
				.header("Content-Type", "application/json")
				.body(data)
			.when()
				.post("api/attendanceRecords")
			.then()
				.statusCode(400).extract().jsonPath().get("title");
		assertEquals(res,"Invalid data");
		System.out.println(res);
	}
	
	@Test(priority=7)
	public void testDelete() {
		String data="{\"ids\":["+punchInId+"]}";
		String res=given()
				.header("Authorization", "Bearer " + token)
				.and()
				.header("Cookie", cookie)
				.and()
				.header("Content-Type", "application/json")
				.body(data)
			.when()
				.delete("/api/attendanceRecords")
			.then()
				.statusCode(200).extract().jsonPath().getString("messages.success");
		assertEquals(res,"Successfully Deleted");
		System.out.println(res);
	}
}
