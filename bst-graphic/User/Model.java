/**
 * A class providing the storage for a BST
 */
package User;

import System.MyPanel;
import User.BTree.State;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import java.io.*;

/**
 * an essentially static class containing the model
 */
public class Model {

	/*
	 * MODEL section
	 */
	/** Title of the main window **/
	public static String title = "BST Visualization";
	/** Labels on the custom buttons **/
	public static String Labels[] = { "Reset", "Add", "Delete" };
	// typedefs for buttons
	private static final int RESET = 0;
	public static final int ADD = 1;
	public static final int DELETE = 2;
	public static String Buttons[] = { "BST", "AVL", "Splay" };
	/** time tick */
	public static double DT = 0.03333;
	public static ButtonGroup butGroup = null;
	/** screen size */
	public static Dimension screenSize;
	/** repainting the screen */
	public static boolean doRepaint;
	/** enable the mouse */
	public static boolean mouseEnabled = false;
	/** painting the screen to protect the data while painting */
	private static boolean painting;
	/** the host panel */
	public static MyPanel myPanel;
	/** diagnostic print stream */
	public static PrintStream debug;
	/** diagnostic print stream */
	public static PrintStream out;
	/** buffered input stream */
	public static BufferedReader input = null;
	/** diagnostic print stream enabler */
	public static boolean initialized = false;
	/**
	 * display initialized? set by first call to dopaint()
	 */
	public static boolean doDbg = true;
	public static int t;
	// private boolean pressed = false;
	private BTree theTree = null;

	/**
	 * Model Application specific data storage
	 */
	boolean doDelete = false;
	private int numEntries = 1;

	/**
	 * basic constructor
	 * 
	 * @param d
	 *            screen size
	 */
	public Model(Dimension d) {
		screenSize = d;
		initialized = false;
		reset(numEntries);
	}

	/**
	 * initialize Global data System reset called at startup
	 * 
	 * @param isStandalone
	 *            - true if running alone, false if an applet that can't write
	 *            to files
	 */
	public static void init(boolean isStandalone) {
		if (isStandalone) {
			try {
				debug = new PrintStream(new FileOutputStream("debug.log"));
			} catch (IOException e) {
				System.out.print("Error " + e + " opening debug.log");
			}
			debug.println("debug log opened");
			doDbg = true; // initial debug setting
		} else {
			doDbg = false;
		}
	}

	/**
	 * Model reset called by the user
	 */
	private void reset(int N) {
		DT = 0.033333333;
		doRepaint = false;
		painting = false;
		if (doDbg) {
			debug.println("System reset\n");
		}
		/*
		 * model specific initialization
		 */
		theTree = new BTree(numEntries);
	}

	/**
	 * hit here each clock tick
	 */
	public void doTick() {
		t++;
		// get the buttons
		if (butGroup != null) {
			int it = butGroup.getSelection().getMnemonic();
			/*
			 * do something with it
			 */
			int newBal = it - 48;
			if (BTree.balance != newBal) {
				BTree.balance = newBal;
				// BTNode.drawn = false;
				theTree.buildTree(numEntries);
			}
		}
		theTree.update();
		if (!painting) {
			doRepaint = true;
		}
	}

	/*
	 * VIEW section
	 */
	private static Font myFont;

	private void initializeDisplay(Graphics g, Dimension d) {
		initialized = true;
		myFont = new Font("San Serif", Font.BOLD, 14);
	}

	/**
	 * paint the screen
	 * 
	 * @param g
	 *            the graphic environment
	 * @param d
	 *            the screen size
	 */
	public void doPaint(Graphics g, Dimension d) {

		if (!initialized) {
			initializeDisplay(g, d);
		}
		screenSize = d;
		painting = true;
		g.setFont(myFont);
		// Do all drawing here
		theTree.drawTree(screenSize, g);
/*		if(BTree.display_mode != State.CHECK_QUEUE){ 
			debug.println("Drew the tree; BTree.display_mode is " + BTree.display_mode);
		}
*/		if (BTree.display_mode == State.SETUP) {
			BTree.display_mode = State.MOVING;
		}
		painting = false;
	}

	/*
	 * CONTROL section
	 */
	/**
	 * respond to custom button press
	 * 
	 * @param code
	 *            the number of the button pressed (0 ... (Labels.length-1) )
	 */
	public void doButton(int code) {
		int value = -1;
		String str = null;
		switch (code) {
		case RESET:
			str = JOptionPane.showInputDialog("How many nodes? ");
			if (str != null) {
				numEntries = Integer.parseInt(str);
			}
			reset(numEntries);
			break;
		case ADD:
			str = JOptionPane.showInputDialog("Enter Numbers: ");
			if (str != null) {
				String tks[] = str.split(",| ");
				for (int i = 0; i < tks.length; i++) {
					if (tks[i].length() > 0) {
						try {
						value = Integer.parseInt(tks[i]);
						theTree.insert(value);
						} catch(Exception e) {};
					}
				}
			}
			break;
		case DELETE:
			doDelete = true;
			break;
		}
	}

	/**
	 * Mouse clicked
	 * 
	 * @param e
	 */
	public void clicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		BTNode it = theTree.findClosest(x, y);
		if (doDelete) {
			theTree.delete(it);
			doDelete = false;
		} else {
			it.showIt = !it.showIt;
		}
	}
	
	public static void repaint() {
		myPanel.repaint();
	}

	/**
	 * Mouse entered
	 * 
	 * @param e
	 */
	public void entered(MouseEvent e) {
		// System.out.println("Mouse Entered");
	}

	/**
	 * Mouse exited
	 * 
	 * @param e
	 */
	public void exited(MouseEvent e) {
		// System.out.println("Mouse Exited");
	}

	/**
	 * Mouse released
	 * 
	 * @param e
	 */
	public void released(MouseEvent e) {
		System.out.println("Mouse Released");
		// pressed = false;
	}

	/**
	 * Mouse pressed
	 * 
	 * @param e
	 */
	public void pressed(MouseEvent e) {
		System.out.println("Mouse Pressed");
		// pressed = true;
	}

	/**
	 * Mouse dragged
	 * 
	 * @param e
	 */
	public void dragged(MouseEvent e) {
		System.out.println("Mouse Dragged");
	}

	/**
	 * Mouse moved
	 * 
	 * @param e
	 */
	public void moved(MouseEvent e) {
		// System.out.println("Mouse Moved");
	}
}
