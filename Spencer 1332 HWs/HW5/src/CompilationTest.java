import java.util.Collection;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class CompilationTest {

	@SuppressWarnings("unused")
	@Test
	public void test() {
		GradableMap<String, String> map0 = new LinearProbingHashTable<String, String>();
		map0 = new LinearProbingHashTable<String, String>(66);
		map0 = new LinearProbingHashTable<String, String>(66, 0.75);
		map0.clear();
		boolean b0 = map0.containsKey(new Object());
		b0 = map0.containsValue(new Object());
		Set<Entry<String, String>> es = map0.entrySet();
		String s0 = map0.get("blastoise");
		b0 = map0.isEmpty();
		Set<String> ks = map0.keySet();
		map0.put("ditto", "zapados");
		map0.putAll(map0);
		s0 = map0.remove(new Object());
		int i0 = map0.size();
		Collection<String> vc = map0.values();
		HashTableEntry<String, String>[] htea = map0.getEntries();
		map0.setEntries(htea);
		map0.setSize(66);
		HashTableEntry<String, String> e0 = new HashTableEntry<String, String>("ponyta", "rapidash");
		b0 = e0.isAvailable();
		e0.setAvailable(b0);
		s0 = e0.getKey();
		s0 = e0.getValue();
		e0.setValue(s0);
		b0 = e0.equals(new Object());
		i0 = e0.hashCode();
		s0 = e0.toString();
	}
	
}