import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CompileTest {

	@SuppressWarnings("unused")
	@Test
	public void test() {
		Node<String> node = new Node<String>("bulbasaur");
		Node<String> temp = new Node<String>("squirtle");
		String s = node.getData();
		temp = node.getLeft();
		temp = node.getRight();
		temp = node.getParent();
		node.setData("charmander");
		node.setLeft(temp);
		node.setRight(temp);
		node.setParent(temp);
		
		BSTInterface<String> bst = new BST<String>();
		temp = bst.getRoot();
		bst.setRoot(node);
		bst.add("pikachu");
		s = bst.get("voltorb");
		s = bst.getMin();
		s = bst.getMax();
		s = bst.remove("dugtrio");
		s = bst.removeMin();
		s = bst.removeMax();
		boolean b = bst.isEmpty();
		List<String> list = bst.inOrder();
		list = bst.levelOrder();
		list = bst.getLevel(0);
		
		list = new ArrayList<String>();
		list.add("vulpix");
		list.add("ninetales");
		list.add("blastoise");
		
		bst.generateTree(list);
	}

}