package TestAutomation.testautomation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
    /**
     * Rigorous Test :-)
     */
	
	public AppTest(String testName) {
		super(testName);
	}
    @Test
    public void testApp()
    {
        assertTrue( true );
    }
    @Test
    public void testStringEquality() {
    	App app=new App();
    	String greeting=app.sendGreetingMessage();
    	assertEquals("Hello Team",greeting);
    }
}
