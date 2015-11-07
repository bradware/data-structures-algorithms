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
		node.setData("charmander");
		node.setLeft(temp);
		node.setRight(temp);
		
		AVLInterface<String> avl = new AVLTree<String>();
		temp = avl.getRoot();
		avl.setRoot(node);
		avl.add("poliwag");
		s = avl.get("vulpix");
		s = avl.remove("jigglypuff");
		boolean b = avl.isEmpty();
	}

}
