package User;

import java.awt.Graphics;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.awt.Dimension;

import User.BTNode;
import User.Blob;

/*
 * A Binary Tree is either null or a BTNode containing a data value 
 * and two Binary Trees usually named 'left' and 'right'
 * 
 * A Binary Search Tree (BST) is a Binary Tree in which at any node N, 
 * all the data in its left sub-tree are less that its data value, and
 * all the data in its right sub-tree are greater that its data value
 * 
 */
public class BTree {
	/**
	 * tree root
	 */
	public BTNode root = null;
	public static int balance = 0;
	private static final String spaces = "                                       ";
	public static BTNode changed = null;

	public enum State {
		NONE, CHECK_QUEUE, SETUP, MOVING, SLIDING, DO_ROTATION, CHECK_INSERT, DO_LEFT, DO_RIGHT, DO_SPLAY, ZIG_ZIG, ZIG_ZAG, ZIG
	};

	public enum Splay {
		NONE, ZIG_ZIG_LEFT, ZIG_ZIG_RIGHT, ZIG_ZAG_LEFT, ZIG_ZAG_RIGHT, ZIG_LEFT, ZIG_RIGHT
	};

	public static State display_mode = State.NONE;
	public static double index = 0;
	public static final double TICKS = 100;
	public static boolean drawn = false;
	private BTNode work_on = null;
	private BTNode P = null;
	private BTNode Q = null;
	private BTNode R = null;
	private boolean inserting;
	private State next_task;
	private LinkedList<Integer> Queue = null;
	/**
	 * diagnostic output file
	 */
//	public static PrintStream debug = null;

	public BTree() {
		buildTree(20);
	}

	public BTree(int N) {
		buildTree(N);
	}

