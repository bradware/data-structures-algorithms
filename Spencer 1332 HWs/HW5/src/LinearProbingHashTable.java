import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
public class LinearProbingHashTable<K, V> implements GradableMap<K, V> {

	private HashTableEntry<K, V>[] entries;
	private double maxLoadFactor;
	private int size;
	
	public LinearProbingHashTable(int length, double maxLoadFactor) {
		size = 0;
		this.maxLoadFactor = maxLoadFactor;
		entries = new HashTableEntry[length];
	}

	public LinearProbingHashTable(int length) {
		size = 0;
		maxLoadFactor = .75;
		entries = new HashTableEntry[length];
	}

	public LinearProbingHashTable() {
		size = 0;
		maxLoadFactor = .75;
		entries = new HashTableEntry[11];
	}
	/**
	 * Clears the HashTable
	 */
	public void clear() {
		size = 0;
		entries = new HashTableEntry[0];
	}

	/**
	 * Checks to see if the Hash Table contains the given key
	 * 
	 * @param key
	 * @return true if key is in the table; false otherwise
	 */
	public boolean containsKey(Object key) {
		if(key == null)
			throw new NullPointerException();
		return keySet().contains(key);
	}

	/**
	 * Checks to see if the Hash Table contains the given value
	 * 
	 * @param value
	 * @return true if value is in the table; false otherwise
	 */
	public boolean containsValue(Object value) {
		boolean x = false;
		for(int i = 0; i < entries.length; i++){
			if(entries[i].getValue().equals(value))
				return true;
		}
		return x;
		
	}

	/**
	 * @return A set of Hash Table entries that are in the hash table
	 */
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new java.util.HashSet<Map.Entry<K, V>>();
		for(int i = 0; i < entries.length; i++){
			if(entries[i] != null && !entries[i].isAvailable())
				set.add(entries[i]);
		}
		return set;
	}

	/**
	 * Gets an element from the Table
	 * 
	 * @param key
	 * @return the value that the key is paired with; null otherwise
	 * 				
	 */
	public V get(Object key) {
		if(key == null)
			throw new NullPointerException();
		if(isEmpty())
			return null;
		int hash = key.hashCode() % entries.length;
		int count = 0;
		while(entries[hash] != null && count < entries.length){
			if(!entries[hash].isAvailable() && entries[hash].getKey().equals(key))
				return entries[hash].getValue();
			count++;
			hash = (hash +1) % entries.length;
		}
		return null;
	}

	
	/**
	 * @return returns true if the list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * @return A set of keys that are in the hash table
	 */
	public Set<K> keySet() {
		Set<K> set = new java.util.HashSet<K>();
		for(int i = 0; i < entries.length; i++){
			if(entries[i] != null && !entries[i].isAvailable())
			set.add(entries[i].getKey());
		}
		return set;
	}

	/**
	 * Puts an entry into the Table
	 * 
	 * @param key, value
	 * @return the old value if there is identical keys, else the value of the inserted element
	 * 				
	 */
	public V put(K key, V value) {
		if(key == null) {
			throw new NullPointerException();
		}
		if(size == entries.length) {
			return null;
		}
		V oldValue = null;
		int i = key.hashCode() % entries.length;
		boolean res = false;
		while(!res) {
			if(entries[i] == null || entries[i].isAvailable()) {
				entries[i] = new HashTableEntry<K,V>(key, value);
				size++;
				res = true;
			}
			else if(entries[i].getKey() == key) {
				oldValue = entries[i].getValue();
				entries[i] = new HashTableEntry<K,V>(key, value);
				res = true;
			}
			i = (i + 1) % entries.length;
		}
			
			if (size * 1.0 / entries.length > maxLoadFactor) {
				//make new table
				HashTableEntry<K,V>[] newTable = new HashTableEntry[entries.length * 2 + 1];
				//loop through old table
				for(int j = 0; j < entries.length; j++) {
					//if entry in old table is there
					if(entries[j] != null && !entries[j].isAvailable()) {
						//find index for key in new table
						int k = entries[j].getKey().hashCode() % newTable.length;
						boolean x = false;
						while(!x) {
							//if spot is available in new table
							if(newTable[k] == null || newTable[k].isAvailable()) {
								//entry in new table with old key and value
								newTable[k] = new HashTableEntry<K,V>(entries[j].getKey(), entries[j].getValue());
								x = true;
							}
							k = (k + 1) % newTable.length;
						}
					}
					
				}
				entries = newTable;
			}
			return value;	
		
		}
	
			

	/**
	 * Adds all of the values from your map to your hash table
	 */
	public void putAll(Map<? extends K, ? extends V> map) {
		if(map == null) {
			return;
		}
		Set<K> set = (Set<K>) map.keySet();
		for(K e : set) {
			put(e,map.get(e));
		}
	}

	/**
	 * Removes an entry from the Table
	 * 
	 * @param key
	 * @return null if no entry was removed, otherwise it returns the value of the removed entry
	 * 				
	 */
	public V remove(Object key) {
		if(key == null) {
			throw new NullPointerException();
		}
		V data = null;
		int i = key.hashCode() % entries.length;
		Boolean res = false;
		int count = 0;
		while(entries[i] != null && !res && count < entries.length) {
			if(!entries[i].isAvailable() && entries[i].getKey()==key) {
				data = entries[i].getValue();
				entries[i].setAvailable(true);
				size--;
				res = true;
			}
			count++;
			i = (i + 1) % entries.length;
		}
		return data;
	}

	/**
	 * @return number of entries in the table
	 */
	public int size() {
		return size;
	}

	/**
	 * @return a collection of all the values in the HashTable
	 */
	public Collection<V> values() {
		ArrayList<V> list = new ArrayList<V>();
		for(int i = 0; i < entries.length; i ++) {
			if(entries[i] != null && !entries[i].isAvailable()) {
				list.add(entries[i].getValue());
			}
		}
		return list;
	}
	

	/*
	 * DO NOT MODIFY CODE BELOW THIS POINT, THESE METHODS ARE USE FOR GRADING
	 */
	
	@Override
	public HashTableEntry<K, V>[] getEntries() {
		return entries;
	}

	@Override
	public void setEntries(HashTableEntry<K, V>[] entries) {
		this.entries = entries;
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}
}
