
import java.util.List;

public interface BSTInterface<T extends Comparable<T>> {

	/**
	 * Adds the given data into the appropriate place in the tree
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
	 * @return the minimum element in the tree, null if the tree is empty
	 */
	public T getMin();

	/**
	 * @return the maximum element in the tree, null if the tree is empty
	 */
	public T getMax();

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
	 * @return removes the minimum element and returns it, null if the tree is empty
	 */
	public T removeMin();

	/**
	 * @return removes the maximum element and returns it, null if the tree is empty
	 */
	public T removeMax();

	/**
	 * @return true if the list is empty, false otherwise
	 */
	public boolean isEmpty();

	/**
	 * @return A list containing an inorder traversal of the tree
	 */
	public List<T> inOrder();

	/**
	 * @return A list containing a level order traversal of the tree
	 */
	public List<T> levelOrder();

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

	/* Extra Credit Methods */

	/**
	 * This is an extra credit method worth 5 points.
	 * 
	 * This method will get all of the data on a particular level of the tree
	 * 
	 * @param level
	 *            the level to return
	 * @return a list containing only the elements on the given level, where the
	 *         root is on level 0, return an empty list if there are not
	 *         elements on the level or the level is invalid
	 */
	public List<T> getLevel(int level);

	/**
	 * This is an extra credit method worth 10 points.
	 * 
	 * This method will clear the current tree. Then create the unique tree
	 * defined by the given preorder traversal. Examples:
	 * 
	 * Given the following list: {3, 1, 5}
	 * 
	 * The tree is uniquely defined to be: 3 1 5
	 * 
	 * Given the following list: {5, 3, 1}
	 * 
	 * The tree is uniquely defined to be: 5 3 1
	 * 
	 * Remember: This is a BST, the left should be less than its parent, and the
	 * right should be greater than its parent.
	 * 
	 * @param preorder
	 *            a preorder traversal of the tree to generate
	 */
	public void generateTree(List<T> preorder);
}
