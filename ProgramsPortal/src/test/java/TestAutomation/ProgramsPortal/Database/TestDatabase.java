package TestAutomation.ProgramsPortal.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestDatabase {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	public static int speakerID;
	public static String speakerName;
	public String speakerEmail;
	public String speakerProfile;
	@BeforeClass
	public void setup() throws SQLException {
		conn=DriverManager.getConnection("jdbc:mysql://EPINHYDW0087:3306/programs","qa","qa123");
	}
	
	@Test
	public void testSpeakerID() throws SQLException {
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from programs.speaker_info where speaker_name = 'Gayathri Prabha Mallavarapu'");
		while(rs.next()) {
			speakerID = rs.getInt("id");
			System.out.println("Speaker ID: " + speakerID);
			speakerName = rs.getString("speaker_name");
			System.out.println("Speaker Name: " + speakerName);
			speakerEmail = rs.getString("speaker_email");
			System.out.println("Speaker Email: " + speakerEmail);
			speakerProfile = rs.getString("speaker_profile");
			System.out.println("Speaker Profile: " + speakerProfile);
		}
	}
}
