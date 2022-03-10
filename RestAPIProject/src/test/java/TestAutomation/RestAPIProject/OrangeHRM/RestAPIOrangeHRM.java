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
	String punchInTime;
	String punchOutTime;
	String totalTimeAfterPunchOut;
	String totalTimeAfterPunchDelete;
	String total;
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
	public void testTotalHours() {
	String data="id=653";
	total=given()
			.header("Authorization", "Bearer " + token)
			.and()
			.header("Content-type", "application/x-www-form-urlencoded")
			.and()
			.header("Cookie", cookie)
			.body(data)
	.when()
		.get("/api/attendanceSheet")
	.then()
		.statusCode(200).extract().jsonPath().getString("meta.totals.T.duration");
	System.out.println(total);
	}

	@Test(priority=4)
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
	
	@Test(priority=5)
	public void testAttendanceRecordsPunchIn() {
		String data="{\r\n"
				+ "    \"date\": \"2022-03-10\",\r\n"
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
		punchInTime=(String)res.get("punchInUserTime");
		System.out.println(punchInTime);
		punchInId = (String)res.get("id");
	}
	
	@Test(priority=6)
	public void testInvalidPunchIn() {
		String data="{\r\n"
				+ "    \"empNumber\":\"13\",\r\n"
				+ "    \"date\":\"2022-03-10\",\r\n"
				+ "    \"time\":\"12:00\",\r\n"
				+ "    \"timezoneOffset\":\"5.5\",\r\n"
				+ "    \"forcePunchIn\":false\r\n"
				+ "}";
		given()
			.header("Authorization", "Bearer " + token)
			.and()
			.header("Cookie", cookie)
			.and()
			.header("Content-Type", "application/json")
			.body(data)
		.when()
			.post("api/attendanceRecords")
		.then()
			.statusCode(403);
	}
	
	@Test(priority=7)
	public void testAttendanceRecordsPunchOut() {
		String data="{\"empNumber\":\"13\",\"date\":\"2022-03-10\",\"time\":\"17:00\",\"timezoneOffset\":\"5.5\"}";
		LinkedHashMap res=given()
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
			.statusCode(200).extract().jsonPath().get("data");
		punchOutTime=(String)res.get("punchOutUserTime");
		System.out.println(punchOutTime);
	}
	
	@Test(priority=8)
	public void testTotalHoursAfterPunchOut() {
	String data="id=653";
	totalTimeAfterPunchOut=given()
			.header("Authorization", "Bearer " + token)
			.and()
			.header("Content-type", "application/x-www-form-urlencoded")
			.and()
			.header("Cookie", cookie)
			.body(data)
	.when()
		.get("/api/attendanceSheet")
	.then()
		.statusCode(200)
		.extract().jsonPath().getString("meta.totals.T.duration");
	System.out.println(totalTimeAfterPunchOut);
	}
	
	@Test(priority=9)
	public void testInvalidPunchOut() {
		String data="{\r\n"
				+ "    \"date\": \"2022-03-10\",\r\n"
				+ "    \"empNumber\": \"13\",\r\n"
				+ "    \"time\": \"17:03\",\r\n"
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
			.statusCode(403);
	}
	
	@Test(priority=10)
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
	
	@Test(priority=11)
	public void testOverlappingRecords() {
		String data="{\r\n"
				+ "    \"empNumber\":\"13\",\r\n"
				+ "    \"date\":\"2022-01-04\",\r\n"
				+ "    \"time\":\"12:00\",\r\n"
				+ "    \"timezoneOffset\":\"5.5\",\r\n"
				+ "    \"forcePunchIn\":false\r\n"
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
				.statusCode(201).extract().jsonPath().get("messages.error");
		assertEquals(res,"Overlapping Records Found");
		System.out.println(res);	
	}
	
	@Test(priority=12)
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
	
	@Test(priority=13)
	public void testTotalHoursAfterDeleting() {
	String data="id=653";
	totalTimeAfterPunchDelete=given()
			.header("Authorization", "Bearer " + token)
			.and()
			.header("Content-type", "application/x-www-form-urlencoded")
			.and()
			.header("Cookie", cookie)
			.body(data)
	.when()
		.get("/api/attendanceSheet")
	.then()
		.statusCode(200).extract().jsonPath().getString("meta.totals.T.duration");
	assertEquals(totalTimeAfterPunchDelete,total);
	System.out.println(totalTimeAfterPunchDelete);
	}
}
