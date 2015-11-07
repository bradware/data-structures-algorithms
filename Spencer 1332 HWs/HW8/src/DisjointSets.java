import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public class DisjointSets {

	private Set<Vertex> vertices;
	private HashMap<Vertex, Vertex> map; 

	/**
	 * This constructor could do any number of things. Feel free to add instance
	 * variables if you need them. You may assume the methods sameSet, and merge
	 * will only be called with vertices that are in the set vertex set passed
	 * in here
	 * 
	 * @param vertices
	 *            All vertices that are valid parameters for this disjoint set
	 */
	public DisjointSets(Set<Vertex> vertices) {
		if(vertices == null || vertices.isEmpty())
			return;
		this.vertices = vertices;
		map = new HashMap<Vertex, Vertex>();
		Object[] array = vertices.toArray();
		for(Vertex v : vertices) {
			map.put(v,v);
		}
	}

	/**
	 * 
	 * Finds the parent Vertex of u, if not found it returns null
	 * 
	 * @param u
	 * @return the parent Vertex of u
	 */
	public Vertex find(Vertex vertex) {
		return map.get(vertex);
	}

	/**
	 * Returns true if and only if u and v belong to the same set.
	 * 
	 * Hint: a "Vertex find(Vertex v)" helper might be useful.
	 * 
	 * @param u
	 * @param v
	 * @return
	 */
	public boolean sameSet(Vertex u, Vertex v) {
		return find(u).equals(find(v));
	}

	/**
	 * Merges the set containing u with the set containing v. If u and v are in
	 * the same set do nothing
	 * 
	 * @param u
	 * @param v
	 */
	public void merge(Vertex u, Vertex v) {
		if(sameSet(u,v))
			return;
		Vertex root = find(v);
		Vertex newRoot= find(u);
		for(Vertex vertex : vertices) {
			if(map.get(vertex).equals(root)) {
				map.remove(vertex);
				map.put(vertex, newRoot);
			}
		}
	}
}