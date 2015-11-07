
import java.util.ArrayList;
import java.util.Collection;

/**
 * An abstract class whose only purpose in life is to run Kruskal's algorithm.
 * 
 * @author
 * 
 */
public abstract class MST {

	/**
	 * Run kruskal's algorithm on the given EdgeList and return a collection of
	 * edges.
	 * 
	 * @param edges
	 * @return
	 */
	public static Collection<Edge> kruskal(EdgeList edges) {
		if(edges == null || edges.getVertices().size()== 0)
			return null;
		DisjointSets sets = new DisjointSets(edges.getVertices());
		Collection<Edge> c = new ArrayList<Edge>();
		for (Edge e : edges) {
			Vertex[] vertices = e.vertices();
			if (!sets.sameSet(vertices[0], vertices[1])) {
				sets.merge(vertices[0], vertices[1]);
				c.add(e);
			}
		}
		return c;
	}

}