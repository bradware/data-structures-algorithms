
import java.util.List;

public interface SimpleBSTInterface<T extends Comparable<T>>
{
	// getter & setter for root
	BSTNode<T> getRoot();
	void setRoot(BSTNode<T> root);
	
	/**
	 * Adds an element into this BST.
	 * 
	 * @param data Data of element to add
	 */
	void add(T data);
	
	/**
	 * Finds and returns the matching element in this BST
	 * equal to the parameter as defined by the equals() method.
	 * 
	 * @param data Data of element to find
	 * @return Matching element's data or null if not found in this BST
	 */
	T get(T data);
	
	/**
	 * Performs a preorder traversal on this BST and returns
	 * a List containing each element's data in the traversal order
	 * 
	 * @return List type containing all data entries in this BST
	 */
	List<T> preorder();
	
	/**
	 * Performs a postorder traversal on this BST and returns
	 * a List containing each element's data in the traversal order
	 * 
	 * @return List type containing all data entries in this BST
	 */
	List<T> postorder();
}
