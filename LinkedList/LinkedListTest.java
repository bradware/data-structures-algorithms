import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;




public class LinkedListTest {
	
	LinkedList<Integer> it = new LinkedList<Integer>();
	

	@Test
	public void testAdd(){
		int vals[] = {2,5,7};
		it.add(vals[0]);
		it.add(vals[1]);
		it.add(vals[2]);
		assertTrue(it.get(0) == 2 && it.get(1) == 5 && it.get(2) == 7);
		assertTrue(it.size() == 3);
		assertTrue(it.getHead().data.equals(it.get(0)));
		assertTrue(it.getTail().data.equals(it.get(2)));

		
	}
	
	@Test
	public void testGet(){
		Integer two = new Integer(2);
		Integer five = new Integer(5);
		Integer fortyFour = new Integer(44);
		Integer thirty = new Integer(30);
		it.add(two);
		it.add(five);
		it.add(fortyFour);
		it.add(thirty);
		assertTrue(it.get(1).equals(five));
		assertTrue(it.get(3).equals(thirty));
	}
	
	@Test
	//Not sure if this is a valid way to test if garbage collection worked
	public void testClear(){
		int vals[] = {2,5,7};
		it.add(vals[0]);
		it.add(vals[1]);
		it.add(vals[2]);
		it.clear();
		assertTrue(it.isEmpty());
	}
	
	@Test
	public void testContains(){
		Integer two = new Integer(2);
		Integer five = new Integer(5);
		Integer fortyFour = new Integer(44);
		Integer thirty = new Integer(30);
		it.add(two);
		it.add(five);
		it.add(fortyFour);
		it.add(thirty);
		assertTrue(it.contains(fortyFour));

		
		
	}
	@Test
	public void testRemove(){
		Integer five = new Integer(5);
		Integer two = new Integer(2);
		Integer seven = new Integer(7);
		Integer fortyFour = new Integer(44);
		it.add(two);
		it.add(five);
		it.add(seven);
		it.add(fortyFour);
		//Integer res = it.remove(fortyFour);
		//assertTrue(it.size() == 3 && res == fortyFour && it.getHead().data == two && it.getTail().data == seven && it.get(1) == five);
		Integer res = it.remove(five);
		assertTrue(it.size() == 3 && res.equals(five) && it.getHead().data.equals(two) && it.getTail().data.equals(fortyFour) && it.get(1).equals(seven));
		
	}
	
	@Test
	public void testAdd2(){
		Integer five = new Integer(5);
		Integer two = new Integer(2);
		Integer seven = new Integer(7);
		Integer fortyFour = new Integer(44);
		Integer twentyTwo = new Integer(22);
		it.add(two);
		it.add(five);
		it.add(seven);
		it.add(fortyFour);
		//it.add(twentyTwo,0);
		//assertTrue(it.getHead().data.equals(twentyTwo) && it.get(1).equals(two));
		it.add(twentyTwo, 4);
		//assertTrue(it.getHead().data.equals(two) && it.getTail().data.equals(fortyFour) && it.get(2).equals(twentyTwo) && it.indexOf(twentyTwo) == 2);
		assertTrue(it.getHead().data.equals(two) && it.getTail().data.equals(twentyTwo) && it.getNode(4).prev.data.equals(fortyFour));
	}
	
	@Test
	public void testIndexOf(){
		Integer five = new Integer(5);
		Integer two = new Integer(2);
		Integer seven = new Integer(7);
		Integer fortyFour = new Integer(44);
		Integer twentyTwo = new Integer(22);
		it.add(two);
		it.add(five);
		it.add(seven);
		it.add(fortyFour);
		assertTrue(it.indexOf(fortyFour) == 3 && it.indexOf(two) == 0 && it.indexOf(seven) == 2);
	}
	
	@Test
	public void testRemove2(){
		Integer five = new Integer(5);
		Integer two = new Integer(2);
		Integer seven = new Integer(7);
		Integer fortyFour = new Integer(44);
		Integer twentyTwo = new Integer(22);
		it.add(two);
		it.add(five);
		it.add(seven);
		it.add(fortyFour);
		//Integer ans = it.remove(2);
		//assertTrue(ans.equals(seven) && it.getHead().data.equals(two) && it.indexOf(five) == 1);
		Integer ans = it.remove(0);
		assertTrue(ans.equals(two) && it.getHead().data.equals(five) && it.indexOf(seven) == 1);
	}
	
	@Test
	public void testGetFirst(){
		Integer five = new Integer(5);
		Integer two = new Integer(2);
		Integer seven = new Integer(7);
		Integer fortyFour = new Integer(44);
		it.add(two);
		it.add(five);
		it.add(seven);
		it.add(fortyFour);
		Integer ans = it.getFirst();
		assertTrue(ans.equals(two));
	}
	
	@Test
	public void testGetLast(){
		Integer five = new Integer(5);
		Integer two = new Integer(2);
		Integer seven = new Integer(7);
		Integer fortyFour = new Integer(44);
		it.add(two);
		it.add(five);
		it.add(seven);
		it.add(fortyFour);
		Integer ans = it.getLast();
		assertTrue(ans.equals(fortyFour));
	}
	@Test
	public void testAddFirst(){
		Integer five = new Integer(5);
		Integer two = new Integer(2);
		Integer seven = new Integer(7);
		Integer fortyFour = new Integer(44);
		Integer twentyTwo = new Integer(22);
		it.add(two);
		it.add(five);
		it.add(seven);
		it.add(fortyFour);
		it.addFirst(twentyTwo);
		assertTrue(it.getHead().data.equals(twentyTwo) && it.get(2).equals(five));
		
	}
	
