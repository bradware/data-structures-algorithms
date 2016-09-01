import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * In this class, you will be implementing three different types of graph algorithms.
 * Remember, it's the journey that counts - not the destination! Return a list of nodes
 * that are visited (in order) to reach the goal node. 
 * 
 * Note: You must add the vertices from least ID to greatest ID, otherwise you will lose
 * points on our JUnit Tests.
 * 
 * Example: let's say you wanted to add the neighbours of 2 into your fringe
 * 
 *          0 1 2 3 4
 *        0 1 0 0 1 1
 *        1 1 1 0 1 1 
 *        2 1 0 1 1 1 
 *        3 1 0 0 1 0
 *        4 1 0 1 1 1
 *        
 * You will simply add 0, 3, and 4 to the fringe in that order!
 * 
 * @author Brad Ware
 *
 */
public class GraphSearches {

	private static final int INF = Integer.MIN_VALUE;
	
	/**
	 * Perform Breadth First Search.
	 * 
	 * 
	 * All parameters will be valid, so you will never worry about either of the two vertices
	 * being out of the range of the matrix.
	 * 
	 * In the adjacency matrix, a 1 indicates that there is a connection, and a 0 indicates
	 * that there is not a connection.
	 * 
	 * @param graph an adjacency matrix that represents the graph
	 * @param v the number of vertices in the graph
	 * @param start the starting vertex
	 * @param goal the ending vertex
	 * @return
	 */
	public static List<Integer> breadthFirstSearch(int[][] graph, int v, int start, int goal){
		//need to figure out if we return path or visited list?!!!!!!
		
		Queue<VertexWrapper> queue = new LinkedList<VertexWrapper>();
		List<Integer> initialPathList = new ArrayList<Integer>();
		Set<Integer> visitedSet = new HashSet<Integer>();
		VertexWrapper startNode = new VertexWrapper(initialPathList,start);
		queue.add(startNode);
		visitedSet.add(startNode.getVertexID());
		while(queue.size() != 0){
			VertexWrapper currentNode = queue.poll();
			int currentVertexID = currentNode.getVertexID();
			visitedSet.add(currentVertexID);
			if(currentVertexID == goal){
				currentNode.getVisitedList().add(currentVertexID); 
				return currentNode.getVisitedList();
			}else{
				List<Integer> tempList = new ArrayList<Integer>();
				tempList.addAll(currentNode.getVisitedList());
				tempList.add(currentVertexID);
				for(int i = 0; i < v; i++){
					if(graph[currentVertexID][i] == 1 && i != currentVertexID && (!visitedSet.contains(i))){
						queue.add(new VertexWrapper(tempList, i));
						
					}
				}
			}
			
		}
		return new ArrayList<Integer>(); //only if the goal isn't contained in the graph 
	}
	
