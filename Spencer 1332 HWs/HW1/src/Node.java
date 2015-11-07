
public class Node<T> implements NodeInterface<T> {
	
	private T data;
	private NodeInterface<T> next;
	private NodeInterface<T> prev;
	
	public Node(T data)
	{
		this.data = data;
		next = null;
		prev = null;
	}

	/**
	 * @return the data of a Node
	 */
	public T getData() {
		return data;
	}

	/**
	 * @return the next NodeInterface
	 */
	public NodeInterface<T> getNext() {
		return next;
	}

	/**
	 * @return the previous NodeInterface
	 */
	public NodeInterface<T> getPrev() {
		return prev;
	}

	/**
	 * Sets the data of a node
	 * 
	 * @param data
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Sets the next of this Node
	 * 
	 * @param node
	 */
	public void setNext(NodeInterface<T> node) {
		next = node;
	}

	/**
	 * Sets the previous of this Node
	 * 
	 * @param node
	 */
	public void setPrev(NodeInterface<T> node) {
		prev = node;
	}
}
