import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class GraphSearchesJUnit {
	
	@Test
	public void test1(){
		System.out.println("BFS Test 1 ----");
		int[][] graph = {{1, 1, 0, 1}, 
						 {1, 1, 1, 0}, 
						 {0, 1, 1, 1}, 
						 {1, 0, 1, 1}};
		List<Integer> answer = GraphSearches.breadthFirstSearch(graph, 4, 0, 3);
		Integer [] theAnswer = {0,3};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		
	}
	
	@Test
	public void test2(){
		System.out.println("BFS Test 2 ----");
		int[][] graph = {{1, 1, 0, 0}, 
						 {1, 1, 1, 0}, 
						 {0, 1, 1, 1}, 
						 {0, 0, 1, 1}};
		List<Integer> answer = GraphSearches.breadthFirstSearch(graph, 4, 0, 3);
		Integer [] theAnswer = {0,1,2,3};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void test3(){
		System.out.println("BFS Test 3 ----");
		int[][] graph = {{1, 1, 0, 0}, 
						 {1, 1, 1, 0}, 
						 {0, 1, 1, 1}, 
						 {0, 0, 1, 1}};
		List<Integer> answer = GraphSearches.breadthFirstSearch(graph, 4, 1, 3);
		Integer [] theAnswer = {1,2,3};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	

	@Test
	public void test4(){
		System.out.println("BFS Test 4 ----");
		int[][] graph = {{1, 1, 0, 0, 0, 1, 0}, 
						 {1, 1, 1, 0, 0, 0, 0}, 
						 {1, 1, 1, 0, 0, 0, 0}, 
						 {1, 1, 1, 1, 1, 0, 0},
		 				 {1, 1, 1, 1, 1, 1, 0},
						 {1, 1, 1, 1, 1, 1, 1},
						 {1, 1, 1, 1, 1, 1, 1}};
		List<Integer> answer = GraphSearches.breadthFirstSearch(graph, 7, 2, 3);
		Integer [] theAnswer = {2,0,5,3};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void test5(){
		System.out.println("BFS Test 5 ----");
		int[][] graph = {{1, 0, 0, 0, 0, 0, 0}, 
						 {1, 1, 1, 0, 0, 0, 0}, 
						 {1, 1, 1, 1, 0, 0, 0}, 
						 {1, 1, 1, 1, 1, 0, 0},
		 				 {1, 1, 1, 1, 1, 1, 0},
						 {1, 1, 1, 1, 1, 1, 1},
						 {1, 1, 1, 1, 1, 1, 1}};
		List<Integer> answer = GraphSearches.breadthFirstSearch(graph, 7, 0, 6);
		Integer [] theAnswer = {};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println("This answer should be empty. Dead End");
		System.out.println();
		
	}
	
	@Test
	public void test6(){
		System.out.println("BFS Test 6 ----");
		int[][] graph = {{1, 0, 0, 0, 0, 0, 0}, 
						 {1, 1, 1, 0, 0, 0, 0}, 
						 {1, 1, 1, 1, 0, 0, 0}, 
						 {1, 1, 1, 1, 1, 0, 0},
		 				 {1, 1, 1, 1, 1, 1, 0},
						 {1, 1, 1, 1, 1, 1, 1},
						 {1, 1, 1, 1, 1, 1, 1}};
		List<Integer> answer = GraphSearches.breadthFirstSearch(graph, 7, 5, 6);
		Integer [] theAnswer = {5,6};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void test7(){
		System.out.println("BFS Test 7 ----");
		int[][] graph = {{1, 0, 0, 0, 0, 0, 0}, 
						 {1, 1, 1, 0, 0, 0, 0}, 
						 {1, 1, 1, 1, 0, 0, 0}, 
						 {1, 1, 1, 1, 1, 0, 0},
		 				 {1, 1, 1, 1, 1, 1, 0},
						 {1, 1, 1, 1, 1, 1, 1},
						 {1, 1, 1, 1, 1, 1, 1}};
		List<Integer> answer = GraphSearches.breadthFirstSearch(graph, 7, 6, 6);
		Integer [] theAnswer = {6};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void test8(){
		System.out.println("BFS Test 8 ----");
		int[][] graph = {{1, 1, 0, 0, 0, 0, 0}, 
						 {1, 1, 1, 0, 0, 0, 0}, 
						 {1, 1, 1, 1, 0, 0, 0}, 
						 {1, 1, 1, 1, 1, 0, 0},
		 				 {1, 1, 1, 1, 1, 1, 0},
						 {1, 1, 1, 1, 1, 1, 1},
						 {1, 1, 1, 1, 1, 1, 1}};
		List<Integer> answer = GraphSearches.breadthFirstSearch(graph, 7, 0, 6);
		Integer [] theAnswer = {0, 1, 2, 3, 4, 5, 6};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void test9(){
		System.out.println("BFS Test 9 ----");
		int[][] graph = {{1, 1, 0, 0, 0, 0, 0}, 
						 {1, 1, 1, 0, 0, 0, 0}, 
						 {1, 1, 1, 1, 0, 0, 0}, 
						 {1, 1, 1, 1, 1, 0, 0},
		 				 {1, 1, 1, 1, 1, 1, 0},
						 {1, 1, 1, 1, 1, 1, 1},
						 {1, 1, 1, 1, 1, 1, 1}};
		List<Integer> answer = GraphSearches.breadthFirstSearch(graph, 7, 6, 2);
		Integer [] theAnswer = {6,2};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void test10(){
		System.out.println("BFS Test 10 ----");
		int[][] graph = {{1, 0, 1, 0, 0, 0, 0, 0, 1, 0}, 
						 {0, 1, 1, 0, 0, 0, 1, 0, 0, 0}, 
						 {1, 0, 1, 1, 0, 0, 1, 0, 0, 0}, 
						 {0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
		 				 {0, 1, 0, 1, 1, 0, 0, 0, 0, 0},
						 {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
						 {0, 0, 1, 0, 0, 0, 1, 1, 0, 0},
						 {1, 1, 1, 1, 0, 0, 0, 1, 0, 0},
						 {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
						 {0, 0, 0, 0, 0, 0, 0, 0, 1, 1}};
		List<Integer> answer = GraphSearches.breadthFirstSearch(graph, 10, 9, 2);
		Integer [] theAnswer = {};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		
	}
	
	@Test
	public void test11(){
		System.out.println("BFS Test 11 ----");
		int[][] graph = {{1, 0, 1, 0, 0, 0, 0, 0, 1, 0}, 
						 {0, 1, 1, 0, 0, 0, 1, 0, 0, 0}, 
						 {1, 0, 1, 1, 0, 0, 1, 0, 0, 0}, 
						 {0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
		 				 {0, 1, 0, 1, 1, 0, 0, 0, 0, 0},
						 {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
						 {0, 0, 1, 0, 0, 0, 1, 1, 0, 0},
						 {1, 1, 1, 1, 0, 0, 0, 1, 0, 0},
						 {1, 1, 1, 0, 0, 1, 1, 0, 1, 0},
						 {0, 0, 0, 0, 0, 0, 0, 0, 0, 1}};
		List<Integer> answer = GraphSearches.breadthFirstSearch(graph, 10, 2, 9);
		Integer [] theAnswer = {2, 0, 8, 5, 9};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void test12(){
		System.out.println("BFS Test 12 ----");
		int[][] graph = {{1, 0, 1, 0, 0, 0, 0, 0, 1, 0}, 
						 {0, 1, 1, 0, 0, 0, 1, 0, 0, 0}, 
						 {1, 0, 1, 1, 0, 0, 1, 0, 0, 0}, 
						 {0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
		 				 {0, 1, 0, 1, 1, 0, 0, 0, 0, 0},
						 {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
						 {0, 0, 1, 0, 0, 0, 1, 1, 0, 0},
						 {1, 1, 1, 1, 0, 0, 0, 1, 0, 0},
						 {1, 1, 1, 0, 0, 1, 1, 0, 1, 0},
						 {0, 0, 0, 0, 0, 0, 0, 0, 0, 1}};
		List<Integer> answer = GraphSearches.breadthFirstSearch(graph, 10, 2, 9);
		Integer [] theAnswer = {2, 0, 8, 5, 9};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		System.out.println();
	}
	
	@Test
	public void test13(){
		System.out.println("BFS Test 13 ----");
		int[][] graph = {{1, 0, 1, 0, 0, 0, 0, 0, 1, 0}, 
						 {0, 1, 1, 0, 0, 0, 1, 0, 0, 0}, 
						 {1, 0, 1, 1, 0, 0, 1, 0, 0, 0}, 
						 {0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
		 				 {0, 1, 0, 1, 1, 0, 0, 0, 0, 0},
						 {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
						 {0, 0, 1, 0, 0, 0, 1, 1, 0, 0},
						 {1, 1, 1, 1, 0, 0, 0, 1, 0, 0},
						 {1, 1, 1, 0, 0, 1, 1, 0, 1, 0},
						 {0, 0, 0, 0, 0, 0, 0, 0, 0, 1}};
		List<Integer> answer = GraphSearches.breadthFirstSearch(graph, 10, 7, 5);
		Integer [] theAnswer = {7, 0, 8, 5};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void test14(){
		System.out.println("BFS Test 14 ----");
		int[][] graph = {{1, 0, 1, 0, 0, 0, 0, 0, 1, 0}, 
						 {0, 1, 1, 0, 0, 0, 1, 0, 0, 0}, 
						 {1, 0, 1, 1, 0, 0, 1, 0, 0, 0}, 
						 {0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
		 				 {0, 1, 0, 1, 1, 0, 0, 0, 0, 0},
						 {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
						 {0, 0, 1, 0, 0, 0, 1, 1, 0, 0},
						 {1, 1, 1, 1, 0, 0, 0, 1, 0, 0},
						 {1, 1, 1, 0, 0, 1, 1, 0, 1, 0},
						 {0, 0, 0, 0, 0, 0, 0, 0, 0, 1}};
		List<Integer> answer = GraphSearches.breadthFirstSearch(graph, 10, 8, 3);
		Integer [] theAnswer = {8, 2, 3};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void test15(){
		System.out.println("BFS Test 15 ----");
		int[][] graph = {{1, 0, 1, 0, 0, 0, 0, 0, 1, 0}, 
						 {0, 1, 1, 0, 0, 0, 1, 0, 0, 0}, 
						 {1, 0, 1, 1, 0, 0, 1, 0, 0, 0}, 
						 {0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
		 				 {0, 1, 0, 1, 1, 0, 0, 0, 0, 0},
						 {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
						 {0, 0, 1, 0, 0, 0, 1, 1, 0, 0},
						 {1, 1, 1, 1, 0, 0, 0, 1, 0, 0},
						 {1, 1, 1, 0, 0, 1, 1, 0, 1, 0},
						 {0, 0, 0, 0, 0, 0, 0, 0, 0, 1}};
		List<Integer> answer = GraphSearches.breadthFirstSearch(graph, 10, 0, 7);
		Integer [] theAnswer = {0, 2, 6, 7};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		System.out.println();
		
	}
	
	@Test
	public void test16(){
		System.out.println("BFS Test 16 ----");
		int[][] graph = {{1, 0, 0, 0, 0, 0, 0}, 
						 {1, 1, 1, 0, 0, 0, 0}, 
						 {1, 1, 1, 1, 0, 0, 0}, 
						 {1, 1, 1, 1, 1, 0, 0},
		 				 {1, 1, 1, 1, 1, 1, 0},
						 {1, 1, 1, 1, 1, 1, 1},
						 {1, 1, 1, 1, 1, 1, 1}};
		List<Integer> answer = GraphSearches.breadthFirstSearch(graph, 7, 0, 0);
		Integer [] theAnswer = {0};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		
	}
	
	@Test
	public void test17(){
		System.out.println("BFS Test 17 ----");
		int[][] graph = {{0, 0, 0, 0, 0, 0, 0}, 
						 {1, 1, 1, 0, 0, 0, 0}, 
						 {1, 1, 1, 1, 0, 0, 0}, 
						 {1, 1, 1, 1, 1, 0, 0},
		 				 {1, 1, 1, 1, 1, 1, 0},
						 {1, 1, 1, 1, 1, 1, 1},
						 {1, 1, 1, 1, 1, 1, 1}};
		List<Integer> answer = GraphSearches.breadthFirstSearch(graph, 7, 0, 0);
		Integer [] theAnswer = {0};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		
	}
	
	@Test
	public void test18(){
		System.out.println("BFS Test 18 ----");
		int[][] graph = {{1, 0, 0, 1, 0, 0, 0}, 
						 {1, 1, 1, 0, 0, 0, 0}, 
						 {1, 1, 1, 1, 0, 0, 0}, 
						 {1, 1, 1, 1, 1, 0, 0},
		 				 {1, 1, 1, 1, 1, 1, 0},
						 {1, 1, 1, 1, 1, 1, 1},
						 {1, 1, 1, 1, 1, 1, 1}};
		List<Integer> answer = GraphSearches.breadthFirstSearch(graph, 7, 4, 4);
		Integer [] theAnswer = {4};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		
	}
	
	@Test
	public void test19(){
		System.out.println("BFS Test 19 ----");
		int[][] graph = {{1, 0, 0, 1, 0, 0, 0}, 
						 {1, 1, 1, 0, 0, 0, 0}, 
						 {1, 1, 1, 1, 0, 0, 0}, 
						 {1, 1, 1, 1, 1, 0, 0},
		 				 {1, 1, 1, 1, 0, 1, 0},
						 {1, 1, 1, 1, 1, 1, 1},
						 {1, 1, 1, 1, 1, 1, 1}};
		List<Integer> answer = GraphSearches.breadthFirstSearch(graph, 7, 4, 4);
		Integer [] theAnswer = {4};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		
	}
	
	@Test
	public void test20(){
		System.out.println("BFS Test 20 ----");
		int[][] graph = {{1, 0, 0, 0, 0, 0, 0}, 
						 {1, 1, 1, 0, 0, 0, 0}, 
						 {1, 1, 1, 1, 0, 0, 0}, 
						 {1, 1, 1, 1, 1, 0, 0},
		 				 {1, 1, 1, 1, 0, 1, 0},
						 {1, 1, 1, 1, 1, 1, 1},
						 {1, 1, 1, 1, 1, 1, 1}};
		List<Integer> answer = GraphSearches.breadthFirstSearch(graph, 7, 0, 4);
		Integer [] theAnswer = {};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		
	}
	
	@Test
	public void testDFS1(){
		System.out.println("Beginning of DFS Testing");
		System.out.println("DFS Test 1 ----");
		int[][] graph = {{1, 1, 0, 1}, 
						 {1, 1, 1, 0}, 
						 {0, 1, 1, 1}, 
						 {1, 0, 1, 1}};
		List<Integer> answer = GraphSearches.depthFirstSearch(graph, 4, 0, 3);
		Integer [] theAnswer = {0,3};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void testDFS2(){
		System.out.println("DFS Test 2 ----");
		int[][] graph = {{1, 1, 0, 0}, 
						 {1, 1, 1, 0}, 
						 {0, 1, 1, 1}, 
						 {0, 0, 1, 1}};
		List<Integer> answer = GraphSearches.depthFirstSearch(graph, 4, 0, 3);
		Integer [] theAnswer = {0,1,2,3};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void testDFS3(){
		System.out.println("DFS Test 3 ----");
		int[][] graph = {{1, 1, 0, 0}, 
						 {1, 1, 1, 0}, 
						 {0, 1, 1, 1}, 
						 {0, 0, 1, 1}};
		List<Integer> answer = GraphSearches.depthFirstSearch(graph, 4, 1, 3);
		Integer [] theAnswer = {1,2,3};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	

	@Test
	public void testDFS4(){
		System.out.println("DFS Test 4 ----");
		int[][] graph = {{1, 1, 0, 0, 0, 0, 0}, 
						 {1, 1, 1, 0, 0, 0, 0}, 
						 {1, 1, 1, 1, 0, 0, 0}, 
						 {1, 1, 1, 1, 1, 0, 0},
		 				 {1, 1, 1, 1, 1, 1, 0},
						 {1, 1, 1, 1, 1, 1, 1},
						 {1, 1, 1, 1, 1, 1, 1}};
		List<Integer> answer = GraphSearches.depthFirstSearch(graph, 4, 2, 3);
		Integer [] theAnswer = {2,3};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void tesDFSt5(){
		System.out.println("DFS Test 5 ----");
		int[][] graph = {{1, 0, 0, 0, 0, 0, 0}, 
						 {1, 1, 1, 0, 0, 0, 0}, 
						 {1, 1, 1, 1, 0, 0, 0}, 
						 {1, 1, 1, 1, 1, 0, 0},
		 				 {1, 1, 1, 1, 1, 1, 0},
						 {1, 1, 1, 1, 1, 1, 1},
						 {1, 1, 1, 1, 1, 1, 1}};
		List<Integer> answer = GraphSearches.depthFirstSearch(graph, 4, 0, 6);
		Integer [] theAnswer = {};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		System.out.println("This answer should be empty. Dead End");
		System.out.println();
		
	}
	
	@Test
	public void testDFS6(){
		System.out.println("DFS Test 6 ----");
		int[][] graph = {{1, 0, 0, 0, 0, 0, 0}, 
						 {1, 1, 1, 0, 0, 0, 0}, 
						 {1, 1, 1, 1, 0, 0, 0}, 
						 {1, 1, 1, 1, 1, 0, 0},
		 				 {1, 1, 1, 1, 1, 1, 0},
						 {1, 1, 1, 1, 1, 1, 1},
						 {1, 1, 1, 1, 1, 1, 1}};
		List<Integer> answer = GraphSearches.depthFirstSearch(graph, 7, 5, 6);
		Integer [] theAnswer = {5, 6};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void testDFS7(){
		System.out.println("DFS Test 7 ----");
		int[][] graph = {{1, 0, 0, 0, 0, 0, 0}, 
						 {1, 1, 1, 0, 0, 0, 0}, 
						 {1, 1, 1, 1, 0, 0, 0}, 
						 {1, 1, 1, 1, 1, 0, 0},
		 				 {1, 1, 1, 1, 1, 1, 0},
						 {1, 1, 1, 1, 1, 1, 1},
						 {1, 1, 1, 1, 1, 1, 1}};
		List<Integer> answer = GraphSearches.depthFirstSearch(graph, 7, 6, 6);
		Integer [] theAnswer = {6};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void testDFS8(){
		System.out.println("DFS Test 8 ----");
		int[][] graph = {{1, 1, 0, 0, 0, 0, 0}, 
						 {1, 1, 1, 0, 0, 0, 0}, 
						 {1, 1, 1, 1, 0, 0, 0}, 
						 {1, 1, 1, 1, 1, 0, 0},
		 				 {1, 1, 1, 1, 1, 1, 0},
						 {1, 1, 1, 1, 1, 1, 1},
						 {1, 1, 1, 1, 1, 1, 1}};
		List<Integer> answer = GraphSearches.depthFirstSearch(graph, 7, 0, 6);
		Integer [] theAnswer = {0, 1, 2, 3, 4, 5, 6};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void testDFS9(){
		System.out.println("DFS Test 9 ----");
		int[][] graph = {{1, 1, 0, 0, 0, 0, 0}, 
						 {1, 1, 1, 0, 0, 0, 0}, 
						 {1, 1, 1, 1, 0, 0, 0}, 
						 {1, 1, 1, 1, 1, 0, 0},
		 				 {1, 1, 1, 1, 1, 1, 0},
						 {1, 1, 1, 1, 1, 1, 1},
						 {1, 1, 1, 1, 1, 1, 1}};
		List<Integer> answer = GraphSearches.depthFirstSearch(graph, 7, 2, 6);
		Integer [] theAnswer = {2, 3, 4, 5, 6};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void testDFS10(){
		System.out.println("DFS Test 10 ----");
		int[][] graph = {{1, 0, 1, 0, 0, 0, 0, 0, 1, 0}, 
						 {0, 1, 1, 0, 0, 0, 1, 0, 0, 0}, 
						 {1, 0, 1, 1, 0, 0, 1, 0, 0, 0}, 
						 {0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
		 				 {0, 1, 0, 1, 1, 0, 0, 0, 0, 0},
						 {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
						 {0, 0, 1, 0, 0, 0, 1, 1, 0, 0},
						 {1, 1, 1, 1, 0, 0, 0, 1, 0, 0},
						 {1, 1, 1, 0, 0, 1, 1, 0, 1, 0},
						 {0, 0, 0, 0, 0, 0, 0, 0, 0, 1}};
		List<Integer> answer = GraphSearches.depthFirstSearch(graph, 10, 9, 2);
		Integer [] theAnswer = {};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		
	}
	//start testing manually  from here!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	@Test
	public void testDFS11(){
		System.out.println("DFS Test 11 ----");
		int[][] graph = {{1, 0, 1, 0, 0, 0, 0, 0, 1, 0}, 
						 {0, 1, 1, 0, 0, 0, 1, 0, 0, 0}, 
						 {1, 0, 1, 1, 0, 0, 1, 0, 0, 0}, 
						 {0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
		 				 {0, 1, 0, 1, 1, 0, 0, 0, 0, 0},
						 {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
						 {0, 0, 1, 0, 0, 0, 1, 1, 0, 0},
						 {1, 1, 1, 1, 0, 0, 0, 1, 0, 0},
						 {1, 1, 1, 0, 0, 1, 1, 0, 1, 0},
						 {0, 0, 0, 0, 0, 0, 0, 0, 0, 1}};
		List<Integer> answer = GraphSearches.depthFirstSearch(graph, 10, 2, 9);
		Integer [] theAnswer = {2, 6, 7, 3, 8, 5, 9};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void testDFS12(){
		System.out.println("DFS Test 12 ----");
		int[][] graph = {{1, 0, 1, 0, 0, 0, 0, 0, 1, 0}, 
						 {0, 1, 1, 0, 0, 0, 1, 0, 0, 0}, 
						 {1, 0, 1, 1, 0, 0, 1, 0, 0, 0}, 
						 {0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
		 				 {0, 1, 0, 1, 1, 0, 0, 0, 0, 0},
						 {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
						 {0, 0, 1, 0, 0, 0, 1, 1, 0, 0},
						 {1, 1, 1, 1, 0, 0, 0, 1, 0, 0},
						 {1, 1, 1, 0, 0, 1, 1, 0, 1, 0},
						 {0, 0, 0, 0, 0, 0, 0, 0, 0, 1}};
		List<Integer> answer = GraphSearches.depthFirstSearch(graph, 10, 7,2);
		Integer [] theAnswer = {7, 3, 8, 6, 2};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void testDFS13(){
		System.out.println("DFS Test 13 ----");
		int[][] graph = {{1, 0, 1, 0, 0, 0, 0, 0, 1, 0}, 
						 {0, 1, 1, 0, 0, 0, 1, 0, 0, 0}, 
						 {1, 0, 1, 1, 0, 0, 1, 0, 0, 0}, 
						 {0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
		 				 {0, 1, 0, 1, 1, 0, 0, 0, 0, 0},
						 {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
						 {0, 0, 1, 0, 0, 0, 1, 1, 0, 0},
						 {1, 1, 1, 1, 0, 0, 0, 1, 0, 0},
						 {1, 1, 1, 0, 0, 1, 1, 0, 1, 0},
						 {0, 0, 0, 0, 0, 0, 0, 0, 0, 1}};
		List<Integer> answer = GraphSearches.breadthFirstSearch(graph, 10, 8, 5);
		Integer [] theAnswer = {8,5};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void testDFS14(){
		System.out.println("DFS Test 14 ----");
		int[][] graph = {{1, 0, 1, 0, 0, 0, 0, 0, 1, 0}, 
						 {0, 1, 1, 0, 0, 0, 1, 0, 0, 0}, 
						 {1, 0, 1, 1, 0, 0, 1, 0, 0, 0}, 
						 {0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
		 				 {0, 1, 0, 1, 1, 0, 0, 0, 0, 0},
						 {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
						 {0, 0, 1, 0, 0, 0, 1, 1, 0, 0},
						 {1, 1, 1, 1, 0, 0, 0, 1, 0, 0},
						 {1, 1, 1, 0, 0, 1, 1, 0, 1, 0},
						 {0, 0, 0, 0, 0, 0, 0, 0, 0, 1}};
		List<Integer> answer = GraphSearches.depthFirstSearch(graph, 10, 8, 3);
		Integer [] theAnswer = {8, 6, 7, 3};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void testDFS15(){
		System.out.println("DFS Test 15 ----");
		int[][] graph = {{1, 0, 1, 0, 0, 0, 0, 0, 1, 0}, 
						 {0, 1, 1, 0, 0, 0, 1, 0, 0, 0}, 
						 {1, 0, 1, 1, 0, 0, 1, 0, 0, 0}, 
						 {0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
		 				 {0, 1, 0, 1, 1, 0, 0, 0, 0, 0},
						 {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
						 {0, 0, 1, 0, 0, 0, 1, 1, 0, 0},
						 {1, 1, 1, 1, 0, 0, 0, 1, 0, 0},
						 {1, 1, 1, 0, 0, 1, 1, 0, 1, 0},
						 {0, 0, 0, 0, 0, 0, 0, 0, 0, 1}};
		List<Integer> answer = GraphSearches.depthFirstSearch(graph, 10, 0, 7);
		Integer [] theAnswer = {0, 8, 6, 7};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		
	}
	
	@Test
	public void testDFS16(){
		System.out.println("DFS Test 16 ----");
		int[][] graph = {{1, 1, 0, 0, 0, 0, 0}, 
						 {1, 1, 1, 0, 0, 0, 0}, 
						 {1, 1, 1, 1, 0, 0, 0}, 
						 {1, 1, 1, 1, 1, 0, 0},
		 				 {1, 1, 1, 1, 1, 1, 0},
						 {1, 1, 1, 1, 1, 1, 1},
						 {1, 1, 1, 1, 1, 1, 1}};
		List<Integer> answer = GraphSearches.depthFirstSearch(graph, 7, 6, 2);
		Integer [] theAnswer = {6, 5, 4, 3, 2};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void DFStest17(){
		System.out.println("DFS Test 17 ----");
		int[][] graph = {{1, 0, 0, 0, 0, 0, 0}, 
						 {1, 1, 1, 0, 0, 0, 0}, 
						 {1, 1, 1, 1, 0, 0, 0}, 
						 {1, 1, 1, 1, 1, 0, 0},
		 				 {1, 1, 1, 1, 1, 1, 0},
						 {1, 1, 1, 1, 1, 1, 1},
						 {1, 1, 1, 1, 1, 1, 1}};
		List<Integer> answer = GraphSearches.depthFirstSearch(graph, 7, 0, 0);
		Integer [] theAnswer = {0};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		
	}
	
	@Test
	public void DFStest18(){
		System.out.println("DFS Test 18 ----");
		int[][] graph = {{0, 0, 0, 0, 0, 0, 0}, 
						 {1, 1, 1, 0, 0, 0, 0}, 
						 {1, 1, 1, 1, 0, 0, 0}, 
						 {1, 1, 1, 1, 1, 0, 0},
		 				 {1, 1, 1, 1, 1, 1, 0},
						 {1, 1, 1, 1, 1, 1, 1},
						 {1, 1, 1, 1, 1, 1, 1}};
		List<Integer> answer = GraphSearches.depthFirstSearch(graph, 7, 0, 0);
		Integer [] theAnswer = {0};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		
	}
	
	@Test
	public void DFStest19(){
		System.out.println("DFS Test 19 ----");
		int[][] graph = {{1, 0, 0, 1, 0, 0, 0}, 
						 {1, 1, 1, 0, 0, 0, 0}, 
						 {1, 1, 1, 1, 0, 0, 0}, 
						 {1, 1, 1, 1, 1, 0, 0},
		 				 {1, 1, 1, 1, 1, 1, 0},
						 {1, 1, 1, 1, 1, 1, 1},
						 {1, 1, 1, 1, 1, 1, 1}};
		List<Integer> answer = GraphSearches.depthFirstSearch(graph, 7, 4, 4);
		Integer [] theAnswer = {4};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		
	}
	
	@Test
	public void DFStest20(){
		System.out.println("DFS Test 20 ----");
		int[][] graph = {{1, 0, 0, 1, 0, 0, 0}, 
						 {1, 1, 1, 0, 0, 0, 0}, 
						 {1, 1, 1, 1, 0, 0, 0}, 
						 {1, 1, 1, 1, 1, 0, 0},
		 				 {1, 1, 1, 1, 0, 1, 0},
						 {1, 1, 1, 1, 1, 1, 1},
						 {1, 1, 1, 1, 1, 1, 1}};
		List<Integer> answer = GraphSearches.depthFirstSearch(graph, 7, 4, 4);
		Integer [] theAnswer = {4};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		
	}
	
	@Test
	public void DFStest21(){
		System.out.println("BFS Test 21 ----");
		int[][] graph = {{1, 0, 0, 0, 0, 0, 0}, 
						 {1, 1, 1, 0, 0, 0, 0}, 
						 {1, 1, 1, 1, 0, 0, 0}, 
						 {1, 1, 1, 1, 1, 0, 0},
		 				 {1, 1, 1, 1, 0, 1, 0},
						 {1, 1, 1, 1, 1, 1, 1},
						 {1, 1, 1, 1, 1, 1, 1}};
		List<Integer> answer = GraphSearches.depthFirstSearch(graph, 7, 0, 4);
		Integer [] theAnswer = {};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		System.out.println("End of DFS Testing");
		
	}
	
	@Test
	public void testDijk1(){
		System.out.println("Dijk's Test 1 ----");
		int INF = Integer.MIN_VALUE;
		int[][] graph = {{0, 1, INF, 3}, 
						 {0, 1, 2, INF}, 
						 {INF, 1, 2, 3}, 
						 {0, INF, 2, 3}};
		List<Integer> answer = GraphSearches.dijkstrasAlgorithm(graph, 4, 0, 3);
		Integer [] theAnswer = {0,3};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		
	}
	
	@Test
	public void testDijk2(){
		System.out.println("Dijk's Test 2 ----");
		int INF = Integer.MIN_VALUE;
		int[][] graph = {{0, 1, INF, 3}, 
				 		 {0, 1, 2, INF}, 
				 		 {INF, 1, 2, 3}, 
				 		 {0, INF, 2, 3}};
		List<Integer> answer = GraphSearches.dijkstrasAlgorithm(graph, 4, 3, 3);
		Integer [] theAnswer = {3};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void testDijk3(){
		System.out.println("Dijk's Test 3 ----");
		int INF = Integer.MIN_VALUE;
		int[][] graph = {{0, 1, INF, 3}, 
				 		 {0, 1, 2, INF}, 
				 		 {INF, 1, 2, 3}, 
				 		 {0, INF, 2, 3},
						 {0, 0, 1, 1}};
		List<Integer> answer = GraphSearches.dijkstrasAlgorithm(graph, 4, 1, 3);
		Integer [] theAnswer = {1,0,3};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	

	@Test
	public void testDijk4(){
		System.out.println("Dijk's Test 4 ----");
		int INF = Integer.MIN_VALUE;
		int[][] graph = {{1, 5, INF, INF, INF, 6, INF}, 
						 {1, 2, 1, INF, INF, INF, INF}, 
						 {1, INF, 3, INF, INF, INF, INF}, 
						 {0, 1, 4, 1, 6, INF, INF},
		 				 {0, 1, 1, 5, 6, 1, INF},
						 {1, 2, 1, 8, 1, 7, 3},
						 {1, 1, 3, 4, 5, 1, 8}};
		List<Integer> answer = GraphSearches.dijkstrasAlgorithm(graph, 7, 2, 3);
		Integer [] theAnswer = {2,0,5,4,3};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void testDijk5(){
		System.out.println("Dijk's Test 5 ----");
		int INF = Integer.MIN_VALUE;
		int[][] graph = {{1, 5, INF, INF, INF, 6, INF}, 
						 {1, 2, 1, INF, INF, INF, INF}, 
						 {1, INF, 3, INF, INF, INF, INF}, 
						 {0, 1, 4, 1, 6, INF, INF},
		 				 {0, 1, 1, 5, 6, 1, INF},
						 {1, 2, 1, 8, 1, 7, 3},
						 {1, 1, 3, 4, 5, 1, 8}};
		List<Integer> answer = GraphSearches.dijkstrasAlgorithm(graph, 7, 0, 6);
		Integer [] theAnswer = {0,5,6};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		
	}
	
	@Test
	public void testDijk6(){
		System.out.println("Dijk's Test 6 ----");
		int INF = Integer.MIN_VALUE;
		int[][] graph = {{1, 5, INF, INF, INF, 6, INF}, 
						 {1, 2, 1, INF, INF, INF, INF}, 
						 {1, INF, 3, INF, INF, INF, INF}, 
						 {0, 1, 4, 1, 6, INF, INF},
		 				 {0, 1, 1, 5, 6, 1, INF},
						 {1, 2, 1, 8, 1, 7, 3},
						 {1, 1, 3, 4, 5, 1, 8}};
		List<Integer> answer = GraphSearches.dijkstrasAlgorithm(graph, 7, 5, 6);
		Integer [] theAnswer = {5,6};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void testDijk7(){
		System.out.println("Dijk's Test 7 ----");
		int INF = Integer.MIN_VALUE;
		int[][] graph = {{1, 5, INF, INF, INF, 6, INF}, 
						 {1, 2, 1, INF, INF, INF, INF}, 
						 {1, INF, 3, INF, INF, INF, INF}, 
						 {0, 1, 4, 1, 6, INF, INF},
		 				 {0, 1, 1, 5, 6, 1, INF},
						 {1, 2, 1, 8, 1, 7, 3},
						 {1, 1, 3, 4, 5, 1, 8}};
		List<Integer> answer = GraphSearches.dijkstrasAlgorithm(graph, 7, 6, 6);
		Integer [] theAnswer = {6};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void testDijk8(){
		System.out.println("Dijk's Test 8 ----");
		int INF = Integer.MIN_VALUE;
		int[][] graph = {{1, 5, INF, INF, INF, 6, INF}, 
						 {1, 2, 1, INF, INF, INF, INF}, 
						 {1, INF, 3, INF, INF, INF, INF}, 
						 {0, 1, 4, 1, 6, INF, INF},
		 				 {0, 1, 1, 5, 6, 1, INF},
						 {1, 2, 1, 8, 1, 7, 3},
						 {1, 1, 3, 4, 5, 1, 8}};
		List<Integer> answer = GraphSearches.dijkstrasAlgorithm(graph, 7, 2, 6);
		Integer [] theAnswer = {2,0,5,6};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void testDijk9(){
		System.out.println("Dijk's Test 9 ----");
		int INF = Integer.MIN_VALUE;
		int[][] graph = {{1, 5, INF, INF, INF, 6, INF}, 
						 {1, 2, 1, INF, INF, INF, INF}, 
						 {1, INF, 3, INF, INF, INF, INF}, 
						 {0, 1, 4, 1, 6, INF, INF},
		 				 {0, 1, 1, 5, 6, 1, INF},
						 {1, 2, 1, 8, 1, 7, 3},
						 {1, 1, 3, 4, 5, 1, 8}};
		List<Integer> answer = GraphSearches.dijkstrasAlgorithm(graph, 7, 6, 2);
		Integer [] theAnswer = {6,1,2};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void testDijk10(){
		System.out.println("Dijk's Test 10 ----");
		int INF = Integer.MIN_VALUE;
		int[][] graph = {{0, INF, 2, INF, INF, INF, INF, INF, 7, INF}, 
						 {INF, 0, 3, INF, INF, INF, 4, INF, INF, INF}, 
						 {2, INF, 0, 5, INF, INF, 8, INF, INF, INF}, 
						 {INF, 3, 1, 0, INF, INF, INF, INF, 7, INF},
		 				 {INF, 1, INF, 4, 0, INF, INF, INF, INF, INF},
						 {1, 1, 9, 1, 3, 0, 2, 12, 7, 10},
						 {INF, INF, 4, INF, INF, INF, 0, 7, INF, INF},
						 {1, 3, 2, 5, INF, INF, INF, 0, INF, INF},
						 {1, 2, 6, INF, INF, INF, INF, INF, 0, INF},
						 {INF, INF, INF, INF, INF, INF, INF, INF, 2, 0}};
		List<Integer> answer = GraphSearches.dijkstrasAlgorithm(graph, 10, 9, 2);
		Integer [] theAnswer = {9,8,0,2};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		
	}
	
	@Test
	public void testDijk11(){
		System.out.println("Dijk's Test 11 ----");
		int INF = Integer.MIN_VALUE;
		int[][] graph = {{0, INF, 2, INF, INF, INF, INF, INF, 7, INF}, 
						 {INF, 0, 3, INF, INF, INF, 4, INF, INF, INF}, 
						 {2, INF, 0, 5, INF, INF, 8, INF, INF, INF}, 
						 {INF, 3, 1, 0, INF, INF, INF, INF, 7, INF},
		 				 {INF, 1, INF, 4, 0, INF, INF, INF, INF, INF},
						 {1, 1, 9, 1, 3, 0, 2, 12, 7, 10},
						 {INF, INF, 4, INF, INF, INF, 0, 7, INF, INF},
						 {1, 3, 2, 5, INF, INF, INF, 0, INF, INF},
						 {1, 2, 6, INF, INF, INF, INF, INF, 0, INF},
						 {INF, INF, INF, INF, INF, INF, INF, INF, 2, 0}};
		List<Integer> answer = GraphSearches.dijkstrasAlgorithm(graph, 10, 2, 9);
		Integer [] theAnswer = {};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void testDijk12(){
		System.out.println("Dijk's Test 12 ----");
		int INF = Integer.MIN_VALUE;
		int[][] graph = {{0, INF, 2, INF, INF, INF, INF, INF, 7, INF}, 
						 {INF, 0, 3, INF, INF, INF, 4, INF, INF, INF}, 
						 {2, INF, 0, 5, INF, INF, 8, INF, INF, INF}, 
						 {INF, 3, 1, 0, INF, INF, INF, INF, 7, INF},
		 				 {INF, 1, INF, 4, 0, INF, INF, INF, INF, INF},
						 {1, 1, 9, 1, 3, 0, 2, 12, 7, 10},
						 {INF, INF, 4, INF, INF, INF, 0, 7, INF, INF},
						 {1, 3, 2, 5, INF, INF, INF, 0, INF, INF},
						 {1, 2, 6, INF, INF, INF, INF, INF, 0, INF},
						 {INF, INF, INF, INF, INF, INF, INF, INF, 2, 0}};
		List<Integer> answer = GraphSearches.dijkstrasAlgorithm(graph, 10, 5, 9);
		Integer [] theAnswer = {5,9};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		System.out.println();
	}
	
	@Test
	public void testDijk13(){
		System.out.println("Dijk's Test 13 ----");
		int INF = Integer.MIN_VALUE;
		int[][] graph = {{0, INF, 2, INF, INF, INF, INF, INF, 7, INF}, 
						 {INF, 0, 3, INF, INF, INF, 4, INF, INF, INF}, 
						 {2, INF, 0, 5, INF, INF, 8, INF, INF, INF}, 
						 {INF, 3, 1, 0, INF, INF, INF, INF, 7, INF},
		 				 {INF, 1, INF, 4, 0, INF, INF, INF, INF, INF},
						 {1, 1, 9, 1, 3, 0, 2, 12, 7, 10},
						 {INF, INF, 4, INF, INF, INF, 0, 7, INF, INF},
						 {1, 3, 2, 5, INF, INF, INF, 0, INF, INF},
						 {1, 2, 6, INF, INF, INF, INF, INF, 0, INF},
						 {INF, INF, INF, INF, INF, INF, INF, INF, 2, 0}};
		List<Integer> answer = GraphSearches.breadthFirstSearch(graph, 10, 7, 5);
		Integer [] theAnswer = {};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println("This should return an empty list, this start cannot reach this finish");
		System.out.println();
	}
	
	@Test
	public void testDijk14(){
		System.out.println("Dijk's Test 14 ----");
		int INF = Integer.MIN_VALUE;
		int[][] graph = {{0, INF, 2, INF, INF, INF, INF, INF, 7, INF}, 
						 {INF, 0, 3, INF, INF, INF, 4, INF, INF, INF}, 
						 {2, INF, 0, 5, INF, INF, 8, INF, INF, INF}, 
						 {INF, 3, 1, 0, INF, INF, INF, INF, 7, INF},
		 				 {INF, 1, INF, 4, 0, INF, INF, INF, INF, INF},
						 {1, 1, 9, 1, 3, 0, 2, 12, 7, 10},
						 {INF, INF, 4, INF, INF, INF, 0, 7, INF, INF},
						 {1, 3, 2, 5, INF, INF, INF, 0, INF, INF},
						 {1, 2, 6, INF, INF, INF, INF, INF, 0, INF},
						 {INF, INF, INF, INF, INF, INF, INF, INF, 2, 0}};
		List<Integer> answer = GraphSearches.dijkstrasAlgorithm(graph, 10, 8, 3);
		Integer [] theAnswer = {8, 0, 2, 3};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
	}
	
	@Test
	public void testDijk15(){
		System.out.println("Dijk's Test 15 ----");
		int INF = Integer.MIN_VALUE;
		int[][] graph = {{0, INF, 2, INF, INF, INF, INF, INF, 7, INF}, 
						 {INF, 0, 3, INF, INF, INF, 4, INF, INF, INF}, 
						 {2, INF, 0, 5, INF, INF, 8, INF, INF, INF}, 
						 {INF, 3, 1, 0, INF, INF, INF, INF, 7, INF},
		 				 {INF, 1, INF, 4, 0, INF, INF, INF, INF, INF},
						 {1, 1, 9, 1, 3, 0, 2, 12, 7, 10},
						 {INF, INF, 4, INF, INF, INF, 0, 7, INF, INF},
						 {1, 3, 2, 5, INF, INF, INF, 0, INF, INF},
						 {1, 2, 6, INF, INF, INF, INF, INF, 0, INF},
						 {INF, INF, INF, INF, INF, INF, INF, INF, 2, 0}};
		List<Integer> answer = GraphSearches.dijkstrasAlgorithm(graph, 10, 0, 7);
		Integer [] theAnswer = {0, 2, 6, 7};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		System.out.println();
		
	}
	
	@Test
	public void testDijk16(){
		System.out.println("Dijk's Test 16 ----");
		int INF = Integer.MIN_VALUE;
		int[][] graph = {{0, INF, 2, INF, INF, INF, INF, INF, 7, INF}, 
						 {INF, 0, 3, INF, INF, INF, 4, INF, INF, INF}, 
						 {2, INF, 0, 5, INF, INF, 8, INF, INF, INF}, 
						 {INF, 3, 1, 0, INF, INF, INF, INF, 7, INF},
		 				 {INF, 1, INF, 4, 0, INF, INF, INF, INF, INF},
						 {1, 1, 9, 1, 3, 0, 2, 12, 7, 10},
						 {INF, INF, 4, INF, INF, INF, 0, 7, INF, INF},
						 {1, 3, 2, 5, INF, INF, INF, 0, INF, INF},
						 {1, 2, 6, INF, INF, INF, INF, INF, 0, INF},
						 {INF, INF, INF, INF, INF, INF, INF, INF, 2, 0}};
		List<Integer> answer = GraphSearches.dijkstrasAlgorithm(graph, 10, 7, 0);
		Integer [] theAnswer = {7,0};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		
	}
	
	@Test
	public void testDijk17(){
		System.out.println("Dijk's Test 17 ----");
		int INF = Integer.MIN_VALUE;
		int[][] graph = {{1, 5, INF, INF, INF, 6, INF}, 
						 {1, 2, 1, INF, INF, INF, INF}, 
						 {1, INF, 3, INF, INF, INF, INF}, 
						 {0, 1, 4, 1, 6, INF, INF},
		 				 {0, 1, 1, 5, 6, 1, INF},
						 {1, 2, 1, 8, 1, 7, 3},
						 {1, 1, 3, 4, 5, 1, 8}};
		List<Integer> answer = GraphSearches.dijkstrasAlgorithm(graph, 7, 0, 0);
		Integer [] theAnswer = {0};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		
	}
	
	@Test
	public void testDijk18(){
		System.out.println("Dijk's Test 18 ----");
		int INF = Integer.MIN_VALUE;
		int[][] graph = {{1, 5, INF, INF, INF, 6, INF}, 
						 {1, 2, 1, INF, INF, INF, INF}, 
						 {1, INF, 3, INF, INF, INF, INF}, 
						 {0, 1, 4, 1, 6, INF, INF},
		 				 {0, 1, 1, 5, 6, 1, INF},
						 {1, 2, 1, 8, 1, 7, 3},
						 {1, 1, 3, 4, 5, 1, 8}};
		List<Integer> answer = GraphSearches.dijkstrasAlgorithm(graph, 7, 4, 4);
		Integer [] theAnswer = {4};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		
	}
	
	@Test
	public void testDijk19(){
		System.out.println("Dijk's Test 19 ----");
		int INF = Integer.MIN_VALUE;
		int[][] graph = {{1, 5, INF, INF, INF, 6, INF}, 
						 {1, 2, 1, INF, INF, INF, INF}, 
						 {1, INF, 3, INF, INF, INF, INF}, 
						 {0, 1, 4, 1, 6, INF, INF},
		 				 {0, 1, 1, 5, 6, 1, INF},
						 {1, 2, 1, 8, 1, 7, 3},
						 {1, 1, 3, 4, 5, 1, 8}};
		List<Integer> answer = GraphSearches.dijkstrasAlgorithm(graph, 7, 5, 4);
		Integer [] theAnswer = {5,4};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		
	}
	
	@Test
	public void testDijk20(){
		System.out.println("Dijk's Test 20 ----");
		int INF = Integer.MIN_VALUE;
		int[][] graph = {{1, 5, INF, INF, INF, 6, INF}, 
						 {1, 2, 1, INF, INF, INF, INF}, 
						 {1, INF, 3, INF, INF, INF, INF}, 
						 {0, 1, 4, 1, 6, INF, INF},
		 				 {0, 1, 1, 5, 6, 1, INF},
						 {1, 2, 1, 8, 1, 7, 3},
						 {1, 1, 3, 4, 5, 1, 8}};
		List<Integer> answer = GraphSearches.dijkstrasAlgorithm(graph, 7, 0, 4);
		Integer [] theAnswer = {0,5,4};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		
	}
	
	@Test
	public void testDijk21(){
		System.out.println("Dijk's Test 21 ----");
		int INF = Integer.MIN_VALUE;
		int[][] graph = {{0, 1, INF, 6}, 
						 {0, 1, 1, INF}, 
						 {INF, 1, 1, 1}, 
						 {0, INF, 2, 3}};
		List<Integer> answer = GraphSearches.dijkstrasAlgorithm(graph, 4, 0, 3);
		Integer [] theAnswer = {0,1,2,3};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		
	}
	
	@Test
	public void testDijk22(){
		System.out.println("Dijk's Test 22 ----");
		int INF = Integer.MIN_VALUE;
		int[][] graph = {{INF, 1, INF, 3}, 
						 {0, 1, 2, INF}, 
						 {INF, 1, 2, 3}, 
						 {0, INF, 2, 3}};
		List<Integer> answer = GraphSearches.dijkstrasAlgorithm(graph, 4, 0, 0);
		Integer [] theAnswer = {0};
		boolean shouldBeTrue = Arrays.equals(theAnswer,answer.toArray());
		assertTrue(shouldBeTrue);
		System.out.println();
		
	}
	
	
}
