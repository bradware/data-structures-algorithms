
public class Node implements Comparable<Node> {

	private static int timer = 0;
	private int frequencey, id;
	private Node left, right;
	private Character data;
	
	public Node(char data, int frequency) {
		this.id = timer++;
		this.left = null;
		this.right = null;
		this.frequencey = frequency;
		this.data = data;
	}
	
	public Node(Node left, Node right) {
		this.id = timer++;
		this.left = left;
		this.right = right;
		this.frequencey = left.frequencey + right.frequencey;
		this.data = null;
	}

	@Override
	public int compareTo(Node that) {
		return (frequencey == that.frequencey ? id - that.id : this.frequencey - that.frequencey);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Node) {
			Node n = (Node) o;
			return eq(data, n.data) && eq(frequencey, n.frequencey);
		} else {
			return false;
		}
	}
	
	private static <T> boolean eq(T a, T b) {
		if (a == null && b == null) {
			return true;
		} else if (a == null || b == null) {
			return false;
		} else {
			return a.equals(b);
		}
	}

	public int getFrequencey() {
		return frequencey;
	}

	public void setFrequencey(int frequencey) {
		this.frequencey = frequencey;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Character getData() {
		return data;
	}

	public void setData(Character data) {
		this.data = data;
	}
	
	public boolean isLeaf() {
		return left == null && right == null;
	}
}