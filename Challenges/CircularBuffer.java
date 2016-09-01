public class CircularBuffer<T extends Comparable<? super T>> {

	private T[] data;
	private int start;
	private int end;
	private int size;

	/**
	 * Default Constructor HINT : Read about circular buffers(or arrays) from
	 * wikipedia and google, they will come in handy for doing this assignment
	 * correctly.
	 */
	public CircularBuffer(int maxCapacity) {
		data = (T[]) new Comparable[maxCapacity];
		start = 0;
		end = 0;
		size = 0;
	}

	/**
	 * Adds the item to the structure, must be
	 * 
	 * in-place stable O(n)
	 * 
	 * @param item
	 */
	public void add(T item) {
		if (size != 10) {
			size++;
		}
		if (size == 0) {
			data[end] = item;
			end++;
			return;
		} 
		// add to end of array
		data[end] = item;
		for (int i = size - 1; i >= 0; i--) {
			T current = data[i];
			int j = i - 1;
			while (j >= 0 && data[j].compareTo(current) > 0) {
				data[j + 1] = data[j--];
				data[j + 1] = current;
			}
		}
		if (size != data.length) {
			end = ++end % data.length;
		}
	}

	/**
	 * This must return the smallest element in this structure, must be
	 * 
	 * in-place stable O(1)
	 * 
	 * @return the smallest element currently in this structure
	 */
	public T remove() {
		if (size == 0) {
			return null;
		} else {
			size--;
			T removedData = data[start];
			data[start] = null;
			start = ++start % data.length;
			if(size == 0){
				end = 0;
			}
			return removedData;
		}
	}

	public T[] getData() {
		return data;
	}
	
	public int getEnd(){
		return end;
	}
	public int getStart(){
		return start;
	}
}
