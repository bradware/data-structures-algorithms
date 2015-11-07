
public interface SortInterface<T extends Comparable<T>> {

	public T[] sort(T[] arr, SortedListInterface<T> sorter);
	
}