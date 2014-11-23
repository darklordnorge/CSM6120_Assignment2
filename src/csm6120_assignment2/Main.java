/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csm6120_assignment2;
import java.io.File;
import SearchTree.Graph;
import SearchTree.TreeNode;
import search_Algortihms.*;

/**
 *
 * @author stefan
 */
public class Main {

    private static State startState = new State();
    private static State goalState = new State();
    /**
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
  //      System.out.println(startState.returnString());
        
        BFS bfs = new BFS();
        bfs.bfs(startState, goalState);
//        DFS dfs = new DFS();
//        dfs.dfs(startState, goalState);
        
      
//        node.returnState().printArray();
//        node.returnChild().returnState().printArray();
//        System.out.println("Lol WhiteSpace");
//        node.returnChild().returnSibling().returnState().printArray();
    } 
}
