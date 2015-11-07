import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author Brad Ware
 * @version 1.0 6/11/2013
 */
class Node<T extends Comparable<T>> {
	private Node<T> left;
	private Node<T> right;
	private T data;
	private int height;
	private int balanceFactor;

	Node(T data) {
		this.data = data;
		height = 0;

	}

	/**
	 * @return this Node's data
	 */
	T getData() {
		return data;
	}
	
	Node<T> getLeft(){
		return left;
	}
	Node<T> getRight(){
		return right;
	}
	
	/**
	 * Adds dataToAdd to this subtree. Rebalances the tree if necessary.
	 * 
	 * @param dataToAdd Must not be null. Must not already exist in the tree.
	 */

	

	OperationResult<T> add(T dataToAdd) {
		OperationResult<T> resultVal = new OperationResult<T>(false,this);
		if (dataToAdd.compareTo(this.data) < 0) {
			if(left == null){
				left = new Node<T>(dataToAdd);
	
			}else{
				resultVal = left.add(dataToAdd);
				left = resultVal.getNewRoot();
			}
			
		}else{
			if(right == null){
				right = new Node<T>(dataToAdd);
				
			}else{
				resultVal = right.add(dataToAdd);
				right = resultVal.getNewRoot();
			}
			
		}
		calculateHeight();
		if(Math.abs(this.balanceFactor()) > 1){
			Node<T> newRoot = rebalance(this);
			resultVal = new OperationResult<T>(true, newRoot);
			if(newRoot.right != null){
				newRoot.right.calculateHeight();
				newRoot.right.balanceFactor();
			}
			if(newRoot.left != null){
				newRoot.left.calculateHeight();
				newRoot.left.balanceFactor();
			}
			newRoot.calculateHeight();
			newRoot.balanceFactor();
		}else{
			resultVal = new OperationResult<T>(false, this);
		}
		return resultVal;
		
	}

	
	/**
	 * Adds the data of this subtree to list in order. (ie. does an in-order
	 * traversal)
	 * 
	 * @param list The list to add the data to. Must not be null.
	 */
	void addToInOrder(List<T> list) {
		if (this == null) {
			return;
		}
		if(left != null){
			left.addToInOrder(list);
		}
		list.add(this.getData());
		if(right != null){
			right.addToInOrder(list);
		}
	}


	/**
	 * @param needle
	 *            The data to look for.
	 * @return true if this Node or any subnode contains needle.
	 */
	boolean contains(T needle) {
		if (needle == null) {
			throw new NullPointerException("Null data not allowed");
		} else {
			Node<T> current = this;
			while (current != null) {
				if (needle.equals(current.data)) {
					return true;
				} else if (needle.compareTo(current.data) > 0) {
					current = current.right;
				} else {
					current = current.left;
				}
			}
		}
		return false;
	}

	/**
	 * Removes dataToRemove from this subtree. When there are two options to use
	 * to replace a Node, uses the successor. Rebalances the tree if necessary.
	 * 
	 * @param dataToRemove
	 *            Must not be null.
	 * @return The results of the remove. See the javadocs for OperationResult
	 */
	OperationResult<T> remove(T dataToRemove) {
		OperationResult<T> resultVal = new OperationResult<T>(false,this);
		if(dataToRemove.equals(data)){
			if(this.left == null){
				resultVal = new OperationResult<T>(true,this.right);
				
			}else if(this.right == null){
				resultVal = new OperationResult<T>(true, this.left);
			}else{
				resultVal = new OperationResult<T>(true, this.getSuccessor());
			}
		}else if(dataToRemove.compareTo(data) < 1){
			this.setLeft(this.left.remove(dataToRemove).getNewRoot());
		}else{
			this.setRight(this.right.remove(dataToRemove).getNewRoot());
		}
		calculateHeight();
		if(Math.abs(this.balanceFactor()) > 1){
			Node<T> newRoot = rebalance(this);//need to recalculate newHeight of all 3 nodes
			resultVal = new OperationResult<T>(true, newRoot);
			
		}
		return resultVal;
	}
	
