
package SearchTree;

import csm6120_assignment2.State;
import java.util.LinkedList;

/**
 * This class represents a node in the search tree/graph
 * @author stefan
 */
public class TreeNode {
    private State state;
    private LinkedList firstChild;
    private LinkedList nextSibling;
    
    public TreeNode(State s){
        this.state = s; //shallow copy
        this.firstChild = new LinkedList();
        this.nextSibling = new LinkedList();  
    }
    
    public void addChild(State s){
        this.firstChild.add(s);
    }
    
    public void addSibling(State s){
        this.nextSibling.add(s);
    }
}
