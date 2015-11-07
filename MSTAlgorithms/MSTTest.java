import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;


public class MSTTest {
	
	@Test
	public void AdjacencyListTestV1(){
		Vertex V1 = new Vertex("V1");
		Vertex V2 = new Vertex("V2");
		Vertex V3 = new Vertex("V3");
		Vertex V4 = new Vertex("V4");
		Vertex V5 = new Vertex("V5");
		Vertex V6 = new Vertex("V6");
		Vertex V7 = new Vertex("V7");
		List<Edge> edgeList = new LinkedList<Edge>();
		edgeList.add(new Edge(V1, V2, 2));
		edgeList.add(new Edge(V2, V5, 10));
		edgeList.add(new Edge(V5, V7, 6));
		edgeList.add(new Edge(V6, V7, 1));
		edgeList.add(new Edge(V3, V6, 5));
		edgeList.add(new Edge(V1, V3, 4));
		edgeList.add(new Edge(V1, V4, 1));
		edgeList.add(new Edge(V3, V4, 2));
		edgeList.add(new Edge(V2, V4, 3));
		edgeList.add(new Edge(V4, V6, 8));
		edgeList.add(new Edge(V4, V7, 4));
		edgeList.add(new Edge(V4, V5, 7));
		AdjacencyList adjacencyList = new AdjacencyList(edgeList);
		List<Pair> V1pairList = new LinkedList<Pair>();
		V1pairList.add(new Pair(V4, 1));
		V1pairList.add(new Pair(V2, 2));
		V1pairList.add(new Pair(V3, 4));
		List<Pair> codeList = adjacencyList.adjacencies(V1);
		Boolean shouldBeTrue = V1pairList.containsAll(codeList);
		assertTrue(shouldBeTrue);
	}
	
	@Test
	public void AdjacencyListTestV2(){
		Vertex V1 = new Vertex("V1");
		Vertex V2 = new Vertex("V2");
		Vertex V3 = new Vertex("V3");
		Vertex V4 = new Vertex("V4");
		Vertex V5 = new Vertex("V5");
		Vertex V6 = new Vertex("V6");
		Vertex V7 = new Vertex("V7");
		List<Edge> edgeList = new LinkedList<Edge>();
		edgeList.add(new Edge(V1, V2, 2));
		edgeList.add(new Edge(V2, V5, 10));
		edgeList.add(new Edge(V5, V7, 6));
		edgeList.add(new Edge(V6, V7, 1));
		edgeList.add(new Edge(V3, V6, 5));
		edgeList.add(new Edge(V1, V3, 4));
		edgeList.add(new Edge(V1, V4, 1));
		edgeList.add(new Edge(V3, V4, 2));
		edgeList.add(new Edge(V2, V4, 3));
		edgeList.add(new Edge(V4, V6, 8));
		edgeList.add(new Edge(V4, V7, 4));
		edgeList.add(new Edge(V4, V5, 7));
		AdjacencyList adjacencyList = new AdjacencyList(edgeList);
		List<Pair> V2pairList = new LinkedList<Pair>();
		V2pairList.add(new Pair(V1, 2));
		V2pairList.add(new Pair(V5, 10));
		V2pairList.add(new Pair(V4, 3));
		List<Pair> codeList = adjacencyList.adjacencies(V2);
		Boolean shouldBeTrue = V2pairList.containsAll(codeList);
		assertTrue(shouldBeTrue);
	}
	
	@Test
	public void AdjacencyListTestV3(){
		Vertex V1 = new Vertex("V1");
		Vertex V2 = new Vertex("V2");
		Vertex V3 = new Vertex("V3");
		Vertex V4 = new Vertex("V4");
		Vertex V5 = new Vertex("V5");
		Vertex V6 = new Vertex("V6");
		Vertex V7 = new Vertex("V7");
		List<Edge> edgeList = new LinkedList<Edge>();
		edgeList.add(new Edge(V1, V2, 2));
		edgeList.add(new Edge(V2, V5, 10));
		edgeList.add(new Edge(V5, V7, 6));
		edgeList.add(new Edge(V6, V7, 1));
		edgeList.add(new Edge(V3, V6, 5));
		edgeList.add(new Edge(V1, V3, 4));
		edgeList.add(new Edge(V1, V4, 1));
		edgeList.add(new Edge(V3, V4, 2));
		edgeList.add(new Edge(V2, V4, 3));
		edgeList.add(new Edge(V4, V6, 8));
		edgeList.add(new Edge(V4, V7, 4));
		edgeList.add(new Edge(V4, V5, 7));
		AdjacencyList adjacencyList = new AdjacencyList(edgeList);
		List<Pair> V3pairList = new LinkedList<Pair>();
		V3pairList.add(new Pair(V1, 4));
		V3pairList.add(new Pair(V4, 2));
		V3pairList.add(new Pair(V6, 5));
		List<Pair> codeList = adjacencyList.adjacencies(V3);
		Boolean shouldBeTrue = V3pairList.containsAll(codeList);
		assertTrue(shouldBeTrue);
	}
	