	/**
	 * Perform Depth First Search.
	 * 
	 * All parameters will be valid, so you will never worry about either of the two vertices
	 * being out of range of the matrix.
	 * 
	 * In the adjacency matrix, a 1 indicates that there is a connection and a 0 indicates
	 * that there is not a connection.
	 * 
	 * @param graph an adjacency matrix that represents the graph
	 * @param v the number of vertices in the graph
	 * @param start the starting vertex
	 * @param goal the ending vertex
	 * @return
	 */
	public static List<Integer> depthFirstSearch(int[][] graph, int v, int start, int goal){ 
	//need to figure out if we return path or visited list?!!!!!!
	Stack<VertexWrapper> stack = new Stack<VertexWrapper>();
	List<Integer> initialPathList = new ArrayList<Integer>();
	Set<Integer> visitedSet = new HashSet<Integer>();
	VertexWrapper startNode = new VertexWrapper(initialPathList,start);
	stack.add(startNode);
	visitedSet.add(startNode.getVertexID());
	while(stack.size() != 0){
		VertexWrapper currentNode = stack.pop();
		int currentVertexID = currentNode.getVertexID();
		visitedSet.add(currentVertexID);
		if(currentVertexID == goal){
			currentNode.getVisitedList().add(currentVertexID); 
			return currentNode.getVisitedList();
		}else{
			List<Integer> tempList = new ArrayList<Integer>();
			tempList.addAll(currentNode.getVisitedList());
			tempList.add(currentVertexID);
			for(int i = 0; i < v; i++){
				if(graph[currentVertexID][i] == 1 && i != currentVertexID && (!visitedSet.contains(i))){
					stack.add(new VertexWrapper(tempList, i));
					
				}
			}
		}
		
	}
	return new ArrayList<Integer>(); //only if the goal isn't contained in the graph 
}

	
	/**
	 * Perform Dijkstra's Algorithm
	 * 
	 * All parameters will be valid, so you will never have to worry about either of the two
	 * vertices being out of range of the matrix.
	 * 
	 * In the adjacency matrix, a positive number indicates a connection with that amount of weight,
	 * and a value of INF indicates that there is no connection. I have provided you with a value for
	 * INF at the top of the file as a constant.
	 * 
	 * @param weightedGraph an adjacency matrix with weights for various graphs.
	 * @param v
	 * @param start
	 * @param goal
	 * @return
	 */
	public static List<Integer> dijkstrasAlgorithm(int[][] weightedGraph, int v, int start, int goal) {
		PriorityQueue<VertexWrapper> priorityQ = new PriorityQueue<VertexWrapper>();
		List<Integer> initialPathList = new ArrayList<Integer>();
		Set<Integer> visitedSet = new HashSet<Integer>();
		VertexWrapper startNode = new VertexWrapper(initialPathList,0,start);
		priorityQ.add(startNode);
		visitedSet.add(startNode.getVertexID());
		while(priorityQ.size() != 0){
			VertexWrapper currentNode = priorityQ.poll();
			int currentVertexID = currentNode.getVertexID();
			visitedSet.add(currentVertexID);
			if(currentVertexID == goal){
				currentNode.getVisitedList().add(currentVertexID);
				return currentNode.getVisitedList();
			}else{
			List<Integer> tempList = new ArrayList<Integer>();
			tempList.addAll(currentNode.getVisitedList());
			tempList.add(currentVertexID);
			for(int i = 0; i < v; i++){
				if(weightedGraph[currentVertexID][i] == INF || (i == currentVertexID) || visitedSet.contains(i)){
					continue;
				}else{
					priorityQ.add(new VertexWrapper(tempList,weightedGraph[currentVertexID][i] + currentNode.getPathCost(),i));

				}
			}
		}
		
	}
	return new ArrayList<Integer>();
	}
	
	/**
	 * Wrapper class for vertices. Feel free to modify this. We won't be testing any of it.
	 * In fact, if you don't want to use this, feel free to make your own wrapper (or not).
	 */
	private static class VertexWrapper implements Comparable<VertexWrapper> {

		private List<Integer> visitedList;
		private int pathCost;
		private int vertexID;
		
		public VertexWrapper() {
			visitedList = null;
			pathCost = 0;
			vertexID = Integer.MIN_VALUE;
		}
		
		public VertexWrapper(List<Integer> list, int vertexID) {
			this();
		     this.visitedList = new ArrayList<Integer>();
		            
		     for(Integer i : list) {
		          visitedList.add(i);
		     }
		            
		     this.vertexID = vertexID;
		}
		
		public VertexWrapper(List<Integer> list, int pathCost, int vertexID) {
			visitedList = new ArrayList<Integer>();
			
			for(Integer i : list) {
				visitedList.add(i);
			}
			
			this.pathCost = pathCost;
			this.vertexID = vertexID;
		}
		
		
		public int getPathCost() {
			return pathCost;
		}
		
		public List<Integer> getVisitedList() {
			return visitedList;
		}
		
		public int getVertexID() {
			return vertexID;
		}
		
		public void setPathCost(int pathCost) {
			this.pathCost = pathCost;
		}
		
		public void setVisitedList(List<Integer> visitedList) {
		    this.visitedList = new ArrayList<Integer>();

			for(Integer i : visitedList) {
				visitedList.add(i.intValue());
			}
                 
		}
		
		public void setVertexID(int vertexID) {
			this.vertexID = vertexID;
		}
		
		@Override
		public int hashCode() {
			return vertexID;
		}
		
		@Override
		public int compareTo(VertexWrapper arg0) {
			return this.pathCost - arg0.pathCost;
		}
		
		@Override
		public boolean equals(Object o) {
			if(!(o instanceof VertexWrapper)) {
				return false;
			}
			else {
				return ((VertexWrapper)o).vertexID == this.vertexID;
			}
		}
		
	}
}