
import static org.junit.Assert.assertEquals;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import org.junit.Test;



public class AVLJUnitTest {
	/**
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testAdd1(){
		System.out.println("Test add1");
		AVLTree tree1 = new AVLTree();
		tree1.add(new Integer(17));		//LEFT TEST
		tree1.add(new Integer(24));
		tree1.add(new Integer(35));
		//tree1.add(null);
		ArrayList<Integer> answer = (ArrayList<Integer>)tree1.inOrder();
		for(Integer current: answer){
			System.out.print(current + ", ");
		}
		System.out.println("root: " + tree1.getHead());
		System.out.println();
		tree1.displayTree();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testAdd2(){
		System.out.println("Test add2");
		AVLTree tree1 = new AVLTree();
		tree1.add(new Integer(17));
		tree1.add(new Integer(-24));		//RIGHTTEST
		tree1.add(new Integer(35));
		tree1.displayTree();
		tree1.add(new Integer(-48));
		tree1.add(new Integer(-54));
		ArrayList<Integer> answer = (ArrayList<Integer>)tree1.inOrder();
		for(Integer current: answer){
			System.out.print(current + ", ");
		}
		System.out.println("root: " + tree1.getHead());
		System.out.println();
		tree1.displayTree();
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testAdd3(){
		System.out.println("Test add3");
		AVLTree tree1 = new AVLTree();
		tree1.add(new Integer(17));
		tree1.add(new Integer(9));
		tree1.add(new Integer(5));			//LEFTRIGHT TEST
		tree1.add(new Integer(4));
		tree1.displayTree();
		tree1.add(new Integer(3));
		tree1.displayTree();
		tree1.add(new Integer(8));
		tree1.displayTree();
		tree1.add(new Integer(7));
		ArrayList<Integer> answer = (ArrayList<Integer>)tree1.inOrder();
		for(Integer current: answer){
			System.out.print(current + ", ");
		}
		System.out.println("root: " + tree1.getHead());
		System.out.println();
		tree1.displayTree();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testAdd4(){
		System.out.println("Test add4");
		AVLTree tree1 = new AVLTree();
		tree1.add(new Integer(17));
		tree1.add(new Integer(9));
		tree1.add(new Integer(5));			////RIGHTLEFT TEST
		tree1.add(new Integer(20));
		tree1.displayTree();
		tree1.add(new Integer(24));
		tree1.displayTree();

		tree1.add(new Integer(16));
		tree1.add(new Integer(15));
		ArrayList<Integer> answer = (ArrayList<Integer>)tree1.inOrder();
		for(Integer current: answer){
			System.out.print(current + ", ");
		}
		System.out.println("root: " + tree1.getHead());
		System.out.println();
		tree1.displayTree();
	}
	
	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testAdd5(){
		System.out.println("Test add5");
		AVLTree tree1 = new AVLTree();		
		tree1.add(new Integer(10));
		tree1.add(new Integer(20));
		tree1.add(new Integer(30));				//LEFTTEST, 
		tree1.add(new Integer(40));
		tree1.displayTree();

		tree1.add(new Integer(50));
		tree1.displayTree();

		tree1.add(new Integer(60));
		int listSize = tree1.size();
		//ASK HOW TO TEST CONTAINS
		//boolean shouldBeTrue = tree1.getRoot().contains(new Integer(68));

		ArrayList<Integer> answer = (ArrayList<Integer>)tree1.inOrder();
		for(Integer current: answer){
			System.out.print(current + ", ");
		}
		System.out.println("root: " + tree1.getHead());
		System.out.println(listSize);
		//System.out.println(shouldBeTrue);
		System.out.println();
		tree1.displayTree();

	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testAdd6(){
		System.out.println("Test add6");
		AVLTree tree1 = new AVLTree();
		tree1.add(new Integer(-17));
		tree1.add(new Integer(-24));
		tree1.add(new Integer(-35));
		tree1.add(new Integer(-40));
		tree1.displayTree();

		tree1.add(new Integer(-50));
		tree1.displayTree();
		tree1.add(new Integer(-21));
		tree1.add(new Integer(-18));
		tree1.add(new Integer(-20));
		ArrayList<Integer> answer = (ArrayList<Integer>)tree1.inOrder();
		for(Integer current: answer){
			System.out.print(current + ", ");
		}
		System.out.println("root: " + tree1.getHead());
		System.out.println();
		tree1.displayTree();
		
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testRemove1(){
		System.out.println("Test remove1");
		AVLTree tree1 = new AVLTree();
		tree1.add(new Integer(17));
		tree1.add(new Integer(24));		//REMOVEROOT
		tree1.add(new Integer(35));
		tree1.displayTree();
		System.out.println();
		System.out.println("Now Removing");
		tree1.remove(new Integer(24));
		tree1.displayTree();
		System.out.println();
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testRemove2(){
		System.out.println("Test remove2");
		AVLTree tree1 = new AVLTree();
		tree1.add(new Integer(17));
		tree1.add(new Integer(-24));		//1 CHILD - LEFT
		tree1.add(new Integer(35));
		tree1.add(new Integer(-48));
		tree1.add(new Integer(54));
		tree1.displayTree();
		System.out.println("Now Removing");
		tree1.remove(new Integer(-24));
		tree1.displayTree();
		System.out.println();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testRemove3(){
		System.out.println("Test remove3");
		AVLTree tree1 = new AVLTree();
		tree1.add(new Integer(17));
		tree1.add(new Integer(9));
		tree1.add(new Integer(5));		
		tree1.add(new Integer(4));
		tree1.add(new Integer(3));		//ROOT
		tree1.add(new Integer(8));
		tree1.add(new Integer(7));
		tree1.displayTree();
		System.out.println();
		System.out.println("Now removing");
		tree1.remove(new Integer(5));//reset to 5
		tree1.displayTree();
		tree1.remove(tree1.getHead());
		tree1.displayTree();
		System.out.println();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void removeAdd4(){
		System.out.println("Test remove4");
		AVLTree tree1 = new AVLTree();
		tree1.add(new Integer(17));
		tree1.add(new Integer(9));
		tree1.add(new Integer(5));		//ROOT
		tree1.add(new Integer(20));
		tree1.add(new Integer(24));
		tree1.add(new Integer(16));
		tree1.add(new Integer(15));
		tree1.add(new Integer(19));
		tree1.displayTree();
		tree1.add(new Integer(0));
		tree1.add(new Integer(-2));
		tree1.add(new Integer(-4));
		tree1.displayTree();
		System.out.println("Now removing");
		tree1.remove(tree1.getHead());
		tree1.displayTree();
		System.out.println();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testremove5(){
		System.out.println("Test remove5");
		AVLTree tree1 = new AVLTree();
		tree1.add(new Integer(10));
		tree1.add(new Integer(20));
		tree1.add(new Integer(30));
		tree1.add(new Integer(40));
		tree1.add(new Integer(50));
		tree1.add(new Integer(60));
		int listSize = tree1.size();
		//ASK HOW TO TEST CONTAINS
		boolean shouldBeFalse = tree1.contains(new Integer(68));
		System.out.println(listSize);
		System.out.println(shouldBeFalse);
		tree1.displayTree();
		System.out.println("Now removing");
		tree1.remove(new Integer(60));
		tree1.displayTree();
		tree1.remove(tree1.getHead());
		tree1.displayTree();
		System.out.println();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testremove6(){
		System.out.println("Test remove6 -- try removing a number not in the tree");
		AVLTree tree1 = new AVLTree();
		tree1.add(new Integer(-17));
		tree1.add(new Integer(-24));
		tree1.add(new Integer(-35));
		tree1.add(new Integer(-40));
		tree1.add(new Integer(-50));
		tree1.add(new Integer(-21));
		tree1.add(new Integer(-18));
		tree1.add(new Integer(-20));
		System.out.println(tree1.contains(-17));
		tree1.displayTree();
		System.out.println();
		System.out.println("Now removing");
		tree1.remove(-18);
		boolean shouldBeFalse = tree1.remove(new Integer(432));
		System.out.println("Should be false: " + shouldBeFalse);
		tree1.displayTree();
		ArrayList<Integer> answer = (ArrayList<Integer>)tree1.inOrder();
		for(Integer current: answer){
			System.out.print(current + ", ");
		}
		System.out.println("Clearing tree");
		tree1.clear();
		tree1.displayTree();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testremove7(){
		System.out.println("Test remove 7 -- removing from empty list");
		AVLTree tree1 = new AVLTree();
		tree1.displayTree();
		System.out.println();
		System.out.println("Now removing");
		boolean shouldBeFalse = tree1.remove(-18);
		System.out.println("Should be false: " + shouldBeFalse);
		tree1.displayTree();
		System.out.println("In Order Traversal");
		ArrayList<Integer> answer = (ArrayList<Integer>)tree1.inOrder();
		for(Integer current: answer){
			System.out.print(current + ", ");
		}
		
	}
	*/
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testAddFINAL(){
		System.out.println("Test addFInal -----");
		AVLTree tree1 = new AVLTree();
		tree1.add(new Integer(8));
		tree1.add(new Integer(32));
		tree1.add(new Integer(14));
		tree1.add(new Integer(45));
		tree1.add(new Integer(36));
		tree1.add(new Integer(12));
		tree1.add(new Integer(40));
		tree1.displayTree();
		tree1.remove(new Integer(12));
		tree1.displayTree();
		tree1.add(new Integer(3));
		tree1.displayTree();
		tree1.remove(tree1.getHead());
		tree1.displayTree();
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testRemoveNonExistingNodeinTree(){
		System.out.println();
		System.out.println("Test Remove on Non Existing Node in Tree -----");
		AVLTree tree1 = new AVLTree();
		tree1.add(new Integer(44));
		tree1.add(new Integer(66));	
		boolean shouldbeFalse = tree1.remove(null);
		boolean shouldAlsoBeFalse = tree1.remove(new Integer(3));
		tree1.displayTree();
		System.out.println("Should be false: " + shouldbeFalse);
		System.out.println("Should also be false: " + shouldAlsoBeFalse);
		System.out.println();
		
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testRemoveEmptyTree(){
		System.out.println();
		System.out.println("Test Remove on Empty tree -----");
		AVLTree tree1 = new AVLTree();
		boolean shouldBeFalse = tree1.remove(new Integer(76));
		tree1.displayTree();
		boolean shouldBeAlsoFalse = tree1.contains(new Integer(5));
		System.out.println("Should be false: " + shouldBeFalse);
		System.out.println("Should be also false: " + shouldBeAlsoFalse);
		System.out.println();
		
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testContainsEmptyTree(){
		System.out.println();
		System.out.println("Test 1 Contains Empty Tree -----");
		AVLTree tree1 = new AVLTree();
		tree1.displayTree();
		boolean shouldBeFalse = tree1.contains(new Integer(5));
		boolean shouldAlsoBeFalse = tree1.contains(null);
		System.out.println("Should be false: " + shouldBeFalse);
		System.out.println("Should also be false: " + shouldAlsoBeFalse);
		System.out.println();
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testTraversal1(){
		System.out.println("Test traversal 1 -----");
		AVLTree tree1 = new AVLTree();
		tree1.add(new Integer(8));
		tree1.add(new Integer(32));
		tree1.add(new Integer(14));
		tree1.add(new Integer(45));
		tree1.add(new Integer(36));
		tree1.add(new Integer(12));
		tree1.add(new Integer(40));
		tree1.displayTree();
		tree1.remove(new Integer(12));
		tree1.displayTree();
		tree1.add(new Integer(3));
		tree1.displayTree();
		tree1.remove(tree1.getHead());
		tree1.displayTree();
		ArrayList<Integer> answer = (ArrayList<Integer>)tree1.inOrder();
		for(Integer current: answer){
			System.out.print(current + ", ");
		}
		System.out.println();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testTraversal2(){
		System.out.println("Test traversal 2 on Empty Tree -----");
		AVLTree tree1 = new AVLTree();
		tree1.displayTree();
		tree1.add(new Integer(3));
		tree1.remove(tree1.getHead());
		tree1.displayTree();
		ArrayList<Integer> answer = (ArrayList<Integer>)tree1.inOrder();
		for(Integer current: answer){
			System.out.print(current + ", ");
		}
	}
		
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testTraversal3(){
		System.out.println("Test traversal 3 on 1 Node in Tree -----");
		AVLTree tree1 = new AVLTree();
		tree1.displayTree();
		tree1.add(new Integer(3));
		tree1.displayTree();
		ArrayList<Integer> answer = (ArrayList<Integer>)tree1.inOrder();
		for(Integer current: answer){
			System.out.print(current + ", ");
		}
	}
		

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Test
		public void testRemovingSuccessor1(){
			System.out.println("Test remove Successor 1 -----"); //Right Side , Left Rotation
			AVLTree tree1 = new AVLTree();
			tree1.add(new Integer(40));
			tree1.add(new Integer(20));
			tree1.add(new Integer(15));
			tree1.add(new Integer(75));
			tree1.add(new Integer(0));
			tree1.add(new Integer(1));
			tree1.add(new Integer(-12));
			tree1.add(new Integer(24));
			tree1.add(new Integer(42));
			tree1.add(new Integer(66));
			tree1.add(new Integer(14));
			tree1.add(new Integer(70));
			tree1.add(new Integer(21));
			tree1.displayTree();
			tree1.remove(new Integer(66));
			tree1.displayTree();
			tree1.remove(new Integer(70));
			tree1.displayTree();
			tree1.remove(new Integer(40));
			tree1.displayTree();
			ArrayList<Integer> answer = (ArrayList<Integer>)tree1.inOrder();
			for(Integer current: answer){
				System.out.print(current + ", ");
			}
		}
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Test
		public void testRemovingSuccessor2(){
			System.out.println("Test remove Successor 2 -----"); //Right Side , RightLeft Rotation
			AVLTree tree1 = new AVLTree();
			tree1.add(new Integer(40));
			tree1.add(new Integer(20));
			tree1.add(new Integer(15));
			tree1.add(new Integer(75));
			tree1.add(new Integer(0));
			tree1.add(new Integer(1));
			tree1.add(new Integer(-12));
			tree1.add(new Integer(44));
			tree1.add(new Integer(50));
			tree1.add(new Integer(66));
			tree1.add(new Integer(14));
			tree1.add(new Integer(70));
			tree1.displayTree();
			tree1.remove(new Integer(66));
			tree1.displayTree();
			tree1.remove(new Integer(70));
			tree1.displayTree();
			ArrayList<Integer> answer = (ArrayList<Integer>)tree1.inOrder();
			for(Integer current: answer){
				System.out.print(current + ", ");
			}
		}
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Test
		public void testRemovingSuccessor3(){
			System.out.println("Test remove Successor 3 -----"); //Left Side , Right Rotation
			AVLTree tree1 = new AVLTree();
			tree1.add(new Integer(40));
			tree1.add(new Integer(20));
			tree1.add(new Integer(15));
			tree1.add(new Integer(75));
			tree1.add(new Integer(0));
			tree1.add(new Integer(1));
			tree1.add(new Integer(-12));
			tree1.add(new Integer(44));
			tree1.add(new Integer(50));
			tree1.add(new Integer(66));
			tree1.add(new Integer(14));
			tree1.add(new Integer(-20));
			tree1.displayTree();
			tree1.remove(new Integer(1));
			tree1.displayTree();
			tree1.remove(new Integer(14));
			tree1.displayTree();
			ArrayList<Integer> answer = (ArrayList<Integer>)tree1.inOrder();
			for(Integer current: answer){
				System.out.print(current + ", ");
			}
		}
		
	
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Test
		public void testRemovingSuccessor4(){
			System.out.println("Test remove Successor 4-----"); //Left Side , LeftRight Rotation
			AVLTree tree1 = new AVLTree();
			tree1.add(new Integer(40));
			tree1.add(new Integer(20));
			tree1.add(new Integer(15));
			tree1.add(new Integer(75));
			tree1.add(new Integer(0));
			tree1.add(new Integer(1));
			tree1.add(new Integer(-12));
			tree1.add(new Integer(44));
			tree1.add(new Integer(50));
			tree1.add(new Integer(66));
			tree1.add(new Integer(14));
			tree1.add(new Integer(-20));
			tree1.displayTree();
			tree1.remove(new Integer(-20));
			tree1.displayTree();
			tree1.remove(new Integer(1));
			tree1.displayTree();
			tree1.remove(new Integer(14));
			tree1.displayTree();
			ArrayList<Integer> answer = (ArrayList<Integer>)tree1.inOrder();
			for(Integer current: answer){
				System.out.print(current + ", ");
			}
		}
		
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testRemovingSuccessorRoot1(){
		System.out.println("Test remove Root 1 -----"); 
		AVLTree tree1 = new AVLTree();
		tree1.add(3);
		tree1.add(2);
		tree1.add(61);
		tree1.add(75);
		tree1.add(26);
		tree1.add(24);
		tree1.add(18);
		tree1.add(90);
		tree1.add(new Integer(85));
		tree1.displayTree();
		tree1.remove(tree1.getHead());
		tree1.displayTree();
		ArrayList<Integer> answer = (ArrayList<Integer>)tree1.inOrder();
		for(Integer current: answer){
			System.out.print(current + ", ");
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testRemovingSuccessorRoot2(){
		System.out.println("Test remove Root 2 -----"); 
		AVLTree tree1 = new AVLTree();
		tree1.add(3);
		tree1.add(2);
		tree1.add(61);
		tree1.add(75);
		tree1.add(26);
		tree1.add(24);
		tree1.add(18);
		tree1.add(90);
		tree1.add(92);
		tree1.displayTree();
		tree1.remove(tree1.getHead());
		tree1.displayTree();
		tree1.remove(92);
		tree1.displayTree();
		tree1.remove(tree1.getHead());
		tree1.displayTree();
		ArrayList<Integer> answer = (ArrayList<Integer>)tree1.inOrder();
		for(Integer current: answer){
			System.out.print(current + ", ");
		}
	}
	
	
	
}
