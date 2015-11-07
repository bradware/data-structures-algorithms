
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class CompileTest {
	@SuppressWarnings("unused")
	
	@Test
	public void test1() {
		SimpleBST ll = new SimpleBST();
		
		ll.add(3);
		ll.add(2);
		ll.add(1);
		ll.add(5);
		
		assertTrue(ll.get(2).equals(2));
		
	}
	

	//@Test
	public void test() {
		BSTNode<String> node = new BSTNode<String>("bulbasaur");
		BSTNode<String> temp = new BSTNode<String>("squirtle");
		String s = node.getData();
		temp = node.getLeft();
		temp = node.getRight();
		node.setData("charmander");
		node.setLeft(temp);
		node.setRight(temp);
		
		SimpleBSTInterface<String> bst = new SimpleBST<String>();
		temp = bst.getRoot();
		bst.setRoot(node);
		bst.add("pikachu");
		s = bst.get("voltorb");
		List<String> list = bst.preorder();
		list = bst.postorder();
		
		
	}
}