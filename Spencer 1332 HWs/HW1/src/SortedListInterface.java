public interface SortedListInterface<T extends Comparable<T>> {

	/**
	 * Add data to this sorted list in the correct position.
	 * 
	 * @param data
	 */
	public void add(T data);

	/**
	 * Check if this list contains data
	 * 
	 * @param data
	 * @return true if this contains data, false otherwise
	 */
	public boolean contains(T data);

	/**
	 * Gets the element FROM THIS LIST that is equal to the provided data
	 * 
	 * @param data
	 * @return the element FROM THIS LIST that is equal to the provided data,
	 *         null if no such element exists
	 */
	public T get(T data);

	/**
	 * Gets the element at the given index
	 * 
	 * @param index
	 *            the 0-based index of an element
	 * @return the element at the given index
	 */
	public T getAt(int index);

	/**
	 * @return the maximum element (last), null if it doesn't exist
	 */
	public T getMax();

	/**
	 * @return the minimum element (first), null if it doesn't exist
	 */
	public T getMin();

	/**
	 * Removes the element that is equal to the provided data, and returns the
	 * element THAT WAS REMOVED
	 * 
	 * @param data
	 * @return the element THAT WAS REMOVED, null if nothing was removed
	 */
	public T remove(T data);

	/**
	 * Removes the element at the given index
	 * 
	 * @param index
	 *            the 0-based index of an element
	 * @return the element removed
	 */
	public T removeAt(int index);

	/**
	 * Removes the maximum element from this list (last)
	 * 
	 * @return the element removed
	 */
	public T removeMax();

	/**
	 * Removes the minimum element from this list (first)
	 * 
	 * @return the element removed
	 */
	public T removeMin();

	/**
	 * @return the number of elements in this list
	 */
	public int size();
	
	/**
	 * @return true if this list is empty, false otherwise
	 */
	public boolean isEmpty();
}