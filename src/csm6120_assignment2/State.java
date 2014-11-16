
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
        state = new ArrayList<Integer>();
    }
    
    public void addState(int toAdd){
        state.add(toAdd);
    }
    
    /**
     * Print the arraylist 
     */
    public void printArray(){
       for(int i = 0; i < state.size(); i++){
           System.out.println(state.get(i));
       }
    }
    
}