	@Test
	public void AdjacencyListTestV4(){
		Vertex V1 = new Vertex("V1");
		Vertex V2 = new Vertex("V2");
		Vertex V3 = new Vertex("V3");
		Vertex V4 = new Vertex("V4");
		Vertex V5 = new Vertex("V5");
		Vertex V6 = new Vertex("V6");
		Vertex V7 = new Vertex("V7");
		List<Edge> edgeList = new LinkedList<Edge>();
		edgeList.add(new Edge(V1, V2, 2));
		edgeList.add(new Edge(V2, V5, 10));
		edgeList.add(new Edge(V5, V7, 6));
		edgeList.add(new Edge(V6, V7, 1));
		edgeList.add(new Edge(V3, V6, 5));
		edgeList.add(new Edge(V1, V3, 4));
		edgeList.add(new Edge(V1, V4, 1));
		edgeList.add(new Edge(V3, V4, 2));
		edgeList.add(new Edge(V2, V4, 3));
		edgeList.add(new Edge(V4, V6, 8));
		edgeList.add(new Edge(V4, V7, 4));
		edgeList.add(new Edge(V4, V5, 7));
		AdjacencyList adjacencyList = new AdjacencyList(edgeList);
		List<Pair> V4pairList = new LinkedList<Pair>();
		V4pairList.add(new Pair(V1, 1));
		V4pairList.add(new Pair(V2, 3));
		V4pairList.add(new Pair(V5, 7));
		V4pairList.add(new Pair(V7, 4));
		V4pairList.add(new Pair(V6, 8));
		V4pairList.add(new Pair(V3, 2));
		List<Pair> codeList = adjacencyList.adjacencies(V4);
		Boolean shouldBeTrue = V4pairList.containsAll(codeList);
		assertTrue(shouldBeTrue);
	}
	
	
	@Test
	public void AdjacencyListTestV5(){
		Vertex V1 = new Vertex("V1");
		Vertex V2 = new Vertex("V2");
		Vertex V3 = new Vertex("V3");
		Vertex V4 = new Vertex("V4");
		Vertex V5 = new Vertex("V5");
		Vertex V6 = new Vertex("V6");
		Vertex V7 = new Vertex("V7");
		List<Edge> edgeList = new LinkedList<Edge>();
		edgeList.add(new Edge(V1, V2, 2));
		edgeList.add(new Edge(V2, V5, 10));
		edgeList.add(new Edge(V5, V7, 6));
		edgeList.add(new Edge(V6, V7, 1));
		edgeList.add(new Edge(V3, V6, 5));
		edgeList.add(new Edge(V1, V3, 4));
		edgeList.add(new Edge(V1, V4, 1));
		edgeList.add(new Edge(V3, V4, 2));
		edgeList.add(new Edge(V2, V4, 3));
		edgeList.add(new Edge(V4, V6, 8));
		edgeList.add(new Edge(V4, V7, 4));
		edgeList.add(new Edge(V4, V5, 7));
		AdjacencyList adjacencyList = new AdjacencyList(edgeList);
		List<Pair> V5pairList = new LinkedList<Pair>();
		V5pairList.add(new Pair(V2, 10));
		V5pairList.add(new Pair(V7, 6));
		V5pairList.add(new Pair(V4, 7));
		List<Pair> codeList = adjacencyList.adjacencies(V5);
		Boolean shouldBeTrue = V5pairList.containsAll(codeList);
		assertTrue(shouldBeTrue);
	}
	
