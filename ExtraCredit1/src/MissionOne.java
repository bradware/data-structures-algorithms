public class MissionOne {

	/**
	 * Sort the array using an in-place sort, this algorithm must be:
	 * 
	 * in-place (no temporary arrays)
	 * stable
	 * O(n^2)
	 * 
	 * @param array
	 * @return array sorted
	 */
	public static <T extends Comparable<? super T>> T[] inplaceSort(T[] array) {
		if(array == null){
			throw new NullPointerException("Cannot sort null array");
		}
		int counter = array.length;
		for(int i = 1; i < counter; i++){
			T current = array[i];
			int j = i - 1;
			while(j >= 0 && array[j].compareTo(current) < 0){
				array[j+1] = array[j--];
				array[j+1] = current;
			}
		}
		return array;
	}
	
}