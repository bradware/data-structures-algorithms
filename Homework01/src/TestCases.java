import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Comparator;
import org.junit.Test;

/**
 * SampleTestCases makes some test cases and tests them!
 * 
 * What is @Test? you need to have @Test above a method declaration if you want
 * JUnit to use that method as a test case.
 * 
 * Note that the String parameter in the following assertTrue, assertFalse,
 * assertEquals, and assertNull methods is optional. If you put the String it
 * will show the string if the test case fails if you don't provide the String,
 * it will simply flag the test as failed and won't show any message.
 * 
 * @author saman
 * 
 */
public class TestCases {

	/**
	 * Testing addNumbers(int, int) method
	 * 
	 * retVal holds the result of adding two integers passed in as parameters
	 * into addNumbers(int,int) method.
	 * 
	 * assertEquals(String message, Object expected, Object actual) checks the
	 * actual value against the expected value, if they are equal the test will
	 * pass, if they are not equal the test won't pass and the message will be
	 * shown.
	 * 
	 * Note: the String message parameter is optional.
	 */
	@Test
	public void testAddNumbers() {
		int retval = SimpleClass.addNumbers(10, -8);
		assertEquals("10 + (-8) is supposed to be 2 ", 2, retval);
	}

	/**
	 * Testing sameNumbers(int, int) method
	 * 
	 * retVal holds true if the parameters of sameNumbers(int,int) method are
	 * equal, and holds false otherwise. If condition is true the test will
	 * pass, if the condition is false the test won't pass and the message will
	 * be shown.
	 * 
	 * assertTrue(String message, boolean condition) checks if condition is
	 * true.
	 * 
	 */
	@Test
	public void testSameNumbers0() {
		boolean retval0 = SimpleClass.sameNumbers(1, 1);
		assertTrue("true expected, but the sameNumbers method returned false",
				retval0);
	}

	/**
	 * Testing sameNumbers(int, int) method
	 * 
	 * retVal holds true if the parameters of sameNumbers(int,int) method are
	 * equal, and holds false otherwise.If condition is false the test will
	 * pass, if the condition is true the test won't pass and the message will
	 * be shown.
	 * 
	 * assertFalse(String message, boolean condition) checks if condition is
	 * false.
	 * 
	 */
	@Test
	public void testSameNumbers1() {
		boolean retval1 = SimpleClass.sameNumbers(2, 1);
		assertFalse("false expected, but the sameNumbers method returned true",
				retval1);
	}

	/*****************************************
	 * Now it's your turn! Follow the instructions for each method.
	 * 
	 * 
	 * NOTE: Don't forget to put @Test above each method. If you are confused on
	 * Syntax look at the sample methods we provided and use those as
	 * references.
	 *****************************************/

	/**
	 * Use assertEquals to test hello() method
	 */
	@Test
	public void testHello0() {

		String answer = SimpleClass.hello();
		assertEquals("Should Print Hello World", "Hello World", answer);

	}

	/**
	 * Use assertEquals to test hello(String) method
	 * 
	 */
	@Test
	public void testHello1() {

		String answer = SimpleClass.hello("Brad");
		assertEquals("Should Print Hello Brad", "Hello Brad", answer);
	}

	/**
	 * Use assertEquals to test helloThing(T) method
	 */
	@Test
	public void testHelloThing() {
		Integer five = new Integer(5);
		String answer = SimpleClass.helloThing(five);
		assertEquals("Should Print Hello 5", "Hello 5", answer);
	}

	/**
	 * Use assertTrue to test Same(String, String) method
	 */
	@Test
	public void testSame0() {
		boolean answer = SimpleClass.same("cs1332", "cs1332");
		assertTrue("true expected, but the sameNumbers method returned false",
				answer);
	}

	/**
	 * Use assertFalse to test Same(String, String) method
	 */

	@Test
	public void testSame1() {

		boolean answer = SimpleClass.same("cs1332", "brad");
		assertFalse("false expected, but returned true", answer);
	}

	/**
	 * Use assertTrue to test strictlyLess(T, T) method
	 */

	@Test
	public void testStrictlyLess0() {

		boolean answer = SimpleClass.strictlyLess("Brad", "Chad");
		assertTrue("True expected but returned false", answer);
	}

	/**
	 * Use assertFalse to test strictlyLess(T, T) method
	 */
	@Test
	public void testStrictlyLess1() {


		boolean answer = SimpleClass.strictlyLess(5, 4);
		assertFalse("False expected but returned true", answer);

	}

	/**
	 * Use assertTrue to test strictlyLess(T, T, Comparator<T>) method
	 */
	@Test
	public void testStrictlyLess2() {

		MyComparator myComp = new MyComparator();
		boolean answer = SimpleClass.strictlyLess(4, 5, myComp);
		assertTrue("True expected but returned false", answer);
	}

	/**
	 * Use assertFalse to test strictlyLess(T, T, Comparator<T>) method
	 */
	@Test
	public void testStrictlyLess3() {
		MyComparator myComp = new MyComparator();
		boolean answer = SimpleClass.strictlyLess(5, 4, myComp);
		assertFalse("False expected but returned true", answer);
	}
	
	private class MyComparator implements Comparator<Integer> {
		
		
		@Override
		public int compare(Integer o1, Integer o2) {
			/**
			if (o1 < o2) {
				return -1;
			}
			if (o1 == o2) {
				return 0;
			}
			return 1;
			*/
			
			return o1.compareTo(o2);

		}
	

	}
	
}