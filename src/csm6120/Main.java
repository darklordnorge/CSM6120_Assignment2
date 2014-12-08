package csm6120;

import SearchAlgortihms.DFS;
import SearchAlgortihms.GBFS;
import SearchAlgortihms.AStar;
import SearchAlgortihms.BFS;
import java.io.File;
import SearchTree.Graph;

/**
 * This class is the entrance to the program.
 *
 * @author stefan
 */
public class Main {

    private static State startState = new State();
    private static State goalState = new State();

    /**
     * Main method of the program. This method can be called from the command
     * line with a set of arguments.
     *
     * javac main theStartFile theGoalFile theAlgorithmToUse
     *
     * where theStartFile is a text file holding the start State, theGoalFile
     * holds the goal State of the puzzle. TheAlgorithmToUse specifies which
     * algorithm, possibilities are:
     *
     * bfs - Breadth-First search dfs - Depth-First search gbfs - Greedy
     * Best-First search astar - A* search
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String sPath = args[0];
        String gPath = args[1];
        String algorithm = args[2];
        File sFile = new File(sPath);
        File gFile = new File(gPath);
        /*
         Create a FileManager instance and read the input files
         */
        FileManager r = new FileManager();
        r.reader(startState, sFile);
        r.reader(goalState, gFile);

        if (algorithm.equals("bfs")) {
            BFS bfs = new BFS();
            bfs.bfs(startState, goalState);
        } else if (algorithm.equals("dfs")) {
            DFS dfs = new DFS();
            dfs.dfs(startState, goalState);
        } else if (algorithm.equals("gbfs")) {
            GBFS gbfs = new GBFS();
            gbfs.gbfs(startState, goalState);
        } else if (algorithm.equals("astar")) {
            AStar astar = new AStar();
            astar.astar(startState, goalState);
        } else {
            System.out.println("Not a legal argument");
            System.out.println("bfs   - Breadth-First search");
            System.out.println("dfs   - Depth-First search");
            System.out.println("gbfs  - Greedy Best-First search");
            System.out.println("astar - A star search");
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        long timeInSec = Math.abs(totalTime/1000000000);
        System.out.println("Total Time: " + totalTime + " nanoseconds");
    }
}
