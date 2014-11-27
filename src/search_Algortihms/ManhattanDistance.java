
package search_Algortihms;

import csm6120_assignment2.State;
import java.util.ArrayList;

/**
 * This class is used to calculate the Manhattan distance for the A* algorithm
 * 
 * @author Stefan
 */
public class ManhattanDistance {
    private int[][] startArray;
    private int[][] goalArray;
    
    /**
     * Constructor of the ManhattanDistance class
     * 
     * @param start The State to compare to the goal
     * @param goal  The goal State to compare too 
     */
    public ManhattanDistance(State start, State goal){
        this.startArray = new int [start.getList().size()]
                [start.getList().size()];
        this.goalArray = new int[goal.getList().size()]
                [goal.getList().size()];
        
        this.setStartArray(this.convertTo2DArray(this.convertToArray
            (start.getList())));
        this.setGoalArray(this.convertTo2DArray(this.convertToArray
            (goal.getList())));
    }
    
    /**
     * Method to convert an 1D integer array to a 
     * 2D integer array
     * 
     * @param intArray  The integer array to convert
     * @return          An 2D integer array
     */
    public int[][] convertTo2DArray(int[] intArray){
        int[][] array = new int[3][3]; 
        int counter = 0;
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                array[i][j] = intArray[counter];
                counter++;
            }
        }
        return array;
    }
       
    /**
     * Method to convert an ArrayList to an array
     * 
     * @param i The arrayList to convert
     * @return  An integer array 
     */
    public int[] convertToArray(ArrayList<Integer> i){
        int [] array = new int[i.size()];
        for(int j = 0;j<array.length;j++){
            array[j] = i.get(j).intValue();
        }
        return array;
    }
    
    /**
     * Method to set the startArray
     * 
     * @param toSet 2D array to set too 
     */
    public void setStartArray(int[][] toSet){
        this.startArray = toSet;
    }
    
    /**
     * Method to set the goalArray
     * 
     * @param toSet 2D array to set too
     */
    public void setGoalArray(int[][] toSet){
        this.goalArray = toSet;
    }
    
    public int calcManhattanDistance(){
        int totalDistance = 0;
        for(int i = 0;i < 3;i++){
            for(int j = 0;j < 3;j++){
                int x_start = startArray[i][j];
                int x_goal = goalArray[i][j];
                int y_start = startArray[i][j];
                int y_goal = goalArray[i][j];
                
                totalDistance += Math.abs(startArray[i][j] - goalArray[i][j]);
                
//                if(startArray[i][j] == goalArray[i][j]){
//                    continue;
//                }
//                else{
//                    totalDistance += Math.abs(x_start - x_goal) + 
//                            Math.abs(y_start - y_goal);
//                }
            }
        }
        
        return totalDistance;
    }
}
