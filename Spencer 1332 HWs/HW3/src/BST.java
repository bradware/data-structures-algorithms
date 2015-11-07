
import java.util.ArrayList;
import java.util.List;

public class BST<T extends Comparable<T>> implements BSTInterface<T> {

	private Node<T> root;
	private int size;
	private List<T> list = new ArrayList<T>();
	
	/**
	 * Adds the given data into the appropriate place in the tree
	 * 
	 * @param data
	 *            the data to add
	 */
	public void add(T data) {
		//safety check
		if(data == null)
			return;
		//if tree is empty
		if(root == null){
			this.setRoot(new Node<T>(data));
			size++;
			return;
		}
		Node<T> curr = root;
		Node<T> prev = null;
		//finding the Node to add from
		while(curr != null){
			prev = curr;
			if(data.compareTo(curr.getData()) < 0)
				curr = curr.getLeft();
			else
				curr = curr.getRight();
		}
		//adding
		if(data.compareTo(prev.getData()) < 0){
			Node<T> x = new Node<T>(data);
			prev.setLeft(x);
			x.setParent(prev);
		}
			
		else{
			Node<T> x = new Node<T>(data);
			prev.setRight(x);
			x.setParent(prev);
		}
			
		
		size++;
		
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
	 * @return the minimum element in the tree, null if the tree is empty
	 */
	public T getMin() {
		
		//tree is empty
		if(root == null)
			return null;
		
		Node<T> x = root;
	
		while(x.getLeft() != null){
			x = x.getLeft();
		}
		return x.getData();
	}

	/**
	 * @return the maximum element in the tree, null if the tree is empty
	 */
	public T getMax() {
		
		//tree is empty
		if(root == null)
			return null;
		
		Node<T> x = root;
	
		while(x.getRight() != null){
			x = x.getRight();
		}
		return x.getData();
	}
	

	


	/**
	 * getPred
	 * Method that takes in a node and returns the node's predecessor
	 * @param Node<T> node 
	 * @return Node<T>
	 */
	public Node<T> getPred(Node<T> node){
		if(node==null){
			return null;
		}
		else if(node.getLeft()!=null){
			node = node.getLeft();
			while(node.getRight()!=null){
				node = node.getRight();
			}
			return node;
		}
		else{
			return null;
		}
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
		if(root==null){
			return null;
		}
		if(data==null){
			return null;
		}
		Node<T> curr = root;
		Node<T> pred = new Node<T>(data);
		while(curr!=null){	
			if(data.compareTo(curr.getData())<0){//parse through tree until data = node's data
				curr = curr.getLeft();
			}
			else if(data.compareTo(curr.getData())>0){//parse through tree until data = node's data
				curr = curr.getRight();
			}
			else if(data.compareTo(curr.getData())==0){//Once we find the node with data = to its data
				if(curr.getRight()!=null && curr.getLeft()!=null){//if the node has 2 CHILDREN
					pred=getPred(curr);
					curr.setData(pred.getData());
					if(pred.getLeft()!=null){
						if(pred.getLeft().getData().compareTo(pred.getParent().getData())>0){
							pred.getLeft().setParent(pred.getParent());
							pred.getParent().setRight(pred.getLeft());
							}
						else if(pred.getLeft().getData().compareTo(pred.getParent().getData())<0){
							pred.getLeft().setParent(pred.getParent());
							pred.getParent().setLeft(pred.getLeft());
						}
					}
					else if(pred.getLeft()==null && pred.getRight()==null){
						pred.setData(null);
					}
					return curr.getData();
				}
else if(curr.getRight()!=null && curr.getLeft()==null){//if the node has only a RIGHT CHILD

	T extra = curr.getData();
	if (root==curr){
		root=curr.getRight();
		curr.setData(null);
	}
	else{
		Node<T> parent = curr.getParent();
		if(parent.getRight()==curr.getData()){
			parent.setLeft(curr.getRight());
		}
		else{
			parent.setRight(curr.getRight());
		}
	}
	return extra;
}
	else if(curr.getLeft()!=null && curr.getRight()==null){//if the node has only a LEFT CHILD

		T extra = curr.getData();//save it to return it later
		if (root==curr){ //if this happens to be the root
			root=curr.getLeft();//reset root pointer
			curr.setData(null);//make the old one null
		}
		else{//if its not the root
			Node<T> parent = curr.getParent();//save the parent node
			if(parent.getLeft()==curr.getData()){//if its on the parent's left
				parent.setRight(curr.getLeft());
			}
			else{//otherwise its on the parent's right
				parent.setLeft(curr.getLeft());
			}
		}
		return extra;
	}

	else if(curr.getLeft()==null && curr.getRight()==null){//if the node has 0 CHILDREN
		if(curr.getData().compareTo(curr.getParent().getRight().getData())>0){//the node is the RIGHT child

			curr.setData(null);
		}
		else if(curr.getData().compareTo(curr.getParent().getLeft().getData())<00){//the node is the LEFT child)
			
			curr.setData(null);
		}
		return curr.getData();
	}
			}
		}
		return null;
	}

	/**
	 * @return removes the minimum element and returns it, null if the tree is empty
	 */
	public T removeMin() {
		
			//tree is empty
				if(root == null)
					return null;
				
				Node<T> x = root;
			
				while(x.getLeft() != null){
					x = x.getLeft();
				}
				size--;
				return remove(x.getData());
	}

	/**
	 * @return removes the maximum element and returns it, null if the tree is empty
	 */
	public T removeMax() {
		
		//tree is empty
		if(root == null)
			return null;
		
		
		Node<T> x = root;
	
		while(x.getRight() != null){
			x = x.getRight();
		}
		size--;
		return remove(x.getData());
	}

	/**
	 * @return true if the list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return (root == null && size() == 0);
			
	}

	public List<T> inorder(Node<T> x){
		if(x != null){
		inorder(x.getLeft());
		list.add(x.getData());
		inorder(x.getRight());
		}
		return list;
	}
	
	/**
	 * @return A list containing an inorder traversal of the tree
	 */
	public List<T> inOrder() {
		list.clear();
		return inorder(root);
	}

	/**
	 * @return A list containing a level order traversal of the tree
	 */
	public List<T> levelOrder() {
		list.clear();
		ArrayList<Node> q = new ArrayList<Node>();
		if(root != null)
			q.add(root);
		Node<T> curr = root;
		while(q.size() != 0){
			curr = q.remove(0);
			list.add(curr.getData());
			if(curr.getLeft() != null)
			q.add(curr.getLeft());
			if(curr.getRight() != null)
			q.add(curr.getRight());
		}
		return list;
	}

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
	public List<T> getLevel(int level) {
		// TODO Extra credit method. Worth 5 Points.
		return null;
	}

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
	public void generateTree(List<T> preorder) {
		// TODO Extra credit method. Worth 10 Points.
	}
	
	public int size(){
		return size;
	}
	
	/* These methods are for grading, do not modify them */
	
	@Override
	public Node<T> getRoot() {
		return root;
	}

	@Override
	public void setRoot(Node<T> root) {
		this.root = root;
	}
	
	
}
