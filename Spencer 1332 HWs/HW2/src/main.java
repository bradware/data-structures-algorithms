public class main{
public static void main(String[] args) {
SimpleBST<Integer> bst = new SimpleBST<Integer>();

/*
bst.add(2);
bst.add(8);
bst.add(9);
bst.add(3);
bst.add(6);
bst.add(1);
/* JD's Output
* [ 1 2 3 6 8 9 ]
[1, 6, 3, 9, 8, 2]
[2, 1, 8, 3, 6, 9]
*/

bst.add(2);
bst.add(1);
bst.add(8);
bst.add(3);
bst.add(6);
bst.add(9);
/* JD's output
* [ 1 2 3 6 8 9 ]
[1, 6, 3, 9, 8, 2]
[2, 1, 8, 3, 6, 9]
oh...it's the same for both
*/

System.out.println(bst);
System.out.println(bst.postorder());
System.out.println(bst.preorder());
}
}