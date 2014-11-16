
package csm6120_assignment2;

import java.util.ArrayList;

/**
 *
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
    
    public void printArray(){
       for(int i = 0; i < state.size(); i++){
           System.out.println(state.get(i));
       }
    }
    
}
