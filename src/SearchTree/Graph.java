
package SearchTree;

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
     * This method checks where the empty tile is and calls other 
     * methods to switch the tiles.
     * 
     * @param s The state on which the next step will be based 
     */
    public void nextStep(TreeNode s){
        int emptyTile; //index of the empty tile
        emptyTile = s.returnState().returnIndex(0);
       
        if(emptyTile == 0){
            this.corner(emptyTile, s);
        }
        else if(emptyTile == 1){
            this.midSection(emptyTile, s);
        }
         else if(emptyTile == 2){
            this.corner(emptyTile, s);
        }
         else if(emptyTile == 3){
            this.midSection(emptyTile, s);
        }
         else if(emptyTile == 4){
            this.center(emptyTile, s);
        }
         else if(emptyTile == 5){
            this.midSection(emptyTile, s);
        }
         else if(emptyTile == 6){
            this.corner(emptyTile, s);
        }
         else if(emptyTile == 7){
            this.midSection(emptyTile, s);
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
     * @param tile  The index of the empty tile(0)
     * @param s     The state to base algorithm on
     */
    public void corner(int tile, TreeNode s){
        State tempState1 = new State(s.returnState());
        State tempState2 = new State(s.returnState());
        TreeNode firstChild, secondChild;
        if(tile == 0){
            tempState1.changeTiles(1, 0);
            firstChild = new TreeNode(tempState1);
            
            tempState2.changeTiles(3, 0);
            secondChild = new TreeNode(tempState2);
            
            s.addChild(firstChild);
            firstChild.addSibling(secondChild);
            
        }
        else if(tile == 2){
            tempState1.changeTiles(1, 2);
            firstChild = new TreeNode(tempState1);
            
            tempState2.changeTiles(5, 2);
            secondChild = new TreeNode(tempState2);
            
            s.addChild(firstChild);
            firstChild.addSibling(secondChild);
        }
        else if(tile == 6){
            tempState1.changeTiles(3, 6);
            firstChild = new TreeNode(tempState1);
            
            tempState2.changeTiles(7, 6);
            secondChild = new TreeNode(tempState2);
            
            s.addChild(firstChild);
            firstChild.addSibling(secondChild);
        }
        else if(tile == 8){
             tempState1.changeTiles(5, 8);
            firstChild = new TreeNode(tempState1);
            
            tempState2.changeTiles(7, 8);
            secondChild = new TreeNode(tempState2);
            
            s.addChild(firstChild);
            firstChild.addSibling(secondChild);
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
     * @param tile  The index of the empty tile(0)
     * @param s     The state to base algorithm on 
     */
    public void midSection(int tile, TreeNode s){
        State tempState1 = new State(s.returnState());
        State tempState2 = new State(s.returnState());
        State tempState3 = new State(s.returnState());
        TreeNode child1, child2, child3;
        
        if(tile == 1){
            tempState1.changeTiles(0, tile);
            child1 = new TreeNode(tempState1);
            
            tempState2.changeTiles(2, tile);
            child2 = new TreeNode(tempState2);
            
            tempState3.changeTiles(4, tile);
            child3 = new TreeNode(tempState3);
            
            s.addChild(child1);
            child1.addSibling(child2);
            child2.addSibling(child3);
            
        }
        else if(tile == 3){
           tempState1.changeTiles(0, tile);
            child1 = new TreeNode(tempState1);
            
            tempState2.changeTiles(4, tile);
            child2 = new TreeNode(tempState2);
            
            tempState3.changeTiles(6, tile);
            child3 = new TreeNode(tempState3);
            
            s.addChild(child1);
            child1.addSibling(child2);
            child2.addSibling(child3);
        }
        else if(tile == 5){
            tempState1.changeTiles(2, tile);
            child1 = new TreeNode(tempState1);
            
            tempState2.changeTiles(4, tile);
            child2 = new TreeNode(tempState2);
            
            tempState3.changeTiles(8, tile);
            child3 = new TreeNode(tempState3);
            
            s.addChild(child1);
            child1.addSibling(child2);
            child2.addSibling(child3);
        }
        else if(tile == 7){
            tempState1.changeTiles(4, tile);
            child1 = new TreeNode(tempState1);
            
            tempState2.changeTiles(6, tile);
            child2 = new TreeNode(tempState2);
            
            tempState3.changeTiles(8, tile);
            child3 = new TreeNode(tempState3);
            
            s.addChild(child1);
            child1.addSibling(child2);
            child2.addSibling(child3);
        }
    }
    
    /**
     * This method generates the next level of the graph if the 
     * empty tile(0) is in the center of the puzzle.
     * (Tile 4 in the representation below
     * Saves all possible states to an arrayList.
     * 
     * 0 1 2
     * 3 4 5
     * 6 7 8
     * 
     * @param tile  The index of the empty tile
     * @param s     The state to base algorithm on
     */
    public void center(int tile, TreeNode s){
        State tempState1 = new State(s.returnState());
        State tempState2 = new State(s.returnState());
        State tempState3 = new State(s.returnState());
        State tempState4 = new State(s.returnState());
        TreeNode child1, child2, child3, child4;
        
        tempState1.changeTiles(1, tile);
        child1 = new TreeNode(tempState1);
        
        tempState2.changeTiles(3, tile);
        child2 = new TreeNode(tempState2);
        
        tempState3.changeTiles(5, tile);
        child3 = new TreeNode(tempState3);
        
        tempState4.changeTiles(7, tile);
        child4 = new TreeNode(tempState4);
       
        s.addChild(child1);
        child1.addSibling(child2);
        child2.addSibling(child3);
        child3.addSibling(child4);
    }
}
