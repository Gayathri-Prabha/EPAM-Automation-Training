package TestAutomation.ProgramsPortal.RestAssured;

import java.net.MalformedURLException;
import java.util.Random;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import TestAutomation.ProgramsPortal.Database.TestDatabase;
import io.restassured.RestAssured;

public class TestRestAssured {
	int random;
	static int num;
	@BeforeClass
	public static void setup(ITestContext context) throws MalformedURLException {
		RestAssured.baseURI="http://epinhydw0087:9090";
	}
	
	@Test(priority = 1)
	public void testSpeakerDetailsWithID() {
		String speakerDetails = given()
				.pathParam("speakerId", TestDatabase.speakerID)
			.when()
				.get("/programs/speaker/{speakerId}")
			.then()
				.statusCode(200)
				.extract().jsonPath().getString("speakerName");
		System.out.println("Speaker Name: " + speakerDetails);
		assertEquals(speakerDetails,TestDatabase.speakerName);
	}
	
	@Test(priority = 2)
	public static void testAddSpeakerDetails() {
		Random random = new Random();
		num = random.nextInt(100);
		String data = "{\r\n"
				+ "    \"disabledStatus\": true,\r\n"
				+ "    \"speakerEmail\": \"gayathriprabha" +num+ "@epam.com\",\r\n"
				+ "    \"speakerId\": 0,\r\n"
				+ "    \"speakerName\": \"Gayathri Prabha\",\r\n"
				+ "    \"speakerPicPath\": \"path\",\r\n"
				+ "    \"speakerProfile\": \"Automation\"\r\n"
				+ "}";
		String name = given()
				.header("Content-type","application/json")
				.body(data)
			.when()
				.post("/programs/speaker")
			.then()
				.statusCode(201).extract().jsonPath().getString("speakerName");
		System.out.println("Speaker Name: " + name);
		assertEquals(name, "Gayathri Prabha");
	}
}