	@Test
	public void AdjacencyListTestV6(){
		Vertex V1 = new Vertex("V1");
		Vertex V2 = new Vertex("V2");
		Vertex V3 = new Vertex("V3");
		Vertex V4 = new Vertex("V4");
		Vertex V5 = new Vertex("V5");
		Vertex V6 = new Vertex("V6");
		Vertex V7 = new Vertex("V7");
		List<Edge> edgeList = new LinkedList<Edge>();
		edgeList.add(new Edge(V1, V2, 2));
		edgeList.add(new Edge(V2, V5, 10));
		edgeList.add(new Edge(V5, V7, 6));
		edgeList.add(new Edge(V6, V7, 1));
		edgeList.add(new Edge(V3, V6, 5));
		edgeList.add(new Edge(V1, V3, 4));
		edgeList.add(new Edge(V1, V4, 1));
		edgeList.add(new Edge(V3, V4, 2));
		edgeList.add(new Edge(V2, V4, 3));
		edgeList.add(new Edge(V4, V6, 8));
		edgeList.add(new Edge(V4, V7, 4));
		edgeList.add(new Edge(V4, V5, 7));
		AdjacencyList adjacencyList = new AdjacencyList(edgeList);
		List<Pair> V6pairList = new LinkedList<Pair>();
		V6pairList.add(new Pair(V3, 5));
		V6pairList.add(new Pair(V7, 1));
		V6pairList.add(new Pair(V4, 8));
		List<Pair> codeList = adjacencyList.adjacencies(V6);
		Boolean shouldBeTrue = V6pairList.containsAll(codeList);
		assertTrue(shouldBeTrue);
	}
	
	@Test
	public void AdjacencyListTestV7(){
		Vertex V1 = new Vertex("V1");
		Vertex V2 = new Vertex("V2");
		Vertex V3 = new Vertex("V3");
		Vertex V4 = new Vertex("V4");
		Vertex V5 = new Vertex("V5");
		Vertex V6 = new Vertex("V6");
		Vertex V7 = new Vertex("V7");
		List<Edge> edgeList = new LinkedList<Edge>();
		edgeList.add(new Edge(V1, V2, 2));
		edgeList.add(new Edge(V2, V5, 10));
		edgeList.add(new Edge(V5, V7, 6));
		edgeList.add(new Edge(V6, V7, 1));
		edgeList.add(new Edge(V3, V6, 5));
		edgeList.add(new Edge(V1, V3, 4));
		edgeList.add(new Edge(V1, V4, 1));
		edgeList.add(new Edge(V3, V4, 2));
		edgeList.add(new Edge(V2, V4, 3));
		edgeList.add(new Edge(V4, V6, 8));
		edgeList.add(new Edge(V4, V7, 4));
		edgeList.add(new Edge(V4, V5, 7));
		AdjacencyList adjacencyList = new AdjacencyList(edgeList);
		List<Pair> V7pairList = new LinkedList<Pair>();
		V7pairList.add(new Pair(V6, 1));
		V7pairList.add(new Pair(V5, 6));
		V7pairList.add(new Pair(V4, 4));
		List<Pair> codeList = adjacencyList.adjacencies(V7);
		Boolean shouldBeTrue = V7pairList.containsAll(codeList);
		assertTrue(shouldBeTrue);
	}
	
	@Test
	public void DisjointSetTestV1(){
		Set<Vertex> vertexSet = new HashSet<Vertex>();
		Vertex V1 = new Vertex("V1");
		Vertex V2 = new Vertex("V2");
		Vertex V3 = new Vertex("V3");
		Vertex V4 = new Vertex("V4");
		Vertex V5 = new Vertex("V5");
		Vertex V6 = new Vertex("V6");
		Vertex V7 = new Vertex("V7");
		vertexSet.add(V1);
		vertexSet.add(V2);
		vertexSet.add(V3);
		vertexSet.add(V4);
		vertexSet.add(V5);
		vertexSet.add(V6);
		vertexSet.add(V7);
		DisjointSets<Vertex> disjointSet = new DisjointSets(vertexSet);
		String parent = disjointSet.findParent(V1).name;
		assertEquals("V1",parent);
		disjointSet.merge(V2, V3);
		disjointSet.merge(V1, V2);
		String parent1 = disjointSet.findParent(V1).name;
		assertEquals("V3", parent1);
		disjointSet.merge(V3, V2);
		String parent2 = disjointSet.findParent(V1).name;
		assertEquals("V3", parent2);
	}
	