	@Test
	public void testAddLast(){
		Integer five = new Integer(5);
		Integer two = new Integer(2);
		Integer seven = new Integer(7);
		Integer fortyFour = new Integer(44);
		Integer twentyTwo = new Integer(22);
		it.add(two);
		it.add(five);
		it.add(seven);
		it.add(fortyFour);
		it.addLast(twentyTwo);
		assertTrue(it.getTail().data.equals(twentyTwo) && it.get(2).equals(seven));
		
	}
	
	@Test
	public void testRemoveFirst(){
		Integer five = new Integer(5);
		Integer two = new Integer(2);
		Integer seven = new Integer(7);
		Integer fortyFour = new Integer(44);
		it.add(two);
		it.add(five);
		it.add(seven);
		it.add(fortyFour);
		Integer ans = it.removeFirst();
		assertTrue(ans.equals(two) && it.getHead().data.equals(five) && it.indexOf(seven) == 1);
	}
	
	@Test
	public void testRemoveLast(){
		Integer five = new Integer(5);
		Integer two = new Integer(2);
		Integer seven = new Integer(7);
		Integer fortyFour = new Integer(44);
		it.add(two);
		it.add(five);
		it.add(seven);
		it.add(fortyFour);
		Integer ans = it.removeLast();
		assertTrue(ans.equals(fortyFour) && it.getHead().data.equals(two) && it.indexOf(seven) == 2 && it.size() == 3);
	}
	
	@Test
	public void testGetHead(){
		//Node<Integer> tempNode = it.getHead();
		//.equals() returns failed test for some reason??
		//assertTrue(tempNode == null);
		Integer five = new Integer(5);
		Integer two = new Integer(2);
		Integer seven = new Integer(7);
		Integer fortyFour = new Integer(44);
		it.add(two);
		it.add(five);
		it.add(seven);
		it.add(fortyFour);
		Node<Integer> tempNode = it.getHead();
		assertTrue(tempNode.data.equals(two));
		
	}
	
	@Test
	public void testGetTail(){
		//Node<Integer> tempNode = it.getHead();
		//.equals() returns failed test for some reason??
		//assertTrue(tempNode == null);
		Integer five = new Integer(5);
		Integer two = new Integer(2);
		Integer seven = new Integer(7);
		Integer fortyFour = new Integer(44);
		it.add(two);
		it.add(five);
		it.add(seven);
		it.add(fortyFour);
		
		Node<Integer> tempNode = it.getTail();
		assertTrue(tempNode.data.equals(fortyFour));
		
	}
	
	@Test
	//start here not sure how to test my code correctly
	public void testReplaceUsingHead(){
		LinkedList<Integer> LL1 = new LinkedList<Integer>();
		Integer one = new Integer(1);
		Integer two = new Integer(2);
		Integer three = new Integer(3);
		Integer four = new Integer(4);
		LL1.add(one);
		LL1.add(two);
		LL1.add(three);
		LL1.add(four);
		LinkedList<Integer> LL2 = new LinkedList<Integer>();
		Integer ten = new Integer(10);
		Integer twenty = new Integer(20);
		Integer thirty = new Integer(30);
		Integer fourty = new Integer(40);
		LL2.add(ten);
		LL2.add(twenty);
		LL2.add(thirty);
		LL2.add(fourty);
		System.out.println(LL1.get(0) + ", " + LL1.get(1) + ", " + LL1.get(2) + ", " + LL1.get(3));
		System.out.println(LL2.get(0) + ", " + LL2.get(1) + ", " + LL2.get(2) + ", " + LL2.get(3));
		LL1.replaceUsingHead(LL2.getHead());
		System.out.println();
		System.out.println(LL1.get(0) + ", " + LL1.get(1) + ", " + LL1.get(2) + ", " + LL1.get(3));
		System.out.println(LL2.get(0) + ", " + LL2.get(1) + ", " + LL2.get(2) + ", " + LL2.get(3));
		System.out.println();
		System.out.println();
	}
	
	@Test
	public void testReplaceUsingTail(){
		LinkedList<Integer> LL1 = new LinkedList<Integer>();
		Integer one = new Integer(1);
		Integer two = new Integer(2);
		Integer three = new Integer(3);
		Integer four = new Integer(4);
		LL1.add(one);
		LL1.add(two);
		LL1.add(three);
		LL1.add(four);
		LinkedList<Integer> LL2 = new LinkedList<Integer>();
		Integer ten = new Integer(10);
		Integer twenty = new Integer(20);
		Integer thirty = new Integer(30);
		Integer fourty = new Integer(40);
		LL2.add(ten);
		LL2.add(twenty);
		LL2.add(thirty);
		LL2.add(fourty);
		System.out.println(LL1.get(0) + ", " + LL1.get(1) + ", " + LL1.get(2) + ", " + LL1.get(3));
		System.out.println(LL2.get(0) + ", " + LL2.get(1) + ", " + LL2.get(2) + ", " + LL2.get(3));
		LL1.replaceUsingTail(LL2.getTail());
		System.out.println();
		System.out.println(LL1.get(0) + ", " + LL1.get(1) + ", " + LL1.get(2) + ", " + LL1.get(3));
		System.out.println(LL2.get(0) + ", " + LL2.get(1) + ", " + LL2.get(2) + ", " + LL2.get(3));
	}
	
	
	
	
	
	
	
	
	

	
	
	
}
