import java.util.ArrayList;
import java.util.List;




public class AVLTree<T extends Comparable<T>> implements AVLInterface<T> {

	private Node<T> root;
	private Node<T> prev;
	private int size;
	private ArrayList list = new ArrayList();
	private ArrayList<T> list1 = new ArrayList<T>();


	
	public void calcHeightAndBF(Node<T> n){
		int right1 = 0;
		int left1 = 0;

		
		if(n == null)
			return;
		if(n.getLeft() == null)
			left1 = -1;
		else
			left1 = n.getLeft().getHeight();
		
		if(n.getRight() == null)
			right1 = -1;
		else
			right1 = n.getRight().getHeight();
		
		if(right1 > left1)
			n.setHeight(right1 + 1);
		else
			n.setHeight(left1 + 1);
			
		n.setBf(left1 - right1);
		
	}
	/**
	 * Left rotation
	 * @param Node t
	 * @return return new sub-root
	 */
	public Node<T> leftFlip(Node<T> t){
		Node<T> b = t.getRight();
		t.setRight(b.getLeft());
		b.setLeft(t);
		return b;
	}
	/**
	 * Right rotation
	 * @param Node t
	 * @return return new sub-root
	 */
	public Node<T> rightFlip(Node<T> t){
		Node<T> b = t.getLeft();
		t.setLeft(b.getRight());
		b.setRight(t);
		return b;
		
	}
	
	/**
	 * (Helper Method) Adds a new node into the tree at the appropriate place
	 *
	 * @param Node x, data
	 *            the data to add
	 */
	private Node<T> insert(Node<T> x, T data){
		if(x == null)
			x = new Node<T>(data);
		else if (x.getData().compareTo(data) < 0){
			x.setRight(insert(x.getRight(), data));
			recalculateHeightAndBF(root);
			return avlRotate(x);
		}
		else if (x.getData().compareTo(data) > 0){
			x.setLeft(insert(x.getLeft(), data));
			recalculateHeightAndBF(root);
			return avlRotate(x);
		}
		return x;
		
	}
	
	/**
	 * Adds a new node into the tree at the appropriate place
	 *
	 * @param data
	 *            the data to add
	 */
	public void add(T data){
		if(data == null)
			return;
		root = insert(root, data);
		recalculateHeightAndBF(root);
	}
	
	/**
	 * Determines which rotation to execute 
	 * @param Node n
	 * @return the sub-root
	 */
	public Node<T> avlRotate(Node<T> n){
		if(n.getBf() > 1 && n.getLeft().getBf() >= 0){
			System.out.println("right rotation");
			return rightFlip(n);
		}
		else if(n.getBf() < -1 && n.getRight().getBf() <= 0){
			System.out.println("left rotation");
			return leftFlip(n);
		}
		else if (n.getBf() < -1 && n.getRight().getBf() > 0){
			System.out.println("left-right rotation");
			return rightleft(n);
		}
		else if (n.getBf() > 1 && n.getLeft().getBf() < 0){
			System.out.println("left-right rotation");
			return leftright(n);
		}
		return n;
	}
	
	/**
	 * Helper method for calculating Heights and Balance Factors
	 * @param Node x
	 */
	public void recalculateHeightAndBF(Node<T> x){
		if(x.getLeft() != null)
			recalculateHeightAndBF(x.getLeft());
		if(x.getRight() != null)
			recalculateHeightAndBF(x.getRight());
		calcHeightAndBF(x);
	}
	
	/**
	 * @return A list containing a level order traversal of the tree with the heights of each node
	 */
	public List<T> levelOrderHeight() {
		list.clear();
		ArrayList<Node> q = new ArrayList<Node>();
		if(root != null)
			q.add(root);
		Node<T> curr = root;
		while(q.size() != 0){
			curr = q.remove(0);
			list.add(curr.getHeight());
			if(curr.getLeft() != null)
			q.add(curr.getLeft());
			if(curr.getRight() != null)
			q.add(curr.getRight());
		}
		return list;
	}
	
	/**
	 * @return A list containing a level order traversal of the tree with the balance factors of each node
	 */
	public List<T> levelOrderBf() {
		list.clear();
		ArrayList<Node> q = new ArrayList<Node>();
		if(root != null)
			q.add(root);
		Node<T> curr = root;
		while(q.size() != 0){
			curr = q.remove(0);
			list.add(curr.getBf());
			if(curr.getLeft() != null)
			q.add(curr.getLeft());
			if(curr.getRight() != null)
			q.add(curr.getRight());
		}
		return list;
	}

