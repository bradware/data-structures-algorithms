import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class BSTTest {
	//Methods that work
	
	//1) add tested pretty well
	//2) remove tested pretty well
	//3) addAll is good
	//4) getSuccessor works well
	//5) All 3 traversal methods work
	//6) 
	
	
	BST bst1;
	Integer[] vals = {};

	
	//@Test
	
	public void testAdd() {

		bst1 = new BST();
		ArrayList<Integer> myList = new ArrayList<Integer>();
		for(int i =0; i < vals.length; i++){
			bst1.add(vals[i]);
		}
		//bst1.displayTree();
		myList = (ArrayList<Integer>)bst1.preOrder();
		for(Integer current: myList){
			System.out.print(current + ", ");
		}
		System.out.println();
		System.out.println("size: " + bst1.size());
		bst1.add(-88);
		bst1.add(200);
		myList = (ArrayList<Integer>)bst1.inOrder();
		System.out.println("New Tree:");
		for(Integer current: myList){
			System.out.print(current + ", ");
		}
		System.out.println();
		System.out.println("size: " + bst1.size());
		boolean contains = bst1.contains(-8);
		System.out.println("Contains: " + contains);
		//Integer removed = (Integer)bst1.remove(25);
		//System.out.println("Removed:" + removed);
		//System.out.println("size: " + bst1.size());
		//myList = (ArrayList<Integer>) bst1.preOrder();
		//for(Integer current: myList){
			//System.out.print(current + ", ");
		//}
	}
	
	/**
	@Test
	public void testRemove(){
		bst1 = new BST();
		ArrayList<Integer> myList = new ArrayList<Integer>();
		for(int i =0; i < vals.length; i++){
			bst1.add(vals[i]);
		}
		//bst1.displayTree();
		myList = (ArrayList<Integer>)bst1.preOrder();
		for(Integer current: myList){
			System.out.print(current + ", ");
		}
		System.out.println();
		System.out.println("size: " + bst1.size());
		boolean contains = bst1.contains(0);
		System.out.println("Contains: " + contains);
		Integer removed = (Integer)bst1.remove(50);
		System.out.println("Removed:" + removed);
		myList = (ArrayList<Integer>) bst1.preOrder();
		for(Integer current: myList){
			System.out.print(current + ", ");
		}//new removed number
		System.out.println();
		Integer removed1 = (Integer)bst1.remove(65);
		System.out.println("Removed:" + removed1);
		myList = (ArrayList<Integer>) bst1.preOrder();
		for(Integer current: myList){
			System.out.print(current + ", ");
		}//next removed number
		System.out.println();

		Integer removed2 = (Integer)bst1.remove(75);
		System.out.println("Removed:" + removed2);
		myList = (ArrayList<Integer>) bst1.preOrder();
		for(Integer current: myList){
			System.out.print(current + ", ");
		}//next number removed
		System.out.println();
		Integer removed3 = (Integer)bst1.remove(68);
		System.out.println("Removed:" + removed3);
		myList = (ArrayList<Integer>) bst1.preOrder();
		for(Integer current: myList){
			System.out.print(current + ", ");
		}//next number removed
		System.out.println();

		Integer removed4 = (Integer)bst1.remove(5);
		System.out.println("Removed:" + removed4);
		myList = (ArrayList<Integer>) bst1.preOrder();
		for(Integer current: myList){
			System.out.print(current + ", ");
		}//next number removed
		System.out.println();

		Integer removed5 = (Integer)bst1.remove(Integer.MIN_VALUE);
		System.out.println("Removed:" + removed5);
		myList = (ArrayList<Integer>) bst1.preOrder();
		for(Integer current: myList){
			System.out.print(current + ", ");
		}//next number removed
		System.out.println();

		Integer removed6 = (Integer)bst1.remove(0);
		System.out.println("Removed:" + removed6);
		System.out.println("size: " + bst1.size());
		myList = (ArrayList<Integer>) bst1.preOrder();
		for(Integer current: myList){
			System.out.print(current + ", ");
		}
		//remove empty list
		System.out.println();
		Integer removedEmpty = (Integer)bst1.remove(31);
		System.out.println("Removed:" + removedEmpty);
		//add new node to the list
		bst1.add(null);
		myList = (ArrayList<Integer>) bst1.preOrder();
		for(Integer current: myList){
			System.out.print(current + ", ");
		}
		bst1.remove(null);
		System.out.println();
		System.out.println(bst1.size());
		myList = (ArrayList<Integer>) bst1.preOrder();
		for(Integer current: myList){
			System.out.print(current + ", ");
		}
	}
	
	
	
	@Test
	public void testContains(){
		bst1 = new BST();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < vals.length; i++){
			list.add(vals[i]);
		}
		bst1.addAll(list);
		System.out.println(bst1.size());
		boolean contains = bst1.contains(null);
		System.out.println(contains);
	}
	/**
	public void testAddAll(){
		bst1 = new BST();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < vals.length; i++){
			list.add(vals[i]);
		}
		bst1.addAll(list);
		ArrayList<Integer> answerList = (ArrayList<Integer>) bst1.preOrder();
		for(Integer current: answerList){
			System.out.print(current + ", ");
		}

		
		
		bst1.clear();
		System.out.println();
		System.out.println(bst1.isEmpty());
		answerList = (ArrayList<Integer>) bst1.preOrder();
		for(Integer current: answerList){
			System.out.print(current + ", ");
		}
		
	}
	*/
	/**
	public void testGetSuccessor(){
		bst1 = new BST();
		ArrayList<Integer> list = new ArrayList<Integer>();
		Integer [ ] vals = {50, 25, 75, 85, 67, 18, 9, 45, null, 22};
		for(int i = 0; i < vals.length; i++){
			list.add(vals[i]);
		}
		bst1.addAll(list);
		Integer successor = (Integer) bst1.getSuccessor(bst1.getRoot()).getData();
		System.out.println(successor);
		
	}
	*/
	
	public static void main(String[] args){
		
		
	}
	
	
	
		
		
		
		
		
	}



