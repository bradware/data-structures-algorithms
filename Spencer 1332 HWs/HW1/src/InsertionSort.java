
public class InsertionSort<T extends Comparable<T>> implements SortInterface<T> {

	/**
	 * Takes in an unsorted array, and sorts it
	 * 
	 * @param array2, sorter
	 * 			
	 * @return the newly sorted array
	 */
	public T[] sort(T[] array2, SortedListInterface<T> sorter) {
		sorter = new SortedLL();
		T[] array = (T[]) new Comparable[array2.length];
		for(int i = 0; i < array2.length; i++)
			sorter.add(array2[i]);
		
		for(int j = 0; j < array2.length; j++)
			array[j] = sorter.removeMin();
		for(int i = 0; i < array2.length; i++)
			System.out.print(array[i]);
		return array;
		
	}

}