	/**
	 * @return A list containing a level order traversal of the tree
	 */
	public List<T> levelOrder() {
		list1.clear();
		ArrayList<Node> q = new ArrayList<Node>();
		if(root != null)
			q.add(root);
		Node<T> curr = root;
		while(q.size() != 0){
			curr = q.remove(0);
			list1.add(curr.getData());
			if(curr.getLeft() != null)
			q.add(curr.getLeft());
			if(curr.getRight() != null)
			q.add(curr.getRight());
		}
		return list1;
	}


	
		
	/**
	 * @param data
	 *            an element to search for
	 * @return the element from the tree that is equal to the given data, null
	 *         if such an element does not exist
	 */
	public T get(T data) {
		
		if(data == null)
			return null;
		//tree is empty
		if(root == null)
			return null;
		
		Node<T> x = root;
		
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
	 * This method is used to help the remove(). It returns the node that is the predecessor the node being removed. 
	 * 
	 * @param Node
	 *            <T> If "node" is the one being removed, pass node.getLeft() to this method
	 * 
	 * @return the predecessor 
	 */
	private Node<T> getPred(Node<T> node) {
		if (node.getRight() == null)
			return node;
		else
			return getPred(node.getRight());
	}
	
	/**
	 * Removes and returns the element from the tree that is equal to the given
	 * data, when necessary replace the removed element with the predecessor.
	 * 
	 * @param data
	 *            the element to remove
	 * @return the element removed from the tree, null if such an element is not
	 *         found
	 */
	public T remove(T data) {
		if(data == null)
			return null;
		if(get(data) == null)
			return null;
		else
			root = remove(root, data);
		return data;
	}

	/**
	 * The helper method for remove that recursively removes a Node from the tree. 
	 * @param node to be used as a basis for comparison
	 * @param data to be removed
	 * @return Node that has been removed 
	 */
	private Node<T> remove(Node<T> node, T data) {
		if(node == null)
			return node;
		else if(data.compareTo(node.getData()) < 0) {
			node.setLeft(remove(node.getLeft(), data));
			recalculateHeightAndBF(root);
			return avlRotate(node);
		}
		else if(data.compareTo(node.getData()) > 0) {
			node.setRight(remove(node.getRight(), data));
			recalculateHeightAndBF(root);
			return avlRotate(node);
		}
		else {
			if(node.getLeft() == null && node.getRight() == null) {
				return null;
			}
			else if(node.getLeft() != null && node.getRight() == null) {
				return node.getLeft();
			}
			else if(node.getLeft() == null && node.getRight() != null) {
				return node.getRight();
			}
			else {
				Node <T >pred = getPred(node.getLeft());
				node.setLeft(remove(node.getLeft(), pred.getData()));
				node.setData(pred.getData());
				recalculateHeightAndBF(root);
				return avlRotate(node);
				}
			}
		}
	

	/**
	 * Performs a left-based double rotation on the subtree with the subroot t. 
	 * This is for the case where the root is left-heavy, and its left child is right-heavy
	 * 
	 * @param t root of the node that is unbalanced 
	 * 
	 * @return the new subroot of the rotated tree
	 */
	public Node<T> leftright(Node<T> t) {
		t.setLeft(leftFlip(t.getLeft()));
		return rightFlip(t);
	}
	
	/**
	 * Performs a right-based double rotation on the subtree with the subroot t.
	 * This is for the case where the root is right-heavy, and its right child is left-heavy.
	 * 
	 * @param t root of the node that is unbalanced
	 * 
	 * @return the new subroot of the rotated tree
	 */
	public Node<T> rightleft(Node<T> t) {
		t.setRight(rightFlip(t.getRight()));
		return leftFlip(t);
	}
	
	public int size(){
		return size;
	}

	/**
	 * @return true if the list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return getRoot() == null;
	}
	
	
	/*
	 ***********************************************************
	 * 			DO NOT CHANGE CODE BELOW THIS POINT
	 **********************************************************
	 */
	@Override
	public Node<T> getRoot() {
		return root;
	}

	@Override
	public void setRoot(Node<T> root) {
		this.root = root;
	}
}
