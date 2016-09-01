import java.util.Map;

import org.junit.Test;




public class HuffmanJUnit{
	//Don't worry about test for String "" because a Tree cannot be built without any characters
	@Test
	public void test1(){
		System.out.println();
		System.out.println("Test 1 -----");
		String startString = "cat";
		Map<Character, Integer> map1 = Huffman.buildFrequencyMap(startString);
		Node root = Huffman.buildHuffmanTree(map1);
		Map<Character, EncodedString> encodedMap = Huffman.buildEncodingMap(root);
		EncodedString binaryCode = Huffman.encode(encodedMap, startString);
		String endString = Huffman.decode(root, binaryCode);
		System.out.println("Start String: " + startString);
		System.out.println("End String: " + endString);
		System.out.println("Are the equal? " + startString.equals(endString));
	}
	
	@Test
	public void test2(){
		System.out.println();
		System.out.println("Test 2 -----");
		String startString = "badboy";
		Map<Character, Integer> map1 = Huffman.buildFrequencyMap(startString);
		Node root = Huffman.buildHuffmanTree(map1);
		Map<Character, EncodedString> encodedMap = Huffman.buildEncodingMap(root);
		EncodedString binaryCode = Huffman.encode(encodedMap, startString);
		String endString = Huffman.decode(root, binaryCode);
		System.out.println("Start String: " + startString);
		System.out.println("End String: " + endString);
		System.out.println("Are the equal? " + startString.equals(endString));
	}
	

	@Test
	public void test3(){
		System.out.println();
		System.out.println("Test 3 -----");
		String startString = "----- ------- -----";
		Map<Character, Integer> map1 = Huffman.buildFrequencyMap(startString);
		Node root = Huffman.buildHuffmanTree(map1);
		Map<Character, EncodedString> encodedMap = Huffman.buildEncodingMap(root);
		EncodedString binaryCode = Huffman.encode(encodedMap, startString);
		String endString = Huffman.decode(root, binaryCode);
		System.out.println("Start String: " + startString);
		System.out.println("End String: " + endString);
		System.out.println("Are the equal? " + startString.equals(endString));
	}
	
	@Test
	public void test4(){
		System.out.println();
		System.out.println("Test 4 -----");
		String startString = "aaaaaaaaaaaaa";
		Map<Character, Integer> map1 = Huffman.buildFrequencyMap(startString);
		Node root = Huffman.buildHuffmanTree(map1);
		Map<Character, EncodedString> encodedMap = Huffman.buildEncodingMap(root);
		EncodedString binaryCode = Huffman.encode(encodedMap, startString);
		String endString = Huffman.decode(root, binaryCode);
		System.out.println("Start String: " + startString);
		System.out.println("End String: " + endString);
		System.out.println("Are the equal? " + startString.equals(endString));
	}
	
	@Test
	public void test5(){
		System.out.println();
		System.out.println("Test 5 -----");
		String startString = "abababababababab";
		Map<Character, Integer> map1 = Huffman.buildFrequencyMap(startString);
		Node root = Huffman.buildHuffmanTree(map1);
		Map<Character, EncodedString> encodedMap = Huffman.buildEncodingMap(root);
		EncodedString binaryCode = Huffman.encode(encodedMap, startString);
		String endString = Huffman.decode(root, binaryCode);
		System.out.println("Start String: " + startString);
		System.out.println("End String: " + endString);
		System.out.println("Are the equal? " + startString.equals(endString));
	}
	
	@Test
	public void test6(){
		System.out.println();
		System.out.println("Test 6 -----");
		String startString = "a    a   bababa    jakdk adkfw ftw wjalkdf ";
		Map<Character, Integer> map1 = Huffman.buildFrequencyMap(startString);
		Node root = Huffman.buildHuffmanTree(map1);
		Map<Character, EncodedString> encodedMap = Huffman.buildEncodingMap(root);
		EncodedString binaryCode = Huffman.encode(encodedMap, startString);
		String endString = Huffman.decode(root, binaryCode);
		System.out.println("Start String: " + startString);
		System.out.println("End String: " + endString);
		System.out.println("Are the equal? " + startString.equals(endString));
	}
	
	@Test
	public void test7(){
		System.out.println();
		System.out.println("Test 7 -----");
		String startString = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
		Map<Character, Integer> map1 = Huffman.buildFrequencyMap(startString);
		Node root = Huffman.buildHuffmanTree(map1);
		Map<Character, EncodedString> encodedMap = Huffman.buildEncodingMap(root);
		EncodedString binaryCode = Huffman.encode(encodedMap, startString);
		String endString = Huffman.decode(root, binaryCode);
		System.out.println("Start String: " + startString);
		System.out.println("End String: " + endString);
		System.out.println("Are the equal? " + startString.equals(endString));
	}
	
