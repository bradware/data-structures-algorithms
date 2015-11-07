/**
 * This class represents a BSTNode object
 * @author Spencer Powell
 * @version 1.0
 */

public class BSTNode<T extends Comparable<T>> {
	
	private T data;
	private BSTNode<T> left;
	private BSTNode<T> right;
	
	/**
	 * Constructs the BSTNode
	 * 
	 * @param data
	 */
	public BSTNode(T data) {
		this.data = data;
		left = null;
		right = null;
	}

	/**
	 * Gets the data of the BSTNode
	 * 
	 * @return data
	 */
	public T getData() {
		if(data != null)
			return data; 
		return null;
	}

	/**
	 * Gets the left BSTNode of the SimpleBST
	 * 
	 * @return left
	 */
	public BSTNode<T> getLeft() {
		if(left != null)
		return left;
		
		return null;
	}
	/**
	 * Gets the right BSTNode of the SimpleBST
	 * 
	 * @return right
	 */
	public BSTNode<T> getRight() {
		if(right != null)
		return right;
		
		return right;
	}
	/**
	 * Sets the data of the BSTNode
	 * 
	 * @param data
	 */
	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Sets the left BSTNode of the SimpleBST
	 * 
	 * @param Node
	 */
	public void setLeft(BSTNode<T> left) {
		this.left = left;
	}
	/**
	 * Sets the right BSTNode of the SimpleBST
	 * 
	 * @param Node
	 */
	public void setRight(BSTNode<T> right) {
		this.right = right;
	}
}