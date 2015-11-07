import static org.junit.Assert.*;

import org.junit.Test;


public class TestMe {

	@Test
	public void test() {
		
		assertTrue(1 + 1 == 2);
		assertFalse(1 + 1 == 3);
		assertEquals(3, 4-1);
	}

	@Test
	public void testAdd() {
		
	}
	
	@Test(timeout = 1000)
	public void testLoop() {
		testLoop();
		assertTrue(true);
	}
}
