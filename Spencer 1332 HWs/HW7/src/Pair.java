
/**
 * This class contains a Vertex and an associated weight. Used for the Path and
 * AdjacencyList class. The only reason it is comparable is to allow a distinct
 * ordering for the AdjacencyList class.
 */
public class Pair implements Comparable<Pair> {

	/**
	 * A timer for grading purposes to make sure that vertices are explored in a
	 * specific order
	 */
	private static int timer = 0;
	private int time;

	private Vertex vertex;
	private int weight;

	public Pair(Vertex vertex, int weight) {
		this.time = timer++;
		this.vertex = vertex;
		this.weight = weight;
	}

	public Vertex getVertex() {
		return vertex;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Pair) {
			Pair that = (Pair) o;
			return this.vertex.equals(that.vertex)
					&& this.weight == that.weight;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return vertex.hashCode() ^ weight;
	}

	@Override
	public int compareTo(Pair that) {
		if (equals(that))
			return 0;
		else
			return this.time - that.time;
	}

	@Override
	public String toString() {
		return String.format("(%s,%d)", vertex.toString(), weight);
	}
}