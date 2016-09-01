import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinearProbingHashtable<K, V> implements GradableMap<K, V> {
	
	/**
	 * You can change the name of this array. as far as you change the name in
	 * setArray(), getArray() and drawTable() method you are fine. we don't care
	 * about the name of this array
	 */
	private TableEntry<K, V>[] hashTable;
	
	/** DO NOT change the name of this variable*/
	private double loadFactor;
	
	private int size;

	/**
	 * Constructs a new, empty hashtable with the specified initial capacity and
	 * the specified load factor.
	 * 
	 * Throws: IllegalArgumentException - if the initial capacity is less than
	 * zero, or if the load factor is nonpositive.
	 **/
	public LinearProbingHashtable(int initialCapacity, double loadFactor) {
		if(initialCapacity < 0 || loadFactor <= 0){
			throw new IllegalArgumentException("Not implemented yet");
		}
		hashTable = new TableEntry[initialCapacity];
		this.loadFactor = loadFactor;
		size = 0;
	}

	/**
	 * Constructs a new, empty hashtable with the specified initial capacity and
	 * default load factor (0.75).
	 * 
	 * Throws: IllegalArgumentException - if the initial capacity is less than
	 * zero.
	 */
	public LinearProbingHashtable(int initialCapacity) {
		if(initialCapacity < 0){
			throw new UnsupportedOperationException("Not implemented yet");
		}
		hashTable = new TableEntry[initialCapacity];
		loadFactor = 0.75f;
		size = 0;
	}

	/**
	 * Constructs a new, empty hashtable with a default initial capacity (11)
	 * and load factor (0.75).
	 */
	public LinearProbingHashtable() {
		hashTable = new TableEntry[11];
		loadFactor = 0.75f;
		size = 0;
	}

	/** Returns the number of keys in this hashtable. */
	@Override
	public int size() {
		return size;
	}

	/** Tests if this hashtable maps no keys to values. */
	@Override
	public boolean isEmpty() {
		if(size == 0){
			return true;
		}
		return false;
	}

	/**
	 * Returns true if this hashtable maps one or more keys to this value. Note
	 * that arg0 is an Object not a generic.
	 * 
	 * This will happen in O(n). Since we don't know where the value could be,
	 * and we have to go through n element in the worst case.
	 * 
	 * Throws:NullPointerException - if the value is null
	 */
	
	@Override
	public boolean containsValue(Object arg0) {
		if(arg0 == null){
			throw new NullPointerException("Cannot search on null values");
		}
		for(int i = 0; i < hashTable.length; i++){
			if(hashTable[i] != null && hashTable[i].isAvailable() == false){
				if(hashTable[i].getValue().equals((V)arg0)){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Tests if the specified object is a key in this hashtable. Note that arg0
	 * is an Object not a generic.
	 * 
	 * Ideally it should happen in O(1)
	 * 
	 * Throws: NullPointerException - if the key is null
	 */
	@Override
	public boolean containsKey(Object arg0) {
		if(arg0 == null){
			throw new NullPointerException();
		}
		int otherHashCode = Math.abs(((K)arg0).hashCode());
		int otherIndex = otherHashCode % hashTable.length;
		while(hashTable[otherIndex] != null){
			if(hashTable[otherIndex].getKey().equals((K)arg0) && hashTable[otherIndex].isAvailable() == false){
				return true;
			}
			otherIndex++;
			if(otherIndex == hashTable.length){
				otherIndex = otherIndex%hashTable.length;
			}
		}
		return false;
	}

	/**
	 * Returns the value to which the specified key is mapped, or null if this
	 * map contains no mapping for the key. More formally, if this map contains
	 * a mapping from a key k to a value v such that (key.equals(k)), then this
	 * method returns v; otherwise it returns null. (There can be at most one
	 * such mapping.)
	 * 
	 * Ideally it should happen in O(1)
	 * 
	 * Throws: NullPointerException - if the specified key is null
	 */
	@Override
	public V get(Object arg0) {
		if(arg0 == null){
			throw new NullPointerException();
		}else if(!this.containsKey((K)arg0)){
			return null;
		}
		int otherHashCode = Math.abs(((K)arg0).hashCode());
		int otherIndex = otherHashCode % hashTable.length;
		if(otherIndex >= hashTable.length){
			return null;
		}
		while(hashTable[otherIndex] != null){
			if(hashTable[otherIndex].getKey().equals((K)arg0) && hashTable[otherIndex].isAvailable() == false){
				return hashTable[otherIndex].getValue();
			}
			otherIndex++;
			if(otherIndex == hashTable.length){
				otherIndex = otherIndex%hashTable.length;
			}
		}
		System.out.println("Code should never reach here");
		return null;
		
	}

	/**
	 * Increases the capacity of and internally reorganizes this hashtable, in
	 * order to accommodate and access its entries more efficiently. This method
	 * is called automatically when the number of keys in the hashtable exceeds
	 * this hashtable's capacity and load factor.
	 */
	protected void rehash() {
		size = 0;
		LinearProbingHashtable<K, V> newTable = new LinearProbingHashtable<K, V>((hashTable.length * 2));
		for(int i = 0; i < hashTable.length; i++){
			if(hashTable[i] != null){
				if(hashTable[i].isAvailable() == false){
					newTable.put(hashTable[i].getKey(), hashTable[i].getValue());
					size++;
				}
			}
		}
		this.setArray(newTable.getArray());
		newTable = null;
	}

	/**
	 * Maps the specified key to the specified value in this hashtable. Neither
	 * the key nor the value can be null. The value can be retrieved by calling
	 * the get method with a key that is equal to the original key.
	 * 
	 * Ideally it should happen in O(1)
	 * 
	 * Throws: NullPointerException - if the key or value is null
	 */
	@Override
	public V put(K key, V value) {
		if(key == null || value == null){
			throw new NullPointerException();
		}
		double currentLoadFactor = ((double)size)/hashTable.length;
		if( currentLoadFactor >= loadFactor){
			this.rehash();
		}
		TableEntry<K,V> newEntry = new TableEntry<K,V>(key,value);
		int hashCode = newEntry.hashCode();
		int index = hashCode % hashTable.length;
		while(hashTable[index] != null){
			if(hashTable[index].getKey().equals(key)){
				if(hashTable[index].isAvailable() == true){
					hashTable[index].setAvailability(false);
					return null;
				}else{
					hashTable[index].setAvailability(false);
					return hashTable[index].setValue(value);
				}
				
			}
			index++;
			if(index == hashTable.length){
				index = index%hashTable.length;
			}
		}
		hashTable[index] = newEntry;
		size++;
		return null;
	}

	/**
	 * Removes the key (and its corresponding value) from this hashtable. This
	 * method does nothing if the key is not in the hashtable and returns null.
	 * 
	 * Ideally it should happen in O(1)
	 * 
	 * Throws: NullPointerException - if the key is null
	 */
	@Override
	public V remove(Object key) {
		if(key == null){
			throw new NullPointerException();
		}
		if(!this.containsKey((K)key)){
			return null;
		}
		int hashCode = ((K)key).hashCode();
		int index = hashCode % hashTable.length;
		while(hashTable[index] != null){
			if(hashTable[index].getKey().equals((K)key) && hashTable[index].isAvailable() == false){
				hashTable[index].setAvailability(true);
				size--;
				return hashTable[index].getValue();
				
			}
		}
		System.out.println("should never reach here");
		return null;
	}

	/**
	 * Copies all of the mappings from the specified map to this hashtable.
	 * These mappings will replace any mappings that this hashtable had for any
	 * of the keys currently in the specified map.
	 * 
	 * This operation should run in O(n) time.
	 * 
	 * Throws: NullPointerException - if the specified map is null
	 */
	@Override
	public void putAll(Map<? extends K, ? extends V> otherMap) {
		if(otherMap == null){
			throw new NullPointerException();
		}
		@SuppressWarnings("unchecked")
		Set<K> newSet = (Set<K>)otherMap.keySet();
		for(K currentKey: newSet){
			V value = otherMap.get(currentKey);
			this.put(currentKey, value);
		}
		
	}

	/** Clears this hashtable so that it contains no keys */
	@Override
	public void clear() {
		this.setArray(new TableEntry[hashTable.length]);
		size = 0;
	}

	/**
	 * Returns a Set view of the mappings contained in this map.
	 * 
	 * This operation should run in O(n) time.
	 */
	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> newSet = new HashSet<Map.Entry<K,V>>();
		TableEntry<K,V>[] values = this.getArray();
		for(int i = 0; i < values.length; i++){
			if(values[i] != null && values[i].isAvailable() == false){
				newSet.add(values[i]);
			}
		}
		return newSet;
	}

	/**
	 * which returns a java.util.Set containing the keys currently in the table.
	 * This is the first difference between our implementation and the contract
	 * of java.util.Map. In our implementation, you may simply create an
	 * instance of java.util.HashMap and add all of the keys. In the fully
	 * compliant implementation you would have to write a new class that
	 * implements java.util.Set and is backed by the hash table. See the Java
	 * API for more information about this, if you are interested. If there are
	 * no items in the hashtable return null
	 */
	@Override
	public Set<K> keySet() {
		if(this.size() == 0){
			return null;
		}
		Set<K> newSet = new HashSet<K>();
		for(int i = 0; i < hashTable.length; i++){
			if(hashTable[i] != null && hashTable[i].isAvailable() == false){
				newSet.add(hashTable[i].getKey());
			}
		}
		return (Set<K>)newSet;
	}

	/**
	 * which returns an implementation of java.util.Collection containing all of
	 * the values in the hash table. This is the second difference between our
	 * implementation and the contract of java.util.Map. In our implementation,
	 * you may simply create an instance of java.util.ArrayList and add all of
	 * the keys. In the fully-compliant implementation you would have to write a
	 * new class that implements java.util.Collection and is backed by the hash
	 * table. See the Java API for more information about this, if you are
	 * interested.
	 */
	@Override
	public Collection<V> values() {
		ArrayList<V> values = new ArrayList<V>();
		for(int i = 0; i < hashTable.length; i++){
			if(hashTable[i] != null && hashTable[i].isAvailable() == false){
				values.add(hashTable[i].getValue());
			}
		}
		return values;
	}

	/**
	 * 
	 * draw the hashtable with entries and availability of each entry This is
	 * just to help you visualize the Hashtable. This is not a part of grading
	 */
	public void drawTable() {
		for (int i = 0; i < hashTable.length; i++) {
			System.out.print(i + "  ");
			if (hashTable[i] == null)
				System.out.println("-------------------------");
			else
				System.out.println("key:" + hashTable[i].getKey().toString()
						+ "    value:" + hashTable[i].getValue().toString()
						+ "    Available?" + hashTable[i].isAvailable());
		}
		System.out
				.println("********************************************************");
		System.out.println();
	}

	/** following methods are already implemented **/
	@Override
	public TableEntry<K, V>[] getArray() {
		return hashTable;
	}

	@Override
	public void setArray(TableEntry<K, V>[] array) {
		this.hashTable = array;
	}

	@Override
	public double getLF() {
		return loadFactor;
	}
}