import java.util.Set;
import java.util.LinkedList;


public class HeapSort {

	/**
	 * This method will take in a set of Comparable values that will then be sorted using a heap
	 * 
	 * @param set The set of type V elements to be heap sorted
	 * @return a LinkedList with the elements from the set parameter in sorted order
	 */
	public static <T extends Comparable<T>> LinkedList<T> heapSort(Set<T> set) {
		Comparable[] arr = (T[]) new Comparable[0];
		arr = set.toArray(arr);
		MinHeap<T> sorter = new MinHeap<T>();
		for(int i =0; i < arr.length; i ++) {
			sorter.add((T)arr[i]);
		}
		LinkedList<T> list = new LinkedList<T>();
		for(int i = 0; i < arr.length; i ++) {
			list.add(sorter.remove());
		}
		return list;
	}
	
}