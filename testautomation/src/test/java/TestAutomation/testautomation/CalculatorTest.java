package TestAutomation.testautomation;

import static org.junit.Assert.assertThrows;
import org.junit.Test;
import junit.framework.TestCase;

public class CalculatorTest extends TestCase{
	Calculator ob;
	@Override
	protected void setUp() throws Exception{
		super.setUp();
		ob=new Calculator();
	}
	@Test
	public void testAdd() {
		int res1=ob.add(2, 3);
		assertEquals(5,res1);
	}
	@Test
	public void testSub() {
		int res2=ob.sub(5, 9);
		assertEquals(4,res2);
	}
	@Test
	public void testMul() {
		int res3=ob.mul(6, 7);
		assertEquals(42,res3);
	}
	@Test
	public void testDiv() {
		int res4=ob.div(8, 4);
		assertEquals(2,res4);
	}
	@Test
	public void testDivWithZeroValue() {
		Integer res=ob.div(10,0);
		assertNull(res);
	}
	@Test
	public void testDivWithZeroValueException() {
		assertThrows(ArithmeticException.class,() -> ob.divWithZeroHandling(10,0));
	}
}
