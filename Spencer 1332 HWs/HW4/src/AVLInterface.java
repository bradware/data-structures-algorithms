public interface AVLInterface<T extends Comparable<T>> {

	/**
	 * Adds a new node into the tree at the appropriate place
	 *
	 * @param data
	 *            the data to add
	 */
	public void add(T data);
	
	/**
	 * @param data
	 *            an element to search for
	 * @return the element from the tree that is equal to the given data, null
	 *         if such an element does not exist
	 */
	public T get(T data);

	/**
	 * Removes and returns the element from the tree that is equal to the given
	 * data, when necessary replace the removed element with the predecessor.
	 * 
	 * @param data
	 *            the element to remove
	 * @return the element removed from the tree, null if such an element is not
	 *         found
	 */
	public T remove(T data);

	/**
	 * @return true if the list is empty, false otherwise
	 */
	public boolean isEmpty();

	/**
	 * This method is for grading purposes
	 * 
	 * @return returns the root of the tree
	 */
	public Node<T> getRoot();

	/**
	 * This method is for grading purposes
	 * 
	 * @param root
	 *            the new root of this tree
	 */
	public void setRoot(Node<T> root);
}
