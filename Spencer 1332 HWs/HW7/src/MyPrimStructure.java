import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Extra Credit (20 Points)
 * 
 * This class is optional, attempting it will not hurt you score.
 */
public class MyPrimStructure implements Structure {

	private PriorityQueue<Path> q;
	private Comparator<Path> com;
	
	public MyPrimStructure() {
		q = new PriorityQueue<Path>(11, com);
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