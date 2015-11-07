import java.util.Map;

/**
 * Defines the additional methods required for this homework assignment.
 * 
 * These methods are necessary to allow us to grade each method individually, so
 * that an error in one method does not cause you to lose points in another.
 * These methods would not normally be included in an implementation of
 * java.util.Map.
 * 
 * @param <K>
 *            The variable type of the keys
 * @param <V>
 *            The variable type of the values
 */
public interface GradableMap<K, V>
		extends Map<K, V>
{
	/**
	 * Returns the array backing this map.
	 * 
	 * @return The array backing this map
	 */
	public HashTableEntry<K, V>[] getEntries();
	
	/**
	 * Sets the array backing this map.
	 * 
	 * @param entries
	 *            The new array backing this map.
	 */
	public void setEntries(HashTableEntry<K, V>[] entries);
	
	/**
	 * Sets the size of the map.
	 * 
	 * @param size
	 *            The new size of the map
	 */
	public void setSize(int size);
}