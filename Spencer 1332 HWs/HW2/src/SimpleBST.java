import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a SimpleBST object 
 * @author Spencer Powell
 * @version 1.0
 */
public class SimpleBST<T extends Comparable<T>> implements SimpleBSTInterface<T> {
	
	private BSTNode<T> root;
	private int size;
	private List<T> list = new ArrayList<T>();
	

	/**
	 * Gets the root of the BST
	 * 
	 * @return root
	 */
	public BSTNode<T> getRoot() {
		if(root != null)
		return root;
		
		return null;
	}

	/**
	 * Sets the root of the BST
	 */
	public void setRoot(BSTNode<T> root) {
		this.root = root;
	}

	/**
	 * Adds an element into this BST.
	 * 
	 * @param data Data of element to add
	 */
	public void add(T data) {
		//safety check
		if(data == null)
			return;
		
		//tree is empty
		if(root == null) {
			root = new BSTNode<T>(data);
			size++;
			return;
		}
		BSTNode<T> x = root;
		BSTNode<T>prev = null;
		//finding a place to add
		while(x != null){
			prev = x;
			if(x.getData().equals(data))
				return;
			if(data.compareTo(x.getData()) < 0)
				x = x.getLeft();
			else
				x = x.getRight();
		}
		//adding
		if(prev.getData().compareTo(data) < 0){
			prev.setRight(new BSTNode(data));
			size++;
		}
		else
		{
			prev.setLeft(new BSTNode(data));
			size++;
		}
			

	}

	/**
	 * Finds and returns the matching element in this BST
	 * equal to the parameter as defined by the equals() method.
	 * 
	 * @param data Data of element to find
	 * @return Matching element's data or null if not found in this BST
	 */
	public T get(T data) {
		if(data == null)
			return null;
		//tree is empty
		if(root == null)
			return null;
		
		BSTNode<T> x = root;
		
		while(x != null){
			if(x.getData().equals(data))
				return x.getData();
			else if(data.compareTo(x.getData()) < 0)
				x = x.getLeft();
			else
				x = x.getRight();
			}
		return null;
	}

	/**
	 * Helper method for preorder
	 * 
	 * @return List type containing all data entries in this BST
	 */
	protected List<T> preOrder(BSTNode<T> x){
		if(x != null){
			list.add(x.getData());
			preOrder(x.getLeft());
			preOrder(x.getRight());
		}
		return list;
	}
	
	/**
	 * Performs a preorder traversal on this BST and returns
	 * a List containing each element's data in the traversal order
	 * 
	 * @return List type containing all data entries in this BST
	 */
	public List<T> preorder() {
			list.clear();
			return preOrder(root);
		}
		
	/**
	 * Helper method for postorder
	 * 
	 * @return List type containing all data entries in this BST
	 */
	protected List<T> postOrder(BSTNode<T> x){
		if(x != null){
			postOrder(x.getLeft());
			postOrder(x.getRight());
			list.add(x.getData());
		}
		return list;
	}
	/**
	 * Performs a postorder traversal on this BST and returns
	 * a List containing each element's data in the traversal order
	 * 
	 * @return List type containing all data entries in this BST
	 */
	public List<T> postorder() {
		list.clear();
		return postOrder(root);
	}
	//returns the size of the list
	public int size(){
		return size;
	}

}