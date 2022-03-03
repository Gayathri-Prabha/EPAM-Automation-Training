package TestAutomation.DatabaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestStructuralDB {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	@BeforeClass
	public void setup() throws SQLException {
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","2468");
	}
	
	@Test
	public void testTablesExistence() throws SQLException{
		String[] tableNames=new String[] {"city","citywithdetail","country","countrylanguage","employee"};
		ArrayList<String> expectedTableNames = new ArrayList<String>();
		stmt=conn.createStatement();
		rs=stmt.executeQuery("show tables");
		while(rs.next())
	    {
			String table = rs.getString(1);
			expectedTableNames.add(table);
	    }
		for(String table:tableNames) {
			assertTrue(expectedTableNames.contains(table));
		}
	}
	
	@Test
	public void testNumberofColumns() throws SQLException{
		stmt=conn.createStatement();
		rs=stmt.executeQuery("select count(*) from information_schema.columns where table_name='city';");
		while(rs.next())
	    {
			assertEquals("9",rs.getString(1));
	    }
	}
	
	@Test
	public void testColumnNames() throws SQLException{
		String columnNames[] = { "city_id", "city", "country_id", "last_update", "id", "name", "countrycode", "district", "population" };
		ArrayList<String> expectedColumnNames = new ArrayList<String>();
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select column_name from information_schema.columns where table_name='city';");
		while (rs.next()) {
			String column = rs.getString(1);
			expectedColumnNames.add(column);
		}
		for(String column:columnNames) {
			assertTrue(expectedColumnNames.contains(column));
		}
	}
	
	@Test
	public void testColumnsDataType() throws SQLException {
		String dataTypes[]= {"smallint","varchar","smallint","timestamp","int","char","char","char","int"};
		ArrayList<String> expectedDataTypes = new ArrayList<String>();
		stmt=conn.createStatement();
		rs=stmt.executeQuery("select column_name,data_type from information_schema.columns where table_name='city';");
		while(rs.next()) {
			String dataTypeName=rs.getString(2);
			expectedDataTypes.add(dataTypeName);
		}
		for(String dataTypeName:dataTypes) {
			assertTrue(expectedDataTypes.contains(dataTypeName));
		}
	}
	
	@Test
	public void testColumnsDataSize() throws SQLException {
		String[] dataTypesLength= {null,"35","3","20",null};
		ArrayList<String> expectedDataTypesLength = new ArrayList<String>();
		stmt=conn.createStatement();
		rs=stmt.executeQuery("select Column_Name,character_maximum_length from Information_Schema.columns where table_schema='world' and table_name='city'");
		while(rs.next()) {
			String dataTypeLength=rs.getString(2);
			expectedDataTypesLength.add(dataTypeLength);
		}
		for(String dataTypeLength:dataTypesLength) {
			assertTrue(expectedDataTypesLength.contains(dataTypeLength));
		}
	}
	
	@Test
	public void testNullable() throws SQLException {
		stmt=conn.createStatement();
		rs=stmt.executeQuery("select column_name,is_nullable from information_schema.columns where table_name='city'");
		while(rs.next()) {
			assertEquals("NO",rs.getString(2));
		}
	}
	
	@Test
	public void testConstraints() throws SQLException {
		String constraints[]= {"PRI","","MUL","","PRI","","MUl","",""};
		ArrayList<String> expectedConstraints = new ArrayList<String>();
		stmt=conn.createStatement();
		rs=stmt.executeQuery("select column_name,column_key from information_schema.columns where table_name='city'");
		while(rs.next()) {
			String keys=rs.getString(2);
			expectedConstraints.add(keys);
		}
		for(String keys:constraints) {
			assertTrue(expectedConstraints.contains(keys));
		}
	}
}
