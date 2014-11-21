
package SearchTree;

import csm6120_assignment2.State;
import java.util.LinkedList;

/**
 * This class represents a node in the search tree/graph
 * @author stefan
 */
public class TreeNode {
    private State state;
    private LinkedList children;
    private LinkedList siblings;
    
    /**
     * Constructor of the TreeNode class.
     * Creates a deep copy of the state which is passed as parameter
     * Initialises the linkedLists. 
     * @param s The State the node referes too
     */
    public TreeNode(State s){
        this.state = new State(s);
        this.children = new LinkedList();
        this.siblings = new LinkedList();  
    }
    
    public TreeNode(TreeNode t){
        this.state = new State(t.returnState());
        this.children = new LinkedList();
        this.siblings = new LinkedList();  
        
        this.children.add(t.children);
        this.siblings.add(t.siblings);
    }
    
    /**
     * Method to add a child to the linkedList
     * @param chield 
     */
    public void addChield(TreeNode chield){
        this.children.add(chield);
    }
    
    /**
     * Method to add a sibling 
     * @param sibling 
     */
    public void addSibling(TreeNode sibling){
        this.siblings.add(sibling);
    }
    
    public State returnState(){
        return this.state;
    }
    
    public TreeNode returnChild(){
        return (TreeNode) this.children.poll();
    }
    
    public TreeNode returnSibling(){
        return (TreeNode) this.siblings.poll();
    }
    
    public boolean hasSibling(){
        return this.siblings.isEmpty();
    }
    
    public boolean hasChildren(){
        return this.children.isEmpty();
    }
}
