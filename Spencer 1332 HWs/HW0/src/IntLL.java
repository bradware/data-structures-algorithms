/**
 * This class represents a Integer Linked List object that is singly linked 
 * and stores integers in sorted order
 * @author Spencer Powell
 * @version 1.0
 */
public class IntLL implements IntLLInterface {

	private int size;
	private Node head;
	
	/**
	 * Constructor for the linked list of integers
	 * Sets the initial size to 0 and the head of the list to null
	 */
	public IntLL(){
		size = 0;
		head = null;
	}
	
	/**
	 * Returns the integer value of the head of the list
	 */
	public int getHead(){
		if(head != null)
			return head.getValue();
		else
			return 0;
	}
	
	/**
	 * Returns the integer value of the node
	 * at a certain position 
	 * 
	 * @param index
	 */
	public int getAt(int index)
	{
		Node x = head;
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		for(int i = 0; i < index; i++)
			x = x.getNext();
		
		return x.getValue();
	}
			
	/**
	 * Returns the size of the linked list
	 */
	public int size() {
		return size; 
	}

	/**
	 * Takes in an integer and adds that
	 * integer to the list in its proper order
	 * 
	 * @param value
	 */
	public void addInOrder(int value) {
		Node x = new Node(value);
	
		if(head == null){
			head = x;
			size++;
			return;
		}
		if(value < head.getValue()){
			x.setNext(head);
			head = x;
			size++;
			return;
		}
		
		Node cNode = head;
		Node pNode = null;
		while(pNode == null){
			
			if(cNode.getNext() == null){
				cNode.setNext(x);
				size++;
				return;
			}
			
			if(cNode.getNext().getValue() > value && cNode.getValue() < value){
				x.setNext(cNode.getNext()); 
				cNode.setNext(x);
				size++;
				return;
			}
			
			cNode = cNode.getNext();
			
			
			
				
		}
			
			
			
			
	}
}
