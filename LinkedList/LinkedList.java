import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Brad Ware
 * @version 1.0
 * 
 *          The API for LinkedList can be found here
 *          http://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html
 */
public class LinkedList<T> implements List<T> {
	private Node<T> head, tail;
	private int size;

	/**
	 * This is to make sure the class compiles You do not have to add any code
	 * for this method
	 */
	public LinkedList() {
		size = 0;
		head = null;
		tail = null;
	}

	@Override
	public void add(T item) {
		if (size == 0) {
			Node<T> newNode = new Node<T>(item, null, null);
			size++;
			head = newNode;
			tail = newNode;
		} else {
			Node<T> newNode = new Node<T>(item, tail, null);
			size++;
			tail.next = newNode;
			tail = newNode;
		}
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public boolean contains(Object item) {
		if (size == 0) {
			return false;
		}
		Node<T> current = head;
		if (item == null || current.data == null) {
			if (current.data == item) {
				return true;
			} else
				while (current.next != null) {
					if (current.data == item) {
						return true;
					}
					current = current.next;
				}
		}
		for (int i = 0; i < size; i++) {
			if(item == null){
				if(current.data == item){
					return true;
				}
			}
			else if (current.data.equals(item)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public T remove(Object item) {
		if (this.contains(item) == false) {
			return null;
		}
		if (size == 1) {
			T tempData = head.data;
			head = null;
			tail = null;
			size--;
			return tempData;
		}
		Node<T> current = head;
		T tempData = (T)item;
		while(current.next != null){
			if(item == null){
				if(current == head){
					head = head.next;
					head.prev = null;
				}
				else if(current == tail){
					tail = tail.prev;
					tail.next = null;
				}
				else if(current.data == item){
					current.prev.next = current.next;
					current.next.prev = current.prev;
				}
				
			}else if(current.data.equals(item)){
				if(head.data.equals(item)){
					head = head.next;
				}
				else if(tail.data.equals(item)){
					tail = tail.prev;
				}else{
				current.prev.next = current.next;
				current.next.prev = current.prev;
				}
			}
			current = current.next;
			
		}
		size--;
		return tempData;
	}

		/**
		 * Node<T> current = head; if (size == 1) { T tempData = current.data;
		 * head = null; tail = null; size--; return tempData; } else { for (int
		 * i = 0; i < size; i++) { if (current.data.equals(item)) { T tempData =
		 * current.data; if (current == tail) { tail = current.prev;
		 * current.prev.next = null; size--; return tempData;
		 * 
		 * } else { current.prev.next = current.next; current.next.prev =
		 * current.prev; size--; return tempData; }
		 * 
		 * } current = current.next;
		 * 
		 * } } System.out.println("Should never reach her"); return null;
		 */

	

	@Override
	public int size() {
		return size;
	}

	@Override
	/**
	 * Returns an iterator able to iterate over the list
	 * 
	 * @return the iterator for the list
	 */
	public Iterator<T> iterator() {
		return new LinkedListIterator(this);
	}

	@Override
	public void add(T item, int index) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		Node<T> newNode = new Node<T>(item);
		if (size == 0) {// empty list
			head = newNode;
			tail = newNode;
			size++;
		} else if (index == 0 && size != 0) {// adding to head of non-empty list
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
			size++;
		} else {
			Node<T> current = head;
			for (int i = 0; i < index - 1; i++) {// current is node right before
													// index you want to add
				current = current.next;
			}
			if (current.equals(tail)) {// adding to end of list
				current.next = newNode;
				newNode.prev = current;
				tail = newNode;
				size++;
			} else {// insert middle of list
				newNode.next = current.next;
				newNode.prev = current;
				current.next = newNode;
				newNode.next.prev = newNode;
				size++;
			}
		}
	}

	@Override
	public T get(int index) {
		Node<T> current = head;
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		for (int i = 0; i < index; i++)
			current = current.next;

		return current.data;

	}

	// My method no need to test
	public Node<T> getNode(int index) {
		Node<T> current = head;
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		for (int i = 0; i < index; i++)
			current = current.next;

		return current;

	}

	@Override
	public int indexOf(Object item) {
		Node<T> current = head;
		for (int i = 0; i < size; i++) {
			if (current.data == item) {
				return i;
			} else {
				current = current.next;
			}
		}
		return -1;
	}

	@Override
	public T remove(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (size == 1) {// removing only thing in list
			T removedData = head.data;
			head = null;
			tail = null;
			size--;
			return removedData;
		} else {
			Node<T> current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			if (index == 0) {
				T removedData = head.data;
				head = current.next;
				size--;
				return removedData;
			} else if (index == (size -1)) {
				T removedData = tail.data;
				tail = tail.prev;
				size--;
				return removedData;

			} else {
				T removedData = current.next.data;
				current.next = current.next.next;
				current.next.prev = current;
				size--;
				return removedData;

			}

		}
	}

	/**
	 * @return the first item in this linked list
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T getFirst() {
		if (size == 0) {
			throw new NoSuchElementException();
		} else {
			return head.data;
		}
	}

	/**
	 * @return the last item in this linked list
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T getLast() {
		if (size == 0) {
			throw new NoSuchElementException();
		} else {
			return tail.data;
		}
	}

	/**
	 * Adds 'item' to front of this linked list
	 * 
	 * @param item
	 */
	// Cases 1) adding to empty list. 2) adding to list with a head
	public void addFirst(T item) {
		if (size == 0) {
			Node<T> newNode = new Node<T>(item, null, null);
			head = newNode;
			tail = newNode;
		}
		Node<T> newNode = new Node<T>(item, null, head);
		head.prev = newNode;
		head = newNode;
		size++;
	}

	/**
	 * Adds 'item' to the end of this linked list
	 * 
	 * @param item
	 */
	public void addLast(T item) {
		if (size == 0) {
			Node<T> newNode = new Node<T>(item, null, null);
			head = newNode;
			tail = newNode;
			size++;

		} else {
			Node<T> newNode = new Node<T>(item, tail, null);
			tail.next = newNode;
			tail = newNode;
			size++;
		}

	}

	/**
	 * Removes and returns the first item from this linked list
	 * 
	 * @return
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T removeFirst() {
		if (size == 0) {
			throw new NoSuchElementException();
		} else {
			T tempData = head.data;
			if(size == 1){
				size = 0;
				head = null;
				tail = null;
				return tempData;
			}
			head = head.next;
			head.prev = null;
			size--;
			return tempData;
		}

	}

	/**
	 * Removes and returns the last item from this linked list
	 * 
	 * @return
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T removeLast() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		else{
			T tempData = tail.data;
			if(size == 1){
				size = 0;
				head = null;
				tail = null;
				return tempData;
			}
			tail = tail.prev;
			tail.next = null;
			size--;
			return tempData;
		}
	}

	/**
	 * Gets the node pointed to by head, if this doesn't exist return null
	 * 
	 * @return Node pointed to by head or null
	 */
	public Node<T> getHead() {
		if (size > 0) {
			return head;
		}
		return null;
	}

	/**
	 * Replace the current linked list with the linked list where 'head' is it's
	 * head.
	 * 
	 * *HINT* You are replacing your current linked list with the linked list
	 * where the variable 'head' is the head. This is not the same as adding
	 * head to the front of the linked list. Think about which variables in your
	 * LinkedList you have to change when you replace the current LinkedList
	 * with another one.
	 * 
	 */
	public void replaceUsingHead(Node<T> head) {
		this.head = head;
		Node<T> current = head;
		size = 1;
		while (current.next != null) {
			current = current.next;
			size++;
		}
		tail = current;
	}

	/**
	 * Gets the node pointed to by tail, if this doesn't exist return null
	 * 
	 * @return Node pointed to by tail or null
	 */
	public Node<T> getTail() {
		if (size > 0) {
			return tail;
		}
		return null;
	}

	/**
	 * Replace the current linked list with the linked list where 'tail' is it's
	 * tail.
	 * 
	 * *HINT* You are replacing your current linked list with the linked list
	 * where the variable 'tail' is the tail. This is not the same as adding
	 * tail to the end of the linked list.Think about which variables in your
	 * LinkedList you have to change when you replace the current LinkedList
	 * with another one.
	 */
	public void replaceUsingTail(Node<T> tail) {
		this.tail = tail;
		size = 1;
		Node<T> current = tail;
		while (current.prev != null) {
			current = current.prev;
			size++;

		}
		head = current;

	}

	private class LinkedListIterator implements Iterator<T> {

		private int index;
		private LinkedList<T> list;

		public LinkedListIterator(LinkedList<T> list) {
			this.list = list;
		}

		@Override
		public boolean hasNext() {

			return index < size;
		}

		@Override
		public T next() {
			if (hasNext()) {
				return list.get(index++);
			}
			return null;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();

		}

	}

}
