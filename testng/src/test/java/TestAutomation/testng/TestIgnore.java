package TestAutomation.testng;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TestIgnore {
 	@Test
    public void testApp1()
    {
        assertTrue(true);
    }
    @Test(enabled = false)
    public void testApp2()
    {
    	assertTrue(true);
    }
}
