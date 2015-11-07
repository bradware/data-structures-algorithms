
public interface SortInterface<T extends Comparable<T>> {
	public void insertionSort(T[] array);
	public void selectionSort(T[] array);
	public void mergeSort(T[] array);
	public void quickSort(T[] array);
}