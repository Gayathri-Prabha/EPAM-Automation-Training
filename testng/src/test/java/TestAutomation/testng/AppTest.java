package TestAutomation.testng;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest 
{
    @Test
    public void testApp()
    {
        assertTrue( true );
    }
    @Test
    public void testApp1()
    {
        System.out.println("Executing test 1");
    }
    @Test
    public void testApp2()
    {
    	System.out.println("Executing test 2");
    }
    @BeforeTest
    public void beforetest()
    {
    	System.out.println("Executing BEFORE TEST");
    }
    @AfterTest
    public void aftertest()
    {
    	System.out.println("Executing AFTER TEST");
    }
    @BeforeSuite
    public void beforeSuite()
    {
    	System.out.println("Executing BEFORE SUITE");
    }   
    @AfterSuite
    public void afterSuite()
    {
    	System.out.println("Executing AFTER SUITE");
    }   
    @BeforeMethod
    public void beforeMethod()
    {
    	System.out.println("Executing BEFORE METHOD");
    }    
    @AfterMethod
    public void afterMethod()
    {
    	System.out.println("Executing AFTER METHOD");
    }
}