	@Test
	public void test8(){
		System.out.println();
		System.out.println("Test 8 -----");
		String startString = "1 2 3 4 5 6 7 8 9 10 11 22 33 44 55 66 77 88 99";
		Map<Character, Integer> map1 = Huffman.buildFrequencyMap(startString);
		Node root = Huffman.buildHuffmanTree(map1);
		Map<Character, EncodedString> encodedMap = Huffman.buildEncodingMap(root);
		EncodedString binaryCode = Huffman.encode(encodedMap, startString);
		String endString = Huffman.decode(root, binaryCode);
		System.out.println("Start String: " + startString);
		System.out.println("End String: " + endString);
		System.out.println("Are the equal? " + startString.equals(endString));
	}
	
	@Test
	public void test9(){
		System.out.println();
		System.out.println("Test 9 -----");
		String startString = "&&&& *** $$$ jldajfa !!@@__($(#())@_! #*U)@UR)(@#FEOF";
		Map<Character, Integer> map1 = Huffman.buildFrequencyMap(startString);
		Node root = Huffman.buildHuffmanTree(map1);
		Map<Character, EncodedString> encodedMap = Huffman.buildEncodingMap(root);
		EncodedString binaryCode = Huffman.encode(encodedMap, startString);
		String endString = Huffman.decode(root, binaryCode);
		System.out.println("Start String: " + startString);
		System.out.println("End String: " + endString);
		System.out.println("Are the equal? " + startString.equals(endString));
	}
	
	@Test
	public void test10(){
		System.out.println();
		System.out.println("Test 10 -----");
		String startString = " ";
		Map<Character, Integer> map1 = Huffman.buildFrequencyMap(startString);
		Node root = Huffman.buildHuffmanTree(map1);
		Map<Character, EncodedString> encodedMap = Huffman.buildEncodingMap(root);
		EncodedString binaryCode = Huffman.encode(encodedMap, startString);
		String endString = Huffman.decode(root, binaryCode);
		System.out.println("Start String: " + startString);
		System.out.println("End String: " + endString);
		System.out.println("Are the equal? " + startString.equals(endString));
	}
	
	@Test
	public void test11(){
		System.out.println();
		System.out.println("Test 11 -----");
		String startString = "abcdefabcdefabcdef";
		Map<Character, Integer> map1 = Huffman.buildFrequencyMap(startString);
		Node root = Huffman.buildHuffmanTree(map1);
		Map<Character, EncodedString> encodedMap = Huffman.buildEncodingMap(root);
		EncodedString binaryCode = Huffman.encode(encodedMap, startString);
		String endString = Huffman.decode(root, binaryCode);
		System.out.println("Start String: " + startString);
		System.out.println("End String: " + endString);
		System.out.println("Are the equal? " + startString.equals(endString));
	}
	
	@Test
	public void test12(){
		System.out.println();
		System.out.println("Test 12 -----");
		String startString = "a";
		Map<Character, Integer> map1 = Huffman.buildFrequencyMap(startString);
		Node root = Huffman.buildHuffmanTree(map1);
		Map<Character, EncodedString> encodedMap = Huffman.buildEncodingMap(root);
		EncodedString binaryCode = Huffman.encode(encodedMap, startString);
		String endString = Huffman.decode(root, binaryCode);
		System.out.println("Start String: " + startString);
		System.out.println("End String: " + endString);
		System.out.println("Are the equal? " + startString.equals(endString));
	}
	
	@Test
	public void test13(){
		System.out.println();
		System.out.println("Test 13 -----");
		String startString = "aa";
		Map<Character, Integer> map1 = Huffman.buildFrequencyMap(startString);
		Node root = Huffman.buildHuffmanTree(map1);
		Map<Character, EncodedString> encodedMap = Huffman.buildEncodingMap(root);
		EncodedString binaryCode = Huffman.encode(encodedMap, startString);
		String endString = Huffman.decode(root, binaryCode);
		System.out.println("Start String: " + startString);
		System.out.println("End String: " + endString);
		System.out.println("Are the equal? " + startString.equals(endString));
	}
	
	@Test
	public void test14(){
		System.out.println();
		System.out.println("Test 14 -----");
		String startString = "aaaaaaaabbbbbbbb";
		Map<Character, Integer> map1 = Huffman.buildFrequencyMap(startString);
		Node root = Huffman.buildHuffmanTree(map1);
		Map<Character, EncodedString> encodedMap = Huffman.buildEncodingMap(root);
		EncodedString binaryCode = Huffman.encode(encodedMap, startString);
		String endString = Huffman.decode(root, binaryCode);
		System.out.println("Start String: " + startString);
		System.out.println("End String: " + endString);
		System.out.println("Are the equal? " + startString.equals(endString));
	}
	

	@Test
	public void test15(){
		System.out.println();
		System.out.println("Test 15 -----");
		String startString = "ab";
		Map<Character, Integer> map1 = Huffman.buildFrequencyMap(startString);
		Node root = Huffman.buildHuffmanTree(map1);
		Map<Character, EncodedString> encodedMap = Huffman.buildEncodingMap(root);
		EncodedString binaryCode = Huffman.encode(encodedMap, startString);
		String endString = Huffman.decode(root, binaryCode);
		System.out.println("Start String: " + startString);
		System.out.println("End String: " + endString);
		System.out.println("Are the equal? " + startString.equals(endString));
	}
	
