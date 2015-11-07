import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * An Iterable (in ascending order by weight) list of edges.
 */
public class EdgeList implements Iterable<Edge> {

	private Set<Vertex> vertices;
	private Collection<Edge> edges;

	/**
	 * Constructs the EdgeList representing a graph from a String.
	 * 
	 * @param edgeList
	 */
	public EdgeList(String edgeList) {
		vertices = new HashSet<Vertex>();
		edges = new ArrayList<Edge>();
		Scanner sc = new Scanner(edgeList);
		int count = sc.nextInt();
		for (int i = 0; i < count; i++) {
			Vertex u = new Vertex(sc.nextInt());
			Vertex v = new Vertex(sc.nextInt());
			int w = sc.nextInt();
			// Sets don't allow duplicates. Just add them.
			vertices.add(u);
			vertices.add(v);
			edges.add(new Edge(u, v, w));
		}
	}

	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder("");
		for (Edge e : edges) {
			ret.append(e.toString() + "\n");
		}
		return ret.toString();
	}

	@Override
	public Iterator<Edge> iterator() {
		return new AscendingIterator<Edge>(edges);
	}

	public Collection<Edge> getEdges() {
		return edges;
	}

	public Set<Vertex> getVertices() {
		return vertices;
	}

	public void setVertices(Set<Vertex> vertices) {
		this.vertices = vertices;
	}

	public void setEdges(Collection<Edge> edges) {
		this.edges = edges;
	}
}