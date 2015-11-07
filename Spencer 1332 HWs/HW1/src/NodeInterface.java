
public interface NodeInterface<T> {

	/* Simple getters and setters */
	public T getData();
	public NodeInterface<T> getNext();
	public NodeInterface<T> getPrev();
	public void setData(T data);
	public void setNext(NodeInterface<T> node);
	public void setPrev(NodeInterface<T> node);
	
}