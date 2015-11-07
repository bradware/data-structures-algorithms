import java.util.LinkedList;

public class MyQueue implements Structure {

	private LinkedList<Path> list;
	
	public MyQueue() {
		list = new LinkedList<Path>();
	}
	
	/**
	 * adds a Path to the list
	 * @param p
	 */
	public void add(Path p) {
		list.add(p);
	}

	/**
	 * removes a path from list
	 * @return Path
	 */
	public Path remove() {
		return list.removeFirst();
	}

	/**
	 * Checks to see if the list is empty
	 * @return true if empty
	 */
	public boolean isEmpty() {
		return (list.size() == 0);
	}

}
