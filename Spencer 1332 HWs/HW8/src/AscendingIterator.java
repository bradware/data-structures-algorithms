import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

/**
 * This class creates an iterator object that allows the user to traverse a given 
 * collection in ascending order. 
 * 
 * @author Spencer Powell
 * @version 1.0
 */
public class AscendingIterator<T extends Comparable<T>> implements Iterator<T> {

	private PriorityQueue<T> queue;
	
	
	/**
	 * Constructor that creates an iterator of all the elements in the provided collection
	 * by using a priority queue.
	 * 
	 * @param items to be sorted
	 */
	public AscendingIterator(Collection<T> items) {
		if(items ==null)
			return;
		queue = new PriorityQueue<T>(items);
		
	}

	@Override
	/**
	 * Returns true if the iteration has more elements. 
	 * (In other words, returns true if next would return an element rather than throwing an exception.)
	 * 
	 * @return boolean true if the iterator has more elements.
	 */
	public boolean hasNext() {
		return !queue.isEmpty();
	}

	/**
	 * Returns the next element in the iteration.
	 * 
	 * @return the next element in the iteration.
	 */
	public T next() {
		if(!queue.isEmpty())
			return queue.poll();
		throw new NoSuchElementException();
	}

	/**
	 * Removes from the underlying collection the last element returned by the iterator (optional operation). 
	 * This method can be called only once per call to next. The behavior of an iterator is unspecified if the 
	 * underlying collection is modified while the iteration is in progress in any way other than by calling this method.
	 * 
	 */
	public void remove() {
		queue.remove();
		throw new UnsupportedOperationException();
	}
	
}