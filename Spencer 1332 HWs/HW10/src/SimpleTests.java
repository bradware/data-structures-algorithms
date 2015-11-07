import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

public class SimpleTests {

	@Test
	public void basicTest1() {
		String start = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbcccccdddefghi";
		Map<Character, Integer> frequencies = HuffmanEncoding.generateFrequencyTable(start);
		HuffmanTree tree = new HuffmanTree(frequencies);
		System.out.println("Initial:\t" + start);
		String encoded = tree.encode(start);
		System.out.println("Encoded:\t" + encoded);
		assertEquals(109, encoded.length());
		String decoded = tree.decode(encoded);
		System.out.println("Decoded:\t" + decoded);
		assertEquals(start, decoded);
	}

}