import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * 
 * @author Saman Shareghi
 * 
 */
public class LinkedListJunit {

	/*****************************************************/
	/****************** addLast() test ******************/
	/*****************************************************/

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testAddLast1() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(2);
		assertEquals("Add fails for 1 item", new Integer(2), test.get(0));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testAddLast2() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(2);
		test.add(5);
		assertEquals("Add fails for 2 items", new Integer(2), test.get(0));
		assertEquals("Add fails for 2 items", new Integer(5), test.get(1));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testAddLast3() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.addLast(2);
		assertEquals("Add fails for 1 item", new Integer(2), test.get(0));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testAddLast4() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.addLast(2);
		test.addLast(5);
		assertEquals("Add fails for 2 items", new Integer(2), test.get(0));
		assertEquals("Add fails for 2 items", new Integer(5), test.get(1));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testAddLast5() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.addLast(null);
		assertEquals("Add fails for 1 null data", null, test.get(0));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testAddLast6() {
		List<Integer> test = new LinkedList<Integer>();
		for (int i = 0; i < 5001; i++)
			test.add(i);
		assertEquals("Add fails for to regrow", new Integer(5000),
				test.get(5000));
	}

	/*****************************************************/
	/****************** addFirst() test ******************/
	/*****************************************************/

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testAddFirst1() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.addFirst(2);
		assertEquals("Add fails for 1 item", new Integer(2), test.get(0));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testAddFirst2() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.addFirst(2);
		test.addFirst(5);
		assertEquals("Add fails for 2 items", new Integer(5), test.get(0));
		assertEquals("Add fails for 2 items", new Integer(2), test.get(1));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testAddFirst3() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.addFirst(null);
		assertEquals("Add fails for 1 item", null, test.get(0));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testAddFirst4() {
		List<Integer> test = new LinkedList<Integer>();
		for (int i = 0; i < 5001; i++)
			test.add(i);
		assertEquals("Add fails for to regrow", new Integer(5000),
				test.get(5000));
	}

