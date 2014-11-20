
package search_Algortihms;

import csm6120_assignment2.State;
import java.util.ArrayList;

/**
 * This class is used to generate the next step in the graph. 
 * @author Stefan
 */
public class Graph {
    private ArrayList <State> pos_state;
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
     * tiles in the puzzle. These numbers represent indices in the arrayList
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
            this.corner(emptyTile, s);
        }
        else if(emptyTile == 1){
            s.changeTiles(0, emptyTile);
        }
         else if(emptyTile == 2){
            this.corner(emptyTile, s);
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
            this.corner(emptyTile, s);
        }
         else if(emptyTile == 7){
            s.changeTiles(4, emptyTile);
        }
         else if(emptyTile == 8){
            this.corner(emptyTile, s);
        }
    }
    
    /**
     * This method is used to generate the next level of the graph
     * when the empty tile is at a corner.
     * Saves all changes to a arrayList of possible states.
     * The tiles where this method is used corresponds with the fields 
     * 0, 2, 6 ,and 8 as shown below
     * 
     * 0 1 2
     * 3 4 5
     * 6 7 8
     * 
     * @param tile The index of the empty tile(0)
     * @param s The state to base the process on
     */
    public void corner(int tile, State s){
        State tempState = new State(s);
        if(tile == 0){
            s.changeTiles(1, 0);
            pos_state.add(s);
            
            tempState.changeTiles(3, 0);
            pos_state.add(tempState);
        }
        else if(tile == 2){
            s.changeTiles(1, 2);
            pos_state.add(s);
            
            tempState.changeTiles(5, 2);
            pos_state.add(tempState);
        }
        else if(tile == 6){
            s.changeTiles(3, 6);
            pos_state.add(s);
            
            tempState.changeTiles(7, 6);
            pos_state.add(tempState);
        }
        else if(tile == 8){
            s.changeTiles(5, 8);
            pos_state.add(s);
            
            tempState.changeTiles(7, 8);
            pos_state.add(tempState);
        }
    }
    
    /**
     * This method to generate the next level of the graph
     * when the empty tile(0) is on the midsection of the sides. 
     * Saves all possible states to an arrayList.
     * The tiles where this method will be used correspond to the fields
     * 1, 3, 5, and 7 as shown below
     * 
     * 0 1 2
     * 3 4 5
     * 6 7 8
     * 
     * @param tile
     * @param s 
     */
    public void midSection(int tile, State s){
        State tempState1 = new State(s);
        State tempState2 = new State(s);
        
        if(tile == 1){
            s.changeTiles(0, tile);
            pos_state.add(s);
            
            tempState1.changeTiles(2, tile);
            pos_state.add(tempState1);
            
            tempState2.changeTiles(4, tile);
            pos_state.add(tempState2);
        }
        else if(tile == 3){
            s.changeTiles(0, tile);
            pos_state.add(s);
            
            tempState1.changeTiles(4, tile);
            pos_state.add(tempState1);
            
            tempState2.changeTiles(6, tile);
            pos_state.add(tempState2);
        }
        else if(tile == 5){
            s.changeTiles(2, tile);
            pos_state.add(s);
            
            tempState1.changeTiles(4, tile);
            pos_state.add(tempState1);
            
            tempState2.changeTiles(8, tile);
            pos_state.add(tempState2);
        }
        else if(tile == 7){
            s.changeTiles(4, tile);
            pos_state.add(s);
            
            tempState1.changeTiles(6, tile);
            pos_state.add(tempState1);
            
            tempState2.changeTiles(8, tile);
            pos_state.add(tempState2);
        }
    }
}