	@Test
	public void test16(){
		System.out.println();
		System.out.println("Test 16 -----");
		String startString = "David";
		Map<Character, Integer> map1 = Huffman.buildFrequencyMap(startString);
		Node root = Huffman.buildHuffmanTree(map1);
		Map<Character, EncodedString> encodedMap = Huffman.buildEncodingMap(root);
		EncodedString binaryCode = Huffman.encode(encodedMap, startString);
		String endString = Huffman.decode(root, binaryCode);
		System.out.println("Start String: " + startString);
		System.out.println("End String: " + endString);
		System.out.println("Are the equal? " + startString.equals(endString));
	}
	
	@Test
	public void test17(){
		System.out.println();
		System.out.println("Test 17 -----");
		String startString = "A a B b C c D d E e F f G g H h I i J j K k L l M m N n O o P p " +
				"Q q R r S s T t U u V v W w X x Y y Z z";
		Map<Character, Integer> map1 = Huffman.buildFrequencyMap(startString);
		Node root = Huffman.buildHuffmanTree(map1);
		Map<Character, EncodedString> encodedMap = Huffman.buildEncodingMap(root);
		EncodedString binaryCode = Huffman.encode(encodedMap, startString);
		String endString = Huffman.decode(root, binaryCode);
		System.out.println("Start String: " + startString);
		System.out.println("End String: " + endString);
		System.out.println("Are the equal? " + startString.equals(endString));
	}
	
	@Test
	public void test18(){
		System.out.println();
		System.out.println("Test 18 -----");
		String startString = "DDDDDDDdddddd";
		Map<Character, Integer> map1 = Huffman.buildFrequencyMap(startString);
		Node root = Huffman.buildHuffmanTree(map1);
		Map<Character, EncodedString> encodedMap = Huffman.buildEncodingMap(root);
		EncodedString binaryCode = Huffman.encode(encodedMap, startString);
		String endString = Huffman.decode(root, binaryCode);
		System.out.println("Start String: " + startString);
		System.out.println("End String: " + endString);
		System.out.println("Are the equal? " + startString.equals(endString));
	}
	
	@Test
	public void test19(){
		System.out.println();
		System.out.println("Test 19 -----");
		String startString = "D";
		Map<Character, Integer> map1 = Huffman.buildFrequencyMap(startString);
		Node root = Huffman.buildHuffmanTree(map1);
		Map<Character, EncodedString> encodedMap = Huffman.buildEncodingMap(root);
		EncodedString binaryCode = Huffman.encode(encodedMap, startString);
		String endString = Huffman.decode(root, binaryCode);
		System.out.println("Start String: " + startString);
		System.out.println("End String: " + endString);
		System.out.println("Are the equal? " + startString.equals(endString));
	}
	

	@Test
	public void test20(){
		System.out.println();
		System.out.println("Test 20 -----");
		String startString = "DD";
		Map<Character, Integer> map1 = Huffman.buildFrequencyMap(startString);
		Node root = Huffman.buildHuffmanTree(map1);
		Map<Character, EncodedString> encodedMap = Huffman.buildEncodingMap(root);
		EncodedString binaryCode = Huffman.encode(encodedMap, startString);
		String endString = Huffman.decode(root, binaryCode);
		System.out.println("Start String: " + startString);
		System.out.println("End String: " + endString);
		System.out.println("Are the equal? " + startString.equals(endString));
	}
	
	@Test
	public void test21(){
		System.out.println();
		System.out.println("Test 21 -----");
		String startString = "dD";
		Map<Character, Integer> map1 = Huffman.buildFrequencyMap(startString);
		Node root = Huffman.buildHuffmanTree(map1);
		Map<Character, EncodedString> encodedMap = Huffman.buildEncodingMap(root);
		EncodedString binaryCode = Huffman.encode(encodedMap, startString);
		String endString = Huffman.decode(root, binaryCode);
		System.out.println("Start String: " + startString);
		System.out.println("End String: " + endString);
		System.out.println("Are the equal? " + startString.equals(endString));
	}
	

	@Test
	public void test22(){
		System.out.println();
		System.out.println("Test 22 -----");
		String startString = "Dd";
		Map<Character, Integer> map1 = Huffman.buildFrequencyMap(startString);
		Node root = Huffman.buildHuffmanTree(map1);
		Map<Character, EncodedString> encodedMap = Huffman.buildEncodingMap(root);
		EncodedString binaryCode = Huffman.encode(encodedMap, startString);
		String endString = Huffman.decode(root, binaryCode);
		System.out.println("Start String: " + startString);
		System.out.println("End String: " + endString);
		System.out.println("Are the equal? " + startString.equals(endString));
	}
	
}
	
