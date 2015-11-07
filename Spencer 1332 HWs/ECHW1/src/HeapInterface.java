import java.util.Collection;

public interface HeapInterface<T extends Comparable<T>> {

	/**
	 * @return If the heap has elements in it
	 */
	public boolean isEmpty();
	
	/**
	 * @return The number of elements in the heap
	 */
	public int size();
	
	/**
	 * Returns the element in the heap with the highest priority
	 * 
	 * @return the element with highest priority
	 */
	public T getFirst();
	
	/**
	 * Removes and returns the element in the heap with the highest priority
	 * 
	 * @return the element with highest priority
	 */
	public T remove();
	
	/**
	 * Inserts an element into the proper place in the array based on its priority
	 * 
	 * @param data The data to be inserted into the heap
	 */
	public void add(T data);
	
	/**
	 * Inserts all of the elements in a Collection into the heap
	 * 
	 * @param elements Collection with the elements to be added to the heap
	 */
	public void addAll(Collection<T> elements);
	
	// Used for grading
	public T[] getArray();
	public void setArray(T[] array);
	public void setSize(int size);
	
}