import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author Brad Ware
 * @version 1.0
 * @date 5/30/2013 This class writes the logic for a Binary Search Tree. Also
 *       contains inner class for the Node objects being added to the BST
 */
public class BST<T extends Comparable<T>> {

	private NullComparator<T> nc;
	private Node<T> root;
	private int size = 0;
	private T removedData;
	private List<T> myList;

	public BST() {
		nc = new NullComparator<T>();
	}

	/**
	 * Adds a data entry to the BST null is positive infinity Calls
	 * addRecursively starting from the root
	 * 
	 * @param data
	 *            -The data entry to add
	 */
	public void add(T data) {
		root = addRecursively(data, root);
		size++;
	}

	/**
	 * This is the recursive logic of the add method. Starts from the root and
	 * moves through the BST until an empty spot is found and adds a new Node
	 * there
	 * 
	 * @param data
	 * @param spot
	 */

	private Node<T> addRecursively(T data, Node<T> spot) {
		if (spot == null) {
			spot = new Node<T>(data);
		} else if (nc.compare(data, spot.getData()) < 0) {
			spot.setLeft(addRecursively(data, spot.getLeft()));
		} else {
			spot.setRight(addRecursively(data, spot.getRight()));
		}
		return spot;
	}

	/**
	 * Adds each data entry from the collection to this BST Read the collections
	 * api if you have questions
	 * 
	 * 
	 * @param Collection
	 *            <T> c
	 */
	public void addAll(Collection<? extends T> c) {
		for (T current : c) {
			this.add(current);
		}
	}

	/**
	 * returns the Successor of the Node passed in
	 * 
	 * @return Node<T> successor
	 */
	private Node<T> getSuccessor(Node<T> current) {
		Node<T> prev = null;
		Node<T> successor = current.getRight();
		if(current.getRight() == null){
			return null;
		}
		while (successor.getLeft() != null) {
			prev = successor;
			successor = successor.getLeft();
		}
		current.setData(successor.getData());
		if (prev == null) {
			current.setRight(successor.getRight());
		} else {
			prev.setLeft(successor.getRight());
		}
		return current;
	}

	/**
	 * Removes a data entry from the BST null is positive infinity
	 * 
	 * @param data The data entry to be removed
	 * @return The removed data entry (null if nothing is removed)
	 */
	public T remove(T data) {
		if (!this.contains(data)) {
			return null;
		}
		root = removeRecursively(data, root);
		size--;
		return removedData;
	}

	private Node<T> removeRecursively(T data, Node<T> spot) {
		if (spot == null) {
			removedData = null;
			return spot;
		} else if (nc.compare(data, spot.getData()) == 0) {
			if (spot.getLeft() == null) {
				removedData = spot.getData();
				return spot.getRight();
			} else if (spot.getRight() == null) {
				removedData = spot.getData();
				return spot.getLeft();
			} else {
				removedData = spot.getData();
				return getSuccessor(spot);
			}
		} else if (nc.compare(data, spot.getData()) < 0) {
			spot.setLeft(removeRecursively(data, spot.getLeft()));

		} else {
			spot.setRight(removeRecursively(data, spot.getRight()));
		}
		return spot;
	}

	/**
	 * Checks if the BST contains a data entry
	 * 
	 * null is positive infinity
	 * 
	 * @param data
	 *            The data entry to be checked
	 * @return If the data entry is in the BST
	 */
	public boolean contains(T data) {
		if (this.size() == 0) {
			return false;
		}
		Node<T> current = root;
		while (current != null) {
			if (data == null) {
				if (current.getData() == data) {
					return true;
				} else {
					current = current.right;
				}
			} else {
				if(current.getData() == null){
					current = current.getLeft();
				}else if(current.getData().equals(data)) {
					return true;
				} else if (nc.compare(data, current.getData()) > 0) {
					current = current.getRight();
				} else {
					current = current.getLeft();
				}
			}
		}
		return false;
	}

	/**
	 * Finds the pre-order traversal of the BST
	 * 
	 * @return A list of the data set in the BST in pre-order
	 */
	public List<T> preOrder() {
		myList = new ArrayList<T>();
		preOrder(root);
		return myList;
	}

	/**
	 * 
	 * @param current
	 */

