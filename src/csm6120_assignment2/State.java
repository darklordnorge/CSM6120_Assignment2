
package csm6120_assignment2;

import java.util.ArrayList;

/**
 * This class has methods and variables to hold an input state.
 * This will be used to hold the start and goal state object.
 * @author stefan
 */
public class State {
    private ArrayList<Integer> state;
    
    /**
     * Constructor for the State object
     * creates an empty arraylist in which the state data will be saved
     */
    public State(){
        this.state = new ArrayList();
    }
    
    /**
     * Method to add an integer to the arraylist 
     * @param toAdd The integer to add 
     */
    public void addState(int toAdd){
        this.state.add(toAdd);
    }
    
    /**
     * Print the arraylist 
     */
    public void printArray(){
       for(int i = 0; i < state.size(); i++){
           System.out.println(state.get(i));
       }
    }
    
    public int return_index(int i){
        return this.state.indexOf(i);
    }
    
}
