public class Edge implements Comparable<Edge> {

	private Vertex u, v;
	private int weight;

	public Edge(Vertex u, Vertex v, int weight) {
		this.u = u;
		this.v = v;
		this.weight = weight;
	}

	public Vertex[] vertices() {
		return new Vertex[] { u, v };
	}

	public String toString() {
		return "<" + u.getId() + "," + v.getId() + ":" + weight + ">";
	}

	@Override
	public int compareTo(Edge that) {
		if (this.weight == that.weight) {
			int thisMin = Math.min(this.u.getId(), this.v.getId());
			int thatMin = Math.min(that.u.getId(), that.v.getId());
			if (thisMin == thatMin) {
				return Math.max(this.u.getId(), this.v.getId())
						- Math.max(that.u.getId(), that.v.getId());
			} else {
				return thisMin - thatMin;
			}
		} else {
			return this.weight - that.weight;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Edge) {
			Edge e = (Edge) o;
			return weight == e.weight
					&& ((u.equals(e.u) && v.equals(e.v)) || (u.equals(e.v) && v
							.equals(e.u)));
		} else {
			return false;
		}
	}

	public int hashCode() {
		// XOR is commutative, so this is okay
		return weight ^ u.getId() ^ v.getId();
	}
}