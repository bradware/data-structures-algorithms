import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class AdjacencyList{
	
	private Map<Vertex, List<Pair>> adjacencyList;
	
	/**
	 * A list of edges will be passed in and the adjacency list will be prepared to use
	 */
	public AdjacencyList(List<Edge> edges) {
		adjacencyList = new HashMap<Vertex, List<Pair>>();
		for(Edge e: edges){
			Vertex u = e.u;
			if(adjacencyList.get(u) == null){
				List<Pair> pairList = new LinkedList<Pair>();
				Pair uNewPair = new Pair(e.v, e.weight);
				pairList.add(uNewPair);
				adjacencyList.put(u, pairList);
			}else{
				Pair uNewPair = new Pair(e.v, e.weight);
				adjacencyList.get(u).add(uNewPair);
			}
			Vertex v = e.v;
			if(adjacencyList.get(v) == null){
				List<Pair> pairList = new LinkedList<Pair>();
				Pair vNewPair = new Pair(u, e.weight);
				pairList.add(vNewPair);
				adjacencyList.put(v, pairList);
			}else{
				Pair vNewPair = new Pair(u, e.weight);
				adjacencyList.get(v).add(vNewPair);
			}
			
		}
	}

	/**
	 * @param vexter a vertex
	 * @return	a list of pair i.e. vertices and weights adjacent to vertex
	 */
	public List<Pair> adjacencies(Vertex vertex) {
		return adjacencyList.get(vertex);
		
	}
	
	/*
	 * Getters and setters
	 */
	
	public Map<Vertex, List<Pair>> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(Map<Vertex, List<Pair>> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}
}
