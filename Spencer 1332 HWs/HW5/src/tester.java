
public class tester {

	public static <K, V> void main(String[] args){
		LinearProbingHashTable ll = new LinearProbingHashTable();
		
		System.out.println(ll.put(13, "Spence-daddy"));
		System.out.println(ll.put(11, "yames"));
		System.out.println(ll.put(14, "Amy"));
		System.out.println(ll.size());
		System.out.println(ll.put(10, "Loewi"));
		System.out.println(ll.put(16, "Lucy"));
		System.out.println(ll.put(22, "mom"));
		System.out.println(ll.put(9, "Dad"));
		
		System.out.println(ll.size());
		//System.out.println(ll.remove(14));
		//System.out.println(ll.remove(10));
		System.out.println(ll.size());
		//ll.clear();
		System.out.println(ll.size());
	
		
		
		System.out.println(ll.get(11));
	
	

		System.out.println("Entry Set: " + ll.entrySet());
		System.out.println("Key Set: " + ll.keySet());
		System.out.println("Values: " + ll.values());
			
			
	}
}