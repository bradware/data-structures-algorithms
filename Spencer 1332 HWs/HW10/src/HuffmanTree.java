import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;

public class HuffmanTree {

	private Node root;
	private Map<Character, String> eTable;
	private PriorityQueue<Node> q;

	/**
	 * 
	 * @param frequencies
	 */
	public HuffmanTree(Map<Character, Integer> frequencies) {
		Collection<Integer> collectionValues = frequencies.values();
		q = new PriorityQueue<Node>();

		for (Character c : frequencies.keySet()) {
			Node node = new Node(c, frequencies.get(c));
			q.add(node);
		}

		while (q.size() > 1) {
			// poll() retrieves/removes head of pq
			Node node1 = q.poll();
			Node node2 = q.poll();
			// combine first two nodes, puts at end:
			Node node3 = new Node(node1, node2);
			q.add(node3);
		}
		// set root to head of pq
		root = q.poll();
		eTable = generateEncodingTable();

	}
	/**
	 * 
	 * @param node
	 * @param str
	 * @param map
	 */
	public void preorder(Node node, String str, Map map) {
		// base case:
		if (node.isLeaf()) {
			char character = node.getData();
			map.put(character, str);
		}

		if (node.getLeft() != null) {
			preorder(node.getLeft(), str + 0, map);
		}
		if (node.getRight() != null) {
			preorder(node.getRight(), str + 1, map);
		}
	}

	/*
	 * You will need to write a method to traverse the tree to generate this
	 * encoding table. Think pre-order traversal, but you add to a map instead
	 * of a list
	 */
	public Map<Character, String> generateEncodingTable() {
		Map<Character, String> map = new HashMap<Character, String>();
		preorder(root, "", map);
		return map;
	}
	/**
	 * 
	 * @param input
	 * @return
	 */
	public String encode(String input) {
		String newString = "";
		for (int i = 0; i < input.length(); i++) {
			newString += eTable.get(input.charAt(i));
		}
		return newString;
	}
	/**
	 * 
	 * @param output
	 * @return
	 */
	public String decode(String output) {
		String newString = "";
		Node currNode = root;
		for (int i = 0; i < output.length(); i++) {
			if (output.charAt(i) == '0') {
				currNode = currNode.getLeft();
			} else if (output.charAt(i) == '1') {
				currNode = currNode.getRight();
			}
			if (currNode.isLeaf()) {
				newString += currNode.getData();
				currNode = root;
			}
		}
		return newString;
	}

	/*
	 * Do not modify the methods below this point, they are used for grading.
	 */

	public void setRoot(Node data) {
		this.root = data;
	}

	public Node getRoot() {
		return root;
	}
}

