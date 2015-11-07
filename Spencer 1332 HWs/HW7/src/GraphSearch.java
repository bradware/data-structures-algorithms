import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class GraphSearch {

	/**
	 * Searches the graph represented by the given AdjacencyList starting at the
	 * given start vertex, for the given goal vertex, using the algorithm based
	 * on the given structure
	 * 
	 * @param start
	 *            the starting vertex, assume it's in al
	 * @param goal
	 *            the goal vertex, assume it's in al
	 * @param al
	 *            the AdjacencyList of the graph
	 * @param s
	 *            the Abstract Structure that determines which graph searching
	 *            algorithm will be used
	 * @return the path from start to goal found in the graph search, or null of
	 *         no such path is found
	 */
	public static Path search(Vertex start, Vertex goal, AdjacencyList al,
			Structure s) {
		ArrayList<Vertex> visited = new ArrayList<Vertex>();
		Path startPath = new Path(start);
		s.add(startPath);
		while (!s.isEmpty()) {
			Path c = s.remove();
			Vertex v = c.getLastVertex();
			if (v.equals(goal))
				return c;

			if (!visited.contains(v)) {
				visited.add(v);

				TreeSet<Pair> x = (TreeSet<Pair>) al.getAdjacencies(v);
				for (Pair p : x) {
					Path path = new Path(p, c);
					s.add(path);
				}
			}
		}
		return null;
	}

	/**
	 * Explores the graph represented by the given AdjacencyList starting at the
	 * given start vertex, using the algorithm based on the given structure.
	 * This method should explore all vertices in the graph, and create a map of
	 * vertices to paths. If this map contains an Entry<Vertex, Path> = (v,p)
	 * that implies that p is the path to get from the given start vertex to the
	 * vertex v. If for a Vertex u, map.containsKey(u) returns false this
	 * implies that there is no path from start to u in the given graph.
	 * 
	 * @param start
	 *            the vertex to start exploring from
	 * @param al
	 *            the AdjacencyList representation of the graph
	 * @param s
	 *            the Structure that will determine which searching algorithm is
	 *            used
	 * @return a mapping of vertices to paths as described above
	 */
	public static Map<Vertex, Path> explore(Vertex start, AdjacencyList al,
			Structure s) {
		Path startPath = new Path(start);
		Map<Vertex, Path> map = new HashMap<Vertex, Path>();
		ArrayList<Vertex> visited = new ArrayList<Vertex>();
		s.add(startPath);
		while (!s.isEmpty()) {
			Path c = s.remove();
			Vertex v = c.getLastVertex();

			if (!visited.contains(v)) {
				visited.add(v);
				map.put(v, c);

				TreeSet<Pair> x = (TreeSet<Pair>) al.getAdjacencies(v);
				for (Pair p : x) {
					Path path = new Path(p, c);
					s.add(path);
				}
			}
		}

		return map;
	}
}
