import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class tester {

	public static void main(String[] args) {
		AdjacencyList al = new AdjacencyList("15 1 2 1 1 5 2 5 6 1 2 3 2 6 4 14 3 7 3 3 9 5 4 8 4 4 9 2 7 8 3 7 10 7 7 9 7 9 8 2 8 10 5 10 11 11");

		// TreeSet<Pair> ts = (TreeSet<Pair>) al.getAdjacencies(new Vertex(3));
		// Iterator i = ts.iterator();

		/*while(i.hasNext()) {
			System.out.println(i.next());
		}*/

		for (int i = 1; i <= 11; i++) {
			TreeSet<Pair> ts = (TreeSet<Pair>) al.getAdjacencies(new Vertex(i));
			System.out.println("Pairs " + i + ": " + ts);
		}
		
		int start = 7;
		
		System.out.println("=====================================");
		System.out.println("Stack: ");
		System.out.println("=====================================");

		for (int i = 1; i <= 11; i++) {
			Path p = GraphSearch.search(new Vertex(start), new Vertex(i), al, new MyStack());
			System.out.println("Path to " + i + ": " + p.getPath());
		}
		
		HashMap<Vertex, Path> map1 = (HashMap<Vertex, Path>) GraphSearch.explore(new Vertex(start), al, new MyStack());
		Iterator<Path> i1 = map1.values().iterator();
		while(i1.hasNext()) {
			System.out.println(i1.next().getPath());
		}
		
		System.out.println("=====================================");
		System.out.println("Queue: ");
		System.out.println("=====================================");
		
		for (int i = 1; i <= 11; i++) {
			Path p = GraphSearch.search(new Vertex(start), new Vertex(i), al, new MyQueue());
			System.out.println("Path to " + i + ": " + p.getPath());
		}
		
		HashMap<Vertex, Path> map2 = (HashMap<Vertex, Path>) GraphSearch.explore(new Vertex(start), al, new MyQueue());
		Iterator<Path> i2 = map2.values().iterator();
		while(i2.hasNext()) {
			System.out.println(i2.next().getPath());
		}
		
		System.out.println("=====================================");
		System.out.println("Priority Queue: ");
		System.out.println("=====================================");
		
		for (int i = 1; i <= 11; i++) {
			Path p = GraphSearch.search(new Vertex(start), new Vertex(i), al, new MyPriorityQueue());
			System.out.println("Path to " + i + ": " + p.getPath());
		}
		
		HashMap<Vertex, Path> map3 = (HashMap<Vertex, Path>) GraphSearch.explore(new Vertex(start), al, new MyPriorityQueue());
		Iterator<Path> i3 = map3.values().iterator();
		while(i3.hasNext()) {
			System.out.println(i3.next().getPath());
		}
		
		/*
		System.out.println("=====================================");
		System.out.println("Prim: ");
		System.out.println("=====================================");
		
		for (int i = 1; i <= 11; i++) {
			Path p = GraphSearch.search(new Vertex(start), new Vertex(i), al, new MyPrimStructure());
			System.out.println("Path to " + i + ": " + p.getPath());
		}
		
		HashMap<Vertex, Path> map4 = (HashMap<Vertex, Path>) GraphSearch.explore(new Vertex(start), al, new MyPrimStructure());
		Iterator<Path> i4 = map4.values().iterator();
		while(i4.hasNext()) {
			System.out.println(i4.next().getPath());
		}
		*/
	}
}