	@Test
	public void DisjointSetTestV2(){
		Set<Vertex> vertexSet = new HashSet<Vertex>();
		Vertex V1 = new Vertex("V1");
		Vertex V2 = new Vertex("V2");
		Vertex V3 = new Vertex("V3");
		Vertex V4 = new Vertex("V4");
		Vertex V5 = new Vertex("V5");
		Vertex V6 = new Vertex("V6");
		Vertex V7 = new Vertex("V7");
		vertexSet.add(V1);
		vertexSet.add(V2);
		vertexSet.add(V3);
		vertexSet.add(V4);
		vertexSet.add(V5);
		vertexSet.add(V6);
		vertexSet.add(V7);
		DisjointSets<Vertex> disjointSet = new DisjointSets(vertexSet);
		String parent = disjointSet.findParent(V2).name;
		assertEquals("V2",parent);
		disjointSet.merge(V5, V7);
		disjointSet.merge(V1, V4);
		disjointSet.merge(V4, V7);
		String parent1 = disjointSet.findParent(V2).name;
		assertEquals("V2", parent1);
		disjointSet.merge(V3, V2);
		String parent2 = disjointSet.findParent(V3).name;
		assertEquals("V2", parent2);
		disjointSet.merge(V2, V3);
		String parent3 = disjointSet.findParent(V2).name;
		assertEquals("V2", parent3);
		disjointSet.merge(V2, V4);
		String parent4 = disjointSet.findParent(V2).name;
		assertEquals("V7", parent4);
	}
	
	@Test
	public void DisjointSetTestV3(){
		Set<Vertex> vertexSet = new HashSet<Vertex>();
		Vertex V1 = new Vertex("V1");
		Vertex V2 = new Vertex("V2");
		Vertex V3 = new Vertex("V3");
		Vertex V4 = new Vertex("V4");
		Vertex V5 = new Vertex("V5");
		Vertex V6 = new Vertex("V6");
		Vertex V7 = new Vertex("V7");
		vertexSet.add(V1);
		vertexSet.add(V2);
		vertexSet.add(V3);
		vertexSet.add(V4);
		vertexSet.add(V5);
		vertexSet.add(V6);
		vertexSet.add(V7);
		DisjointSets<Vertex> disjointSet = new DisjointSets(vertexSet);
		String parent = disjointSet.findParent(V3).name;
		assertEquals("V3",parent);
		disjointSet.merge(V5, V7);
		disjointSet.merge(V1, V4);
		disjointSet.merge(V4, V7);
		String parent1 = disjointSet.findParent(V3).name;
		assertEquals("V3", parent1);
		disjointSet.merge(V3, V2);
		String parent2 = disjointSet.findParent(V3).name;
		assertEquals("V2", parent2);
		disjointSet.merge(V2, V3);
		String parent3 = disjointSet.findParent(V3).name;
		assertEquals("V2", parent3);
		disjointSet.merge(V2, V4);
		String parent4 = disjointSet.findParent(V3).name;
		assertEquals("V7", parent4);
	}
	
	@Test
	public void DisjointSetTestV4(){
		Set<Vertex> vertexSet = new HashSet<Vertex>();
		Vertex V1 = new Vertex("V1");
		Vertex V2 = new Vertex("V2");
		Vertex V3 = new Vertex("V3");
		Vertex V4 = new Vertex("V4");
		Vertex V5 = new Vertex("V5");
		Vertex V6 = new Vertex("V6");
		Vertex V7 = new Vertex("V7");
		vertexSet.add(V1);
		vertexSet.add(V2);
		vertexSet.add(V3);
		vertexSet.add(V4);
		vertexSet.add(V5);
		vertexSet.add(V6);
		vertexSet.add(V7);
		DisjointSets<Vertex> disjointSet = new DisjointSets(vertexSet);
		String parent = disjointSet.findParent(V4).name;
		assertEquals("V4",parent);
		disjointSet.merge(V5, V7);
		disjointSet.merge(V1, V4);
		disjointSet.merge(V4, V7);
		String parent1 = disjointSet.findParent(V4).name;
		assertEquals("V7", parent1);
		disjointSet.merge(V4, V2);
		String parent2 = disjointSet.findParent(V4).name;
		assertEquals("V2", parent2);
		disjointSet.merge(V2, V3);
		String parent3 = disjointSet.findParent(V4).name;
		assertEquals("V3", parent3);
		disjointSet.merge(V2, V4);
		String parent4 = disjointSet.findParent(V4).name;
		assertEquals("V3", parent4);
	}
	
