import java.util.Collection;

/**
 * This class represents a Heap 
 * @author Spencer Powell
 * @version 1.0
 */
public abstract class Heap<T extends Comparable<T>> implements HeapInterface<T> {

	public abstract int priority(T one, T two);

	/**
	 * This is the array containing your data. You MUST leave index 0 empty or
	 * your grade will be low. So start putting stuff at index 1, this will
	 * actually make the heap easier to implement.
	 */
	protected T[] array;
	private int size;

	/**
	 * Initializes the array with a default capacity of 11, and initializes the
	 * size to 0.
	 */
	public Heap() {
		array = (T[]) new Comparable[11];
		size = 0;
	}

	/**
	 * Initializes the array with the given capacity, you do not need to do any
	 * checks on the capacity, it will be valid in our tests. and initialize the
	 * size to 0.
	 * 
	 * @param capacity
	 *            the starting capacity of the heap
	 */
	public Heap(int capacity) {
		array = (T[]) new Comparable[capacity];
		size = 0;
	}

	/**
	 * @return If the heap has elements in it
	 */
	public boolean isEmpty(){
		for(int i = 0; i < array.length; i++){
			if(array[i] != null)
				return false;
		}
		return true;
	}

	/**
	 * @return The number of elements in the heap
	 */
	public int size() {
		int count = 0;
		for(int i = 0; i < array.length; i++){
			if(array[i] != null)
				count++;
		}
		return count;
	}
	

	/**
	 * Returns the element in the heap with the highest priority
	 * 
	 * @return the element with highest priority
	 */
	public T getFirst() {
		if(isEmpty())
			return null;
		return array[1];
	}

	/**
	 * Removes and returns the element in the heap with the highest priority
	 * 
	 * @return the element with highest priority
	 */
	public T remove() {
		if(!isEmpty()){
			int i = findLast();
			int j = 2;
			
			T temp = array[1];
			array[1] = array[i];
			array[i] = null;
			T root = array[1];
			while(j < i && priority(root, array[j]) < 0){
					swap(array, j, j-1);
					j++;
			}
			return temp;
		}
		else
			return null;
	}

	/**
	 * Inserts an element into the proper place in the array based on its priority
	 * 
	 * @param data The data to be inserted into the heap
	 */
	public void add(T data) {
		if(data == null)
			return;
		
		int i = 0;
		//list empty
		if(isEmpty()){
			array[1] = data;
			return;
		}
		
		if(findLast() == array.length - 1 && priority(data, array[findLast()]) > 0){
			i = findLast();
			array[i] = data;
		}
		else if(findLast() != array.length - 1){
			i = findLast() + 1;
			array[i] = data;
		}
		else
			return;
	
			while(array[i] != null && i > 1 && priority(data, array[i-1]) > 0){
				swap(array, i, i-1);
				i--;
			}
		
	}
	/**
	 * Helper method that finds the index of the last element
	 * 
	 */
	public int findLast(){
		for(int i = array.length - 1; i > 0; i--){
			if(array[i] != null)
				return i;
		}
		return 0;
	}
	
	/**
	 * Helper method that swaps
	 * @param array
	 * @param i
	 * @param j
	 */
	private void swap(T[] array, int i, int j){
		T tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	@Override
	public void addAll(Collection<T> elements) {
		if(elements == null) {
			return;
		}
		for(T element: elements) {
			add(element);
		}
	}

	// do not modify methods below this point, they are for grading purposes

	@Override
	public T[] getArray() {
		return array;
	}

	@Override
	public void setArray(T[] array) {
		this.array = array;
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}
}