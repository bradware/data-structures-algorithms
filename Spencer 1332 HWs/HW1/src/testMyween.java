
public class testMyween {
	
		public static <T> void main(String[] args){
			SortedLL ll = new SortedLL();
			InsertionSort m = new InsertionSort();
			
			ll.add(null);
			ll.add(2);
			ll.add(1);
			ll.add(5);
			
			if(ll.size() == 0)
				System.out.println("One");
			else if(ll.size() == 2)
				System.out.println("TWo");
			else
				System.out.println("Three");
			
			System.out.println();
			for(int i = 0; i < ll.size(); i++)
			System.out.print("[" + ll.getAt(i) + "]");
			
			System.out.println();
			System.out.println("Size: " + ll.size());
			System.out.println("Value:" + ll.getAt(0));
			System.out.println(ll.remove(5));
			System.out.println(ll.get(2));
			
			ll.removeMin();
			
			
			for(int i = 0; i < ll.size(); i++)
				System.out.print("[" + ll.getAt(i) + "]");
			System.out.println();
			System.out.println("Size: " + ll.size());
			System.out.println("Value:" + ll.getAt(0));
			System.out.println(ll.contains(4));
			ll.removeMax();
			System.out.println(ll.isEmpty());
			
			Comparable[] arr = {2, 4, 7, 5, 1};
			SortedLL x = new SortedLL();
			m.sort(arr, x);
			
		}


}