	@Test
	public void DisjointSetTestV5(){
		Set<Vertex> vertexSet = new HashSet<Vertex>();
		Vertex V1 = new Vertex("V1");
		Vertex V2 = new Vertex("V2");
		Vertex V3 = new Vertex("V3");
		Vertex V4 = new Vertex("V4");
		Vertex V5 = new Vertex("V5");
		Vertex V6 = new Vertex("V6");
		Vertex V7 = new Vertex("V7");
		vertexSet.add(V1);
		vertexSet.add(V2);
		vertexSet.add(V3);
		vertexSet.add(V4);
		vertexSet.add(V5);
		vertexSet.add(V6);
		vertexSet.add(V7);
		DisjointSets<Vertex> disjointSet = new DisjointSets(vertexSet);
		String parent = disjointSet.findParent(V5).name;
		assertEquals("V5",parent);
		disjointSet.merge(V5, V7);
		disjointSet.merge(V1, V4);
		disjointSet.merge(V4, V7);
		String parent1 = disjointSet.findParent(V5).name;
		assertEquals("V7", parent1);
		disjointSet.merge(V4, V2);
		String parent2 = disjointSet.findParent(V4).name;
		assertEquals("V2", parent2);
		disjointSet.merge(V5, V3);
		String parent3 = disjointSet.findParent(V5).name;
		assertEquals("V3", parent3);
		disjointSet.merge(V2, V4);
		String parent4 = disjointSet.findParent(V5).name;
		assertEquals("V3", parent4);
		
	}
	
	@Test
	public void DisjointSetTestV6(){
		Set<Vertex> vertexSet = new HashSet<Vertex>();
		Vertex V1 = new Vertex("V1");
		Vertex V2 = new Vertex("V2");
		Vertex V3 = new Vertex("V3");
		Vertex V4 = new Vertex("V4");
		Vertex V5 = new Vertex("V5");
		Vertex V6 = new Vertex("V6");
		Vertex V7 = new Vertex("V7");
		vertexSet.add(V1);
		vertexSet.add(V2);
		vertexSet.add(V3);
		vertexSet.add(V4);
		vertexSet.add(V5);
		vertexSet.add(V6);
		vertexSet.add(V7);
		DisjointSets<Vertex> disjointSet = new DisjointSets(vertexSet);
		String parent = disjointSet.findParent(V6).name;
		assertEquals("V6",parent);
		disjointSet.merge(V5, V7);
		disjointSet.merge(V1, V4);
		disjointSet.merge(V6, V3);
		String parent1 = disjointSet.findParent(V6).name;
		assertEquals("V3", parent1);
		disjointSet.merge(V4, V2);
		String parent2 = disjointSet.findParent(V6).name;
		assertEquals("V3", parent2);
		disjointSet.merge(V2, V1);
		String parent3 = disjointSet.findParent(V4).name;
		assertEquals("V2", parent3);
		disjointSet.merge(V3, V4);
		String parent4 = disjointSet.findParent(V6).name;
		assertEquals("V2", parent4);
		
	}
	
	@Test
	public void DisjointSetTestV7(){
		Set<Vertex> vertexSet = new HashSet<Vertex>();
		Vertex V1 = new Vertex("V1");
		Vertex V2 = new Vertex("V2");
		Vertex V3 = new Vertex("V3");
		Vertex V4 = new Vertex("V4");
		Vertex V5 = new Vertex("V5");
		Vertex V6 = new Vertex("V6");
		Vertex V7 = new Vertex("V7");
		vertexSet.add(V1);
		vertexSet.add(V2);
		vertexSet.add(V3);
		vertexSet.add(V4);
		vertexSet.add(V5);
		vertexSet.add(V6);
		vertexSet.add(V7);
		DisjointSets<Vertex> disjointSet = new DisjointSets(vertexSet);
		String parent = disjointSet.findParent(V7).name;
		assertEquals("V7",parent);
		disjointSet.merge(V5, V7);
		disjointSet.merge(V7, V4);
		disjointSet.merge(V2, V3);
		String parent1 = disjointSet.findParent(V7).name;
		assertEquals("V4", parent1);
		disjointSet.merge(V4, V2);
		String parent2 = disjointSet.findParent(V7).name;
		assertEquals("V3", parent2);
		disjointSet.merge(V2, V1);
		String parent3 = disjointSet.findParent(V7).name;
		assertEquals("V1", parent3);
		disjointSet.merge(V3, V4);
		String parent4 = disjointSet.findParent(V7).name;
		assertEquals("V1", parent4);
		
	}
	
