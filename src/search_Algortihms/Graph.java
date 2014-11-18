
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
     * tiles in the puzzle. These numbers represent indices in the arraylist
     * and are :
     * 0 1 2
     * 3 4 5
     * 6 7 8
     * This method will always choose the next smallest index to switch with
     * @param s The state on which the next step will be based 
     */
    public void nextStep(State s){
        int emptyTile; //index of the empty tile
        emptyTile = s.returnIndex(0);
       
        if(emptyTile == 0){
            s.changeTiles(1, emptyTile);
        }
        else if(emptyTile == 1){
            s.changeTiles(0, emptyTile);
        }
         else if(emptyTile == 2){
            s.changeTiles(1, emptyTile);
        }
         else if(emptyTile == 3){
            s.changeTiles(0, emptyTile);
        }
         else if(emptyTile == 4){
            s.changeTiles(1, emptyTile);
        }
         else if(emptyTile == 5){
            s.changeTiles(2, emptyTile);
        }
         else if(emptyTile == 6){
            s.changeTiles(3, emptyTile);
        }
         else if(emptyTile == 7){
            s.changeTiles(4, emptyTile);
        }
         else if(emptyTile == 8){
            s.changeTiles(5, emptyTile);
        }
    }
    
    /**
     * This method generates the next level of the graph
     * 
     * @param s The state to base the generation on
     */
    public void nextLevel(State s){
        
    }
}
