import java.util.ArrayList;
import java.util.Collection;


public class tester {
	public static <T> void main(String[] args){
		MinHeap ll = new MinHeap();
		ArrayList x = new ArrayList();
		
		x.add(88);
		x.add(66);
		x.add(99);
		
		ll.add(20);
		ll.add(10);
		ll.add(15);
		ll.add(8);
		ll.add(7);
		ll.add(13);
		ll.add(14);
		ll.add(2);
		
		ll.addAll(x);
		System.out.println(ll.size());
		System.out.println(ll.findLast());
		ll.remove();
		
		for(int i = 0; i < ll.array.length; i++)
			System.out.print(" " + ll.array[i]);	
	}
}