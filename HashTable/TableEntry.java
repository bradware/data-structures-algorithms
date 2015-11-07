import java.util.Map.Entry;

/**
 * The Class HashTableEntry.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class TableEntry<KEY,VALUE> implements Entry<KEY, VALUE> {
	
	private KEY key;
	private VALUE value;
	private boolean isAvailable;

	/**
	 * Instantiates a new hash table entry.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public TableEntry(KEY key, VALUE value){
		this.key = key;
		this.value = value;
		isAvailable = false;
	}
	
	/**
	 * Checks if the entry is available.
	 *
	 * @return true, if it is available
	 */
	public boolean isAvailable(){
		return isAvailable;
	}
	
	/**
	 * Sets the availability.
	 *
	 * @param isAvailable the new availability
	 */
	public void setAvailability(boolean isAvailable){
		this.isAvailable = isAvailable;		
	}

	@Override
	public boolean equals(Object o){
		//Two entries are equal if both the Key and Value in each of the entries is the same, 
		//in other words, .equals() returns true for both Key and Value.
		//Make sure to account for null when you are checking.
		if(o == null){
			return false;
		}
		if(!(o instanceof TableEntry<?,?>)){
			return false;
		}
		if(this.getKey().equals(((TableEntry<KEY,VALUE>)o).getKey()) && 
				this.getValue().equals(((TableEntry<KEY,VALUE>)o).getValue())){
			return true;
		}
		return false;
		
	}

	@Override
	public KEY getKey() {
		return key;
	}
	
	/**
	 * @return the hashcode of the entry as defined in Map.Entry API (Google it!)
	 */
	@Override
	public int hashCode(){
		return Math.abs(getKey().hashCode());
	}

	@Override
	public VALUE setValue(VALUE value) {
		VALUE oldValue = this.value;
		this.value = value;
		return oldValue;
	}
	
	@Override
	public VALUE getValue() {
		return value;
	}

}