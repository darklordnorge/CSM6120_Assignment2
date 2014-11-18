
package search_Algortihms;

import csm6120_assignment2.State;
import java.util.ArrayList;

/**
 * This class is used to generate the next step in the graph. 
 * @author Stefan
 */
public class Graph {
    private ArrayList <Integer> pos_state;
    /**
     * Constructor for the graph object 
     */
    public Graph(){
        this.pos_state = new ArrayList();
    }
    
    /**
     * Algorithm to generate the next state in the graph
     * Based on the fact that empty space can only move 
     * horizontally and vertically.
     * To make the process easier simple numbers identifiers 
     * are assigned to the possible
     * tiles in the puzzle. These numbers are :
     * 0 1 2
     * 3 4 5
     * 6 7 8
     * 
     * @param s The state on which the next step will be based 
     */
    public void nextStep(State s){
        int emptyTile; //place of the empty tile
        emptyTile = s.returnIndex(0);
       
        if(emptyTile == 2){
            s.changeTiles(1, emptyTile);
            s.printArray();
        }
    }
}
