import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class TestMST {

	@Before
	public void setUp() throws Exception {

	}
	//Kruskals Output should be:
	// f d 1
	// b a 2
	// d a 3
	// e b 6
	// d c 7

	@Test
	public void testKruskal() {
		Edge edge1 = new Edge(new Vertex("a"), new Vertex("b"), 2);
		Edge edge2 = new Edge(new Vertex("c"), new Vertex("d"), 7);
		Edge edge3 = new Edge(edge1.v, edge2.u, 3);
		Edge edge4 = new Edge(edge1.v, edge2.v, 12);
		Edge edge5 = new Edge(new Vertex("e"), new Vertex("f"), 18);
		Edge edge6 = new Edge(edge1.u, edge5.v, 6);
		Edge edge7 = new Edge(edge1.u,edge5.u, 20);
		Edge edge8 = new Edge(edge2.u, edge5.u, 1);
		List<Edge> edges = new ArrayList<Edge>();
		edges.add(edge1);
		edges.add(edge2);
		edges.add(edge3);
		edges.add(edge4);
		edges.add(edge5);
		edges.add(edge6);
		edges.add(edge7);
		edges.add(edge8);
		Collection<Edge> myResult = MST.kruskals(edges);
		System.out.println("testing kruskals");
		for(Edge edge: myResult){
			System.out.print(edge.u.name + " " + edge.v.name + " " + edge.weight);
			System.out.println();
		}
		System.out.println();
	}
	
	//Prim's Output should be:
	// b a 2
	// d a 3
	// f d 1
	// e b 6
	// c d 7
	
	@Test
	public void testPrim(){
		Edge edge1 = new Edge(new Vertex("a"), new Vertex("b"), 2);
		Edge edge2 = new Edge(new Vertex("c"), new Vertex("d"), 7);
		Edge edge3 = new Edge(edge1.v, edge2.u, 3);
		Edge edge4 = new Edge(edge1.v, edge2.v, 12);
		Edge edge5 = new Edge(new Vertex("e"), new Vertex("f"), 18);
		Edge edge6 = new Edge(edge1.u, edge5.v, 6);
		Edge edge7 = new Edge(edge1.u,edge5.u, 20);
		Edge edge8 = new Edge(edge2.u, edge5.u, 1);
		List<Edge> edges = new ArrayList<Edge>();
		edges.add(edge1);
		edges.add(edge2);
		edges.add(edge3);
		edges.add(edge4);
		edges.add(edge5);
		edges.add(edge6);
		edges.add(edge7);
		edges.add(edge8);
		AdjacencyList adjacentVertices = new AdjacencyList(edges);
		Collection<Edge> myResult = MST.prims(edge1.v, adjacentVertices);
		System.out.println("testing prims");
		for(Edge edge: myResult){
			System.out.print(edge.u.name + " " + edge.v.name + " " + edge.weight);
			System.out.println();
		}
	}
}

