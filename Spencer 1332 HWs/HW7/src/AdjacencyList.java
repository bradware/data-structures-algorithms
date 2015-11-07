import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.Scanner;
import java.util.TreeSet;

public class AdjacencyList {

	/**
	 * A map of vertices to their Adjacencies and the weight associated with
	 * each edge
	 */
	private Map<Vertex, SortedSet<Pair>> al;
	private SortedSet<Pair> set1;
	private SortedSet<Pair> set2;
	private int edges;
	private int weight;
	/**
	 * Constructs an adjacency list
	 * @param edgeList
	 */
	public AdjacencyList(String edgeList) {
		Scanner scan = new Scanner(edgeList);
		edges = scan.nextInt();
		System.out.println(edges);
		al = new HashMap<Vertex, SortedSet<Pair>>();
		
		for(int i = 0; i < edges; i++){
			Vertex v1 = new Vertex(scan.nextInt());
			Vertex v2 = new Vertex(scan.nextInt());
			weight = scan.nextInt();
			
			if(al.containsKey(v1))
				al.get(v1).add(new Pair(v2, weight));
			
			else{
				set1 = new TreeSet<Pair>();
				set1.add(new Pair(v2, weight));
				al.put(v1, set1);
			}
				
			
			if(al.containsKey(v2))
				al.get(v2).add(new Pair(v1, weight));
				
				
			else{
				set2 = new TreeSet<Pair>();
				set2.add(new Pair(v1, weight));
				al.put(v2, set2);
			}
		}
		System.out.println(al.values());
		
	}
	/**
	 * gets v's adjacent vertices
	 * @param v
	 * @return a sorted set of adjacent vertices
	 */
	public SortedSet<Pair> getAdjacencies(Vertex v) {
		return al.get(v);
	}
	
	// used for grading
	
	public void setAl(Map<Vertex, SortedSet<Pair>> al) {
		this.al = al;
	}
}