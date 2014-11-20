/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csm6120_assignment2;
import java.io.File;
import SearchTree.Graph;

/**
 *
 * @author stefan
 */
public class Main {

    private static State startState = new State();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String path = args[0];
        File file = new File(path);
        FileManager r = new FileManager();
        Graph g = new Graph();
        r.reader(startState, file);
        startState.printArray();
        System.out.println("Now switch:");
        g.nextStep(startState);
        startState.printArray();
    } 
}
