import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class MST {

	/**
	 * Find MST using Kruskal's algorithm. Follow the instructions in the pdf.
	 * 
	 * @param edges
	 *            the edge list that represents the graph
	 * @return a collection of edges that represent the MST
	 */
	public static Collection<Edge> kruskals(List<Edge> edges) {
		PriorityQueue<Edge> pQueue = new PriorityQueue<Edge>();
		Collection<Edge> edgeList = new LinkedList<Edge>();// final list to be returned
		if(edges == null){
		    return edgeList;
		}		
		Set<Vertex> djSet = new HashSet<Vertex>();
		for (Edge e : edges) {
			pQueue.add(e);
			djSet.add(e.u);
			djSet.add(e.v);
		}
		DisjointSets<Vertex> disjointSet = new DisjointSets<Vertex>(djSet);
		while (!pQueue.isEmpty()) {
			Edge e = pQueue.poll();
			Vertex uRoot = disjointSet.findParent(e.u);
			Vertex vRoot = disjointSet.findParent(e.v);
			if (!uRoot.equals(vRoot)) {
				edgeList.add(e);
				disjointSet.merge(e.u, e.v);
			}
		}
		return edgeList;
	}

	/**
	 * Implement Prim's algo-rhythm!
	 * 
	 * @param start
	 *            the starting vertex of the MST, you are guaranteed that it is
	 *            contained in the AdjacencyList
	 * @param graph
	 *            the adjacency list that represents the graph. You need to find
	 *            MST for this graph
	 * @return a collection of edges that represent the MST of the graph
	 */
	public static Collection<Edge> prims(Vertex start, AdjacencyList graph) {
	    LinkedList<Vertex> visitedList = new LinkedList<Vertex>();
        Collection<Edge> edgeList = new LinkedList<Edge>();
		PriorityQueue<Edge> pQueue = new PriorityQueue<Edge>();
		if(start == null || graph == null){
		    return edgeList;
		}
		for (Pair p : graph.adjacencies(start)) {
			Edge newEdge = new Edge(start, p.vertex, p.weight);
			pQueue.add(newEdge);
		}
		while (!pQueue.isEmpty()) {
			Edge current = pQueue.poll();
			if(visitedList.contains(current.v) && visitedList.contains(current.u)) {//don't need this check
				continue;
			} else{
				edgeList.add(current);
				visitedList.add(current.v);
				visitedList.add(current.u);
				for (Pair p : graph.adjacencies(current.u)) {
					if (!visitedList.contains(p.vertex)) {
						Edge newEdge = new Edge(current.u, p.vertex, p.weight);
						pQueue.add(newEdge);
					}
				}
				for (Pair p : graph.adjacencies(current.v)) {
					if (!visitedList.contains(p.vertex)) {
						Edge newEdge = new Edge(current.v, p.vertex, p.weight);
						pQueue.add(newEdge);
					}
				}
			}
		}
		return edgeList;
	}

}
