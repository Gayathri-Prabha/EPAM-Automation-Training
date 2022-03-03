package TestAutomation.DatabaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestStoredProcedure {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	@BeforeClass
	public void setup() throws SQLException {
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","2468");
	}
	
	@Test
	public void testStoredProcedureExistence() throws SQLException {
		stmt=conn.createStatement();
		rs=stmt.executeQuery("show procedure status where name = 'cityCountsByCountry'");
		rs.next();
		String procedureName = rs.getString("Name");
		assertEquals(procedureName, "cityCountsByCountry");
	}
	
	@Test
	public void testSPCityDetails() throws SQLException {
		CallableStatement cstmt = conn.prepareCall("{CALL cityDetails}");
		rs=cstmt.executeQuery();
		stmt=conn.createStatement();
		ResultSet actualData=stmt.executeQuery("Select * from city");
		assertTrue(compareResultSet(rs, actualData));
	}
	
	@Test
	public void testSPCityByCountry() throws SQLException {
		CallableStatement cstmt = conn.prepareCall("{CALL cityByCountry(?)}");
		cstmt.setString(1, "AFG");
		rs=cstmt.executeQuery();
		stmt=conn.createStatement();
		ResultSet actualData=stmt.executeQuery("Select * from city where countryCode='AFG'");
		assertTrue(compareResultSet(rs, actualData));
	}
	
	@Test
	public void testSPCityCountsByCountry() throws SQLException {
		CallableStatement cstmt = conn.prepareCall("{CALL cityCountsByCountry(?,?,?)}");
		cstmt.setString(1, "AFG");
		cstmt.registerOutParameter(2, Types.INTEGER);
		cstmt.registerOutParameter(3, Types.INTEGER);
		rs=cstmt.executeQuery();
		int cityCount = cstmt.getInt(2);
		int countryCount = cstmt.getInt(3);
		
		stmt=conn.createStatement();
		ResultSet actualData=stmt.executeQuery("Select count(*) from city where countryCode='AFG'");
		actualData.next();
		int expectedCityCount = actualData.getInt(1);
		
		stmt=conn.createStatement();
		actualData=stmt.executeQuery("Select count(*) from country");
		actualData.next();
		int expectedCountryCount = actualData.getInt(1);
		
		assertEquals(cityCount,expectedCityCount);
		assertEquals(countryCount,expectedCountryCount);
	}
	
	@Test
	public void testTrigger() throws SQLException
	{
		stmt=conn.createStatement();
		stmt.execute("insert into employee(ID,name,age,language,nationality)\r\n"
				+ "values(303,\"ABCDEFG\",35,'EN','IND')");
		ResultSet actualData=stmt.executeQuery("select language from employee where ID = 303");
		String  language= "";
		while (actualData.next()) {
			language = actualData.getString("language");
		}
		assertEquals(language, "JP");
	}
	
	@Test
	private boolean compareResultSet(ResultSet rs1, ResultSet rs2) throws SQLException
	{
		try {
			while (rs1.next()) {
				rs2.next();
				int count = rs1.getMetaData().getColumnCount();
				for (int i = 1; i <= count; i++) {
					if (!rs1.getString(i).equals(rs2.getString(i))) {
						return false;
					}
				}
			}
		} 
		catch (Exception ex) 
		{
			return false;
		}
		return true;
	}

	@AfterClass
	public void tearDown() throws SQLException {
		conn.close();
	}
}