	public Node<T> getSuccessor(){
		Node<T> prev = null;
		Node<T> successor = this.right;
		if(this.right == null){
			return null;
		}
		while (successor.left != null) {
			prev = successor;
			successor = successor.left;
		}
		this.setData(successor.getData());
		if (prev == null) {
			this.setRight(successor.right);
		} else {
			prev.setLeft(successor.right);
		}
		if(this.right != null){
			this.right.calculateHeight();
			if(Math.abs(this.right.balanceFactor()) > 1){
				this.setRight(rebalance(this.right));
				
			}
		}
		if(this.left != null){
			this.left.calculateHeight();
			if(Math.abs(this.left.balanceFactor()) > 1){
				this.setLeft(rebalance(this.left));
			}
		}
		return this;
	}
	private void setData(T data) {
		this.data = data;
	}
	
	
	public int getHeight(){
		return height;
	}

	public int calculateHeight(){
		height = 0;
		if(left != null){
			height = Math.max(height, 1 + left.getHeight());
		}
		if(right != null){
			height = Math.max(height, 1 + right.getHeight());
		}
		return height;
	}
	
	public int balanceFactor(){
		if(left == null && right == null){
			balanceFactor = 0;
		}else if(left == null){
			balanceFactor = (-1) - this.right.getHeight();
		}else if(right == null){
			balanceFactor = this.left.getHeight() - (-1);
		}else{
			balanceFactor = this.left.getHeight() - this.right.getHeight();
		}
		return balanceFactor;
	}
	//Need to change these to the variable
	public Node<T> rebalance(Node<T> root){
		if(root.balanceFactor() > 1 && root.left.balanceFactor() >= 0){
			return rightRotation(root);
		}else if(root.balanceFactor() > 1 && root.left.balanceFactor() < 0){
			return leftRightRotation(root);
		}else if(root.balanceFactor() < -1 && root.right.balanceFactor() > 0){
			return rightLeftRotation(root);
		}else{
			return leftRotation(root);
		}
	}
	
	private Node<T> rightRotation(Node<T> current){
		Node<T> newRoot = current.left;
		current.left = newRoot.right;
		newRoot.right = current;
		newRoot.right.calculateHeight();
		newRoot.left.calculateHeight();
		newRoot.calculateHeight();
		return newRoot;
		
		
	}
	private Node<T> leftRightRotation(Node<T> current){
		//Left rotation
		Node<T> newRoot = current.left.right;
		current.left.right = newRoot.left;
		newRoot.left = current.left;
		current.left = newRoot;
		//Right rotation
		current.left = newRoot.right;
		newRoot.right = current;
		newRoot.right.calculateHeight();
		newRoot.left.calculateHeight();
		newRoot.calculateHeight();
		return newRoot;
	}
	private Node<T> rightLeftRotation(Node<T> current){
		//Right rotation
		Node<T> newRoot = current.right.left;
		current.right.left = newRoot.right;
		newRoot.right = current.right;
		current.right = newRoot;
		//Left rotation
		current.right = newRoot.left;
		newRoot.left = current;
		newRoot.right.calculateHeight();
		newRoot.left.calculateHeight();
		newRoot.calculateHeight();
		return newRoot;
		
		
		
		
	}
	private Node<T> leftRotation(Node<T> current){
		Node<T> newRoot = current.right;
		current.right = newRoot.left;
		newRoot.left = current;
		newRoot.right.calculateHeight();
		newRoot.left.calculateHeight();
		newRoot.calculateHeight();
		return newRoot;
		
	}
	
	public void setRight(Node<T> newRight){
		this.right = newRight;
	}
	public void setLeft(Node<T> newLeft){
		this.left = newLeft;
	}
	public String toString(){
		return data + " ";
	}
}
