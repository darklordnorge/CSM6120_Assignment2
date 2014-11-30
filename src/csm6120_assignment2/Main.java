
package csm6120_assignment2;

import java.io.File;
import SearchTree.Graph;
import SearchTree.TreeNode;
import search_Algortihms.*;

/**
 * This class is the entrance to the program. 
 * 
 * @author stefan
 */
public class Main {

    private static State startState = new State();
    private static State goalState = new State();

    /**
     * Main method of the program. 
     * This method can be called from the command line with a set of 
     * arguments. 
     * 
     * javac main theStartFile theGoalFile theAlgorithmToUse
     * 
     * where theStartFile is a text file holding the start State,
     * theGoalFile holds the goal State of the puzzle. 
     * TheAlgorithmToUse specifies which algorithm, possibilities are:
     * 
     * bfs - Breadth-First search
     * dfs - Depth-First search
     * gbfs - Greedy Best-First search 
     * astar - A* search
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String sPath = args[0];
        String gPath = args[1];
        File sFile = new File(sPath);
        File gFile = new File(gPath);
        FileManager r = new FileManager();
        Graph g = new Graph();
        r.reader(startState, sFile);
        r.reader(goalState, gFile);
    
        
//        ManhattanDistance md = new ManhattanDistance(startState, goalState);
      
        //      System.out.println(startState.getStringtoString());

        //        BFS bfs = new BFS();
        //        bfs.bfs(startState, goalState);
        //        DFS dfs = new DFS();
        //        dfs.dfs(startState, goalState);
        //          GBFS gbfs = new GBFS();
        //          gbfs.gbfs(startState, goalState);
        AStar astar = new AStar();
        astar.astar(startState, goalState);
    }
}
