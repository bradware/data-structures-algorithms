public class Node<T> {

	private T data;
	private Node<T> left, right, parent;
	
	public Node(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLeft() {
		return left;
	}

	public Node<T> getRight() {
		return right;
	}
	
	public Node<T> getParent() {
		return parent;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}
	
	public void setParent(Node<T> parent) {
		this.parent = parent;
	}
}
