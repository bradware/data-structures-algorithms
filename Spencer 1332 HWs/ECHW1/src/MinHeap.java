/**
 * This class represents a MinHeap
 * @author Spencer Powell
 * @version 1.0
 */

public class MinHeap<T extends Comparable<T>> extends Heap<T> {

	/**
	 * Takes in two Comparable objects to find which has higher priority
	 * 
	 * @param one An element to be prioritized  
	 * @param two An element to be prioritized
	 * @return  a negative value if parameter one is greater then parameter two,
	 * 			zero if compareTo returns zero,
	 * 			a positive value if parameter two is greater then parameter one
	 */
	@Override
	public int priority(T one, T two) {
		if(one.compareTo(two) > 0)
			return -1;
		if(one.compareTo(two) < 0)
			return 1;
		else
			return 0;
	}

}