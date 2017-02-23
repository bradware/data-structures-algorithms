import java.util.Comparator;

/**
 * This is an implementation of a max binary heap that is backed by an array.
 * This means the largest item will be at the root.
 * 
 * This implementation will accept a comparator object that can be used to
 * define an ordering of the items contained in this heap, other than the
 * objects' default compareTo method (if they are comparable). This is useful if
 * you wanted to sort strings by their length rather than their lexicographic
 * ordering. That's just one example. Null should be treated as positive
 * infinity if no comparator is provided. If a comparator is provided, you
 * should let it handle nulls, which means it could possibly throw a
 * NullPointerException, which in this case would be fine.
 * 
 * If a comparator is provided that should always be what you use to compare
 * objects. If no comparator is provided you may assume the objects are
 * Comparable and cast them to type Comparable<T> for comparisons. If they
 * happen to not be Comparable you do not need to handle anything, and you can
 * just let your cast throw a ClassCastException.
 */
public class BinaryHeap<T> implements Heap<T> {
	/**
	 * This the current size/number of elements in the heap
	 */
	private int size;

	/**
	 * This is the Comparator that will be used order the elements in the heap
	 */
	private Comparator<T> comp;

	/**
	 * This is the array used to back the heap.
	 */
	private T[] data;

	/**
	 * Default constructor, this should initialize data to a default size (11 is
	 * normally a good choice)
	 * 
	 * This assumes that the generic objects are Comparable, you will need to
	 * cast them when comparing since there are no bounds on the generic
	 * parameter
	 */
	public BinaryHeap() {
		comp = new HeapComparator<T>();
		data = (T[]) new Object[11];
		size = 0;
	}

	/**
	 * Constructor that accepts a custom comparator to use with this heap. Also
	 * initializes data to a default size.
	 * 
	 * When a comparator is provided it should be preferred over the objects'
	 * compareTo method
	 * 
	 * If the comparator given is null you should attempt to cast the objects to
	 * Comparable as if a comparator were not given
	 * 
	 * @param comp
	 */
	public BinaryHeap(Comparator<T> comp){
		this.comp = comp;
		data = (T[]) new Object[11];
		size = 0;
	}

	/**
	 * The first element will be added to index 0 of the array. If the array
	 * becomes full, resize.
	 */
	@Override
	public void add(T item) {
		if (size == 0) {
			data[0] = item;
			size++;
		} else {
			if (size == data.length) {
				this.resize();
			}
			int current = size;
			data[current] = item;
			if(comp == null){
				comp = new HeapComparator<T>();
			}
			while (comp.compare(data[current], data[(current - 1) / 2]) > 0) {
				T tempData = data[current];
				data[current] = data[(current - 1) / 2];
				data[(current - 1) / 2] = tempData;
				current = (current - 1) / 2;
				if (current < 1) {
					break;
				}

			}
			size++;
		}
	}

	public void resize() {
		T[] newArr = (T[])new Object[size * 2];
		for (int i = 0; i < data.length; i++) {
			newArr[i] = data[i];
		}
		data = newArr;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	/**
	 * @throw NullPointerException if list is empty
	 */
	@Override
	public T peek() {
		if (isEmpty()) {
			throw new NullPointerException("Empty list");
		} else {
			return data[0];
		}
	}

	/**
	 * Return null if list is empty.
	 */
	@Override
	public T remove() {
		if (isEmpty()) {
			return null;
		}
		if (size == 1) {
			size--;
			return data[0];
		} else {
			T tempData = data[0];
			data[0] = data[size-1];
			data[size-1] = tempData;
			size--;
			if(size == 1){
				return tempData;
			}
			int current = 0;
			int leftChild = (2 * current) + 1;
			int rightChild = (2 * current) + 2;
			while (comp.compare(data[current], data[leftChild]) < 1
					|| comp.compare(data[current], data[rightChild]) < 1) {
				T temp = data[current];
				if (rightChild == size) {
					if (comp.compare(data[current], data[leftChild]) < 1) {
						data[current] = data[leftChild];
						data[leftChild] = temp;
						current = leftChild;
					}
				} else if (comp.compare(data[leftChild], data[rightChild]) > 0) {
					data[current] = data[leftChild];
					data[leftChild] = temp;
					current = leftChild;
				} else {
					data[current] = data[rightChild];
					data[rightChild] = temp;
					current = rightChild;
				}
				if(current != rightChild){
					current = leftChild;
				}
				rightChild = (2 * current) + 2;
				leftChild = (2 * current) + 1;
				if (!(leftChild < size)){
					break;
				}

			}
			return tempData;
		}
	}

	@Override
	public int size() {
		return size;
	}

	/**
	 * Performs heapsort on a copy of the current heap and returns an array of
	 * sorted elements in ascending order. The original heap must not be
	 * altered.
	 * 
	 * @return sorted list of elements in the heap
	 */
	public T[] heapSort() {
		if(size == 0){
			return null;
		}
		T[] returnedArray = (T[])new Object[this.size];
		BinaryHeap<T> newHeap = new BinaryHeap<T>(comp);
		for(int i = 0; i < this.size(); i++){
			if(i == newHeap.data.length){
				newHeap.resize();
			}
			newHeap.getData()[i] = this.getData()[i];
			newHeap.size++;
		}
		int addToEnd = newHeap.size-1;
		while(addToEnd >= 0){
			T removedData = newHeap.remove();
			returnedArray[addToEnd] = removedData;
			addToEnd--;
		}
		return returnedArray;
		
	}
	
	public boolean heapSortWorked(T[] answer){
		if(answer == null){
			throw new UnsupportedOperationException("List is empty");
		}
		for(int i = 1; i < answer.length; i++){
			if(comp.compare(answer[i-1], answer[i]) > 0){
				return false;
			}
		}
		return true;
	}

	public T[] getData() {
		return data;
	}

	private class HeapComparator<T> implements Comparator<T> {

		@Override
		public int compare(T o1, T o2) {
			if (o1 == null) {
				return 1332;
			} else if (o2 == null) {
				return -2110;
			} else if (o1 == null & o2 == null) {
				return 0;
			} else {
				return ((Comparable<T>) o1).compareTo(o2);
			}
		}

	}

}