/**
 * This class is essentially a wrapper for an int, and we will be using it to
 * represent different vertices in a graph
 */
public class Vertex {

	private int id;

	public Vertex(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		// Note: (null instanceof Object), is defined to return false
		if (o instanceof Vertex) {
			return id == ((Vertex) o).id;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public String toString() {
		return Integer.toString(id);
	}
}