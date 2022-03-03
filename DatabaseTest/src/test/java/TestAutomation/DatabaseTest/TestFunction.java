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

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestFunction {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	@BeforeClass
	public void setup() throws SQLException {
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","2468");
	}
	
	@Test
	public void testFunctionExistence() throws SQLException {
		stmt=conn.createStatement();
		rs=stmt.executeQuery("show function status where name='cityPopulation';");
		rs.next();
		String functionName = rs.getString("Name");
		assertEquals(functionName, "cityPopulation");
	}
	
	@Test
	public void testcountCityPopulation() throws SQLException {
		CallableStatement cstmt = conn.prepareCall("{? = call cityPopulation(?)}");
		cstmt.registerOutParameter(1, Types.INTEGER);
		cstmt.setInt(2, 200000);
		cstmt.execute();
		int expectedCount=cstmt.getInt(1);
		stmt=conn.createStatement();
		rs=stmt.executeQuery("select count(*) from city where Population > 200000");
		int actualCount=0;
		while(rs.next())
	    {
	    	actualCount=rs.getInt(1);
	    }
		assertEquals(actualCount,expectedCount);
	}
}
