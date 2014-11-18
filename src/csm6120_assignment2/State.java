
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
    
    /**
     * Method to return the index of a specific item in the arraylist
     * 
     * @param i The item to search for
     * @return  The position of the item in the arraylist 
     */
    public int returnIndex(int i){
        return this.state.indexOf(i);
    }
    
    /**
     * Method to exchange to tiles
     * @param i Index of the tile to change
     * @param j Index of the Empty tile to change 
     */
    public void changeTiles(int i, int j){
        int temp, tempIndex, empty, emptyIndex;
        
        temp = this.state.get(i);
        this.state.remove(i);
        this.state.add(i, 0); //move empty tile where i was
        this.state.remove(j);
        this.state.add(j, temp);
        
    }
    
}
