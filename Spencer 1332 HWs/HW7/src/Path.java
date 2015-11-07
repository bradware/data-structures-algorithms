
import java.util.ArrayList;
import java.util.List;

/**
 * This class is an Immutable List that allows us to represent paths between
 * vertices in a weighted graph. These paths are comparable based on their total
 * weight and the time they were created
 */
public class Path implements Comparable<Path> {

	/**
	 * This timer allows us to guarantee that all paths are distinct as defined
	 * by compareTo, only useful for grading purposes.
	 */
	private static int timer = 0;

	/**
	 * The order in which this path was created relative to other paths
	 */
	private int time;

	/**
	 * This is the total weight of the path
	 */
	private int weight;

	/**
	 * This is a list of all of the vertices in the path, it should contain a
	 * pair for start that has weight 0, and it should never be null -- this
	 * means make sure that the list is initialized in EVERY constructor
	 */
	private List<Pair> list;

	/**
	 * Creates a new path with the given start vertex
	 * 
	 * @param start
	 */
	public Path(Vertex start) {
		time = timer++;
		weight = 0;
		list = new ArrayList<Pair>();
		list.add(new Pair(start, 0));
	}

	/**
	 * Creates a new path and add's the given pair to the end of the old path
	 * 
	 * @param next
	 * @param old
	 */
	public Path(Pair next, Path old) {
		time = timer++;
		weight = old.getWeight() + next.getWeight();
		list = new ArrayList<Pair>(old.list);
		list.add(next);
	}

	public Vertex getFirstVertex() {
		return list.get(0).getVertex();
	}

	public Vertex getLastVertex() {
		return list.get(list.size() - 1).getVertex();
	}

	public List<Pair> getPath() {
		return list;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public int compareTo(Path that) {
		int ret = this.weight - that.weight;
		if (ret == 0)
			ret = this.time - that.time;
		return ret;
	}
}