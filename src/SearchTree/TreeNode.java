
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
    
    /**
     * Constructor of the TreeNode class.
     * Creates a deep copy of the state which is passed as parameter
     * Initialises the linkedLists. 
     * @param s The State the node referes too
     */
    public TreeNode(State s){
        this.state = new State(s);
        this.firstChild = new LinkedList();
        this.nextSibling = new LinkedList();  
    }
    
    /**
     * Method to add a child to the linkedList
     * @param child 
     */
    public void addChild(TreeNode child){
        this.firstChild.add(child);
    }
    
    /**
     * Method to add a sibling 
     * @param sibling 
     */
    public void addSibling(TreeNode sibling){
        this.nextSibling.addLast(sibling);
    }
    
    public State returnState(){
        return this.state;
    }
}