	@Test
	public void kruskelsTest(){
		Vertex V1 = new Vertex("V1");
		Vertex V2 = new Vertex("V2");
		Vertex V3 = new Vertex("V3");
		Vertex V4 = new Vertex("V4");
		Vertex V5 = new Vertex("V5");
		Vertex V6 = new Vertex("V6");
		Vertex V7 = new Vertex("V7");
		List<Edge> edgeList = new LinkedList<Edge>();
		Edge e1 = new Edge(V1, V2, 2);
		Edge e2 = new Edge(V2, V5, 10);
		Edge e3 = new Edge(V5, V7, 6);
		Edge e4 = new Edge(V6, V7, 1);
		Edge e5 = new Edge(V3, V6, 5);
		Edge e6 = new Edge(V1, V3, 4);
		Edge e7 = new Edge(V1, V4, 1);
		Edge e8 = new Edge(V3, V4, 2);
		Edge e9 = new Edge(V2, V4, 3);
		Edge e10 = new Edge(V4, V6, 8);
		Edge e11 = new Edge(V4, V7, 4);
		Edge e12 = new Edge(V4, V5, 7);
		edgeList.add(e1);
		edgeList.add(e2);
		edgeList.add(e3);
		edgeList.add(e4);
		edgeList.add(e5);
		edgeList.add(e6);
		edgeList.add(e7);
		edgeList.add(e8);
		edgeList.add(e9);
		edgeList.add(e10);
		edgeList.add(e11);
		edgeList.add(e12);
		List<Edge> codeList = (List<Edge>)MST.kruskals(edgeList);
		List<Edge> answerList = new LinkedList<Edge>();
		answerList.add(e7);
		answerList.add(e4);
		answerList.add(e8);
		answerList.add(e1);
		answerList.add(e11);
		answerList.add(e3);
		Boolean shouldBeTrue = codeList.containsAll(answerList);
		assertTrue(shouldBeTrue);
		
		
	}
	
	

	@Test
	public void primsTest(){
		Vertex V1 = new Vertex("V1");
		Vertex V2 = new Vertex("V2");
		Vertex V3 = new Vertex("V3");
		Vertex V4 = new Vertex("V4");
		Vertex V5 = new Vertex("V5");
		Vertex V6 = new Vertex("V6");
		Vertex V7 = new Vertex("V7");
		List<Edge> edgeList = new LinkedList<Edge>();
		Edge e1 = new Edge(V1, V2, 2);
		Edge e2 = new Edge(V2, V5, 10);
		Edge e3 = new Edge(V5, V7, 6);
		Edge e4 = new Edge(V6, V7, 1);
		Edge e5 = new Edge(V3, V6, 5);
		Edge e6 = new Edge(V1, V3, 4);
		Edge e7 = new Edge(V1, V4, 1);
		Edge e8 = new Edge(V3, V4, 2);
		Edge e9 = new Edge(V2, V4, 3);
		Edge e10 = new Edge(V4, V6, 8);
		Edge e11 = new Edge(V4, V7, 4);
		Edge e12 = new Edge(V4, V5, 7);
		edgeList.add(e1);
		edgeList.add(e2);
		edgeList.add(e3);
		edgeList.add(e4);
		edgeList.add(e5);
		edgeList.add(e6);
		edgeList.add(e7);
		edgeList.add(e8);
		edgeList.add(e9);
		edgeList.add(e10);
		edgeList.add(e11);
		edgeList.add(e12);
		AdjacencyList adjacentList = new AdjacencyList(edgeList);
		Collection<Edge> codeList = MST.prims(V1, adjacentList);
		Collection<Edge> answerList = new LinkedList<Edge>();
		answerList.add(e7);
		answerList.add(e8);
		answerList.add(e1);
		answerList.add(e11);
		answerList.add(e4);
		answerList.add(e3);
		Boolean shouldBeTrue = codeList.containsAll(answerList);
		assertTrue(shouldBeTrue);
		
		
	}
}
