import java.util.HashMap;
import java.util.Map;
import java.util.Map;

public abstract class HuffmanEncoding {
	/**
	 * 
	 * @param text
	 * @return
	 */
	public static Map<Character, Integer> generateFrequencyTable(String text) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		if (text.length() == 0 || text == null) {
			return null;
		}

		for (int i = 0; i < text.length(); i++) {
			if (map.containsKey(text.charAt(i))) {
				int value = map.get(text.charAt(i));
				map.put(text.charAt(i), value + 1);
			} else {
				map.put(text.charAt(i), 1);
			}
		}
		return map;
	}
}