import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class DisjointSets<T> {
	
	private Map<T, Node<T>> map;
	
	/**
	 * Takes in a set of generic type objects. 
	 * Here you need to wrap each object T in a Node and then add the pair of object T and its resulting 
	 * node to a HashMap.
	 * Conceptually you can think of this step as making each node to be its own disjoint set. 
	 * Then whenever you need you can use merge function to merge these little disjoint sets.
	 */
	public DisjointSets(Set<T> set) {
		map = new HashMap<T, Node<T>>();
		for(T data: set){
			Node<T> newNode = new Node<T>(data);
			map.put(data, newNode);
		}
	}
	
	/**
	 * In this method you need to do path compression for object o:
	 * 1) wrap the object o in a Node
	 * 2) find the root of the disjoint set that o is attached to call it root
	 * 3) then make the root be the parent of o
	 * 
	 * @param o 	an object of type T whose root is to be found
	 * @return 		the root of the vertex taken in
	 */
	
	public T findParent(T o) {//guaranteed this data will be from the set in our hashMap
		Node<T> root = map.get(o);
		while(root.getParent() != null){
			root = root.getParent();
		}
		if(map.get(o).getParent() != null){//checking to see if this was a root itself
			Node<T> startNode = map.get(o);
			startNode.setParent(root);
		}
		return root.getData();
	}
	
	/**
	 * points the root of the firstObject to the root of the secondObject.
	 * If they already have the same root don't do anything.
	 *  
	 * @param firstObject an object of type T who is to be merged with parameter secondObject
	 * @param firstObject an object of type T who is to be merged with parameter firstObject
	 */
	public void merge(T firstObject, T secondObject) {
		Node<T> rootFirstObject = map.get(this.findParent(firstObject));
		Node<T> rootSecondObject = map.get(this.findParent(secondObject));
		if(!rootFirstObject.equals(rootSecondObject)){
			rootFirstObject.setParent(rootSecondObject);
			map.get(firstObject).setParent(rootSecondObject);
		}
		
	}
	
	
	

	/**
	 * Basic node class for use with DisjointSet
	 */
	private class Node<T> {

		private T data;
		private Node<T> parent;

		/**
		 * set the data to be the given data and set parent to null
		 * @param data
		 */
		public Node(T data) {
			this.data = data;
			parent = null;
		}

		/**
		 * set the data and parent to the given values
		 * @param data
		 * @param parent
		 */
		public Node(T data, Node<T> parent) {
			this.data = data;
			this.parent = parent;
		}

		/*implement all the setters and getters below*/
		public void setData(T data) {
			this.data = data;
		}

		public void setParent(Node<T> parent) {
			this.parent = parent;
		}

		public T getData() {
			return data;
		}

		public Node<T> getParent() {
			return parent;
		}
	}

}