	public void preOrder(Node<T> current) {
		if (current == null) {
			return;
		}
		myList.add(current.getData());
		preOrder(current.getLeft());
		preOrder(current.getRight());
	}

	/**
	 * Finds the in-order traversal of the BST
	 * 
	 * @return A list of the data set in the BST in in-order
	 */
	public List<T> inOrder() {
		myList = new ArrayList<T>();
		inOrder(root);
		return myList;

	}

	public void inOrder(Node<T> current) {
		if (current == null) {
			return;
		}
		inOrder(current.getLeft());
		myList.add(current.getData());
		inOrder(current.getRight());
	}

	/**
	 * Finds the post-order traversal of the BST
	 * 
	 * @return A list of the data set in the BST in post-order
	 */
	public List<T> postOrder() {
		myList = new ArrayList<T>();
		postOrder(root);
		return myList;

	}

	public void postOrder(Node<T> current) {
		if (current == null) {
			return;
		}
		postOrder(current.getLeft());
		postOrder(current.getRight());
		myList.add(current.getData());

	}

	/**
	 * Checks to see if the BST is empty. This is trivial since you have a size
	 * variable
	 * 
	 * @return If the BST is empty or not
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Clears this BST and sets the size back to 0
	 * Nodes picked up by garbage collection
	 * Nodes data in the list to null?
	 */
	public void clear() {
		root = null;
		size = 0;

	}

	/**
	 * @return the size of this BST
	 */
	public int size() {
		return size;
	}

	/**
	 * First clears this BST, then reconstructs the BST that is uniquely defined
	 * by the given preorder and inorder traversals. Draw this out on paper, it
	 * will make it much easier to code.
	 * 
	 * (When you finish, this BST should produce the same preorder and inorder
	 * traversals as those given)
	 * 
	 * @param preorder
	 *            a preorder traversal of the BST to reconstruct
	 * @param inorder
	 *            an inorder traversal of the BST to reconstruct
	 */
	//
	public void reconstruct(List<? extends T> preorder,
			List<? extends T> inorder) {
		this.clear();
		this.addAll(preorder);
	}

	/*
	 * The following methods are for grading, do not modify them
	 */

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public static class Node<K extends Comparable<K>> {

		private K data;
		private Node<K> left, right;

		public Node(K data) {
			setData(data);
		}

		public K getData() {
			return data;
		}

		public void setData(K data) {
			this.data = data;
		}

		public Node<K> getLeft() {
			return left;
		}

		public void setLeft(Node<K> left) {
			this.left = left;
		}

		public Node<K> getRight() {
			return right;
		}

		public void setRight(Node<K> right) {
			this.right = right;
		}
	}

	private class NullComparator<E extends Comparable<E>> implements
			Comparator<E> {

		@Override
		public int compare(E o1, E o2) {
			// if both objects are null
			if (o1 == null && o2 == null) {
				return 0;
				// return positive number b/c first number is null
			} else if (o1 == null) {
				return 1332;
				// return negative number b/c second number is null, making it
				// greater than first
			} else if (o2 == null) {
				return -2110;
			}
			// case neither numbers are null
			return o1.compareTo(o2);
		}
	}

	// -----------------DISPLAY TREE --------------------------------

	/**
	 * prints out the tree for better visualization
	 */
	public void displayTree() {
		Stack<Node> globalStack = new Stack<Node>();
		globalStack.push(root);
		int emptyLeaf = 32;
		boolean isRowEmpty = false;
		System.out
				.println("****......................................................****");
		while (isRowEmpty == false) {
			Stack<Node> localStack = new Stack<Node>();
			isRowEmpty = true;
			for (int j = 0; j < emptyLeaf; j++)
				System.out.print(' ');
			while (globalStack.isEmpty() == false) {
				Node temp = globalStack.pop();
				if (temp != null) {

					// System.out.println(temp.getData());
					System.out.print(temp);
					localStack.push(temp.getLeft());
					localStack.push(temp.getRight());
					if (temp.getLeft() != null || temp.getRight() != null)
						isRowEmpty = false;
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0; j < emptyLeaf * 2 - 2; j++)
					System.out.print(' ');
			}
			System.out.println();
			emptyLeaf /= 2;
			while (localStack.isEmpty() == false)
				globalStack.push(localStack.pop());
		}
		System.out
				.println("****......................................................****");
	}
	// -----------------END OF DISPLAY TREE ------------------------

}
