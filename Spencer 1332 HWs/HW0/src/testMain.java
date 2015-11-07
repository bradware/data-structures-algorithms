
public class testMain {
	public static void main(String[] args){
		IntLL ll = new IntLL();
		
		ll.addInOrder(2);
		ll.addInOrder(1);
		ll.addInOrder(5);
		
		
		System.out.println();
		for(int i = 0; i < ll.size(); i++)
		System.out.print("[" + ll.getAt(i) + "]");
		
		System.out.println();
		System.out.println("Size: " + ll.size());
		System.out.println("Head value: " + ll.getHead());
		System.out.println("Value:" + ll.getAt(0));
		
		
	}
}
