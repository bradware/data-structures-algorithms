import java.util.Map;

public class HashTableEntry<K, V> implements Map.Entry<K, V> {
	private K key;
	private V value;
	private boolean available;

	public HashTableEntry(K key, V value) {
		this.key = key;
		this.value = value;
		this.available = false;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public V setValue(V value) {
		V old = this.value;
		this.value = value;

		return old;
	}

	@Override
	public boolean equals(Object that) {
		if (that instanceof Map.Entry<?, ?>) {
			Map.Entry<?, ?> other = (Map.Entry<?, ?>) that;

			return (getKey() == null ? other.getKey() == null : getKey()
					.equals(other.getKey()))
					&& (getValue() == null ? other.getValue() == null
							: getValue().equals(other.getValue()));
		}

		return false;
	}

	@Override
	public int hashCode() {
		return (getKey() == null ? 0 : getKey().hashCode())
				^ (getValue() == null ? 0 : getValue().hashCode());

	}

	@Override
	public String toString() {
		return (available ? "---" : "(" + key + ", " + value + ")");
	}
}