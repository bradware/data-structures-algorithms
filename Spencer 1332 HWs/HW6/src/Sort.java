import java.util.Arrays;


public class Sort<T extends Comparable<T>> implements SortInterface<T> {

	protected int insertionCount;
	protected int selectionCount;
	protected int quickCount;
	protected int mergeCount;
	/**
	 * Sorts the given data using insertion sort
	 * 
	 * @param array
	 */
	public void insertionSort(T[] array) {
		insertionCount = 0;
		if(array == null || array.length ==1)
			return;
		
		for(int i = 1; i < array.length; i++){
			T temp = (T)array[i];
			int index = i;
			boolean x = false;
			for(int j = i; j > 0 && temp.compareTo(array[j - 1]) < 0; j--){
				array[j] = array[j-1];
				index = j;
				x = true;
				insertionCount++;
			}	
			insertionCount++;
			if(x)
				array[index -1] = temp;
			else
				array[index] = temp;	
		}
		
	}

	/**
	 * Sorts the given data using selection sort
	 * 
	 * @param array
	 */
	public void selectionSort(T[] array) {
		selectionCount = 0;
		if(array == null || array.length == 1)
			return;
		T temp;
		int least;
		for(int i = 0; i < array.length-1; i++){
			least = i;
			for(int j = i+1; j < array.length; j++){
				if(array[least].compareTo(array[j]) > 0)
					least = j;
				selectionCount++;
			}
			temp = array[least];
			array[least] = array[i];
			array[i] = temp;	
		}
		
	}

	/**
	 * Sorts the given data using merge sort
	 * 
	 * @param array
	 */
	public void mergeSort(T[] array) {
		mergeCount = 0;
		if (array == null)
			return;
		if (array.length > 1) {
			int front = array.length / 2;
			int back = array.length - front;

			T[] arr1 = (T[]) (new Comparable[front]);
			T[] arr2 = (T[]) (new Comparable[back]);

			for (int i = 0; i < front; i++) {
				arr1[i] = array[i];
			}

			for (int i = front; i < array.length; i++) {
				arr2[i - front] = array[i];
			}

			mergeSort(arr1);
			mergeSort(arr2);

			int Index = 0;
			int arr1Index = 0;
			int arr2Index = 0;

			while (arr1.length != arr1Index && arr2.length != arr2Index) {
				if (arr1[arr1Index].compareTo(arr2[arr2Index]) < 0) {
					array[Index] = arr1[arr1Index];
					Index++;
					arr1Index++;
				} else {
					array[Index] = arr2[arr2Index];
					Index++;
					arr2Index++;
				}
				mergeCount++;
			}
			while (arr1.length != arr1Index) {
				array[Index] = arr1[arr1Index];
				Index++;
				arr1Index++;
			}
			while (arr2.length != arr2Index) {
				array[Index] = arr2[arr2Index];
				Index++;
				arr2Index++;
			}
		}
	}
	//disregard this method
	public boolean isEmpty(Comparable[] array){
		for(int i = 0; i < array.length; i++){
			if(array[i] != null)
				return false;
		}
		return true;
	}
	
	//disregard this method
	/*public T[] subArray(T[] array, int first, int last){
		T[] arrayX = (T[]) new Comparable[last - first +1];
		for(int i = 0; i < arrayX.length; i++){
			arrayX[i] = array[first++]; 
		}
		return arrayX;
	}
	*/
	

	/**
	 * Sorts the given data using quick sort
	 * 
	 * @param array
	 */
	public void quickSort(T[] array) {
		quickCount = 0;
		if(array == null || array.length == 1)
			return;
		int max = 0;
		//find largest T and put it at the end of data
		for(int i = 1; i < array.length; i++){
			if(array[max].compareTo(array[i]) < 0)
				max = i;
			quickCount++;
		}
		swap(array, array.length - 1, max);
		qs(array, 0, array.length - 2);
	}
	
	/**
	 * Sorts the given data using quick sort
	 * 
	 * @param array, first index, last index
	 */
	public void qs(T[] array, int first, int last){
		
		int lower = first + 1;
		int upper = last;
		swap(array, first, (first+last)/2);
		T x = (T) array[first];
		while(lower <= upper){
			while(x.compareTo(array[lower])>0){
				lower++;
				quickCount++;
			}	
			while(x.compareTo(array[upper])<0){
				upper--;
				quickCount++;
			}
			if(lower<upper)
				swap(array, lower++, upper--);
			else 
				lower++;
		}
		swap(array, upper, first);
		if(first < upper-1)
			qs(array, first, upper-1);
		if(upper+1 < last)
			qs(array, upper+1, last);
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
	
}
	