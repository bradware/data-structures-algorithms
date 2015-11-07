/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package User;
/**
 *
 * @author dsmith
 */
public class Blob {
    public BTNode node;
    public int level;
    public int sign;
    
    public Blob(BTNode n, int lv, int sgn) {
        node = n;
        level = lv;
        sign = sgn;
    }
    
    public String toString() {
        return "{" + node.data + ", " + level + "}";
    }
}
