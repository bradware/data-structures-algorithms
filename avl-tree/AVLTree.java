import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;


/**
 * For information on the Collection interface, see http://docs.oracle.com/javase/7/docs/api/java/util/Collection.html
 * 
 * 
 * @author Brad Ware
 * @version 1.0 6/22/2013
 *
 */

//look at treeWasChanged in Operation Result
//removing successor breaks the tree ---- done!
//breaks when element does not exist in tree and you call remove on it --- done!
//remove on empty tree causes it to break ------ done!
//remove that changes root breaks
// contains on empty tree fails -------- done!
//in order traversal for empty tree is broken ------done!
public class AVLTree<T extends Comparable<T>> implements Collection<T> {
	private Node<T> head;
	private int size;
	private List<T> myList;
	
	public AVLTree() {
		myList = new ArrayList<T>();
	}

	/**
	 * Does not support duplicate data. Read the add() javadoc online for more information.
	 * Rebalances the tree if necessary.
	 */
	@Override
	public boolean add(T data) {
		if(data == null){
			throw new UnsupportedOperationException("Null data not permitted");
		}if(size == 0){
			head = new Node(data);
			size++;
			return true;
		}
		
		else if(contains(data)){
			return false;
		}else{
			OperationResult<T> oR = head.add(data);
			if(oR.treeWasChanged()){
				head = oR.getNewRoot();
			}
			size++;
			return true;
		}
	}
	
	@Override
	public void clear() {
		head = null;
		size = 0;
	}
	
	/**
	 * @return A list of the data in the AVLTree. Will never return null.
	 */
	public List<T> inOrder() {
		myList = new ArrayList<T>();
		if(head == null || size == 0){
			return myList;
		}
		head.addToInOrder(myList);
		return myList;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		if(size == 0){
			return true;
		}
		return false;
	}

	/**
	 * @param o Must not be null.
	 */
	@Override
	public boolean contains(Object o) throws ClassCastException {
		if(head == null || size == 0){
			return false;
		}else{
			return head.contains((T)o);
		}
	}

	/**
	 * Rebalances the tree if necessary.
	 * 
	 * @param o Must not be null.
	 */
	@Override
	public boolean remove(Object o) throws ClassCastException {
		if(o == null){
			return false;
		}else if(size == 0){
			return false;
		}else if(!this.contains(o)){
			return false;
		}else{
			OperationResult<T> oR = head.remove((T)o);
			if(oR.treeWasChanged()){
				head = oR.getNewRoot();
			}
			size--;
			return true;
		}
	}
	

	/**
	 * @param c Must not be null.
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object each : c) {
			@SuppressWarnings("unchecked")
			T tEach = (T) each;
			
			if (!contains(tEach)) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * @param c Must not be null.
	 */
	@Override
	public boolean addAll(Collection<? extends T> c) {
		boolean treeChanged = false;
		
		for (T each : c) {
			treeChanged |= add(each);
		}
		
		return treeChanged;
	}

	/**
	 * @param c Must not be null.
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		boolean treeChanged = false;
		
		for (Object each : c) {
			@SuppressWarnings("unchecked")
			T tEach = (T) each;
			treeChanged |= remove(tEach);
		}
		
		return treeChanged;
	}

	/**
	 * @param c Must not be null.
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public Iterator<T> iterator() {
		return inOrder().iterator();
	}

	@Override
	public Object[] toArray() {
		return inOrder().toArray();
	}

	@Override
	public <N> N[] toArray(N[] a) {
		return inOrder().toArray(a);
	}
	
	public T getHead(){
		return head.getData();
	}

	// -----------------DISPLAY TREE --------------------------------

	/**
	* prints out the tree for better visualization 
	*/
	public void displayTree(){
	     Stack<Node<T>> globalStack = new Stack<Node<T>>();
	     globalStack.push(head);
	     int emptyLeaf = 32;
	     boolean isRowEmpty = false;
	     System.out.println("****.................................****");
	     while (isRowEmpty == false){
	         Stack<Node<T>> localStack = new Stack<Node<T>>();
	         isRowEmpty = true;
	         for (int j = 0; j < emptyLeaf; j++)
	             System.out.print(' ');
	         while (globalStack.isEmpty() == false){
	             Node<T> temp = globalStack.pop();
	             if (temp != null){
	             // System.out.println(temp.getData());
	             System.out.print(temp);
	             localStack.push(temp.getLeft());
	             localStack.push(temp.getRight());
	             if (temp.getLeft() != null || temp.getRight() != null)
	                 isRowEmpty = false;
	        }else{
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
	 System.out.println("****..................................****");
	}
	// -----------------END OF DISPLAY TREE ------------------------

	
	
}