	/*****************************************************/
	/****************** getLast() test *******************/
	/*****************************************************/

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testGetLast0() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(2);
		test.add(5);
		assertEquals("Get last fails for 2 items", new Integer(5),
				test.getLast());
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testGetLast1() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(600);
		test.addLast(5);
		test.addFirst(null);
		assertEquals("Get last fails for 3 items", new Integer(5),
				test.getLast());
	}

	// @Worth(points=1)
	@Test(timeout = 2000, expected = NoSuchElementException.class)
	public void testGetLast2() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		assertEquals("Get last fails for empty list", null, test.getLast());
	}

	/*****************************************************/
	/****************** getFirst() test ******************/
	/*****************************************************/

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testGetFirst0() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(2);
		test.add(5);
		assertEquals("Get first fails for 2 items", new Integer(2),
				test.getFirst());
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testGetFirst1() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(600);
		test.addLast(5);
		test.addFirst(null);
		assertEquals("Get first fails for 3 items", null, test.getFirst());
	}

	// @Worth(points=1)
	@Test(timeout = 2000, expected = NoSuchElementException.class)
	public void testGetFirst2() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		assertEquals("Get first fails for empty list", null, test.getFirst());
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testGetFirst3() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(600);
		assertTrue(
				"Get first and get last don't return the same for a 1 element LL",
				test.getLast().equals(test.getFirst()));
	}

	/***********************************************/
	/********************* add() *********************/
	/***********************************************/

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testAdd1() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(2, 0);
		assertEquals("Add fails for 1 item", new Integer(2), test.get(0));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testAdd2() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(null, 0);
		assertEquals("Add fails for null", null, test.get(0));
	}

	// @Worth(points=1)
	@Test(timeout = 2000, expected = IndexOutOfBoundsException.class)
	public void testAdd3() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(2, -12);
		assertFalse("Add fails for a negative index", test.contains(2));
	}

	// @Worth(points=1)
	@Test(timeout = 2000, expected = IndexOutOfBoundsException.class)
	public void testAdd4() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(2, 2);
		assertFalse("Add fails for an index beyond current bounds",
				test.contains(2));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testAdd5() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(2, 0);
		test.add(1, 1);
		assertEquals("Add fails for 2 items", new Integer(2), test.get(0));
		assertEquals("Add fails for 2 items", new Integer(1), test.get(1));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testAdd6() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(2, 0);
		test.add(1, 0);
		assertEquals("Add fails for 2 items in the same position", new Integer(
				2), test.get(1));
		assertEquals("Add fails for 2 items in the same position", new Integer(
				1), test.get(0));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testAdd7() {
		List<Integer> test = new LinkedList<Integer>();
		addMany(5000, test);
		assertEquals("Add fails for to regrow", new Integer(5000),
				test.get(5000));
	}

	/*****************************************************/
	/****************** contains() test ******************/
	/*****************************************************/

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testContains1() {
		List<Integer> test = new LinkedList<Integer>();
		assertFalse("Contains fails for null when null is not added",
				test.contains(null));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testContains2() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(null, 0);
		assertTrue("Contains fails for null when null is added",
				test.contains(null));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testContains3() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(1, 0);
		assertTrue("Contains fails for 1 item", test.contains(1));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testContains4() {
		List<Integer> test = new LinkedList<Integer>();
		addMany(500, test);
		assertTrue("Contains fails for many items", test.contains(373));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testContains5() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(1, 0);
		test.add(null, 0);
		assertTrue("Contains fails for an item after a null", test.contains(1));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testContains6() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(1, 0);
		assertFalse("Contains fails for an item not in LinkedList",
				test.contains(4));
	}

	/*****************************************************/
	/****************** get() test ******************/
	/*****************************************************/

	// @Worth(points=1)
	@Test(timeout = 2000, expected = IndexOutOfBoundsException.class)
	public void testGet1() {
		List<Integer> test = new LinkedList<Integer>();
		assertEquals("Get fails for a negative index", null, test.get(-20));
	}

	// @Worth(points=1)
	@Test(timeout = 2000, expected = IndexOutOfBoundsException.class)
	public void testGet2() {
		List<Integer> test = new LinkedList<Integer>();
		assertEquals("Get fails for an index beyond current bounds", null,
				test.get(20));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testGet3() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(1);
		test.add(null);
		test.add(30);
		test.addLast(32);
		test.addFirst(null);

		assertEquals("Get fails for an index beyond current bounds", null,
				test.get(2));
	}

	/*****************************************************/
	/****************** indexOf() test ******************/
	/*****************************************************/

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testIndexOf1() {
		List<Integer> test = new LinkedList<Integer>();
		assertEquals("Index of fails for null when null is not added", -1,
				test.indexOf(null));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testIndexOf3() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(2, 0);
		assertEquals("Index of fails for 1 item", 0, test.indexOf(2));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testIndexOf4() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(2, 0);
		assertEquals("Index of fails for item not in LinkedList", -1,
				test.indexOf(3));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testIndexOf5() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(2, 0);
		test.add(2, 0);
		test.add(2, 0);
		test.add(2, 0);
		test.add(3, 3);
		test.add(3, 0);
		assertEquals("Index of fails for first instance of an item", 1,
				test.indexOf(2));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testIndexOf6() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(2, 0);
		test.add(2, 0);
		test.add(2, 0);
		test.add(2, 0);
		test.add(null, 3);
		test.add(null, 1);
		assertEquals("Index of fails for first instance of a null", 1,
				test.indexOf(null));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testIndexOf7() {
		List<Integer> test = new LinkedList<Integer>();
		addMany(5000, test);
		assertEquals("Index of fails after regrow", 5000, test.indexOf(5000));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testIndexOf8() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(2, 0);
		test.add(2, 0);
		test.add(2, 0);
		test.add(2, 0);
		test.add(null, 3);
		test.add(null, 1);
		test.clear();
		assertEquals("Index of fails after clear", -1, test.indexOf(null));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testIndexOf9() {
		List<Integer> test = new LinkedList<Integer>();
		addMany(5000, test);
		test.clear();
		assertEquals("Index of fails after clear and regrow", -1,
				test.indexOf(3032));
	}

	/*****************************************************/
	/****************** isEmpty() test ******************/
	/*****************************************************/

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testIsEmpty1() {
		List<Integer> test = new LinkedList<Integer>();
		assertTrue("Is empty fails for new LinkedList", test.isEmpty());
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testIsEmpty2() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(2, 0);
		assertFalse("Is empty fails for an LinkedList with 1 item",
				test.isEmpty());
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testIsEmpty3() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(2, 0);
		test.clear();
		assertTrue("Is empty fails for a cleared LinkedList", test.isEmpty());
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testIsEmpty4() {
		List<Integer> test = new LinkedList<Integer>();
		addMany(500, test);
		test.clear();
		assertTrue("Is empty fails for a cleared LinkedList", test.isEmpty());
	}

	/*****************************************************/
	/****************** size() test ******************/
	/*****************************************************/

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testSize1() {
		List<Integer> test = new LinkedList<Integer>();
		assertEquals("Size fails for new LinkedList", 0, test.size());
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testSize2() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(2, 0);
		assertEquals("Size fails for an LinkedList with 1 item", 1, test.size());
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testSize3() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(2, 0);
		test.clear();
		assertEquals("Size fails for a cleared LinkedList", 0, test.size());
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testSize4() {
		List<Integer> test = new LinkedList<Integer>();
		addMany(5000, test);
		test.clear();
		assertEquals("Size fails for a cleared LinkedList", 0, test.size());
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testSize5() {
		List<Integer> test = new LinkedList<Integer>();
		addMany(5000 - 1, test);
		addMany(5000 - 1, test);
		assertEquals("Size fails for a cleared LinkedList", 10000, test.size());
	}

	/*****************************************************/
	/****************** clear() test ******************/
	/*****************************************************/

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testClear1() {
		List<Integer> test = new LinkedList<Integer>();
		test.clear();
		assertEquals("Clear fails on a new LinkedList", 0, test.size());
	}

	// @Worth(points=1)
	@Test(timeout = 2000, expected = IndexOutOfBoundsException.class)
	public void testClear2() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(2, 0);
		test.clear();
		assertEquals("Clear fails to clear 1 item", null, test.get(0));
	}

	// @Worth(points=1)
	@Test(timeout = 2000, expected = IndexOutOfBoundsException.class)
	public void testClear3() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(2, 0);
		test.add(2, 0);
		test.add(2, 0);
		test.clear();
		test.add(3, 1);
		assertFalse("Clear fails to reset size", test.contains(3));
	}

	/*****************************************************/
	/****************** iterator() test ******************/
	/*****************************************************/

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testIterator1() {
		List<Integer> test = new LinkedList<Integer>();
		for (@SuppressWarnings("unused")
		Integer i : test) {
			fail("Iterator fails for an empty list");
		}
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testIterator2() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(2);
		int sum = 0;
		for (Integer i : test) {
			sum += i;
		}
		assertEquals("Iterator fails for 1 element list", 2, sum);
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testIterator3() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(5);
		test.add(10);
		test.add(15);
		test.add(20);
		test.add(25);
		int sum = 0;
		for (Integer i : test) {
			sum += i;
		}
		assertEquals("Iterator fails on a list of 5 items", 75, sum);
	}

	/*****************************************************/
	/****************** remove() test ******************/
	/*****************************************************/

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testRemove1() {
		List<Integer> test = new LinkedList<Integer>();
		assertEquals("Remove fails for empty list", null,
				test.remove(new Integer(5)));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testRemove2() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(10);
		assertEquals("Remove fails for element not in list", null,
				test.remove(new Integer(5)));
		assertEquals("Remove fails for element not in list", 1, test.size());
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testRemove3() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(10);
		assertEquals("Remove fails for list of size 1", new Integer(10),
				test.remove(new Integer(10)));
		assertTrue("Remove fails for list of size 1", test.isEmpty());
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testRemove4() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(10);
		test.add(5);
		test.add(17);
		assertEquals("Remove fails for first element of list", new Integer(10),
				test.remove(new Integer(10)));
		assertEquals("Remove fails for first element of list", 2, test.size());
		assertEquals("Remove fails for first element of list", new Integer(5),
				test.get(0));
		assertEquals("Remove fails for first element of list", new Integer(17),
				test.get(1));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testRemove5() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(10);
		test.add(5);
		test.add(17);
		assertEquals("Remove fails for middle element of list", new Integer(5),
				test.remove(new Integer(5)));
		assertEquals("Remove fails for middle element of list", 2, test.size());
		assertEquals("Remove fails for middle element of list",
				new Integer(10), test.get(0));
		assertEquals("Remove fails for middle element of list",
				new Integer(17), test.get(1));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testRemove6() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(10);
		test.add(5);
		test.add(17);
		assertEquals("Remove fails for last element of list", new Integer(17),
				test.remove(new Integer(17)));
		assertEquals("Remove fails for last element of list", 2, test.size());
		assertEquals("Remove fails for last element of list", new Integer(10),
				test.get(0));
		assertEquals("Remove fails for last element of list", new Integer(5),
				test.get(1));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testRemove7() {
		List<Thing> test = new LinkedList<Thing>();
		Thing a = new Thing(10);
		Thing b = new Thing(5), b2 = new Thing(5);
		Thing c = new Thing(17);
		test.add(a);
		test.add(b);
		test.add(c);
		Thing rem = test.remove(b2);
		assertEquals("Remove doesn't return element from list", b.time,
				rem.time);
	}

	// @Worth(points=1)
	@Test(timeout = 2000, expected = IndexOutOfBoundsException.class)
	public void testRemove8() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(5);
		assertEquals("Remove fails for one element list", new Integer(5),
				test.remove(new Integer(5)));
		assertEquals("Remove fails for one element list", 0, test.size());
		assertEquals("Remove fails for one element list", null, test.get(0));
		assertEquals("Remove fails for one element list", null,
				test.get(test.size()));
	}

	/*****************************************************/
	/****************** removeAt() test ******************/
	/*****************************************************/

	// @Worth(points=1)
	@Test(timeout = 2000, expected = IndexOutOfBoundsException.class)
	public void testRemoveAt1() {
		List<Integer> test = new LinkedList<Integer>();
		assertEquals("Remove fails for empty list", null, test.remove(0));
	}

	// @Worth(points=1)
	@Test(timeout = 2000, expected = IndexOutOfBoundsException.class)
	public void testRemoveAt2() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(10);
		assertEquals("Remove fails for negative index", null, test.remove(-5));
		assertEquals("Remove fails for negative index", 1, test.size());
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testRemoveAt3() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(10);
		assertEquals("Remove fails for list of size 1", new Integer(10),
				test.remove(0));
		assertTrue("Remove fails for list of size 1", test.isEmpty());
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testRemoveAt4() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(10);
		test.add(5);
		test.add(17);
		assertEquals("Remove fails for first element of list", new Integer(10),
				test.remove(0));
		assertEquals("Remove fails for first element of list", 2, test.size());
		assertEquals("Remove fails for first element of list", new Integer(5),
				test.get(0));
		assertEquals("Remove fails for first element of list", new Integer(17),
				test.get(1));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testRemoveAt5() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(10);
		test.add(5);
		test.add(17);
		assertEquals("Remove fails for middle element of list", new Integer(5),
				test.remove(1));
		assertEquals("Remove fails for middle element of list", 2, test.size());
		assertEquals("Remove fails for middle element of list",
				new Integer(10), test.get(0));
		assertEquals("Remove fails for middle element of list",
				new Integer(17), test.get(1));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testRemoveAt6() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(10);
		test.add(5);
		test.add(17);
		assertEquals("Remove fails for last element of list", new Integer(17),
				test.remove(2));
		assertEquals("Remove fails for last element of list", 2, test.size());
		assertEquals("Remove fails for last element of list", new Integer(10),
				test.get(0));
		assertEquals("Remove fails for last element of list", new Integer(5),
				test.get(1));
	}

	// @Worth(points=1)
	@Test(timeout = 2000, expected = IndexOutOfBoundsException.class)
	public void testRemoveAt7() {
		List<Integer> test = new LinkedList<Integer>();
		test.add(5);
		assertEquals("Remove fails for one element list", new Integer(5),
				test.remove(0));
		assertEquals("Remove fails for one element list", 0, test.size());
		assertEquals("Remove fails for one element list", null, test.get(0));
		assertEquals("Remove fails for one element list", null,
				test.get(test.size()));
	}

	/*****************************************************/
	/****************** removeFirst() test ******************/
	/*****************************************************/

	// @Worth(points=1)
	@Test(timeout = 2000, expected = NoSuchElementException.class)
	public void testRemoveFirst1() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		assertEquals("Remove first fails for empty list", null,
				test.removeFirst());
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testRemoveFirst2() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(10);
		assertEquals("Remove first fails for 1 element list", new Integer(10),
				test.removeFirst());
		assertTrue("Remove first fails for 1 element list", test.isEmpty());
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testRemoveFirst3() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(10);
		test.add(5);
		test.add(17);
		assertEquals("Remove first fails for 3 element list", new Integer(10),
				test.removeFirst());
		assertEquals("Remove first fails for 3 element list", 2, test.size());
	}

	// @Worth(points=1)
	@Test(timeout = 2000, expected = IndexOutOfBoundsException.class)
	public void testRemoveFirst4() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(5);
		assertEquals("Remove fails for one element list", new Integer(5),
				test.removeFirst());
		assertEquals("Remove fails for one element list", 0, test.size());
		assertEquals("Remove fails for one element list", null, test.get(0));
		assertEquals("Remove fails for one element list", null,
				test.get(test.size()));
	}

	/*****************************************************/
	/****************** removeLast() test ******************/
	/*****************************************************/

	// @Worth(points=1)
	@Test(timeout = 2000, expected = NoSuchElementException.class)
	public void testRemoveLast1() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		assertEquals("Remove last fails for empty list", null,
				test.removeLast());
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testRemoveLast2() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(10);
		assertEquals("Remove last fails for 1 element list", new Integer(10),
				test.removeLast());
		assertTrue("Remove last fails for 1 element list", test.isEmpty());
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testRemoveLast3() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(10);
		test.add(5);
		test.add(17);
		assertEquals("Remove last fails for 3 element list", new Integer(17),
				test.removeLast());
		assertEquals("Remove last fails for 3 element list", 2, test.size());
	}

	// @Worth(points=1)
	@Test(timeout = 2000, expected = IndexOutOfBoundsException.class)
	public void testRemoveLast4() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(5);
		assertEquals("Remove fails for one element list", new Integer(5),
				test.removeLast());
		assertEquals("Remove fails for one element list", 0, test.size());
		assertEquals("Remove fails for one element list", null, test.get(0));
		assertEquals("Remove fails for one element list", null,
				test.get(test.size()));
	}

	/*****************************************************/
	/****************** getHead() test ******************/
	/*****************************************************/

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testGetHead0() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(null);
		test.add(10);
		test.add(1);
		test.add(5);
		test.add(3);
		Node<Integer> curr = test.getHead();
		assertTrue("Node doesn't have the required data", curr.data == null);
		curr = curr.next;
		assertTrue("Node doesn't have the required data",
				curr.data.equals(new Integer(10)));
		assertTrue("Node doesn't have the required data",
				curr.prev.data == null);
		curr = curr.next;
		assertTrue("Node doesn't have the required data",
				curr.data.equals(new Integer(1)));
		assertTrue("Node doesn't have the required data",
				curr.prev.data.equals(new Integer(10)));
		curr = curr.next;
		assertTrue("Node doesn't have the required data",
				curr.data.equals(new Integer(5)));
		assertTrue("Node doesn't have the required data",
				curr.prev.data.equals(new Integer(1)));
		curr = curr.next;
		assertTrue("Node doesn't have the required data",
				curr.data.equals(new Integer(3)));
		assertTrue("Node doesn't have the required data",
				curr.prev.data.equals(new Integer(5)));
		curr = curr.prev;
		curr = curr.prev;
		curr = curr.prev;
		curr = curr.prev;
		assertTrue("Node doesn't have the required data", curr.data == null);
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testGetHead1() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(10);
		test.add(5);
		test.add(17);
		Node<Integer> curr = test.getHead();
		curr = curr.next;
		assertTrue("Node doesn't have the required data",
				curr.data.equals(new Integer(5)));
		assertTrue("Node doesn't have the required data",
				curr.prev.data.equals(new Integer(10)));
		assertTrue("Node doesn't have the required data",
				curr.next.data.equals(new Integer(17)));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testGetHead2() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(10);
		test.add(5);
		Node<Integer> curr = test.getHead();
		curr = curr.next;
		assertTrue("Node doesn't have the required data", curr.next == null);
		assertTrue("Node doesn't have the required data",
				curr.prev.data.equals(new Integer(10)));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testGetHead3() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(null);
		Node<Integer> curr = test.getHead();
		assertTrue("Node doesn't have the required data", curr.next == null);
		assertTrue("Node doesn't have the required data", curr.prev == null);
		assertTrue("Node doesn't have the required data", curr.data == null);
	}

	/*****************************************************/
	/****************** getTail() test ******************/
	/*****************************************************/

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testGetTail0() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(null);
		test.add(10);
		test.add(1);
		test.add(5);
		test.add(3);
		Node<Integer> curr = test.getTail();

		curr = curr.prev;
		curr = curr.prev;
		curr = curr.prev;
		curr = curr.prev;

		assertTrue("Node doesn't have the required data", curr.data == null);
		curr = curr.next;
		assertTrue("Node doesn't have the required data",
				curr.data.equals(new Integer(10)));
		assertTrue("Node doesn't have the required data",
				curr.prev.data == null);
		curr = curr.next;
		assertTrue("Node doesn't have the required data",
				curr.data.equals(new Integer(1)));
		assertTrue("Node doesn't have the required data",
				curr.prev.data.equals(new Integer(10)));
		curr = curr.next;
		assertTrue("Node doesn't have the required data",
				curr.data.equals(new Integer(5)));
		assertTrue("Node doesn't have the required data",
				curr.prev.data.equals(new Integer(1)));
		curr = curr.next;
		assertTrue("Node doesn't have the required data",
				curr.data.equals(new Integer(3)));
		assertTrue("Node doesn't have the required data",
				curr.prev.data.equals(new Integer(5)));

	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testGetTail1() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(10);
		test.add(5);
		test.add(17);
		Node<Integer> curr = test.getTail();
		curr = curr.prev;
		assertTrue("Node doesn't have the required data",
				curr.data.equals(new Integer(5)));
		assertTrue("Node doesn't have the required data",
				curr.prev.data.equals(new Integer(10)));
		assertTrue("Node doesn't have the required data",
				curr.next.data.equals(new Integer(17)));
	}

	@Test(timeout = 2000)
	public void testGetTail2() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(10);
		test.add(5);
		Node<Integer> curr = test.getTail();
		curr = curr.prev;
		assertTrue("Node doesn't have the required data", curr.prev == null);
		assertTrue("Node doesn't have the required data",
				curr.next.data.equals(new Integer(5)));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testGetTail3() {
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(null);
		Node<Integer> curr = test.getTail();
		assertTrue("Node doesn't have the required data", curr.next == null);
		assertTrue("Node doesn't have the required data", curr.prev == null);
		assertTrue("Node doesn't have the required data", curr.data == null);
	}

	/*****************************************************/
	/****************** replaceUsingHead() test ******************/
	/*****************************************************/

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testReplaceUsingHead0() {
		LinkedList<Integer> newtest = new LinkedList<Integer>();
		newtest.add(0);
		newtest.add(1);
		newtest.add(2);
		newtest.add(3);
		newtest.add(4);
		newtest.add(5);
		newtest.add(6);
		newtest.add(null);
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(10);
		test.add(5);
		test.add(17);
		test.add(9);
		test.add(59);
		test.add(177);
		test.add(null);

		test.replaceUsingHead(newtest.getHead());

		assertTrue("replaceUsingHead() didn't work", test.size() == 8);
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testReplaceUsingHead1() {
		LinkedList<Integer> newtest = new LinkedList<Integer>();
		newtest.add(0);
		newtest.add(1);
		newtest.add(2);
		newtest.add(3);
		newtest.add(4);
		newtest.add(5);
		newtest.add(6);
		newtest.add(null);
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(10);
		test.add(5);
		test.add(17);
		test.add(9);
		test.add(59);
		test.add(177);
		test.add(null);

		test.replaceUsingHead(newtest.getHead());

		assertTrue("replaceUsingHead() didn't work",
				test.getFirst().equals(new Integer(0)));
		assertTrue("replaceUsingHead() didn't work", test.getLast() == null);
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testReplaceUsingHead2() {
		LinkedList<Integer> newtest = new LinkedList<Integer>();
		newtest.add(0);
		newtest.add(1);
		newtest.add(2);
		newtest.add(3);
		newtest.add(4);
		newtest.add(5);
		newtest.add(6);
		newtest.add(null);
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(10);
		test.add(5);
		test.add(17);
		test.add(9);
		test.add(59);
		test.add(177);
		test.add(null);

		test.replaceUsingHead(newtest.getHead());

		assertTrue("replaceUsingHead() didn't work",
				test.get(0).equals(new Integer(0)));
		assertTrue("replaceUsingHead() didn't work",
				test.get(4).equals(new Integer(4)));
		assertTrue("replaceUsingHead() didn't work",
				test.get(test.size() - 1) == null);
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testReplaceUsingHead3() {
		LinkedList<Integer> newtest = new LinkedList<Integer>();
		newtest.add(0);
		newtest.add(1);
		newtest.add(2);
		newtest.add(3);
		newtest.add(4);
		newtest.add(5);
		newtest.add(6);
		newtest.add(null);
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(10);
		test.add(5);
		test.add(17);
		test.add(9);
		test.add(59);
		test.add(177);
		test.add(null);

		test.replaceUsingHead(newtest.getHead());

		assertTrue("replaceUsingHead() didn't work",
				test.contains(new Integer(0)));
		assertTrue("replaceUsingHead() didn't work",
				test.contains(new Integer(1)));
		assertTrue("replaceUsingHead() didn't work",
				test.contains(new Integer(2)));
		assertTrue("replaceUsingHead() didn't work",
				test.contains(new Integer(3)));
		assertTrue("replaceUsingHead() didn't work",
				test.contains(new Integer(4)));
		assertTrue("replaceUsingHead() didn't work",
				test.contains(new Integer(5)));
		assertTrue("replaceUsingHead() didn't work",
				test.contains(new Integer(6)));
		assertTrue("replaceUsingHead() didn't work", test.contains(null));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testReplaceUsingHead4() {
		LinkedList<Integer> newtest = new LinkedList<Integer>();
		newtest.add(1);
		newtest.add(2);
		newtest.add(3);
		newtest.add(5);
		newtest.add(6, newtest.size());
		newtest.add(null);
		newtest.add(0, 0);
		newtest.add(4, 4);
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(10);
		test.add(5);
		test.add(17);
		test.add(9);
		test.add(59);
		test.add(177);
		test.add(null);

		test.replaceUsingHead(newtest.getHead());

		assertTrue("replaceUsingHead() didn't work",
				test.get(0).equals(new Integer(0)));
		assertTrue("replaceUsingHead() didn't work",
				test.get(4).equals(new Integer(4)));
		assertTrue("replaceUsingHead() didn't work",
				test.get(6).equals(new Integer(6)));
		assertTrue("replaceUsingHead() didn't work",
				test.get(test.size() - 1) == null);
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testReplaceUsingHead5() {
		LinkedList<Integer> newtest = new LinkedList<Integer>();
		newtest.add(1);
		newtest.add(2);
		newtest.add(3);
		newtest.add(5);
		newtest.add(6, newtest.size());
		newtest.add(null);
		newtest.add(0, 0);
		newtest.add(4, 4);
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(10);
		test.add(5);
		test.add(17);
		test.add(9);
		test.add(59);
		test.add(177);
		test.add(null);

		test.replaceUsingHead(newtest.getHead());

		assertTrue("replaceUsingHead() didn't work", test.contains(0));
		assertTrue("replaceUsingHead() didn't work", test.contains(4));
		assertTrue("replaceUsingHead() didn't work", test.contains(6));
		assertTrue("replaceUsingHead() didn't work", test.contains(null));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testReplaceUsingHead6() {
		LinkedList<Integer> newtest = new LinkedList<Integer>();
		addMany(500, newtest);
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(10);
		test.add(5);
		test.add(17);
		test.add(9);
		test.add(59);
		test.add(177);
		test.add(null);

		test.replaceUsingHead(newtest.getHead());

		assertTrue("replaceUsingHead() didn't work",
				test.getHead().data.equals(newtest.getHead().data));
		assertTrue("replaceUsingHead() didn't work",
				test.getTail().data.equals(newtest.getTail().data));
	}

	/*****************************************************/
	/****************** replaceUsingTail() test ******************/
	/*****************************************************/

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testReplaceUsingTail1() {
		LinkedList<Integer> newtest = new LinkedList<Integer>();
		newtest.add(0);
		newtest.add(1);
		newtest.add(2);
		newtest.add(3);
		newtest.add(4);
		newtest.add(5);
		newtest.add(6);
		newtest.add(null);
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(10);
		test.add(5);
		test.add(17);
		test.add(9);
		test.add(59);
		test.add(177);
		test.add(null);

		test.replaceUsingTail(newtest.getTail());

		assertTrue("replaceUsingHead() didn't work", test.size() == 8);
		assertTrue("replaceUsingHead() didn't work",
				test.getFirst().equals(new Integer(0)));
		assertTrue("replaceUsingHead() didn't work", test.getLast() == null);
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testReplaceUsingTail2() {
		LinkedList<Integer> newtest = new LinkedList<Integer>();
		newtest.add(0);
		newtest.add(1);
		newtest.add(2);
		newtest.add(3);
		newtest.add(4);
		newtest.add(5);
		newtest.add(6);
		newtest.add(null);
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(10);
		test.add(5);
		test.add(17);
		test.add(9);
		test.add(59);
		test.add(177);
		test.add(null);

		test.replaceUsingTail(newtest.getTail());

		assertTrue("replaceUsingHead() didn't work",
				test.get(0).equals(new Integer(0)));
		assertTrue("replaceUsingHead() didn't work",
				test.get(4).equals(new Integer(4)));
		assertTrue("replaceUsingHead() didn't work",
				test.get(test.size() - 1) == null);
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testReplaceUsingTail3() {
		LinkedList<Integer> newtest = new LinkedList<Integer>();
		newtest.add(0);
		newtest.add(1);
		newtest.add(2);
		newtest.add(3);
		newtest.add(4);
		newtest.add(5);
		newtest.add(6);
		newtest.add(null);
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(10);
		test.add(5);
		test.add(17);
		test.add(9);
		test.add(59);
		test.add(177);
		test.add(null);

		test.replaceUsingTail(newtest.getTail());

		assertTrue("replaceUsingHead() didn't work",
				test.contains(new Integer(0)));
		assertTrue("replaceUsingHead() didn't work",
				test.contains(new Integer(1)));
		assertTrue("replaceUsingHead() didn't work",
				test.contains(new Integer(2)));
		assertTrue("replaceUsingHead() didn't work",
				test.contains(new Integer(3)));
		assertTrue("replaceUsingHead() didn't work",
				test.contains(new Integer(4)));
		assertTrue("replaceUsingHead() didn't work",
				test.contains(new Integer(5)));
		assertTrue("replaceUsingHead() didn't work",
				test.contains(new Integer(6)));
		assertTrue("replaceUsingHead() didn't work", test.contains(null));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testReplaceUsingTail4() {
		LinkedList<Integer> newtest = new LinkedList<Integer>();
		newtest.add(1);
		newtest.add(2);
		newtest.add(3);
		newtest.add(5);
		newtest.add(6, newtest.size());
		newtest.add(null);
		newtest.add(0, 0);
		newtest.add(4, 4);
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(10);
		test.add(5);
		test.add(17);
		test.add(9);
		test.add(59);
		test.add(177);
		test.add(null);

		test.replaceUsingTail(newtest.getTail());

		assertTrue("replaceUsingHead() didn't work",
				test.get(0).equals(new Integer(0)));
		assertTrue("replaceUsingHead() didn't work",
				test.get(4).equals(new Integer(4)));
		assertTrue("replaceUsingHead() didn't work",
				test.get(6).equals(new Integer(6)));
		assertTrue("replaceUsingHead() didn't work",
				test.get(test.size() - 1) == null);
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testReplaceUsingTail5() {
		LinkedList<Integer> newtest = new LinkedList<Integer>();
		newtest.add(1);
		newtest.add(2);
		newtest.add(3);
		newtest.add(5);
		newtest.add(6, newtest.size());
		newtest.add(null);
		newtest.add(0, 0);
		newtest.add(4, 4);
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(10);
		test.add(5);
		test.add(17);
		test.add(9);
		test.add(59);
		test.add(177);
		test.add(null);

		test.replaceUsingTail(newtest.getTail());

		assertTrue("replaceUsingHead() didn't work", test.contains(0));
		assertTrue("replaceUsingHead() didn't work", test.contains(4));
		assertTrue("replaceUsingHead() didn't work", test.contains(6));
		assertTrue("replaceUsingHead() didn't work", test.contains(null));
	}

	// @Worth(points=1)
	@Test(timeout = 2000)
	public void testReplaceUsingTail6() {
		LinkedList<Integer> newtest = new LinkedList<Integer>();
		addMany(500, newtest);
		LinkedList<Integer> test = new LinkedList<Integer>();
		test.add(10);
		test.add(5);
		test.add(17);
		test.add(9);
		test.add(59);
		test.add(177);
		test.add(null);

		test.replaceUsingTail(newtest.getTail());

		assertTrue("replaceUsingHead() didn't work",
				test.getHead().data.equals(newtest.getHead().data));
		assertTrue("replaceUsingHead() didn't work",
				test.getTail().data.equals(newtest.getTail().data));
	}

	/*********************************************/
	/***************** Helper Methods **************/
	/*********************************************/

	private void addMany(int num, List<Integer> arr) {
		for (int i = 0; i <= num; i++) {
			arr.add(i, i);
		}
	}

	private static class Thing {
		private static int timer = 0;

		private int time;
		private int value;

		private Thing(int value) {
			this.time = timer++;
			this.value = value;
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Thing) {
				return value == ((Thing) o).value;
			}
			return false;
		}

		@Override
		public int hashCode() {
			return value;
		}
	}
}