import java.util.*;
import java.util.Map.Entry;


public class Huffman {

	/**
	 * Builds a frequency map of characters for the given string.
	 * 
	 * This should just be the count of each character.
	 * 
	 * @param s
	 * @return
	 */
	public static Map<Character, Integer> buildFrequencyMap(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(Character c: s.toCharArray()){
			Integer isInTable = map.get(c);
			if(isInTable != null){
				map.put(c, ++isInTable);
			}else{
				map.put(c, 1);
			}
		}
		return map;
	}
	
	/**
	 * Build the Huffman tree using the frequencies given.
	 * 
	 * The frequency map will not necessarily come from the buildFrequencyMap() method.
	 * 
	 * @param freq
	 * @return
	 */
	public static Node buildHuffmanTree(Map<Character, Integer> freq){
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		for(Entry<Character, Integer> e: freq.entrySet()){
			Node newNode = new Node(e.getKey(), e.getValue());
			queue.add(newNode);
		}
		while(queue.size() > 1){
			Node first = queue.poll();
			Node second = queue.poll();
			Node parent = new Node(first, second);
			queue.add(parent);
		}
		return queue.poll();
		
	}
	
 	/**
 	 * Traverse the tree and extract the encoding for each character in the tree
 	 * 
 	 * The tree provided will be a valid huffman tree but may not come from the buildHuffmanTree() method.
 	 * 
 	 * @param tree
 	 * @return
 	 */
 	public static Map<Character, EncodedString> buildEncodingMap(Node tree) {
		HashMap<Character, EncodedString> map = new HashMap<Character, EncodedString>();
 		if(tree == null){
 			throw new NullPointerException();
 		}
 		EncodedString str = new EncodedString();
 		buildEncodingMapRecursively(tree, map, str);
 		return map;
 		
 	}
 	
 	private static void buildEncodingMapRecursively(Node tree, Map<Character, 
 			EncodedString> map, EncodedString str){
 		if(tree.left == null && tree.right == null){
 			if(str.isEmpty()){
 				str.zero();
 				map.put(tree.character, str);
 			}else{
 				EncodedString strCopy = new EncodedString();
 				strCopy.concat(str);
 				map.put(tree.character, strCopy);
 			}
 		}
 		if(tree.left != null){
 			str.zero();
 			buildEncodingMapRecursively(tree.left, map, str);
 			str.remove();
 		}
 		if(tree.right != null){
 			str.one();
 			buildEncodingMapRecursively(tree.right, map, str);
 			str.remove();
 		}
 		
 	}
	
	/**
	 * Encode each character in the string using the map provided.
	 * 
	 * If a character in the string doesn't exist in the map ignore it.
	 * 
	 * The encoding map may not necessarily come from the buildEncodingMap() method, but will be correct
	 * for the tree given to decode() when decoding this method's output.
	 * 
	 * @param encodingMap
	 * @param s
	 * @return
	 */
	public static EncodedString encode(Map<Character, EncodedString> encodingMap, String s) {
		EncodedString resultEndcode = new EncodedString();
		for(Character c: s.toCharArray()){
			if(encodingMap.containsKey(c)){
				resultEndcode.concat(encodingMap.get(c));
			}
		}
		return resultEndcode;
		
	}
	
	/**
	 * Decode the encoded string using the tree provided.
	 * 
	 * The encoded string may not necessarily come from encode, but will be a valid string for the given tree.
	 * 
	 * (tip: use StringBuilder to make this method faster -- concatenating strings is SLOW)
	 * 
	 * @param tree
	 * @param es
	 * @return
	 */
	public static String decode(Node tree, EncodedString es) {
		Node root = tree;
		StringBuilder string = new StringBuilder();
		for(Byte b: es){
			if(root.left == null && root.right == null){//if we only have 1 type of character in tree
				string.append(root.character);
				root = tree;
			}
			else if(b.equals((byte)0)){
				root = root.left;
				if(root.left == null && root.right == null){
					string.append(root.character);
					root = tree;
				}
				
			}else{
				root = root.right;
				if(root.left == null && root.right == null){
					string.append(root.character);
					root = tree;
				}
				
			}
		}
		return string.toString();
	}
	
}
