import java.util.PriorityQueue;

public class MyPriorityQueue implements Structure {

	private PriorityQueue<Path> q;
	
	public MyPriorityQueue() {
		q = new PriorityQueue<Path>();
	}
	
	/**
	 * adds a Path to the list
	 * @param p
	 */
	public void add(Path p) {
		q.add(p);
	}

	/**
	 * removes a path from list
	 * @return Path
	 */
	public Path remove() {
		return q.remove();
	}

	/**
	 * Checks to see if the list is empty
	 * @return true if empty
	 */
	public boolean isEmpty() {
		return q.isEmpty();
	}
}