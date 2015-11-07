
public class testBST {
	public static <T> void main(String[] args){
		SimpleBST ll = new SimpleBST();
	
		ll.add(4);
		ll.add(6);
		ll.add(1);
		ll.add(0);
		ll.add(5);
	
		System.out.println(ll.getRoot().getData());
		for(int i = 0; i < ll.size(); i++)
			System.out.print(ll.size());
		
	System.out.println();
	System.out.println(ll.get(1));
	
	ll.preorder();
	System.out.println(ll.preorder());
	System.out.println(ll.preorder());
	ll.postorder();
	System.out.println(ll.postorder());
	System.out.println(ll.postorder());
		
		
		
			
	}
}
