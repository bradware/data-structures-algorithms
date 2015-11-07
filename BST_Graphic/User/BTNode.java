package User;

/*
 * BTNode - driver for BST's
 *
 * A Binary Tree is either null or a BTNode containing some data and two BTNodes
 * named left and right
 *
 * a BST is a Binary Tree in which for every node, all the data in the left
 * sub-tree is before the data at this node, and all the data in the right
 * subtree is after it.
 */
import java.awt.Graphics;

import User.BTree.State;

/**
 * 
 * @author dsmith
 */
public class BTNode {

	/**
	 * integer data value
	 */
	public int data;
	/**
	 * reference to the parent
	 */
	public BTNode parent;
	/**
	 * reference to the before sub-tree
	 */
	public BTNode left;
	/**
	 * reference to the after sub-tree
	 */
	public BTNode right;
	/**
	 * where the node was drawn
	 */
	public int x;
	public int y;
	public int x_was;
	public int y_was;
	public int x_at;
	public int y_at;
	private boolean getNow = false;
	public boolean moving;
	public static boolean diagnose = false;
	/**
	 * node's balance factor
	 */
	public int bf;
	public boolean showIt;

	/**
	 * BTNode constructor
	 * 
	 * @param dat
	 *            - the data value
	 * @param par
	 *            - reference to the parent node
	 */
	public BTNode(int dat, BTNode par) {
		data = dat;
		parent = par;
		left = null;
		right = null;
		showIt = true;
		bf = 0;
		moving = false;
		x = 0;
		y = 0;
		BTree.drawn = false;
	}

	public void saveLocation() {
		if(x == 0) getNow = true;
		x_was = x;
		y_was = y;
		moving = true;
		BTree.index = 0;
		if(left != null) left.saveLocation();
		if(right != null) right.saveLocation();
	}

	private static int dist;
	private static BTNode theNode;

	public BTNode findClosest(int x, int y) {
		dist = distFrom(x, y);
		theNode = this;
		lookAt(this, x, y);
		return theNode;
	}

	public int distFrom(int px, int py) {
		int res = (int) Math.sqrt((x - px) * (x - px) + (y - py) * (y - py));
		return res;
	}

	private static void lookAt(BTNode here, int x, int y) {
		if (here != null) {
			// is this what I want?
			int d = here.distFrom(x, y);
			if (d < dist) {
				dist = d;
				theNode = here;
			}
			lookAt(here.left, x, y);
			lookAt(here.right, x, y);
		}
	}
	
	public static BTNode setParentLink(BTNode root, BTNode here,
			boolean useRight) {
		BTNode res = root;
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

	public boolean isBalanced() {
		boolean res = true;
		if (bf > 1 || bf < -1) {
			res = false;
		}
		return res;
	}

	public void draw(Graphics g) {
/*		if (diagnose) {
			Model.debug.println("draw " + this);
		}
*/		if ((BTree.display_mode == State.SETUP || BTree.display_mode == State.MOVING)
				&& moving && BTree.drawn ) {
			if(getNow) {
				x_was = x;
				y_was = y;
				getNow = false;
			}
			x_at = x_was + (int)((x - x_was) * BTree.index / BTree.TICKS);
			y_at = y_was + (int)((y - y_was) * BTree.index / BTree.TICKS);
		} else {
			x_at = x;
			y_at = y;
		}
		g.fillOval(x_at, y_at, 4, 4);
		if (parent != null) {
			g.drawLine(x_at, y_at, parent.x_at, parent.y_at);
		}
		if (showIt) {
			int l_x, l_y;
			String label = "" + data;
			if (BTree.display_mode == State.SLIDING && moving) {
				l_x = x_was + (int)((x - x_was) * BTree.index / BTree.TICKS);
				l_y = y_was + (int)((y - y_was) * BTree.index / BTree.TICKS);
			} else {
				l_x = x_at;
				l_y = y_at;
			}
			g.drawString(label, l_x + 5, l_y);
		}
	}

	/*
	 * toString for a BTNode @return a string with the data and parent data
	 */

	public String toString() {
		String p = null;
		if (parent != null) {
			p = "" + parent.data;
		}
		String res = " " + data + "(" + p + ")";
		res += "; bf = " + bf;
		return res;
	}

}
