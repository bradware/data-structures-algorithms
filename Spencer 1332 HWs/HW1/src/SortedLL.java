

public class SortedLL<T extends Comparable<T>> implements SortedListInterface<T>  {
	
	private int size;
	private NodeInterface<T> head;
	private NodeInterface<T> tail;
	
	

	/**
	 * Add data to this sorted list in the correct position.
	 * 
	 * @param data
	 */
	public void add(T data) {
		if(data == null){
			return;
		}
		
		Node<T> addit = new Node<T>(data);
		//adding to empty list
		if(size == 0){
			head = addit;
			tail = addit;
			size++;
			return;
		}
		
		//adding to head
		if(data.compareTo(head.getData()) < 0) {
			head.setPrev(addit);
			addit.setNext(head);
			head = addit;
			size++;
			return;
		}
		//adding to tail
		if(data.compareTo(tail.getData()) > 0){
			tail.setNext(addit);
			addit.setPrev(tail);
			addit.setNext(null);
			tail = addit;
			size++;
			return;
		}
		NodeInterface<T> curr = head;	
		while(1 == 1){
			//adding to middle
			if(data.compareTo(curr.getData()) > 0 && data.compareTo(curr.getNext().getData()) < 0) {
				curr.getNext().setPrev(addit);
				addit.setPrev(curr);
				addit.setNext(curr.getNext());
				curr.setNext(addit);
				size++;
				return;
			}
			
			curr = curr.getNext();
		}
				
				
			
	}

	/**
	 * Check if this list contains data
	 * 
	 * @param data
	 * @return true if this contains data, false otherwise
	 */
	public boolean contains(T data) {
		boolean contain = false;
		for(int i = 0; i < size; i++){
			if(data.equals(getAt(i)))
				contain = true;
		}
			return contain;
	}

	/**
	 * Gets the element FROM THIS LIST that is equal to the provided data
	 * 
	 * @param data
	 * @return the element FROM THIS LIST that is equal to the provided data,
	 *         null if no such element exists
	 */
	public T get(T data) {
		T x = null;
		for(int i = 0; i < size; i++){
			if(data.equals(getAt(i)))
				x = getAt(i);
		}
		return x;
	}
	/**
	 * Gets the element at the given index
	 * 
	 * @param index
	 *            the 0-based index of an element
	 * @return the element at the given index
	 */
	public T getAt(int index)
	{
		NodeInterface<T> x = head;
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		for(int i = 0; i < index; i++)
			x = x.getNext();
		
		return x.getData();
	}

	/**
	 * @return the maximum element (last), null if it doesn't exist
	 */
	public T getMax() {
		if(tail != null)
			return tail.getData();
		else
			return null;
	}

	/**
	 * @return the minimum element (first), null if it doesn't exist
	 */
	public T getMin() {
		if(head != null)
			return head.getData();
		else
			return null;
	}

	/**
	 * Removes the element that is equal to the provided data, and returns the
	 * element THAT WAS REMOVED
	 * 
	 * @param data
	 * @return the element THAT WAS REMOVED, null if nothing was removed
	 */
	public T remove(T data) {
		T elem = null;
		elem = get(data);
		
		if(elem != null){
		//NodeInterface<T> rem = new Node<T>(elem);
		NodeInterface<T> curr = head;
			//remove if one node
			if(size == 1 && data.equals(head.getData()))
			{
				head = null;
				tail = null;
				size--;
				return elem;
			}
		
			//remove from head
			if(data.equals(head.getData())){
				curr = head;
				curr = curr.getNext();
				curr.getPrev().setNext(null);
				curr.setPrev(null);
				head = curr;
				size--;
				return elem;
			}
			//remove from tail
			if(data.equals(tail.getData())){
				curr = tail;
				curr = curr.getPrev();
				curr.getNext().setPrev(null);
				curr.setNext(null);
				tail = curr;
				size--;
				return elem;
			}
			
			while(curr != null){
				//removing from middle
				 if(data.equals(curr.getData())){
					curr.getNext().setPrev(curr.getPrev());
					curr.getPrev().setNext(curr.getNext());
					curr.setNext(null);
					curr.setPrev(null);
					size--;
					return elem;
				}
				 curr = curr.getNext();
			}
		}
		return elem;
			
	
	}

	/**
	 * Removes the element at the given index
	 * 
	 * @param index
	 *            the 0-based index of an element
	 * @return the element removed
	 */
	public T removeAt(int index) {
		T x = getAt(index);
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		return remove(x);
	}

	/**
	 * Removes the maximum element from this list (last)
	 * 
	 * @return the element removed
	 */
	public T removeMax() {
		T x = getMax();
		return remove(x);
	}

	/**
	 * Removes the minimum element from this list (first)
	 * 
	 * @return the element removed
	 */
	public T removeMin() {
		T x = getMin();
		return remove(x);
	}

	/**
	 * @return the number of elements in this list
	 */
	public int size() {
		return size;
	}
	
	/**
	 * @return true if this list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return (head == null && tail == null);
	}
}