package SearchTree;

import csm6120.State;
import java.util.LinkedList;

/**
 * This class represents a node in the search tree/graph
 *
 * @author stefan
 */
public class TreeNode {

    private State state;
    private LinkedList children;
    private LinkedList siblings;
    private boolean explored;

    /**
     * Constructor of the TreeNode class. Creates a deep copy of the state which
     * is passed as parameter Initialises the linkedLists.
     *
     * @param s     The State the node referes too
     */
    public TreeNode(State s) {
        this.state = new State(s);
        this.children = new LinkedList();
        this.siblings = new LinkedList();
        this.explored = false;
    }
    
    /**
     * Constructor of the TreeNode class. 
     * Creates a deep copy of another TreeNode object.
     * 
     * @param t     The TreeNode object this instance is a copy off
     */
    public TreeNode(TreeNode t) {
        this.state = new State(t.getState());
        this.children = new LinkedList();
        this.siblings = new LinkedList();

        this.children.add(t.children);
        this.siblings.add(t.siblings);
    }

    /**
     * Method to add a child to the linkedList
     *
     * @param child     The TreeNode object to add to the children list 
     */
    public void addChild(TreeNode child) {
        this.children.add(child);
    }

    /**
     * Method to add a sibling to the linkedList of siblings
     *
     * @param sibling   The TreeNode object to add to the siblings list 
     */
    public void addSibling(TreeNode sibling) {
        this.siblings.add(sibling);
    }

    /**
     * Method to return the state of the node object
     *
     * @return the State object of the node
     */
    public State getState() {
        return this.state;
    }

    /**
     * Method to return(poll) and remove the first element of the "Children"
     * linkedList
     *
     * @return The head of the "children" linkedList
     */
    public TreeNode getFirstChild() {
        return (TreeNode) this.children.poll();
    }

    /**
     * Method to return(poll) and remove the first element of the "siblings"
     * linkedList
     *
     * @return The head of the "siblings" linkedList
     */
    public TreeNode getFirstSibling() {
        return (TreeNode) this.siblings.poll();
    }

    /**
     * Method to check if the TreeNode object has siblings. Returns true if the
     * linkedList is empty
     *
     * @return Boolean "True" if the list is empty
     */
    public boolean siblingIsEmpty() {
        return this.siblings.isEmpty();
    }

    /**
     * Method to check if the TreeNode object has children. Returns true if the
     * linkedList is empty
     *
     * @return Boolean "True" if the list is empty
     */
    public boolean childrenIsEmpty() {
        return this.children.isEmpty();
    }

    /**
     * Method to peek(return but not remove) the head of the "children"
     * linkedList
     *
     * @return The head of the "children" LinkedList
     */
    public TreeNode peekChild() {
        return (TreeNode) this.children.peek();
    }

    /**
     * Method to remove the head of the children linkedList
     */
    public void removeFirstChild() {
        children.pop();
    }

    /**
     * Method to set the "explored" variable of the object
     *
     * @param b The boolean value to set
     */
    public void setExplored(boolean b) {
        this.explored = b;
    }

    /**
     * Method to get the "explored" variable of the object
     *
     * @return The boolean value of "explored"
     */
    public boolean getExplored() {
        return explored;
    }
    
    /**
     * Method to return the size of the "children" linkedList
     * 
     * @return  The size of the List
     */
    public int getNumOfChildren(){
        return this.children.size();
    }
}
