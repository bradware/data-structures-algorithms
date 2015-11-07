
public class tester {

	public static <T> void main(String[] args){
		AVLTree ll = new AVLTree();
	
		ll.add(13);
		ll.add(11);
		ll.add(14);
		ll.add(10);
		ll.add(16);
		ll.add(12);
		ll.add(9);
		
		
		System.out.println(ll.remove(16));
		
		
	
		
		
	System.out.println(ll.get(8));
	
	

		System.out.println("Tree: " + ll.levelOrder());
		System.out.println("BFs: " + ll.levelOrderBf());
		System.out.println("Heights: " + ll.levelOrderHeight());
			
			
	}
}