	public void buildTree(int N) {
		root = null;
		Queue = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			insert((int) (Math.random() * 100));
		}
		display_mode = State.CHECK_QUEUE;
	}

	/**
	 * wrapper for inserting
	 * 
	 * @param - where to insert
	 * @param dat
	 *            - the value to insert
	 * @return - the modified sub-tree
	 */
	public void insert(int dat) {
		inserting = true;
		Queue.add(dat);
	}

	private static State last = null;

	public void update() {
		if (display_mode == last) {
//			Model.debug.print(".");
		} else {
			Model.debug.println("update at state " + display_mode);
			last = display_mode;
		}
		switch (display_mode) {
		case CHECK_QUEUE:
			if (!Queue.isEmpty()) {
				int dat = Queue.removeFirst().intValue();
				changed = null;
				work_on = reallyInsert(root, dat, null);
				if (work_on != root) {
					root = work_on;
					root.parent = null;
				}
				if (balance > 0 && changed != null) {
					switch (balance) {
					case 1: // AVL
						depth(work_on);
						P = changed;
						Model.debug.println("CHECK_QUEUE 1. P changed to " + P);
						while (P != null && P.isBalanced()) {
							P = P.parent;
							Model.debug.println("CHECK_QUEUE 2. P changed to " + P);
						}
						if (P != null) {
							display_mode = State.DO_ROTATION;
							BTNode.diagnose = true;
							Model.debug.println("start diagnosis");
						}
						break;
					case 2: // Splay
						Model.debug.println(BFTrav("Start Splay"));
						display_mode = State.DO_SPLAY;
						break;
					}
				}
			}
			break;
		case DO_SPLAY:
			BTNode X = changed;
			BTNode Y = null;
			BTNode Z = null;
			Splay mode = Splay.NONE;
			if (X != root) {
				// need a splay
				Y = X.parent;
				Z = Y.parent;
				if (Y.right == X) {
					// could be ZIG_ZIG left, ZIG_ZAG right or ZIG_LEFT
					if (Z == null) {
						mode = Splay.ZIG_LEFT;
						Z = X.right;
					} else if (Z.right == Y) {
						mode = Splay.ZIG_ZIG_LEFT;
					} else {
						mode = Splay.ZIG_ZAG_RIGHT;
					}
				} else {
					if (Z == null) {
						mode = Splay.ZIG_RIGHT;
						Z = X.left;
					} else if (Z.left == Y) {
						mode = Splay.ZIG_ZIG_RIGHT;
					} else {
						mode = Splay.ZIG_ZAG_LEFT;
					}
				}
				splay(X, Y, Z, mode);
			} else {
				display_mode = State.CHECK_QUEUE;
			}
			break;
		case DO_ROTATION:
			// debug.println("balance the tree");
			/*
			 * start at the node we just added go up from there to a unbalanced
			 * node (bf ! -1, 0 1) if not there, quit
			 */
			// save that node as P
			if (P.bf > 1) {
				Q = P.right;
				Model.debug.println("DO_ROTATION 1. Q changed to " + Q);
				if (Q.bf > 0) {
					work_on = wrap_rotate(P, Q, true); // true is left
					next_task = State.CHECK_INSERT;
				} else {
					// needs a double rotation
					R = Q.left;
					work_on = wrap_rotate(Q, R, false); // true is left
					next_task = State.DO_LEFT;
				}
			} else {
				// do the left heavy side
				Q = P.left;
				Model.debug.println("DO_ROTATION 2. Q changed to " + Q);
				if (Q.bf < 0) {
					work_on = wrap_rotate(P, Q, false);
					next_task = State.CHECK_INSERT;
				} else {
					// needs a double rotation
					R = Q.right;
					work_on = wrap_rotate(Q, R, true); // true is left
					next_task = State.DO_RIGHT;
				}
			}
			if (display_mode == State.DO_ROTATION) {
				display_mode = State.CHECK_QUEUE;
			}
			if (display_mode != last) {
				Model.debug.println("     --> " + display_mode);
			}
			break;
		case DO_LEFT:
			work_on = wrap_rotate(P, R, true);
			next_task = State.CHECK_INSERT;
			break;
		case DO_RIGHT:
			work_on = wrap_rotate(P, R, false);
			next_task = State.CHECK_INSERT;
			break;
		case MOVING:
		case SLIDING:
			index++;
			if (index >= TICKS) {
				display_mode = next_task;
				if(display_mode == State.DO_SPLAY) {
					Model.debug.println(BFTrav("End Splay"));
				}
				if(display_mode == null) {
					display_mode = State.NONE;
				}
				index = 0;
				resetMoving();
			}
			break;
		case CHECK_INSERT:
			if (inserting) {
				display_mode = State.CHECK_QUEUE;
			} else {
				depth(work_on);
				P = changed;
				Model.debug.println("CHECK_INSERT 1. P changed to " + P);
				while (P != null && P.isBalanced()) {
					P = P.parent;
					Model.debug.println("CHECK_INSERT 2. P changed to " + P);
				}
				if (P != null) {
					display_mode = State.DO_ROTATION;
				}
			}
			break;
		default:
			break;
		}
	}

	private void splay(BTNode X, BTNode Y, BTNode Z, Splay mode) {
		X.saveLocation();
		Y.saveLocation();
		if (Z != null) {
			Z.saveLocation();
		}
		Model.debug.println("splay X = " + X 
				        + "\n      Y = " + Y 
				        + "\n      Z = " + Z 
				        + "\n   mode = " + mode);
		display_mode = State.SETUP;
		BTNode parent = null;
		BTNode child = Z;
		switch (mode) {
		case ZIG_ZIG_LEFT:
			Z.right = Y.left;
			if(Z.right != null) Z.right.parent = Z;
			Y.left = Z;
			Y.right = X.left;
			if(Y.right != null) Y.right.parent = Y;
			X.left = Y;
			parent = Z.parent;
			Z.parent = Y;
			Y.parent = X;
			break;
		case ZIG_ZIG_RIGHT:
			Z.left = Y.right;
			if(Z.left != null) Z.left.parent = Z;
			Y.right = Z;
			Y.left = X.right;
			if(Y.left != null) Y.left.parent = Y;
			X.right = Y;
			parent = Z.parent;
			Z.parent = Y;
			Y.parent = X;
			break;
		case ZIG_ZAG_LEFT:
			Z.right = X.left;
			if(Z.right != null) Z.right.parent = Z;
			X.left = Z;
			Y.left = X.right;
			if(Y.left != null) Y.left.parent = Y;
			X.right = Y;
			parent = Z.parent;
			Z.parent = X;
			Y.parent = X;
			break;
		case ZIG_ZAG_RIGHT:
			Z.left = X.right;
			if(Z.left != null) Z.left.parent = Z;
			X.right = Z;
			Y.right = X.left;
			if(Y.right != null) Y.right.parent = Y;
			X.left = Y;
			parent = Z.parent;
			Z.parent = X;
			Y.parent = X;
			break;
		case ZIG_LEFT:
			Y.right = X.left;
			if(Y.right != null) Y.right.parent = Y;
			X.left = Y;
			parent = Y.parent;
			child = Y;
			Y.parent = X;
			break;
		case ZIG_RIGHT:
			Y.left = X.right;
			if(Y.left != null) Y.left.parent = Y;
			X.right = Y;
			parent = Y.parent;
			child = Y;
			Y.parent = X;
			break;
		default:
			break;
		}
		// set parent link
		X.parent = parent;
		if (parent == null) {
			root = X;
		} else if (parent.right == child) {
			parent.right = X;
		} else {
			parent.left = X;
		}
		next_task = State.DO_SPLAY;
	}

	public void resetMoving() {
		resetMoving(root);
	}

	private void resetMoving(BTNode here) {
		if (here != null) {
			here.moving = false;
			resetMoving(here.left);
			resetMoving(here.right);
		}
	}

	private BTNode wrap_rotate(BTNode P, BTNode Q, boolean doLeft) {
		BTNode res = rotate(P, Q, doLeft);
		if (res != root) {
			root = res;
			root.parent = null;
		}
		return res;
	}

	private BTNode rotate(BTNode P, BTNode Q, boolean doLeft) {
		BTNode res = root;
		BTNode saved = null;
		State was = display_mode;
		Model.debug.println("rotate " + P);
		display_mode = State.SETUP;
		if ((was == State.DO_ROTATION) || (was == State.DO_LEFT)
				|| (was == State.DO_RIGHT)) {
			P.saveLocation();
			Q.saveLocation();
		}
		Q.parent = P.parent;
		if (P.parent != null) {
			if (P.parent.left == P) {
				P.parent.left = Q;
			} else {
				P.parent.right = Q;
			}
		} else {
			res = Q;
		}
		P.parent = Q;
		if (doLeft) {
			// save node on the heavy side Q
			saved = Q.left;
			// Put Q where P was
			// Put P in Q's left leg
			Q.left = P;
			// Put saved odd leg as P's right
			P.right = saved;
		} else {
			// save node on the heavy side Q
			saved = Q.right;
			// Put Q where P was
			// Put P in Q's left leg
			Q.right = P;
			// Put saved odd leg as P's right
			P.left = saved;
		}
		if (saved != null) {
			saved.parent = P;
		}
		return res;
	}

	/**
	 * recursive insert function
	 * 
	 * @param here
	 *            - where to insert
	 * @param dat
	 *            - the value to insert
	 * @param par
	 *            - the parent node to connect
	 * @return - the modified sub-tree
	 */
	public BTNode reallyInsert(BTNode here, int dat, BTNode par) {
		BTNode res = here;
		if (here == null) {
			res = new BTNode(dat, par);
			changed = res;
			// debug.println("inserted " + dat);
		} else if (dat < here.data) {
			here.left = reallyInsert(here.left, dat, here);
		} else if (dat > here.data) {
			here.right = reallyInsert(here.right, dat, here);
		}
		return res;
	}

	/**
	 * count the nodes in the tree
	 * 
	 * @return the sub-tree count
	 */
	public int count() {
		return count(root);
	}

	/**
	 * count the nodes in a sub-tree
	 * 
	 * @param here
	 *            - the sub-tree
	 * @return the sub-tree count
	 */
	public int count(BTNode here) {
		int res = 0;
		if (here != null) {
			int nl = count(here.left);
			int nr = count(here.right);
			res = nl + nr + 1;
		}
		return res;
	}

	/**
	 * depth of a tree
	 * 
	 * @return its depth
	 */
	public int depth() {
		return depth(root);
	}

	/**
	 * depth of a sub-tree
	 * 
	 * @param here
	 *            - the sub-tree
	 * @return its depth
	 */
	public int depth(BTNode here) {
		int res = 0;
		if (here != null) {
			int nl = depth(here.left);
			int nr = depth(here.right);
			res = ((nl > nr) ? nl : nr) + 1;
			here.bf = nr - nl;
		}
		return res;
	}

	/**
	 * in-order tree traversal returning a string
	 * 
	 * @param here
	 *            -the sub-tree
	 * @return the traversal
	 */
	public String inOrder() {
		return inOrder(root);
	}

	/**
	 * in-order sub-tree traversal returning a string
	 * 
	 * @param here
	 *            -the sub-tree
	 * @return the traversal
	 */
	public String inOrder(BTNode here) {
		String res = "";
		if (here != null) {
			String lstr = inOrder(here.left);
			String rstr = inOrder(here.right);
			res = lstr + here + rstr;
		}
		return res;
	}

	/**
	 * pre-order traversal returning a string
	 * 
	 * @return the traversal
	 */
	public String preOrder() {
		return preOrder(root);
	}

	/**
	 * pre-order sub-tree traversal returning a string
	 * 
	 * @param here
	 *            - the sub-tree
	 * @return the traversal
	 */
	public String preOrder(BTNode here) {
		String res = "";
		if (here != null) {
			String lstr = preOrder(here.left);
			String rstr = preOrder(here.right);
			res = here + lstr + rstr;
		}
		return res;
	}

	public BTNode findClosest(int x, int y) {
		return root.findClosest(x, y);
	}

	public BTNode find(int val) {
		return find(root, val);
	}

	public BTNode find(BTNode here, int val) {
		BTNode res = here;
		if (here != null) {
			if (here.data < val) {
				res = find(here.right, val);
			} else if (here.data > val) {
				res = find(here.left, val);
			}
		}
		return res;
	}

	public String BFTrav(String title) {
		String res = "\n" + title + "\n" + spaces;
		LinkedList<Blob> Q = new LinkedList<Blob>();
		enq(Q, root, 0, 1);
		int level = 0;
		int spaceCount = spaces.length();
		while (!Q.isEmpty()) {
			Blob b = deq(Q);
			if (b.level > level) {
				level = b.level;
				spaceCount = spaceCount * 2 / 3 - 2;
				if (spaceCount < 1) {
					spaceCount = 1;
				}
				res += "\n" + spaces.substring(0, spaceCount);
			}
			if (b.node == null) {
				res += "--" + spaces.substring(0, spaceCount);
			} else {
				res += b.node.data + spaces.substring(0, spaceCount);
				enq(Q, b.node.left, level + 1, -1);
				enq(Q, b.node.right, level + 1, 1);
			}
		}
		return res;
	}

	public static Blob deq(LinkedList<Blob> Q) {
		Blob res = null;
		res = Q.removeFirst();
		return res;
	}

	public static void enq(LinkedList<Blob> Q, BTNode n, int lv, int sgn) {
		Blob b = new Blob(n, lv, sgn);
		Q.add(b);
	}

	public BTNode findLeaf() {
		return findLeaf(root);
	}

	public BTNode findLeaf(BTNode here) {
		BTNode res = null;
		if (here != null) {
			// is this what I want?
			if (here.left == null && here.right == null) {
				res = here;
			} else {
				res = findLeaf(here.left);
				if (res == null) {
					res = findLeaf(here.right);
				}
			}
		}
		return res;
	}

	public BTNode findTwo() {
		return findTwo(root);
	}

	public BTNode findTwo(BTNode here) {
		BTNode res = null;
		if (here != null) {
			// is this what I want?
			if (here.left != null && here.right != null) {
				res = here;
			} else {
				res = findTwo(here.left);
				if (res == null) {
					res = findTwo(here.right);
				}
			}
		}
		return res;
	}

	public BTNode findOne() {
		return findOne(root);
	}

	public BTNode findOne(BTNode here) {
		BTNode res = null;
		if (here != null) {
			// is this what I want?
			if (here.left == null ^ here.right == null) {
				res = here;
			} else {
				res = findOne(here.left);
				if (res == null) {
					res = findOne(here.right);
				}
			}
		}
		return res;
	}

	public void delete(BTNode here) {
		Model.debug.println("delete " + here);
		BTNode res = reallyDelete(root, here);
		if (balance > 0) {
			depth(root); // reset the bf's
			P = changed;
			Model.debug.println("delete P changed to " + P);
			inserting = false;
			if (!P.isBalanced()) {
				// save that node as P
				display_mode = State.DO_ROTATION;
			}
		}
		root = res;
		root.parent = null;
	}

	public BTNode reallyDelete(BTNode top, BTNode here) {
		BTNode res = top;
		/*
		 * if has no children or one child
		 */
		Model.debug.println("reallyDelete " + here + " at " + top);
		if (here.left == null) {
			res = setParentLink(top, here, true);
		} else if (here.right == null) {
			res = setParentLink(top, here, false);
		} else {
			/*
			 * the bad case
			 */
			BTNode succ = null;
			/*
			 * if left is deeper, go left
			 */
			if (depth(here.left) >= depth(here.right)) {
				succ = here.left;
				/*
				 * find the successor, largest to the right
				 */
				while (succ.right != null) {
					succ = succ.right;
				}
			} else {
				/*
				 * otherwise, go right
				 */
				succ = here.right;
				/*
				 * find the successor, largest to the right
				 */
				while (succ.left != null) {
					succ = succ.left;
				}
			}
			/*
			 * move its data
			 */
			Model.debug.println("Successor is " + succ);
			int save = succ.data;
			here.x_was = succ.x;
			here.y_was = succ.y;
			here.moving = true;
			Model.debug.println("moving data for " + here);
			res = reallyDelete(top, succ);
			here.data = save;
			display_mode = State.SLIDING;
		}
		return res;
	}

	private static BTNode setParentLink(BTNode top, BTNode here,
			boolean useRight) {
		BTNode res = top;
		BTNode parent = here.parent;
		BTree.changed = parent;
		if (parent == null) {
			if (useRight) {
				res = here.right;
			} else {
				res = here.left;
			}
			res.parent = null;
		} else {
			if (useRight) {
				if (here.data > parent.data) {
					parent.right = here.right;
				} else {
					parent.left = here.right;
				}
				if (here.right != null) {
					here.right.parent = parent;
				}
			} else {
				if (here.data > parent.data) {
					parent.right = here.left;
				} else {
					parent.left = here.left;
				}
				if (here.left != null) {
					here.left.parent = parent;
				}
			}
		}
		return res;
	}

	public void drawTree(Dimension screenSize, Graphics g) {
		int nodeX = screenSize.width / 2;
		int nodeY = 15;
		int dx = nodeX;
		int ht = depth(root);
		if (ht < 3)
			ht = 3;
		int dy = (screenSize.height - 30) / (ht - 1);
		LinkedList<Blob> Q = new LinkedList<Blob>();
		enq(Q, root, 0, 1);
		int level = 0;
		while (!Q.isEmpty()) {
			Blob b = deq(Q);
			if (b.level > level) {
				level = b.level;
				dx /= 2;
			}
			BTNode node = b.node;
			if (node != null) {
				if (node.parent == null) {
					node.x = nodeX;
					node.y = nodeY;
				} else {
					node.x = node.parent.x + dx * b.sign;
					node.y = node.parent.y + dy;
				}
				node.draw(g);
				enq(Q, node.left, level + 1, -1);
				enq(Q, node.right, level + 1, 1);
			}
		}
		drawn = true;
	}
}
